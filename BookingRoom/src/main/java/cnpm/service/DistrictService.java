package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.District;
import cnpm.repository.DistrictRepository;

@Service
@Transactional
public class DistrictService {
	
	@Autowired
	private DistrictRepository districtRepository;
	
	public List<District> findAll() {
		return districtRepository.findAll();
	}

	public District findById(final int districtid) {
		return districtRepository.findById(districtid);
	}
}
