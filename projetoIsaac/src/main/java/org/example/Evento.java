package org.example;

public class Evento {
    private String nome;
    private String data;
    private String local;
    private int capacidade;
    private String categoria;
    Pessoa[] pessoas = new Pessoa[capacidade];

    public Evento(String nome, String data, String local, int capacidade) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void inscricaoEvento(Pessoa pessoa) {
        if (capacidade > 0) {
            System.out.println("Inscrição realizada com sucesso!");
            capacidade--;
            for (int i = 0; i < pessoas.length; i++) {
                if (pessoas[i] == null) {
                    pessoas[i] = pessoa;
                    break;
                }
            }
        } else {
            System.out.println("Evento lotado!");
        }

        System.out.println("--------------------");
    }

    public void listarEvento() {
        System.out.println("--------------------");
        System.out.println("Nome do evento: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Local: " + local);
        System.out.println("Número de vagas disponíveis: " + capacidade);
        System.out.println("Categoria: " + categoria);
        System.out.println("--------------------");
    }

}
