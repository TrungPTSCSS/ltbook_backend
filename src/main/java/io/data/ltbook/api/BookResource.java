package io.data.ltbook.api;


import io.data.ltbook.domain.Book;
import io.data.ltbook.domain.ResponseObject;
import io.data.ltbook.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookResource {
    private final DatabaseService databaseService;

    @GetMapping("/GetByQuery")
    public List<Book> getAllBook(){
        return databaseService.getAllBook();
    }

    @GetMapping("/GetById")
    @ResponseBody
    ResponseEntity<ResponseObject> findById(@RequestParam Long id){
        Optional<Book> foundBook = databaseService.getBookDetails(id);

        return foundBook.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query book successfully", foundBook)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find book with id =" + id, "")
                );
    }

    @PostMapping("/GetByType")
    ResponseEntity<ResponseObject> fieldByType(@RequestBody Book book){
        List<Book> foundBook = databaseService.findByType(book.getType().trim());
        return foundBook.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("success", "query book successfully", foundBook)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "can't find book follow type", "")
                );
    }

    @PostMapping("/Create")
    ResponseEntity<ResponseObject> insertBook(@RequestBody Book newBook){
//        List<Book> foundBook = repository.findByName(newBook.getName().trim());
//        if(foundBook.size() > 0){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//                    new ResponseObject("fail", "Book name already exist", "")
//            );
//        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "create new book successfully", databaseService.initBook(newBook))
        );
    }


    @PutMapping("/Update")
    @ResponseBody
    ResponseEntity<ResponseObject> updateBook(@RequestBody Book newBook, @PathVariable Long id){
        Book updatedBook = databaseService.getBookDetails(id).map(book -> {
            book.setName(newBook.getName());
            book.setPrice(newBook.getPrice());
            book.setRating(newBook.getRating());
            book.setDescription(newBook.getDescription());
            book.setArtistAvatar(newBook.getArtistAvatar());
            book.setArtistName(newBook.getArtistName());
            book.setArtistBornDay(newBook.getArtistBornDay());
            book.setType(newBook.getType());
            book.setStatus(newBook.getStatus());
            book.setCreateBy(newBook.getCreateBy());
            book.setCreateAt(newBook.getCreateAt());
            book.setUpdateBy(newBook.getUpdateBy());
            book.setUpdateAt(newBook.getUpdateAt());
            return databaseService.initBook(book);
        }).orElseGet(() -> {
            newBook.setId(id);
            return databaseService.initBook(newBook);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("success", "update book successfully", updatedBook)
        );
    }

    @DeleteMapping("/Delete")
    @ResponseBody
    ResponseEntity<ResponseObject> deleteBook(@PathVariable Long id){
        boolean existId = databaseService.checkBook(id);
        if(existId){
            databaseService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("success", "delete book successfully", "")
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("fail", "can't find book to delete", "")
            );
        }
    }
}
