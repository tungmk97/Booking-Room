package cnpm.service;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Account;
import cnpm.domain.Post;
import cnpm.repository.PostRepository;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(final int post_id) {
		return postRepository.findById(post_id);
	}

	public void save(final Post post, Principal principal) {
		// check if exist -> throw exception
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format( new Date()   );
		Account account = userDetailsServiceImpl.findByUsername(principal.getName());
		Post newPost = new Post();
		newPost.setPost_id(post.getPost_id());
		newPost.setTitle(post.getTitle());
		newPost.setAcreage(post.getAcreage());
		newPost.setAddress(post.getAddress());
		newPost.setDescription(post.getDescription());
		newPost.setPrice(post.getPrice());
		newPost.setId_user(account.getUser_id());
		newPost.setStatus_id(1);
//		newPost.setEnd_date(post.getEnd_date());
//		newPost.setStart_date(dateString);
		postRepository.persist(newPost);
	}

	public void update(final Post post) {
		// check if not exist -> throw excpetion
		Post postDb = postRepository.findById(post.getPost_id());
		postDb.setPost_id(post.getPost_id());
		postDb.setTitle(post.getTitle());
		postDb.setAcreage(post.getAcreage());
		postDb.setAddress(post.getAddress());
		postDb.setDescription(post.getDescription());
		postDb.setPrice(post.getPrice());
		postDb.setStatus_id(1);
//		newPost.setEnd_date(post.getEnd_date());
//		newPost.setStart_date(dateString);
		postRepository.persist(postDb);
	}

	public void delete(final int post_id) {
		Post post = postRepository.findById(post_id);
		if (post != null) {
			postRepository.delete(post);
		}
	}
}
