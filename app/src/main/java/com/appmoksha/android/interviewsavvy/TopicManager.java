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

        Topic networks_topic = new Topic("Networks: Basics");
        networks_topic.LoadTopic("xyz");
        mTopics.add(networks_topic);

        Topic db_topic = new Topic("Databases");
        db_topic.LoadTopic("xyz");
        mTopics.add(db_topic);

        Topic os_topic = new Topic("Operating Systems");
        os_topic.LoadTopic("xyz");
        mTopics.add(os_topic);
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
