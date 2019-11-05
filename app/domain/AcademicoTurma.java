package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "academicos_turmas", schema = "cadastros")
public class AcademicoTurma implements Serializable {

    @Id
    private Integer academico;

    @Id
    private Integer turma;

    private String descricao;

    @Deprecated
    private AcademicoTurma() {
    }

    public AcademicoTurma(Integer academcio, Integer turma, String descricao) {
        this.academico = academcio;
        this.turma = turma;
        this.descricao = descricao;
    }

    public Integer getAcademcioId() {
        return academico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicoTurma that = (AcademicoTurma) o;
        return Objects.equals(academico, that.academico) &&
                Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {

        return Objects.hash(academico, turma);
    }
}
