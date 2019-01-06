package cnpm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.District;
import cnpm.domain.Post;
import cnpm.domain.Province;

@Repository
@Transactional(rollbackFor = Exception.class)
public class SearchRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public void persist(final Province province) {
		entityManager.persist(province);
	}
	public void persist(final District dictrict) {
		entityManager.persist(dictrict);
	}
}
