package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.District;
import cnpm.domain.Province;


@Repository
@Transactional(rollbackFor = Exception.class)
public class DistrictRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	public void persist(final District dictrict) {
		entityManager.persist(dictrict);
	}
	
	public List<District> findAll() {
		return entityManager.createQuery("FROM District").getResultList();
	}

	public District findById(final int districtid) {
		return entityManager.find(District.class, districtid);
	}

	public List<District> findAllLimitDis() {
		return entityManager.createQuery("SELECT p FROM District p WHERE p.provinceid=").getResultList();
	}
	
	
}
