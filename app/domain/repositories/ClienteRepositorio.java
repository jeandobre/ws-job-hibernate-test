package domain.repositories;

import domain.FornecedorCompra;
import domain.Pessoa;
import play.db.jpa.JPA;

import javax.persistence.Query;
import java.util.List;

public class ClienteRepositorio {

    public void removerTodosAcademicos(){
        JPA.em().createQuery("DELETE FROM AcademicoTurma").executeUpdate();
    }

    public void salvarFornecedor(FornecedorCompra fornecedorCompra){
        JPA.em().persist(fornecedorCompra);
    }

    public void removerTodosFornecedores(){
        JPA.em().createQuery("DELETE FROM FornecedorCompra").executeUpdate();
    }
}
