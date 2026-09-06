package com.hihonor.adsdk.base;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadse = "ActivityManager";
    private static volatile a hnadsf;
    private int hnadsb = 0;
    private boolean hnadsc = false;
    private final ArrayList<Activity> hnadsd = new ArrayList<>();
    private final List<Activity> hnadsa = new ArrayList();

    public synchronized void hnadsb(Activity activity) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onActivityPaused activity = " + activity, new Object[0]);
        this.hnadsd.remove(activity);
    }

    public synchronized Activity hnadsc() {
        if (this.hnadsa.size() == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getTopActivity: is empty ", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder("getTopActivity: ");
        List<Activity> list = this.hnadsa;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, sb.append(list.get(list.size() - 1).getClass().getName()).toString(), new Object[0]);
        List<Activity> list2 = this.hnadsa;
        return list2.get(list2.size() - 1);
    }

    public synchronized void hnadsd(Activity activity) {
        if (activity != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "remove activity: " + activity.getClass().getName(), new Object[0]);
            this.hnadsa.remove(activity);
        }
    }

    public boolean hnadsd() {
        return this.hnadsc;
    }

    public static a hnadsa() {
        if (hnadsf == null) {
            synchronized (a.class) {
                if (hnadsf == null) {
                    hnadsf = new a();
                }
            }
        }
        return hnadsf;
    }

    public synchronized Activity hnadsb() {
        if (this.hnadsd.isEmpty()) {
            return null;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "getResumeActivity activity = " + this.hnadsd.get(0), new Object[0]);
        return this.hnadsd.get(0);
    }

    public synchronized void hnadse() {
        if (this.hnadsb == 0) {
            this.hnadsc = true;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onActivityStarted foreground", new Object[0]);
        }
        this.hnadsb++;
    }

    public synchronized void hnadsf() {
        int i = this.hnadsb - 1;
        this.hnadsb = i;
        if (i == 0) {
            this.hnadsc = false;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onActivityStarted background", new Object[0]);
        }
    }

    public synchronized void hnadsc(Activity activity) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onActivityResumed activity = " + activity, new Object[0]);
        this.hnadsd.add(activity);
    }

    public synchronized void hnadsa(Activity activity) {
        if (activity != null) {
            if (!this.hnadsa.contains(activity)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "add activity: " + activity.getClass().getName(), new Object[0]);
                this.hnadsa.add(activity);
            }
        }
    }

    public synchronized void hnadsa(String str) {
        for (Activity activity : this.hnadsa) {
            if (activity.getClass().getName().equals(str)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "finish activity: " + activity.getClass().getName(), new Object[0]);
                activity.finish();
            }
        }
    }
}
