package com.byazt.qi;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.byazt.hv.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.stub.StubApp;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 54})
public class ve {
    public static volatile ve c;
    public final ArrayList<String> tt = new ArrayList<>();
    public final AtomicBoolean ve = new AtomicBoolean(false);
    public long uj = System.currentTimeMillis();
    public long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2661a = 0;
    public String sp = "";
    public String x = "";
    public String i = "";
    public boolean da = false;
    public boolean sl = false;

    public static ve c(Application application) {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    ve veVar = new ve();
                    c = veVar;
                    veVar.da = da.c(application);
                    c.sl = da.c(StubApp.getOrigApplicationContext(application.getApplicationContext()), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    c.c();
                }
            }
        }
        return c;
    }

    public void c(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.tt.size() == 0) {
            this.sp = localClassName;
            this.n = System.currentTimeMillis();
            this.f2661a = System.currentTimeMillis() - this.uj;
            this.ve.set(false);
        }
        if (!this.tt.contains(localClassName)) {
            this.tt.add(localClassName);
        }
        this.i = localClassName;
    }

    public void tt(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.tt.contains(localClassName)) {
            this.tt.remove(localClassName);
        }
        if (this.tt.size() == 0) {
            this.uj = System.currentTimeMillis();
            this.ve.set(true);
            this.x = localClassName;
        }
    }

    private void c() {
        int size;
        try {
            Class<?> cls = Class.forName(Val.AT);
            Method declaredMethod = cls.getDeclaredMethod(Val.CAT, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.tt.contains(localClassName)) {
                            this.tt.add(localClassName);
                        }
                    }
                }
                this.ve.set(this.tt.size() <= 0);
            }
        } catch (Exception unused) {
        }
    }

    public String c(String str, long j, int i, boolean z) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.n;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.ve.get() && this.sl) {
            i2 |= 2;
        }
        if (!this.ve.get() && this.f2661a >= 5000 && j2 < 1000) {
            i2 = this.x.equals(this.i) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("bakdur", this.f2661a).put("popt", j2).put("uct", j3).put("isbak", this.ve).put("alert", this.sl).put("rit", i).put("tag", str).put(NotificationCompat.CATEGORY_SYSTEM, this.da).put(OapsKey.KEY_SIZE, this.tt.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.sp = "";
        this.f2661a = 0L;
        this.n = 0L;
        this.uj = System.currentTimeMillis();
        return string;
    }
}
