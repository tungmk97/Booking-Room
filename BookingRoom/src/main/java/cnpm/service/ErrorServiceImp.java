package cnpm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cnpm.domain.Error;
import cnpm.repository.ErrorRepository;


@Service
public class ErrorServiceImp {

	 @Autowired
	    private ErrorRepository errorRepository;

	    public Error getOne(String id){
	        return errorRepository.getOne(id);
	    }
}
