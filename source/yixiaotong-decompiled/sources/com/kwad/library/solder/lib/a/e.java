package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class e<P extends a> {
    protected String aDT;
    protected int aEM;
    protected String aEO;
    protected String aEP;
    protected boolean aEQ;
    protected P aER;
    protected com.kwad.library.solder.lib.ext.b aES;
    protected Throwable aET;
    protected String aEU;
    protected boolean aEV;
    protected long aEW;
    protected String aEX;
    protected List<com.kwad.library.solder.lib.c.a> aEY;
    protected com.kwad.library.solder.lib.c.b aEZ;
    protected d aEt;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int aEL = 0;
    private final byte[] aEI = new byte[0];
    protected StringBuffer aEN = new StringBuffer(String.valueOf(this.mState));

    public final d DX() {
        return this.aEt;
    }

    public final Throwable DZ() {
        return this.aET;
    }

    public final String Eb() {
        return this.aDT;
    }

    public final boolean Ec() {
        return this.aEQ;
    }

    public final int Ed() {
        return this.aEL;
    }

    public final com.kwad.library.solder.lib.ext.b Ef() {
        return this.aES;
    }

    public final boolean Eg() {
        return this.aEV;
    }

    public final String Eh() {
        return this.aEU;
    }

    public final String Ei() {
        return this.aEX;
    }

    public final com.kwad.library.solder.lib.c.b Ej() {
        return this.aEZ;
    }

    public final e a(d dVar) {
        this.aEt = dVar;
        return this;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.aES = bVar;
    }

    public final void c(P p) {
        this.aER = p;
    }

    public final void cB(String str) {
        this.mVersion = str;
    }

    public final void cF(String str) {
        this.aEO = str;
    }

    public final void cG(String str) {
        this.aEP = str;
    }

    public abstract P cH(String str);

    public final void dh(int i) {
        if (i > 0) {
            this.aEM = i;
        }
    }

    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.aEZ = bVar;
        this.aDT = bVar.aFr;
        this.mVersion = bVar.version;
        this.aEX = bVar.aFu;
        this.aEV = bVar.aEV;
        this.aEU = bVar.aEU;
        this.aEW = bVar.aFt;
        this.mDownloadUrl = bVar.aFs;
    }

    public final int getState() {
        int i;
        synchronized (this.aEI) {
            i = this.mState;
        }
        return i;
    }

    public final String DY() {
        return this.aEN.toString();
    }

    public final e dg(int i) {
        synchronized (this.aEI) {
            this.mState = i;
        }
        return cE(String.valueOf(i));
    }

    public final void cancel() {
        synchronized (this.aEI) {
            dg(0);
        }
    }

    public final e cE(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aEN.append(" --> ").append(str);
        }
        return this;
    }

    public final e q(Throwable th) {
        this.aET = th;
        return cE(th.getLocalizedMessage());
    }

    public final boolean Ea() {
        dg(-1);
        this.aEY = null;
        int i = this.aEL + 1;
        this.aEL = i;
        return i <= this.aEM;
    }

    public final String Ee() {
        return !TextUtils.isEmpty(this.aEO) ? this.aEO : this.aEP;
    }

    public final List<com.kwad.library.solder.lib.c.a> Ek() {
        String strEb = Eb();
        if (!TextUtils.isEmpty(strEb) && this.aEY == null) {
            this.aEY = b(strEb, getVersion(), Ei());
        }
        return this.aEY;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.aEt.DN().cx(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.aEt.DN().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.aFr = str;
                            aVar.version = str4;
                            aVar.un = true;
                            arrayList.add(aVar);
                        } else {
                            this.aEt.DN().G(str, str4);
                        }
                    } else {
                        this.aEt.DN().G(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "PluginRequest{mId='" + this.aDT + "'}";
    }
}
