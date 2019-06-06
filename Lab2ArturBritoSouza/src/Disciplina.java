/**

 * Representacao de uma disciplina, com o nome dela, a quantidade de horas/aula 
 * que essa disciplina teve, quantas provas a disciplina tera, o peso de cada 
 * nota dessa disciplina, as notas em cada prova dessa diciplina de um aluno, a media
 * final de um aluno nessa disciplina e se esse aluno passou ou nao nessa disciplina.
 *

 * @author Artur Brito Souza - 118210056

 */

import java.util.Arrays;

public class Disciplina {

	// Nome da discilina
    private String nomeDisciplina;
    
    // Quantidade de horas de aula que a disciplina teve.
    private int horasAula;
    
    // As notas de um aluno nessa disciplina.
    private double[] notas;
    
    // Os pesos de cada nota nessa disciplina.
    private double[] pesosDasNotas;
    
    // A media do aluno nessa disciplina.
    private double media;
    
    // Contador para a conta da media.
    private int contador;
    
    /**
     * Constrói uma disciplina a partir do nome dela, com um padrao de 4 notas para essa disciplina.
     * @param nomeDisciplina - o nome da disciplina.
     * @param quantidadeDeNotasDaDisciplina - a quantidade de notas dessa disciplina
     */

    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.horasAula = 0;
        this.notas = new double[4];
        this.pesosDasNotas = new double[1];
        this.pesosDasNotas[0] = 1;
        this.media = 0;

    }

    /**
    * Constrói uma disciplina a partir do nome dela e da quantidade de notas que ela tera.
    * @param nomeDisciplina - o nome da disciplina.
    * @param quantidadeDeNotasDaDisciplina - a quantidade de notas dessa disciplina
    */

    public Disciplina(String nomeDisciplina, int quantidadeDeNotasDaDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[quantidadeDeNotasDaDisciplina];
        this.pesosDasNotas = new double[1];
        this.pesosDasNotas[0] = 1;

    }

    /**
     * Constrói uma disciplina a partir do nome dela, da quantidade de notas que ela tera
     * e do peso que cada nota tera no calculo da media.
     *

     * @param nomeDisciplina - o nome da disciplina.
     * @param quantidadeDeNotasDaDisciplina - a quantidade de notas dessa disciplina
     * @param pesoDasNotas - o peso de cada nota da disciplina.
     */
    
    public Disciplina(String nomeDisciplina, int quantidadeDeNotasDaDisciplina, double[] pesosDasNotas) {
        this(nomeDisciplina,  quantidadeDeNotasDaDisciplina);
        this.pesosDasNotas = pesosDasNotas;
    }


    /**
     * Cadastra uma quantidade de horas para a disciplina.
     * @param horas inteiro que representa a qunatidade de horas que estao sendo cadastradas nessa disciplina.
     */
    public void cadastraHoras(int horas){
        this.horasAula += horas;
    }

    /**
     * Cadastra uma nota em um teste.
     * @param nota inteiro que representa qual nota vai ser cadastrada
     * @param valorNota representa o valor que o aluno obteve no teste escolhido.
     */
    public void cadastraNota(int nota, double valorNota){
        this.notas[nota - 1] = valorNota;
    }

    /** 
     * Verifica se o aluno atingiu a media 7, minimo para passar na disciplina.
     * @return Um booleano que retorna verdade se a media e maior ou igual a 7 e falso se sua nota esta abaixo de 7.
     */
    public boolean aprovado( ){
        calculaMedia();

        if (this.media >= 7) {
            return true;
        }
        return false;
    }

    /**
     * Calcula a media do aluno da disciplina.
     * o if/else e para separar os casos em que e determinado os pesos das provas e os que nao sao determinados.
     */
    private void calculaMedia(){
        double somatorio = 0;
        double somatorioDosPesos = 0;

        if (this.pesosDasNotas[0] != 1) {
        	for (contador = 0; contador < notas.length; contador ++) {
            somatorio +=  (this.notas[contador] * this.pesosDasNotas[contador]);
            somatorioDosPesos += this.pesosDasNotas[contador];
            this.media = somatorio / somatorioDosPesos ;
        	}
        } 
        else { for (double notaAtual: this.notas) {
            somatorio +=  notaAtual;
            this.media = somatorio / this.notas.length;

        }
        }
    }

    /**
    * Retorna a String que representa o aluno. A representação segue o 
    * formato “nomeDisciplina - Nome da disciplina, horasAula - quantidade de horas dessa disciplina,
    * media - a media dessa disciplina, notas - as notas individuais de cada prova dessa disciplina.”.

    *
    * @return a representação em String de uma disciplina.
    */
    @Override
    public String toString( ){
        return this.nomeDisciplina + " " + this.horasAula + " " + this.media + " " + Arrays.toString(this.notas);
    }
}
