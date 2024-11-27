package quizapp;

import java.util.ArrayList;

public class QuizRepository {
    private ArrayList<Quiz> quizList; // クイズを格納するリスト

    // コンストラクタ
    public QuizRepository() {
        quizList = new ArrayList<>();
        initializeQuizzes(); // クイズの初期化
    }

    // クイズをリストに追加
    public void addQuiz(Quiz quiz) {
        quizList.add(quiz);
    }

    // 指定されたインデックスのクイズを取得
    public Quiz getQuiz(int index) {
        if (index >= 0 && index < quizList.size()) {
            return quizList.get(index);
        } else {
            return null;
        }
    }

    // クイズの総数を取得
    public int getQuizCount() {
        return quizList.size();
    }

    // クイズの初期化
    private void initializeQuizzes() {
        // サンプルクイズを追加
        addQuiz(new Quiz("Javaの基本データ型に含まれないものはどれ？", new String[] {
            "1. int",
            "2. boolean",
            "3. String",
            "4. double"
        }, 3)); // 正解は "String"

        addQuiz(new Quiz("Javaの配列はどのように宣言しますか？", new String[] {
            "1. int[] array = new int[5];",
            "2. array = int[5];",
            "3. int array = [5];",
            "4. int array = new int(5);"
        }, 1)); // 正解は "int[] array = new int[5];"

        addQuiz(new Quiz("オブジェクト指向の概念に含まれないものはどれ？", new String[] {
            "1. 継承",
            "2. カプセル化",
            "3. ポリモーフィズム",
            "4. コンパイル"
        }, 4)); // 正解は "コンパイル"
    }

    // クイズリストを取得するメソッド
    public ArrayList<Quiz> getQuizList() {
        return quizList; // Quizリスト全体を返す
    }
}
