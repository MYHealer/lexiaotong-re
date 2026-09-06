package com.yfanads.android;

import android.content.Context;
import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.db.imp.g;
import com.yfanads.android.model.SdkConfModel;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: AdsInnerMgr.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements OnResultListener<SdkConfModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f9562a;
    public final /* synthetic */ SdkConfModel b;
    public final /* synthetic */ b c;

    public a(b bVar, Context context, SdkConfModel sdkConfModel) {
        this.c = bVar;
        this.f9562a = context;
        this.b = sdkConfModel;
    }

    @Override // com.yfanads.android.callback.OnResultListener
    public final void onSuccess(SdkConfModel sdkConfModel) {
        SdkConfModel sdkConfModel2 = sdkConfModel;
        YFLog.high("updateNextConfig success");
        if (sdkConfModel2 == null) {
            b bVar = this.c;
            Context context = this.f9562a;
            SdkConfModel sdkConfModel3 = this.b;
            bVar.getClass();
            b.a(context, sdkConfModel3);
            return;
        }
        InitUtils.setConfModel(sdkConfModel2);
        g.a("sdkConf", sdkConfModel2);
        b bVar2 = this.c;
        Context context2 = this.f9562a;
        bVar2.getClass();
        b.a(context2, sdkConfModel2);
    }

    @Override // com.yfanads.android.callback.OnResultListener
    public final void onFailed(int i, String str) {
        b bVar = this.c;
        Context context = this.f9562a;
        SdkConfModel sdkConfModel = this.b;
        bVar.getClass();
        b.a(context, sdkConfModel);
        YFLog.error(" loader fail " + i);
    }
}
