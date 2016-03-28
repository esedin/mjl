package com.yard42.rxdroid;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FirstObservable extends Fragment{

    private File mFilesDir;
    private ApplicationAdapter mAdapter;

    @InjectView(R.id.first_fragment_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.first_fragment_swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contianer, Bundle state){
        return inflater.inflate(R.layout.first_fragment, contianer, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        mAdapter = new ApplicationAdapter(new ArrayList<>(), R.layout.grid_item);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.myPrimaryColor));
        mSwipeRefreshLayout.setProgressViewOffset(false, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24,
                        getResources().getDisplayMetrics()));

        mSwipeRefreshLayout.setOnRefreshListener(this::refreshTheList);

        mSwipeRefreshLayout.setEnabled(true);
        mSwipeRefreshLayout.setRefreshing(true);
        mRecyclerView.setVisibility(View.GONE);

        getFileDir().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(file -> {mFilesDir = file; refreshTheList();});
    }

    private void refreshTheList() {
        getApps().toSortedList().subscribe(new Observer<List<AppInfo>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(getActivity(), "Here is the list!", Toast.LENGTH_LONG).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onNext(List<AppInfo> appInfos) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mAdapter.addApplications(appInfos);
                mSwipeRefreshLayout.setRefreshing(false);
                storeList(appInfos);
            }
        });
    }

    private void storeList(List<AppInfo> appInfos) {
        ApplicationsList.getInstance().setList(appInfos);

        Schedulers.io().createWorker().schedule(() -> {
            SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
            Type appInfoType = new TypeToken<List<AppInfo>>() {
            }.getType();
            sharedPref.edit().putString("APPS", new Gson().toJson(appInfos, appInfoType)).apply();
        });
    }

    private Observable<File> getFileDir() {
            return Observable.create(subscriber -> {
                subscriber.onNext(App.instance.getFilesDir());
                subscriber.onCompleted();
            });
    }

    private Observable<AppInfo> getApps() {
        return Observable.create(subscriber -> {
            List<AppInfoRich> apps = new ArrayList<>();
            final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            List<ResolveInfo> infos = getActivity().getPackageManager().queryIntentActivities(mainIntent, 0);
            for(ResolveInfo resolveInfo : infos)
            {
                apps.add(new AppInfoRich(getActivity(), resolveInfo));
            }

            for (AppInfoRich appInfoRich : apps)
            {
                Bitmap icon = Utils.drawableToBitmap(appInfoRich.getIcon());
                String name = appInfoRich.getName();
                String iconPath = mFilesDir + "/" + name;
                Utils.storeBitmap(App.instance, icon, name);

                if (subscriber.isUnsubscribed()) { return; }

                subscriber.onNext(new AppInfo(name, iconPath, appInfoRich.getLastUpdateTime()));
            }
            if (!subscriber.isUnsubscribed())
            {
                subscriber.onCompleted();
            }
        });
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
