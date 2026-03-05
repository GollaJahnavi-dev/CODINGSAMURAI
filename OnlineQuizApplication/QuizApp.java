import java.util.*;

public class QuizApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add Questions
        questions.add(new Question(
                "What is JVM?",
                new String[]{"Java Virtual Machine", "Java Vendor Machine", "Just Virtual Method", "None"},
                1));

        questions.add(new Question(
                "Which keyword is used for inheritance?",
                new String[]{"implement", "extends", "inherits", "super"},
                2));

        questions.add(new Question(
                "Which collection allows dynamic resizing?",
                new String[]{"Array", "LinkedList", "ArrayList", "Stack"},
                3));

        questions.add(new Question(
                "Which company developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"},
                2));

        questions.add(new Question(
                "Which method is the entry point of Java program?",
                new String[]{"start()", "main()", "run()", "init()"},
                2));

        questions.add(new Question(
                "Which keyword is used to create object?",
                new String[]{"class", "new", "object", "create"},
                2));

        questions.add(new Question(
                "Which package contains Scanner class?",
                new String[]{"java.io", "java.net", "java.util", "java.lang"},
                3));

        questions.add(new Question(
                "Which concept allows method overriding?",
                new String[]{"Encapsulation", "Abstraction", "Polymorphism", "Compilation"},
                3));

        boolean retry = true;

        while (retry) {

            int score = 0;

             ArrayList<Integer> userAnswers = new ArrayList<>();

            Collections.shuffle(questions);

            int questionNumber = 1;

            for (Question q : questions) {

                System.out.println("\nQ" + questionNumber + ": " + q.getQuestion());

                for (int i = 0; i < q.getOptions().length; i++) {
                    System.out.println((i + 1) + ". " + q.getOptions()[i]);
                }

                int userAnswer;

                while (true) {
                    System.out.print("Your answer: ");
                    userAnswer = sc.nextInt();

                    if (userAnswer >= 1 && userAnswer <= q.getOptions().length) {
                        break;
                    } else {
                        System.out.println("Invalid option! Please enter between 1 and "
                                + q.getOptions().length);
                    }
                }

                 userAnswers.add(userAnswer);

                if (userAnswer == q.getCorrectAnswer()) {
                    System.out.println("Correct");
                    score++;
                } else {
                    System.out.println("Wrong");
                    System.out.println("Correct Answer: "
                            + q.getOptions()[q.getCorrectAnswer() - 1]);
                }

                questionNumber++;
            }

             // Quiz Summary
            System.out.println("\n===== QUIZ SUMMARY =====");

            for (int i = 0; i < questions.size(); i++) {

                Question q = questions.get(i);
                int userAnswer = userAnswers.get(i);

                System.out.println("\nQ" + (i + 1) + ": " + q.getQuestion());
                System.out.println("Your Answer: " + q.getOptions()[userAnswer - 1]);
                System.out.println("Correct Answer: " +
                        q.getOptions()[q.getCorrectAnswer() - 1]);

                if (userAnswer == q.getCorrectAnswer()) {
                    System.out.println("Result: Correct");
                } else {
                    System.out.println("Result: Wrong");
                }
            }

            // Score
            System.out.println("\nYour Score: " + score + "/" + questions.size());

            double percentage = ((double) score / questions.size()) * 100;
            System.out.println("Percentage: " + percentage + "%");

            System.out.print("\nDo you want to retry? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                retry = false;
                System.out.println("Thank you for taking the quiz!");
            }
        }

        sc.close();
    }
}
