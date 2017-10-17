/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dominio;

/**
 *
 * @author 31206018
 */
public class Titular {
    private long numero;
    private String nome;
    private String rg;
    private String cpf;

    public Titular(long numero, String nome, String rg, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public long getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    
    
}
