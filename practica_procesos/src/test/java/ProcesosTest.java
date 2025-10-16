import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.ProcesoPadre;

public class ProcesosTest {

    @Test
    void testGrepFiltraLineasConPSP() throws Exception {
        String[] lines = ProcesoPadre.MSG.split("\r?\n");
        long count = java.util.Arrays.stream(lines)
            .filter(l -> l.toLowerCase().contains("psp"))
            .count();
        assertEquals(3, count, "Debe haber 3 líneas que contienen 'psp'");
    }
}
