/**

 * Representacao do estado de saude de um estudante.
 *

 * @author Artur Brito Souza - 118210056

 */

public class Saude {

	// Estado da saude mental.
    private String saudeMental;
    
    // Estado da saude fisica.
    private String saudeFisica;
    
    // Emoji em que o aluno pode colocar para descrever de forma mais personalizada seu estado de saude. 
    private String emoji;

    /**
     * Metodo utilizado para inicializar um objeto do tipo Saude, com saudeFisica e saudeMental
     * igual a boa e um emoji igual a vazio.
     */
    public Saude (){
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
        this.emoji = "";

    }

    /**
     * Metodo utilizado para atribuir um emoji ao objeto saude.
     * @param emoji Define o atributo emoji no objeto Saude.
     */
    void definirEmoji(String emoji){
        this.emoji = emoji;


    }

    /**
     * Define um novo valor para saude mental.
     * @param valor String que define o estado de saude mental.
     * Verifica se ocorreu mudancas no estado de saude mental, para 
     * avaliar se deve retirar o emoji da avaliacao da saude geral.
     */
    void defineSaudeMental(String valor){
        if (!this.saudeMental.equals(valor)){
            this.emoji = "";
        }
        this.saudeMental = valor;
    }

    /**
    * Define um novo valor para saude fisica.
    * @param valor String que define o estado de saude fisica.
    * Verifica se ocorreu mudancas no estado de saude fisica, para 
    * avaliar se deve retirar o emoji da avaliacao da saude geral.
    */
    void defineSaudeFisica(String valor){
        if (!this.saudeFisica.equals(valor)){
            this.emoji = "";
        }
        this.saudeFisica = valor;
    }

    /**

     * Retorna a String que representa o estado de saude do aluno. A representação segue o 
     * formato qualificador, que possui tres categorias (boa, ok e fraca) seguido da opcao
     * de ter um emoji.

     *
     * @return a representação em String do estado de saude de um aluno.
     */
    
    String getStatusGeral(){
        if (this.saudeFisica.equals(this.saudeMental)){
            if (this.saudeFisica.equals("boa")){
                return "boa " + this.emoji;
            }
            return "fraca " + this.emoji;
        }
        return "ok " + this.emoji;
    }
}
