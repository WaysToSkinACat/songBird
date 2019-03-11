package qa.com.songBirdTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import qa.com.business.service.SongBirdService;
import qa.com.rest.SongBirdEndpoint;



@RunWith(MockitoJUnitRunner.class)
public class SongBirdEndpointTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SongBirdEndpoint endpoint;

	@Mock
	private SongBirdService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}
	@Ignore
	@Test
	public void test1() {
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllAccounts());
	}
	@Ignore
	@Test
	public void test2() {
		Mockito.when(service.getAnAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAnAccount(Mockito.anyString()));
	}
	@Ignore
	@Test
	public void test3() {
		Mockito.when(service.createAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.createAccount(Mockito.anyString()));
	}
	@Ignore
	@Test
	public void test4() {
		Mockito.when(service.updateAccount(Mockito.anyString(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateAccount(Mockito.anyString(), Mockito.anyString()));
	}
@Ignore
	@Test
	public void test5() {
		Mockito.when(service.deleteAccount(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteAccount(Mockito.anyString()));
	}
}