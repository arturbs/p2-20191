package util;

public class Validador {
    public static void validaStringNull(String parametro, String mensagem) {
        if (parametro == null) {
            throw  new IllegalArgumentException(mensagem);
        }
    }

    public static void validaStringVazia(String parametro, String mensagem) {
        if (parametro.trim().equals("")) {
            throw  new IllegalArgumentException(mensagem);
        }
    }

    public  static void validaTamanhoString(String parametro, int tamanhoMinimoAceitavel, int tamanhoMaximoAceitavel, String mensagem ) {
        if (parametro.length() < tamanhoMinimoAceitavel || parametro.length() > tamanhoMaximoAceitavel){
            throw new IllegalArgumentException(mensagem);
        }
    }
}
