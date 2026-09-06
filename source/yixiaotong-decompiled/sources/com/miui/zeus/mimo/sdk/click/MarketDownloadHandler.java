package com.miui.zeus.mimo.sdk.click;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n;
import com.miui.zeus.mimo.sdk.p;
import com.miui.zeus.mimo.sdk.u3;
import com.miui.zeus.mimo.sdk.v3;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.w6;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MarketDownloadHandler extends u3 implements n {
    public final Context b;
    public p c;
    public final w3 d;
    public n e;
    public boolean f;

    public MarketDownloadHandler(Context context, w3 w3Var) {
        this.b = context;
        this.d = w3Var;
    }

    @Override // com.miui.zeus.mimo.sdk.u3
    public void a() {
        super.a();
        p pVar = this.c;
        if (pVar != null) {
            this.b.unregisterReceiver(pVar);
            this.c.f5557a = null;
            this.c = null;
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onCancelDownload(String str) {
        this.f = false;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadCancel();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onCancelDownload(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFailed(String str, int i) {
        this.f = false;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadFailed(i);
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onDownloadFailed(str, i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadFinished(String str) {
        this.f = true;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadFinished();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onDownloadFinished(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadPaused(String str) {
        this.f = true;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadPaused();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onDownloadPaused(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadProgressUpdated(String str, int i) {
        this.f = true;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadProgressUpdated(i);
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onDownloadProgressUpdated(str, i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onDownloadStarted(String str) {
        this.f = true;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onDownloadStarted();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onDownloadStarted(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onExistDownload(String str) {
        n nVar = this.e;
        if (nVar != null) {
            nVar.onExistDownload(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallFailed(String str, int i) {
        this.f = false;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onInstallFailed(i);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallStart(String str) {
        this.f = true;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onInstallStart();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onInstallStart(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.n
    public void onInstallSuccess(String str) {
        this.f = false;
        w3 w3Var = this.d;
        if (w3Var != null) {
            w3Var.onInstallSuccess();
        }
        n nVar = this.e;
        if (nVar != null) {
            nVar.onInstallSuccess(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.u3
    public void a(MimoAdInfo mimoAdInfo, ClickAreaType clickAreaType, v3 v3Var, boolean z) {
        String str;
        if (mimoAdInfo.t() && !w6.a(this.b, mimoAdInfo)) {
            if (!TextUtils.isEmpty(mimoAdInfo.F)) {
                str = mimoAdInfo.F;
            } else {
                str = mimoAdInfo.w;
            }
            String str2 = mimoAdInfo.C;
            if (this.d != null && this.c == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(s.d(new byte[]{81, 11, 94, Ascii.ETB, 65, 10, 0, 11, 11, 11, Ascii.US, 8, 83, Ascii.SYN, 88, 92, 77, 77, 37, 43, 49, 44, 125, 42, 115, 32, 108, 112, 119, 48, 53, 37, 42, 46, 110, 55, 119, 55, 102, 117, 109}, "2d399c"));
                p pVar = new p(str2);
                this.c = pVar;
                pVar.f5557a = this;
                if (Build.VERSION.SDK_INT >= 33) {
                    this.b.registerReceiver(pVar, intentFilter, 2);
                } else {
                    this.b.registerReceiver(pVar, intentFilter);
                }
            }
            m.a(s.d(new byte[]{38, 89, Ascii.DC4, 15, 94, 93, 0, 0, 37, 14, 88, 6, 9, 126, 2, 15, 86, 94, 4, Ascii.SYN}, "b6ca22"), s.d(new byte[]{88, 87, 87, 5, 90, 86, 6, 52, 7, 5, 84, 48, 70, 90, Ascii.EM, 92, 19, 26}, "469a38") + str + s.d(new byte[]{65}, "c62a83"));
            if (ClickAreaType.isButtonArea(clickAreaType) && mimoAdInfo.S) {
                ((CommonActionHandler.a) v3Var).a(ClickActionType.DOWNLAOD, false);
                return;
            }
            if (!TextUtils.isEmpty(str) && ((str.startsWith(s.d(new byte[]{92, 4, 68, 8, 85, 66}, "1e6c06")) || str.startsWith(s.d(new byte[]{8, 8, 14, 7, 68, 88, 4, 16}, "eacf63"))) && f9.a(y8.f5752a, s.d(new byte[]{85, 9, 85, Ascii.US, 26, 94, 0, 11, 11, 11, Ascii.US, 8, 87, Ascii.DC4, 83, 84, Ascii.SYN}, "6f81b7")) >= 1914670)) {
                try {
                    Intent intent = new Intent(s.d(new byte[]{0, 13, 84, Ascii.ETB, 12, 89, 5, 74, 15, 12, 69, 0, 15, Ascii.ETB, Ascii.RS, 4, 0, 68, 8, 11, 8, 76, 103, 44, 36, 52}, "ac0ec0"));
                    intent.setData(Uri.parse(str));
                    intent.setPackage(s.d(new byte[]{85, 14, 90, Ascii.GS, Ascii.ESC, 80, 0, 11, 11, 11, Ascii.US, 8, 87, 19, 92, 86, Ascii.ETB}, "6a73c9"));
                    intent.addFlags(268435456);
                    intent.addFlags(8388608);
                    intent.addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
                    this.b.startActivity(intent);
                    ((CommonActionHandler.a) v3Var).a(ClickActionType.DOWNLAOD, false);
                    return;
                } catch (Exception e) {
                    m.b(s.d(new byte[]{117, 14, 65, 11, 85, 95, 0, 0, 37, 14, 88, 6, 90, 41, 87, 11, 93, 92, 4, Ascii.SYN}, "1a6e90"), s.d(new byte[]{Ascii.SYN, 77, 80, 69, Ascii.DC2, 38, 14, 19, 8, 14, 94, 4, 1, 123, 72, 122, 15, 47, 0, Ascii.SYN, 13, 7, 69}, "e917fb"), e);
                }
            }
        }
        u3 u3Var = this.f5627a;
        if (u3Var != null) {
            u3Var.a(mimoAdInfo, clickAreaType, v3Var, z);
        }
    }
}
