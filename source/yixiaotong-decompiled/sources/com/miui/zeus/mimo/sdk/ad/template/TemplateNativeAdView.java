package com.miui.zeus.mimo.sdk.ad.template;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.base.BaseAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.h3;
import ijiami_1011.NCall;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TemplateNativeAdView extends BaseAdView implements h3 {
    private final String TAG;
    private boolean isMsaRenderFail;
    private TemplateUIController.a mAdListener;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f5366a;

        public a(Throwable th) {
            this.f5366a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(AppTypeIdUtil.NewDevice4GDrinkOTA_1), this});
        }
    }

    public TemplateNativeAdView(Context context) {
        super(context);
        this.TAG = s.d(new byte[]{100, 87, 89, SignedBytes.MAX_POWER_OF_TWO, 8, 86, Ascii.NAK, 1, 40, 3, 69, 12, 70, 87, 102, 85, 9, 88, Ascii.NAK, 1, 39, 6, 103, 12, 85, 69}, "0240d7");
        this.isMsaRenderFail = false;
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public int getRequestMinHeight() {
        return NCall.II(new Object[]{94, this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public int getRequestMinWidth() {
        return NCall.II(new Object[]{95, this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public View getRootAdView() {
        return (View) NCall.IL(new Object[]{96, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{97, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{98, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{99, this, th});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{100, this});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{101, this, activity, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.h3
    public void setTemplateUIControllerAdListener(TemplateUIController.a aVar) {
        NCall.IV(new Object[]{102, this, aVar});
    }
}
