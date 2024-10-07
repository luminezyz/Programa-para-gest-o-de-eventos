import org.example.Evento;
import org.example.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EventoTest {
    private Evento evento;
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @BeforeEach
    public void setup() {
        evento = new Evento("Tech Conference", "2024-11-01", "São Paulo", 2);
        pessoa1 = new Pessoa("Paulinho");
        pessoa2 = new Pessoa("Luís");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("Tech Conference", evento.getNome());
        assertEquals("2024-11-01", evento.getData());
        assertEquals("São Paulo", evento.getLocal());
        assertEquals(2, evento.getCapacidade());

        evento.setNome("Java Summit");
        evento.setData("2024-12-15");
        evento.setLocal("Rio de Janeiro");
        evento.setCapacidade(500);

        assertEquals("Java Summit", evento.getNome());
        assertEquals("2024-12-15", evento.getData());
        assertEquals("Rio de Janeiro", evento.getLocal());
        assertEquals(500, evento.getCapacidade());
    }

    @Test
    public void testInscricaoEventoSucesso() {
        evento.inscricaoEvento(pessoa1);
        assertEquals(1, evento.getCapacidade());

        evento.inscricaoEvento(pessoa2);
        assertEquals(0, evento.getCapacidade());
    }

    @Test
    public void testInscricaoEventoLotado() {
        evento.inscricaoEvento(pessoa1);
        evento.inscricaoEvento(pessoa2);
        assertEquals(0, evento.getCapacidade());

        Pessoa pessoa3 = new Pessoa("Pedro");
        evento.inscricaoEvento(pessoa3);
        assertEquals(0, evento.getCapacidade());
    }

    @Test
    public void testCategoria() {
        evento.setCategoria("Tecnologia");
        assertEquals("Tecnologia", evento.getCategoria());
    }
}