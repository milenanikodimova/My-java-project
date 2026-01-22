import java.util.Scanner;

/* =======================
   MAIN КЛАС
   ======================= */
public class StaniBogat {

    public static void main(String[] args) {

        Question[] questions = QuestionData.getQuestions();
        Game game = new Game(questions);
        game.start();
    }
}

/* =======================
   КЛАС С ВЪПРОСИТЕ
   ======================= */
class QuestionData {

    public static Question[] getQuestions() {
        return new Question[] {
            new Question(
                "Коя е столицата на България?",
                new String[]{"A) Пловдив", "B) Варна", "C) София", "D) Бургас"},
                'C', 100
            ),
            new Question(
                "Кой философ въвежда понятието 'воля за власт'?",
                new String[]{"A) Хегел", "B) Ницше", "C) Шопенхауер", "D) Сартр"},
                'B', 150
            ),
            new Question(
                "Кой е написал романа 'Под игото'?",
                new String[]{"A) Елин Пелин", "B) Иван Вазов", "C) Христо Ботев", "D) Пенчо Славейков"},
                'B', 190
            ),
            new Question(
                "Кой е химичният символ на водата?",
                new String[]{"A) O2", "B) CO2", "C) H2O", "D) HO2"},
                'C', 200
            )
        };
    }
}

/* =======================
   КЛАС QUESTION
   ======================= */
class Question {

    private String text;
    private String[] options;
    private char correctAnswer;
    private int prize;

    public Question(String text, String[] options, char correctAnswer, int prize) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.prize = prize;
    }

    public void printQuestion() {
        System.out.println(text);
        for (String option : options) {
            System.out.println(option);
        }
    }

    public boolean isCorrect(char answer) {
        return answer == correctAnswer;
    }

    public int getPrize() {
        return prize;
    }
}

/* =======================
   КЛАС GAME
   ======================= */
class Game {

    private Question[] questions;
    private int prize;
    private Scanner input;

    public Game(Question[] questions) {
        this.questions = questions;
        this.prize = 0;
        this.input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добре дошъл в играта „СТАНИ БОГАТ“!");
        System.out.println("Отговаряй с A, B, C или D.\n");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("Въпрос " + (i + 1) + ":");
            questions[i].printQuestion();

            char answer = readAnswer();

            if (questions[i].isCorrect(answer)) {
                prize = questions[i].getPrize();
                System.out.println("Верен отговор! Печелиш " + prize + " лева.\n");

                if (i < questions.length - 1) {
                    if (!continueGame()) {
                        System.out.println("Ти напускаш играта с " + prize + " лева!");
                        break;
                    }
                } else {
                    System.out.println("Поздравления! Победи играта и спечели " + prize + " лева!");
                }

            } else {
                System.out.println("Грешен отговор! Тръгваш си с 0 лева.");
                break;
            }
        }

        input.close();
    }

    private char readAnswer() {
        while (true) {
            System.out.print("Твоят отговор: ");
            char answer = Character.toUpperCase(input.next().charAt(0));

            if (answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D') {
                return answer;
            }
            System.out.println("Няма такъв отговор! Опитай отново.\n");
        }
    }

    private boolean continueGame() {
        System.out.print("Искаш ли да продължиш? (y/n): ");
        return input.next().equalsIgnoreCase("y");
    }
}


