package br.com.fiap.model;

public class Pedido {

    private int codigo;
    private String descricao;
    private double valorTotal;
    private int quantidade;

    public Pedido() {
    }

    public Pedido(String descricao, double valorTotal, int quantidade) {
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
    }

    public Pedido(int codigo, String descricao, double valorTotal, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
