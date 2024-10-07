package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {
    private Gestao gestao;
    private JTextArea outputArea;

    public InterfaceGrafica() {
        gestao = new Gestao();

        setTitle("Sistema de Gestão de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JButton cadastrarButton = new JButton("Cadastrar Evento");
        JButton listarButton = new JButton("Listar Eventos");
        JButton buscarButton = new JButton("Buscar Evento");
        JButton categorizarButton = new JButton("Categorizar Evento");
        JButton inscricaoButton = new JButton("Inscrição em Evento");

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarEvento();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarEventos();
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEvento();
            }
        });

        categorizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                categorizarEvento();
            }
        });

        inscricaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscricaoEvento();
            }
        });

        panel.add(cadastrarButton);
        panel.add(listarButton);
        panel.add(buscarButton);
        panel.add(categorizarButton);
        panel.add(inscricaoButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void cadastrarEvento() {
        String nome = JOptionPane.showInputDialog("Digite o nome do evento:");
        String data = JOptionPane.showInputDialog("Digite a data do evento:");
        String local = JOptionPane.showInputDialog("Digite o local do evento:");
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do evento:"));

        Evento evento = new Evento(nome, data, local, capacidade);
        for (int i = 0; i < gestao.eventos.length; i++) {
            if (gestao.eventos[i] == null) {
                gestao.eventos[i] = evento;
                outputArea.append("Evento cadastrado!\n");
                return;
            }
        }
        outputArea.append("Não foi possível cadastrar o evento. Limite de eventos atingido.\n");
    }

    private void listarEventos() {
        outputArea.setText("Lista de Eventos\n");
        boolean eventosExistem = false;

        for (int i = 0; i < gestao.eventos.length; i++) {
            if (gestao.eventos[i] != null) {
                eventosExistem = true;
                Evento evento = gestao.eventos[i];
                outputArea.append("Nome: " + evento.getNome() + "\n");
                outputArea.append("Data: " + evento.getData() + "\n");
                outputArea.append("Local: " + evento.getLocal() + "\n");
                outputArea.append("Capacidade: " + evento.getCapacidade() + "\n");
                outputArea.append("Categoria: " + (evento.getCategoria() != null ? evento.getCategoria() : "Não categorizado") + "\n");
                outputArea.append("--------------------\n");
            }
        }

        if (!eventosExistem) {
            outputArea.append("Nenhum evento cadastrado.\n");
        }
    }

    private void buscarEvento() {
        String nome = JOptionPane.showInputDialog("Digite o nome do evento que deseja buscar:");
        for (int i = 0; i < gestao.eventos.length; i++) {
            if (gestao.eventos[i] != null && gestao.eventos[i].getNome().equals(nome)) {
                outputArea.append("Evento encontrado:\n");
                outputArea.append("Nome: " + gestao.eventos[i].getNome() + "\n");
                outputArea.append("Data: " + gestao.eventos[i].getData() + "\n");
                outputArea.append("Local: " + gestao.eventos[i].getLocal() + "\n");
                outputArea.append("Capacidade: " + gestao.eventos[i].getCapacidade() + "\n");
                outputArea.append("Categoria: " + (gestao.eventos[i].getCategoria() != null ? gestao.eventos[i].getCategoria() : "Não categorizado") + "\n");
                outputArea.append("--------------------\n");
                return;
            }
        }
        outputArea.append("Evento não encontrado.\n");
    }

    private void categorizarEvento() {
        String nome = JOptionPane.showInputDialog("Digite o nome do evento para categorizar:");
        String categoria = JOptionPane.showInputDialog("Digite a categoria do evento:");

        for (int i = 0; i < gestao.eventos.length; i++) {
            if (gestao.eventos[i] != null && gestao.eventos[i].getNome().equals(nome)) {
                gestao.eventos[i].setCategoria(categoria);
                outputArea.append("Categoria definida para o evento: " + nome + "\n");
                return;
            }
        }
        outputArea.append("Evento não encontrado.\n");
    }

    private void inscricaoEvento() {
        String nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento:");
        String nomePessoa = JOptionPane.showInputDialog("Digite o nome da pessoa:");
        String emailPessoa = JOptionPane.showInputDialog("Digite o email da pessoa:");
        String cpfPessoa = JOptionPane.showInputDialog("Digite o CPF da pessoa:");

        Pessoa pessoa = new Pessoa(nomePessoa, cpfPessoa, emailPessoa);

        for (int i = 0; i < gestao.eventos.length; i++) {
            if (gestao.eventos[i] != null && gestao.eventos[i].getNome().equals(nomeEvento)) {
                if(gestao.eventos[i].getCapacidade() > 0){
                    gestao.eventos[i].inscricaoEvento(pessoa);
                    outputArea.append(pessoa.getNome() + " foi inscrito(a) no evento: " + gestao.eventos[i].getNome() + "\n");
                    return;
                }
                else{
                    outputArea.append("Não foi possível fazer a inscrição, o evento está lotado!");
                    return;
                }

            }
        }
        outputArea.append("Evento não encontrado.\n");
    }
}
