package Caixa;

import Util.Validador;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControllerCaixas {

    private HashMap<String, CaixaAbstract> estoqueCaixas;

    public ControllerCaixas(){
        this.estoqueCaixas = new HashMap<>();
    }


    public void AdicionaCaixa(String descricao, String personalizacao, String formato, String dimencoes){

        Validador.ValidaStringNullEVazia(descricao, "");
        Validador.ValidaStringNullEVazia(personalizacao, "");
        Validador.ValidaStringNullEVazia(formato, "");
        Validador.ValidaStringNullEVazia(dimencoes, "");

        if ( estoqueCaixas.containsValue(descricao)){
            throw new IllegalArgumentException("Descricao Unica ja cadastrada");
        }

        if (formato.trim().equals("Pentagonal")){
            if (dimencoes.split(",").length > 1){
                throw new IllegalArgumentException("Dimensoes erradas");
            }
            else {
                CaixaAbstract cp = new CaixaPentagonal(descricao, personalizacao, formato, dimencoes);
                this.estoqueCaixas.put(descricao, cp);
            }
        }

        if (formato.trim().equals("Retangular")) {
            if (dimencoes.split(",").length > 2){
                throw new IllegalArgumentException("Dimensoes erradas");
            }
            else {
                CaixaAbstract cr = new CaixaRetangulo(descricao, personalizacao, formato, dimencoes);
                this.estoqueCaixas.put(descricao, cr);
            }
        }

        if (formato.trim().equals("Circular")) {
            if (dimencoes.split(",").length > 1){
                throw new IllegalArgumentException("Dimensoes erradas");
            }
            else {
                CaixaAbstract cc = new CaixaCircular(descricao, personalizacao, formato, dimencoes);
                this.estoqueCaixas.put(descricao, cc);
            }
        }
    }

    public void modificaPersonalizacao(String descricao, String novaPersonalizacao){
        Validador.ValidaStringNullEVazia(novaPersonalizacao, "");
        Validador.ValidaStringNullEVazia(descricao, "");


        this.estoqueCaixas.get(descricao).setPersonalizacao(novaPersonalizacao);
    }

    public void removeCaixa (String descricao){
        Validador.ValidaStringNullEVazia(descricao, "Descricao invalida");

        this.estoqueCaixas.remove(descricao);
    }

    public int numerosDeCaixas(){
        return this.estoqueCaixas.size();
    }

    public String exibeCaixaEspecifica(String personalizacao, String formato){
        Validador.ValidaStringNullEVazia(personalizacao, "personalizacao invalida");
        Validador.ValidaStringNullEVazia(formato, "formato invalida");


        String saida = "";

        List<CaixaAbstract> CaixaList = new ArrayList<>(estoqueCaixas.values());

        for (CaixaAbstract caixas : CaixaList) {
            if (caixas.getPersonalizacao().equals(personalizacao) && caixas.getFormato().equals(formato)){
                 saida += caixas.toString() + " | ";
            }
        }
        return saida.substring(0, saida.length() - 3);
    }

    public String exibeCaixasComPersonalizacaoEspecifica (String personalizacao){
        Validador.ValidaStringNullEVazia(personalizacao, "personalizacao invalida");

        String saida = "";

        List<CaixaAbstract> CaixaList = new ArrayList<>(estoqueCaixas.values());

        for (CaixaAbstract caixas : CaixaList) {
            if (caixas.getPersonalizacao().equals(personalizacao)){
                saida += caixas.toString() + " | ";
            }
        }
        return saida.substring(0, saida.length() - 3);
    }

    public String exibeCaixasComFormatoEspecifico (String formato){
        Validador.ValidaStringNullEVazia(formato, "formato invalida");

        String saida = "";

        List<CaixaAbstract> CaixaList = new ArrayList<>(estoqueCaixas.values());

        for (CaixaAbstract caixas : CaixaList) {
            if (caixas.getFormato().equals(formato)){
                saida += caixas.toString() + " | ";
            }
        }
        return saida.substring(0, saida.length() - 3);
    }

    public double rendimentoTotal() {
        double saida = 0;
        List<CaixaAbstract> CaixaList = new ArrayList<>(this.estoqueCaixas.values());


        for (CaixaAbstract caixa : CaixaList){
            saida += caixa.getPreco();
//            DecimalFormat df = new DecimalFormat("#0,00");
//            saida = Double.parseDouble(df.format(saida));
        }
        return saida;
    }

}
