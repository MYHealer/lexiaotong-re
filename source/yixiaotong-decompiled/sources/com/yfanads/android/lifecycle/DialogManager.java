package com.yfanads.android.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DialogManager implements Application.ActivityLifecycleCallbacks {
    private static DialogManager instance;
    private final Map<String, List<Dialog>> dialogMap = new WeakHashMap();

    private DialogManager(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public static DialogManager getInstance() {
        return instance;
    }

    public static void init(Context context) {
        if (context instanceof Application) {
            Application application = (Application) context;
            if (instance == null) {
                instance = new DialogManager(application);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        List<Dialog> list = this.dialogMap.get(activity.getLocalClassName());
        if (list != null) {
            for (Dialog dialog : list) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            list.clear();
        }
        this.dialogMap.remove(activity.getLocalClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public void registerDialog(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || dialog == null) {
            return;
        }
        List<Dialog> arrayList = this.dialogMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.dialogMap.put(str, arrayList);
        }
        arrayList.add(dialog);
    }

    public void unregisterDialog(String str, Dialog dialog) {
        List<Dialog> list;
        if (TextUtils.isEmpty(str) || dialog == null || (list = this.dialogMap.get(str)) == null) {
            return;
        }
        list.remove(dialog);
    }
}
