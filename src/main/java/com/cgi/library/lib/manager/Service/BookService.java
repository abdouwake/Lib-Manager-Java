package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAllBooks();
    public boolean deleteBook(Integer idBook);
    public boolean existsById(Integer idBook);

    public Optional<Book> findById(Integer idBook);
    public Book addBook(Book book);
    public Book updateBook(Book book);

}
