import domain.repositories.ClienteRepositorio;
import domain.FornecedorCompra;
import domain.NovoFornecedor;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

public class NovoFornecedorCompraTest extends UnitTest {

    @Before
    public void removerTodos(){
        new ClienteRepositorio().removerTodosFornecedores();
    }

    @Test
    public void criarESalvarCorretamente(){

        NovoFornecedor novoFornecedor = new NovoFornecedor();

        FornecedorCompra fornecedor = novoFornecedor.criarFornecedor("Empresa de fachada","14.145.245/0001-52", "Beltran social ltda");

        assertNotNull(fornecedor);
        assertEquals("14.145.245/0001-52", fornecedor.getCNPJ());


    }
}
