/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.sistema.bancario;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author 31206018
 */
@Path("/recurso")
public class Recurso {
    private String at1;
    private String at2;

    public Recurso(String at1, String at2) {
        this.at1 = at1;
        this.at2 = at2;
    }
    
    @GET
    @Path("/ws")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response metodo1(){
        Entidade e = new Entidade();
        e.setNome(at1);
        e.setDesc(at2);
        return Response.ok(e).build();
    }
}
