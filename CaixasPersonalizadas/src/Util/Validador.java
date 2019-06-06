package Util;

public class Validador {

    public static void ValidaStringNullEVazia(String parametro, String mensagem) {
        if (parametro == null || parametro.trim().equals("")){
            throw new IllegalArgumentException(mensagem);
        }
    }

    public static void ValidaDimensao(Double parametro, String mensagem) {
        if (parametro <= 0) {
            throw new IllegalArgumentException(mensagem);
        }
    }
}
