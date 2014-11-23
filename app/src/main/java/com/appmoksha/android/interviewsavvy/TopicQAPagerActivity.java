package com.appmoksha.android.interviewsavvy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by pvatturi on 11/22/14.
 */
public class TopicQAPagerActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private Topic mTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        final UUID topicId = (UUID) getIntent()
                .getSerializableExtra(TopicQAFragment.EXTRA_TOPIC_ID);
        mTopic = TopicManager.get(this).getTopic(topicId);
        setTitle(mTopic.getTitle());

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return TopicQAFragment.newInstance(topicId, i);
            }

            @Override
            public int getCount() {
                return mTopic.numQuestionAndAnswers();
            }
        });
    }
}