package com.saudeMental;

import java.util.ArrayList;
import java.util.Scanner;

public class CuidandoDeVoce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo de saúde mental! Escolha o jogo que deseja jogar:");
        System.out.println("1. Cuidando de Você (Jogo de Escolhas)");
        System.out.println("2. Três Coisas Boas (Jogo de Gratidão)");
        System.out.println("3. Desenhe Seus Sentimentos (Autoexpressão)");
        System.out.print("Escolha uma opção (1-3): ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (escolha) {
            case 1:
                JogoSaudeMental jogoEscolhas = new JogoSaudeMental();
                jogoEscolhas.iniciarJogo(scanner);
                break;
            case 2:
                JogoGratidao jogoGratidao = new JogoGratidao();
                jogoGratidao.iniciarJogo(scanner);
                break;
            case 3:
                JogoAutoexpressao jogoAutoexpressao = new JogoAutoexpressao();
                jogoAutoexpressao.iniciarJogo(scanner);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}

// Jogo de Escolhas - Cuidando de Você
class JogoSaudeMental {
    private int pontuacao;

    public JogoSaudeMental() {
        this.pontuacao = 0;
    }

    public void iniciarJogo(Scanner scanner) {
        System.out.println("Vamos começar o jogo 'Cuidando de Você'!");
        System.out.println("Você teve um dia estressante. O que você faz?");
        System.out.println("1. Meditar\n2. Comer besteiras\n3. Fazer uma caminhada");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1, 3 -> {
                pontuacao++;
                System.out.println("Boa escolha! Sua pontuação de saúde mental aumentou.");
            }
            case 2 -> System.out.println("Ok, todo mundo precisa relaxar de vez em quando.");
            default -> System.out.println("Opção inválida.");
        }
        System.out.println("Pontuação final: " + pontuacao);
    }
}

// Jogo de Gratidão - Três Coisas Boas
class JogoGratidao {
    public void iniciarJogo(Scanner scanner) {
        System.out.println("Vamos praticar a gratidão! Informe três coisas boas do seu dia:");
        ArrayList<String> coisasBoas = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Coisa boa " + i + ": ");
            String coisa = scanner.nextLine();
            coisasBoas.add(coisa);
        }

        System.out.println("Ótimo! Aqui estão as coisas boas que você mencionou:");
        for (String coisa : coisasBoas) {
            System.out.println("- " + coisa);
        }
        System.out.println("Lembre-se sempre das pequenas coisas boas do seu dia!");
    }
}

// Jogo de Autoexpressão - Desenhe Seus Sentimentos
class JogoAutoexpressao {
    public void iniciarJogo(Scanner scanner) {
        System.out.println("Descreva como você está se sentindo hoje:");
        String sentimento = scanner.nextLine();
        System.out.println("Seus sentimentos em forma de imagem mental:");
        System.out.println("🎨 '" + sentimento + "' pode ser como uma pintura abstrata cheia de cores e emoções!");
    }
}
