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

import banco.dominio.Conta;
import java.util.List;

public interface ContaDaoInterface {
    List<Conta> listarTudo();
    
    void adicionar(Conta c);
    void remover(Conta c);
    void atualizar(Conta c);
    Conta buscarPeloNumero(long numeroConta);
}
