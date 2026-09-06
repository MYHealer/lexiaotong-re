package com.byazt.lkt;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aas.gu;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.byazt.qh.uj;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSConfig;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import ms.bz.bd.c.Pgl.pblv;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 545, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f2456a = "";
    public static volatile c c;
    public static volatile uj i;
    public volatile String n;
    public final AtomicBoolean sp = new AtomicBoolean(false);
    public PglMSManager tt;
    public final String uj;
    public volatile boolean ve;
    public volatile int x;

    public static c c() {
        return c;
    }

    private static c uj(String str) {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c(str);
                }
            }
        }
        return c;
    }

    private c(String str) {
        this.x = pblv.COLLECT_MODE_DEFAULT;
        String strRl = x.m().rl();
        com.byazt.dj.uj ujVarNu = x.m().nu();
        if (ujVarNu != null) {
            if (!ujVarNu.isCanUsePhoneState() || !ujVarNu.isCanUseWifiState() || !ujVarNu.isCanUseWriteExternal()) {
                this.x = 290;
            }
            if (!ujVarNu.isCanUseAndroidId()) {
                this.x = 290;
            }
        }
        this.n = null;
        this.uj = strRl;
        this.ve = n(str);
    }

    private boolean n(String str) {
        try {
            Context context = gt.getContext();
            PglMSConfig.Builder builder = new PglMSConfig.Builder("1371", this.uj, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.x);
            builder.addDataObserver(new PglITokenObserver() { // from class: com.byazt.lkt.c.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str2) {
                    String unused = c.f2456a = str2;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    com.byazt.by.uj.c().sl(str2);
                }
            });
            if (!x.m().sp()) {
                builder.addAdvanceInfo("kOA1", "1");
            } else if (!x.m().da()) {
                builder.setOaid(str);
            }
            if (!x.m().uj()) {
                builder.addAdvanceInfo("kS1", "1");
            }
            if (!x.m().sl()) {
                builder.addAdvanceInfo("kDisableBlueToothCollection", "1");
            }
            if (!x.m().u()) {
                builder.addAdvanceInfo("kDisableIpCollection", "1");
            }
            com.byazt.dj.uj ujVarNu = x.m().nu();
            if (ujVarNu != null && !ujVarNu.alist()) {
                builder.addAdvanceInfo("kDisableAppListCollection", "1");
                builder.addAdvanceInfo("kDisableImeListCollection", "1");
            }
            PglMSManagerUtils.init(context, builder.setDeviceID(this.n).setClientType(1).build());
            PglMSManagerUtils.initToken("1371");
            ve();
            return true;
        } catch (Throwable th) {
            m.tt("MSSdkImpl", "appid 为空，初始化失败！", th);
            return false;
        }
    }

    private void ve() {
        if (this.tt == null) {
            this.tt = PglMSManagerUtils.get("1371");
        }
    }

    public void c(String str) {
        if (this.ve) {
            ve();
            if (TextUtils.isEmpty(str) || str.equals(this.n) || this.tt == null) {
                return;
            }
            this.n = str;
            this.tt.setDeviceID(str);
        }
    }

    public void tt(String str) {
        if (this.ve) {
            ve();
            PglMSManager pglMSManager = this.tt;
            if (pglMSManager != null) {
                pglMSManager.report(str);
            }
        }
    }

    public static String tt() {
        if (TextUtils.isEmpty(f2456a)) {
            f2456a = com.byazt.by.uj.c().nu();
        }
        return f2456a;
    }

    public Map<String, String> c(String str, byte[] bArr) {
        if (!this.ve) {
            return new HashMap();
        }
        ve();
        PglMSManager pglMSManager = this.tt;
        if (pglMSManager != null) {
            return pglMSManager.getFeatureHash(str, bArr);
        }
        return new HashMap();
    }

    public static void c(uj ujVar) {
        i = ujVar;
        c(true);
    }

    public static c c(boolean z) {
        if (!x.m().i()) {
            return uj(null);
        }
        if (i != null) {
            return c == null ? uj(gu.ve(i)) : c;
        }
        if (z) {
            return uj("error");
        }
        return null;
    }
}
