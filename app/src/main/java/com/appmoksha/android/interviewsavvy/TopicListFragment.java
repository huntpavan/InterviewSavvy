package com.appmoksha.android.interviewsavvy;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pvatturi on 11/20/14.
 */
public class TopicListFragment extends ListFragment {

    private static final String TAG = "TopicListFragment";
    private ArrayList<Topic> mTopics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.topics_title);

        mTopics = TopicManager.get(getActivity()).getTopics();
        TopicAdapter adapter = new TopicAdapter(mTopics);
        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setDividerHeight(0);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Topic t = ((TopicAdapter) getListAdapter()).getItem(position);
        Log.d(TAG, t.getTitle() + " was clicked.");
    }

    @Override
    public void onResume() {
        super.onResume();
        ((TopicAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class TopicAdapter extends ArrayAdapter<Topic> {

        public TopicAdapter(ArrayList<Topic> Topics) {
            super(getActivity(), 0, Topics);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_topic, null);
            }
            Topic t = getItem(position);


            TextView titleTextView =
                    (TextView) convertView.findViewById(R.id.topic_list_item_titleTextView);
            titleTextView.setText(t.getTitle());

            TextView questionsTextView =
                    (TextView) convertView.findViewById(R.id.topic_list_item_questionsTextView);
            questionsTextView.setText(t.numQuestionAndAnswers() + " questions");

            return convertView;


        }
    }

}
