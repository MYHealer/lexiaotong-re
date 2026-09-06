package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.ba;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String auA;
    public int errorCode;
    public String errorReason;
    public int rq;

    public final boolean zr() {
        return TextUtils.equals("start", this.auA);
    }

    public final boolean zs() {
        return TextUtils.equals(TtmlNode.END, this.auA);
    }

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.util.e.f1657a, this.auA);
    }

    public final boolean zt() {
        return TextUtils.equals("progress", this.auA);
    }

    public final boolean zu() {
        return TextUtils.equals("pause", this.auA);
    }

    public final boolean zv() {
        return TextUtils.equals(ba.ag, this.auA);
    }

    public final int zw() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
