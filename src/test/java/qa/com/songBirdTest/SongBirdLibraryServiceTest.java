package qa.com.songBirdTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import qa.com.business.service.SongBirdLibraryServiceImpl;
import qa.com.persistence.repository.SongBirdLibraryRepository;



@RunWith(MockitoJUnitRunner.class)
public class SongBirdLibraryServiceTest {

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private SongBirdLibraryServiceImpl service;

	@Mock
	private SongBirdLibraryRepository repo;

	@Before
	public void setup() {
		service.setRepository(repo);
	}

	@Test
	public void test1() {
		Mockito.when(repo.getAllSongs()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllSongs());
	}

	@Test
	public void test2() {
		Mockito.when(repo.getASong(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getASong(Mockito.anyLong()));
	}

	@Test
	public void test3() {
		Mockito.when(repo.createASong(Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.createASong(Mockito.anyString()));
	}

	@Test
	public void test4() {
		Mockito.when(repo.updateASong(Mockito.anyLong(), Mockito.anyString())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.updateASong(Mockito.anyLong(), Mockito.anyString()));
	}

	@Test
	public void test5() {
		Mockito.when(repo.deleteASong(Mockito.anyLong())).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.deleteASong(Mockito.anyLong()));
	}
}
