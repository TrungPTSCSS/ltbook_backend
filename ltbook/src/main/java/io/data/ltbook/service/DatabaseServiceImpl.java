package io.data.ltbook.service;

import io.data.ltbook.domain.Blog;
import io.data.ltbook.domain.Book;
import io.data.ltbook.repo.BlogRepo;
import io.data.ltbook.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DatabaseServiceImpl implements DatabaseService {
    private final BlogRepo blogRepo;
    private final BookRepo bookRepo;

    //create
    @Override
    public Blog initBlog(Blog blog) {
        log.info("init Blog to Database",blog);
        return blogRepo.save(blog);
    }
    @Override
    public Book initBook(Book book) {
        log.info("init book to Database",book);
        return bookRepo.save(book);
    }
    //GetByQuery
    @Override
    public List<Blog> getAllBlog() {
        return blogRepo.findAll();
    }
    @Override
    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }
    //GetById
    @Override
    public Optional<Blog> getBlogDetails(Long id) {
        return blogRepo.findById(id);
    }
    @Override
    public List<Blog> findBlogByTitle(String title) {
        return blogRepo.findByTitle(title);
    }

    //delete
    @Override
    public boolean checkBlog(Long id) {
        return blogRepo.existsById(id);
    }
    @Override
    public void deleteBlog(Long id) {
        blogRepo.deleteById(id);
    }
    @Override
    public boolean checkBook(Long id) {
        return bookRepo.existsById(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }


    @Override
    public Optional<Book> getBookDetails(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public List<Book> findByType(String type) {
        return bookRepo.findByType(type);
    }


}
