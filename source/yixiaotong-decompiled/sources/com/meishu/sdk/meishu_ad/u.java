package com.meishu.sdk.meishu_ad;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.google.gson.Gson;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.utils.k1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u implements com.meishu.sdk.core.utils.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.c f5094a;
    public final /* synthetic */ MeishuSplashRootView b;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.a c;
    public final /* synthetic */ View d;
    public final /* synthetic */ ImageView e;
    public final /* synthetic */ int f;
    public final /* synthetic */ com.meishu.sdk.meishu_ad.splash.d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ v j;

    /* JADX INFO: compiled from: AdNative.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f5095a;

        public a(byte[] bArr) {
            this.f5095a = bArr;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            u.this.j.r.setBytes(this.f5095a);
            u uVar = u.this;
            uVar.f5094a.setWidth(Integer.valueOf(uVar.j.r.getGifWidth()));
            u uVar2 = u.this;
            uVar2.f5094a.setHeight(Integer.valueOf(uVar2.j.r.getGifHeight()));
            u.this.j.r.startAnimation();
        }
    }

    public u(v vVar, com.meishu.sdk.meishu_ad.splash.c cVar, MeishuSplashRootView meishuSplashRootView, com.meishu.sdk.meishu_ad.splash.a aVar, View view, ImageView imageView, int i, com.meishu.sdk.meishu_ad.splash.d dVar, int i2, int i3) {
        this.j = vVar;
        this.f5094a = cVar;
        this.b = meishuSplashRootView;
        this.c = aVar;
        this.d = view;
        this.e = imageView;
        this.f = i;
        this.g = dVar;
        this.h = i2;
        this.i = i3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.meishu.sdk.core.utils.w
    public void a(HttpResponse<byte[]> httpResponse, Bitmap bitmap, Bitmap bitmap2) throws IOException {
        this.j.p = System.currentTimeMillis();
        this.j.a(this.f5094a, this.b, this.c, this.d, true);
        try {
            if (!httpResponse.isSuccessful()) {
                v vVar = this.j;
                com.meishu.sdk.meishu_ad.splash.c cVar = this.f5094a;
                GifImageView gifImageView = vVar.r;
                ImageView imageView = this.e;
                int i = this.f;
                com.meishu.sdk.meishu_ad.splash.d dVar = this.g;
                com.meishu.sdk.meishu_ad.splash.a aVar = this.c;
                ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                vVar.a(cVar, gifImageView, imageView, i, dVar, aVar, this.h, this.i);
                return;
            }
            try {
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    v vVar2 = this.j;
                    com.meishu.sdk.meishu_ad.splash.c cVar2 = this.f5094a;
                    GifImageView gifImageView2 = vVar2.r;
                    ImageView imageView2 = this.e;
                    int i2 = this.f;
                    com.meishu.sdk.meishu_ad.splash.d dVar2 = this.g;
                    com.meishu.sdk.meishu_ad.splash.a aVar2 = this.c;
                    ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                    vVar2.a(cVar2, gifImageView2, imageView2, i2, dVar2, aVar2, this.h, this.i);
                    return;
                }
                if (responseBody.length >= com.meishu.sdk.core.utils.i0.a()) {
                    v vVar3 = this.j;
                    com.meishu.sdk.meishu_ad.splash.c cVar3 = this.f5094a;
                    GifImageView gifImageView3 = vVar3.r;
                    ImageView imageView3 = this.e;
                    int i3 = this.f;
                    com.meishu.sdk.meishu_ad.splash.d dVar3 = this.g;
                    com.meishu.sdk.meishu_ad.splash.a aVar3 = this.c;
                    ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                    vVar3.a(cVar3, gifImageView3, imageView3, i3, dVar3, aVar3, this.h, this.i);
                    return;
                }
                this.j.getClass();
                if (com.meishu.sdk.core.utils.e0.a(responseBody)) {
                    v vVar4 = this.j;
                    GifImageView gifImageView4 = vVar4.r;
                    if (gifImageView4 == null) {
                        com.meishu.sdk.meishu_ad.splash.c cVar4 = this.f5094a;
                        ImageView imageView4 = this.e;
                        int i4 = this.f;
                        com.meishu.sdk.meishu_ad.splash.d dVar4 = this.g;
                        com.meishu.sdk.meishu_ad.splash.a aVar4 = this.c;
                        ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                        vVar4.a(cVar4, gifImageView4, imageView4, i4, dVar4, aVar4, this.h, this.i);
                        return;
                    }
                    gifImageView4.post(new a(responseBody));
                    try {
                        Gson gson = new Gson();
                        HashMap map = new HashMap();
                        map.put("stepNum", 3);
                        map.put("msg", "image succ, gif not null");
                        map.put("creativeType", Integer.valueOf(this.g.getAdPatternType()));
                        o1.a(this.f5094a.b.getErrorUrl(), gson.toJson(map));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.j.p = System.currentTimeMillis();
                    k1.a(this.g, 1, false);
                    v.a(this.j.A != 1, this.c, this.f5094a);
                    v vVar5 = this.j;
                    com.meishu.sdk.meishu_ad.splash.c cVar5 = this.f5094a;
                    com.meishu.sdk.meishu_ad.splash.a aVar5 = this.c;
                    vVar5.h = true;
                    if (vVar5.f != 1 || vVar5.g) {
                        vVar5.a(cVar5, aVar5);
                    }
                    try {
                        o1.c(this.f5094a.b.getEventUrl(), 200, "加载成功");
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                if (bitmap == null) {
                    v vVar6 = this.j;
                    com.meishu.sdk.meishu_ad.splash.c cVar6 = this.f5094a;
                    GifImageView gifImageView5 = vVar6.r;
                    ImageView imageView5 = this.e;
                    int i5 = this.f;
                    com.meishu.sdk.meishu_ad.splash.d dVar5 = this.g;
                    com.meishu.sdk.meishu_ad.splash.a aVar6 = this.c;
                    ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                    vVar6.a(cVar6, gifImageView5, imageView5, i5, dVar5, aVar6, this.h, this.i);
                    return;
                }
                try {
                    Gson gson2 = new Gson();
                    HashMap map2 = new HashMap();
                    map2.put("stepNum", 3);
                    map2.put("msg", "image succ,bitmap not null");
                    map2.put("creativeType", Integer.valueOf(this.g.getAdPatternType()));
                    o1.a(this.f5094a.b.getErrorUrl(), gson2.toJson(map2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                k1.a(this.g, 1, false);
                v vVar7 = this.j;
                vVar7.a(this.f, bitmap, vVar7.r, this.e, bitmap2);
                this.f5094a.setWidth(Integer.valueOf(bitmap.getWidth()));
                this.f5094a.setHeight(Integer.valueOf(bitmap.getHeight()));
                this.j.p = System.currentTimeMillis();
                this.j.h = true;
                try {
                    o1.c(this.f5094a.b.getEventUrl(), 200, "加载成功");
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                v.a(this.g);
                v.a(this.j.A != 1, this.c, this.f5094a);
                v vVar8 = this.j;
                if (vVar8.f != 1 || vVar8.g) {
                    com.meishu.sdk.meishu_ad.splash.d dVar6 = this.g;
                    dVar6.setMonitorUrl(com.meishu.sdk.core.utils.h0.b(dVar6.getMonitorUrl(), this.j.a()));
                    this.j.a(this.f5094a, this.c);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
                v vVar9 = this.j;
                com.meishu.sdk.meishu_ad.splash.c cVar7 = this.f5094a;
                GifImageView gifImageView6 = vVar9.r;
                ImageView imageView6 = this.e;
                int i6 = this.f;
                com.meishu.sdk.meishu_ad.splash.d dVar7 = this.g;
                com.meishu.sdk.meishu_ad.splash.a aVar7 = this.c;
                ErrorCodeUtil.RES_LOAD_ERROR.intValue();
                vVar9.a(cVar7, gifImageView6, imageView6, i6, dVar7, aVar7, this.h, this.i);
            }
        } catch (Throwable th4) {
            v vVar10 = this.j;
            com.meishu.sdk.meishu_ad.splash.c cVar8 = this.f5094a;
            GifImageView gifImageView7 = vVar10.r;
            ImageView imageView7 = this.e;
            int i7 = this.f;
            com.meishu.sdk.meishu_ad.splash.d dVar8 = this.g;
            com.meishu.sdk.meishu_ad.splash.a aVar8 = this.c;
            ErrorCodeUtil.RES_LOAD_ERROR.intValue();
            vVar10.a(cVar8, gifImageView7, imageView7, i7, dVar8, aVar8, this.h, this.i);
            th4.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.utils.w
    public void onFailure(IOException iOException) {
        this.j.p = System.currentTimeMillis();
        this.j.a(this.f5094a, this.b, this.c, this.d, true);
        v vVar = this.j;
        com.meishu.sdk.meishu_ad.splash.c cVar = this.f5094a;
        GifImageView gifImageView = vVar.r;
        ImageView imageView = this.e;
        int i = this.f;
        com.meishu.sdk.meishu_ad.splash.d dVar = this.g;
        com.meishu.sdk.meishu_ad.splash.a aVar = this.c;
        ErrorCodeUtil.RES_LOAD_ERROR.intValue();
        vVar.a(cVar, gifImageView, imageView, i, dVar, aVar, this.h, this.i);
    }
}
