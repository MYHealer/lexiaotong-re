package com.byazt.jna;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import com.byazt.bog.a;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 755, 54})
public class ve implements Application.ActivityLifecycleCallbacks {
    public Fragment c;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public ve(Fragment fragment) {
        this.c = fragment;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        Object obj;
        if (this.c.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    obj = null;
                    break;
                }
                obj = objArr[i];
                Object field = FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(field) || ((field instanceof String) && (((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                    break;
                    break;
                }
                i++;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    Object obj2 = objArr[i3];
                    if (obj2 != obj) {
                        objArr2[i2] = obj2;
                        iArr[i2] = i3;
                        i2++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            a.c(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Object[] objArr;
        Object obj;
        if (this.c.getActivity() != activity) {
            return;
        }
        try {
            Parcelable parcelable = bundle.getParcelable("android:fragments");
            if (parcelable == null || (objArr = (Object[]) FieldUtils.readField(parcelable, "mActive")) == null) {
                return;
            }
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    obj = null;
                    break;
                }
                obj = objArr[i];
                Object field = FieldUtils.readField(obj, "mTag");
                if ("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_plugin".equals(field) || ((field instanceof String) && (((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle") || ((String) field).contains("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag_pangle")))) {
                    break;
                    break;
                    break;
                }
                i++;
            }
            if (obj != null) {
                Object[] objArr2 = (Object[]) Array.newInstance(Class.forName("android.app.FragmentState"), objArr.length - 1);
                int[] iArr = new int[objArr.length - 1];
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    Object obj2 = objArr[i3];
                    if (obj2 != obj) {
                        objArr2[i2] = obj2;
                        iArr[i2] = i3;
                        i2++;
                    }
                }
                FieldUtils.writeField(parcelable, "mActive", objArr2);
                FieldUtils.writeField(parcelable, "mAdded", iArr);
            }
        } catch (Throwable th) {
            a.c(th);
        }
    }
}
