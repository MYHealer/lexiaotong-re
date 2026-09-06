package com.yfanads.android.qapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class Pr extends Instrumentation {
    public static final boolean PRINT_LOG = false;
    private static String TAG = "YFAds";
    private final Instrumentation base;
    private String[] ucf;
    private String url = "";

    public Pr(Instrumentation instrumentation, String str, String[] strArr) {
        this.base = instrumentation;
        TAG = str;
        try {
            this.ucf = strArr;
            StringBuilder sb = new StringBuilder("hook uris: ");
            String[] strArr2 = this.ucf;
            log(str, sb.append(strArr2 != null ? strArr2.length : 0).toString());
        } catch (Exception e) {
            log(TAG, "hook parse uris failed " + e.getMessage());
        }
    }

    private boolean ce(Intent intent) {
        String str;
        String str2;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            str = TAG;
            str2 = "hook extras is null ";
        } else {
            Set<String> setKeySet = extras.keySet();
            if (setKeySet != null && !setKeySet.isEmpty()) {
                Iterator<String> it = setKeySet.iterator();
                while (it.hasNext()) {
                    Object obj = extras.get(it.next());
                    log(TAG, "hook checkExtras " + obj);
                    if (obj instanceof String) {
                        String str3 = (String) obj;
                        if (mr(str3)) {
                            this.url = str3;
                            return true;
                        }
                    }
                }
                return false;
            }
            str = TAG;
            str2 = "hook extras key empty ";
        }
        log(str, str2);
        return false;
    }

    private boolean cu(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        return mr(data.toString());
    }

    private Instrumentation.ActivityResult iol(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        try {
            Method declaredMethod = Instrumentation.class.getDeclaredMethod(Val.EXEC, Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class);
            declaredMethod.setAccessible(true);
            try {
                return (Instrumentation.ActivityResult) declaredMethod.invoke(this.base, context, iBinder, iBinder2, activity, intent, Integer.valueOf(i), bundle);
            } catch (Exception e) {
                e = e;
                throw new RuntimeException(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private void log(String str, String str2) {
    }

    private void logIntentWithExtras(Context context, Activity activity, Intent intent, int i, Bundle bundle) {
    }

    private boolean mr(String str) {
        log(TAG, "hook quick-app uri: " + str);
        for (String str2 : this.ucf) {
            if (mr(str, str2)) {
                log(TAG, "hook blocked quick-app uri: " + str2);
                return true;
            }
        }
        return false;
    }

    private boolean mr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str.startsWith(str2);
    }

    private boolean sb(Intent intent) {
        String[] strArr;
        if (intent == null || (strArr = this.ucf) == null || strArr.length == 0) {
            return false;
        }
        log(TAG, "hook shouldBlock");
        if (cu(intent)) {
            return true;
        }
        return ce(intent);
    }

    public Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle) {
        if (!sb(intent)) {
            logIntentWithExtras(context, activity, intent, i, bundle);
            return iol(context, iBinder, iBinder2, activity, intent, i, bundle);
        }
        Log.d(TAG, "hook blocked " + intent + "|" + this.url);
        Intent intent2 = new Intent(context, (Class<?>) DummyActivity.class);
        intent2.putExtra("blocked_original", intent.toUri(0));
        return iol(context, iBinder, iBinder2, activity, intent2, i, bundle);
    }
}
