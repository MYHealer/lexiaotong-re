package com.hihonor.adsdk.base;

import android.app.Application;
import android.content.Context;
import com.hihonor.adsdk.base.init.HnAdConfig;
import com.hihonor.adsdk.base.init.HnAdManager;
import com.hihonor.adsdk.base.init.e;
import com.hihonor.adsdk.base.init.f;
import com.hihonor.adsdk.base.init.h;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnAds {
    private static final String LOG_TAG = "HnAds";
    private e initializer;
    private HnAdConfig mAdConfig;
    private Context mContext;

    static /* synthetic */ class a {
    }

    private static final class b {
        private static final HnAds hnadsa = new HnAds(null);

        private b() {
        }
    }

    /* synthetic */ HnAds(a aVar) {
        this();
    }

    public static HnAds get() {
        return b.hnadsa;
    }

    public HnAdManager getAdManager() {
        return new com.hihonor.adsdk.base.init.a();
    }

    public HnAdConfig getCfg() {
        return this.mAdConfig;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, HnAdConfig hnAdConfig) {
        if (context == null) {
            throw new IllegalArgumentException("SDK init context must not be null");
        }
        if (hnAdConfig == null) {
            throw new IllegalArgumentException("SDK init HnAdConfig must not be null");
        }
        this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "forceEnableDebugLog =false", new Object[0]);
        com.hihonor.adsdk.common.b.b.hnadsa(false);
        com.hihonor.adsdk.common.a.hnadsa().hnadsa(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        updateConfig(hnAdConfig);
        this.initializer.hnadsa(this.mContext);
        com.hihonor.adsdk.base.j.a.hnadsb().hnadsc();
    }

    public void initActivityLifecycle(Application application) {
        if (application == null) {
            throw new IllegalArgumentException("initActivityLifecycle application must not be null");
        }
        this.initializer.hnadsa(application);
    }

    public boolean isInitialized() {
        return (this.mContext == null || this.mAdConfig == null) ? false : true;
    }

    public boolean isSdkConfigSuccess() {
        return h.hnadsb();
    }

    public void updateConfig(HnAdConfig hnAdConfig) {
        this.mAdConfig = hnAdConfig;
    }

    private HnAds() {
        this.initializer = new f();
    }
}
