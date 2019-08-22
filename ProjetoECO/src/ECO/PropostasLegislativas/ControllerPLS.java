package ECO.PropostasLegislativas;

import ECO.Comissao.Comissao;
import ECO.Pessoa.Deputado;
import ECO.Pessoa.Pessoa;

import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.*;

/**
 * Classe responsavel por controlar e gerenciar todas as acoes de propostas legislativas
 * @autor Artur Brito
 */

public class ControllerPLS implements Serializable {
	/**
	 * Atributo mapa responsavel por armazenar as PLS cadastradas.
	 */

	private HashMap<String, PropostaLegislativa> propostasDeLeis;
	/**
	 * Atributo responsavel por armazenar o numero de propostas do Tipo PL
	 */

	private HashMap<Integer, Integer> numeroPL;
	/**
	 * Atributo responsavel por armazenar o numero de propostas do Tipo PLP
	 */
	private HashMap<Integer, Integer> numeroPLP;
	/**
	 * Atributo responsavel por armazenar o numero de propostas do Tipo PEC
	 */
	private HashMap<Integer, Integer> numeroPEC;

	/**
	 * Construtor da classe que inicializa os mapas tidos como parametros.
	 */

	public ControllerPLS() {
		this.propostasDeLeis = new HashMap<>();
		this.numeroPL = new HashMap<>();
		this.numeroPLP = new HashMap<>();
		this.numeroPEC = new HashMap<>();

	}
	/**
	 * Cadastra o objeto PL de acordo com as informacoes recebidos como parametro. Caso esses parametros forem invalidos, lanca-se uma excecao.
	 * @param dni meio de identificao
	 * @param ano em que foi cadastrado
	 * @param ementa informacoes sobre os objetivos da proposta
	 * @param interesses relacionados a proposta
	 * @param url meio de documentacao
	 * @param conclusivo boolean relacionado a proposta ser ou nao conclusivo
	 * @return o codigo da proposta cadastrada.
	 */


	public String cadastrarPL(String dni, int ano, String ementa, String interesses, String url, boolean conclusivo) {
		validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
		validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual");
		validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

		String codigo = "PL " + contadorPL(ano) + "/" + ano;
		propostasDeLeis.put(codigo, new PL(dni, ano, ementa, interesses, url, conclusivo, codigo));
		return codigo;
	}
	/**
	 * Cadastra o objeto PLP de acordo com as informacoes recebidos como parametro. Caso esses parametros forem invalidos, lanca-se uma excecao.
	 * @param dni meio de identificao
	 * @param ano em que foi cadastrado
	 * @param ementa informacoes sobre os objetivos da proposta
	 * @param interesses relacionados a proposta
	 * @param url meio de documentacao
	 * @param artigos boolean relacionado a proposta ser ou nao conclusivo
	 * @return o codigo da proposta cadastrada.
	 */

	public String cadastrarPLP(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
		validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validadorString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual");
		validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

		String codigo = "PLP " + contadorPLP(ano) + "/" + ano;
		propostasDeLeis.put(codigo, new PLP(dni, ano, ementa, interesses, url, artigos, codigo));
		return codigo;

	}
	/**
	 * Cadastra o objeto PEC de acordo com as informacoes recebidos como parametro. Caso esses parametros forem invalidos, lanca-se uma excecao.
	 * @param dni meio de identificao
	 * @param ano em que foi cadastrado
	 * @param ementa informacoes sobre os objetivos da proposta
	 * @param interesses relacionados a proposta
	 * @param url meio de documentacao
	 * @param artigos boolean relacionado a proposta ser ou nao conclusivo
	 * @return o codigo da proposta cadastrada.
	 */

