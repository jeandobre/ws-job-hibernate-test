package domain.repositories;

import domain.Pessoa;
import org.hibernate.CacheMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import value_object.Nome;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import java.util.List;

public class Repositorio {

    public Repositorio() {

    }

    @Transactional(readOnly = true)
    public Pessoa buscarPessoaPorNome(String nome){
        try {
            return (Pessoa) JPA.em().createQuery("FROM Pessoa WHERE nome.primeiroNome = :nome")
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<Pessoa> buscarTodasPessoas(){
        Query query = JPA.em().createQuery("FROM Pessoa p ");
        return query.getResultList();
    }

    @Transactional
    public void removerTodos(){
        JPA.em().createQuery("DELETE FROM Pessoa")
                .executeUpdate();
    }

    @Transactional
    public void salvarPessoa(Pessoa pessoa){
        JPA.em().persist(pessoa);
    }

    @Transactional
    public void buscarESalvarPessoa(String nome, String sobrenome){
        //JPA.em()
        //JPA.em().setFlushMode(FlushModeType.COMMIT);

      /*  try {
            JPA.em().createQuery("FROM Pessoa WHERE nome.primeiroNome = :nome")
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e) {*/

      //  Session session = JPA.em().unwrap(Session.class);
    //    session.setCacheMode(CacheMode.REFRESH);
        EntityManager em = JPA.em();


      /*  try {
            Pessoa pessoa = (Pessoa) em.createQuery("FROM Pessoa WHERE nome.primeiroNome = :nome")
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (Exception e){*/
            if(!em.getTransaction().isActive())
                em.getTransaction().begin();

            Pessoa pessoa = new Pessoa(new Nome(nome, sobrenome));
          //  em.refresh(em.merge(pessoa));
          //  if(pessoa.id == null)
                em.persist(pessoa);
       // }
    }
}
