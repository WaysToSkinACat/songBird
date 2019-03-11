package qa.com.songBirdTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import qa.com.persistence.domain.Account;
import qa.com.persistence.repository.SongBirdDBRepository;
import qa.com.util.JSONUtil;



@RunWith(MockitoJUnitRunner.class)
public class SongBirdRepositoryTest {

	private static final String MOCK_ARRAY1 = "[{\"userName\":\"Matt\",\"firstName\":\"ff\",\"lastName\":\"Matt\",\"email\":\"Matt\",\"songs\":[]},{\"userName\":\"Jordan\",\"firstName\":\"ff\",\"lastName\":\"Matt\",\"email\":\"Matt\",\"songs\":[]}]";

	private static final String MOCK_ARRAY2 = "[{\"userName\":\"Matt\",\"firstName\":\"ff\",\"lastName\":\"Matt\",\"email\"\"Matt\",\"songs\":[]}]";

	private static final String MOCK_OBJECT = "{\"userName\":\"Matt\",\"firstName\":\"ff\",\"lastName\":\"Matt\",\"email\":\"Matt\",\"songs\":[]}";

	@InjectMocks
	private SongBirdDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private List<Account> accounts;

	@Before
	public void setup() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account("Matt", "ff", "Matt", "Matt"));
		accounts.add(new Account("Jordan", "ff", "Matt", "Matt"));
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllClassrooms() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(accounts);
		assertEquals(MOCK_ARRAY1, repo.getAllAccounts());
	}

	@Test
	public void testGetAnAccount() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyString())).thenReturn(accounts.get(0));
		assertEquals(MOCK_OBJECT, repo.getAnAccount("Matt"));
	}

	@Test
	public void testCreateAccount() {
		String reply = repo.createAccount(MOCK_OBJECT);
		assertEquals("{\"message\": \"Account has been sucessfully added\"}", reply);
	}

	@Test
	public void testDeleteAccountpass() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		String reply = repo.deleteAccount("Matt");
		assertEquals("{\"message\": \"Account has been sucessfully deleted\"}", reply);
	}

	@Test
	public void testDeleteAccountFail() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		String reply = repo.deleteAccount("Matt");
		assertEquals("{\"message\": \"no such Account\"}", reply);
	}

	@Test
	public void testUpdateAccountFail() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		assertEquals("{\"message\": \"no such Account\"}", repo.updateAccount("Jordan", update));
	}

	@Test
	public void testUpdateAccountPass() {
		String update = "{\"trainer\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(accounts.get(0));
		assertEquals("{\"message\": \"Account has been sucessfully Updated\"}", repo.updateAccount("Matt", update));
	}
}
