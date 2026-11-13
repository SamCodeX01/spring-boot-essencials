package br.com.samuel.spring_boot_essencials.exception;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {//Aqui está pegando o texto da mensagem de erro que recebeu no construtor de NotFoundException
        super(message); //e repassando diretamente para o construtor da classe Exception.
        // usada para chamar o construtor da classe base (classe pai).
    }
}
