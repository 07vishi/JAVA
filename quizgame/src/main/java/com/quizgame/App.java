package com.quizgame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear un objeto de tipo QuizGame
        QuizGame game = new QuizGame();

        // Mensaje de bienvenida
        System.out.println("Bienvenido al juego de preguntas!");

        // Iniciar el juego
        game.startGame(scanner);
    }
}

class QuizGame {
    private int score;
    private int questionIndex;

    private Question[] questions;

    public QuizGame() {
        this.score = 0;
        this.questionIndex = 0;
        this.questions = new Question[] {
            new Question("¿Cuál es la capital de Francia?", "París"),
            new Question("¿Cuántos continentes hay?", "7"),
            new Question("¿Cuál es el símbolo químico del agua?", "H2O"),
            new Question("¿Quién pintó la Mona Lisa?", "Leonardo da Vinci"),
            new Question("¿Qué año comenzó la Segunda Guerra Mundial?", "1939")
        };
    }

    // Método para iniciar el juego
    public void startGame(Scanner scanner) {
        System.out.println("¡Comencemos!");

        // Ciclo para hacer las preguntas
        while (questionIndex < questions.length) {
            Question currentQuestion = questions[questionIndex];
            System.out.println(currentQuestion.getQuestionText());
            String userAnswer = scanner.nextLine();

            if (currentQuestion.checkAnswer(userAnswer)) {
                score++;
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto. La respuesta correcta era: " + currentQuestion.getAnswer());
            }

            questionIndex++;
        }

        // Fin del juego
        System.out.println("El juego ha terminado. Tu puntuación final es: " + score);
    }
}

class Question {
    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAnswer() {
        return answer;
    }

    // Método para verificar la respuesta
    public boolean checkAnswer(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}
