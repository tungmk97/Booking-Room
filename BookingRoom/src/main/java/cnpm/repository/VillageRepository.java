package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Village;


@Repository
@Transactional(rollbackFor = Exception.class)
public class VillageRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public List<Village> findAll() {
		return entityManager.createQuery("FROM Village").getResultList();
	}
	

	public Village findById(final int villageid) {
		return entityManager.find(Village.class, villageid);
	}
}
