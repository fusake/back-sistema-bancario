/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao.impl.relacional;

import banco.dao.api.ContaDaoInterface;
import banco.dominio.Conta;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 31206018
 */
public class ContaDaoRelacional implements ContaDaoInterface {

    private ConexaoInterface conexao;
    private Scanner sc = new Scanner(System.in);

    public ContaDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Conta> listarTudo() {
        List<Conta> contas;
        contas = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT nro_conta, saldo FROM contas";
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                long n = resultados.getLong("nro_conta");
                BigDecimal b = resultados.getBigDecimal("saldo");
                Conta c = new Conta(n, b);
                contas.add(c);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return contas;
    }

    @Override
    public void adicionar(Conta c) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "INSERT INTO contas VALUES(" + c.getNumero() + "," + c.getSaldo() + ")";
            System.out.println(sql);
            st.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remover(Conta c) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "DELETE FROM contas WHERE nro_conta =" + c.getNumero();
            st.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Conta Removida.");
    }

    @Override
    public void atualizar(Conta c) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "UPDATE contas SET nro_conta =" + c.getNumero() + ", saldo =" + c.getSaldo() + "WHERE nro_conta =" + c.getNumero();
            st.executeUpdate(sql);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Conta buscarPeloNumero(long numeroConta) {
        Conta c = new Conta(123, BigDecimal.ZERO);
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT * FROM contas WHERE nro_conta =" + numeroConta + "";
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                c.setNumero(resultados.getLong("nro_conta"));
                c.setSaldo(resultados.getBigDecimal("saldo"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }
}
