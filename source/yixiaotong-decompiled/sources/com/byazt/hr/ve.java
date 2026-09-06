package com.byazt.hr;

import android.text.TextUtils;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 54})
public class ve {
    public Map<String, tt> c;
    public Map<String, ConcurrentHashMap<String, com.byazt.hr.c>> tt;

    /* JADX INFO: renamed from: com.byazt.hr.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 29, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 29, 24})
    private static class c {
        public static ve c = new ve(null);
    }

    public /* synthetic */ ve(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ve() {
        this.tt = new ConcurrentHashMap();
    }

    public static ve c() {
        return c.c;
    }

    public void c(ConcurrentHashMap<String, tt> concurrentHashMap) {
        this.c = concurrentHashMap;
        if (concurrentHashMap != null) {
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "mAdnControlMap = ".concat(String.valueOf(concurrentHashMap)));
        } else {
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "mAdnControlMap is null ");
        }
    }

    public void c(String str, String str2, String str3) {
        com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError adnName = " + str + " slotId = " + str2 + " error = " + str3);
        Map<String, tt> map = this.c;
        tt ttVar = map != null ? map.get(str) : null;
        if (ttVar != null) {
            for (String str4 : ttVar.tt()) {
                if (TextUtils.equals(str4, str3)) {
                    com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError 命中errorCode = ".concat(String.valueOf(str4)));
                    long time = new Date().getTime() + ttVar.c();
                    com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError 更新时间 = " + a.tt(time));
                    com.byazt.hr.c cVar = new com.byazt.hr.c(str, str2, time);
                    if (this.tt != null) {
                        ConcurrentHashMap<String, com.byazt.hr.c> concurrentHashMap = new ConcurrentHashMap<>();
                        concurrentHashMap.put(str2, cVar);
                        this.tt.put(str, concurrentHashMap);
                        com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "setAdnError mAdnControlMap = " + this.tt);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public com.byazt.pp.c c(String str, String str2) {
        com.byazt.hr.c cVar;
        ConcurrentHashMap<String, com.byazt.hr.c> concurrentHashMap;
        com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad adnName = " + str + " slotId = " + str2);
        Map<String, ConcurrentHashMap<String, com.byazt.hr.c>> map = this.tt;
        if (map == null || (concurrentHashMap = map.get(str)) == null) {
            cVar = null;
        } else {
            cVar = concurrentHashMap.get(str2);
            com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 取出的showBean = ".concat(String.valueOf(cVar)));
        }
        if (cVar != null && cVar.c() != 0) {
            long time = new Date().getTime();
            if (time <= cVar.c()) {
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 当前时间 = " + a.tt(time));
                com.byazt.eu.tt.c("TTMediationSDK_AdnShowControl", "checkLoad 规则有效时间 = " + a.tt(cVar.c()));
                return new com.byazt.bnd.c(40044, com.byazt.pp.c.c(40044));
            }
        }
        return null;
    }
}
