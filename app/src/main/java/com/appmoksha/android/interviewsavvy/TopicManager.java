package com.appmoksha.android.interviewsavvy;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by pvatturi on 11/20/14.
 */
public class TopicManager {

    private final String TAG = "TopicManager";
    private ArrayList<Topic> mTopics;
    private static TopicManager sTopicManager;
    private Context mAppContext;
    private List<String> mTopicJsonFiles = Arrays.asList(
            "operating_systems.json", "networks.json", "databases.json", "c_lang.json", "oop.json");

    private TopicManager(Context appContext) {
        mAppContext = appContext;
        mTopics = new ArrayList<Topic>();
        try {
            loadTopics();
        } catch (Exception e) {
            Log.e(TAG, "Error loading topics: ", e);
        }
    }

    private void loadTopics() throws IOException, JSONException {
        BufferedReader reader = null;
        try {
            for (String filename: mTopicJsonFiles) {
                InputStream in = mAppContext.getResources().getAssets().open(filename);
                //mAppContext.openFileInput(filename);
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder jsonString = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    jsonString.append(line);
                }

                JSONObject jsonObject = (JSONObject) new JSONTokener(jsonString.toString()).nextValue();
                mTopics.add(new Topic(jsonObject));
            }
        } catch (FileNotFoundException e) {
        } finally {
            if (reader != null)
                reader.close();
            }
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

    public Topic getTopic(UUID id) {
        for (Topic t : mTopics) {
            if (t.getId().equals(id))
                return t;
        }
        return null;
    }
}
