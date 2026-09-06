package com.meishu.sdk.meishu_ad;

import android.text.TextUtils;
import android.view.View;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.o1;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z extends com.meishu.sdk.core.safe.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d f5155a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ View f;
    public final /* synthetic */ v g;

    /* JADX INFO: compiled from: AdNative.java */
    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                if (z.this.g.u == 1) {
                    return;
                }
                if (TextUtils.isEmpty(z.this.f5155a.getVideo_cover()) && TextUtils.isEmpty(z.this.f5155a.getDefImage())) {
                    z zVar = z.this;
                    zVar.g.a(zVar.b, "video load error", ErrorCodeUtil.RES_LOAD_ERROR);
                    try {
                        o1.c(z.this.c.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video 加载超时 cid:" + z.this.f5155a.getCid());
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                if (z.this.g.v != 1 && z.this.g.w != 1) {
                    z zVar2 = z.this;
                    zVar2.g.a(zVar2.b, "video load error", ErrorCodeUtil.RES_LOAD_ERROR);
                    try {
                        o1.c(z.this.c.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video 加载超时 cid:" + z.this.f5155a.getCid());
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
                try {
                    o1.c(z.this.c.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video 加载超时 cid:" + z.this.f5155a.getCid());
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                if (z.this.g.u != 1) {
                    z zVar3 = z.this;
                    v.a(zVar3.g, zVar3.c, zVar3.f5155a, zVar3.d, zVar3.e, zVar3.b, zVar3.f);
                    return;
                }
                return;
                th.printStackTrace();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    public z(v vVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.c cVar, int i, int i2, View view) {
        this.g = vVar;
        this.f5155a = dVar;
        this.b = aVar;
        this.c = cVar;
        this.d = i;
        this.e = i2;
        this.f = view;
    }

    @Override // com.meishu.sdk.core.safe.n
    public void a() {
        this.g.k = true;
        cancel();
        SdkHandler.getInstance().runOnUiThread(new a());
    }
}
