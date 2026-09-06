package com.meishu.sdk.meishu_ad;

import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h0 extends com.meishu.sdk.core.safe.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5017a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
    public final /* synthetic */ v c;

    /* JADX INFO: compiled from: AdNative.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                if (((com.meishu.sdk.platform.ms.splash.g) h0.this.f5017a).e) {
                    return;
                }
                h0 h0Var = h0.this;
                if (h0Var.c.s) {
                    return;
                }
                o1.b(h0Var.b.getEventUrl(), ErrorCodeUtil.RES_LOAD_ERROR.intValue(), "load res error timeout no exposure,cid=" + h0.this.b.getCid());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public h0(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar) {
        this.c = vVar;
        this.f5017a = aVar;
        this.b = dVar;
    }

    @Override // com.meishu.sdk.core.safe.n
    public void a() {
        cancel();
        SdkHandler.getInstance().runOnUiThread(new a());
    }
}
