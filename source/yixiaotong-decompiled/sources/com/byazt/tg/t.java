package com.byazt.tg;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gq.z;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 66})
public class t implements i {
    @Override // com.byazt.tg.i
    public boolean c(com.byazt.dd.tt ttVar, int i, x xVar) {
        DownloadInfo downloadInfoTt;
        if (ttVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(ttVar.oz())) {
            downloadInfoTt = com.byazt.di.da.c((Context) null).c(ttVar.oz(), null, true);
        } else {
            downloadInfoTt = com.byazt.di.da.c((Context) null).tt(ttVar.c());
        }
        return z.c(ttVar, downloadInfoTt, i, xVar, false, null);
    }
}
