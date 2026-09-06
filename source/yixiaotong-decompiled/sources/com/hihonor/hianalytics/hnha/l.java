package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class l {
    public n a(m mVar) {
        n nVar;
        long jA = com.hihonor.hianalytics.util.r.a();
        try {
            String[] strArrQ = g.q();
            if (mVar.c != 2 || strArrQ == null || strArrQ.length <= 0) {
                nVar = TextUtils.isEmpty(mVar.f3658a) ? new n(-100, com.hihonor.hianalytics.util.r.a() - jA) : new n(l3.a(mVar.f3658a, mVar.d, mVar.b), com.hihonor.hianalytics.util.r.a() - jA);
            } else {
                nVar = new n(o3.a().a(mVar.d, mVar.b, "preload_url_tag"), com.hihonor.hianalytics.util.r.a() - jA);
            }
            return nVar;
        } catch (Throwable th) {
            j2.g("NetManager", "postData failE=" + SystemUtils.getDesensitizedException(th));
            return new n(th, com.hihonor.hianalytics.util.r.a() - jA);
        }
    }
}
