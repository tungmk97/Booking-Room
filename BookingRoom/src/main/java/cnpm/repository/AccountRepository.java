package cnpm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cnpm.domain.Account;

@Repository(value = "accountDAO")
@Transactional(rollbackFor = Exception.class)
public class AccountRepository {
	
	@PersistenceContext	
	private EntityManager entityManager;

	public void persist(final Account account) {
		entityManager.persist(account);
	}

	public Account findById(final int id_user) {
		return entityManager.find(Account.class, id_user);
	}

	public void delete(final Account account) {
		entityManager.remove(account);
	}

	public List<Account> findAll() {
		return entityManager.createQuery("FROM Account").getResultList();
	}
}
