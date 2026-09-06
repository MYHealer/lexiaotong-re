package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class av extends ah {
    private static final String Z = "CmdBaseDownload";

    public av(String str) {
        super(str);
    }

    protected IAppDownloadManager V(Context context, String str) {
        IAppDownloadManager iAppDownloadManagerCode = com.huawei.hms.ads.jsb.a.Code(context).Code();
        iAppDownloadManagerCode.Code(B(str));
        if (com.huawei.openalliance.ad.utils.z.B(context)) {
            iAppDownloadManagerCode.Code(true);
        }
        return iAppDownloadManagerCode;
    }
}
