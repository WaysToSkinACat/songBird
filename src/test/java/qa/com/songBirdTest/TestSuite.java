package qa.com.songBirdTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ SongBirdLibraryEndpointTest.class, SongBirdEndpointTest.class, SongBirdLibraryServiceTest.class,
	SongBirdServiceTest.class, SongBirdLibraryRepositoryTest.class, SongBirdRepositoryTest.class })

public class TestSuite {
}