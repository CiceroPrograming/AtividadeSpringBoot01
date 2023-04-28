package com.atividadeweb01.atividadeweb01.Model;

public class Produto {

    private int id;
    private String nomeProduto;
    private double valor;
    private double peso;
    private int qtdEstoque;

    public Produto(int id, String nomeProduto, double valor, double peso, int qtdEstoque) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.peso = peso;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

}
