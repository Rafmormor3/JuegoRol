package elementos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CoordenadaTest {

	@ParameterizedTest
	@CsvSource({
		"5,4",
		"6,3",
		"8,5"
	})
	void testGoRight(int x, int y) {
		Coordenada c = new Coordenada(x, y);
		assert(c.goRight());
	}
	
	@ParameterizedTest
	@CsvSource({
		"10,4",
		"10,3",
		"10,5"
	})
	void testGoRightFalse(int x, int y) {
		Coordenada c = new Coordenada(x, y);
		assertFalse(c.goRight());
	}

	@Test
	void testClone() {
		Coordenada c = new Coordenada(5, 4);
		assert(c.clone()==c);
	}
	
	@Test
	void testCloneFalse() {
		Coordenada c = new Coordenada(5, 4);
		assertFalse(c.clone()!=c);
	}

}
