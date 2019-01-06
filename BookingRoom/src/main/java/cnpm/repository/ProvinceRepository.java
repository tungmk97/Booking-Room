package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Post;
import cnpm.domain.Province;


@Repository
@Transactional(rollbackFor = Exception.class)
public class ProvinceRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public void persist(final Province province) {
		entityManager.persist(province);
	}
	
	public List<Province> findAll() {
		return entityManager.createQuery("FROM Province").getResultList();
	}
	
	public Province findById(final int provinceid) {
		return entityManager.find(Province.class, provinceid);
	}
	
	public List<Province> findAllLimit() {
		return entityManager.createQuery("SELECT p FROM Province p WHERE p.provinceid=").getResultList();
	}
}
