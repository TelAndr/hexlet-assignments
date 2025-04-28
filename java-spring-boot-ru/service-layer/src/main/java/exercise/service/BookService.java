package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
	@Autowired
	private BookRepository repository;

	@Autowired
	private BookMapper mapper;

	//@Autowired
	//private BookUtils bookUtils;

	public List<BookDTO> getAllBooks() {
		var books = repository.findAll();
		var result = books.stream()
				.map(mapper::map)
				.toList();
		return result;
	}

	public BookDTO createBook(BookCreateDTO bookData) {
		var book = mapper.map(bookData);
		//book.setBook(userUtils.getCurrentUser());
		repository.save(book);
		var bookDTO = mapper.map(book);
		return bookDTO;
	}

	public BookDTO findByid(Long id) {
		var book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This book is not found"));
		var bookDTO = mapper.map(book);
		return bookDTO;
	}

	public BookDTO updateBook(BookUpdateDTO bookData, Long id) {
		var book = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This book is not found"));
		mapper.update(bookData, book);
		repository.save(book);
		var bookDTO = mapper.map(book);
		return bookDTO;
	}

	public void deleteBook(Long id) {
		repository.deleteById(id);
	}
    // END
}
