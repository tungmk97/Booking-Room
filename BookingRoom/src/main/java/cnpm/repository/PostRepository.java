package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Post;

@Repository
@Transactional(rollbackFor = Exception.class)
public class PostRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public void persist(final Post post) {
		entityManager.persist(post);
	}

	public Post findById(final int post_id) {
		return entityManager.find(Post.class, post_id);
	}

	public void delete(final Post post) {
		entityManager.remove(post);
	}

	public List<Post> findAll() {
		return entityManager.createQuery("FROM Post").getResultList();
	}
	
	public List<Post> findAllLimit6() {
		return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.price ASC").setMaxResults(6).getResultList();
	}
	
	public List<Post> findAllLimit2() {
		return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.post_id DESC").setMaxResults(2).getResultList();
	}
	
	public List<Post> findAllByUserId(int user_id) {
		return entityManager.createQuery("SELECT p FROM Post p WHERE p.user_id = " + user_id).getResultList();
	}
	public List<Post> findAllByAddress(String city, String district, String block) {
		return entityManager.createQuery("SELECT p FROM Post p WHERE p.address LIKE '%" + block + "%" + district + "%" + city+ "%'").getResultList();
	}
}