	public String cadastrarPEC(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		validadorString(dni, "Erro ao cadastrar projeto: autor nao pode ser vazio ou nulo");
		validadorDni(dni, "Erro ao cadastrar projeto: dni invalido");
		validadorString(ementa, "Erro ao cadastrar projeto: ementa nao pode ser vazia ou nula");
		validadorString(interesses, "Erro ao cadastrar projeto: interesse nao pode ser vazio ou nulo");
		validadorString(url, "Erro ao cadastrar projeto: url nao pode ser vazio ou nulo");
		validadorString(artigos, "Erro ao cadastrar projeto: artigo nao pode ser vazio ou nulo");
		validadorAnoFuturo(ano, "Erro ao cadastrar projeto: ano posterior ao ano atual");
		validadorAno(ano, "Erro ao cadastrar projeto: ano anterior a 1988");

		String codigo = "PEC " + contadorPEC(ano) + "/" + ano;
		propostasDeLeis.put(codigo, new PEC(dni, ano, ementa, interesses, url, artigos, codigo));
		return codigo;
	}
	/**
	 * Contador responsavel por quantificar o numero de propostas do Tipo PL com o ano recebido como parametro como sendo seu atributo
	 * @param ano forma de identificacao
	 * @return o numero de propostas
	 */

	private Integer contadorPL(Integer ano) {
		if (numeroPL.containsKey(ano)) {
			numeroPL.put(ano, numeroPL.get(ano) + 1);
			return numeroPL.get(ano);
		} else {
			numeroPL.put(ano, 0);
			return contadorPL(ano);
		}
	}
	/**
	 * Contador responsavel por quantificar o numero de propostas do Tipo PLP com o ano recebido como parametro como sendo seu atributo
	 * @param ano forma de identificacao
	 * @return o numero de propostas
	 */

	private Integer contadorPLP(Integer ano) {
		if (numeroPLP.containsKey(ano)) {
			numeroPLP.put(ano, numeroPLP.get(ano) + 1);
			return numeroPLP.get(ano);
		} else {
			numeroPLP.put(ano, 0);
			return contadorPLP(ano);
		}
	}
	/**
	 * Contador responsavel por quantificar o numero de propostas do Tipo PEC com o ano recebido como parametro como sendo seu atributo
	 * @param ano forma de identificacao
	 * @return o numero de propostas
	 */

	private Integer contadorPEC(Integer ano) {
		if (numeroPEC.containsKey(ano)) {
			numeroPEC.put(ano, numeroPEC.get(ano) + 1);
			return numeroPEC.get(ano);
		} else {
			numeroPEC.put(ano, 0);
			return contadorPEC(ano);
		}
	}

	/**
	 * Exibe o projeto que se refere a String codigo passada como parametro
	 * 
	 * @param codigo meio de identificacao do projeto
	 * @return o toString do projeto relacionado
	 */
	public String exibirProjeto(String codigo) {
		return propostasDeLeis.get(codigo).toString();
	}
	/**
	 * Verfica se a proposta legislativa eh conclusiva.
	 * @return boolean confirmando ou nao a conclusao
	 */
	public boolean verificaBooleanConclusivo(String codigo) {
		return this.propostasDeLeis.get(codigo).verificaBooleanConclusivo();
	}
	/**
	 * Retorna o mapa contendo todas as propostas ja cadastradas
	 * @return o mapa de PLS
	 */
	public HashMap<String, PropostaLegislativa> getPropostasDeLeis() {
		return propostasDeLeis;
	}
	/**
	 * Retorna os interesses da proposta que possue o codigo recebido como parametro
	 * @param codigo meio de identificacao da proposta
	 * @return os interesses
	 */
	public String getInteressesRelacionados(String codigo) {
		return propostasDeLeis.get(codigo).getInteressesRelacionados();
	}
	/**
	 * Verifica se ha um quorum minimo relacionando os deputados presentes com o total.
	 * @param deputadosPresentes deputados que estao presentes atuantes
	 * @param totalDeDeputados total de deputados.
	 */
	public void quorumMininimo(String codigo, int deputadosPresentes, int totalDeDeputados) {
		propostasDeLeis.get(codigo).quorumMininimo(deputadosPresentes, totalDeDeputados);
	}

	/**
	 * Exibe a tramitacao. Retorna de acordo com a tramitacao da proposta que possue o codigo passado como parametro.
	 * @param codigo relacionado a identificacao da proposta
	 * @return saida
	 */

