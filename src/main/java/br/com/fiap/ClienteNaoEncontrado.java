package br.com.fiap;

public class ClienteNaoEncontrado extends RuntimeException {
    public ClienteNaoEncontrado(String message) {
        super(message);
    }
}
