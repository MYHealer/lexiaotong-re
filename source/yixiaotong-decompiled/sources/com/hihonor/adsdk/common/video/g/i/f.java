package com.hihonor.adsdk.common.video.g.i;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f implements c {
    private static final int hnadsa = 4;

    private String hnadsb(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.hihonor.adsdk.common.video.g.i.c
    public String hnadsa(String str) {
        String strHnadsb = hnadsb(str);
        String strHnadsa = com.hihonor.adsdk.common.video.g.l.a.hnadsa(str);
        return TextUtils.isEmpty(strHnadsb) ? strHnadsa : strHnadsa + "." + strHnadsb;
    }
}
