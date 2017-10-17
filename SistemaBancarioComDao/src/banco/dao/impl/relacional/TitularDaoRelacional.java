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
import banco.dao.api.TitularDaoInterface;
import banco.dominio.Conta;
import banco.dominio.Titular;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TitularDaoRelacional implements TitularDaoInterface {

    private ConexaoInterface conexao;

    public TitularDaoRelacional(ConexaoInterface conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Titular> listarTudo() {
        List<Titular> titulares;
        titulares = new ArrayList<>();
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT nro_titular, nome, rg, cpf FROM titulares";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                long n = resultados.getLong("nro_titular");
                String nome = resultados.getString("nome");
                String rg = resultados.getString("rg");
                String cpf = resultados.getString("cpf");
                Titular t = new Titular(n, nome, rg, cpf);
                titulares.add(t);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return titulares;
    }

    @Override
    public void adicionar(Titular t) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "INSERT INTO titulares VALUES(" + t.getNumero() + ",'" + t.getNome() + "','" + t.getRg() + "','" + t.getCpf() + "')";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Titular t) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "UPDATE * FROM titulares WHERE nro_titular = " + t.getNumero();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remover(Titular t) {
        try {
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "REMOVE INTO titulares WHERE nro_titular = " + t.getNumero();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Titular buscarPeloNome(String nome) {
          Titular t = new Titular(0, nome, nome, nome);
        try{
            Statement st;
            st = conexao.getConnection().createStatement();
            String sql = "SELECT * INTO titulares WHERE nome = '"+nome+"'";
            ResultSet resultado = st.executeQuery(sql);
            Long n = resultado.getLong("nro_titular");
            String name, rg,cpf;
            name = resultado.getString("nome");
            rg = resultado.getString("rg");
            cpf = resultado.getString("cpf");
           t.setNumero(n);
           t.setNome(name);
           t.setRg(rg);
           t.setCpf(cpf);
            //Titular t = new Titular(resultado.getLong("nro_titular"),resultado.getString("nome") , resultado.getString("rg"), resultado.getString("cpf");
        }catch(Exception e){
            e.printStackTrace();
        }
       return t; 
    }
    
}
