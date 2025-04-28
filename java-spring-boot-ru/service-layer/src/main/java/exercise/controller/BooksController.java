package exercise.controller;

import java.util.List;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> index() {
        //var books = bookRepository.findAll();
        //var result = books.stream()
        //        .map(bookMapper::map)
        //        .toList();
        //return result;
		return bookService.getAllBooks();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookCreateDTO bookData) {
        //var book = bookMapper.map(bookData);
        //bookRepository.save(book);
        //var bookDTO = bookMapper.map(book);
        //return bookDTO;
		return bookService.createBook(bookData);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO show(@PathVariable long id) {
        //var book = bookRepository.findById(id)
        //        .orElseThrow(() -> new ResourceNotFoundException("Book is Not found"));
        //var bookDTO = bookMapper.map(book);
        //return bookDTO;
		return bookService.findByid(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO update(@RequestBody BookUpdateDTO bookData, @PathVariable long id) {
        //var book = bookRepository.findById(id)
        //        .orElseThrow(() -> new ResourceNotFoundException("Book is Not found"));
        //bookMapper.update(bookData, book);
        //bookRepository.save(book);
        //var bookDTO = bookMapper.map(book);
        //return bookDTO;
		return bookService.updateBook(bookData, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        //bookRepository.deleteById(id);
		bookService.deleteBook(id);
    }
    // END
}
