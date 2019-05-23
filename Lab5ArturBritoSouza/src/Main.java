import SAGA.Fornecedor.ControllerFornecedor;

public class Main {
    public static void main(String[] args) {
        ControllerFornecedor cf = new ControllerFornecedor();
        cf.cadastraFornecedor("Pac","pac@ccc","190");
        System.out.println(cf.listarFornecedores());

        cf.cadastraProduto("Pac","Maminha de Nathan","Gostoso",90000000);
        cf.cadastraProduto("Pac","Bundão duro de Danilo", "Parece uma melancia", 10);

        System.out.println(cf.listaProdutosFornecedor("Pac"));

        cf.cadastraCombo("Pac", "ComboDelicia", "DELICIA", 0.20, "Maminha de Nathan - Gostoso, Bundão duro de Danilo - Parece uma melancia");

        cf.listaProdutosFornecedor("Pac");
    }
}
