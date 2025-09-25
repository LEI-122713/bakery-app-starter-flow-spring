/**
 * Classe responsável por gerir as interações do utilizador no front-end.
 */
public class MainController {

/**
 * Devolve uma mensagem de boas-vindas.
 *
 * @param nome o nome do utilizador
 * @return mensagem de boas-vindas personalizada
 */
public String boasVindas(String nome) {
    return "Olá, " + nome + "!";
}
}
