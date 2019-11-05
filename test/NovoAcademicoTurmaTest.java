import domain.AcademicoTurma;
import domain.repositories.ClienteRepositorio;
import domain.NovoCliente;
import org.junit.Before;
import org.junit.Test;
import play.test.UnitTest;

public class NovoAcademicoTurmaTest extends UnitTest {

    @Before
    public void limpar(){
        new ClienteRepositorio().removerTodosAcademicos();
    }

    @Test
    public void deveSalvarAcademicosCorretamente(){

        AcademicoTurma academicoTurma1 = new NovoCliente().criarAcademicoTurma(1,1, "Aluno 1 turma 1");
        AcademicoTurma academicoTurma2 = new NovoCliente().criarAcademicoTurma(2,1, "Aluno 2 turma 1");
        AcademicoTurma academicoTurma3 = new NovoCliente().criarAcademicoTurma(3,2, "Aluno 3 turma 2");
        AcademicoTurma academicoTurma4 = new NovoCliente().criarAcademicoTurma(4,2, "Aluno 4 turma 2");


        assertEquals(1, academicoTurma1.getAcademcioId().intValue());

    }
}
