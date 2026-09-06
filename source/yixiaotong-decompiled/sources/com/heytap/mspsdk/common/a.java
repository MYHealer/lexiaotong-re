package com.heytap.mspsdk.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.byazt.hv.TTDownloadField;
import com.heytap.mspsdk.log.MspLog;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f3456a;

    /* JADX INFO: renamed from: com.heytap.mspsdk.common.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.heytap.mspsdk.common.a$a, reason: collision with other inner class name */
    private static class C0420a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3457a = new a(null);
    }

    private a() {
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        return C0420a.f3457a;
    }

    private static Activity c() {
        StringBuilder sb;
        String message;
        MspLog.d("ActivityLifeCallBack", "get activity from reflect");
        try {
            Class<?> cls = Class.forName(Val.AT);
            Object objInvoke = cls.getMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (ClassNotFoundException e) {
            sb = new StringBuilder("getActivityReflect: ");
            message = e.getMessage();
            MspLog.e("ActivityLifeCallBack", sb.append(message).toString());
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder("getActivityReflect: ");
            message = e2.getMessage();
            MspLog.e("ActivityLifeCallBack", sb.append(message).toString());
        } catch (NoSuchFieldException e3) {
            sb = new StringBuilder("getActivityReflect: ");
            message = e3.getMessage();
            MspLog.e("ActivityLifeCallBack", sb.append(message).toString());
        } catch (NoSuchMethodException e4) {
            sb = new StringBuilder("getActivityReflect: ");
            message = e4.getMessage();
            MspLog.e("ActivityLifeCallBack", sb.append(message).toString());
        } catch (InvocationTargetException e5) {
            sb = new StringBuilder("getActivityReflect: ");
            message = e5.getMessage();
            MspLog.e("ActivityLifeCallBack", sb.append(message).toString());
        }
        return null;
    }

    public Activity b() {
        Activity activity = this.f3456a;
        return activity == null ? c() : activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityCreated " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f3456a = null;
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityPaused " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f3456a = activity;
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityResumed " + activity.getClass().getSimpleName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        MspLog.iIgnore("ActivityLifeCallBack", "onActivityStopped " + activity.getClass().getSimpleName());
    }
}
