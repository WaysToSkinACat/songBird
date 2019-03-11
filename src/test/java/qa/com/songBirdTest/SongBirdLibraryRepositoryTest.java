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

import qa.com.persistence.domain.Song;
import qa.com.persistence.repository.SongBirdLibraryDBRepository;
import qa.com.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class SongBirdLibraryRepositoryTest {

	private static final String MOCK_ARRAY1 = "[{\"songName\":\"Joe\",\"bPM\":1,\"description\":\"a\",\"tubeLink\":\"b\"},{\"songName\":\"Jane\",\"bPM\":12,\"description\":\"a\",\"tubeLink\":\"b\"}]";

	private static final String MOCK_ARRAY2 = "[{\"songName\":\"Joe\",\"bPM\":1,\"description\":\"a\",\"tubeLink\":\"b\"}]";

	private static final String MOCK_OBJECT = "{\"songName\":\"Joe\",\"bPM\":1,\"description\":\"a\",\"tubeLink\":\"b\"}";

	@InjectMocks
	private SongBirdLibraryDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	List<Song> songs;

	@Before
	public void setup() {
		songs = new ArrayList<Song>();
		songs.add(new Song("Joe",1,"a","b"));
		songs.add(new Song("Jane",12,"a","b"));
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllSongs() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(songs);
		assertEquals(MOCK_ARRAY1, repo.getAllSongs());
	}

	@Test
	public void testGetASong() {
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(songs.get(0));
		assertEquals(MOCK_OBJECT, repo.getASong(1L));
	}

	@Test
	public void testCreateASong() {
		String reply = repo.createASong(MOCK_OBJECT);
		assertEquals("{\"message\": \"Song has been sucessfully added\"}", reply);
	}

	@Test
	public void testDeleteSongPass() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		String reply = repo.deleteASong(1L);
		assertEquals("{\"message\": \"Song has been sucessfully deleted\"}", reply);
	}

	@Test
	public void testDeleteSongFail() {
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		String reply = repo.deleteASong(0L);
		assertEquals("{\"message\": \"no such Song\"}", reply);
	}

	@Test
	public void testUpdateSongFail() {
		String update = "{\"songName\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(false);
		assertEquals("{\"message\": \"no such Song\"}", repo.updateASong(1L, update));
	}

	@Test
	public void testUpdateSongPass() {
		String update = "{\"songName\":\"Jordan\"}";
		Mockito.when(manager.contains(Mockito.anyObject())).thenReturn(true);
		Mockito.when(manager.find(Mockito.any(), Mockito.anyLong())).thenReturn(songs.get(0));
		assertEquals("{\"message\": \"Song has been sucessfully updated\"}", repo.updateASong(1L, update));
	}
}
