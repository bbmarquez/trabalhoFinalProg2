/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho;

/**
 *
 * @author anaFidelis
 */
public class CD {
    private String titulo;
    private String banda;
    private double preco;
    private String loja;

    public CD(String titulo, String banda, double preco, String loja) {
        this.titulo = titulo;
        this.banda = banda;
        this.preco = preco;
        this.loja = loja;
    }

    public CD() {
        this.titulo = "";
        this.banda  = "";
        this.preco  = 0;
        this.loja   = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }
    
}
