package com.appmoksha.android.interviewsavvy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;


public class TopicListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TopicListFragment();
    }

}
