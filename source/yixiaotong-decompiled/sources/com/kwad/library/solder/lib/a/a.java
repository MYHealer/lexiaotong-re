package com.kwad.library.solder.lib.a;

import android.content.Context;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a {
    protected File aEE;
    protected String aEF;
    protected String aEG;
    private final String aEJ;
    protected com.kwad.library.solder.lib.c.b aEK;
    protected String mVersion;
    private final byte[] aEI = new byte[0];
    private boolean aEH = false;
    protected com.kwad.library.solder.lib.ext.c aEj = i.DQ().DK();

    public final String DV() {
        return this.aEJ;
    }

    public final a a(com.kwad.library.solder.lib.c.b bVar) {
        this.aEK = bVar;
        return this;
    }

    public final void cB(String str) {
        this.mVersion = str;
    }

    public final void cC(String str) {
        this.aEG = str;
    }

    public final void cD(String str) {
        this.aEF = str;
    }

    public final String getId() {
        return this.aEG;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    protected abstract void l(Context context, String str);

    public a(String str) {
        this.aEJ = str;
        this.aEF = str;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.aEJ + "'}";
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.aEH) {
            return true;
        }
        synchronized (this.aEI) {
            z = this.aEH;
        }
        return z;
    }

    private void DU() {
        if (this.aEH) {
            return;
        }
        synchronized (this.aEI) {
            this.aEH = true;
        }
    }

    public final String DW() {
        com.kwad.library.solder.lib.c.b bVar = this.aEK;
        if (bVar != null) {
            return bVar.aFu;
        }
        return null;
    }

    public final void q(Context context, String str) {
        l(context, str);
        DU();
    }
}
