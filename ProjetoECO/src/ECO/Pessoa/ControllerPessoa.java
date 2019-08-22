package ECO.Pessoa;

import ECO.Comissao.Comissao;

import java.io.*;
import java.util.*;

import static ECO.Util.Validador.*;

/**
 * Classe ControllerPessoa que serve para armazenar os objetos Pessoa e objetos Deputado.
 * @autor Ana Carolina Chaves
 * @autor Luciano Erick
 * @autor Artur Brito
 * @autor Gutemberg Filho
 */

public class ControllerPessoa implements Serializable {
    /**
     * Atributo que refere-se ao mapa para armazenar objetos Pessoa.
     */
    private Map<String ,Pessoa> pessoas;
    private List<String> partidos;
    private Map<String, Deputado> deputados;

    /**
     * Construtor da classe ControllerPessoa inicializa o mapa de pessoas cadastradas.
     */

    public ControllerPessoa() {
        this.pessoas = new HashMap<>();
        this.partidos = new ArrayList<>();
        this.deputados = new HashMap<>();
    }
    /**
     * Retorna o mapa que contem os objetos Pessoa ja cadastrados
     * @return mapa contendo os objetos Pessoa cadastrados
     */

    public Map<String, Pessoa> getPessoas() {
        return pessoas;
    }

    /**
     * Retorna o mapa que contem os objetos Deputado ja cadastrados.
     * @return mapa contendo os objetos Deputado cadastrados.
     */

    public Map<String, Deputado> getDeputados() {
        return deputados;
    }

    /**
     * Cadastra pessoas de acordo com os metodos da classe, menos o partido. Caso os parametros sejam invalidos, lanca-se uma excecao.
     * @param nome nome do objeto a ser cadastrado
     * @param dni codigo de identificacao do objeto a ser cadastrado.
     * @param estadoOrigem estado de origem do objeto a ser cadastrado.
     * @param interesses interesses do objeto a ser cadastrado
     */


