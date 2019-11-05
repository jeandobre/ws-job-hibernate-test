package domain;

import value_object.FornecedorCompraId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedores_compras", schema = "cadastros")
public class FornecedorCompra {

    @EmbeddedId
    private FornecedorCompraId id;

    private String nomeFantasia;

    @Deprecated
    private FornecedorCompra() {
    }

    public FornecedorCompra(FornecedorCompraId id, String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        this.id = id;
    }

    public String getCNPJ() {
        return id.getCnpj();
    }
}
