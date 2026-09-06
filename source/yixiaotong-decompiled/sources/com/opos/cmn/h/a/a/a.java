package com.opos.cmn.h.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (b.a() && com.opos.cmn.an.h.d.a.d(origApplicationContext, com.opos.cmn.an.b.b.a("Y29tLnRlbmNlbnQubW0=")) && com.opos.cmn.an.h.d.a.b(origApplicationContext, com.opos.cmn.an.b.b.a("Y29tLnRlbmNlbnQubW0=")) >= 980) {
                    z = true;
                }
                com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return z;
            }
            com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram failed, context is null!");
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MiniProgramUtils", "isSupportMiniProgram", th);
        }
        z = false;
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return z;
    }

    public static boolean a(Context context, com.opos.cmn.h.a.b.a aVar) {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zSendReq = false;
        if (context != null && aVar != null) {
            try {
                if (TextUtils.isEmpty(aVar.f6165a)) {
                    str = "openMiniProgram failed, appId is null!";
                } else if (a(context)) {
                    IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(StubApp.getOrigApplicationContext(context.getApplicationContext()), aVar.f6165a, false);
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = aVar.b;
                    req.path = aVar.c;
                    req.miniprogramType = 0;
                    zSendReq = iwxapiCreateWXAPI.sendReq(req);
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("MiniProgramUtils", "openMiniProgram", th);
            }
            com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + zSendReq + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return zSendReq;
        }
        str = "openMiniProgram failed, context or miniProgramParams is null!";
        com.opos.cmn.an.f.a.b("MiniProgramUtils", str);
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + zSendReq + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return zSendReq;
    }
}
