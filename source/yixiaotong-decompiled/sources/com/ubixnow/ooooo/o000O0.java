package com.ubixnow.ooooo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.ubixnow.adtype.splash.custom.UMNCustomSplashAdapter;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000O0 extends o000Oo0 {
    private o000OO0O OooOOO;
    private UMNCustomSplashAdapter OooOOOO;
    private o000O0O0 OooOOOo;
    private boolean OooOOo;
    private Handler OooOOo0;
    private final Runnable OooOOoo;

    public class OooO00o implements Runnable {
        public OooO00o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0("------adShowTask run");
            if (o000O0.this.OooOOOo == null || o000O0.this.OooOOo) {
                return;
            }
            ErrorInfo errorInfo = new ErrorInfo(oOO00O0.ubix_splash_show_error, oOO00O0.ubix_splash_show_error_msg);
            errorInfo.setInfo((Object) o000O0.this.OooO0Oo.OooOO0);
            o000O0.this.OooOOOo.onShowError(errorInfo);
        }
    }

    public o000O0(Context context, BaseDevConfig baseDevConfig) {
        super(context, baseDevConfig);
        this.OooOOo = false;
        this.OooOOoo = new OooO00o();
    }

    public o00O0 OooO00o(UMNEcpmInfo uMNEcpmInfo) {
        o00O0 o00o0OooO00o = OooO00o("1");
        o00o0OooO00o.OooOOo = uMNEcpmInfo;
        OooO0O0("1");
        return o00o0OooO00o;
    }

    @Override // com.ubixnow.ooooo.o00O0O00
    public o0O00o0 OooO00o(Context context) {
        if (this.OooOOO == null) {
            this.OooOOO = new o000OO0O(context);
        }
        return this.OooOOO;
    }

    public oo00o OooO00o(ErrorInfo errorInfo) {
        o000OO0O o000oo0o = this.OooOOO;
        if (o000oo0o != null) {
            return o000oo0o.OooO00o(this.OooO0Oo, errorInfo, true);
        }
        return null;
    }

    public void OooO00o(long j) {
        try {
            if (this.OooOOo0 == null) {
                ooooO000.OooO0O0("------startHandlerForAdShow  " + j);
                this.OooOOo0 = new Handler(Looper.getMainLooper());
            }
            this.OooOOo0.postDelayed(this.OooOOoo, j);
        } catch (Exception unused) {
        }
    }

    public void OooO00o(ViewGroup viewGroup, o000O0O0 o000o0o0) {
        String str;
        oo00o oo00oVar = this.OooO0Oo.OooOO0;
        if (oo00oVar == null) {
            if (o000o0o0 != null) {
                ErrorInfo errorInfo = new ErrorInfo(oOO00O0.ubix_cantShowSplash, oOO00O0.ubix_cantShowSplash_msg);
                errorInfo.setInfo((Object) this.OooO0Oo.OooOO0);
                o000o0o0.onShowError(errorInfo);
            }
            ooooO000.OooO0O0("开屏广告未找到可以展示的广告");
            return;
        }
        this.OooOOOo = o000o0o0;
        oOO00O ooo00o = oo00oVar.getBaseAdConfig().OooOOO0;
        if (ooo00o != null) {
            long j = ooo00o.Oooo0oo;
            if (j < 1000) {
                j = 5000;
            }
            OooO00o(j);
            str = ooo00o.Oooo0oO;
        } else {
            str = "";
        }
        this.OooO = this.OooOOO.OooO00o(viewGroup, str);
        this.OooOOOO = (UMNCustomSplashAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter();
        if (this.OooO == null) {
            ((UMNCustomSplashAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter()).internalShow(viewGroup, o000o0o0);
        } else {
            ((UMNCustomSplashAdapter) this.OooO0Oo.OooOO0.getAbsBaseAdapter()).internalShow(this.OooO, o000o0o0);
        }
    }

    public void OooO00o(o00O00o0 o00o00o0) {
        o00O0 o00o0 = this.OooO0Oo;
        o00o0.OooO0Oo.OooO0OO = 2;
        o00o0.OooOOOo = o00o00o0;
        int iOooO00o = oOo00o00.OooO00o(this.OooO0Oo.OooO0Oo.OooO00o.slotId + oO00000o.o00000O0.OooO0oo, 0);
        BaseDevConfig baseDevConfig = this.OooO0Oo.OooO0Oo.OooO00o;
        o00o00o0.startCountDown(iOooO00o, baseDevConfig != null ? baseDevConfig.timeout : 0);
        super.OooO0O0();
    }

    public void OooO0O0(boolean z) {
        try {
            ooooO000.OooO0O0("------removeAdShowTask  " + (this.OooOOo0 != null));
            this.OooOOo = z;
            Handler handler = this.OooOOo0;
            if (handler != null) {
                handler.removeCallbacks(this.OooOOoo);
            }
        } catch (Exception e) {
            ooooO000.OooO0O0("------removeAdShowTask e: " + e.getMessage());
        }
    }

    public void OooOO0() {
        this.OooO0O0 = null;
        UMNCustomSplashAdapter uMNCustomSplashAdapter = this.OooOOOO;
        if (uMNCustomSplashAdapter != null) {
            uMNCustomSplashAdapter.destory();
        }
        if (this.OooOOo0 != null) {
            this.OooOOo0 = null;
        }
        this.OooO = null;
        super.OooO0OO();
    }

    public boolean OooOO0O() {
        oo00o oo00oVar;
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 == null || (oo00oVar = o00o0.OooOO0) == null) {
            return false;
        }
        return ((UMNCustomSplashAdapter) oo00oVar.getAbsBaseAdapter()).isValid();
    }
}
