package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Ward;


@Repository
@Transactional(rollbackFor = Exception.class)
public class WardRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public List<Ward> findAll() {
		return entityManager.createQuery("FROM Ward").getResultList();
	}

	public Ward findById(final int wardid) {
		return entityManager.find(Ward.class, wardid);
	}
}
