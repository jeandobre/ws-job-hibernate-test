package domain;

import value_object.Nome;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pessoas", schema = "cadastros")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Embedded
    private Nome nome;

    public Pessoa(Nome nome) {
        this.nome = nome;
    }

    @Version
    private Integer version;

    //O hibernate usa este construtor, por isso deixar ele como private e
    //Para não ser utilizado
    @Deprecated
    private Pessoa() {}

    public String getNome() {
        return nome.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
