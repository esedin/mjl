package com.yard42.rxdroid;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(prefix = "m")
public class AppInfo implements Comparable<Object>{
    long mLastUpdateTime;

    String mName;

    String mIcon;

    public AppInfo(String name, String icon, long lastUpdateTime) {
        this.mLastUpdateTime = lastUpdateTime;
        this.mName = name;
        this.mIcon = icon;
    }

    @Override
    public int compareTo(Object another) {
        AppInfo appInfo = (AppInfo) another;
        return getName().compareTo(appInfo.getName());
    }
}
