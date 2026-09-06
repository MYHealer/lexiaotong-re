package com.byazt.vm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 130})
public final class m {
    public static final String c = "m#";
    public static String da = null;
    public static long sl = 0;
    public static boolean t = false;
    public static final String tt = "m#";
    public static final List<com.byazt.gj.n> uj = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2817a;
    public final nu n;
    public final gt sp;
    public Map<String, String> u;
    public final Context x;
    public Long yp;
    public final ReentrantLock ve = new ReentrantLock();
    public final AtomicBoolean i = new AtomicBoolean(false);

    public nu c() {
        return this.n;
    }

    public m(Context context) {
        this.x = StubApp.getOrigApplicationContext(context.getApplicationContext());
        nu nuVarC = rh.c(context);
        this.n = nuVarC;
        if (nuVarC != null) {
            this.f2817a = nuVarC.tt(context);
        } else {
            this.f2817a = false;
        }
        this.sp = new gt(context);
    }

    public Map<String, String> c(long j) {
        if (!this.f2817a) {
            return null;
        }
        if (!com.byazt.gj.c.tt) {
            my myVarC = this.sp.c();
            if (myVarC != null) {
                return myVarC.c();
            }
            return null;
        }
        tt();
        if (this.u == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.ve.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.ve.unlock();
                }
            } catch (InterruptedException e) {
                com.byazt.yv.da.c(e);
            }
        }
        return this.u;
    }

    public static void c(com.byazt.gj.n nVar) {
        List<com.byazt.gj.n> list = uj;
        synchronized (list) {
            list.add(nVar);
        }
        if (da != null) {
            c(new com.byazt.gj.n.c(da, t, sl), new Object[]{nVar});
        }
    }

    private static Object[] ve() {
        Object[] array;
        List<com.byazt.gj.n> list = uj;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    private static void c(com.byazt.gj.n.c cVar, Object[] objArr) {
        if (cVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((com.byazt.gj.n) obj).c(cVar);
        }
    }

    public static void c(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            com.byazt.yv.da.c(e);
        }
    }

    public static <K, V> void c(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    public void tt() {
        if (this.i.compareAndSet(false, true)) {
            c(new Runnable() { // from class: com.byazt.vm.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.uj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        int iIntValue;
        try {
            this.ve.lock();
            my myVarC = this.sp.c();
            long jLongValue = -1;
            boolean z = false;
            if (myVarC != null) {
                da = myVarC.c;
                t = myVarC.ve != null && myVarC.ve.booleanValue();
                sl = myVarC.sp == null ? -1L : myVarC.sp.longValue();
                this.u = myVarC.c();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairC = c(this.x);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            my myVar = null;
            String string = null;
            if (pairC.first != null) {
                if (myVarC != null) {
                    string = myVarC.tt;
                    iIntValue = myVarC.f2818a.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                my myVar2 = new my((String) pairC.first, str, (Boolean) pairC.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.yp);
                this.sp.c(myVar2);
                myVar = myVar2;
            }
            if (myVar != null) {
                da = myVar.c;
                if (myVar.ve != null && myVar.ve.booleanValue()) {
                    z = true;
                }
                t = z;
                if (myVar.sp != null) {
                    jLongValue = myVar.sp.longValue();
                }
                sl = jLongValue;
                this.u = myVar.c();
            }
        } finally {
            this.ve.unlock();
            c(new com.byazt.gj.n.c(da, t, sl), ve());
        }
    }

    private Pair<String, Boolean> c(Context context) {
        String str;
        Boolean boolValueOf;
        nu.c cVarVe;
        nu nuVar = this.n;
        if (nuVar == null || (cVarVe = nuVar.ve(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = cVarVe.tt;
            boolValueOf = Boolean.valueOf(cVarVe.ve);
            if (cVarVe instanceof i.c) {
                this.yp = Long.valueOf(((i.c) cVarVe).c);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void c(Runnable runnable) {
        x.c(c + "-query", runnable);
    }
}
