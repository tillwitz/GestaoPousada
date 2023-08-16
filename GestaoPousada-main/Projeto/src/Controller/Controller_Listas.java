package Controller;

import java.util.ArrayList;
import Model.Pessoa;
import Model.Pousada;
import Model.Quarto;

public class Controller_Listas {
    public Controller_Listas() {
    }

    public ArrayList<String> getListaPessoas(){
        ArrayList<String> listaPessoasTexto = new ArrayList<String>();
        for(Pessoa pessoa : new Pessoa().getListaPessoas()){
            listaPessoasTexto.add(pessoa.toString());
        }
        return listaPessoasTexto;
    }

    public ArrayList<String> getListaPousadas(){
        ArrayList<String> listaPousadasTexto = new ArrayList<>();
        for (Pousada pousada : new Pousada().getListaPousada()){
            listaPousadasTexto.add(pousada.toString());
        }
        return listaPousadasTexto;
    }
    public ArrayList<String> getListaQuartos(){
        ArrayList<String> listaQuartosTexto = new ArrayList<>();
        for (Quarto quarto : new Quarto().getListaQuartos()){
            listaQuartosTexto.add(quarto.toString());
        }
        return listaQuartosTexto;
    }
}
