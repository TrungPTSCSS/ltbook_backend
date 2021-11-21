package io.data.ltbook.service;

import io.data.ltbook.domain.Blog;
import io.data.ltbook.domain.Book;

import java.util.List;
import java.util.Optional;

public interface DatabaseService {
    Blog initBlog(Blog blog);
    Book initBook(Book book);

    List<Blog> getAllBlog();
    List<Book> getAllBook();

    Optional<Blog> getBlogDetails(Long id);
    Optional<Book> getBookDetails(Long id);

    List<Blog> findBlogByTitle(String title);
    List<Book> findByType(String type);

    boolean checkBlog(Long id);
    void deleteBlog(Long id);
    boolean checkBook(Long id);
    void deleteBook(Long id);
}
