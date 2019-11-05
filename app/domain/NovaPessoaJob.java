package domain;

import domain.repositories.Repositorio;
import play.Logger;
import play.db.jpa.Transactional;
import play.jobs.Job;
import value_object.Nome;

public class NovaPessoaJob extends Job<Integer> {

    private static Repositorio repositorio;
    private String nome;

    public NovaPessoaJob(String nome) {
        repositorio = new Repositorio();
        this.nome = nome;
    }

    @Override
    //@Transactional
    public void doJob() throws Exception {

//        Pessoa pessoa = repositorio.buscarPessoaPorNome(nome);
  //      if(pessoa == null){
         //   pessoa = new Pessoa(new Nome(nome, "teste"));
            try {
                //repositorio.salvarPessoa(pessoa);
                repositorio.buscarESalvarPessoa(nome, "TESTE");
                System.out.println("Salvou " + nome);
            } catch (Exception e){
                e.printStackTrace();
                //Logger.error("Erro ao salvar pessoa", e);
            }
       // }

    }
}
