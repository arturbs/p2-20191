import SAGA.Cliente.ControllerCliente;
import SAGA.Fornecedor.ControllerFornecedor;
import SAGA.SAGAController;

public class Main {
    public static void main(String[] args) {
        ControllerFornecedor cf = new ControllerFornecedor();
        SAGAController cp = new SAGAController();
        ControllerCliente cc = new ControllerCliente();

        cf.cadastraFornecedor("Pac","pac@ccc","190");
        System.out.println(cf.listarFornecedores());

        cf.cadastraProduto("Pac","Maminha de Nathan","Gostoso",90000000);
        cf.cadastraProduto("Pac","Bundão duro de Danilo", "Parece uma melancia", 10);

        cf.cadastraCombo("Pac", "ComboDelicia", "DELICIA", 0.20, "Maminha de Nathan - Gostoso, Bundão duro de Danilo - Parece uma melancia");

        cf.cadastraProduto("Pac", "pao", "frances", 25);

        System.out.println(cf.listaProdutosFornecedor("Pac"));


        cc.cadastraCliente("99999999999", "antonio", "foda-se", "fodassetambem" );

        System.out.println(cc.listaClientes());

        System.out.println(cc.exibeContasCliente("99999999999"));

        cp.adicionaCompra("99999999999", "Pac", "12/01/1987", "pao", "frances");

        System.out.println(cc.exibeContasCliente("99999999999"));

    }
}
