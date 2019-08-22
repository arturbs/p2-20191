package ECO.PropostasLegislativas;

/**
 * Classe responsavel por criar o objeto PEC que se faz filha da super classe PropostaLegislativa. Se baseia nos atributos da super classe acompanhado do atributo artigo especifico da classe.
 * @autor Artur Brito
 */
public class PEC extends PropostaLegislativa {
    /**
     * Atributo responsavel por armazenar o artigo caracteristico da proposta legislativa PEC
     */
    private String artigo;

    /**
     * Construtor da classe a partir dos atributos gerais da classe mae com o atributo artigo especifico da classe PEC.
     * @param DNIAutor dni do autor da proposta legislativa relacionada
     * @param ano ano em que a proposta legistaliva foi inicializada
     * @param ementa objetivos da proposta legislativa
     * @param interessesRelacionados interesses relacionados a proposta legislativa
     * @param url forma padronizada de representacao do documento relacionado a proposta legislativa
     * @param artigo artigo especifico da classe PEC
     * @param codigo codigo da proposta legislativa
     */

    public PEC(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, String artigo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.artigo = artigo;

    }

    /**
     * Retorna o artigo da proposta legislativa do tipo PEC
     * @return o artigo relacionado ao objeto PEC
     */

    public String getArtigo() {
        String saida = "";
        String[] artigos = this.artigo.split(",");
        for ( int i = 0; i < artigos.length; i++ ) {
            saida += artigos[i] + ", ";
        }
        saida = saida.substring(0, saida.length() - 2);
        return saida;
    }

    /**
     * Representacao textual do objeto PEC
     * @return representacao textual do objeto PEC
     */

    @Override
    public String toString() {
        return "Projeto de Emenda Constitucional - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + " - " + getArtigo() + " - " + getSituacaoAtual();
    }

    /**
     * Verfica se a proposta legislativa eh conclusiva.
     * @return boolean confirmando ou nao a conclusao
     */
    @Override
    public boolean verificaBooleanConclusivo() {
        return false;
    }

    /**
     * Verifica se ha um quorum minimo relacionando os deputados presentes com o total.
     * @param deputadosPresentes deputados que estao presentes atuantes
     * @param totalDeDeputados total de deputados.
     */

    @Override
    public void quorumMininimo(int deputadosPresentes, int totalDeDeputados) {
        if (!(deputadosPresentes >= Math.floor((totalDeDeputados * 3 / 5) + 1))) {
            throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
        }
    }
    /**
     * Exibe a tramitacao. Retorna de acordo com a tramitacao da proposta que possue o codigo passado como parametro.
     * @param codigo identificacao da proposta
     * @return saida
     */

    @Override
    public String exibirTramitacao(String codigo) {
        String saida = getTramitacao();

        if ( saida.equals("")) {
            throw new IllegalArgumentException("Isso nem existe");
        }
        if ( saida.equals("EM VOTACAO (CCJC)")){
            return saida;
        }
        String saidaFinal = saida.substring(19);
        return saidaFinal;
    }


}

