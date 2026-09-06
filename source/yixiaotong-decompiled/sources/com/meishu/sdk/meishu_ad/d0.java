package com.meishu.sdk.meishu_ad;

import android.view.View;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.o1;
import java.io.IOException;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d0 implements com.meishu.sdk.core.utils.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5008a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ View f;
    public final /* synthetic */ v g;

    public d0(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.a aVar, int i, int i2, View view) {
        this.g = vVar;
        this.f5008a = cVar;
        this.b = dVar;
        this.c = aVar;
        this.d = i;
        this.e = i2;
        this.f = view;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        try {
            if (httpResponse.isSuccessful()) {
                o1.c(this.f5008a.b.getEventUrl(), 200, "video cover 加载成功");
                this.g.t = httpResponse.getResponseBody();
                this.g.v = 1;
                if (this.g.u == 2) {
                    v.a(this.g, this.f5008a, this.b, this.d, this.e, this.c, this.f);
                }
            } else {
                this.g.v = 2;
                o1.c(this.f5008a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, "video cover load error cid:" + this.b.getCid());
                if (this.g.u == 2 && this.g.w == 2) {
                    this.g.a(this.c, "video load error,def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
                } else if (this.g.u == 2) {
                    v.a(this.g, this.f5008a, this.b, this.d, this.e, this.c, this.f);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        this.g.v = 2;
        o1.c(this.f5008a.b.getEventUrl(), ErrorCodeUtil.RENDER_AD_RESULT, com.meishu.sdk.activity.a.a("video cover load error cid:").append(this.b.getCid()).toString());
        if (this.g.u == 2 && this.g.w == 2) {
            this.g.a(this.c, "video load error,def isnull", ErrorCodeUtil.RES_LOAD_ERROR);
        } else if (this.g.u == 2) {
            v.a(this.g, this.f5008a, this.b, this.d, this.e, this.c, this.f);
        }
    }
}
