package domain;

import domain.repositories.ClienteRepositorio;
import value_object.FornecedorCompraId;

public class NovoFornecedor {

    public NovoFornecedor() {
    }

    public FornecedorCompra criarFornecedor(String nomeFantasia, String cnpj, String razaoSocial){

        FornecedorCompraId fornecedorCompraId = new FornecedorCompraId(cnpj, razaoSocial);

        FornecedorCompra fornecedorCompra = new FornecedorCompra(fornecedorCompraId, nomeFantasia);

        new ClienteRepositorio().salvarFornecedor(fornecedorCompra);

        return fornecedorCompra;
    }


}
