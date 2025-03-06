package com.saudeMental;

import java.util.Scanner;

public class JogoAutoexpressao {
    public void iniciarJogo(Scanner scanner) {
        System.out.println("Descreva como você está se sentindo hoje:");
        String sentimento = scanner.nextLine();
        System.out.println("Seus sentimentos em forma de imagem mental:");
        System.out.println("🎨 '" + sentimento + "' pode ser como uma pintura abstrata cheia de cores e emoções!");
    }
}
