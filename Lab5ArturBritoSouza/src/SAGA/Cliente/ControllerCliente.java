package SAGA.Cliente;

import java.util.*;
import java.util.List;

/**
 * Criado para controlar a classe Cliente.
 * Um Cliente Controller possui um Conjunto de clientes, que possuem como chave o cpf do cliente.
 * 
 * @author Artur Brito Souza - UFCG 
 */
public class ControllerCliente {
	
	/**
     * Conjunto de Clientes, identificados unicamente pelo seu cpf, que também é a chave do mapa clientes
     */
    private HashMap<String , Cliente> clientes;

    /**
     * Criado para inicializar o ControllerCliente
     */
    public ControllerCliente(){
        this.clientes = new HashMap<>();
    }

    /**
     * Criado para retornar o mapa de clientes
     * @return o mapa.
     */
    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    /**
     * Criado para adicionar um cliente ao controlador.
     *
     * @param cpf String com cpf no cliente
     * @param nome String com nome do cliente.
     * @param email String com email do cliente.
     * @param localizacao String com local de trabalho do cliente.
     * @return String com cpf do cliente cadastrado.
     */
    public String cadastraCliente(String cpf, String nome, String email, String localizacao){

        util.Validador.validaStringNullEVazia(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo." );
        util.Validador.validaTamanhoString(cpf, 11, 11, "Erro no cadastro do cliente: cpf invalido." );
        util.Validador.validaStringNullEVazia(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        if (this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }
        Cliente c = new Cliente(cpf, nome, email, localizacao);
        this.clientes.put(cpf, c);
        return cpf;
    }

    /**
     * Criado para retornar a representacao de um cliente especifico.
     *
     * @param cpf String com cpf do cliente que deseja ser encontrado.
     * @return String com representacao do cliente desejado, ou frase cliente nao cadastrado, caso o cliente nao esteja no sistema.
     */
    public String encontraCliente(String cpf){

        String saida = "";

        util.Validador.validaStringNullEVazia(cpf,"Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo." );
        if (this.clientes.containsKey(cpf)){
            saida = this.clientes.get(cpf).toString();
        }
        else {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }

        return saida;
    }

    /**
     * Criado para retornar a representacao de todos os clientes
     *
     * @return String com nome de todos os clientes cadastrados
     */
    public String listaClientes (){
        String saida = "";

        List<Cliente> clienteList = new ArrayList<>(this.clientes.values());
        Collections.sort(clienteList);

        for (Cliente cliente: clienteList) {
            saida += cliente.toString() + " | ";
        }

        return saida.substring(0, saida.length() - 3);
    }


    /**
     * Criado para editar algum atributo do Cliente.
     *
     * @param cpf Cpf que ira identificar o cliente
     * @param informacao qual o atributo que sera modificado
     * @param alteracao novo valor o qual o atributo indicado sera substitituido.
     * @return String com a frase Altercao concluida
     */
    public String editaCadastro (String cpf, String informacao, String alteracao){

        util.Validador.validaStringNullEVazia(alteracao, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(informacao, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        util.Validador.validaStringNullEVazia(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");

        if (informacao.toLowerCase().trim().equals("cpf")){
            throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
        }
    	if (!informacao.toLowerCase().trim().equals("email") && !informacao.toLowerCase().trim().equals("nome") && !informacao.toLowerCase().trim().equals("localizacao")) {
    		throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
    	}
    	if (!this.clientes.containsKey(cpf)) {
    		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
    	}
        if (this.clientes.containsKey(cpf)){
            if (informacao.toLowerCase().equals("email")){
            	this.clientes.get(cpf).setEmail(alteracao);
            }
            if (informacao.toLowerCase().equals("nome")){
            	this.clientes.get(cpf).setNome(alteracao);
            }
            if (informacao.toLowerCase().equals("localizacao")){
            	this.clientes.get(cpf).setLocalizacao(alteracao);
            }
        }
        return "Altercao concluida";
    }

    /**
     * Criado para remover algum cliente.
     *
     * @param cpf String com cpf do cliente que sera removido.
     * @return String com a frase cliente removido.
     */
    public String RemoveClienteDoCadastro(String cpf){

        util.Validador.validaStringNullEVazia(cpf, "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        if (!this.clientes.containsKey(cpf)) {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        }
        String saida = "";

        if (this.clientes.containsKey(cpf)){
        	this.clientes.remove(cpf);
            saida = "Cliente removido";
        }
        return saida;
    }

}
