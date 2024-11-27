package quizapp;

public class QuizApp {
    public static void main(String[] args) {
        // QuizRepositoryのインスタンスを作成
        QuizRepository quizRepository = new QuizRepository();

        // QuizViewとQuizControllerのインスタンスを作成
        QuizView quizView = new QuizView(quizRepository);
        QuizController quizController = new QuizController(quizRepository, quizView);

        // クイズアプリの実行
        quizController.runQuiz();
    }
}
