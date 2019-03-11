package qa.com.songBirdTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import qa.com.business.service.SongBirdLibraryService;
import qa.com.rest.SongBirdLibraryEndpoint;

@RunWith(MockitoJUnitRunner.class)
public class SongBirdLibraryEndpointTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SongBirdLibraryEndpoint endpoint;

	@Mock
	private SongBirdLibraryService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void test1() {
		Mockito.when(service.getAllSongs()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getAllSongs());
	}

	@Test
	public void test2() {
		Mockito.when(service.getASong(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.getASong(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(service.createASong(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.createASong(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(service.updateASong(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.updateASong(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(service.deleteASong(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.deleteASong(Mockito.anyLong()));
	}
}
