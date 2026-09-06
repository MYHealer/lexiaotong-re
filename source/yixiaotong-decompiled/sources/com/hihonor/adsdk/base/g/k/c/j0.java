package com.hihonor.adsdk.base.g.k.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class j0 extends k0 {
    public void hnadsa(int i, int i2, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        this.hnadsa.put("__ACTION__", i + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsn, i2 + "");
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadso, str);
        if (!TextUtils.isEmpty(str2)) {
            this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsp, com.hihonor.adsdk.common.f.z.hnadsa(str2));
        }
        this.hnadsa.put(com.hihonor.adsdk.base.g.j.e.c.hnadsq, System.currentTimeMillis() + "");
    }
}
