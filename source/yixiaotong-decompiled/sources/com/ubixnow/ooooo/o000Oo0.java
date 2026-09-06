package com.ubixnow.ooooo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.exoplayer2.C;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.common.ui.UMNFrameLayout;
import com.ubixnow.core.common.ui.UMNRelativeLayout;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o000Oo0 extends o00O0O00 {
    public static final String OooO0oO = "---" + o000Oo0.class.getName();
    public o00OOOOo OooO;
    public long OooO0oo;
    private o000O00 OooOO0;
    private UMNFrameLayout OooOO0O;
    public boolean OooOO0o;
    private oo00o OooOOO0;

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = o000Oo0.OooO0oO;
            ooooO000.OooO0OO(str, "delay onAdDismiss" + (o000Oo0.this.OooOO0 == null));
            if (o000Oo0.this.OooOO0 != null) {
                ooooO000.OooO0OO(str, "onAdDismiss 1");
                o000Oo0.this.OooOO0.onDismiss();
            }
        }
    }

    public class OooO0O0 implements o000O0O0 {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.o000O0O0
        public void onAdClick(o000O00O o000o00o) {
            ooooO000.OooO0OO(o000Oo0.OooO0oO, IAdInterListener.AdCommandType.AD_CLICK);
            if (o000Oo0.this.OooOO0 != null) {
                o000Oo0.this.OooOO0.onAdClick();
            }
        }

        @Override // com.ubixnow.ooooo.o000O0O0
        public void onAdDismiss(o000O00O o000o00o) {
            String str = o000Oo0.OooO0oO;
            ooooO000.OooO0OO(str, "onAdDismiss");
            if (o000Oo0.this.OooOO0 != null) {
                ooooO000.OooO0OO(str, "onAdDismiss 2");
                o000Oo0.this.OooOO0.onDismiss();
            }
        }

        @Override // com.ubixnow.ooooo.o000O0O0
        public void onAdShow(o000O00O o000o00o) {
            ooooO000.OooO0OO(o000Oo0.OooO0oO, "onAdShow");
            if (o000Oo0.this.OooOO0 != null) {
                o000Oo0.this.OooOO0.onAdShow();
            }
        }

        @Override // com.ubixnow.ooooo.o000O0O0
        public void onShowError(ErrorInfo errorInfo) {
            String str = o000Oo0.OooO0oO;
            ooooO000.OooO0OO(str, "onShowError");
            if (o000Oo0.this.OooOO0 != null) {
                ooooO000.OooO0OO(str, "onAdDismiss 3");
                o000Oo0.this.OooOO0.onDismiss();
            }
        }
    }

    public class OooO0OO implements UMNFrameLayout.OooO00o {
        public OooO0OO() {
        }

        @Override // com.ubixnow.core.common.ui.UMNFrameLayout.OooO00o
        public void visibleChange(boolean z) {
            String str = o000Oo0.OooO0oO;
            ooooO000.OooO0OO(str, "visibleChange " + z);
            if (z && o000Oo0.this.OooO0o()) {
                o000Oo0 o000oo0 = o000Oo0.this;
                o000oo0.OooO00o(o000oo0.OooOO0O);
            } else if (o000Oo0.this.OooOO0 != null) {
                ooooO000.OooO0OO(str, "onAdDismiss 5");
                o000Oo0.this.OooOO0.onDismiss();
            }
        }
    }

    public o000Oo0(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
    }

    public void OooO() {
        this.OooOO0 = null;
    }

    public void OooO00o(ViewGroup viewGroup) {
        ooooO000.OooO0OO(OooO0oO, "start showDs");
        ((o000O00O) this.OooOOO0).OooO0O0 = 2;
        BaseUtils.postDelayed(new OooO00o(), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        ((UMNCustomSplashAdapter) this.OooOOO0.getAbsBaseAdapter()).internalShow(viewGroup, new OooO0O0());
    }

    public void OooO00o(o000O00 o000o00) {
        View viewFindViewWithTag;
        this.OooOO0 = o000o00;
        try {
            o00OOOOo o00ooooo = this.OooO;
            if (o00ooooo != null && o00ooooo.OooO0O0() != null) {
                this.OooOO0O = (UMNFrameLayout) this.OooO.OooO0O0();
                UMNRelativeLayout uMNRelativeLayout = (UMNRelativeLayout) this.OooO.OooO0OO();
                if (uMNRelativeLayout != null && (viewFindViewWithTag = uMNRelativeLayout.findViewWithTag("dislike_button")) != null) {
                    uMNRelativeLayout.removeView(viewFindViewWithTag);
                }
                if (this.OooOO0O.isShown()) {
                    ooooO000.OooO0OO(OooO0oO, "当前在前台，直接展示");
                    OooO00o(this.OooOO0O);
                    return;
                } else {
                    ooooO000.OooO0OO(OooO0oO, "当前不在前台");
                    this.OooOO0O.setVisibleChangeListener(new OooO0OO());
                    return;
                }
            }
            if (this.OooOO0 != null) {
                ooooO000.OooO0OO(OooO0oO, "onAdDismiss 4");
                this.OooOO0.onDismiss();
            }
        } catch (Exception unused) {
            if (this.OooOO0 != null) {
                ooooO000.OooO0OO(OooO0oO, "onAdDismiss 6");
                this.OooOO0.onDismiss();
            }
        }
    }

    public void OooO00o(oo00o oo00oVar) {
        this.OooOOO0 = oo00oVar;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public void OooO0OO() {
        super.OooO0OO();
        this.OooOOO0 = null;
        OooO();
        ooooO000.OooO0OO(OooO0oO, "onDestroy");
    }

    public boolean OooO0o() {
        String str = OooO0oO;
        ooooO000.OooO0OO(str, "checkDsValid");
        oo00o oo00oVar = this.OooOOO0;
        if (oo00oVar != null) {
            if (!((UMNCustomSplashAdapter) oo00oVar.getAbsBaseAdapter()).isValid()) {
                ooooO000.OooO0OO(str, "ad is not valid");
                return false;
            }
            if (System.currentTimeMillis() - this.OooO0oo < this.OooO0Oo.OooO0OO.OooOOOO.OooOO0.OooO0oO) {
                ooooO000.OooO0OO(str, "firstAdShowTime:" + this.OooO0oo + "  maxTime:" + this.OooO0Oo.OooO0OO.OooOOOO.OooOO0.OooO0oO);
                return true;
            }
        }
        if (ooooO000.OooO00o) {
            ooooO000.OooO0OO(str, "dsInfo is not null");
        }
        return false;
    }

    public o000O00O OooO0oO() {
        return (o000O00O) this.OooOOO0;
    }

    public void OooO0oo() {
        this.OooO0oo = System.currentTimeMillis();
    }
}
