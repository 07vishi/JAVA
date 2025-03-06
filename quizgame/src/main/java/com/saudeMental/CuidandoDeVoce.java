package com.saudeMental;

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
                // Alterado para a classe JogoSaudeMentalAvancado
                JogoSaudeMentalAvancado jogoEscolhas = new JogoSaudeMentalAvancado("Personagem");
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
