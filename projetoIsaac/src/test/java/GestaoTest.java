import org.example.Evento;
import org.example.Gestao;
import org.example.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GestaoTest {

    private Gestao gestao;
    private Evento evento1;
    private Evento evento2;
    private Pessoa pessoa;

    @BeforeEach
    public void setup() {
        gestao = new Gestao();
        evento1 = new Evento("Semana Nexus", "01/01/2024", "Cesupa", 100);
        evento2 = new Evento("BGS", "02/02/2024", "São Paulo", 20000);
        pessoa = new Pessoa("Luís", "123456789", "luís@example.com");

        gestao.eventos[0] = evento1;
        gestao.eventos[1] = evento2;
    }

    @Test
    public void testCadastrarEvento() {
        Evento novoEvento = new Evento("Comic Con", "03/03/2024", "Algum lugar", 50000);
        gestao.eventos[2] = novoEvento;
        assertNotNull(gestao.eventos[2]);
        assertEquals("Comic Con", gestao.eventos[2].getNome());
    }

    @Test
    public void testListarEventos() {
        gestao.listarEventos();
        assertNotNull(gestao.eventos[0]);
        assertNotNull(gestao.eventos[1]);
    }

    @Test
    public void testBuscarEvento() {
        Evento eventoEncontrado = null;
        for (Evento e : gestao.eventos) {
            if (e != null && e.getNome().equals("Semana Nexus")) {
                eventoEncontrado = e;
                break;
            }
        }
        assertNotNull(eventoEncontrado);
        assertEquals("Semana Nexus", eventoEncontrado.getNome());
    }

    @Test
    public void testCategorizarEvento() {
        gestao.eventos[0].setCategoria("Tecnologia");
        assertEquals("Tecnologia", gestao.eventos[0].getCategoria());
    }

    @Test
    public void testInscricaoEvento() {
        gestao.eventos[0].inscricaoEvento(pessoa);
        assertEquals(99, gestao.eventos[0].getCapacidade());
    }
}
