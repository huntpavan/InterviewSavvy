package com.appmoksha.android.interviewsavvy;

/**
 * Created by pvatturi on 11/20/14.
 */
public class QuestionAndAnswer {

    private String mQuestion;
    private String mAnswer;

    public QuestionAndAnswer(String question, String answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }
}
