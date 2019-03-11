package qa.com.songBirdTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import qa.com.business.service.SongBirdServiceImpl;
import qa.com.persistence.repository.SongBirdRepository;

@RunWith(MockitoJUnitRunner.class)
public class SongBirdServiceTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SongBirdServiceImpl service;

	@Mock
	private SongBirdRepository repo;

	@Before
	public void setup() {
		service.setRepository(repo);
	}

	@Test
	public void test1() {
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllAccounts());
	}

	@Test
	public void test2() {
		Mockito.when(repo.getAnAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAnAccount(Mockito.anyString()));
	}

	@Test
	public void test3() {
		Mockito.when(repo.createAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.createAccount(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(repo.updateAccount(Mockito.anyString(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateAccount(Mockito.anyString(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(repo.deleteAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteAccount(Mockito.anyString()));
	}
}
