package com.saudeMental;

import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

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
        // Conectar ao MongoDB e preparar o handler
        String connectionString = "mongodb+srv://sudemental:saude123456@conhecimento.jproi.mongodb.net/?retryWrites=true&w=majority&appName=conhecimento";
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("saudeMentalDB");
        DatabaseHandler dbHandler = new DatabaseHandler(database);
       
       
        System.out.println("Bem-vindo à 'Jornada do Bem-Estar Mental'!");
        System.out.println("Olá, " + nomePersonagem + "! Vamos embarcar nessa jornada para melhorar seu bem-estar mental.");
        System.out.println("Seu objetivo é encontrar equilíbrio, tomar boas decisões e melhorar sua qualidade de vida.");

        // Ciclo diário 1
        cicloDiario1(scanner);

        // Ciclo diário 2
        cicloDiario2(scanner);

        // Feedback final baseado nas condições do personagem
        feedbackFinal();


        // Salvar os resultados no banco de dados
        dbHandler.salvarResultados(nomePersonagem, energia, felicidade, estresse, pontuacao);
    }

    private void cicloDiario1(Scanner scanner) {
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
        
        // Problema inesperado
        System.out.println("\nDe repente, você enfrenta um imprevisto. Como lida com isso?");
        System.out.println("1. Resolve o problema rapidamente e continua o seu dia.");
        System.out.println("2. Fica preocupado e deixa o problema te afetar o resto do dia.");
        System.out.println("3. Tenta ignorar o problema e espera que ele se resolva sozinho.");
        int escolha6 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha6 == 1) {
            energia += 5;
            felicidade += 10;
            estresse -= 5;
            pontuacao += 8;
            System.out.println("Você resolveu o imprevisto de maneira eficiente e o dia seguiu tranquilo.");
        } else if (escolha6 == 2) {
            energia -= 5;
            felicidade -= 8;
            estresse += 10;
            pontuacao -= 6;
            System.out.println("A preocupação te deixou mais estressado e afetou seu humor.");
        } else if (escolha6 == 3) {
            energia -= 3;
            felicidade -= 4;
            estresse += 6;
            pontuacao -= 5;
            System.out.println("Ignorar o problema não foi a melhor escolha e te deixou mais tenso.");
        }
                // Decisão no final do dia
        System.out.println("\nEstá no final do dia, e você tem que decidir como descansar. O que faz?");
        System.out.println("1. Lê um livro antes de dormir.");
        System.out.println("2. Passa o tempo nas redes sociais, até pegar no sono.");
        System.out.println("3. Faz uma meditação rápida para relaxar.");
        int escolha5 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha5 == 1) {
            energia += 5;
            felicidade += 8;
            estresse -= 5;
            pontuacao += 7;
            System.out.println("A leitura foi relaxante e ajudou você a desacelerar para a noite.");
        } else if (escolha5 == 2) {
            energia -= 3;
            felicidade -= 3;
            estresse += 4;
            pontuacao -= 4;
            System.out.println("Você acabou ficando mais estressado e com dificuldade para dormir.");
        } else if (escolha5 == 3) {
            energia += 8;
            felicidade += 5;
            estresse -= 10;
            pontuacao += 9;
            System.out.println("A meditação te trouxe um grande alívio e você se sentiu mais tranquilo.");
        }

    }


