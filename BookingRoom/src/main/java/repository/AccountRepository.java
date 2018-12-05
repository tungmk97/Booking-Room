package repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findByNameContaining(String q);
}
