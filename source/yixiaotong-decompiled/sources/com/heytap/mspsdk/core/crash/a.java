package com.heytap.mspsdk.core.crash;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.heytap.mspsdk.constants.Constants;
import com.heytap.mspsdk.log.MspLog;
import com.heytap.mspsdk.util.e;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, List<c>> f3461a;
    private static b b = new b();

    /* JADX INFO: renamed from: com.heytap.mspsdk.core.crash.a$a, reason: collision with other inner class name */
    private static class C0421a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f3462a = new a();
    }

    public static a a() {
        return C0421a.f3462a;
    }

    public static String a(Context context, String str) {
        return str.contains("com.heytap.htms") ? str.replace("com.heytap.htms", com.heytap.mspsdk.core.b.a(context).f()) : str;
    }

    private static void a(Map<String, List<c>> map) {
        f3461a = map;
    }

    private void b(final Context context) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(context);
            }
        });
    }

    private synchronized void b(final Context context, final String str, final int i, final int i2, final int i3, final String str2) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.c(context, str, i, i2, i3, str2);
            }
        });
    }

    private synchronized void c(final Context context) {
        com.heytap.mspsdk.executor.b.a().a(new Runnable() { // from class: com.heytap.mspsdk.core.crash.a$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                a.d(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, String str, int i, int i2, int i3, String str2) {
        try {
            e eVar = new e(context, Constants.SP_COMMON_FILE, 0);
            eVar.b("key_process_name", str);
            eVar.b("key_crash_count", Integer.valueOf(i));
            eVar.b("key_launch_count", Integer.valueOf(i2));
            eVar.b("key_version_code", Integer.valueOf(i3));
            eVar.b("key_version_name", str2);
            eVar.a();
        } catch (Exception e) {
            MspLog.e("AppCrashManager", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context) {
        try {
            new e(context, Constants.SP_COMMON_FILE, 0).a("key_version_code").a("key_version_name").a("key_crash_count").a("key_launch_count").a("key_process_name").a();
        } catch (Exception e) {
            MspLog.e("AppCrashManager", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Context context) {
        int iIntValue = ((Integer) new e(context, Constants.SP_COMMON_FILE, 0).a("key_version_code", 0)).intValue();
        if (iIntValue > 0) {
            com.heytap.mspsdk.core.b bVarA = com.heytap.mspsdk.core.b.a(context);
            int iE = bVarA.e();
            String strD = bVarA.d();
            if (iE > iIntValue) {
                a(context, iE, strD);
            }
        }
    }

    public void a(Context context) {
        MspLog.d("AppCrashManager", "registerCrashReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.heytap.htms.sub_process_crash");
        int i = Build.VERSION.SDK_INT;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (i >= 33) {
            origApplicationContext.registerReceiver(b, intentFilter, 4);
        } else {
            origApplicationContext.registerReceiver(b, intentFilter);
        }
    }

    public synchronized void a(Context context, int i, String str) {
        c(context);
        for (String str2 : f3461a.keySet()) {
            List<c> list = f3461a.get(str2);
            if (list != null && list.size() > 0) {
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(str2, i, str);
                }
            }
        }
    }

    public synchronized void a(Context context, String str, int i, int i2, int i3, String str2) {
        b(context, str, i, i2, i3, str2);
        if (f3461a.containsKey(str)) {
            List<c> list = f3461a.get(str);
            if (list != null && list.size() > 0) {
                Iterator<c> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(i2, i, str, i3, str2);
                }
            }
        }
    }

    public synchronized void a(Context context, String str, c cVar) {
        MspLog.d("AppCrashManager", "addMspProcessCrashListener:" + str);
        if (f3461a == null) {
            a(new ConcurrentHashMap());
        }
        List<c> copyOnWriteArrayList = f3461a.containsKey(str) ? f3461a.get(str) : null;
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (copyOnWriteArrayList.size() > 10) {
            return;
        }
        copyOnWriteArrayList.add(cVar);
        f3461a.put(str, copyOnWriteArrayList);
        b(context);
    }
}
