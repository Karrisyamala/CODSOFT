import java.util.Scanner;

public class QuizApplicationWithTimer {

    public static void main(String[] args) {
        String[] questions = {
                "What is the capital of India?",
                "Who is the author of 'To Kill a Mockingbird'?",
                "What is the chemical symbol for gold?"
        };

        String[][] options = {
                {"A. Mumbai", "B. New Delhi", "C. Kolkata", "D. Chennai"},
                {"A. Harper Lee", "B. J.K. Rowling", "C. Charles Dickens", "D. Jane Austen"},
                {"A. Au", "B. Ag", "C. Hg", "D. Fe"}
        };

        String[] answers = {"B", "A", "A"};

        int score = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (A, B, C, or D): ");

            try {
                // Add a timer for each question (e.g., 15 seconds)
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}