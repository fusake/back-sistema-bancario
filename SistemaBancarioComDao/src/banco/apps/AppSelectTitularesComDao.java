/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.apps;

/**
 *
 * @author 31206018
 */

import banco.dominio.Titular;
import banco.dao.api.TitularDaoInterface;
import banco.dao.impl.relacional.TitularDaoRelacional;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import java.util.List;

public class AppSelectTitularesComDao {
    public static void main(String[] args) {
        ConexaoInterface conexao;
        conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        TitularDaoInterface tao;
        tao = new TitularDaoRelacional(conexao);
        System.out.print("----------------------");
        Titular tt = new Titular(5, "Vinicius", "5555555555", "666666666666");
        tao.adicionar(tt);
        List<Titular> todosTitulares;
        todosTitulares = tao.listarTudo();
        for(Titular t : todosTitulares){
            System.out.print("Nro: " + t.getNumero());
            System.out.print(" - ");
            System.out.print("Nome: " + t.getNome());
            System.out.print(" - ");
            System.out.print("RG: " + t.getRg());
            System.out.print(" - ");
            System.out.println("CPF: " + t.getCpf());
            
        }
        conexao.close();
        
    }
}