private void cicloDiario2(Scanner scanner) {
    System.out.println("\nOutro dia se inicia! Como você lida com os desafios?");
    System.out.println("1. Participa de uma aula de yoga para relaxar o corpo e a mente.");
    System.out.println("2. Enfrenta um engarrafamento e chega atrasado ao trabalho.");
    System.out.println("3. Aproveita a manhã para ler um livro inspirador.");
    int escolha1 = scanner.nextInt();
    scanner.nextLine();

    if (escolha1 == 1) {
        energia += 8;
        felicidade += 10;
        estresse -= 7;
        pontuacao += 7;
        System.out.println("A prática de yoga te trouxe paz e energia renovada!");
    } else if (escolha1 == 2) {
        energia -= 8;
        felicidade -= 5;
        estresse += 10;
        pontuacao -= 5;
        System.out.println("O trânsito foi estressante e afetou seu humor.");
    } else if (escolha1 == 3) {
        energia += 5;
        felicidade += 8;
        estresse -= 5;
        pontuacao += 6;
        System.out.println("A leitura te trouxe inspiração e tranquilidade.");
    }

    // Pergunta sobre alimentação
    System.out.println("\nNa hora do almoço, você escolhe:");
    System.out.println("1. Comer uma refeição saudável e equilibrada.");
    System.out.println("2. Comer fast food pela praticidade.");
    System.out.println("3. Pular o almoço por falta de apetite.");
    int escolha2 = scanner.nextInt();
    scanner.nextLine();

    if (escolha2 == 1) {
        energia += 10;
        felicidade += 5;
        estresse -= 3;
        pontuacao += 8;
        System.out.println("Uma boa refeição te deixou mais disposto e feliz!");
    } else if (escolha2 == 2) {
        energia -= 5;
        felicidade -= 2;
        estresse += 2;
        pontuacao -= 3;
        System.out.println("O fast food foi rápido, mas não trouxe muito benefício para seu bem-estar.");
    } else if (escolha2 == 3) {
        energia -= 10;
        felicidade -= 5;
        estresse += 5;
        pontuacao -= 5;
        System.out.println("Pular refeições prejudica sua energia e seu humor.");
    }


    // Pergunta sobre atividade social
    System.out.println("\nApós o expediente, um amigo te convida para sair. O que você faz?");
    System.out.println("1. Aceita o convite e vai socializar.");
    System.out.println("2. Prefere ficar em casa e descansar.");
    System.out.println("3. Vai para a academia liberar o estresse.");
    int escolha3 = scanner.nextInt();
    scanner.nextLine();

    if (escolha3 == 1) {
        energia -= 5;
        felicidade += 10;
        estresse -= 5;
        pontuacao += 8;
        System.out.println("Socializar te fez bem e aumentou sua felicidade!");
    } else if (escolha3 == 2) {
        energia += 5;
        felicidade -= 2;
        estresse -= 2;
        pontuacao += 4;
        System.out.println("Descansar te ajudou a recuperar energia.");
    } else if (escolha3 == 3) {
        energia -= 5;
        felicidade += 7;
        estresse -= 10;
        pontuacao += 10;
        System.out.println("Exercitar-se foi ótimo para aliviar o estresse e melhorar seu humor!");
    }

            // Desafio de saúde
        System.out.println("\nVocê percebe que sua saúde não está tão boa. O que decide fazer?");
        System.out.println("1. Vai ao médico para resolver o problema de saúde.");
        System.out.println("2. Tenta melhorar com remédios caseiros.");
        System.out.println("3. Ignora o problema e espera que melhore sozinho.");
        int escolha7 = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Impactos das escolhas
        if (escolha7 == 1) {
            energia += 10;
            felicidade += 8;
            estresse -= 6;
            pontuacao += 10;
            System.out.println("A visita ao médico foi útil e você começou a se sentir melhor.");
        } else if (escolha7 == 2) {
            energia += 3;
            felicidade += 2;
            estresse += 4;
            pontuacao += 2;
            System.out.println("Os remédios caseiros ajudaram um pouco, mas você ainda se sente mal.");
        } else if (escolha7 == 3) {
            energia -= 5;
            felicidade -= 7;
            estresse += 8;
            pontuacao -= 5;
            System.out.println("Ignorar a saúde piorou a situação e te deixou mais preocupado.");
        }


    // Nova pergunta: Antes de dormir
    System.out.println("\nAntes de dormir, você decide:");
    System.out.println("1. Meditar para acalmar a mente.");
    System.out.println("2. Ficar no celular até tarde.");
    System.out.println("3. Ler um livro leve para relaxar.");
    int escolha4 = scanner.nextInt();
    scanner.nextLine();

    if (escolha4 == 1) {
        energia += 5;
        felicidade += 8;
        estresse -= 5;
        pontuacao += 7;
        System.out.println("A meditação te ajudou a ter uma noite tranquila e revigorante.");
    } else if (escolha4 == 2) {
        energia -= 8;
        felicidade -= 5;
        estresse += 5;
        pontuacao -= 3;
        System.out.println("O uso excessivo do celular prejudicou seu sono e seu bem-estar.");
    } else if (escolha4 == 3) {
        energia += 3;
        felicidade += 6;
        estresse -= 3;
        pontuacao += 5;
        System.out.println("A leitura leve ajudou você a relaxar antes de dormir.");
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
