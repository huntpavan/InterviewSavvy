package com.appmoksha.android.interviewsavvy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by pvatturi on 11/22/14.
 */
public class TopicQAFragment extends Fragment {

    public static final String EXTRA_TOPIC_ID =
            "com.appmoksha.android.interviewsavvy.topic_id";

    public static final String EXTRA_QUESTION_ID =
            "com.appmoksha.android.interviewsavvy.question_id";

    private Topic mTopic;
    private int mQid;
    private TextView mQuestion;
    private TextView mAnswer;

    public static TopicQAFragment newInstance(UUID topicId, int qId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TOPIC_ID, topicId);
        args.putSerializable(EXTRA_QUESTION_ID, qId);
        TopicQAFragment fragment = new TopicQAFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID topicId = (UUID) getArguments().getSerializable(EXTRA_TOPIC_ID);
        mTopic = TopicManager.get(getActivity()).getTopic(topicId);
        mQid = getArguments().getInt(EXTRA_QUESTION_ID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.topic_qa_fragment, container, false);

        mQuestion = (TextView) v.findViewById(R.id.question_textView);
        mQuestion.setText(mTopic.getQuestion(mQid));

        mAnswer = (TextView) v.findViewById(R.id.answer_textView);
        //mAnswer.setText(mTopic.getAnswer(mQid));
        mAnswer.setText(Html.fromHtml(mTopic.getAnswer(mQid)));

        return v;

    }

}
