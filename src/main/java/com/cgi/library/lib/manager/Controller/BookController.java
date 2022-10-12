package com.cgi.library.lib.manager.Controller;

import com.cgi.library.lib.manager.Model.Book;
import com.cgi.library.lib.manager.ResponseEntity.ResponseHandler;
import com.cgi.library.lib.manager.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/All")
    public ResponseEntity<Object> getAllStudents(){
        List<Book> result =  bookService.getAllBooks();
        return ResponseHandler.generateResponse("Le livre a été ajouté avec succès", HttpStatus.OK,result);
    }

    @GetMapping("/findById/{idBook}")
    public ResponseEntity<Object> getAllBooks(@PathVariable Integer idBook){
        if(bookService.existsById(idBook)){
            Optional<Book> result = bookService.findById(idBook);
            return ResponseHandler.generateResponse("success.", HttpStatus.OK,result);
        }else {
            return ResponseHandler.generateResponse("Ce livre est introuvable", HttpStatus.NOT_FOUND,null);
        }
    }

    @DeleteMapping("{idBook}")
    public ResponseEntity<Object> deleteBook(@PathVariable Integer idBook) throws Exception{
        if(bookService.existsById(idBook)){
            boolean result = bookService.deleteBook(idBook);
            return ResponseHandler.generateResponse("Le livre a été supprimé avec succès.", HttpStatus.OK,result);
        }else{
            return ResponseHandler.generateResponse("Ce livre est introuvable", HttpStatus.NOT_FOUND,null);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateBook(@RequestBody Book book) throws Exception{
        if(bookService.existsById(book.getIsbn())){
            Optional<Book> result = Optional.ofNullable(bookService.updateBook(book));
            return ResponseHandler.generateResponse("Le livre a été mis à jour.", HttpStatus.OK,result);
        }else {
            return ResponseHandler.generateResponse("Ce livre est introuvable", HttpStatus.NOT_FOUND,null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addBook(@RequestBody Book book) throws Exception{
        if(bookService.existsById(book.getIsbn())){
            return ResponseHandler.generateResponse("Ce livre existe déjà dans la bibliothèque.", HttpStatus.CONFLICT,null);
        }else {
            bookService.addBook(book);
            return ResponseHandler.generateResponse("Le livre a été ajouté avec succès.", HttpStatus.CONFLICT,null);
        }
    }


}
