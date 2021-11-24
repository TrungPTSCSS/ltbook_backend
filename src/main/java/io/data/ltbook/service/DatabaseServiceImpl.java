package io.data.ltbook.service;

import io.data.ltbook.domain.Bill;
import io.data.ltbook.domain.Blog;
import io.data.ltbook.domain.Book;
import io.data.ltbook.domain.ProductCart;
import io.data.ltbook.repo.BillRepo;
import io.data.ltbook.repo.BlogRepo;
import io.data.ltbook.repo.BookRepo;
import io.data.ltbook.repo.ProductCartRepo;
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
    private final ProductCartRepo productCartRepo;
    private final BillRepo billRepo;

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

    @Override
    public ProductCart initProductCart(ProductCart productCart) {
        return productCartRepo.save(productCart);
    }

    @Override
    public Bill initBill(Bill bill) {
        return billRepo.save(bill);
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

    @Override
    public List<ProductCart> getAllProductCart() {
        return productCartRepo.findAll();
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepo.findAll();
    }

    //GetById
    @Override
    public Optional<Blog> getBlogDetails(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public Optional<Book> getBookDetails(Long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Optional<ProductCart> getProductCart(Long id) {
        return productCartRepo.findById(id);
    }

    @Override
    public Optional<Bill> getBillById(Long id) {
        return billRepo.findById(id);
    }

    //GetByType
    @Override
    public List<Blog> findBlogByTitle(String title) {
        return blogRepo.findByTitle(title);
    }
    @Override
    public List<Book> findByType(String type) {
        return bookRepo.findByType(type);
    }
    @Override
    public List<ProductCart> findByCartCode(String code) {
        return productCartRepo.findByCodeCart(code);
    }

    @Override
    public List<Bill> findByIdUser(Long idUser) {
        return billRepo.findByIdUser(idUser);
    }

//    @Override
//    public List<Bill> findCodeCartInBill(String code) {
//        return billRepo.fi(code);
//    }


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
    public boolean checkProductCart(Long id) {
        return productCartRepo.existsById(id);
    }

    @Override
    public void deleteProductCart(Long id) {
        productCartRepo.deleteById(id);
    }

    @Override
    public boolean checkBill(Long id) {
        return billRepo.existsById(id);
    }

    @Override
    public void deleteBill(Long id) {
        billRepo.deleteById(id);
    }


}
