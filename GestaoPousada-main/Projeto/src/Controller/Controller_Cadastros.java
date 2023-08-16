package Controller;

import Model.Pessoa;
import Model.Pousada;
import Model.Quarto;

import java.time.LocalDate;

public class Controller_Cadastros {
    public Controller_Cadastros() {
    }

    public String cadastrarPessoa(String nome, String dataNascimento){
        Pessoa pessoa = new Pessoa();
        if(nome == null || nome == "" ||
                dataNascimento == null || dataNascimento == ""){
            return "O Nome e a Data de Nascimento devem ser preenchidos!";
        }
        pessoa.setNome(nome);
        pessoa.setData_nascimento(LocalDate.parse(dataNascimento));
        return pessoa.setPessoaDB(pessoa);
    }

    public String cadastrarPousada(String nome){
        Pousada pousada = new Pousada();
        if(nome == null || nome == ""){
            return "O nome da pousada deve ser preenchidos!";
        } else {
            pousada.setNome(nome);
            return pousada.setPousadaDB(pousada);
        }
    }

    public String cadastrarQuarto(String nome, int pousada_id){
        Quarto quarto = new Quarto();
        if(nome == null || nome == "" || pousada_id == 0){
            return "O nome do quarto e o id da pousada deve ser preenchido!";
        } else {
            quarto.setNome(nome);
            quarto.setPousada_id(pousada_id);
            return quarto.setQuartoDB(quarto);
        }
    }
}
