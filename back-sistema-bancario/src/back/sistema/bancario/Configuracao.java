/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.sistema.bancario;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author 31206018
 */
public class Configuracao extends 
        io.dropwizard.Configuration{
    
    @JsonProperty
    private String atributo1;
    @JsonProperty
    private String atributo2;

    public String getAtributo1() {
        return atributo1;
    }

    public String getAtributo2() {
        return atributo2;
    }

    public void setAtributo1(String atributo1) {
        this.atributo1 = atributo1;
    }

    public void setAtributo2(String atributo2) {
        this.atributo2 = atributo2;
    }
    
    
    
    
}
