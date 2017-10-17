/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.sistema.bancario;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31206018
 */

@XmlRootElement
public class Entidade {
    String nome;
    String desc;

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
