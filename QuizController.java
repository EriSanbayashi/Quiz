package quizapp;

import java.util.Collections;

public class QuizController {
    private QuizRepository quizRepository; // クイズデータを管理
    private QuizView quizView; // ユーザーインターフェースを管理

    // コンストラクタ
    public QuizController(QuizRepository quizRepository, QuizView quizView) {
        this.quizRepository = quizRepository;
        this.quizView = quizView;
    }

    // クイズアプリの実行
    public void runQuiz() {
        boolean isContinue = true; // 再挑戦フラグ

        while (isContinue) {
            Collections.shuffle(quizRepository.getQuizList()); // クイズリストをシャッフル

            int score = 0; // スコアの初期化
            int totalQuizzes = quizRepository.getQuizCount(); // 全クイズの数

            for (int i = 0; i < totalQuizzes; i++) {
                Quiz currentQuiz = quizRepository.getQuiz(i); // ランダムにクイズを取得
                quizView.displayQuiz(currentQuiz); // クイズを表示

                int userAnswer = quizView.getUserAnswer(); // ユーザーの回答を取得
                if (userAnswer == currentQuiz.getCorrectAnswer()) {
                    quizView.displayResult(true); // 正解の場合
                    score++; // スコアを加算
                } else {
                    quizView.displayResult(false); // 不正解の場合
                }

                System.out.println(); // 空行を入れて次のクイズへ
            }

            // 最終的な得点を表示
            quizView.displayScore(score, totalQuizzes); // 総得点を表示

            // 再挑戦の確認
            isContinue = quizView.askRetry(); // ユーザーに再挑戦するかを尋ねる
        }
    }
}
