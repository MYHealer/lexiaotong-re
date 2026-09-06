package com.ubix.ssp.ad.e.b0.i;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8802a = null;
    private static Handler b = null;
    private static boolean c = true;
    private LinkedHashMap<Integer, b> d = new LinkedHashMap<>();

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.b0.i.a$a, reason: collision with other inner class name */
    class RunnableC1092a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8803a;

        RunnableC1092a(int i) {
            this.f8803a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.c) {
                return;
            }
            a.this.c();
            a.this.a(this.f8803a);
        }
    }

    public static synchronized a b() {
        if (f8802a == null) {
            f8802a = new a();
            b = new Handler(Looper.getMainLooper());
        }
        return f8802a;
    }

    public void a(int i) {
        b.postDelayed(new RunnableC1092a(i), 150L);
    }

    public void a(int i, b bVar) {
        synchronized (this) {
            if (!this.d.containsKey(Integer.valueOf(i))) {
                this.d.put(Integer.valueOf(i), bVar);
            }
            if (this.d.size() > 0 && c) {
                c = false;
                a(i);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            if (this.d.containsKey(Integer.valueOf(i))) {
                this.d.remove(Integer.valueOf(i));
            }
            if (this.d.size() == 0) {
                c = true;
            }
        }
    }

    public boolean c() {
        try {
            for (Map.Entry entry : (Map.Entry[]) this.d.entrySet().toArray(new Map.Entry[0])) {
                b bVar = (b) entry.getValue();
                if (bVar != null) {
                    if (bVar.a()) {
                        bVar.b();
                    } else {
                        bVar.c();
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
