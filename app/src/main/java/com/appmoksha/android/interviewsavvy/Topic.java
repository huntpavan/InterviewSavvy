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
    private ArrayList<QuestionAndAnswer> mQuestionAndAnswers;
    private UUID mId;


    public Topic(JSONObject jsonObject) throws JSONException {
        mId = UUID.randomUUID();
        mTitle = jsonObject.getString("name");
        mLogo = jsonObject.getString("logo");
        mQuestionAndAnswers = new ArrayList<QuestionAndAnswer>();

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
            Log.i("Pavan", "\n\nquestion ----->>>" + question);
            Log.i("Pavan", "\n\nanswer ----->>>" + answer);
            mQuestionAndAnswers.add(new QuestionAndAnswer(question, answer));
        }
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

    public ArrayList<QuestionAndAnswer> getQuestionAndAnswers() {
        return mQuestionAndAnswers;
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

    public String getQuestion(int qid) {
        return mQuestionAndAnswers.get(qid).getQuestion();
    }

    public String getAnswer(int qid) {
        return mQuestionAndAnswers.get(qid).getAnswer();
    }
}
