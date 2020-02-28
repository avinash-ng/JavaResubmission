import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;;
class FillingFormTests {

	static FormFilling obj = new FormFilling();
	Logger logger = Logger.getLogger(FormFilling.class.getName());

	
	@Test
	void findDatesTestCase1() {
		String actual = null;
		String expected = "No range";
		try {
			actual = obj.findDates("04-04-2016", "01-02-2014");
			assertEquals(actual, expected);
			logger.log(Level.INFO, "test case passed");

		} 
		catch (ParseException e) {
			logger.log(Level.SEVERE, "exception raised");
//			e.printStackTrace();
//			logger.log(Level.SEVERE, "exception raised");
		}
		
	}
	
	
	
	
	@Test
	void findDatesTestCase2() {
		String actual = null;
		String expected = "05-03-2017 04-04-2017";
		try {
			actual = obj.findDates("04-04-2016", "04-04-2017");
			assertEquals(actual, expected);
			logger.log(Level.INFO, "test case passed");

		} catch (ParseException e) {
			
			e.printStackTrace();
			logger.log(Level.SEVERE, "exception raised");
		}
		
		
	}
	
	@Test
	void findDatesTestCase3() {
		String actual = null;
		String expected = "05-03-2017 04-03-2017";
		try {
			actual = obj.findDates("04-04-2016", "04-03-2017");
			assertEquals(actual, expected);
			logger.log(Level.INFO, "test case passed");

		} catch (ParseException e) {
			
			e.printStackTrace();
			logger.log(Level.SEVERE, "exception raised");
		}
			
	}
	
	@Test
	void findDatesTestCase4() {
		String actual = null;
		String expected = "05-03-2017 04-05-2017";
		try {
			actual = obj.findDates("04-04-2016", "05-05-2017");
			assertEquals(actual, expected);
			logger.log(Level.INFO, "test case passed");

		} catch (ParseException e) {
			
			e.printStackTrace();
			logger.log(Level.SEVERE, "exception raised");
		}
			
	}
	
	
	

}
