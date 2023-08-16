package Model;

import Factory.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

public class Pousada {
    private int id;
    private String nome;

    public Pousada() {
        this.id = 0;
        this.nome = "";
    }

    public Pousada(String nome) {
        this.id = 0;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nome='" + nome + "'\'";
    }

    public ArrayList<Pousada> getListaPousada(){
        ArrayList<Pousada> listaPousadas = new ArrayList<>();
        ConnectionFactory cf = new ConnectionFactory();

        try {
            Statement stmt = cf.conectar().createStatement();
            ResultSet result = stmt.executeQuery("select * from pousada order by nome");
            cf.desconectar();
            while(result.next()){
                Pousada pousada = new Pousada();
                pousada.setId(result.getInt("id"));
                pousada.setNome(result.getString("nome"));
                listaPousadas.add(pousada);
            }
        } catch (SQLException e){
            System.out.println("Erro ao conectar o banco de dados.\nErro:"+e.getMessage());
        }
        return listaPousadas;
    }

    public String setPousadaDB(Pousada pousada){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("insert into pousada (nome) values ("+
                "'"+pousada.getNome()+"')");
            cf.desconectar();
            return "Registro inserido com sucesso!";
        } catch (SQLException e){
            return "Erro ao inserir registro!"+e.getMessage();
        }
    }

    public String updatePousadaDB(){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("update pousada set nome = '"+this.nome+
                    "' where id ="+this.id);
            cf.desconectar();
            return "Registro atualizado com sucesso!";
        } catch (SQLException e){
            return "Erro ao atualizar registro: "+e.getMessage();
        }
    }

    public String deletePousadaDB(int id){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("delete from pousada where id = "+id);
            cf.desconectar();
            return "Registro excluido com sucesso!";
        } catch (SQLException e){
            return "Erro ao excluir registro: "+e.getMessage();
        }
    }
}
