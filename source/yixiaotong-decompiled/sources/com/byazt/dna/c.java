package com.byazt.dna;

import android.util.SparseArray;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public interface c<T> {
    int getAgeGroup();

    String getAppChannel();

    String getAppId();

    String getAppName();

    String getAppVersion();

    com.byazt.lz.c getCustomController();

    String getData();

    int[] getDirectDownloadNetworkType();

    Object getExtra(String str);

    Map<String, Object> getInitExtra();

    String getKeywords();

    com.byazt.lz.a getMediationConfig();

    String getPackageName();

    int getPluginUpdateConfig();

    String getSdkApiVersion();

    int getThemeStatus();

    int getTitleBarTheme();

    String getVersionCode();

    boolean isAllowShowNotify();

    boolean isDebug();

    boolean isPaid();

    boolean isPlugin();

    boolean isSupportMultiProcess();

    boolean isUseMediation();

    void updateInitParams(SparseArray sparseArray);
}
