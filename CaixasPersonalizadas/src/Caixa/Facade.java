package Caixa;

public class Facade {
    private ControllerCaixas controladorPrincipal;

    public Facade(){
        this.controladorPrincipal = new ControllerCaixas();
    }

    public static void main(String[] args) {
        ControllerCaixas conC = new ControllerCaixas();

        conC.AdicionaCaixa("oi", "arte em tecido", "Retangular", "10,7");
        conC.AdicionaCaixa("ola", "arte em tecido", "Circular", "20");
        conC.AdicionaCaixa("iai", "Colagem", "Retangular", "10,9");
        conC.AdicionaCaixa("opa", "Colagem", "Circular", "10");
        conC.AdicionaCaixa("men", "pintura a mao", "Pentagonal", "15");

        System.out.println(conC.numerosDeCaixas());
        System.out.println(conC.exibeCaixaEspecifica("arte em tecido", "Retangular"));
        System.out.println(conC.exibeCaixasComFormatoEspecifico("Retangular"));
        System.out.println(conC.exibeCaixasComFormatoEspecifico("Circular"));
        System.out.println(conC.exibeCaixasComFormatoEspecifico("Pentagonal"));

        conC.modificaPersonalizacao("oi", "pintura a mao");

        System.out.println(conC.exibeCaixasComPersonalizacaoEspecifica("pintura a mao"));

        System.out.println(conC.exibeCaixasComPersonalizacaoEspecifica("Colagem"));
        System.out.println(conC.rendimentoTotal());

        conC.removeCaixa("men");
        System.out.println(conC.numerosDeCaixas());
        System.out.println(conC.rendimentoTotal());






    }

    public void adicionaCaixa(String descricao, String personalizacao, String formato, String dimencoes){
        this.controladorPrincipal.AdicionaCaixa(descricao, personalizacao, formato, dimencoes);
    }

    public void modificaPersonalizacao(String descricao, String novaPersonalizacao){
        this.controladorPrincipal.modificaPersonalizacao(descricao, novaPersonalizacao);
    }

    public void removeCaixa(String descricao){
        this.controladorPrincipal.removeCaixa(descricao);
    }

    public int numeroDeCaixas(){
        return this.controladorPrincipal.numerosDeCaixas();
    }

    public String exibeCaixaEspecifica(String personalizacao, String formato){
        return controladorPrincipal.exibeCaixaEspecifica(personalizacao, formato);
    }

    public String ExibeCaixasComPersonalizacaoEspecifica (String personalizacao){
        return controladorPrincipal.exibeCaixasComPersonalizacaoEspecifica(personalizacao);
    }

    public String exibeCaixasComFormatoEspecifico (String formato){
        return controladorPrincipal.exibeCaixasComFormatoEspecifico(formato);
    }

    public double RendimentoTotal(){
        return this.controladorPrincipal.rendimentoTotal();
    }
}
