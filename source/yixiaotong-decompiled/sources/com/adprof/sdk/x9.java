package com.adprof.sdk;

import android.os.Handler;
import com.hihonor.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa f1519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ eb f831a;

    public x9(aa aaVar, eb ebVar) {
        this.f1519a = aaVar;
        this.f831a = ebVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        z9 z9Var;
        Handler handler;
        Handler handler2;
        z9 z9Var2;
        aa aaVar = this.f1519a;
        eb ebVar = this.f831a;
        aaVar.getClass();
        try {
            try {
                Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient");
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(aaVar.f1029a);
                if (advertisingIdInfo == null) {
                    mg mgVar = new mg("Advertising identifier info is null");
                    handler2 = aaVar.f16a;
                    z9Var2 = new z9(aaVar, ebVar, mgVar);
                } else if (!advertisingIdInfo.isLimit) {
                    aaVar.f16a.post(new y9(aaVar, ebVar, advertisingIdInfo.id));
                    return;
                } else {
                    mg mgVar2 = new mg("User has disabled advertising identifier");
                    handler2 = aaVar.f16a;
                    z9Var2 = new z9(aaVar, ebVar, mgVar2);
                }
                handler2.post(z9Var2);
            } catch (Throwable unused) {
                c3 c3VarA = e3.a(aaVar.f1029a);
                if (c3VarA == null) {
                    mg mgVar3 = new mg("Advertising identifier info is null");
                    handler = aaVar.f16a;
                    z9Var = new z9(aaVar, ebVar, mgVar3);
                } else if (!c3VarA.f168a) {
                    aaVar.f16a.post(new y9(aaVar, ebVar, c3VarA.f1099a));
                    return;
                } else {
                    mg mgVar4 = new mg("User has disabled advertising identifier");
                    Handler handler3 = aaVar.f16a;
                    z9Var = new z9(aaVar, ebVar, mgVar4);
                    handler = handler3;
                }
                handler.post(z9Var);
            }
        } catch (Throwable th) {
            aaVar.f16a.post(new z9(aaVar, ebVar, new mg(th.getMessage())));
        }
    }
}
