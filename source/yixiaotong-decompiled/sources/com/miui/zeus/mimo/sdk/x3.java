package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.click.RemoteInstallProxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5735a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ RemoteInstallProxy.b d;
    public final /* synthetic */ RemoteInstallProxy e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5736a;

        public a(boolean z) {
            this.f5736a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            x3.this.d.a(this.f5736a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Exception f5737a;

        public b(Exception exc) {
            this.f5737a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            x3.this.d.a(false);
            x3.this.d.a(this.f5737a);
        }
    }

    public x3(RemoteInstallProxy remoteInstallProxy, String str, String str2, String str3, RemoteInstallProxy.b bVar) {
        this.e = remoteInstallProxy;
        this.f5735a = str;
        this.b = str2;
        this.c = str3;
        this.d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RemoteInstallProxy remoteInstallProxy;
        boolean zHandleDeeplinkViaMsa;
        try {
            try {
                try {
                    synchronized (this.e.c) {
                        if (RemoteInstallProxy.a(this.e)) {
                            m.a(ijiami_1011.s.s.s.d(new byte[]{52, 82, 89, 87, 69, 87, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 10, 103, 70, 87, 73, 75}, "f74812"), ijiami_1011.s.s.s.d(new byte[]{67, 6, 83, 85, Ascii.CAN, 69, Ascii.NAK, 11, 70, 14, 80, 16, 95, 0, 90, 11}, "1c21ae") + this.f5735a + ijiami_1011.s.s.s.d(new byte[]{66, 71, 15, 88, 16, 84, Ascii.DC2, 5}, "b1f909"));
                            zHandleDeeplinkViaMsa = this.e.b.handleDeeplinkViaMsa(this.b, this.f5735a, this.c);
                        } else {
                            zHandleDeeplinkViaMsa = false;
                        }
                    }
                    x8.e(new a(zHandleDeeplinkViaMsa));
                    if (this.e.a()) {
                        RemoteInstallProxy remoteInstallProxy2 = this.e;
                        remoteInstallProxy2.f5393a.unbindService(remoteInstallProxy2.d);
                        remoteInstallProxy = this.e;
                        remoteInstallProxy.b = null;
                    }
                } catch (Exception e) {
                    m.b(ijiami_1011.s.s.s.d(new byte[]{48, 80, 89, 94, 76, 84, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 14, 101, 70, 94, SignedBytes.MAX_POWER_OF_TWO, 72}, "b54181"), ijiami_1011.s.s.s.d(new byte[]{71, 80, 9, 10, 65, 82, 65, 12, 7, 12, 85, 9, 80, Ascii.NAK, 1, 69, 15, Ascii.ETB}, "55de57"), e);
                    x8.e(new b(e));
                    if (!this.e.a()) {
                        return;
                    }
                    RemoteInstallProxy remoteInstallProxy3 = this.e;
                    remoteInstallProxy3.f5393a.unbindService(remoteInstallProxy3.d);
                    remoteInstallProxy = this.e;
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            try {
                if (this.e.a()) {
                    RemoteInstallProxy remoteInstallProxy4 = this.e;
                    remoteInstallProxy4.f5393a.unbindService(remoteInstallProxy4.d);
                    this.e.b = null;
                }
            } catch (Exception unused2) {
            }
            throw th;
        }
    }
}
