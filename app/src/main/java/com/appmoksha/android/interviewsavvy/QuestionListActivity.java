package com.appmoksha.android.interviewsavvy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.UUID;

/**
 * Created by pvatturi on 12/4/14.
 */
public class QuestionListActivity extends SingleFragmentActivity {

    private static UUID mTopicId;

    @Override
    protected Fragment createFragment() {
        UUID topicId = (UUID) getIntent()
                .getSerializableExtra(QuestionListFragment.EXTRA_TOPIC_ID);

        if (topicId != null) {
            mTopicId = topicId;
        }
        return QuestionListFragment.newInstance(mTopicId);
    }
}
