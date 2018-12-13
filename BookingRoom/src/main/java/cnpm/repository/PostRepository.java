package cnpm.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Post;



@Repository()
@Transactional(rollbackFor = Exception.class)
public class PostRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public void persist(final Post post) {
		entityManager.persist(post);
	}
	
	public Post findById(final int id_post) {
		return entityManager.find(Post.class, id_post);
	}
	public void delete(final Post post) {
		entityManager.remove(post);
	}
	
	public List<Post> findAll() {
		return entityManager.createQuery("FROM posts").getResultList();
	}
}
