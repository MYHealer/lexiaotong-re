package com.ubixnow.ooooo;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMediaListener;
import com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0000 implements UMNNativeEventListener, UMNNativeMediaListener {
    public static final int OooO00o = 0;
    public static final int OooO0O0 = 1;
    public static final int OooO0OO = 2;
    public static final int OooO0Oo = 3;
    public OooO00o OooO0o;
    public o00000 OooO0o0;
    public final oo00o<UMNCustomRewardAdapter> OooO0oO;
    private final HashSet<Integer> OooO0oo = new HashSet<>();

    public interface OooO00o {
        Bitmap getAppIconBitmap();

        View getClickView();

        long getCountDownSeconds();

        ViewGroup getPopWindowRoot();

        void onRewardVerify(oo00o oo00oVar);
    }

    public o0000(oo00o<UMNCustomRewardAdapter> oo00oVar) {
        this.OooO0oO = oo00oVar;
    }

    private static o0000 OooO00o(oo00o<UMNCustomRewardAdapter> oo00oVar) {
        switch (oo00oVar.getBaseAdConfig().OooOOO0.OooOOo) {
            case 21:
            case 22:
                return new o0000O00(oo00oVar);
            case 23:
                return new o0000O0O(oo00oVar);
            case 24:
                return new o0000oo(oo00oVar);
            default:
                return new o0000O0(oo00oVar);
        }
    }

    public static o0000 OooO0O0(oo00o<UMNCustomRewardAdapter> oo00oVar) {
        try {
            o00O000 baseAdConfig = oo00oVar.getBaseAdConfig();
            if (!o0O0OOOo.OooO00o(baseAdConfig.OooO00o, baseAdConfig.OooOOO0)) {
                ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j2"));
                return new o0000O0(oo00oVar);
            }
            ooooO000.OooO0O0(ooooO000.OooO0OO, ooooO000.OooO0OO("j1"));
            oo00oVar.extraInfo.put(o0OO000o.o00O00Oo, "1");
            return OooO00o(oo00oVar);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public synchronized void OooO00o() {
        OooO0O0(2);
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onAdClick(this.OooO0oO);
        }
    }

    public void OooO00o(String str, String str2) {
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg, str, str2));
        }
    }

    public boolean OooO00o(int i) {
        return this.OooO0oo.contains(Integer.valueOf(i));
    }

    public synchronized void OooO0O0() {
        if (!OooO00o(3)) {
            OooO00o oooO00o = this.OooO0o;
            if (oooO00o != null) {
                oooO00o.onRewardVerify(this.OooO0oO);
            }
            OooO0O0(3);
            o00000 o00000Var = this.OooO0o0;
            if (o00000Var != null) {
                o00000Var.onRewardVerify(this.OooO0oO);
            }
        }
    }

    public void OooO0O0(int i) {
        this.OooO0oo.add(Integer.valueOf(i));
    }

    public void OooO0OO() {
    }

    public View OooO0Oo() {
        return null;
    }

    public void OooO0o() {
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onVideoPlayStart(this.OooO0oO);
        }
    }

    public void OooO0o0() {
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onVideoPlayComplete(this.OooO0oO);
        }
    }

    public void OooO0oO() {
    }

    public void OooO0oo() {
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
    public void onAdClicked() {
        OooO00o();
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
    public void onAdClose() {
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onAdDismiss(this.OooO0oO);
        }
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeEventListener
    public void onAdExposure() {
        o00000 o00000Var = this.OooO0o0;
        if (o00000Var != null) {
            o00000Var.onAdShow(this.OooO0oO);
        }
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
    public void onVideoEnd() {
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
    public void onVideoError() {
        OooO00o(oOO00O0.ubix_show_error, oOO00O0.ubix_videoshow_error_msg);
    }

    @Override // com.ubixnow.adtype.nativead.api.UMNNativeMediaListener
    public void onVideoStart() {
    }
}
