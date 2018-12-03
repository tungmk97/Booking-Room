package service;

import java.util.List;

import domain.Account;

public interface AccountService {
	
	Iterable<Account> findAll();

    List<Account> search(String q);

    Account findOne(int id);

    void save(Account account);

    void delete(int id);
}
