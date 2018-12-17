package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Village;
import cnpm.repository.VillageRepository;

@Service
@Transactional
public class VillageService {
	
	@Autowired
	private VillageRepository villageRepository;
	
	public List<Village> findAll() {
		return villageRepository.findAll();
	}

	public Village findById(final int villageid) {
		return villageRepository.findById(villageid);
	}
}
