package com.appmoksha.android.interviewsavvy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by pvatturi on 12/4/14.
 */
public class QuestionListFragment extends ListFragment {

    private static final String TAG = "QuestionListFragment";
    public static final String EXTRA_TOPIC_ID =
            "com.appmoksha.android.interviewsavvy.topic_id";

    private ArrayList<String> mQuestions;
    private UUID mTopicId;

    public static QuestionListFragment newInstance(UUID topicId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TOPIC_ID, topicId);
        QuestionListFragment fragment = new QuestionListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTopicId = (UUID) getArguments().getSerializable(EXTRA_TOPIC_ID);
        Topic topic = TopicManager.get(getActivity()).getTopic(mTopicId);
        getActivity().setTitle(topic.getTitle());

        mQuestions = topic.getAllQuestions();
        QuestionAdapter adapter = new QuestionAdapter(mQuestions);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d(TAG, "Question " + position + " was clicked ------>>>>.");

        Intent i = new Intent(getActivity(), TopicQAPagerActivity.class);
        i.putExtra(TopicQAFragment.EXTRA_TOPIC_ID, mTopicId);
        i.putExtra(TopicQAFragment.EXTRA_QUESTION_ID, position);
        startActivity(i);
    }

    private class QuestionAdapter extends ArrayAdapter<String> {


        public QuestionAdapter(ArrayList<String> questions) {
            super(getActivity(), 0, questions);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_question, null);
            }
            String question = getItem(position);

            TextView titleTextView =
                    (TextView) convertView.findViewById(R.id.question_list_textView);
            titleTextView.setText(question);

            return convertView;
        }
    }
}