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
import banco.dao.api.ContaDaoInterface;
import banco.dao.impl.relacional.ConexaoInterface;
import banco.dao.impl.relacional.ContaDaoRelacional;
import banco.dao.impl.relacional.javadb.ConexaoJavaDb;
import banco.dominio.Conta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarContas {

    public static void main(String[] args) {

        ConexaoInterface conexao;
        conexao = new ConexaoJavaDb("app", "app", "127.0.0.1", 1527, "sistema_bancario");
        ContaDaoInterface dao;
        dao = new ContaDaoRelacional(conexao);
        List<Conta> contas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        long l;
        BigDecimal s;
        Conta c;

        do {
            System.out.println("---MENU DE GERENCIAMENTO DE CONTAS---");
            System.out.println("--ESCOLHA UMA DAS OPÇÕES--");
            System.out.println("(1) - LISTAR TODAS AS CONTAS");
            System.out.println("(2) - ADICIONAR UMA CONTA");
            System.out.println("(3) - REMOVER UMA CONTA");
            System.out.println("(4) - ATUALIZAR OS DADOS DE UMA CONTA");
            System.out.println("(5) - SAIR");
            
            op = sc.nextInt();
         

            switch (op) {

                case 1:
                    //Listar todas as contas
                    contas = dao.listarTudo();
                    for (Conta ca : contas) {
                        System.out.print("Nro: " + ca.getNumero());
                        System.out.print(" - ");
                        System.out.println("Saldo: " + ca.getSaldo());                       
                    }
                    System.out.println("      ");
                    break;

                case 2:
                    //Adicionar uma conta
                    System.out.println("Digite um numero para a conta: ");
                    l = sc.nextLong();
                    System.out.println("Digite um saldo para a conta:");
                    s = sc.nextBigDecimal();
                    dao.adicionar(c = new Conta(l, s));
                    break;

                case 3:
                    //Remover uma conta
                    System.out.println("Digite um numero de conta: ");
                    l = sc.nextLong();
                    dao.remover(c = new Conta(l, new BigDecimal(0.0)));
                    break;

                case 4:
                    //Atualizar os dados de uma conta
                    System.out.print("Digite um numero de conta: ");
                    l = sc.nextLong();
                    System.out.println("Digite um novo valor de saldo: ");
                    s = sc.nextBigDecimal();
                    dao.atualizar(c = new Conta(l, s));
                    break;

                case 5:
                    System.exit(5);

            }
        }while (op != 5);
     
    }
}
