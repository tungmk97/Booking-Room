package cnpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cnpm.domain.Account;

public interface UserRepository extends JpaRepository<Account, Integer> {
	Account findByUsername(String username);
	Account findByEmail(String email);
}