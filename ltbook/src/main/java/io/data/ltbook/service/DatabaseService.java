package io.data.ltbook.service;

import io.data.ltbook.domain.Bill;
import io.data.ltbook.domain.Blog;
import io.data.ltbook.domain.Book;
import io.data.ltbook.domain.ProductCart;

import java.util.List;
import java.util.Optional;

public interface DatabaseService {
    Blog initBlog(Blog blog);
    Book initBook(Book book);
    ProductCart initProductCart(ProductCart productCart);
    Bill initBill(Bill bill);

    List<Blog> getAllBlog();
    List<Book> getAllBook();
    List<ProductCart> getAllProductCart();
    List<Bill> getAllBill();

    Optional<Blog> getBlogDetails(Long id);
    Optional<Book> getBookDetails(Long id);
    Optional<ProductCart> getProductCart(Long id);
    Optional<Bill> getBillById(Long id);



    List<Blog> findBlogByTitle(String title);
    List<Book> findByType(String type);
    List<ProductCart> findByCartCode(String code);
    List<Bill> findByIdUser(Long idUser);
//    List<Bill> findCodeCartInBill(String code);


    boolean checkBlog(Long id);
    void deleteBlog(Long id);
    boolean checkBook(Long id);
    void deleteBook(Long id);
    boolean checkProductCart(Long id);
    void deleteProductCart(Long id);
    boolean checkBill(Long id);
    void deleteBill(Long id);
}
