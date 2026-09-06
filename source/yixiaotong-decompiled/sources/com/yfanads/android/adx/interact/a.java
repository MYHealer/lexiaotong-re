package com.yfanads.android.adx.interact;

import android.hardware.SensorManager;
import android.os.Vibrator;
import java.util.HashMap;

/* JADX INFO: compiled from: ActionManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements com.yfanads.android.adx.interact.b.a, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f9602a;
    public Vibrator b;
    public int c;
    public float d;
    public com.yfanads.android.adx.interact.b e;
    public d f;
    public final HashMap g = new HashMap();
    public boolean h = true;
    public long i;
    public boolean j;
    public volatile boolean k;
    public InterfaceC1172a l;

    /* JADX INFO: renamed from: com.yfanads.android.adx.interact.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionManager.java */
    public interface InterfaceC1172a {
        void a(int i, String[] strArr);
    }

    /* JADX INFO: compiled from: ActionManager.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9603a = new a();
    }

    public final void a(int i, int i2, String[] strArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.i;
        com.yfanads.android.adx.utils.a.a("action shakeOrTwist tempLast = " + j);
        if (j <= 1200.0f) {
            HashMap map = this.g;
            Integer numValueOf = Integer.valueOf(i);
            Boolean bool = Boolean.TRUE;
            map.put(numValueOf, bool);
            if (!this.h && this.j && bool.equals(this.g.get(0)) && bool.equals(this.g.get(1))) {
                com.yfanads.android.adx.utils.a.a("action setAction ");
                Vibrator vibrator = this.b;
                if (vibrator != null) {
                    vibrator.vibrate(200L);
                }
                InterfaceC1172a interfaceC1172a = this.l;
                if (interfaceC1172a != null) {
                    interfaceC1172a.a(i2, strArr);
                }
                this.h = true;
                this.g.clear();
                return;
            }
            return;
        }
        this.g.clear();
        HashMap map2 = this.g;
        Integer numValueOf2 = Integer.valueOf(i);
        Boolean bool2 = Boolean.TRUE;
        map2.put(numValueOf2, bool2);
        com.yfanads.android.adx.utils.a.a("action shakeOrTwist " + this.g.get(0) + " , " + this.g.get(1));
        if (!this.j || (bool2.equals(this.g.get(0)) && bool2.equals(this.g.get(1)))) {
            com.yfanads.android.adx.utils.a.a("action setAction ");
            Vibrator vibrator2 = this.b;
            if (vibrator2 != null) {
                vibrator2.vibrate(200L);
            }
            InterfaceC1172a interfaceC1172a2 = this.l;
            if (interfaceC1172a2 != null) {
                interfaceC1172a2.a(i2, strArr);
            }
            this.g.clear();
        } else {
            this.h = false;
        }
        this.i = jCurrentTimeMillis;
    }

    public final void a(InterfaceC1172a interfaceC1172a) {
        this.l = interfaceC1172a;
    }

    public static a a() {
        return b.f9603a;
    }
}
