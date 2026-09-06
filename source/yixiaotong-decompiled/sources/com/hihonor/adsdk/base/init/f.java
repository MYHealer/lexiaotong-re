package com.hihonor.adsdk.base.init;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.g.j.d.p0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.common.f.a0;
import com.hihonor.adsdk.common.f.l;
import com.hihonor.hianalytics.util.HiAnalyticTools;
import com.tencent.mmkv.MMKV;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f implements e {
    private static final String hnadsb = "InitializerImpl";
    private com.hihonor.adsdk.base.download.a hnadsa;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsb(Context context) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "init#init ad sdk. version:%s, buildType:%s, env:%s", "10024300", "release", "env_prod_union");
        a0.hnadsa(new l() { // from class: com.hihonor.adsdk.base.init.f$$ExternalSyntheticLambda1
            @Override // com.hihonor.adsdk.common.f.l
            public final void hnadsa(Exception exc, String str) {
                f.hnadsa(exc, str);
            }
        });
        HnAdConfig cfg = HnAds.get().getCfg();
        hnadsa(context, cfg);
        b.hnadsc().hnadsc(context);
        com.hihonor.adsdk.base.net.i.hnadsb();
        com.hihonor.adsdk.base.g.i.hnadsc();
        com.hihonor.adsdk.base.j.e.hnadsb().hnadsk();
        h.hnadsa("initOaid");
        com.hihonor.adsdk.base.download.d.hnadsa().hnadsc();
        hnadsa(cfg);
        com.hihonor.adsdk.base.j.n.g.hnadsa().hnadsc();
        com.hihonor.adsdk.base.e.c.hnadsa().hnadsd();
    }

    @Override // com.hihonor.adsdk.base.init.e
    public void hnadsa(final Context context) {
        hnadsc(context);
        a0.hnadsb(new Runnable() { // from class: com.hihonor.adsdk.base.init.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hnadsb(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(Exception exc, String str) {
        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.SUB_HANDLER_GET_EXCEPTION, str).hnadse();
    }

    private void hnadsc(Context context) {
        if (this.hnadsa != null || context == null) {
            return;
        }
        com.hihonor.adsdk.base.download.a aVar = new com.hihonor.adsdk.base.download.a();
        this.hnadsa = aVar;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(aVar);
            return;
        }
        Application applicationHnadsb = com.hihonor.adsdk.common.f.a.hnadsd().hnadsb();
        if (applicationHnadsb != null) {
            applicationHnadsb.registerActivityLifecycleCallbacks(this.hnadsa);
        }
    }

    @Override // com.hihonor.adsdk.base.init.e
    public void hnadsa(Application application) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "initActivityLifecycle", new Object[0]);
        hnadsc(application);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void hnadsa(Context context, HnAdConfig hnAdConfig) {
        if (hnAdConfig != null && hnAdConfig.isSupportMultiProcess()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "init#init ad sdk. support multi process.", new Object[0]);
            synchronized (MMKV.class) {
                try {
                    if (TextUtils.isEmpty(MMKV.getRootDir())) {
                        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "MMKV rootDir is null", new Object[0]);
                        MMKV.initialize(context);
                    } else {
                        com.hihonor.adsdk.common.b.b.hnadsa(hnadsb, (Object) ("MMKV initialize has done: " + MMKV.getRootDir()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                HiAnalyticTools.enableNewMode();
                return;
            } catch (Throwable th2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "initHaSupportMultiProcess, init#init ad sdk. media set support multi process enable.but HiAnalyticTools.enableNewMode() exception. message is " + th2.getMessage(), new Object[0]);
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "init#init ad sdk. un support multi process.", new Object[0]);
    }

    public void hnadsa(HnAdConfig hnAdConfig) {
        if (hnAdConfig == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "reportInit, config is null", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(com.hihonor.adsdk.base.j.g.hnadsa(hnAdConfig));
            jSONObject.remove("appKey");
            new p0(jSONObject.toString()).hnadse();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("config to json have Exception:");
            sb.append(e.getMessage());
            sb.append("appId is:");
            sb.append(hnAdConfig.getAppId());
            sb.append("appName is:");
            sb.append(hnAdConfig.getAppName());
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "reportInit, " + ((Object) sb), new Object[0]);
            new p0(sb.toString()).hnadse();
        }
    }
}
