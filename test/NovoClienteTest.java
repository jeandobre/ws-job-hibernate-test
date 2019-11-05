import domain.NovaPessoaJob;
import domain.repositories.ClienteRepositorio;
import domain.NovoCliente;
import domain.Pessoa;
import domain.repositories.Repositorio;
import org.junit.Before;
import org.junit.Test;
import play.libs.F;
import play.test.UnitTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovoClienteTest extends UnitTest {

    @Before
    public void limparPessoas(){
        new Repositorio().removerTodos();
    }
/*
    @Test
    public void carregarPessoas(){

        Pessoa novoCliente = new NovoCliente()
                .criarNovoCliente("Jean", "Dobre");

        assertNotNull(novoCliente.id);
        assertEquals("Jean Dobre", novoCliente.getNome());
        assertNotNull(novoCliente);
    }

    //Cuidado este teste depende do anterior, pode dar errado
    @Test
    public void buscarPessoasNoBanco(){

        Pessoa pessoaJ = new NovoCliente()
                .criarNovoCliente("Jean", "Dobre");

        Pessoa pessoaK = new NovoCliente()
                .criarNovoCliente("Joana", "Dark");

        List<Pessoa> pessoas = new Repositorio().buscarTodasPessoas();
        assertEquals(2, pessoas.size());

    }
*/
    @Test
    public void concorrenciaComInsercoes(){
        List<F.Promise<Integer>> promises = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            String nomeAleatorio = "Jean" + (i % 2);
            promises.add(new NovaPessoaJob(nomeAleatorio).now());
        }
        System.out.println("percorreu todo o laço");
        F.Promise.waitAll(promises);
        System.out.println("Terminou");

    }

    /*
    @Test
    public void deveDarErroAoSalvar(){
      //  JPA.em().getTransaction().;
        Pessoa pessoaJ = new NovoCliente()
                .criarNovoCliente("Jean", "Dobre");

        try {
            Pessoa pessoaK = new NovoCliente()
                    .criarNovoCliente("Jean", "Dark");

            fail("Deveria ocorrer erro de Nome único duplicado");
        } catch (Exception e){
            JPA.em().getTransaction().rollback();
        }

    }*/
}
