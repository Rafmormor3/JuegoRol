package elementos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JugadorTest {

	@Test
    void testSetGemasExcepcion() {

        Jugador j = new Jugador(PlayerType.ELFO);
        assertThrows(JugadorException.class, () -> j.setGemas(-1), "No puede introducir gemas negativas");

    }

    @Test
    void testSetGemas() {
        Jugador j = new Jugador(PlayerType.ELFO);
        assertDoesNotThrow(() -> j.setGemas(2));
    }

    @Test 
    void testGetFuerzaParaLuchar() {
        Jugador j = new Jugador(PlayerType.ELFO);
        assert(j.getFuerzaParaLuchar()>=0);
    }

    @ValueSource(ints = {-1, -5, -6})
    @ParameterizedTest
    void testSetDineroException(int dinero) {
        Jugador j = new Jugador(PlayerType.ELFO);
        assertThrows(JugadorException.class,() -> j.setDinero(dinero),"No puede introducir dinero negativo");
    }

    @ValueSource(ints = {1, 5, 3})
    @ParameterizedTest
    void testSetDinero(int dinero) {
        Jugador j = new Jugador(PlayerType.ELFO);
        assertDoesNotThrow(() -> j.setDinero(dinero));
    }

}
