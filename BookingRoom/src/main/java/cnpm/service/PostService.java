package cnpm.service;

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
	
	public List<Post> findAll() {
		return postRepository.findAll();
	}	
	
	public Post findById(final int id_post) {
		return postRepository.findById(id_post);
	}
	
	public void save(final Post post) {
		postRepository.persist(post);
	}
	
//	public void save(final Account account) {
//		// check if exist -> throw exception
//		accountRepository.persist(account);
//	}
	
//	public void update(Post post) {
//		postRepository.update(post);
//	}
	
	public void delete(final int id_post) {
		Post post = postRepository.findById(id_post);
		if (post != null) {
			postRepository.delete(post);
		}
	}
//	public void delete(int id_post) {
//		postRepository.delete(id_post);
//	}
}
