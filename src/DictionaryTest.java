import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void constructorTest() {
		Dictionary testing = new Dictionary();
		assertNotNull(testing.available);
		assertNotNull(testing.wordSize);
	}

}
