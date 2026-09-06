package com.hihonor.adsdk.common.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class c implements e {
    private final List<f> hnadsa = new ArrayList();
    private boolean hnadsb = false;

    c() {
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(String str, String str2, Object... objArr) {
        hnadsa(3, str, null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(boolean z) {
        this.hnadsb = z;
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsb(String str, String str2, Object... objArr) {
        hnadsa(5, str, null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsc(String str, String str2, Object... objArr) {
        hnadsa(7, str, null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsd(String str, String str2, Object... objArr) {
        hnadsa(str, (Throwable) null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadse(String str, String str2, Object... objArr) {
        hnadsa(2, str, null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsf(String str, String str2, Object... objArr) {
        hnadsa(4, str, null, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(String str, Object obj) {
        hnadsa(3, str, null, com.hihonor.adsdk.common.b.j.b.hnadsa(obj), new Object[0]);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(String str, Throwable th, String str2, Object... objArr) {
        hnadsa(6, str, th, str2, objArr);
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(int i, String str, String str2, Throwable th) {
        if (th != null) {
            if (str2 != null) {
                str2 = str2 + " : " + com.hihonor.adsdk.common.b.j.b.hnadsa(th);
            }
            if (str2 == null) {
                str2 = com.hihonor.adsdk.common.b.j.b.hnadsa(th);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "Log content is empty or none";
        }
        for (f fVar : this.hnadsa) {
            if (fVar.hnadsa(i, str) || this.hnadsb) {
                fVar.hnadsa(i, str, str2);
            }
        }
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa() {
        this.hnadsa.clear();
    }

    @Override // com.hihonor.adsdk.common.b.e
    public void hnadsa(f fVar) {
        this.hnadsa.add(fVar);
    }

    private void hnadsa(int i, String str, Throwable th, String str2, Object... objArr) {
        hnadsa(i, str, hnadsa(str2, objArr), th);
    }

    private String hnadsa(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
