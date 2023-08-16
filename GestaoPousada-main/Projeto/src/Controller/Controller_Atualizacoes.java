package Controller;

import Model.Pessoa;
import Model.Pousada;
import Model.Quarto;

import java.time.LocalDate;

public class Controller_Atualizacoes {
    public Controller_Atualizacoes() {
    }

    public String updatePessoa(int id, String nome, String dataNascimento){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setData_nascimento(LocalDate.parse(dataNascimento));
        return pessoa.updatePessoaDB();
    }

    public String updatePousada(int id, String nome){
        Pousada pousada = new Pousada();
        pousada.setId(id);
        pousada.setNome(nome);
        return  pousada.updatePousadaDB();
    }

    public String updateQuarto(int id, String nome){
        Quarto quarto = new Quarto();
        quarto.setId(id);
        quarto.setNome(nome);
        return quarto.updateQuartoDB();
    }
}
