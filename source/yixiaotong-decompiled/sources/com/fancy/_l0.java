package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l0 {
    public static void _a(_f _fVar, List<String> list) {
        if (_fVar == null || list == null || list.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(_fVar._r)) {
            map.put("User-Agent", _fVar._r);
            map.put("Referer", "");
        }
        NetUtils._a(list, (HashMap<String, String>) map);
        Logger.d("PtgAdTrackManager", "AdTrackManager do videoImp ", list);
    }
}
