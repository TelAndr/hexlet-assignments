package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Map;

import exercise.model.Post;
import exercise.model.Comment;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    
	@Autowired
    private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }
	
	@GetMapping("/{id}")
	// Пользователь автоматически преобразуется в JSON
	public PostDTO show(@PathVariable Long id) {
		var post = postRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

		//var dto = new PostDTO();
		//dto.setId(post.getId());
		//dto.setTitle(post.getTitle());
		//dto.setBody(post.getBody());
		//dto.setComments(toListCommentDTO(post));
		//return dto;
		return toPostDTO(post);
	}

	private PostDTO toPostDTO(Post post) {
		PostDTO postDTO = new PostDTO();
		postDTO.setTitle(post.getTitle());
		postDTO.setBody(post.getBody());
		postDTO.setId(post.getId());
		postDTO.setComments(toListCommentDTO(post));
		return postDTO;
	}
	private CommentDTO toCommentDTO(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setBody(comment.getBody());
		return commentDTO;
	}
	
	private List<CommentDTO> toListCommentDTO(Post post) {
		return commentRepository.findByPostId(post.getId()).stream()
				.map(this::toCommentDTO)
				.toList();
	}
}
// END
