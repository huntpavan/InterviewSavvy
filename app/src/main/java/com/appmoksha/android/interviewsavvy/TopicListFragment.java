package com.appmoksha.android.interviewsavvy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Topic t = ((TopicAdapter) getListAdapter()).getItem(position);
        Log.d(TAG, t.getTitle() + " was clicked.");

        Intent i = new Intent(getActivity(), TopicQAPagerActivity.class);
        i.putExtra(TopicQAFragment.EXTRA_TOPIC_ID, t.getId());
        startActivity(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((TopicAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class TopicAdapter extends ArrayAdapter<Topic> {

        private final List<Integer> mLogoColors = Arrays.asList(
                0xffff725e, 0xffAA66CC, 0xff99CC00, 0xffFFBB33, 0xffFF4444, 0xff33B5E5,
                0xFFFF688C, 0xFF3787FF);

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


            TextView logoTextView =
                    (TextView) convertView.findViewById(R.id.topic_list_item_logoTextView);
            logoTextView.setText(t.getLogo());
            logoTextView.setBackgroundColor(mLogoColors.get(position % mLogoColors.size()));

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
