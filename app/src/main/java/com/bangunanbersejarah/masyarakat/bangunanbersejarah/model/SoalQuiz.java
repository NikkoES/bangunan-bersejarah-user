package com.bangunanbersejarah.masyarakat.bangunanbersejarah.model;

public class SoalQuiz {

    String question;
    String answerOne;
    String answerTwo;
    String answerThree;
    String answerFour;
    String correctAnswer;

    public SoalQuiz(String question, String answerOne, String answerTwo, String answerThree, String answerFour, String correctAnswer) {
        this.question = question;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
