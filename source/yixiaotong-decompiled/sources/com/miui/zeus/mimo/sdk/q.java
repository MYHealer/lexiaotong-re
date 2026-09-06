package com.miui.zeus.mimo.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.market.IAppDownloadManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q {
    public static final String e = ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK}, "d68dbb");
    public Context b;
    public IAppDownloadManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5565a = new Object();
    public final ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                String str = q.e;
                m.a(str, ijiami_1011.s.s.s.d(new byte[]{7, 80, 80, 16, 94, 8, 50, 1, Ascii.DC4, Ascii.DC4, 88, 6, 83, 34, 14, 94, 95, 3, 2, 16, 3, 6}, "6aa01f"));
                synchronized (q.this.f5565a) {
                    q.this.c = IAppDownloadManager.Stub.asInterface(iBinder);
                    m.a(str, ijiami_1011.s.s.s.d(new byte[]{87, 92, 100, 85, 75, 71, 8, 7, 3, 33, 94, 11, 86, 87, 84, 68, 92, 85}, "827091"));
                    q.this.f5565a.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (q.this.f5565a) {
                q.this.c = null;
            }
        }
    }

    public q(Context context) {
        this.b = context;
    }

    public static String a(Uri uri, String str) {
        if (uri != null && uri.isHierarchical()) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public final boolean a() {
        return a(this.b) && this.c != null;
    }

    public boolean a(String str) {
        String strA;
        if (!TextUtils.isEmpty(str) && str.contains(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 86, 16, 86, 66, 13, 0, Ascii.GS, 54, 13, 66, 12, 68, 80, 9, 93, 13}, "09f30a"))) {
            if (str.isEmpty()) {
                strA = "";
            } else {
                try {
                    Uri uri = Uri.parse(str);
                    strA = a(uri, ijiami_1011.s.s.s.d(new byte[]{69, 89, 84, 13, 0, 83, 4, 42, 7, 15, 84}, "587fa4"));
                    if (TextUtils.isEmpty(strA)) {
                        strA = a(uri, ijiami_1011.s.s.s.d(new byte[]{15, 1}, "fe7676"));
                    }
                    if (TextUtils.isEmpty(strA)) {
                        strA = a(uri, e);
                    }
                } catch (Exception unused) {
                    strA = "";
                }
            }
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            try {
                synchronized (this.f5565a) {
                    try {
                        if (b()) {
                            m.a(e, ijiami_1011.s.s.s.d(new byte[]{65, 4, 84, 80, 75, Ascii.NAK, Ascii.NAK, 11, 70, 17, 89, 10, 68, 65, 84, 80, Ascii.DC2, 67, 8, 1, 17}, "3a5425"));
                            this.c.cancel(strA, this.b.getPackageName());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            } finally {
                if (a()) {
                    this.b.unbindService(this.d);
                    this.c = null;
                }
            }
        }
        return false;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.contains(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 95, Ascii.DC4, 83, 19, 14, 0, Ascii.GS, 54, 13, 66, 12, 68, 89, 13, 88, 92}, "00b6ab"))) {
            return false;
        }
        try {
            try {
                synchronized (this.f5565a) {
                    try {
                        if (!b()) {
                            if (!a()) {
                                return false;
                            }
                            this.b.unbindService(this.d);
                            this.c = null;
                            return false;
                        }
                        m.a(e, ijiami_1011.s.s.s.d(new byte[]{67, 87, 89, 92, 74, 65, Ascii.NAK, 11, 70, 17, 89, 10, 70, Ascii.DC2, 89, 92, 19, Ascii.ETB, 8, 1, 17}, "12883a"));
                        if (b.h(str2)) {
                            this.c.downloadByUriV2(Uri.parse(str), str2);
                        } else {
                            this.c.downloadByUri(Uri.parse(str));
                        }
                        if (!a()) {
                            return true;
                        }
                        this.b.unbindService(this.d);
                        this.c = null;
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!a()) {
                    return false;
                }
            }
        } catch (Throwable th2) {
            if (a()) {
                this.b.unbindService(this.d);
                this.c = null;
            }
            throw th2;
        }
    }

    public boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.contains(ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 91, Ascii.DC4, 4, 69, 14, 0, Ascii.GS, 54, 13, 66, 12, 76, 93, 13, 15, 10}, "84ba7b"))) {
            return false;
        }
        try {
            try {
                synchronized (this.f5565a) {
                    try {
                        if (!b()) {
                            if (!a()) {
                                return false;
                            }
                            this.b.unbindService(this.d);
                            this.c = null;
                            return false;
                        }
                        m.a(e, ijiami_1011.s.s.s.d(new byte[]{69, 6, 0, 92, Ascii.FS, Ascii.ETB, Ascii.NAK, 11, 70, 17, 89, 10, SignedBytes.MAX_POWER_OF_TWO, 67, 0, 92, 69, 65, 8, 1, 17}, "7ca8e7"));
                        if (b.h(str2)) {
                            this.c.pauseByUriV2(Uri.parse(str), str2);
                        } else {
                            this.c.pauseByUri(Uri.parse(str));
                        }
                        if (!a()) {
                            return true;
                        }
                        this.b.unbindService(this.d);
                        this.c = null;
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!a()) {
                    return false;
                }
            }
        } catch (Throwable th2) {
            if (a()) {
                this.b.unbindService(this.d);
                this.c = null;
            }
            throw th2;
        }
    }

    public boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str) || !str.contains(ijiami_1011.s.s.s.d(new byte[]{71, 13, SignedBytes.MAX_POWER_OF_TWO, 84, 69, 13, 0, Ascii.GS, 54, 13, 66, 12, Ascii.NAK, 11, 89, 95, 10}, "ab617a"))) {
            return false;
        }
        try {
            try {
                synchronized (this.f5565a) {
                    try {
                        if (!b()) {
                            if (!a()) {
                                return false;
                            }
                            this.b.unbindService(this.d);
                            this.c = null;
                            return false;
                        }
                        m.a(e, ijiami_1011.s.s.s.d(new byte[]{19, 93, 84, 87, 26, Ascii.CAN, Ascii.NAK, 11, 70, 17, 89, 10, Ascii.SYN, Ascii.CAN, 84, 87, 67, 78, 8, 1, 17}, "a853c8"));
                        if (b.h(str2)) {
                            this.c.resumeByUriV2(Uri.parse(str), str2);
                        } else {
                            this.c.resumeByUri(Uri.parse(str));
                        }
                        if (!a()) {
                            return true;
                        }
                        this.b.unbindService(this.d);
                        this.c = null;
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (!a()) {
                    return false;
                }
            }
        } catch (Throwable th2) {
            if (a()) {
                this.b.unbindService(this.d);
                this.c = null;
            }
            throw th2;
        }
    }

    public final boolean b() throws InterruptedException {
        if (this.c == null) {
            if (a(this.b)) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(ijiami_1011.s.s.s.d(new byte[]{86, 93, 88, Ascii.GS, 78, 13, 0, 11, 11, 11, Ascii.US, 8, 84, SignedBytes.MAX_POWER_OF_TWO, 94, 86, 66, 74, Ascii.DC2, 1, Ascii.DC4, Ascii.DC4, 88, 6, 80, Ascii.FS, 116, 67, 70, 32, 14, 19, 8, 14, 94, 4, 81, 97, 80, 65, SignedBytes.MAX_POWER_OF_TWO, 13, 2, 1}, "52536d"));
                    intent.setComponent(new ComponentName(ijiami_1011.s.s.s.d(new byte[]{83, 91, 9, 74, Ascii.GS, 80, 0, 11, 11, 11, Ascii.US, 8, 81, 70, 15, 1, 17}, "04dde9"), ijiami_1011.s.s.s.d(new byte[]{85, 93, 88, Ascii.US, Ascii.GS, 8, 0, 11, 11, 11, Ascii.US, 8, 87, SignedBytes.MAX_POWER_OF_TWO, 94, 84, 17, 79, 5, 5, Ascii.DC2, 3, Ascii.US, 36, 70, 66, 113, 94, Ascii.DC2, 15, 13, 11, 7, 6, 98, 0, 68, 68, 92, 82, 0}, "6251ea")));
                    this.b.bindService(intent, this.d, 1);
                } catch (Exception e2) {
                    m.c(e, ijiami_1011.s.s.s.d(new byte[]{82, 94, Ascii.SYN, 94, 0, Ascii.NAK, 15, 11, Ascii.DC2, 66, 83, 12, 95, 85, 67, 70, 12, 80, 65, Ascii.ETB, 3, 16, 71, 12, 82, 84, 77}, "11c2d5"), e2);
                }
            } else {
                m.a(e, ijiami_1011.s.s.s.d(new byte[]{70, 89, 93, 17, 93, 69, 8, Ascii.ETB, 70, 12, 94, 69, 83, 17, 75, 26, 75, 17, 4, 9, 39, 6, 98, 10, 94, 68, 76, 10, 87, 11, 65, 5, Ascii.SYN, Ascii.DC2, Ascii.US}, "218c8e"));
            }
        }
        if (a()) {
            return true;
        }
        this.f5565a.wait(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        return a();
    }

    public final boolean a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(ijiami_1011.s.s.s.d(new byte[]{90, 88, 94, Ascii.EM, 75, 8, 0, 11, 11, 11, Ascii.US, 8, 88, 69, 88, 82, 71, 79, Ascii.DC2, 1, Ascii.DC4, Ascii.DC4, 88, 6, 92, Ascii.EM, 114, 71, 67, 37, 14, 19, 8, 14, 94, 4, 93, 100, 86, 69, 69, 8, 2, 1}, "97373a"));
            intent.setComponent(new ComponentName(ijiami_1011.s.s.s.d(new byte[]{86, 92, 93, Ascii.FS, 73, 95, 0, 11, 11, 11, Ascii.US, 8, 84, 65, 91, 87, 69}, "530216"), ijiami_1011.s.s.s.d(new byte[]{2, 13, 91, Ascii.US, 26, 12, 0, 11, 11, 11, Ascii.US, 8, 0, 16, 93, 84, Ascii.SYN, 75, 5, 5, Ascii.DC2, 3, Ascii.US, 36, 17, Ascii.DC2, 114, 94, Ascii.NAK, 11, 13, 11, 7, 6, 98, 0, 19, Ascii.DC4, 95, 82, 7}, "ab61be")));
            return (context == null || context.getPackageManager() == null || context.getPackageManager().queryIntentServices(intent, 0).isEmpty()) ? false : true;
        } catch (Exception unused) {
        }
    }
}
