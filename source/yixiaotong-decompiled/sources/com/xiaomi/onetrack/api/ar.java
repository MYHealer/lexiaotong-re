package com.xiaomi.onetrack.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.analytics.ITrack;
import com.xiaomi.onetrack.Configuration;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ar {
    private static final int h = 1;
    private static final int i = 2;
    private static volatile ar k;
    private volatile ITrack d;
    private b j;
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{97, 84, 16, 16, 91, 2, 4, 39, 9, 12, 95, 0, 81, 69, 47, 7, 92, 0, 6, 1, Ascii.DC4}, "21bf2a");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9417a = ijiami_1011.s.s.s.d(new byte[]{85, 89, 11, Ascii.FS, 85, 94, Ascii.DC4, 13, 72, 3, 95, 4, 90, 79, Ascii.DC2, 91, 91, 68}, "66f287");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{91, 90, 88, 79, 88, 81, Ascii.DC4, 13, 72, 3, 95, 4, 84, 76, 65, 8, 86, 75, 79, 11, 8, 7, 69, Ascii.ETB, 89, 86, 94, 79, 122, 86, 4, 48, Ascii.DC4, 3, 82, 14, 107, 80, 71, Ascii.ETB, 92, 91, 4}, "855a58");
    private static String l = ijiami_1011.s.s.s.d(new byte[]{92, 11, 7, Ascii.NAK, Ascii.SYN, 84, 2, 15, 57, 17, 84, Ascii.ETB, 69, 12, 1, 4, 59, 86, 14, 10, 8, 7, 82, 17}, "3ebad5");
    private AtomicBoolean e = new AtomicBoolean(false);
    private AtomicBoolean f = new AtomicBoolean(false);
    private AtomicBoolean m = new AtomicBoolean(false);
    private ServiceConnection n = new ServiceConnection() { // from class: com.xiaomi.onetrack.api.ServiceConnectionManager$1
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            try {
                try {
                    this.f9398a.g.unbindService(this.f9398a.n);
                } catch (Exception e) {
                    com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{96, 83, 75, 67, 8, 81, 4, 39, 9, 12, 95, 0, 80, 66, 116, 84, 15, 83, 6, 1, Ascii.DC4}, "3695a2"), ijiami_1011.s.s.s.d(new byte[]{11, 13, 118, 10, 89, 80, 8, 10, 1, 38, 88, 0, 0, 89, Ascii.DC4}, "dc4c74") + e.toString());
                }
                this.f9398a.c();
            } catch (Throwable th) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{100, 82, 68, Ascii.NAK, 10, 86, 4, 39, 9, 12, 95, 0, 84, 67, 123, 2, 13, 84, 6, 1, Ascii.DC4}, "776cc5"), ijiami_1011.s.s.s.d(new byte[]{88, 92, 33, 12, 89, 92, 8, 10, 1, 38, 88, 0, 83, Ascii.DC2, Ascii.ETB, 13, 69, 87, Ascii.SYN, 5, 4, 14, 84, 95}, "72ce78") + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            try {
                this.f9398a.c();
            } catch (Throwable th) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{101, 3, 68, 66, 80, 90, 4, 39, 9, 12, 95, 0, 85, Ascii.DC2, 123, 85, 87, 88, 6, 1, Ascii.DC4}, "6f6499"), ijiami_1011.s.s.s.d(new byte[]{9, 86, 44, 66, 95, 89, 35, 13, 8, 6, 88, 11, 1, Ascii.CAN, Ascii.SYN, 95, 65, 90, Ascii.SYN, 5, 4, 14, 84, 95}, "f8b735") + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f9398a.d = ITrack.Stub.asInterface(iBinder);
                this.f9398a.f.set(true);
                this.f9398a.e.set(false);
                this.f9398a.g();
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{48, 93, Ascii.DC4, 68, 80, 2, 4, 39, 9, 12, 95, 0, 0, 76, 43, 83, 87, 0, 6, 1, Ascii.DC4}, "c8f29a"), ijiami_1011.s.s.s.d(new byte[]{88, 94, 53, 81, Ascii.DC4, 70, 8, 7, 3, 33, 94, 11, 89, 85, 5, SignedBytes.MAX_POWER_OF_TWO, 3, 84, 65, 68, 11, 33, 94, 11, 89, 85, 5, SignedBytes.MAX_POWER_OF_TWO, 15, 94, 6, 68}, "70f4f0") + this.f9398a.e + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 9, 116, 91, 12, 1, 51, 1, Ascii.NAK, Ascii.ETB, 93, 17, 2}, "8d62be") + this.f9398a.f + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 14, 120, 42, 95, 0, 53, Ascii.SYN, 7, 1, 90, 54, 81, 17, 71, 12, 82, 0, 65}, "4c1e1e") + (this.f9398a.d == null ? 0 : 1) + ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, Ascii.SYN, 8, 86, 3}, "5fa297") + Process.myPid() + ijiami_1011.s.s.s.d(new byte[]{17, 67, 91, 92, 92}, "1728f2") + Process.myTid());
            } catch (Throwable th) {
                this.f9398a.c();
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{101, 7, 16, 16, 80, 82, 4, 39, 9, 12, 95, 0, 85, Ascii.SYN, 47, 7, 87, 80, 6, 1, Ascii.DC4}, "6bbf91"), ijiami_1011.s.s.s.d(new byte[]{11, 93, 96, 3, 66, Ascii.DC4, 8, 7, 3, 33, 94, 11, 10, 86, 80, Ascii.DC2, 85, 6, 65, 16, 14, 16, 94, Ascii.DC2, 5, 81, 95, 3, 10}, "d33f0b") + th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                this.f9398a.c();
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{107, 82, Ascii.ETB, 66, 94, 7, 4, 39, 9, 12, 95, 0, 91, 67, 40, 85, 89, 5, 6, 1, Ascii.DC4}, "87e47d"), ijiami_1011.s.s.s.d(new byte[]{92, 12, 101, 86, 68, 19, 8, 7, 3, 38, 88, Ascii.SYN, 80, 13, 88, 93, 83, 6, Ascii.NAK, 1, 2, 88, 17, 69, 94, 33, 89, 93, 88, 0, 2, 16, 15, 12, 86, 69}, "3b636e") + this.f9398a.e + ijiami_1011.s.s.s.d(new byte[]{17, 85, 125, 125, 15, 4, 53, Ascii.SYN, 7, 1, 90, 54, 84, 74, 66, 91, 2, 4, 65}, "1842aa") + (this.f9398a.d == null ? 0 : 1));
            } catch (Throwable th) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{103, 81, 17, 16, 95, 7, 4, 39, 9, 12, 95, 0, 87, SignedBytes.MAX_POWER_OF_TWO, 46, 7, 88, 5, 6, 1, Ascii.DC4}, "44cf6d"), ijiami_1011.s.s.s.d(new byte[]{12, 11, 101, 1, 74, 16, 8, 7, 3, 38, 88, Ascii.SYN, 0, 10, 88, 10, 93, 5, Ascii.NAK, 1, 2, 66, 69, 13, 17, 10, 65, 5, 90, 10, 4, 94}, "ce6d8f") + th.getMessage());
            }
        }
    };
    private CopyOnWriteArrayList<a> o = new CopyOnWriteArrayList<>();
    private Context g = com.xiaomi.onetrack.f.a.b();

    public interface a {
        void a();
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                ar.this.f();
            } else if (i == 2) {
                ar.this.d();
            }
        }
    }

    private ar() {
        HandlerThread handlerThread = new HandlerThread(l);
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper());
        this.j = bVar;
        bVar.sendEmptyMessage(2);
    }

    public static ar a() {
        if (k == null) {
            b();
        }
        return k;
    }

    public static void b() {
        if (k == null) {
            synchronized (ar.class) {
                if (k == null) {
                    k = new ar();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d = null;
        this.f.set(false);
        this.e.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.e.get() || this.f.get() || this.d != null) {
            com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{92, 11, Ascii.DC2, Ascii.ETB, 66, 1, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 92, 69, 12, 33, 95, 10, 15, 1, 5, Ascii.SYN, 88, 11, 94, 95, 65}, "9eab0d") + this.e.get() + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 15, 43, SignedBytes.MAX_POWER_OF_TWO, 117, 10, 15, 0, 53, Ascii.ETB, 82, 6, 93, 17, 17, 9}, "8bb37c") + this.f.get() + ijiami_1011.s.s.s.d(new byte[]{66, 15, 34, 13, 5, 92, Ascii.CAN, 16, 15, 1, 66, 95, 66}, "bbccd0") + (this.d == null ? 0 : 1));
        } else {
            e();
        }
    }

    private void e() {
        this.e.set(true);
        try {
            Intent intent = new Intent();
            intent.setClassName(f9417a, b);
            boolean zBindService = this.g.bindService(intent, this.n, 1);
            if (zBindService) {
                this.f.set(true);
            } else {
                this.f.set(false);
                try {
                    this.g.unbindService(this.n);
                } catch (Throwable th) {
                    Log.d(c, ijiami_1011.s.s.s.d(new byte[]{77, 86, 82, 91, 95, 87, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 93, Ascii.CAN, 85, 3, 11, 19}, "880213") + th.getMessage());
                }
            }
            com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{87, 80, 10, 93, 106, 87, 19, Ascii.DC2, 15, 1, 84, 95, Ascii.NAK, Ascii.EM, 9, 122, 86, 92, 15, 1, 5, Ascii.SYN, 88, 11, 82, 3, 68}, "59d992") + this.e + ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 81, 81, 12, 0, 102, 4, Ascii.ETB, 19, 14, 69, 95}, "638bd4") + zBindService);
        } catch (Throwable th2) {
            try {
                this.f.set(false);
                this.e.set(false);
                this.g.unbindService(this.n);
            } catch (Throwable th3) {
                Log.d(c, ijiami_1011.s.s.s.d(new byte[]{83, 11, 11, 92, 96, 6, 19, Ascii.DC2, 15, 1, 84, 69, 84, 83, 95, Ascii.CAN}, "1be83c") + th3.getMessage());
            }
            com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{84, 11, 91, 81, 107, 4, 19, Ascii.DC2, 15, 1, 84, 69, 83, 88, Ascii.NAK}, "6b558a") + th2.getMessage());
        }
        this.e.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.f.get()) {
                this.g.unbindService(this.n);
            }
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{76, 15, 117, 93, 8, 92, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 92, 65, 99, 92, Ascii.DC4, 87, Ascii.SYN, 5, 4, 14, 84, 95, Ascii.EM}, "9a74f8") + th.getMessage());
        }
        c();
        com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 95, 38, 91, 92, 84, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 6, 17, 68, 95, 123, 67, 35, 13, 8, 6, 98, 16, 0, 82, 1, 65, 65, 10}, "c1d220") + this.f.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Iterator<a> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(int i2) {
        if (i2 == 2) {
            this.j.sendEmptyMessageDelayed(1, 5000L);
        } else if (this.j.hasMessages(1)) {
            this.j.removeMessages(1);
        }
    }

    public void a(a aVar) {
        if (this.o.contains(aVar)) {
            return;
        }
        this.o.add(aVar);
    }

    public void a(String str, String str2, String str3) {
        try {
            com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, Ascii.SYN, 5, 84, 95, 32, 0, 7, 14, 7, 117, 4, Ascii.DC2, 5, 94, Ascii.ETB, 85, 19, 17, 45, 2, 88}, "fdd74c") + str + ijiami_1011.s.s.s.d(new byte[]{Base64.padSymbol, 85, 66, 3, 93, 76, 47, 5, 11, 7, 11, 58, 6, 81, SignedBytes.MAX_POWER_OF_TWO, 7, 9}, "b04f38") + str3);
            this.d.trackEvent(str, com.xiaomi.onetrack.f.a.e(), str2, str3);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(c, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 75, 87, 80, 92, 123, 0, 7, 14, 7, 117, 4, Ascii.SYN, 88, Ascii.SYN, 86, 69, 74, 14, Ascii.SYN, 92}, "b96378") + e.toString());
        }
    }

    public boolean a(String str, String str2, Configuration configuration, boolean z) {
        if (this.e.get()) {
            return false;
        }
        if (this.d == null) {
            this.j.sendEmptyMessage(2);
            return false;
        }
        try {
            String appId = configuration.getAppId();
            if (z) {
                appId = configuration.getAdEventAppId();
            }
            this.d.trackEvent(appId, com.xiaomi.onetrack.f.a.e(), str, str2);
            return true;
        } catch (Throwable th) {
            f();
            com.xiaomi.onetrack.util.p.a(c, ijiami_1011.s.s.s.d(new byte[]{16, 71, 87, 81, 90, 19, Ascii.NAK, 12, Ascii.DC4, 13, 70, 4, 6, 89, 83, 8, 17}, "d56213") + th.getMessage());
            return false;
        }
    }
}
