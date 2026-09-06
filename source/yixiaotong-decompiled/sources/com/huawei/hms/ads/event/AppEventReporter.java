package com.huawei.hms.ads.event;

import android.content.Context;
import com.huawei.hms.ads.dc;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.ad;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AppEventReporter {
    public static void reportEventData(Context context, Map<String, String> map) {
        g.V(context).Code(dc.S, ad.V(map), null, null);
    }
}
