package cnpm.AccountTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cnpm.domain.Account;
import cnpm.repository.AccountRepository;
import cnpm.service.AccountService;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
    private AccountService accountService;
	
	 @Autowired
	    private AccountRepository accountRepository;
	@Test
	public void testFindById() {
		 // given
	    Account alex = new Account(0, "alex", null, null, null, 0, null, null, null);
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    Account found = accountRepository.findById(alex.getUser_id());
	 
	    // then
	    assertThat(found.getUser_id())
	      .isEqualTo(alex.getUser_id());
	    
	}
	@Test
	public void testSaveAccount() {
		Account account = new Account();
			        account.setUser_id(50);
					account.setUsername("Huh");
					account.setName("Trần Thị Hiền");
					account.setPassword("abc12345");
					account.setEmail("hien05@gmail.com");
					account.setPhone_number(016);
					account.setAddress("abc");
					
			        int x = entityManager.createQuery("select count(*) from Account").getFirstResult();
			        accountService.save(account);
			        int y = entityManager.createQuery("select count(*) from Account").getFirstResult();
			        Assert.assertEquals(x+1,y);
		
	}
	    
	
	@Test
	public void testUpdateAccount() {
		Account account = new Account();
			        account.setUser_id(50);
					account.setUsername("Huh");
					account.setName("Trần Thị Hiền");
					account.setPassword("abc12345");
					account.setEmail("hien05@gmail.com");
					account.setPhone_number(016);
					account.setAddress("abc");
					
			        int x = entityManager.createQuery("select count(*) from Account").getFirstResult();
			        accountService.update(account);
			        int y = entityManager.createQuery("select count(*) from Account").getFirstResult();
			        Assert.assertEquals(x,y);
		
	}
	@Test
	public void testDeleteAccount() {
		        int countBeforeDelete = entityManager.createQuery("select count(*) from Account").getFirstResult();
		        accountService.delete(01);
		        int countAfterDelete = entityManager.createQuery("select count(*) from Account").getFirstResult();
		        Assert.assertEquals(countBeforeDelete-1, countAfterDelete);
		
	}
}
