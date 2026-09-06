package com.cdo.oaps.ad;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class n implements l {
    @Override // com.cdo.oaps.ad.l
    public boolean a(Context context, Map<String, Object> map) {
        return (!Launcher.Host.MK.equals(OapsWrapper.wrapper(map).getHost()) || p.b(context) >= 5100) ? new j().a(context, map) : ad.a(context, map);
    }

    @Override // com.cdo.oaps.ad.l
    public boolean b(Context context, Map<String, Object> map) {
        return (!Launcher.Host.MK.equals(OapsWrapper.wrapper(map).getHost()) || p.b(context) >= 5100) ? new j().b(context, map) : ad.b(context, map);
    }
}
