package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Account;
import repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
    private AccountRepository accountRepository;

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public List<Account> search(String q) {
		// TODO Auto-generated method stub
		return accountRepository.findByNameContaining(q);
	}

	@Override
	public Account findOne(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findOne(id);
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
		
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);
		
	}

}
