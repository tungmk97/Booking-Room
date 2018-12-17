package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.District;


@Repository
@Transactional(rollbackFor = Exception.class)
public class DistrictRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	public List<District> findAll() {
		return entityManager.createQuery("FROM District").getResultList();
	}
	

	public District findById(final int districtid) {
		return entityManager.find(District.class, districtid);
	}
}
