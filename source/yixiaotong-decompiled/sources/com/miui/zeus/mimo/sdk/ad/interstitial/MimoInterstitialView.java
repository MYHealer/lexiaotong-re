package com.miui.zeus.mimo.sdk.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.t0;
import com.miui.zeus.mimo.sdk.u0;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.w0;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoInterstitialView extends RelativeLayout implements IBindDataView {
    private IBindDataView mView;

    public MimoInterstitialView(Context context) {
        super(context);
    }

    public MimoInterstitialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MimoInterstitialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private IBindDataView createInterstitialView(MimoAdInfo mimoAdInfo) {
        IBindDataView iBindDataView;
        if (mimoAdInfo.p0.trim().contains(s.d(new byte[]{72, 82, 10, 91, 88, 12, 19, Ascii.DC4}, "07d45c"))) {
            try {
                iBindDataView = (IBindDataView) Class.forName(s.d(new byte[]{86, 12, 93, 79, 93, 94, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 70, 77, 93, 8, 93, 88, 79, Ascii.ETB, 2, 9, Ascii.US, 4, 81, 77, 89, 15, 68, 82, 19, Ascii.ETB, Ascii.DC2, 11, 69, 12, 84, 15, Ascii.RS, Ascii.ETB, 89, 82, Ascii.SYN, 74, 47, 12, 69, 0, 71, 10, 67, Ascii.NAK, 89, 67, 8, 5, 10, 58, 84, 11, 90, 14, 95, 19, SignedBytes.MAX_POWER_OF_TWO}, "5c0a07")).getConstructor(Context.class).newInstance(getContext());
            } catch (Exception e) {
                m.b(s.d(new byte[]{101, 88, 1, 69, 55, 68, 8, 8, Ascii.NAK}, "31d2b0"), s.d(new byte[]{85, 69, 85, 86, 77, 80, 40, 10, Ascii.DC2, 7, 67, Ascii.SYN, 66, 94, 68, 94, 88, 89, 55, 13, 3, Ascii.NAK, 17, 0, 68, 69, 95, 69, 3, Ascii.NAK}, "670795") + e.getMessage());
                iBindDataView = null;
            }
            if (iBindDataView != null) {
                return iBindDataView;
            }
        }
        if (mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{66, 5, 67, 85, 92, 92, 55, 1, Ascii.DC4, Ascii.SYN, 88, 6, 80, 10, 114}, "1f1092")) || mimoAdInfo.p0.trim().startsWith(s.d(new byte[]{Ascii.NAK, 7, Ascii.SYN, 85, 4, 89, 41, 11, Ascii.DC4, 11, 75, 10, 8, 16, 5, 92, 34}, "fdd0a7")) || mimoAdInfo.p0.trim().toLowerCase().contains(s.d(new byte[]{81, 12, 95, 9, 95, 5, 19, 15}, "3c0b2d"))) {
            return new t0(getContext(), null);
        }
        return (mimoAdInfo.p0.trim().contains(s.d(new byte[]{17, 83, Ascii.DC4, 82, 84, 90, 55, 1, Ascii.DC4, Ascii.SYN, 88, 6, 3, 92, 39, 0}, "b0f714")) || mimoAdInfo.p0.trim().contains(s.d(new byte[]{17, 91, SignedBytes.MAX_POWER_OF_TWO, 0, 7, 15, 41, 11, Ascii.DC4, 11, 75, 10, 12, 76, 83, 9, 35, 86}, "b82eba"))) ? new w0(getContext()) : new u0(getContext(), null);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        IBindDataView iBindDataView = this.mView;
        if (iBindDataView != null) {
            iBindDataView.destroy();
        }
    }

    @Override // android.view.View, com.miui.zeus.mimo.sdk.view.IBindDataView
    public View getRootView() {
        return this;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        IBindDataView iBindDataView = this.mView;
        if (iBindDataView != null) {
            iBindDataView.pause();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        IBindDataView iBindDataView = this.mView;
        if (iBindDataView != null) {
            iBindDataView.resume();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        IBindDataView iBindDataViewCreateInterstitialView = createInterstitialView(mimoAdInfo);
        this.mView = iBindDataViewCreateInterstitialView;
        iBindDataViewCreateInterstitialView.setAdInfo(activity, mimoAdInfo, w3Var);
        removeAllViews();
        addView(this.mView.getRootView(), new RelativeLayout.LayoutParams(-1, -1));
    }
}
