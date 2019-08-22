package ECO.Util;

/**
 * Classe Conversoes que serve para unicamente resolver convercoes de data
 * @autor Artur Brito
 */

public class  Conversoes {
    /**
     * Converte a data recebida como parametro para forma convencional.
     * @param dataDeInicio parametro de inicio de atuacao do Deputado relacionado
     * @return a data convertida
     */

    public static String converteData(String dataDeInicio) {
        String aux = "";
        char[] array = dataDeInicio.toCharArray();
        for(int i=0; i<array.length; i++) {
            if(i == 1 || i == 3) {
                aux += array[i] + "/";
            }else {
                aux += array[i];
            }
        }
        dataDeInicio=aux;
        return dataDeInicio;
    }

}
