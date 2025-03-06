package com.saudeMental;

import java.util.ArrayList;
import java.util.Scanner;

public class JogoGratidao {
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
