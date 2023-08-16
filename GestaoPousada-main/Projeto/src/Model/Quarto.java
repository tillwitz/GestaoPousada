package Model;

import Factory.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quarto {
    private int id;
    private int pousada_id;
    private String nome;

    public Quarto() {
        this.id = 0;
        this.pousada_id = 0;
        this.nome = "";
    }

    public Quarto(String nome) {
        this.id = 0;
        this.pousada_id = 0;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public int getPousada_id() {
        return pousada_id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPousada_id(int pousada_id) {
        this.pousada_id = pousada_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", pousada_id=" + pousada_id +
                ", nome='" + nome + "'\'";
    }

    public ArrayList<Quarto> getListaQuartos(){
        ArrayList<Quarto> listaQuartos = new ArrayList<>();
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            ResultSet result = stmt.executeQuery("select * from quarto order by nome");
            cf.desconectar();
            while (result.next()){
                Quarto quarto = new Quarto();
                quarto.setId(result.getInt("id"));
                quarto.setPousada_id(result.getInt("pousada_id"));
                quarto.setNome(result.getString("nome"));
                listaQuartos.add(quarto);
            }
        } catch (SQLException e){
            System.out.printf("Erro ao Conectar o Banco de Dados.\nErro: "+e.getMessage());
        }
        return listaQuartos;
    }

    public String setQuartoDB(Quarto quarto){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("insert into quarto (nome,pousada_id) values ('"+ quarto.nome +"',"+
                    quarto.pousada_id+ ")");
            cf.desconectar();
            return "Registro inserido com sucesso!";
        } catch (SQLException e){
            return "Erro ao inserir registro! "+e.getMessage();
        }
    }

    public String updateQuartoDB(){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("update quarto set nome = '"+this.nome+
                    "' where id = "+this.id);
            cf.desconectar();
            return "Registro atualizado com sucesso!";
        } catch (SQLException e){
            return "Erro ao atualizar registro: "+e.getMessage();
        }
    }

    public String deleteQuartoDB(int id){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("delete from quarto where id = "+id);
            cf.desconectar();
            return "Registro excluido com sucesso!";
        } catch (SQLException e){
            return "Erro ao excluir registro: "+e.getMessage();
        }
    }
}
