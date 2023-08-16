package Model;

import Factory.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    private LocalDate data_nascimento;

    public Pessoa() {
        this.id = 0;
        this.nome = "";
        this.data_nascimento = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return this.data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String toString(){
        return "ID: "+ this.id
                + " | Nome: " + this.nome
                + " | Data Nascimento: " + this.data_nascimento;
    }

    public ArrayList<Pessoa> getListaPessoas(){
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        ConnectionFactory cf = new ConnectionFactory();

        try {
            Statement stmt = cf.conectar().createStatement();
            ResultSet result = stmt.executeQuery("select * from pessoa order by nome");
            cf.desconectar();
            while(result.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(result.getInt("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setData_nascimento(LocalDate.parse(result.getString("data_nascimento")));
                listaPessoas.add(pessoa);
            }
        }catch(SQLException e){
            System.out.println("Erro ao Conectar o Banco de Dados.\nErro: "+ e.getMessage());
        }
        return listaPessoas;
    }

    public String setPessoaDB(Pessoa pessoa){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("insert into pessoa (nome,data_nascimento) " +
                    "values ('"+pessoa.getNome()+"','"
                    +pessoa.getData_nascimento().toString()+"')");
            cf.desconectar();
            return "Registro inserido com sucesso!";
        }catch (SQLException e){
            return "Erro ao inserir registro! "+e.getMessage();
        }
    }

    public String updatePessoaDB(){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("update pessoa set nome = '"+this.nome+
                    "', data_nascimento = '"+this.data_nascimento.toString()+"' where id = "+this.id);
            cf.desconectar();
            return "Registro atualizado com sucesso!";
        }catch (SQLException e){
            return "Erro ao atualizar registro: "+ e.getMessage();
        }
    }

    public String deletePessoaDB(int id){
        ConnectionFactory cf = new ConnectionFactory();
        try {
            Statement stmt = cf.conectar().createStatement();
            stmt.execute("delete from pessoa where id = "+ id);
            cf.desconectar();
            return "Registro excluido com sucesso!";
        }catch (SQLException e){
            return "Erro ao excluir registro: "+ e.getMessage();
        }
    }

}
