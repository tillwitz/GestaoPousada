package View;

import Controller.Controller_Atualizacoes;
import Controller.Controller_Cadastros;
import Controller.Controller_Exclusao;
import Controller.Controller_Listas;
import java.util.Scanner;

public class Menu {
    Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu(){
        int opcao;
        do {
            System.out.println("Menu");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Ver Lista");
            System.out.println("3 - Atualizar Cadastro");
            System.out.println("4 - Excluir Cadastro");
            System.out.println("0 - Encerrar Aplicacao");
            System.out.printf("Selecione uma Opcao: ");
            opcao = sc.nextInt();
            if (opcao >= 1 && opcao <= 4) {
                mostrarSubMenu(opcao);
            }else if(opcao != 0){
                System.out.println("Opcao invalida, por favor selecione Uma das opcoes abaixo:");
            }
        }while(opcao != 0);

    }

    public void mostrarSubMenuGeral(String menu){
        System.out.println(menu);
        System.out.println("1 - Locacao");
        System.out.println("2 - Pessoa");
        System.out.println("3 - Pousada");
        System.out.println("4 - Quarto");
        System.out.println("0 - Voltar ao Menu Anterior");
        System.out.printf("Selecione uma Opcao: ");
    }

    public void mostrarSubMenuListas(String menu){
        System.out.println(menu);
        System.out.println("1 - Locacoes");
        System.out.println("2 - Pessoas");
        System.out.println("3 - Pousadas");
        System.out.println("4 - Quartos");
        System.out.println("0 - Voltar ao Menu Anterior");
        System.out.printf("Selecione uma Opcao: ");
    }

    public void mostrarSubMenu(int opcao){
        int subOpcao = -1;
        Controller_Cadastros cc = new Controller_Cadastros();
        Controller_Listas cl = new Controller_Listas();
        Controller_Atualizacoes ca = new Controller_Atualizacoes();
        Controller_Exclusao ce = new Controller_Exclusao();
        do {
            switch (opcao) {
                case 1:
                    mostrarSubMenuGeral("Cadastrar");
                    subOpcao = sc.nextInt();
                    if(subOpcao == 1){
                        //Não será implementada
                    }else if(subOpcao == 2){
                        System.out.println("Informe o nome da pessoa:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println("Informe a data de nascimento:");
                        String data_nascimento = sc.nextLine();
                        //Chamar Controller de Cadastros
                        System.out.println(cc.cadastrarPessoa(nome,data_nascimento));
                    }else if (subOpcao == 3){
                        System.out.printf("Informe o nome da pousada:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.printf(cc.cadastrarPousada(nome));
                    }else if (subOpcao == 4){
                        System.out.printf("Informe o nome do quarto:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println("Informe o ID da pousada:");
                        int pousada_id = sc.nextInt();
                        System.out.printf(cc.cadastrarQuarto(nome,pousada_id));
                    }
                    break;
                case 2:
                    mostrarSubMenuListas("Listar");
                    subOpcao = sc.nextInt();
                    if(subOpcao == 1){
                        //Não será implementada
                    }else if(subOpcao == 2){
                        System.out.println("Lista de clientes existentes:");
                        //chamar o controler de listas
                        for(String pessoa : cl.getListaPessoas()){
                            System.out.println(pessoa);
                        }
                        System.out.println("Informe qualquer caracter para voltar ao menu!");
                        sc.next();
                    }else if (subOpcao == 3){
                        System.out.println("Lista de pousadas existentes:");
                        //chamar o controler de listas
                        for(String pousadas : cl.getListaPousadas()){
                            System.out.println(pousadas);
                        }
                        System.out.println("Informe qualquer caracter para voltar ao menu!");
                        sc.next();
                    }else if (subOpcao == 4){
                        System.out.println("Lista de quartos existentes:");
                        //chamar o controler de listas
                        for(String quartos : cl.getListaQuartos()){
                            System.out.println(quartos);
                        }
                        System.out.println("Informe qualquer caracter para voltar ao menu!");
                        sc.next();
                    }
                    break;
                case 3:
                    mostrarSubMenuGeral("Atualizar");
                    subOpcao = sc.nextInt();
                    if(subOpcao == 1){
                        //Não será implementada
                    }else if(subOpcao == 2){
                        System.out.println("Informe o ID da pessoa que deseja atualizar:");
                        int id = sc.nextInt();
                        System.out.println("Informe o nome da Pessoa:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println("Informe a data de nascimento:"
                                +"(Padrão ISO8601) -> YYYY-MM-DD");
                        String dataNascimento = sc.nextLine();
                        //Chamar Controller
                        System.out.println(ca.updatePessoa(id,nome,dataNascimento));
                    }else if (subOpcao == 3){
                        System.out.println("Informe o ID da pousada que deseja atualizar:");
                        int id = sc.nextInt();
                        System.out.println("Informe o nome da pousada:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println(ca.updatePousada(id,nome));
                    }else if (subOpcao == 4){
                        System.out.println("Informe o ID do quarto que deseja atualizar:");
                        int id = sc.nextInt();
                        System.out.println("Informe o nome do quarto:");
                        sc.nextLine();
                        String nome = sc.nextLine();
                        System.out.println(ca.updateQuarto(id,nome));
                    }
                    break;
                case 4:
                    mostrarSubMenuGeral("Excluir");
                    subOpcao = sc.nextInt();
                    if(subOpcao == 1){
                        //Não será implementada
                    }else if(subOpcao == 2){
                        System.out.println("Informe o ID da Pessoa que Deseja Excluir:");
                        int id = sc.nextInt();
                        System.out.println(ce.deletePessoa(id));
                    }else if (subOpcao == 3){
                        System.out.println("Informe o ID da pousada que deseja excluir:");
                        int id = sc.nextInt();
                        System.out.println(ce.deletePousada(id));
                    }else if (subOpcao == 4){
                        System.out.println("Informe o ID do quarto que deseja excluir:");
                        int id = sc.nextInt();
                        System.out.println(ce.deleteQuarto(id));
                    }
                    break;
            }
            if(subOpcao < 0 || subOpcao > 4){
                System.out.println("Opcao invalida, por favor selecione uma das opcoes abaixo:");
            }
        }while(subOpcao != 0);
    }
}
