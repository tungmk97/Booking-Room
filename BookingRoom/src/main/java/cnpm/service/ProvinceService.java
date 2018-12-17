package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Province;
import cnpm.repository.ProvinceRepository;

@Service
@Transactional
public class ProvinceService {
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	public List<Province> findAll() {
		return provinceRepository.findAll();
	}

	public Province findById(final int provinceid) {
		return provinceRepository.findById(provinceid);
	}
}
