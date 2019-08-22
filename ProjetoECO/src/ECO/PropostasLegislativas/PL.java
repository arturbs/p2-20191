package ECO.PropostasLegislativas;

/**
 * Classe responsavel por criar o objeto PL que se faz filha da super classe PropostaLegislativa. Se baseia nos atributos gerais da classe mae adicionados do atribut boolean Conclusivo e o int numeroPL que se inicia como sendo igual a 1
 * @autor Artur Brito
 */

public class PL extends PropostaLegislativa {
    /**
     * Atributo boolean para verificar se relaciona com uma proposta conclusiva ou nao
     */

    private boolean Conclusivo;

    /**
     * Construtor da classe PL com parametros da classe mae e os atributos especificos da classe PL
     * @param DNIAutor dni do autor da proposta legislativa
     * @param ano ano em que a proposta legislativa foi criada
     * @param ementa os objetivos relacionados a proposta legislativa
     * @param interessesRelacionados interesses compostos a proposta legislativa
     * @param url endereco do documento relacionado
     * @param conclusivo boolean verificando referido a confirmacao da conclusao do proposta legislativa
     * @param codigo codigo relacionado a proposta legislativa
     */

    public PL(String DNIAutor, int ano, String ementa, String interessesRelacionados, String url, boolean conclusivo, String codigo) {
        super(DNIAutor, ano, ementa, interessesRelacionados, url, codigo);
        this.Conclusivo = conclusivo;
    }

    /**
     * Verifica se a proposta legistativa relacionada eh conclusiva ou nao
     * @return boolean com a confirmacao ou nao da conclusao
     */

    public String isConclusivo() {
        if ( this.Conclusivo == true) {
            return " - Conclusiva";
        }
        return "";

    }

    /**
     * Representacao textual do objeto PL relacionado
     * @return representacao textual
     */

    @Override
    public String toString() {
        return "Projeto de Lei - " + getCodigo() + " - " + getDNIAutor() + " - " + getEmenta() + isConclusivo() + " - " + getSituacaoAtual();
    }
    /**
     * Verfica se a proposta legislativa eh conclusiva.
     * @return boolean confirmando ou nao a conclusao
     */

    @Override
    public boolean verificaBooleanConclusivo() {
        return this.Conclusivo;
    }
    /**
     * Verifica se ha um quorum minimo relacionando os deputados presentes com o total.
     * @param deputadosPresentes deputados que estao presentes atuantes
     * @param totalDeDeputados total de deputados.
     */

    @Override
    public void quorumMininimo(int deputadosPresentes, int totalDeDeputados) {
        if (!(deputadosPresentes >= Math.floor((totalDeDeputados / 2) + 1))) {
            throw new IllegalArgumentException("Erro ao votar proposta: quorum invalido");
        }
    }
    /**
     * Exibe a tramitacao. Retorna de acordo com a tramitacao da proposta que possue o codigo passado como parametro.
     * @param codigo relacionado a identificacao da proposta
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
