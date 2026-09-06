package com.ubix.ssp.open;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXAdLossInfo {
    public String lossReason;
    public String winPlatform;
    public long winPrice = 0;
    public String[] adMeta = new String[0];

    public HashMap<String, String> getInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("__win_price__", this.winPrice + "");
        if (!TextUtils.isEmpty(this.winPlatform)) {
            map.put("__win_bidder__", this.winPlatform);
        }
        if (!TextUtils.isEmpty(this.lossReason)) {
            map.put("__loss_reason__", this.lossReason);
        }
        String[] strArr = this.adMeta;
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            if (!str.isEmpty()) {
                map.put("__win_meta__", str);
            }
        }
        return map;
    }
}
