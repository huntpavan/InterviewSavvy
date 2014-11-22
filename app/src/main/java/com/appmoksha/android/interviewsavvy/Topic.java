package com.appmoksha.android.interviewsavvy;

import java.util.ArrayList;

/**
 * Created by pvatturi on 11/20/14.
 */


public class Topic {

    private String mTitle;
    private ArrayList<QuestionAndAnswer> mQuestionAndAnswers;
    private String mLogo;

    public Topic(String title, String logo) {
        mTitle = title;
        mLogo = logo;
        mQuestionAndAnswers = new ArrayList<QuestionAndAnswer>();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public ArrayList<QuestionAndAnswer> getQuestionAndAnswers() {
        return mQuestionAndAnswers;
    }

    public void LoadTopic(String qa_source_file) {
        mQuestionAndAnswers.add(new QuestionAndAnswer("Question 1?", "Answer 1: blah blah"));
        mQuestionAndAnswers.add(new QuestionAndAnswer("Question 2?", "Answer 2: blah blah"));
    }

    public int numQuestionAndAnswers() {
        return mQuestionAndAnswers.size();
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }
}
