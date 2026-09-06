package com.meishu.sdk.meishu_ad;

import android.view.View;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.k1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import java.io.IOException;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j0 implements com.meishu.sdk.core.utils.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5029a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c c;
    public final /* synthetic */ MeishuSplashRootView d;
    public final /* synthetic */ View e;
    public final /* synthetic */ v f;

    public j0(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, View view) {
        this.f = vVar;
        this.f5029a = aVar;
        this.b = dVar;
        this.c = cVar;
        this.d = meishuSplashRootView;
        this.e = view;
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onFailure(IOException iOException) {
        v vVar = this.f;
        com.meishu.sdk.meishu_ad.splash.a aVar = this.f5029a;
        Integer num = ErrorCodeUtil.RES_LOAD_ERROR;
        vVar.a(aVar, "图片资源加载错误", num);
        o1.a(this.f.d, num.intValue(), com.meishu.sdk.activity.a.a("图片资源加载错误 cid：").append(this.b.getCid()).toString());
    }

    @Override // com.meishu.sdk.core.utils.x
    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
        try {
            if (!httpResponse.isSuccessful()) {
                v vVar = this.f;
                com.meishu.sdk.meishu_ad.splash.a aVar = this.f5029a;
                Integer num = ErrorCodeUtil.RES_LOAD_ERROR;
                vVar.a(aVar, "图片资源加载错误", num);
                o1.a(this.f.d, num.intValue(), "图片资源加载错误 cid：" + this.b.getCid());
                return;
            }
            byte[] responseBody = httpResponse.getResponseBody();
            if (responseBody == null || responseBody.length <= 0) {
                v vVar2 = this.f;
                com.meishu.sdk.meishu_ad.splash.a aVar2 = this.f5029a;
                Integer num2 = ErrorCodeUtil.RES_LOAD_ERROR;
                vVar2.a(aVar2, "图片资源加载错误", num2);
                o1.a(this.f.d, num2.intValue(), "图片资源加载错误 cid：" + this.b.getCid());
                return;
            }
            if (responseBody.length >= com.meishu.sdk.core.utils.i0.a()) {
                v vVar3 = this.f;
                com.meishu.sdk.meishu_ad.splash.a aVar3 = this.f5029a;
                Integer num3 = ErrorCodeUtil.RES_LOAD_ERROR;
                vVar3.a(aVar3, "图片资源加载错误", num3);
                o1.c(this.f.d, num3.intValue(), "图片资源加载错误 cid:" + this.b.getCid());
                return;
            }
            if (com.meishu.sdk.core.utils.e0.a(responseBody)) {
                o1.a(this.f.d, 200, "splash gif load success");
                k1.a(this.b, 1, false);
                this.f.a(this.c, this.d, this.f5029a, this.e, true);
                v.a(this.f, responseBody, this.d, true, (BaseAdSlot) this.b, this.c, this.f5029a, (NormalMediaView) null);
            } else {
                o1.a(this.f.d, 200, "splash image load success");
                k1.a(this.b, 1, false);
                this.f.a(this.c, this.d, this.f5029a, this.e, true);
                v.a(this.f, responseBody, this.d, false, (BaseAdSlot) this.b, this.c, this.f5029a, (NormalMediaView) null);
            }
            v.a(this.b);
            v vVar4 = this.f;
            com.meishu.sdk.meishu_ad.splash.c cVar = this.c;
            com.meishu.sdk.meishu_ad.splash.a aVar4 = this.f5029a;
            vVar4.h = true;
            if (vVar4.f != 1 || vVar4.g) {
                vVar4.a(cVar, aVar4);
            }
        } catch (Throwable th) {
            v vVar5 = this.f;
            com.meishu.sdk.meishu_ad.splash.a aVar5 = this.f5029a;
            Integer num4 = ErrorCodeUtil.RES_LOAD_ERROR;
            vVar5.a(aVar5, "图片资源加载错误", num4);
            o1.a(this.f.d, num4.intValue(), com.meishu.sdk.activity.a.a("图片资源加载错误 cid：").append(this.b.getCid()).toString());
            th.printStackTrace();
        }
    }
}
