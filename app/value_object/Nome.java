package value_object;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Version;
import java.util.Objects;

@Embeddable
public class Nome {

    @Column(name = "primeiro_nome")
    @NaturalId()
    private String primeiroNome;

    @Column(name = "ultimo_nome")
    private String ultimoNome;

    public Nome(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    public String getNome() {
        return primeiroNome + " " + ultimoNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nome nome = (Nome) o;
        return Objects.equals(primeiroNome, nome.primeiroNome) &&
                Objects.equals(ultimoNome, nome.ultimoNome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiroNome, ultimoNome);
    }
}
