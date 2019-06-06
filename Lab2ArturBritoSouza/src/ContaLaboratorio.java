/**

 * Representacao das contas dos laboratorios de um estudante.

 * @author Artur Brito Souza - 118210056

 */

public class ContaLaboratorio {

	// Nome do laboratorio.
    private String nomeLab;
    
    // Cota da memoria que o aluno tem em determinado laboratorio.
    private int cota;
    
    // Espaco utilizado da memoria desse laboratorio.
    private int espacoUtilizado = 0;

    /**
     * Metodo que inicializa um objeto do tipo ContaLaboratorio,
     * com uma cota padrao de 2000 mgb.
     * @param nomeLab String que representa o nome do laboratoro.
     */
    public ContaLaboratorio (String nomeLab){
        this.nomeLab = nomeLab;
        this.cota = 2000;
    }

    /**
     * Metodo que inicializa um objeto do tipo ContaLaboratorio.
     * @param nomeLab String que representa o nome do laboratoro.
     * @param cota inteiro que representa a o espaco limite de memoria
     * permitido para o usuario nesse laboratorio.
     */
    public  ContaLaboratorio (String nomeLab, int cota){
        this.nomeLab = nomeLab;
        this.cota = cota;
    }

    /** Ocupa espaco de memoria na conta.
     * @param mbytes inteiro que representa a quantidade de memoria, em mb, que sera consumido da conta. 
     */
    public void consomeEspaco (int mbytes){
        this.espacoUtilizado += mbytes;
    }


    /**
     * Elimina espaco de memoria utilizado 
     * @param mbytes inteiro que representa a quantidade de memoria, em mb, que sera liberado da conta.
     */
    public void liberaEspaco(int mbytes){
        this.espacoUtilizado -= mbytes;
    }

    /** 
     * Verifica se o aluno atingiu o limite de memoria de sua conta nesse laboratorio.
     * @return Um booleano que retorna verdade se passou do limite e falso se esta abaixo do limite.
     */
    boolean atingiuCota(){
        if (this.espacoUtilizado >= this.cota) {
            return true;
        }
        return false;
    }

    /**
     * Retorna a String que representa o laboratorio no formato nome do laboratorio, 
     * o total de espaco utilizado e o limite disponivel de memoria do laboratorio.
     * @return a representação em String das informacoes referentes ao laboratorio.
     */
    @Override
    public String toString(){
        return this.nomeLab + " " + this.espacoUtilizado + "/" + this.cota;
    }
}

