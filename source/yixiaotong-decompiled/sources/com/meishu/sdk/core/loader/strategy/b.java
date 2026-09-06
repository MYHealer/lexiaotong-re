package com.meishu.sdk.core.loader.strategy;

import android.text.TextUtils;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.stub.StubApp;

/* JADX INFO: compiled from: PriceFirstStrategy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f4816a;

    public b(e eVar) {
        this.f4816a = eVar;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        SdkAdInfo sdkAdInfo;
        e eVar = this.f4816a;
        eVar.getClass();
        try {
            eVar.x = true;
            eVar.f();
            for (int i = 0; i < eVar.g.size(); i++) {
                com.meishu.sdk.core.loader.loadbean.a aVar = eVar.g.get(i);
                if (aVar.c != 1 && (sdkAdInfo = aVar.f4815a) != null) {
                    String err = sdkAdInfo.getErr();
                    if (err.contains("__MS_ERRNO__")) {
                        String strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", String.valueOf(10));
                        aVar.f4815a.setErr(strReplace);
                        if (TextUtils.isEmpty(strReplace)) {
                            continue;
                        } else {
                            z.a(StubApp.getOrigApplicationContext(eVar.f4818a.getContext().getApplicationContext()), h0.a(strReplace), new i());
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
