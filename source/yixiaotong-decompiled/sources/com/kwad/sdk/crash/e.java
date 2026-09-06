package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {
    private com.kwad.sdk.crash.b.b beg;
    private c beh;
    private long bei;

    static class a {
        private static final e bej = new e(0);
    }

    public final c Qi() {
        return this.beh;
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f fVarQa = this.beh.Qa();
        if (fVarQa != null) {
            fVarQa.a(i, exceptionMessage);
        }
    }

    private e() {
        this.beg = new com.kwad.sdk.crash.b.b();
        this.beh = new c.a().Qc();
    }

    public static e Qd() {
        return a.bej;
    }

    public final String[] Qe() {
        return this.beg.Qq();
    }

    public final String[] Qf() {
        return this.beg.Qf();
    }

    public final String getAppId() {
        return this.beh.bdF.mAppId;
    }

    public final String Qg() {
        return this.beh.bdE.beK;
    }

    public final String getSdkVersion() {
        return this.beh.bdE.mSdkVersion;
    }

    public final int Qh() {
        return this.beh.bdE.beO;
    }

    public final void a(c cVar) {
        this.beh = cVar;
        this.bei = SystemClock.elapsedRealtime();
        this.beg.a(cVar.bdH, cVar.bdI);
    }

    public final Context getContext() {
        return this.beh.context;
    }

    public final h Qj() {
        return this.beh.bdG;
    }

    public final long Qk() {
        return SystemClock.elapsedRealtime() - this.bei;
    }

    public final boolean isDebug() {
        return this.beh.isDebugMode();
    }
}
