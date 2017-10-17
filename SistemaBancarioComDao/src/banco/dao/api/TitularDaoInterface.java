/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao.api;

/**
 *
 * @author 31206018
 */
import banco.dominio.Titular;
import java.util.List;

public interface TitularDaoInterface {

    List<Titular> listarTudo();
    
    void adicionar(Titular t);
    void remover(Titular t);
    void atualizar(Titular t);
    Titular buscarPeloNome(String nome);

}
