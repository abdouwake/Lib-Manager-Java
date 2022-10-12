package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.Book;
import com.cgi.library.lib.manager.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean deleteBook(Integer idBook) {
        bookRepository.deleteById(idBook);
        return true;
    }

    @Override
    public Optional<Book> findById(Integer idBook) {
        return bookRepository.findById(idBook);
    }

    @Override
    public boolean existsById(Integer idBook) {
        return bookRepository.existsById(idBook);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
