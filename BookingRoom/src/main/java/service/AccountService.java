package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Account;

@Service
public interface AccountService {
	
	Iterable<Account> findAll();

    List<Account> search(String q);

    List<Account> findOne(int id);

    void save(Account account);

    void delete(int id);
}
