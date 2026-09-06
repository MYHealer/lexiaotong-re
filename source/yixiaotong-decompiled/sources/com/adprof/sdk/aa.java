package com.adprof.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class aa implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f16a = new Handler(Looper.getMainLooper());

    public aa(Context context) {
        this.f1029a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1029a == null || ebVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new x9(this, ebVar));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        if (this.f1029a == null) {
            return false;
        }
        try {
            pk.a("AdvertisingIdPlatform", "supported in");
            Object objInvoke = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.f1029a);
            if (!(objInvoke instanceof Boolean)) {
                return true;
            }
            pk.a("AdvertisingIdPlatform", "supported in invoke ");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th) {
            try {
                boolean zA = new ea().a(this.f1029a);
                pk.a("AdvertisingIdPlatform", "supported oaid in custom   Throwable " + th.getMessage() + PPSLabelView.Code + zA);
                return zA;
            } catch (Exception e) {
                pk.a("AdvertisingIdPlatform", "supported e1 " + e.getMessage());
                th.printStackTrace();
                return false;
            }
        }
    }
}
