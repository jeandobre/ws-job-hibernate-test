package domain;

import domain.repositories.Repositorio;
import play.db.jpa.JPA;
import value_object.Nome;

public class NovoCliente {

    private static Repositorio repositorio;

    public NovoCliente() {
        repositorio = new Repositorio();
    }

    public Pessoa criarNovoCliente(String primeiroNome, String ultimoNome){
        Nome nome = new Nome(primeiroNome, ultimoNome);

        Pessoa pessoa = new Pessoa(nome);
        repositorio.salvarPessoa(pessoa);

        return pessoa;
    }

    public AcademicoTurma criarAcademicoTurma(Integer academicoId, Integer turmaId, String descricao){
        AcademicoTurma academicoTurma = new AcademicoTurma(academicoId, turmaId, descricao);

        JPA.em().persist(academicoTurma);

        return academicoTurma;
    }
}
