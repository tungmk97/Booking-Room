package cnpm.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Account;
import cnpm.domain.AppRole;
import cnpm.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
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
		Account user = new Account();
    	String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
        user.setUser_id(account.getUser_id());
        user.setUsername(account.getUsername());
        user.setName(account.getName());
        user.setPassword(encodedPassword);
        user.setEmail(account.getEmail());
        user.setAddress(account.getAddress());
        user.setPhone_number(account.getPhone_number());
        user.setEnabled(account.getEnabled());
        user.setRoles(Arrays.asList(new AppRole("USER")));
		accountRepository.persist(user);
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
