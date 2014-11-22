package com.appmoksha.android.interviewsavvy;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by pvatturi on 11/20/14.
 */
public class TopicManager {

    private ArrayList<Topic> mTopics;
    private static TopicManager sTopicManager;
    private Context mAppContext;

    private TopicManager(Context appContext) {
        mAppContext = appContext;
        mTopics = new ArrayList<Topic>();

        Topic networks_topic = new Topic("Networks", "N");
        networks_topic.LoadTopic("xyz");
        mTopics.add(networks_topic);

        Topic db_topic = new Topic("Databases", "DB");
        db_topic.LoadTopic("xyz");
        mTopics.add(db_topic);

        Topic os_topic = new Topic("Operating Systems", "OS");
        os_topic.LoadTopic("xyz");
        mTopics.add(os_topic);

        Topic c_topic = new Topic("C Language", "C");
        os_topic.LoadTopic("xyz");
        mTopics.add(c_topic);

        Topic bit_topic = new Topic("Bit Questions ", "B");
        os_topic.LoadTopic("xyz");
        mTopics.add(bit_topic);

        Topic interview_topic = new Topic("Interview Questions ", "I");
        interview_topic.LoadTopic("xyz");
        mTopics.add(interview_topic);

    }

    public static TopicManager get(Context c) {
        if (sTopicManager == null) {
            sTopicManager = new TopicManager(c.getApplicationContext());
        }
        return sTopicManager;
    }

    public ArrayList<Topic> getTopics() {
        return mTopics;
    }
}
