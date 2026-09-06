package com.meishu.sdk.meishu_ad;

import android.content.Context;
import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.meishu.sdk.core.utils.k1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import java.io.File;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements com.meishu.sdk.core.bquery.h<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a f5010a;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c c;
    public final /* synthetic */ MeishuSplashRootView d;
    public final /* synthetic */ View e;
    public final /* synthetic */ v f;

    public e(v vVar, com.meishu.sdk.meishu_ad.splash.a aVar, com.meishu.sdk.meishu_ad.splash.d dVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, View view) {
        this.f = vVar;
        this.f5010a = aVar;
        this.b = dVar;
        this.c = cVar;
        this.d = meishuSplashRootView;
        this.e = view;
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void a(String str, File file, boolean z) {
        File file2 = file;
        if (file2.length() >= com.meishu.sdk.core.utils.i0.a()) {
            this.f.a(this.f5010a, "splash video load error", Integer.valueOf(IBidding.ECPM_STATUS_NULL_AD_IMPL));
            o1.a(this.f.d, IBidding.ECPM_STATUS_NULL_AD_IMPL, com.meishu.sdk.activity.a.a("splash video load error cid：").append(this.b.getCid()).toString());
            return;
        }
        o1.a(this.f.d, 200, "splash video load success");
        k1.a(this.b, 1, z);
        SplashSkipView splashSkipViewA = this.f.a(this.c, this.d, this.f5010a, this.e, true);
        NormalMediaView normalMediaView = new NormalMediaView(this.f.f5096a);
        normalMediaView.setConfigWidth(this.b.f5047a);
        normalMediaView.setConfigHeight(this.b.b);
        normalMediaView.setPlayOnce(true);
        normalMediaView.g();
        normalMediaView.setIsEyes(this.b.H);
        normalMediaView.setUseTransform(false);
        normalMediaView.setDisplayMode(2);
        normalMediaView.setFromLogoVisibility(8);
        normalMediaView.setFromLogo(null);
        normalMediaView.setAdListener(new c(this));
        Context context = this.f.f5096a;
        normalMediaView.setNativeAdMediaListener(new com.meishu.sdk.platform.ms.recycler.b(this.b, new d(this, normalMediaView, splashSkipViewA)));
        normalMediaView.setVideoCover(this.b.getVideo_cover());
        normalMediaView.setVideoEndCover(this.b.h);
        if (file2.getAbsolutePath().endsWith("m3u8") || str.contains("m3u8")) {
            normalMediaView.setVideoPath(str);
        } else {
            normalMediaView.setVideoPath(file2.getAbsolutePath());
        }
        this.f.h = true;
        v.a(this.b);
        v vVar = this.f;
        if (vVar.f != 1 || vVar.g) {
            normalMediaView.start();
            this.f.a(this.c, this.f5010a);
        }
    }

    @Override // com.meishu.sdk.core.bquery.h
    public void onFail(int i, String str) {
        this.f.a(this.f5010a, str, Integer.valueOf(IBidding.ECPM_STATUS_NULL_AD_IMPL));
        o1.a(this.f.d, IBidding.ECPM_STATUS_NULL_AD_IMPL, str + " cid：" + this.b.getCid());
    }
}
