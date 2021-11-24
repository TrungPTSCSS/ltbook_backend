package io.data.ltbook.api;


import io.data.ltbook.domain.Blog;
import io.data.ltbook.domain.ResponseObject;
import io.data.ltbook.repo.BlogRepo;
import io.data.ltbook.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
@Slf4j
public class BlogResource {
    private final DatabaseService databaseService;


    @GetMapping("/GetByQuery")
    public List<Blog> getAllBlog(){
        return databaseService.getAllBlog();
    }

    @GetMapping("/GetById")
    @ResponseBody
    ResponseEntity<ResponseObject> findById(@RequestParam Long id){
        Optional<Blog> foundBlog = databaseService.getBlogDetails(id);
        return foundBlog.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query blog successfully", foundBlog)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find blog with id =" + id, "")
                );
    }
    @PostMapping("/Create")
    ResponseEntity<ResponseObject> insertBlog(@RequestBody Blog newBlog){
        List<Blog> foundBlog = databaseService.findBlogByTitle(newBlog.getTitle().trim());
        if(foundBlog.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail", "Blog name already exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new blog successfully", databaseService.initBlog(newBlog))
        );
    }
    @PutMapping("/Update")
    @ResponseBody
    ResponseEntity<ResponseObject> updateBlog(@RequestBody Blog newBlog, @RequestParam Long id){
        Blog updatedBlog = databaseService.getBlogDetails(id).map(blog -> {
            blog.setTitle(newBlog.getTitle());
            blog.setContent(newBlog.getContent());
            blog.setTags(newBlog.getTags());
            blog.setStatus(newBlog.getStatus());
            blog.setCreateBy(newBlog.getCreateBy());
            blog.setCreateAt(newBlog.getCreateAt());
            blog.setUpdateBy(newBlog.getUpdateBy());
            blog.setUpdateAt(newBlog.getUpdateAt());
            return databaseService.initBlog(blog);
        }).orElseGet(() -> {
            newBlog.setId(id);
            return databaseService.initBlog(newBlog);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update blog successfully", updatedBlog)
        );
    }

    @DeleteMapping("/Delete")
    @ResponseBody
    ResponseEntity<ResponseObject> deleteBlog(@RequestParam Long id){
        boolean existId = databaseService.checkBlog(id);
        if(existId){
            databaseService.deleteBlog(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete blog successfully", "")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "can't find blog to delete", "")
            );
        }
    }
}
