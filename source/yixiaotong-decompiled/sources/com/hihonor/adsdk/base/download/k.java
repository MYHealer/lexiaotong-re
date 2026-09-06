package com.hihonor.adsdk.base.download;

import android.text.TextUtils;
import com.hihonor.adsdk.common.f.t;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k {
    private static final String hnadsc = "DownloadUrlManager";
    private static final String hnadsd = "pkgType";
    private static final String hnadse = "packageSet";
    private final t hnadsa;
    private final t hnadsb;

    static /* synthetic */ class a {
    }

    private static class b {
        private static final k hnadsa = new k(null);
        private static final Boolean hnadsb = Boolean.TRUE;

        private b() {
        }
    }

    /* synthetic */ k(a aVar) {
        this();
    }

    public static k hnadsa() {
        return b.hnadsa;
    }

    public void hnadsb(g gVar) {
        if (b.hnadsb.booleanValue() || gVar == null) {
            return;
        }
        if (gVar.d() == 2 && gVar.hnadsv() == 0) {
            return;
        }
        String strHnadsd = gVar.hnadsd();
        String strA = gVar.a();
        int iD = gVar.d();
        if (TextUtils.isEmpty(strHnadsd) || TextUtils.isEmpty(strA) || !TextUtils.isEmpty(this.hnadsa.hnadsg(strHnadsd))) {
            return;
        }
        this.hnadsa.hnadsa(strHnadsd, strA, true);
        this.hnadsb.hnadsa(strHnadsd, iD, true);
        Set<String> setHnadsh = this.hnadsa.hnadsh(hnadse);
        setHnadsh.add(strHnadsd);
        this.hnadsa.hnadsa(hnadse, setHnadsh, true);
    }

    private k() {
        this.hnadsa = t.hnadsd(hnadsc);
        this.hnadsb = t.hnadsd(hnadsd);
    }

    public void hnadsa(String str) {
        if (b.hnadsb.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        this.hnadsb.hnadsc(str, true);
        this.hnadsa.hnadsc(str, true);
        Set<String> setHnadsh = this.hnadsa.hnadsh(hnadse);
        setHnadsh.remove(str);
        this.hnadsa.hnadsa(hnadse, setHnadsh, true);
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "clearDownloadUrl pkg:" + str + " set:" + setHnadsh, new Object[0]);
    }

    public void hnadsa(g gVar) {
        if (b.hnadsb.booleanValue() || gVar == null) {
            return;
        }
        if (gVar.d() == 2 && gVar.hnadsv() == 0) {
            return;
        }
        String strHnadsg = this.hnadsa.hnadsg(gVar.hnadsd());
        if (TextUtils.isEmpty(strHnadsg)) {
            return;
        }
        gVar.hnadsi(strHnadsg);
    }

    public void hnadsb(String str, int i) {
        if (b.hnadsb.booleanValue()) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "removeStatus pkg:" + str + " status:" + i, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i == -1 || i == 2008 || i == 2005 || i == 2011 || i == 2100 || i == 2012) {
            hnadsa(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(String str, int i) {
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "queryAppStatus package:" + str + " status:" + i, new Object[0]);
        hnadsb(str, i);
    }

    public void hnadsb() {
        if (b.hnadsb.booleanValue()) {
            return;
        }
        Set<String> setHnadsh = this.hnadsa.hnadsh(hnadse);
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "getDownloadUrlListAppStatus onInitResult set: " + setHnadsh.size(), new Object[0]);
        if (setHnadsh.isEmpty()) {
            return;
        }
        for (String str : setHnadsh) {
            int iHnadsa = this.hnadsb.hnadsa(str, -1);
            if (iHnadsa >= 0) {
                d.hnadsa().hnadsa(str, iHnadsa, new m() { // from class: com.hihonor.adsdk.base.download.k$$ExternalSyntheticLambda0
                    @Override // com.hihonor.adsdk.base.download.m
                    public final void hnadsa(String str2, int i) {
                        this.f$0.hnadsa(str2, i);
                    }
                });
            }
        }
    }
}
