package ECO.Votacao;

import ECO.Comissao.Comissao;
import ECO.Pessoa.Deputado;
import ECO.PropostasLegislativas.PropostaLegislativa;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.Serializable;
import java.util.*;

import static ECO.Util.Validador.validadorString;

/**
 * Classe responsavel por gerenciar as votacoes contidas no programa
 * @autor Artur Brito
 * @autor Gutemberg Filho
 */

public class ControllerVotacao implements Serializable {
    /**
     * Metodo relacionada a votacao da comissao relacionada de acordo com as informacoes dadas como parametro. Caso algum parametro seja invalido, uma excecao sera lancada.
     * @param codigo da proposta relacionada
     * @param statusGovernista status relacionado ao governo
     * @param proximoLocal onde a comissao sera encaminhada
     * @param comissoes mapa contendo as comissoes cadastradas
     * @param propostasLegislativas propostas emvolvidas
     * @param deputados deputados relacionados no mapa
     * @param partidosBase lista de partidos relacionados
     * @param interessesRelacionados interesses da comissao
     * @return boolean de acordo com o resultado da votacao
     */

    public boolean votarComissao(String codigo, String statusGovernista, String proximoLocal, Map<String, Comissao> comissoes, HashMap<String,
            PropostaLegislativa> propostasLegislativas, Map<String, Deputado> deputados, String partidosBase, String interessesRelacionados) {

        validadorString(statusGovernista, "Erro ao votar proposta: status invalido");

        boolean aprovacao = false;
        if (!comissoes.containsKey("CCJC")) {
            throw new IllegalArgumentException("Erro ao votar proposta: CCJC nao cadastrada");
        }

        validadorString(proximoLocal, "Erro ao votar proposta: proximo local vazio");

        if (!statusGovernista.equals("GOVERNISTA") && !statusGovernista.equals("OPOSICAO")
                && !statusGovernista.equals("LIVRE")) {
            throw new IllegalArgumentException("Erro ao votar proposta: status invalido");
        }
        if (!propostasLegislativas.containsKey(codigo)) {
            throw new IllegalArgumentException("Erro ao votar proposta: projeto inexistente");
        }

        if (propostasLegislativas.get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || propostasLegislativas.get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }

        String[] situacaoAtual = propostasLegislativas.get(codigo).getSituacaoAtual().split("VOTACAO");
        String localAtual = situacaoAtual[1].substring(2, situacaoAtual[1].length() - 1);

        if (localAtual.contains("Plenario") || localAtual.contains("plenario")) {
            throw new IllegalArgumentException("Erro ao votar proposta: proposta encaminhada ao plenario");
        }

        if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) && statusGovernista.equals("GOVERNISTA")) {

            aprovacao = true;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", APROVADO (" + localAtual + ")");

            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() && (!localAtual.equals("CCJC"))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }

        } else if (!(aprovaGoverno(localAtual, partidosBase, comissoes, deputados)) && statusGovernista.equals("GOVERNISTA")) {

            aprovacao = false;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", REJEITADO (" + localAtual + ")");

            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }
            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo()) {
                propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");

            }
        }

        else if (aprovaGoverno(localAtual, partidosBase, comissoes, deputados) && statusGovernista.equals("OPOSICAO")) {

            aprovacao = false;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", REJEITADO (" + localAtual + ")");


            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo()) {
                propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");
            }


        } else if (!(aprovaGoverno(localAtual, partidosBase, comissoes, deputados)) && statusGovernista.equals("OPOSICAO")) {

            aprovacao = true;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", APROVADO (" + localAtual + ")");


            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() && (!localAtual.equals("CCJC"))) {

                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }

        }


        else if (statusGovernista.equals("LIVRE") && verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados) ) {

            aprovacao = true;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao(propostasLegislativas.get(codigo).getTramitacao() + ", APROVADO (" + localAtual + ")");



            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }

            if (propostasLegislativas.get(codigo).verificaBooleanConclusivo() && !localAtual.equals("CCJC")) {
                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }
        }
        else if (!verificaInteresse(localAtual, comissoes, deputados, propostasLegislativas, interessesRelacionados) && statusGovernista.equals("LIVRE")) {

            aprovacao = false;

            propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (" + proximoLocal + ")");

            propostasLegislativas.get(codigo).setTramitacao(propostasLegislativas.get(codigo).getTramitacao() + ", REJEITADO (" + localAtual + ")");


            if (proximoLocal.equals("plenario") && (!codigo.contains("PL "))) {
                propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - 1o turno)");

            }


            if (!(propostasLegislativas.get(codigo).verificaBooleanConclusivo())) {
                propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");

            }
        }
        return aprovacao;
    }
    /**
     * Metodo relacionada a votacao do plenario relacionada de acordo com as informacoes dadas como parametro. Caso algum parametro seja invalido, uma excecao sera lancada.
     * @param codigo da proposta relacionada
     * @param statusGovernista status relacionado ao governo
     * @param presentes deputados que partipara
     * @param comissoes mapa contendo as comissoes cadastradas
     * @param propostasLegislativas propostas emvolvidas
     * @param deputados deputados relacionados no mapa
     * @param partidosBase lista de partidos relacionados
     * @param interessesRelacionados interesses da comissao
     * @return boolean de acordo com o resultado da votacao
     */


    public boolean votarPlenario(String codigo, String statusGovernista, String presentes, Map<String, Comissao> comissoes,
                                 HashMap<String, PropostaLegislativa> propostasLegislativas, Map<String, Deputado> deputados,
                                 String partidosBase, String interessesRelacionados) {

        boolean aprovacao = false;
        int turno;

        if (propostasLegislativas.get(codigo).getSituacaoAtual().contains("1")) {
            turno = 1;
        }
        else {
            turno = 2;
        }


        if (propostasLegislativas.get(codigo).getSituacaoAtual().equals("ARQUIVADO")
                || propostasLegislativas.get(codigo).getSituacaoAtual().equals("APROVADO")) {
            throw new IllegalArgumentException("Erro ao votar proposta: tramitacao encerrada");
        }

        if(plenarioDiferenciacao(codigo, statusGovernista, presentes, comissoes, propostasLegislativas, deputados, partidosBase)) {
        	aprovacao = true;
        	propostasLegislativas.get(codigo).setSituacaoAtual("EM VOTACAO (Plenario - " + (turno + 1) + "o turno)");

        	if (codigo.contains("PL ")) {
                propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", APROVADO (" + "Plenario" + ")");
            }
        	else {
                propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", APROVADO (" + "Plenario - " + turno + "o turno)");
            }


            if (propostasLegislativas.get(codigo).getSituacaoAtual().contains("3") || codigo.contains("PL ")) {
                propostasLegislativas.get(codigo).setSituacaoAtual("APROVADO");
                String dniAutor = propostasLegislativas.get(codigo).getDNIAutor();
                deputados.get(dniAutor).adicionaLei();
            }

        }
        else {
            aprovacao = false;
            propostasLegislativas.get(codigo).setSituacaoAtual("ARQUIVADO");
            if (codigo.contains("PL ")) {
                propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", REJEITADO (" + "Plenario" + ")");
            }
            else {
                propostasLegislativas.get(codigo).setTramitacao( propostasLegislativas.get(codigo).getTramitacao() + ", REJEITADO (" + "Plenario - " + turno + "o turno)");
            }
        }

        return aprovacao;
    }
    /**
     * Aprova o governo de acordo com as informacoes dadas como parametros.
     * @param comissaoAtual comissao atual
     * @param base1
     * @param comissoes relacionadas ao governo no mapa
     * @param deputados relacionados ao governo no mapa
     * @return
     */


    private boolean aprovaGoverno(String comissaoAtual, String base1, Map<String, Comissao> comissoes, Map<String, Deputado> deputados) {

        String[] base = base1.trim().split(",");
        Set<String> listaDni = comissoes.get(comissaoAtual).getListaDNI();
        int baseGov = 0;
        int oposicao = 0;
        for (String F : listaDni) {
            for (int j = 0; j < base.length; j++) {
                if (base[j].equals(deputados.get(F).getPartido())) {
                    baseGov += 1;
                } else {
                    oposicao += 1;
                }
            }
        }
        return baseGov > oposicao;
    }

    /**
     * Serve para verificar se as comissoes e os deputados relacionados possuem o mesmo interesse
     * @param comissaoAtual
     * @param comissoes mapa de comissao
     * @param deputados mapa de deputado
     * @param propostasLegislativas mapa com as propotas
     * @param interessesRelacionadas interesses dos deputados
     * @return
     */

    private boolean verificaInteresse(String comissaoAtual, Map<String, Comissao> comissoes, Map<String, Deputado> deputados,
                                      HashMap<String, PropostaLegislativa> propostasLegislativas, String interessesRelacionadas) {

        Set<String> listaDni = comissoes.get(comissaoAtual).getListaDNI();
        String[] interesse = interessesRelacionadas.trim().split(",");
        int aceita = 0;
        int rejeita = 0;
        for (int j = 0; j < interesse.length; j++) {
            for (String F : listaDni) {
                String[] interesseDNI = deputados.get(F).getInteresses().trim().split(",");
                for (int l = 0; l < interesseDNI.length; l++) {
                    if (interesseDNI[l].equals(interesse[j]))
                        aceita += 1;
                }

            }
            rejeita += 1;
        }

        if (aceita > rejeita) {
            return true;
        }
        return false;
    }
    /**
     * Aprova o plenario governista de acordo com os deputados presentes e o mapa contendo eles.
     * @param presentes
     * @param base1
     * @param deputados
     * @return inteiro de acordo com a aprovacao do plenario governista
     */
    
    private int aprovaPlenarioGovernista(String presentes, String base1, Map<String,Deputado> deputados) {
    	String[] listaPresentes = presentes.trim().split(",");
    	String[] base = base1.trim().split(",");
    	
    	
    	int baseGov = 0;
    	
    	for(int i = 0; i< listaPresentes.length; i++) {
    		for(int j = 0;j < base.length; j++) {
    			if(deputados.get(listaPresentes[i]).getPartido().equals(base[j])) {
    				baseGov += 1;
    			}
    		}
    	}

    	return baseGov;
    }
    /**
     * Aprova o Plenario Livre em relacao a String com presentes e o mapa contendo os deputados participantes
     * @param presentes deputados participantes
     * @param deputados mapa com todos os deputados
     * @param interessesRelacionados interesses relacionados
     * @return int relacionado a aprovacao do plenario livre
     */

    private int aprovaPlenarioLivre (String presentes, Map<String,Deputado> deputados, String interessesRelacionados) {
        String[] listaPresentes = presentes.trim().split(",");
        String[] interesse = interessesRelacionados.trim().split(",");

        int aprova = 0;

        for (int j = 0; j < interesse.length; j++) {
            for (String F : listaPresentes) {
                String[] interesseDNI = deputados.get(F).getInteresses().trim().split(",");
                for (int l = 0; l < interesseDNI.length; l++) {
                    if (interesseDNI[l].equals(interesse[j]))
                        aprova += 1;
                }
            }
        }
        return aprova;
    }
    /**
     * Formacao do plenario diferenciacao relacionando aos varios tipos de Propostas Legislativas.
     * @param codigo
     * @param statusGovernista
     * @param presentes
     * @param comissoes
     * @param propostasLegislativas
     * @param deputados
     * @param partidosBase
     * @return
     */

    private boolean plenarioDiferenciacao (String codigo, String statusGovernista, String presentes, Map<String, Comissao> comissoes, HashMap<String, PropostaLegislativa> propostasLegislativas, Map<String, Deputado> deputados, String partidosBase) {
        String[] listaPresentes = presentes.trim().split(",");
        String[] base = partidosBase.trim().split(",");

        if (codigo.contains("PL ")) {
            int meta = (int) Math.round(Math.floor(listaPresentes.length/2)+1);

            if (statusGovernista.equals("LIVRE")) {
                if (aprovaPlenarioLivre(presentes, deputados, propostasLegislativas.get(codigo).getInteressesRelacionados()) >= meta) {
                    return true;
                }

            }
            else if ((aprovaPlenarioGovernista(presentes, partidosBase, deputados)) >= meta) {
                return true;
            }
        }

        if (codigo.contains("PLP")) {

            int meta = (int) Math.round(Math.floor(deputados.size()/2)+1);

            if (statusGovernista.equals("LIVRE")) {
                    if (aprovaPlenarioLivre(presentes, deputados, propostasLegislativas.get(codigo).getInteressesRelacionados()) >= meta) {
                        return true;
                    }
            }
            else if ((aprovaPlenarioGovernista(presentes, partidosBase, deputados)) >= meta) {
                return true;
            }
        }

        if (codigo.contains("PEC")) {

            int meta = (int) Math.round(Math.floor(deputados.size() * 3 / 5)+1);
            if (statusGovernista.equals("LIVRE")) {
                if (aprovaPlenarioLivre(presentes, deputados, propostasLegislativas.get(codigo).getInteressesRelacionados()) >= meta) {
                    return true;
                }
            }
            else if ((aprovaPlenarioGovernista(presentes, partidosBase, deputados)) >= meta) {
                return true;
            }
        }
        return false;
    }

}
