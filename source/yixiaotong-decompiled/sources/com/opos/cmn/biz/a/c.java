package com.opos.cmn.biz.a;

import android.content.Context;
import com.byazt.bv.BaseConstants;
import com.cdo.oaps.ad.af;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5962a = "com." + com.opos.cmn.an.b.a.c + ".market";
    private static final String b = "com." + com.opos.cmn.an.b.a.f5875a + ".market";
    private static final String c = "com." + com.opos.cmn.an.b.a.d + ".browser";

    public static String a(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, af.e)) {
            return af.e;
        }
        String str = f5962a;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return str;
        }
        String str2 = b;
        return com.opos.cmn.an.h.d.a.d(context, str2) ? str2 : "";
    }

    public static String b(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO)) {
            return BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO;
        }
        String str = c;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return str;
        }
        if (com.opos.cmn.an.h.d.a.d(context, "com.nearme.browser")) {
            return "com.nearme.browser";
        }
        return com.opos.cmn.an.h.d.a.d(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO) ? BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO : "";
    }
}
