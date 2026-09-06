package com.miui.zeus.mimo.sdk.download;

import android.content.Context;
import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.jni.NativeUtils;
import com.miui.zeus.mimo.sdk.C1210r;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n;
import com.miui.zeus.mimo.sdk.n4;
import com.miui.zeus.mimo.sdk.o;
import com.miui.zeus.mimo.sdk.t;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.u;
import com.miui.zeus.mimo.sdk.v;
import com.miui.zeus.mimo.sdk.w;
import com.miui.zeus.mimo.sdk.w6;
import com.miui.zeus.mimo.sdk.x;
import com.miui.zeus.mimo.sdk.x8;
import com.miui.zeus.mimo.sdk.y;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class AutoDownloadController implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1210r f5409a;
    public int b = 0;
    public String c;
    public n d;
    public MimoAdInfo e;
    public boolean f;
    public final int g;

    public AutoDownloadController(Context context) {
        this.f5409a = new C1210r(context);
        this.g = f9.a(context, s.d(new byte[]{81, 11, 89, 74, 72, 91, 0, 11, 11, 11, Ascii.US, 8, 83, Ascii.SYN, 95, 1, 68}, "2d4d02"));
    }

    public final String a(MimoAdInfo mimoAdInfo) {
        if (mimoAdInfo == null) {
            return null;
        }
        return this.g >= 40005380 ? mimoAdInfo.y : mimoAdInfo.x;
    }

    public final boolean b(MimoAdInfo mimoAdInfo) {
        return (b.g(mimoAdInfo.C) || com.miui.zeus.mimo.sdk.s.a().b(mimoAdInfo.C) == null) ? false : true;
    }

    public void c() {
        C1210r c1210r = this.f5409a;
        if (c1210r != null) {
            c1210r.a();
        }
    }

    public final void d() {
        if (this.e == null) {
            return;
        }
        String strA = NativeUtils.a(this.c);
        if (!b.h(this.e.z)) {
            m.a(s.d(new byte[]{117, 13, 66, 88, 90, 91, 0, 0, 37, 13, 95, 17, 67, 13, 89, 90, 83, 70}, "1b5664"), s.d(new byte[]{Ascii.ETB, 87, 16, 66, 11, 83, 37, 11, 17, 12, 93, 10, 4, 86, 33, 78, 43, 95, 44, 5, Ascii.DC4, 9, 84, 17, 69, SignedBytes.MAX_POWER_OF_TWO, 6, 68, 19, 91, 4, 38, Ascii.US, 36, 93, 10, 4, 70, 53, 6}, "e2c7f6"));
            com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
            sVarA.getClass();
            com.miui.zeus.mimo.sdk.s.d = false;
            x8.j.execute(new w(sVarA, strA));
            return;
        }
        m.a(s.d(new byte[]{32, 91, SignedBytes.MAX_POWER_OF_TWO, 95, 10, 10, 0, 0, 37, 13, 95, 17, Ascii.SYN, 91, 91, 93, 3, Ascii.ETB}, "d471fe"), s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 84, 70, 16, 90, 1, 37, 11, 17, 12, 93, 10, 83, 85, 119, Ascii.FS, 122, 13, 44, 5, Ascii.DC4, 9, 84, 17, Ascii.DC2, 67, 80, Ascii.SYN, 66, 9, 4, 38, Ascii.US, 36, 93, 10, 83, 69, 99, 87}, "215e7d"));
        com.miui.zeus.mimo.sdk.s sVarA2 = com.miui.zeus.mimo.sdk.s.a();
        String str = this.e.z;
        sVarA2.getClass();
        com.miui.zeus.mimo.sdk.s.d = false;
        x8.j.execute(new x(sVarA2, strA, str));
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onCancelDownload(String str) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        sVarA.b.remove(this.e.C);
        this.f5409a.a();
        this.c = "";
        n nVar = this.d;
        if (nVar != null) {
            nVar.onCancelDownload(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFailed(String str, int i) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        sVarA.b.remove(this.e.C);
        this.f5409a.a();
        this.c = "";
        this.b = i;
        y8.b.post(new n4(this));
        n nVar = this.d;
        if (nVar != null) {
            nVar.onDownloadFailed(str, i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFinished(String str) {
        n nVar;
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null || (nVar = this.d) == null) {
            return;
        }
        nVar.onDownloadFinished(str);
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadPaused(String str) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s.a().a(this.e.C, 2);
        n nVar = this.d;
        if (nVar != null) {
            nVar.onDownloadPaused(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadProgressUpdated(String str, int i) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        String str2 = this.e.C;
        o oVar = sVarA.b.get(str2);
        if (oVar == null) {
            oVar = new o(3, i);
        } else {
            oVar.b = 3;
            oVar.f5540a = i;
        }
        sVarA.b.put(str2, oVar);
        n nVar = this.d;
        if (nVar != null) {
            nVar.onDownloadProgressUpdated(str, i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadStarted(String str) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s.a().a(this.e.C, 3);
        n nVar = this.d;
        if (nVar != null) {
            nVar.onDownloadStarted(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onExistDownload(String str) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        if (b.g(this.c)) {
            this.c = a(this.e);
        }
        d();
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallFailed(String str, int i) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        sVarA.b.remove(this.e.C);
        this.f5409a.a();
        this.c = "";
        n nVar = this.d;
        if (nVar != null) {
            nVar.onInstallFailed(str, i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallStart(String str) {
        n nVar;
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null || (nVar = this.d) == null) {
            return;
        }
        nVar.onInstallStart(str);
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallSuccess(String str) {
        if (this.e == null || com.miui.zeus.mimo.sdk.s.a().b(this.e.C) == null) {
            return;
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        sVarA.b.remove(this.e.C);
        this.f5409a.a();
        this.c = "";
        n nVar = this.d;
        if (nVar != null) {
            nVar.onInstallSuccess(str);
        }
    }

    public void a() {
        MimoAdInfo mimoAdInfo = this.e;
        if (mimoAdInfo == null) {
            return;
        }
        b.a(AdEvent.MIMO_SDK_DOWNLOAD_CANCEL, mimoAdInfo);
        if (b.g(this.c)) {
            this.c = a(this.e);
        }
        com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
        String strA = NativeUtils.a(this.c);
        sVarA.getClass();
        com.miui.zeus.mimo.sdk.s.d = true;
        x8.j.execute(new y(sVarA, strA));
        onCancelDownload(this.e.C);
    }

    public void b() {
        MimoAdInfo mimoAdInfo;
        if (this.f && b.h(this.c) && (mimoAdInfo = this.e) != null) {
            this.f5409a.a(mimoAdInfo.C, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:63:0x01c8  */
    public boolean a(View view, MimoAdInfo mimoAdInfo, boolean z, n nVar) {
        boolean z2;
        if (view != null && mimoAdInfo != null && mimoAdInfo.S0) {
            this.f = z;
            this.e = mimoAdInfo;
            this.d = nVar;
            boolean z3 = false;
            if (this.b != -4) {
                if (b(mimoAdInfo) && (this.f || mimoAdInfo.S || b.h(this.c))) {
                    this.f5409a.a(mimoAdInfo.C, this);
                    o oVarB = com.miui.zeus.mimo.sdk.s.a().b(mimoAdInfo.C);
                    int i = oVarB.b;
                    if (3 == i) {
                        b.a(AdEvent.MIMO_SDK_DOWNLOAD_PAUSE, mimoAdInfo);
                        if (b.g(this.c)) {
                            this.c = a(this.e);
                        }
                        if (this.e != null) {
                            String strA = NativeUtils.a(this.c);
                            if (b.h(this.e.z)) {
                                m.a(s.d(new byte[]{38, 11, 66, 11, 88, 14, 0, 0, 37, 13, 95, 17, 16, 11, 89, 9, 81, 19}, "bd5e4a"), s.d(new byte[]{65, 88, 19, Ascii.ETB, 3, 114, 14, 19, 8, 14, 94, 4, 85, 123, Ascii.US, 41, 15, 123, 0, Ascii.SYN, 13, 7, 69, 69, 65, 88, 19, Ascii.ETB, 3, 116, Ascii.CAN, 34, 10, 13, 80, 17, 103, 11}, "19fdf6"));
                                com.miui.zeus.mimo.sdk.s sVarA = com.miui.zeus.mimo.sdk.s.a();
                                String str = this.e.z;
                                sVarA.getClass();
                                x8.j.execute(new v(sVarA, strA, str));
                            } else {
                                m.a(s.d(new byte[]{114, 90, 19, 93, 93, 86, 0, 0, 37, 13, 95, 17, 68, 90, 8, 95, 84, 75}, "65d319"), s.d(new byte[]{70, 2, 68, 67, 82, 34, 14, 19, 8, 14, 94, 4, 82, 33, 72, 125, 94, 43, 0, Ascii.SYN, 13, 7, 69, 69, 70, 2, 68, 67, 82, 36, Ascii.CAN, 34, 10, 13, 80, 17, 96, 82}, "6c107f"));
                                com.miui.zeus.mimo.sdk.s sVarA2 = com.miui.zeus.mimo.sdk.s.a();
                                sVarA2.getClass();
                                x8.j.execute(new u(sVarA2, strA));
                            }
                        }
                        n nVar2 = this.d;
                        if (nVar2 != null) {
                            nVar2.onDownloadPaused(mimoAdInfo.C);
                        }
                        return false;
                    }
                    if (2 == i) {
                        b.a(AdEvent.MIMO_SDK_DOWNLOAD_CONTINUE, mimoAdInfo);
                        if (b.g(this.c)) {
                            this.c = a(this.e);
                        }
                        d();
                        n nVar3 = this.d;
                        if (nVar3 != null) {
                            nVar3.onDownloadProgressUpdated(mimoAdInfo.C, oVarB.f5540a);
                        }
                        return false;
                    }
                }
                if ((!b(mimoAdInfo) || this.f) && !w6.a(y8.f5752a, mimoAdInfo)) {
                    this.f5409a.a(mimoAdInfo.C, this);
                    String strA2 = a(mimoAdInfo);
                    this.c = strA2;
                    if (b.g(strA2)) {
                        z2 = false;
                    } else {
                        String strA3 = NativeUtils.a(this.c);
                        if (b.h(mimoAdInfo.z)) {
                            m.a(s.d(new byte[]{125, 11, Ascii.DC4, 87, 92, 93, 0, 0, 37, 13, 95, 17, 75, 11, 15, 85, 85, SignedBytes.MAX_POWER_OF_TWO}, "9dc902"), s.d(new byte[]{83, 94, SignedBytes.MAX_POWER_OF_TWO, 7, 2, 69, 37, 11, 17, 12, 93, 10, 86, 83, 112, Ascii.ESC, 44, 88, 44, 5, Ascii.DC4, 9, 84, 17, Ascii.ETB, 83, 93, Ascii.NAK, 15, 93, 14, 5, 2, 32, 72, 35, 91, 88, 83, Ascii.SYN, 55, 3}, "772ba1"));
                            com.miui.zeus.mimo.sdk.s sVarA3 = com.miui.zeus.mimo.sdk.s.a();
                            String str2 = mimoAdInfo.z;
                            sVarA3.getClass();
                            com.miui.zeus.mimo.sdk.s.d = false;
                            x8.j.execute(new t(sVarA3, strA3, str2));
                        } else {
                            m.a(s.d(new byte[]{34, 88, 78, 8, 9, 88, 0, 0, 37, 13, 95, 17, Ascii.DC4, 88, 85, 10, 0, 69}, "f79fe7"), s.d(new byte[]{92, 11, 65, 3, 85, 16, 37, 11, 17, 12, 93, 10, 89, 6, 113, Ascii.US, 123, 13, 44, 5, Ascii.DC4, 9, 84, 17, Ascii.CAN, 6, 92, 17, 88, 8, 14, 5, 2, 32, 72, 35, 84, 13, 82, Ascii.DC2, 96, 85}, "8b3f6d"));
                            com.miui.zeus.mimo.sdk.s.a().a(strA3);
                        }
                        z2 = true;
                    }
                    m.a(s.d(new byte[]{39, 14, SignedBytes.MAX_POWER_OF_TWO, 93, 88, 92, 0, 0, 36, Ascii.SYN, 95, 51, 10, 4, SignedBytes.MAX_POWER_OF_TWO}, "ca7343"), s.d(new byte[]{93, 93, 13, 67, 90, 9, 0, 0, 53, Ascii.SYN, 80, Ascii.ETB, 77, 15, 94, 9}, "92c46f") + z2);
                    if (z2) {
                        com.miui.zeus.mimo.sdk.s.a().a(mimoAdInfo.C, 3);
                        n nVar4 = this.d;
                        if (nVar4 != null) {
                            nVar4.onDownloadStarted(mimoAdInfo.C);
                        }
                        mimoAdInfo = this.e;
                        z3 = true;
                    } else {
                        mimoAdInfo = this.e;
                    }
                } else {
                    mimoAdInfo = this.e;
                }
            }
            mimoAdInfo.S = z3;
        }
        return true;
    }
}
