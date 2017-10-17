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

import java.math.BigDecimal;

public class Conta {
    private long numero;
    private BigDecimal saldo;
    
    public Conta(long numero, BigDecimal saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public long getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    
    
    
}
