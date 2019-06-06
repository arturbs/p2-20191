package pacoteSRC;

/**
 * Representacao de uma agenda telefonica.
 *
 * @author Artur Brito Souza
 */

public class Agenda {
	
	/**
     * Array que representa a lista da agenda.
     */
	private Contato[] listaDeContatos;

	/**
	 * Cria um array de contatos que representa as posicoes na agenda telefonica.
	 */
	public Agenda() {
		
		this.listaDeContatos = new Contato[100];
	}

	/**
	 * Criado para colocar as informacoes do contato dentro do array listaDeContatos.
	 * 
	 * @param posicao do contato no array no formato int.
	 * @param nome do contato no formato String.
	 * @param sobreNome do contato no formato String.
	 * @param numero do contato no formato String.
	 * 
	 * @return boolenado que retorna true se foi possivel cadastrar o contato em alguma possicao do array.
	 */
	public boolean cadastraContatos(int posicao, String nome, String sobreNome, String numero ) {
		if (posicao < 1 || posicao > 100){
			return false;

		}
		this.listaDeContatos[posicao - 1] = new Contato(nome, sobreNome, numero);
		return true;
	}

	/**
	 * Criado para mostrar informacoes de um contato especifico da agenda.
	 * 
	 * @param posicao do contato na lista da agenda, no formato int
	 * 
	 * @return a string saida, que se possivel cadastra sera uma
	 * string no formato nome sobrenome - numero e se nao for possivel
	 * cadastrar sera uma string dizendo que a posicao nao e valida.
	 */
	public String encontraContato(int posicao) {
		String saida = "";
		if (this.listaDeContatos[posicao - 1] != null) {
			saida += this.listaDeContatos[posicao - 1].toString();
			
		}
		else {
			saida += "POSICAO INVALIDA!";
		}
		
		return saida;
	}

	/**
	 * Criado para lista todos os contatos cadastrados pelo programa.
	 * 
	 * @return a string saida, que sera todos os contatos cadastrados ate
	 * o momento pelo programa no formato posicao na agenda - nome sobrenome.
	 */
	public String listaDeContatos() {
		String saida = "";
		for (int posicao = 0; posicao < listaDeContatos.length; posicao++) {
			if (this.listaDeContatos[posicao] != null) {
				saida += (posicao + 1) + " - " + this.listaDeContatos[posicao].getNome() + " " + this.listaDeContatos[posicao].getSobreNome() + "\n";
			}
		}
		return saida;
	}
}
