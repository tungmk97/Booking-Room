package repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import domain.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findByNameContaining(String q);

	Account findOne(int id);
    
}
