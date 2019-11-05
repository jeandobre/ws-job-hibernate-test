package value_object;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class FornecedorCompraId implements Serializable {

    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Deprecated
    private FornecedorCompraId(){

    }

    public FornecedorCompraId(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorCompraId that = (FornecedorCompraId) o;
        return Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cnpj, razaoSocial);
    }
}
