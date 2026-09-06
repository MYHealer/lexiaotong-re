package com.fancy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.byazt.hv.TTDownloadField;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fl {
    public static final _fl _c = new _fl();
    public static int _d = 0;
    public final _a _a = new _a();
    public volatile boolean _b;

    public static final class _a implements Application.ActivityLifecycleCallbacks {
        public _g _a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPostStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPrePaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (_fl._d == 0) {
                _g _gVar = this._a;
                if (_gVar != null) {
                    _gVar._a();
                }
                ActionTrackManager actionTrackManager_a = ActionTrackManager._a();
                actionTrackManager_a.getClass();
                com.fancy.adsdk.lib.utils._d._b(new _d(actionTrackManager_a));
            }
            _fl._d++;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int i = _fl._d;
            if (i > 0) {
                _fl._d = i - 1;
            }
            if (_fl._d <= 0) {
                _g _gVar = this._a;
                if (_gVar != null) {
                    _gVar._b();
                }
                ActionTrackManager actionTrackManager_a = ActionTrackManager._a();
                actionTrackManager_a.getClass();
                com.fancy.adsdk.lib.utils._d._b(new _e(actionTrackManager_a));
            }
        }
    }

    public static boolean _a(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return true;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName)) {
                int i = runningAppProcessInfo.importance;
                return (i == 100 || i == 200) ? false : true;
            }
        }
        return true;
    }

    public final void _a(Context context, _g _gVar) {
        synchronized (_fl.class) {
            if (!this._b) {
                int i = 0;
                try {
                    Class<?> cls = Class.forName(Val.AT);
                    Object objInvoke = cls.getMethod(Val.CAT, new Class[0]).invoke(null, new Object[0]);
                    Field declaredField = cls.getDeclaredField("mActivities");
                    declaredField.setAccessible(true);
                    Map map = (Map) declaredField.get(objInvoke);
                    if (map != null && map.size() > 0) {
                        i = 1;
                    }
                } catch (Throwable unused) {
                }
                _d = i;
                Application application = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
                _a _aVar = this._a;
                _aVar._a = _gVar;
                application.registerActivityLifecycleCallbacks(_aVar);
            }
            this._b = true;
        }
    }
}
