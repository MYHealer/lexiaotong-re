package com.kwad.components.core.page.widget.a;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.ez;
import com.kwad.components.core.t.r;
import com.kwad.components.core.t.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f implements g {
    @Override // com.kwad.components.core.page.widget.a.g
    public final e bc(String str) {
        e eVar = new e();
        if (TextUtils.isEmpty(str)) {
            return eVar;
        }
        Uri uri = Uri.parse(str);
        eVar.ahx = r.a(u.a(uri, "heightRatio", "0"), 0.0f);
        eVar.ahy = r.a(u.a(uri, "absoluteHeight", "0"), 0.0f);
        eVar.ahA = r.m(u.a(uri, "topRadius", "0"), 0);
        eVar.ahz = r.a(u.a(uri, "maskAlpha", "0"), 0.0f);
        eVar.ahB = bd(u.a(uri, "disableClickOutsideDismiss", ez.V));
        eVar.ahC = bd(u.a(uri, "enableDragHalfToFull", ez.V));
        eVar.ahD = bd(u.a(uri, "showStatusBar", ez.V));
        eVar.ahF = bd(u.a(uri, "isAdjustKeyBoard", ez.Code));
        eVar.ahH = u.a(uri);
        return eVar;
    }

    private static boolean bd(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }
}
