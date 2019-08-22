package ECO.Comissao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static ECO.Util.Validador.validadorString;

/**
 *  Classe responsavel por controlar todas as acoes relacionadas ao objeto Comissao armazenando-os em uma colecao para melhor administracao
 * @autor Luciano Erick
 * @autor Ana Carolina Chaves
 */

public class ControllerComissao implements Serializable {
    /**
     * Atributo responsavel por armazenar os objetos Comissoes cadastrados;
     */

    private Map<String, Comissao> mapaComissoes;

    /**
     * Construtor da classe ControllerComissao que inicializar o mapaComissoes responsavel por armazenar os objetos cadastrados
     */

    public ControllerComissao() {
        this.mapaComissoes = new HashMap<>();
    }

    /**
     * Retorna o atributo da classe ControllerComissao com os objetos Comissao que foram cadastrados
     * @return o mapa com as comissoes ja cadastradas
     */

    public Map<String, Comissao> getMapaComissoes() {
        return mapaComissoes;
    }

    /**
     * Cadastra os objetos a partir dos parametros. Caso os parametros forem null ou vazio, uma excecao sera lancada. Se o tema ja estiver cadastrado, uma excecao tambem sera lancada
     * @param tema o tema responsavel como identificacao do objeto Comissao cadastrado
     * @param dniPoliticos String que carrega os dnis dos politicos participantes do objeto Comissao
     */

    public void cadastrarComissao(String tema, String dniPoliticos) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        validadorString(dniPoliticos, "Erro ao cadastrar comissao: lista de politicos nao pode ser vazio ou nulo");
        this.mapaComissoes.put(tema, new Comissao(tema, dniPoliticos));
    }

    /**
     * Verifica se o objeto Comissao com o tema passado como parametro contem no mapa de comissoes. Caso contrario, lanca-se uma excecao.
     * @param tema meio de identificacao do objeto Comissao.
     * @param mensagem que sera lancada caso o objeto Comissao nao exista no mapa comissao
     */

    public void verificaComissao(String tema, String mensagem) {
        validadorString(tema, "Erro ao cadastrar comissao: tema nao pode ser vazio ou nulo");
        if (!this.mapaComissoes.containsKey(tema)) {
            throw new IllegalArgumentException(mensagem);
        }
    }

    /**
     * Método de gravação de mapa de commisao, o objeto é gravado após o sistema ser fechado.
     * @param map, mapa de comissoes.
     * @param arquivo, nome do arquivo de destino.
     */

    public void escreverArquivos(Map<String, Comissao> map, String arquivo){
        FileOutputStream arquivoComissao;
        try {
            arquivoComissao = new FileOutputStream(arquivo);
            ObjectOutputStream gravarComissao = new ObjectOutputStream(arquivoComissao);
            gravarComissao.writeObject(map);
            gravarComissao.flush();
            gravarComissao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Método de recuperação de mapa gravado.
     * @param arquivo, nome do arquivo onde os dados serão buscados.
     * @return, retorna um mapa de comissao gravado anteriormente.
     */

    public Map<String, Comissao> lerArquivos (String arquivo){
        File arquivoComissao = null;
        arquivoComissao = new File(arquivo);
        Map<String, Comissao> map = new HashMap<>();
        FileInputStream fis;
        try {
            if (!arquivoComissao.exists()) {
                arquivoComissao.createNewFile();
            }
            else if (arquivoComissao.length() == 0) {
                System.out.println("ARQUIVO VAZIO");

            }else{
                fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (Map<String, Comissao>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Inicializa outro mapa de comissoes em prol da limpeza do sistema.
     */
    public void limpar() {

        this.mapaComissoes = new HashMap<>();
    }
}
