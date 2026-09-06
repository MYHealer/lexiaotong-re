package com.huawei.hms.ads.template.downloadbuttonstyle;

import android.content.Context;
import com.huawei.openalliance.ad.views.AppDownloadButton;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class a {
    protected Context Code;
    protected AppDownloadButton V;

    public a(Context context, AppDownloadButton appDownloadButton) {
        this.Code = context;
        this.V = appDownloadButton;
    }

    protected abstract void Code();

    public void Code(Context context) {
        V(context);
        Code();
    }

    public abstract void Code(String str);

    protected abstract void V(Context context);
}
