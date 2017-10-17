/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao.impl.relacional;

/**
 *
 * @author 31206018
 */
import java.sql.Connection;

public interface ConexaoInterface {
    Connection getConnection();
    void close();
    
}
