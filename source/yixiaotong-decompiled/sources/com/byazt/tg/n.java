package com.byazt.tg;

import android.text.TextUtils;
import com.byazt.gq.z;
import com.byazt.t.DownloadInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 46})
public class n implements sp {
    @Override // com.byazt.tg.sp
    public boolean c(com.byazt.dd.tt ttVar, int i, x xVar, com.byazt.de.ve veVar) {
        DownloadInfo downloadInfoTt;
        if (ttVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(ttVar.oz())) {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).c(ttVar.oz(), null, true);
        } else {
            downloadInfoTt = com.byazt.di.da.c(com.byazt.gq.t.getContext()).tt(ttVar.c());
        }
        return z.c(ttVar, downloadInfoTt, i, xVar, true, veVar);
    }
}
