package com.miui.zeus.mimo.sdk.click;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.systemAdSolution.landingPageV2.service.ILandingPageServiceV2;
import com.miui.zeus.mimo.sdk.m;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class RemoteInstallProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5393a;
    public ILandingPageServiceV2 b;
    public final Object c = new Object();
    public final ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                synchronized (RemoteInstallProxy.this.c) {
                    try {
                        RemoteInstallProxy.this.b = ILandingPageServiceV2.Stub.asInterface(iBinder);
                        RemoteInstallProxy.this.c.notifyAll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                m.b(s.d(new byte[]{55, 87, 12, 9, 77, 93, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 9, 98, 19, 9, 65, 65}, "e2af98"), s.d(new byte[]{87, 10, 100, 84, 68, SignedBytes.MAX_POWER_OF_TWO, 8, 7, 3, 33, 94, 11, 86, 1, 84, 69, 83, 82}, "8d7166"), e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.a(s.d(new byte[]{97, 81, 93, 87, 16, 82, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 95, 100, 66, 87, Ascii.FS, 78}, "3408d7"), s.d(new byte[]{10, 90, 53, 6, 71, 68, 8, 7, 3, 38, 88, Ascii.SYN, 6, 91, 8, 13, 80, 81, Ascii.NAK, 1, 2}, "e4fc52"));
            synchronized (RemoteInstallProxy.this.c) {
                RemoteInstallProxy.this.b = null;
            }
        }
    }

    public interface b {
        void a(Exception exc);

        void a(boolean z);
    }

    public RemoteInstallProxy(Context context) {
        this.f5393a = context;
    }

    public static boolean a(RemoteInstallProxy remoteInstallProxy) throws InterruptedException {
        if (remoteInstallProxy.b == null && remoteInstallProxy.a(remoteInstallProxy.f5393a)) {
            try {
                Intent intent = new Intent();
                intent.setAction(s.d(new byte[]{14, 81, 19, 11, Ascii.ETB, 80, 15, 16, 3, 12, 69, 75, 2, 91, Ascii.DC2, 11, 86, 87, 79, 5, 2, 76, 125, 36, 45, 124, 47, 44, 126, 102, 49, 37, 33, 39, 110, 54, 38, 106, 48, 43, 122, 124, 55, 86}, "c8fb99"));
                intent.setPackage(s.d(new byte[]{80, 14, 88, Ascii.RS, 14, 91, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 71, 4, 88, 113, 7, 97, 14, 8, 19, Ascii.SYN, 88, 10, 93}, "3a50c2"));
                m.a(s.d(new byte[]{106, 93, 9, 88, Ascii.DC2, 7, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 84, 104, Ascii.SYN, 88, Ascii.RS, Ascii.ESC}, "88d7fb"), String.valueOf(remoteInstallProxy.f5393a.bindService(intent, remoteInstallProxy.d, 1)));
            } catch (Exception e) {
                m.b(s.d(new byte[]{55, 80, 93, 88, 67, 85, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 9, 101, 66, 88, 79, 73}, "e50770"), s.d(new byte[]{6, 12, 77, 13, 82, 16, 15, 11, Ascii.DC2, 66, 83, 12, 11, 7, Ascii.CAN, Ascii.NAK, 94, 85, 65, Ascii.ETB, 3, 16, 71, 12, 6, 6, Ascii.SYN}, "ec8a60"), e);
            }
        }
        if (remoteInstallProxy.a()) {
            return true;
        }
        remoteInstallProxy.c.wait(1000L);
        return remoteInstallProxy.a();
    }

    public final boolean a() {
        return a(this.f5393a) && this.b != null;
    }

    public final boolean a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(s.d(new byte[]{12, 10, 69, 12, 75, 12, 15, 16, 3, 12, 69, 75, 0, 0, 68, 12, 10, 11, 79, 5, 2, 76, 125, 36, 47, 39, 121, 43, 34, 58, 49, 37, 33, 39, 110, 54, 36, 49, 102, 44, 38, 32, 55, 86}, "ac0eee"));
            intent.setPackage(s.d(new byte[]{82, 92, 89, Ascii.ESC, 84, 91, Ascii.DC4, 13, 72, 17, 72, Ascii.SYN, 69, 86, 89, 116, 93, 97, 14, 8, 19, Ascii.SYN, 88, 10, 95}, "134592"));
            if (context != null && context.getPackageManager() != null && !context.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                m.a(s.d(new byte[]{51, 80, 14, 11, 77, 87, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 13, 101, 17, 11, 65, 75}, "a5cd92"), s.d(new byte[]{87, 88, 93, 7, 16, 65, 9, 1, 70, 3, 85, 69, 66, 84, 65, Ascii.NAK, 89, 86, 4, 68, 15, 12, 17, Ascii.SYN, 72, 66, 71, 6, 93, 116, 5, 55, 9, 14, 68, 17, 88, 94, 93, 77}, "113c05"));
                return true;
            }
        } catch (Exception e) {
            m.b(s.d(new byte[]{101, 92, 93, 95, 67, 92, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 91, 105, 66, 95, 79, SignedBytes.MAX_POWER_OF_TWO}, "790079"), s.d(new byte[]{74, 9, 8, 87, 65, 81, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 86, 8, Ascii.SYN, Ascii.DC2, 14, 87, 2, 17, Ascii.DC4, 66, 70, 13, 92, 8, 69, 88, Ascii.DC4, 80, 6, 1, 70, 11, 87, 69, 77, 14, 0, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.DC4, 8, Ascii.ETB, 70, Ascii.SYN, 89, 0, Ascii.EM, Ascii.NAK, Ascii.FS, 65, Ascii.NAK, 81, 12, 68, 7, 6, 17, 4, 73, Ascii.SYN, 75}, "9fe2a4"), e);
        }
        m.b(s.d(new byte[]{96, 83, 91, 89, 17, 92, 40, 10, Ascii.NAK, Ascii.SYN, 80, 9, 94, 102, 68, 89, Ascii.GS, SignedBytes.MAX_POWER_OF_TWO}, "2666e9"), s.d(new byte[]{17, 10, 7, SignedBytes.MAX_POWER_OF_TWO, 7, Ascii.ETB, 8, Ascii.ETB, 70, 12, 94, 69, 4, 66, 17, 75, 17, 67, 4, 9, 39, 6, 98, 10, 9, Ascii.ETB, Ascii.SYN, 91, 13, 89, 65, 5, Ascii.SYN, Ascii.DC2, Ascii.US}, "ebb2b7"));
        return false;
    }
}
