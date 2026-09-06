package com.byazt.ia;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.byazt.hv.TTDownloadField;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.ld;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT, 13})
public class tt {
    public static com.byazt.uy.uj nu;
    public Application c;
    public long da;
    public String i;
    public long m;
    public String sl;
    public String sp;
    public long t;
    public Context tt;
    public String u;
    public long x;
    public long yp;
    public String z;
    public List<String> ve = new ArrayList();
    public List<Long> uj = new ArrayList();
    public List<String> n = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Long> f2325a = new ArrayList();
    public int rh = 0;
    public boolean my = false;
    public final Application.ActivityLifecycleCallbacks gt = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.ia.tt.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            String strC;
            tt ttVar = tt.this;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            ttVar.sp = strC;
            tt.this.x = System.currentTimeMillis();
            tt.this.ve.add(tt.this.sp);
            tt.this.uj.add(Long.valueOf(tt.this.x));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            String strC;
            tt ttVar = tt.this;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            ttVar.i = strC;
            tt.this.da = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String strC;
            tt ttVar = tt.this;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            ttVar.sl = strC;
            tt.this.t = System.currentTimeMillis();
            tt.this.my = true;
            tt.n(tt.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String strC;
            tt ttVar = tt.this;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            ttVar.u = strC;
            tt.this.yp = System.currentTimeMillis();
            tt.a(tt.this);
            if (tt.this.rh <= 0) {
                tt.this.my = false;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            String strC;
            tt ttVar = tt.this;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            ttVar.z = strC;
            tt.this.m = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String strC;
            if (tt.nu == null) {
                strC = activity.getClass().getName();
            } else {
                strC = tt.nu.c(activity);
            }
            int iIndexOf = tt.this.ve.indexOf(strC);
            if (iIndexOf >= 0 && iIndexOf < tt.this.ve.size()) {
                tt.this.ve.remove(iIndexOf);
                tt.this.uj.remove(iIndexOf);
            }
            tt.this.n.add(strC);
            tt.this.f2325a.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    public boolean ve() {
        return this.my;
    }

    public static /* synthetic */ int a(tt ttVar) {
        int i = ttVar.rh;
        ttVar.rh = i - 1;
        return i;
    }

    public static /* synthetic */ int n(tt ttVar) {
        int i = ttVar.rh;
        ttVar.rh = i + 1;
        return i;
    }

    public tt(Context context) {
        this.tt = context;
        if (context instanceof Application) {
            this.c = (Application) context;
        }
        n();
    }

    private void n() {
        Application application = this.c;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.gt);
        }
    }

    private JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.ve;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.ve.size(); i++) {
                try {
                    jSONArray.put(c(this.ve.get(i), this.uj.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray sp() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.n;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.n.size(); i++) {
                try {
                    jSONArray.put(c(this.n.get(i), this.f2325a.get(i).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONObject c(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put(CrashHianalyticsData.TIME, j);
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", c(this.sp, this.x));
            jSONObject.put("last_start_activity", c(this.i, this.da));
            jSONObject.put("last_resume_activity", c(this.sl, this.t));
            jSONObject.put("last_pause_activity", c(this.u, this.yp));
            jSONObject.put("last_stop_activity", c(this.z, this.m));
            jSONObject.put("alive_activities", a());
            jSONObject.put("finish_activities", sp());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray tt() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.tt.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
                return jSONArray;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                        jSONObject.put(ld.L, runningTaskInfo.description);
                        jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                        jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                        jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                        jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }
}
