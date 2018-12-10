package cnpm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Account;
import cnpm.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	public Account findById(final int id_user) {
		return accountRepository.findById(id_user);
	}

	public void save(final Account account) {
		// check if exist -> throw exception
		accountRepository.persist(account);
	}

	public void update(final Account account) {
		// check if not exist -> throw excpetion
		Account accountDb = accountRepository.findById(account.getUser_id());
		accountDb.setUser_id(account.getUser_id());
		accountDb.setUsername(account.getUsername());
		accountDb.setName(account.getName());
		accountDb.setPassword(account.getPassword());
		accountDb.setEmail(account.getEmail());
		accountDb.setPhone_number(account.getPhone_number());
		accountDb.setAddress(account.getAddress());
		accountDb.setEnabled(account.getEnabled());
		accountRepository.persist(accountDb);
	}

	public void delete(final int user_id) {
		Account account = accountRepository.findById(user_id);
		if (account != null) {
			accountRepository.delete(account);
		}
	}
	
}
