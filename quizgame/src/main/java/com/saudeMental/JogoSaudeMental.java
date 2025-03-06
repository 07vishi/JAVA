package com.saudeMental;

import java.util.Scanner;

public class JogoSaudeMental {
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