    public void cadastraPessoa(String nome, String dni, String estadoOrigem, String interesses) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estadoOrigem, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if (pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        } else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estadoOrigem, interesses));
        }
    }

    /**
     * Cadastra pessoas de acordo com os metodos da classe, incluindo o partido. Caso os parametros sejam invalidos, lanca-se uma excecao.
     * @param nome nome do objeto a ser cadastrado
     * @param dni codigo de identificacao do objeto a ser cadastrado.
     * @param estadoOrigem estado de origem do objeto a ser cadastrado.
     * @param interesses interesses do objeto a ser cadastrado
     * @param partido partido do objeto a ser cadastrado
     */


    public void cadastraPessoa(String nome, String dni, String estadoOrigem, String interesses, String partido) {
        validadorString(nome, "Erro ao cadastrar pessoa: nome nao pode ser vazio ou nulo");
        validadorString(dni, "Erro ao cadastrar pessoa: dni nao pode ser vazio ou nulo");
        validadorString(estadoOrigem, "Erro ao cadastrar pessoa: estado nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar pessoa: dni invalido");
        if(pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar pessoa: dni ja cadastrado");
        }
        else if (!pessoas.containsKey(dni)) {
            this.pessoas.put(dni, new Pessoa(nome, dni, estadoOrigem, interesses, partido));
        }
    }

    /**
     * Cadastra objeto Deputado a partir do dni e a data de inicio de atuacao. Caso tenha parametro invalido, lanca-se uma excecao.
     * @param dni codigo de identificacao.
     * @param dataDeInicio data de inicio de atuacao politica
     */

    public void cadastraDeputado (String dni, String dataDeInicio) {
        validadorString(dni, "Erro ao cadastrar deputado: dni nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao cadastrar deputado: dni invalido");
        if (!pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa nao encontrada");
        }
        validadorString(dataDeInicio, "Erro ao cadastrar deputado: data nao pode ser vazio ou nulo");
        validadorData(dataDeInicio, "Erro ao cadastrar deputado: data invalida");
        validadorDataFutura(dataDeInicio, "Erro ao cadastrar deputado: data futura");

        if (pessoas.get(dni).getPartido() == null || pessoas.get(dni).getPartido().trim().equals("")) {
            throw new IllegalArgumentException("Erro ao cadastrar deputado: pessoa sem partido");
        }

        String nome = pessoas.get(dni).getNome();
        String estadoDeOrigem = pessoas.get(dni).getEstadoOrigem();
        String interesses = pessoas.get(dni).getInteresses();
        String partido = pessoas.get(dni).getPartido();


        deputados.put(dni, new Deputado(nome,dni, estadoDeOrigem, interesses, partido, dataDeInicio));
        pessoas.remove(dni);
    }

    /**
     * Verifica se o objeto Deputado atraves do seu dni existe no mapa de pessoas. Caso não, lanca-se uma excecao. Verifica tambem se o objeto cadastrado no mapa pessoas tem a funcao de deputado tambem
     * @param dni codigo de identificacao do objeto Pessoa.
     */

    public void verificaDeputado(String dni) {
        if (!pessoas.containsKey(dni) && !deputados.containsKey(dni) ){
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa inexistente");
        }
        if (!deputados.containsKey(dni)){
            throw new IllegalArgumentException("Erro ao cadastrar projeto: pessoa nao eh deputado");
        }
    }

    /**
     * Exibe uma pessoa cadastrada no sistema a partir do DNI. Caso o parametro seja invalido, uma exececao eh lancada.
     * @param dni codigo de identificacao.
     * @return a pessoa cadastrada em um formato para Pessoas Politicas e outra para Nao Politicas.

     */
    public String exibirPessoa(String dni) {
        validadorString(dni, "Erro ao exibir pessoa: dni nao pode ser vazio ou nulo");
        validadorDni(dni, "Erro ao exibir pessoa: dni invalido");

        if (deputados.containsKey(dni)) {
            return deputados.get(dni).toString();
        }

        if(!pessoas.containsKey(dni)) {
            throw new IllegalArgumentException("Erro ao exibir pessoa: pessoa nao encontrada");
        }
        return pessoas.get(dni).toString();
    }

    /**
     * Cadastra a String partido na lista partidos
     * @param partido String recebida como parametro responsavel por representar o partido relacionado
     */

    public void cadastrarPartido(String partido) {
        validadorString(partido, "Erro ao cadastrar partido: partido nao pode ser vazio ou nulo");
        this.partidos.add(partido);
    }

    /**
     * Exibe os partidos ja cadastrados em ordem alfabetica e sem repeticao
     * @return uma String com todos os partidos ja cadastrados ja ordenados
     */

    public String exibirBase() {
        String saida = "";
        Collections.sort(this.partidos);
        for (String partido : this.partidos) {
            saida += partido + ",";
        }
        if(saida.length() != 0) {
            saida = saida.substring(0,saida.length() - 1);
        }
        return saida;
    }
    /**
     * Retorna o int com a quantidade de deputados que ja foram cadastrados
     * @return inteiro com a quantidade de deputados ja cadastrados
     */

    public int qtdDeputados () {
        return deputados.size();
    }

    /**
     * Retorna a lista que contem todas as Strings partido ja cadastradas
     * @return lista partidos
     */

    public List<String> getPartidos() {
        return partidos;
    }

    /**
     * Método de gravação de mapa de pessoas, o objeto é gravado após o sistema ser fechado.
     * @param map, mapa de pessoas.
     * @param arquivo, nome do arquivo de destino.
     */

    public void escreverArquivosPessoa(Map<String, Pessoa> map, String arquivo){
        FileOutputStream arquivoPessoas;
        try {
            arquivoPessoas = new FileOutputStream(arquivo);
            ObjectOutputStream gravarPessoa = new ObjectOutputStream(arquivoPessoas);
            gravarPessoa.writeObject(map);
            gravarPessoa.flush();
            gravarPessoa.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método de gravação de mapa de deputados, o objeto é gravado após o sistema ser fechado.
     * @param map, mapa de deputados.
     * @param arquivo, nome do arquivo de destino.
     */
    public void escreverArquivosDeputado(Map<String, Deputado> map, String arquivo){
        FileOutputStream arquivoDeputados;
        try {
            arquivoDeputados = new FileOutputStream(arquivo);
            ObjectOutputStream gravarDeputado= new ObjectOutputStream(arquivoDeputados);
            gravarDeputado.writeObject(map);
            gravarDeputado.flush();
            gravarDeputado.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Método de gravação de mapa de partidos, o objeto é gravado após o sistema ser fechado.
     * @param list, lista de partidos.
     * @param arquivo, nome do arquivo de destino.
     */
    public void escreverArquivosPartido(List<String> list, String arquivo){
        FileOutputStream arquivoPartido;
        try {
            arquivoPartido = new FileOutputStream(arquivo);
            ObjectOutputStream gravarPartido = new ObjectOutputStream(arquivoPartido);
            gravarPartido.writeObject(list);
            gravarPartido.flush();
            gravarPartido.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * Método de recuperação de mapa gravado.
     * @param arquivo, nome do arquivo onde os dados serão buscados.
     * @return mapa com as informacoes
     */

    public Map<String, Pessoa> lerArquivosPessoa(String arquivo){
        File arquivoPessoa = null;
        arquivoPessoa = new File(arquivo);
        Map<String, Pessoa> map = new HashMap<>();
        FileInputStream fis;
        try {
            if (!arquivoPessoa.exists()) {
                arquivoPessoa.createNewFile();
            }
            else if (arquivo.length() == 0) {
                System.out.println("ARQUIVO VAZIO");

            }else{
                fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (Map<String, Pessoa>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * Método de recuperação de mapa gravado.
     * @param arquivo, nome do arquivo onde os dados serão buscados.
     * @return mapa com as informacoes
     */

    public Map<String, Deputado> lerArquivosDeputado(String arquivo){
        File arquivoDeputado = null;
        arquivoDeputado = new File(arquivo);
        Map<String, Deputado> map = new HashMap<>();
        FileInputStream fis;
        try {
            if (!arquivoDeputado.exists()) {
                arquivoDeputado.createNewFile();
            }
            else if (arquivo.length() == 0) {
                System.out.println("ARQUIVO VAZIO");

            }else{
                fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                map = (Map<String, Deputado>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    /**
     * Método de recuperação de mapa gravado.
     * @param arquivo, nome do arquivo onde os dados serão buscados.
     * @return a lista com as informacoes
     */

    public List<String> lerArquivosPartido(String arquivo){
        File arquivoPartido = null;
        arquivoPartido = new File(arquivo);
        List<String> list = new ArrayList<>(); 
        FileInputStream fis;
        try {
            if (!arquivoPartido.exists()) {
                arquivoPartido.createNewFile();
            }
            else if (arquivo.length() == 0) {
                System.out.println("ARQUIVO VAZIO");

            }else{
                fis = new FileInputStream(arquivo);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (List<String>) ois.readObject();
                ois.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * Inicializa novos mapas e lista para limpar o sistema.
     */
    public void limpar() {
        this.partidos = new ArrayList<>();
        this.deputados = new HashMap<>();
        this.pessoas = new HashMap<>();
    }

}

