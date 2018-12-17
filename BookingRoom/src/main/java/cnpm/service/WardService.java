package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Ward;
import cnpm.repository.WardRepository;

@Service
@Transactional
public class WardService {
	
	@Autowired
	private WardRepository wardRepository;
	
	public List<Ward> findAll() {
		return wardRepository.findAll();
	}

	public Ward findById(final int wardid) {
		return wardRepository.findById(wardid);
	}
}
