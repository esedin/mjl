package com.yard42.android.techread;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.androidquery.AQuery;
import com.androidquery.util.AQUtility;

import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    AQuery aq;
    RecyclerView gridView;
    StaggeredGridLayoutManager layoutManager;
    AdapterMain adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aq = new AQuery(this);
        AQUtility.setDebug(true);

        gridView = new RecyclerView(this);
        gridView.setHasFixedSize(true);

        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        gridView.setLayoutManager(layoutManager);
        gridView.setItemAnimator(new DefaultItemAnimator());
        getWindow().setContentView(gridView);

        adapter
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
