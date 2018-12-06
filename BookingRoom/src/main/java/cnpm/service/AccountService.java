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
		Account accountDb = accountRepository.findById(account.getId_user());
		accountDb.setName(account.getName());
		accountDb.setAddress(account.getAddress());
		accountRepository.persist(accountDb);
	}

	public void delete(final int id_user) {
		Account account = accountRepository.findById(id_user);
		if (account != null) {
			accountRepository.delete(account);
		}
	}
}
