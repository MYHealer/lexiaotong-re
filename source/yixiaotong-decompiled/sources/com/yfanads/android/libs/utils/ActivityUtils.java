package com.yfanads.android.libs.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.hv.TTDownloadField;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class ActivityUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ActivityUtils";

    private static List<Activity> getActivities() {
        return getActivities(getActivitiesInActivityThread());
    }

    private static List<Activity> getActivities(Object obj) {
        if (obj != null) {
            return toActivityList(obj);
        }
        return null;
    }

    private static Object getActivitiesInActivityThread() {
        return ReflectUtils.reflect(null, "android.app.ActivityThread#currentActivityThread().mActivities");
    }

    private static Application getApplication() {
        return (Application) ReflectUtils.reflect(null, "android.app.ActivityThread#currentApplication()");
    }

    public static Activity getTopActivity() {
        try {
            return getTopActivity(getActivities());
        } catch (Exception unused) {
            return null;
        }
    }

    private static Activity getTopActivity(List<Activity> list) {
        try {
            Activity topActivityByIsTopOfTask = getTopActivityByIsTopOfTask(list);
            if (topActivityByIsTopOfTask != null) {
                return topActivityByIsTopOfTask;
            }
        } catch (ReflectUtils.ReflectException unused) {
        }
        try {
            Activity topActivityByResume = getTopActivityByResume(list);
            if (topActivityByResume != null) {
                return topActivityByResume;
            }
        } catch (ReflectUtils.ReflectException unused2) {
        }
        try {
            Activity topActivityByActivityManager = getTopActivityByActivityManager(getApplication(), list);
            if (topActivityByActivityManager != null) {
                return topActivityByActivityManager;
            }
            return null;
        } catch (ReflectUtils.ReflectException unused3) {
            return null;
        }
    }

    private static Activity getTopActivityByActivityManager(Context context, List<Activity> list) {
        ActivityManager activityManager = (ActivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService(TTDownloadField.TT_ACTIVITY);
        String packageName = context.getPackageName();
        List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
        int size = appTasks.size();
        boolean z = false;
        Activity activity = null;
        String className = null;
        for (int i = 0; i < size; i++) {
            ActivityManager.RecentTaskInfo taskInfo = appTasks.get((size - 1) - i).getTaskInfo();
            if (packageName.equals(taskInfo.baseActivity.getPackageName())) {
                className = taskInfo.topActivity.getClassName();
            }
        }
        if (TextUtils.isEmpty(className)) {
            Log.i(TAG, "尝试通过getTopActivityByActivityManager获取Activity失败");
            return null;
        }
        if (list != null) {
            Activity activity2 = null;
            for (Activity activity3 : list) {
                if (className.equals(activity3.getClass().getName())) {
                    if (z) {
                        Log.i(TAG, "尝试通过getTopActivityByActivityManager获取Activity失败");
                        return null;
                    }
                    z = true;
                    activity2 = activity3;
                }
            }
            activity = activity2;
        }
        if (activity == null) {
            Log.w(TAG, "尝试通过getTopActivityByActivityManager获取Activity失败");
        } else {
            Log.i(TAG, "尝试通过getTopActivityByActivityManager获取Activity成功");
        }
        return activity;
    }

    private static Activity getTopActivityByIsTopOfTask(List<Activity> list) {
        for (Activity activity : list) {
            if (((Boolean) ReflectUtils.reflect(activity, "isTopOfTask()")).booleanValue()) {
                Log.i(TAG, "尝试通过getTopActivityByIsTopOfTask获取Activity成功");
                return activity;
            }
        }
        Log.w(TAG, "尝试通过getTopActivityByIsTopOfTask获取Activity失败");
        return null;
    }

    private static Activity getTopActivityByResume(List<Activity> list) {
        for (Activity activity : list) {
            if (((Boolean) ReflectUtils.reflect(activity, "mResumed")).booleanValue()) {
                Log.i(TAG, "尝试通过getTopActivityByResume获取Activity成功");
                return activity;
            }
        }
        Log.w(TAG, "尝试通过getTopActivityByResume获取Activity失败");
        return null;
    }

    private static List<Activity> toActivityList(Object obj) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (obj instanceof Map) {
            Iterator it = ((Map) obj).entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add((Activity) ReflectUtils.reflect(((Map.Entry) it.next()).getValue(), TTDownloadField.TT_ACTIVITY));
            }
        }
        return arrayList;
    }
}
