package com.byazt.hu;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1381, 66})
public class t {

    /* JADX INFO: renamed from: com.byazt.hu.t$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1381, 167})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 1381, AppTypeIdUtil.NewDevice4GDrinkOTA_2})
    private static class c {
        public static t c = new t(null);
    }

    public /* synthetic */ t(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static t c() {
        return c.c;
    }

    private t() {
    }

    public void c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }

    public void tt(String str, String str2, String str3) {
        m.uj("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
