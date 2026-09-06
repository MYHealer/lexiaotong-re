package com.hihonor.hianalytics.module;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface IScreenAutoTracker {
    Map<String, String> getTrackProperties();

    default String getTrackerId() {
        String strF = SystemUtils.f();
        return (TextUtils.isEmpty(strF) ? "" : strF + "/") + getClass().getName();
    }
}
