package com.hihonor.updater.installsdk;

import android.text.TextUtils;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f3724a = new ConcurrentHashMap<>();

    public static List<String> a() {
        return new ArrayList(f3724a.keySet());
    }

    private static boolean a(int i) {
        return -1 == i || 2008 == i || 2012 == i;
    }

    public static boolean a(AppStatusInfo appStatusInfo) {
        if (appStatusInfo == null) {
            return true;
        }
        return a(appStatusInfo.getStatus());
    }

    public static void b(AppStatusInfo appStatusInfo) {
        if (appStatusInfo == null || TextUtils.isEmpty(appStatusInfo.getPackageName())) {
            return;
        }
        String packageName = appStatusInfo.getPackageName();
        int status = appStatusInfo.getStatus();
        synchronized (a.class) {
            f3724a.put(packageName, Integer.valueOf(status));
        }
    }

    public static boolean b() {
        int iIntValue;
        synchronized (a.class) {
            ConcurrentHashMap<String, Integer> concurrentHashMap = f3724a;
            if (concurrentHashMap.isEmpty()) {
                return false;
            }
            com.hihonor.updater.installsdk.c.a.c("a", "record size=" + concurrentHashMap.size());
            for (String str : concurrentHashMap.keySet()) {
                Integer num = f3724a.get(str);
                if (num != null && (iIntValue = num.intValue()) != -1 && iIntValue != 2012 && iIntValue != 2008) {
                    com.hihonor.updater.installsdk.c.a.c("a", "incomplete task " + str + PPSLabelView.Code + iIntValue);
                    return true;
                }
            }
            return false;
        }
    }
}
