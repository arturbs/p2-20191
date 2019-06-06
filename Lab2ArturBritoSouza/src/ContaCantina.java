/**

 * Representacao das contas de cantina de um aluno, especificamente de computacao, matriculado da * UFCG.
 * Toda conta de cantina precisa ter o nome da cantina e e identificado unicamente por este nome.
 *

 * @author Artur Brito Souza - 118210056

 */

public class ContaCantina {

    // Nome da cantida.
    private String nomeDaCantina;

    // Quanto o aluno tem em dividas nessa cantina
    private int conta;

    //Qunatidade de itens comprados nessa cantina.
    private int totalDeItens;

    // Valor, em centavos, da compra realizada.
    private int valor;


    /**
     * Constroi uma conta para uma cantina a partir do nome da cantina.
     * @param nomeDaCantina e a String que representa a cantina a qual a conta esta se referindo.
     */

    public ContaCantina(String nomeDaCantina) {
        this.nomeDaCantina = nomeDaCantina;
        this.valor = 0;
        this.totalDeItens = 0;
    }

    /**
     * Metodo criado para cadastro de lanche em ContaCantina e acrescentar na divida dessa 
     * conta o valor dessa compra.
     * @param qtdItens Inteiro que representa a quantidade de produtos comprados na cantina
     * @param valorCentavos Inteiro que representa o valor total em centavos gasto nessa compra.
     */
    public void cadastraLanche(int qtdItens, int valorCentavos) {
        this.valor += valorCentavos;
        this.totalDeItens += qtdItens;
        this.conta += valorCentavos;

    }

    /**
     * Metodo que subtrai um valor da divida em conta.
     * @param valorCentavos Inteiro que representa a quantidade, em centavos, que esta sendo paga da divida.
     */
    public void pagaConta(int valorCentavos) {
        this.conta -= valorCentavos;
    }


    /**
     *Metodo utilizado para saber quanto ainda falta pagar na divida da conta.
     * @return Um inteiro representando a quantidade que falta para pagar.
     */
    public int getFaltaPagar( ) {
        return this.conta;
    }

    /**
     * Retorna a String que representa a cantina no formato nome da cantina, 
     * o total de itens comprados e o valor total das compras.

     *
     * @return a representação em String das informacoes referentes a cantina.
     */
    
    @Override
    public String toString( ) {
        return this.nomeDaCantina + " " + this.totalDeItens + " " + this.valor;
    }
}
