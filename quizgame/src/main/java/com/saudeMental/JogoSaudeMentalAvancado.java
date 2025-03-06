package com.saudeMental;

import java.util.Scanner;

public class JogoSaudeMentalAvancado {
    private int energia;
    private int felicidade;
    private int estresse;
    private int pontuacao;
    private String nomePersonagem;

    public JogoSaudeMentalAvancado(String nome) {
        this.nomePersonagem = nome;
        this.energia = 50;  // energia do personagem
        this.felicidade = 50;  // felicidade do personagem
        this.estresse = 50;  // estresse do personagem
        this.pontuacao = 0;  // pontuação global
    }

    public void iniciarJogo(Scanner scanner) {
        System.out.println("Bem-vindo à 'Jornada do Bem-Estar Mental'!");
        System.out.println("Olá, " + nomePersonagem + "! Vamos embarcar nessa jornada para melhorar seu bem-estar mental.");
        System.out.println("Seu objetivo é encontrar equilíbrio, tomar boas decisões e melhorar sua qualidade de vida.");

        // Ciclo diário 1
        cicloDiario(scanner);

        // Ciclo diário 2
        cicloDiario(scanner);

        // Feedback final baseado nas condições do personagem
        feedbackFinal();
    }

    private void cicloDiario(Scanner scanner) {
        System.out.println("\nÉ um novo dia, " + nomePersonagem + "! Como você começa o dia?");
        System.out.println("1. Acorda cedo e faz uma meditação para começar o dia com calma.");
        System.out.println("2. Acorda tarde, se arruma às pressas e vai para o trabalho.");
        System.out.println("3. Pega o celular e começa a navegar nas redes sociais.");
        int escolha1 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha1 == 1) {
            energia += 10;
            felicidade += 5;
            estresse -= 5;
            pontuacao += 5;
            System.out.println("Você começa o dia com mais disposição e menos estresse!");
        } else if (escolha1 == 2) {
            energia -= 5;
            felicidade -= 2;
            estresse += 5;
            pontuacao -= 3;
            System.out.println("Você se sentiu um pouco mais estressado, mas conseguiu começar o dia.");
        } else if (escolha1 == 3) {
            energia -= 3;
            felicidade -= 3;
            estresse += 2;
            pontuacao -= 2;
            System.out.println("Você se distraiu um pouco, mas não foi a melhor maneira de começar o dia.");
        }

        // Situação no trabalho
        System.out.println("\nNo trabalho, você recebe uma tarefa desafiadora. O que faz?");
        System.out.println("1. Pede ajuda a um colega.");
        System.out.println("2. Tenta resolver sozinho, mas fica sobrecarregado.");
        System.out.println("3. Ignora a tarefa e procrastina.");
        int escolha2 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha2 == 1) {
            energia += 5;
            felicidade += 10;
            estresse -= 5;
            pontuacao += 8;
            System.out.println("Você se sentiu apoiado e resolveu a tarefa com facilidade!");
        } else if (escolha2 == 2) {
            energia -= 5;
            felicidade -= 5;
            estresse += 10;
            pontuacao -= 4;
            System.out.println("Você se sentiu sobrecarregado e estressado.");
        } else if (escolha2 == 3) {
            energia -= 3;
            felicidade -= 8;
            estresse += 5;
            pontuacao -= 6;
            System.out.println("Você evitou a tarefa, mas isso aumentou seu estresse.");
        }

        // Atividade de lazer
        System.out.println("\nApós o trabalho, você tem um tempo livre. O que decide fazer?");
        System.out.println("1. Vai ao parque fazer uma caminhada e relaxar.");
        System.out.println("2. Fica em casa, assiste TV e come fast food.");
        System.out.println("3. Faz um hobby criativo (pintura, escrita, música).");
        int escolha3 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha3 == 1) {
            energia += 5;
            felicidade += 15;
            estresse -= 10;
            pontuacao += 10;
            System.out.println("A caminhada te ajudou a relaxar e você se sente mais feliz!");
        } else if (escolha3 == 2) {
            energia -= 5;
            felicidade -= 5;
            estresse += 5;
            pontuacao -= 4;
            System.out.println("Você se sentiu um pouco vazio após comer fast food e não fazer nada produtivo.");
        } else if (escolha3 == 3) {
            energia += 10;
            felicidade += 10;
            estresse -= 5;
            pontuacao += 12;
            System.out.println("Você se sentiu criativo e renovado após dedicar um tempo ao seu hobby!");
        }
    }

    private void feedbackFinal() {
        System.out.println("\nFim da jornada! Vamos ver como você está:");
        System.out.println("Energia: " + energia + "/100");
        System.out.println("Felicidade: " + felicidade + "/100");
        System.out.println("Estresse: " + estresse + "/100");
        System.out.println("Pontuação final: " + pontuacao);

        if (pontuacao >= 30) {
            System.out.println("Excelente! Você tem um bom equilíbrio entre as suas atividades e cuida bem da sua saúde mental.");
        } else if (pontuacao >= 10) {
            System.out.println("Bom trabalho! No entanto, há alguns pontos em que você pode melhorar.");
        } else {
            System.out.println("Você está enfrentando dificuldades. Lembre-se de cuidar mais de sua saúde mental e buscar ajuda quando necessário.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do personagem:");
        String nome = scanner.nextLine();
        JogoSaudeMentalAvancado jogo = new JogoSaudeMentalAvancado(nome);
        jogo.iniciarJogo(scanner);
    }
}
