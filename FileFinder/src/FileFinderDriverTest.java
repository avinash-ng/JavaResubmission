import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;





import org.junit.jupiter.api.Test;

class FileFinderDriverTest {

	FileFinder fd = new FileFinder();
	Logger logger = Logger.getLogger(FileFinder.class.getName());
	
	@Test
	void findFilesTest1() {
		ArrayList<String> actual = fd.findFiles("java");
		ArrayList<String> expected = new ArrayList<String> ();
						expected.add("./avinash/workspace/DemoProject/src/main/java");
						expected.add("./avinash/workspace/DemoProject/src/test/java");
						expected.add("./avinash/Downloads/jackson-core-jackson-core-2.10.1/src/main/java");
						expected.add("./avinash/Downloads/jackson-core-jackson-core-2.10.1/src/test/java");
						expected.add("./avinash/IdeaProjects/HelloWorld/src/main/java");
						expected.add("./avinash/IdeaProjects/HelloWorld/src/test/java");
						expected.add("./avinash/Visual_Paradigm_CE_16.1/resources/instantgenerator/rest/java");
						expected.add("./avinash/Visual_Paradigm_CE_16.1/resources/instantgenerator/java");
						expected.add("./avinash/Visual_Paradigm_CE_16.1/jre/bin/java");
		try {
			assertTrue(actual.containsAll(expected));
			assertTrue(expected.containsAll(actual));
			logger.log(Level.INFO, "test passed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}

		
	@Test
	void findFilesTest2() {
		ArrayList<String> actual = fd.findFiles("");
//		ArrayList<String> expected = new ArrayList<String> ();
		try {
			assertEquals("improper regex", actual.get(0));
			logger.log(Level.WARNING, "please pass some proper regex");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
	@Test
	void findFilesTest3() {
		ArrayList<String> actual = fd.findFiles("one.py");
		ArrayList<String> expected = new ArrayList<String> ();
		try {
			assertEquals(actual, expected);
			logger.log(Level.INFO, "test passed");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
			
	}
	
}
