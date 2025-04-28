package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
	@Autowired
	private AuthorRepository repository;

	@Autowired
	private AuthorMapper mapper;

	//@Autowired
	//private AuthorUtils authorUtils;

	public List<AuthorDTO> getAllAutors() {
		var authors = repository.findAll();
		var result = authors.stream()
				.map(mapper::map)
				.toList();
		return result;
	}

	public AuthorDTO createAuthor(AuthorCreateDTO authorData) {
		var author = mapper.map(authorData);
		//author.setAuthor(userUtils.getCurrentUser());
		repository.save(author);
		var authorDTO = mapper.map(author);
		return authorDTO;
	}

	public AuthorDTO findById(Long id) {
		var author = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
		var authorDTO = mapper.map(author);
		return authorDTO;
	}

	public AuthorDTO updateAuthor(AuthorUpdateDTO authorData, Long id) {
		var author = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("This author is not found"));
		mapper.update(authorData, author);
		repository.save(author);
		var authorDTO = mapper.map(author);
		return authorDTO;
	}

	public void deleteAuthor(Long id) {
		repository.deleteById(id);
	}
    // END
}
