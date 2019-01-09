package org.o7planning.hellospringboot;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import cnpm.domain.Account;
import cnpm.hellospringboot.BookingRoomApplication;
import cnpm.repository.AccountRepository;
import cnpm.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookingRoomApplication.class)
public class BookingRoomApplicationTests {
	
	@ỊnjectMocks
	private AccountService service;
	
	@Mock
	private AccountRepository repository;
	
	private static final int ID = 1;
	@Test
	public void findByIdTest() {
		service.findById(ID);
		verify(repository).findById(ID);
}

	@Test
	public void saveTest() {
		Account account = mock(Account.class);
		service.save(account);
		verify(repository).persist(account);
	}
	@Test
	public void updateTest() {
		Account account = mock(Account.class);
		when(account.getUser_id()).thenReturn(ID);
		when(account.getName()).thenReturn("test name");
		when(account.getUsername()).thenReturn("test user_name");
		when(account.getPassword()).thenReturn("test password");
		when(account.getAddress()).thenReturn("test address");
		when(account.getEmail()).thenReturn("test email");
		Integer arg0 = null;
		when(account.getPhone_number()).thenReturn(arg0);
		service.update(account);
		verify(repository).persist(account);
	}
	public void deleteTest() {
		service.delete(ID);
		Account account = null;
		verify(repository).delete(account);
	}		
}
