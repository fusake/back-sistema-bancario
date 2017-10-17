/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.sistema.bancario;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 *
 * @author 31206018
 */
public class Aplicacao extends 
        Application<Configuracao>{
    public static void main(String[] args) throws Exception{
        String[] param = {"server","conf/server_config.yml"};
        new Aplicacao().run(param);
    }

    @Override
    public void run(Configuracao t, Environment e) throws Exception {
        final Recurso recurso = new Recurso(t.getAtributo1(), t.getAtributo2());
        e.jersey().register(recurso);
    }
    
    
}
