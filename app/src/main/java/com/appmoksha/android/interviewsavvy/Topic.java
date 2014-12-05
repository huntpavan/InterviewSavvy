package com.appmoksha.android.interviewsavvy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by pvatturi on 11/20/14.
 */


public class Topic {

    private String mTitle;
    private String mLogo;
    //private ArrayList<QuestionAndAnswer> mQuestionAndAnswers;
    private ArrayList<String> mQuestions;
    private ArrayList<String> mAnswers;
    private int mSize;
    private UUID mId;


    public Topic(JSONObject jsonObject) throws JSONException {
        mId = UUID.randomUUID();
        mTitle = jsonObject.getString("name");
        mLogo = jsonObject.getString("logo");
        //mQuestionAndAnswers = new ArrayList<QuestionAndAnswer>();

        mQuestions = new ArrayList<String>();
        mAnswers = new ArrayList<String>();

        // Parsing list of  QuestionAndAnswers
        JSONArray qalist = jsonObject.getJSONArray("qalist");
        for (int i=0 ; i<qalist.length() ; i++) {
            JSONObject qa = qalist.getJSONObject(i);
            String question = qa.getString("question");
            JSONArray jsonArray = qa.getJSONArray("answer");
            StringBuilder sb = new StringBuilder();
            for(int j=0; j < jsonArray.length(); j++){
                sb.append(jsonArray.getString(j));
            }
            String answer = sb.toString();
            //mQuestionAndAnswers.add(new QuestionAndAnswer(question, answer));
            mQuestions.add(question);
            mAnswers.add(answer);
        }
        //mSize = mQuestionAndAnswers.size();
        mSize = mQuestions.size();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    //public ArrayList<QuestionAndAnswer> getQuestionAndAnswers() {
    //    return mQuestionAndAnswers;
    //}

    public int numQuestionAndAnswers() {
        return mSize;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getQuestion(int qid) {
        return mQuestions.get(qid);
    }

    public String getAnswer(int qid) {
        return mAnswers.get(qid);
    }

    public ArrayList<String> getAllQuestions() {
        return mQuestions;
    }
}