	public String exibirTramitacao(String codigo) {
		String complemento = "";

		if (!(propostasDeLeis.get(codigo).getSituacaoAtual().contains("ARQUIVADO"))
				&& !(propostasDeLeis.get(codigo).getSituacaoAtual().contains("APROVADO"))
				&& !(propostasDeLeis.get(codigo).exibirTramitacao(codigo).equals("EM VOTACAO (CCJC)"))) {
			complemento = ", " + propostasDeLeis.get(codigo).getSituacaoAtual();
//            proximoLocal = plenario, mas tramitacao tem que ser Plenario.
			String complemento1[] = complemento.split("plenario");
			if (complemento1.length == 2) {
				complemento = ", EM VOTACAO (Plenario)";
			}
		}
		return propostasDeLeis.get(codigo).exibirTramitacao(codigo) + complemento;
	}

	/**
	 * Declara um mapa que armazenara as estrategias envolvidas no processo de votacao
	 */
	
	public Map<String, String> estrategia;

	/**
	 * Configura a estrategia recebida como parametro
	 * @param dni meio de identificacao da estrategia do Deputado relacionado
	 * @param estrategia String contendo a estrategia do Deputado.
	 */
	
	public void configuraEstrategiaProposta(String dni, String estrategia) {
		switch (estrategia) {
		case "CONSTITUCIONAL":
			break;
		case "CONCLUSAO":
			break;
		case "APROVACAO":
			break;
		default:
			throw new IllegalArgumentException("Erro ao configurar estrategia: estrategia invalida");
		}

	}
	/**
	 * Metodo que funciona pegando a proposta relacionada ao objeto Deputado que tem o dni recebido como parametro.
	 * @param dni meio de identificacao do objeto Deputadp
	 * @param pessoa mapa de pessoas
	 * @param leis leis relacionadas
	 * @return a proposta relacionada
	 */

	public String pegarPropostaRelacionada(String dni, Map<String, Pessoa> pessoa,Map<String, PropostaLegislativa> leis) {
		estrategia = new HashMap<>();
		for(Map.Entry<String,Pessoa> entry2 : pessoa.entrySet()) {
			this.estrategia.put(entry2.getKey(),"CONSTITUCIONAL");
		}
		
		String retorno = "";
		String[] interesses = pessoa.get(dni).getInteresses().trim().split(",");
		if(this.estrategia.get(dni).equals("CONSTITUCIONAL")) {
		for (Map.Entry<String, PropostaLegislativa> entry : leis.entrySet()) {
			for (int i = 0; i < interesses.length; i++) {
				if (interesses[i].equals(entry.getValue().getInteressesRelacionados())) {
					if (entry.getKey().substring(0, 3).equals("PEC") ) {
						return entry.getValue().getCodigo();
					}
					else if (entry.getKey().substring(0, 3).equals("PLP")) {
						retorno = entry.getValue().getCodigo();
					} 
					else if (entry.getKey().substring(0, 2).equals("PL")) {
						retorno = entry.getValue().getCodigo();
					}
				}
			}
			
		}
	}
		if(this.estrategia.get(dni).equals("CONCLUSAO")) {
			
		}
	return retorno;

	}
	/**
	 * Método de gravação de mapa de pls, o objeto é gravado após o sistema ser fechado.
	 * @param map, mapa de comissoes.
	 * @param arquivo, nome do arquivo de destino.
	 */

	public void escreverArquivos(Map<String, PropostaLegislativa> map, String arquivo) {

		FileOutputStream arquivoPLS;

		try {
			arquivoPLS = new FileOutputStream(arquivo);
			ObjectOutputStream gravarPLS = new ObjectOutputStream(arquivoPLS);
			gravarPLS.writeObject(map);
			gravarPLS.flush();
			gravarPLS.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método de recuperação de mapa gravado.
	 * @param arquivo, nome do arquivo onde os dados serão buscados.
	 * @return o mapa com as informacoes gravadas
	 */

	public Map<String, PropostaLegislativa> lerArquivos(String arquivo) {
		File arquivoPLS = null;
		arquivoPLS = new File(arquivo);
		Map<String, PropostaLegislativa> map = new HashMap<>();
		FileInputStream fis;

		try {
			if (!arquivoPLS.exists()) {
				arquivoPLS.createNewFile();
			} else if (arquivoPLS.length() == 0) {
				System.out.println("ARQUIVO VAZIO");

			} else {
				fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(fis);
				map = (HashMap<String, PropostaLegislativa>) ois.readObject();
				ois.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * Inicia um novo mapa de propostasDeLeis para limpar o sistema.
	 */

	public void limpar() {
		this.propostasDeLeis = new HashMap<>();
	}
}
