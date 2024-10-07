package org.example;

import java.util.Scanner;

public class Gestao {
    public Evento[] eventos = new Evento[10];

    public void cadastrarEvento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do evento: ");
        String nome = sc.nextLine();

        System.out.print("Digite a data do evento: ");
        String data = sc.nextLine();

        System.out.print("Digite o local do evento: ");
        String local = sc.nextLine();

        System.out.print("Digite a capacidade do evento: ");
        int capacidade = sc.nextInt();

        Evento evento = new Evento(nome, data, local, capacidade);

        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] == null) {
                eventos[i] = evento;
                break;
            }
        }


    }
    public void listarEventos() {
        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null) {
                eventos[i].listarEvento();
            }
        }
    }

    public void buscarEvento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do evento: ");
        String nome = sc.nextLine();

        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null && eventos[i].getNome().equals(nome)) {
                eventos[i].listarEvento();
            }
        }


    }

    public void categorizarEvento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do evento: ");
        String nome = sc.nextLine();

        System.out.print("Digite a categoria do evento: ");
        String categoria = sc.nextLine();

        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null && eventos[i].getNome().equals(nome)) {
                eventos[i].setCategoria(categoria);
            }
        }


    }

    public void inscricaoEvento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do evento: ");
        String nome = sc.nextLine();

        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = sc.nextLine();

        System.out.print("Digite o email da pessoa: ");
        String emailPessoa = sc.nextLine();

        System.out.println("Digite o cpf da pessoa: ");
        String cpfPessoa = sc.nextLine();

        Pessoa pessoa = new Pessoa(nomePessoa, cpfPessoa, emailPessoa);

        for (int i = 0; i < eventos.length; i++) {
            if (eventos[i] != null && eventos[i].getNome().equals(nome)) {
                eventos[i].inscricaoEvento(pessoa);
            }
        }


    }

}
