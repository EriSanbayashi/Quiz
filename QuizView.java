package quizapp;

import java.util.Scanner;

public class QuizView {
    private Scanner scanner;

    // コンストラクタ
    public QuizView(QuizRepository quizRepository) {
        scanner = new Scanner(System.in);
    }

    // クイズの問題文と選択肢を表示
    public void displayQuiz(Quiz quiz) {
        System.out.println("問題: " + quiz.getQuestion());
        String[] options = quiz.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ": " + options[i]);
        }
    }

    // ユーザーから回答を入力
    public int getUserAnswer() {
        System.out.print("あなたの回答を入力してください (1-4): ");
        while (true) {
            try {
                int answer = Integer.parseInt(scanner.nextLine());
                if (answer >= 1 && answer <= 4) {
                    return answer;
                } else {
                    System.out.print("無効な入力です。1から4の数字を入力してください: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("無効な入力です。数字を入力してください: ");
            }
        }
    }

    // 正解・不正解の結果を表示
    public void displayResult(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("正解です！");
        } else {
            System.out.println("残念、不正解です。");
        }
    }

    // 総合得点を表示
    public void displayScore(int score, int total) {
        System.out.println("あなたの得点: " + score + "/" + total);
    }

    // 再挑戦するかを尋ねるメソッド
    public boolean askRetry() {
        System.out.print("もう一度挑戦しますか？ (1: はい, 0: いいえ): ");
        int response = scanner.nextInt(); // ユーザー入力を取得
        return response == 1;
    }
}
