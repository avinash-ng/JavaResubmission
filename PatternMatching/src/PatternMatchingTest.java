import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.logging.Level;
import java.util.logging.Logger;
class PatternMatchingTest {

	static PatternMatching pObj = new PatternMatching();
	Logger logger = Logger.getLogger(PatternMatching.class.getName());
	
	
	
	@Test
	void patternMatchingTestCase1() {
		
		boolean actual = pObj.containsAToZ("abcdefg");
		
		
		
		assertFalse(actual);
		logger.log(Level.INFO, "test passed : missing some characters");
	
	
	}	
	
	
	@Test
	void patternMatchingTestCase2() {
		
		boolean actual = pObj.containsAToZ("abcdefgHIJKLMNopqrstuvwxyZ");
		boolean expected = true;
		
		
		assertEquals(actual, expected);
		logger.log(Level.INFO, "test passed");
//			intentionally failed this test
//			Assert.fail("fails test");
	}

	
	
	@Test
	void patternMatchingTestCase3() {
		
		boolean actual = pObj.containsAToZ("abcdefgHIJMNopqrstuvwxyZ");
		
		
		assertFalse(actual);
		logger.log(Level.INFO, "test passed : missing some characters");
		
		
	}
}
