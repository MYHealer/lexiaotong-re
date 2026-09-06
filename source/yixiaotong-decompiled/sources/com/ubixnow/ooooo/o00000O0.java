package com.ubixnow.ooooo;

import android.os.Handler;
import android.text.TextUtils;
import com.ubixnow.adtype.reward.api.UMNRewardAd;
import com.ubixnow.adtype.reward.api.UMNRewardListener;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.bean.UMNAdInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00000O0 extends o00O0O0 {
    public UMNRewardListener OooOOO0;
    private Runnable OooOOo;
    private Handler OooOOo0;
    private boolean OooOOO = false;
    private int[] OooOOOO = new int[3];
    private HashMap<String, String> OooOOOo = new HashMap<>();
    private long OooOOoo = 0;
    private long OooOo00 = 0;

    public class OooO implements Runnable {
        public OooO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(4);
            o00000O0.this.OooOOO0.onAdDismiss();
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ ErrorInfo OooO0O0;

        public OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
            this.OooO00o = o00o0;
            this.OooO0O0 = errorInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(5);
            o00000O0.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
            ErrorInfo errorInfo = this.OooO0O0;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO0O0.platFormCode)) {
                uMNError.platFormCode = this.OooO0O0.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.platFormMsg)) {
                uMNError.platFormMsg = this.OooO0O0.platFormMsg;
            }
            o00000O0.this.OooOOO0.onError(uMNError);
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(2);
            o00000O0.this.OooO0O0(this.OooO00o.OooOOo0, this.OooO0O0, 0);
            o00000O0.this.OooOOO0.onAdShow();
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooO0OO(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(7);
            o00000O0.this.OooO0O0(this.OooO00o.OooOOo0, this.OooO0O0, false);
            o00000O0.this.OooOOO0.onVideoPlayStart();
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ oo00o OooO00o;
        public final /* synthetic */ boolean OooO0O0;
        public final /* synthetic */ o00O0 OooO0OO;

        public OooO0o(oo00o oo00oVar, boolean z, o00O0 o00o0) {
            this.OooO00o = oo00oVar;
            this.OooO0O0 = z;
            this.OooO0OO = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(3);
            o0O0OOOo.OooO00o(this.OooO00o);
            if (this.OooO0O0) {
                o00000O0.this.OooO00o(this.OooO0OO.OooOOo0, this.OooO00o, 2);
            } else {
                o00000O0.this.OooO00o(this.OooO0OO.OooOOo0, this.OooO00o, 0);
                o00000O0.this.OooOOO0.onAdClicked();
            }
        }
    }

    public class OooOO0 implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooOO0(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(8);
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(this.OooO00o.OooOOo0, o0OO000o.o000O0oO);
            o00000O0.this.OooO00o(mapOooO00o, this.OooO00o.OooOOo0, this.OooO0O0);
            mapOooO00o.put("duration", (System.currentTimeMillis() - this.OooO00o.OooOOo0.OooOo.OooO0oO) + "");
            o0OO000.OooO00o(o0OO000o.o000O0o0, mapOooO00o, new Object[0]);
            o00000O0.this.OooOOO0.onVideoPlayComplete();
        }
    }

    public class OooOO0O implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooOO0O(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(9);
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(this.OooO00o.OooOOo0, o0OO000o.o000O);
            o00000O0.this.OooO00o(mapOooO00o, this.OooO00o.OooOOo0, this.OooO0O0);
            mapOooO00o.put("duration", (System.currentTimeMillis() - this.OooO00o.OooOOo0.OooOo.OooO0oO) + "");
            o0OO000.OooO00o(o0OO000o.o000O0oo, mapOooO00o, new Object[0]);
            o00000O0.this.OooOOO0.onRewardVerify();
        }
    }

    public class OooOOO implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo00o OooO0O0;

        public OooOOO(o00O0 o00o0, oo00o oo00oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo00oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0 o00000o0;
            o00O0 o00o0;
            ErrorInfo errorInfo;
            o00000O0.this.OooO0Oo(this.OooO00o, this.OooO0O0);
            o00000O0.this.OooOO0O.add(1);
            UMNAdInfo uMNAdInfo = new UMNAdInfo(o00000O0.this.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0, oO00000o.o0O0O00.OooO00o(this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO)), o00000O0.this.OooO00o(this.OooO0O0.material));
            if (o00000O0.this.OooO00o(this.OooO00o)) {
                o00000o0 = o00000O0.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0, o0OO000o.o0000o0O);
            } else if (oO00000o.o00O0O.OooO00o == 0) {
                ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onAdLoadSuccess： " + this.OooO0O0.getBaseAdConfig().OooO00o.OooO + " SlotId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + this.OooO0O0.getBaseAdConfig().OooO00o.OooO0OO);
                o00000O0.this.OooO00o(this.OooO00o.OooOOo0, this.OooO0O0);
                o00000O0.this.OooOOO0.onAdLoadSuccess(uMNAdInfo);
                return;
            } else {
                o00000o0 = o00000O0.this;
                o00o0 = this.OooO00o;
                errorInfo = new ErrorInfo(o0OO000o.o0000o0o, o0OO000o.o0000o);
            }
            o00000o0.OooO00o(o00o0, errorInfo);
        }
    }

    public class OooOOO0 implements Runnable {
        public OooOOO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o00000O0.this.OooOO0O.add(10);
            o00000O0.this.OooOOO0.onVideoSkip();
        }
    }

    public class OooOOOO implements Runnable {
        public final /* synthetic */ ErrorInfo OooO00o;
        public final /* synthetic */ o00O0 OooO0O0;

        public OooOOOO(ErrorInfo errorInfo, o00O0 o00o0) {
            this.OooO00o = errorInfo;
            this.OooO0O0 = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            ErrorInfo errorInfo = this.OooO00o;
            UMNError uMNError = new UMNError(errorInfo.code, errorInfo.msg);
            if (!TextUtils.isEmpty(this.OooO00o.platFormCode)) {
                uMNError.platFormCode = this.OooO00o.platFormCode;
            }
            if (!TextUtils.isEmpty(this.OooO00o.platFormMsg)) {
                uMNError.platFormMsg = this.OooO00o.platFormMsg;
            }
            o00000O0.this.OooO0O0(this.OooO0O0.OooOOo0, this.OooO00o);
            o00000O0.this.OooOOO0.onVideoPlayError(uMNError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(oo0oO0 oo0oo0, ErrorInfo errorInfo) {
        HashMap<String, String> mapOooO00o = o0OO000.OooO00o(oo0oo0, o0OO000o.o0OoO0o);
        Object obj = errorInfo.object;
        if (obj instanceof oo00o) {
            OooO00o(mapOooO00o, oo0oo0, (oo00o) obj);
        }
        mapOooO00o.put(o0OO000o.o000oo0o, errorInfo.msg);
        if (!TextUtils.isEmpty(errorInfo.platFormCode)) {
            mapOooO00o.put(o0OO000o.o000oo, errorInfo.platFormCode);
        }
        if (!TextUtils.isEmpty(errorInfo.platFormMsg)) {
            mapOooO00o.put(o0OO000o.o000ooO0, errorInfo.platFormMsg);
        }
        mapOooO00o.put("duration", (System.currentTimeMillis() - oo0oo0.OooOo.OooO0oO) + "");
        o0OO000.OooO00o(o0OO000o.o000OO00, mapOooO00o, new Object[0]);
    }

    public synchronized void OooO(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onVideoPlayComplete： " + this.OooOOO + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        if (!OooO00o(8) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooOO0(o00o0, oo00oVar));
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onError：" + errorInfo.toString());
        if (!OooO00o(5) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO00o(o00o0, errorInfo));
        }
    }

    public synchronized void OooO0O0(o00O0 o00o0, ErrorInfo errorInfo) {
        try {
            if (!OooO00o(6) && this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooOOOO(errorInfo, o00o0));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public synchronized void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            if (!OooO00o(1) && this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooOOO(o00o0, oo00oVar));
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void OooO0o(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onAdDismiss： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        if (!OooO00o(4) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO());
        }
    }

    public synchronized void OooO0o0(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onAdClicked： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        boolean zOooO0O0 = OooO0O0(oo00oVar);
        if (OooO00o(3)) {
            if (this.OooOOO0 != null && OooO0OO(oo00oVar)) {
                this.OooOOO0.onAdClicked();
            }
            oo00oVar.extraInfo.put(o0OO000o.o00O00Oo, "2");
            oo00oVar.extraInfo.put(oo00o.trackingExtraInfo, this.OooOOOo);
            OooO00o(o00o0.OooOOo0, oo00oVar, 1);
        } else if (this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO0o(oo00oVar, zOooO0O0, o00o0));
        }
    }

    public synchronized void OooO0oO(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onAdShow： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        if (!OooO00o(2)) {
            if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0O0(o00o0, oo00oVar));
            }
            o0O0O0O.OooO00o(oo00oVar);
        }
    }

    public synchronized void OooO0oo(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onRewardVerify： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        if (!OooO00o(9) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooOO0O(o00o0, oo00oVar));
        }
    }

    public synchronized void OooOO0(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onVideoPlayStart： " + oO00000o.o0O0O00.OooO00o(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO));
        if (!OooO00o(7)) {
            if (this.OooOOO0 != null) {
                BaseUtils.runInMainThread(new OooO0OO(o00o0, oo00oVar));
            }
            o0O0O0O.OooO00o(oo00oVar);
        }
    }

    public synchronized void OooOO0O(o00O0 o00o0, oo00o oo00oVar) {
        ooooO000.OooO0O0(UMNRewardAd.TAG, "回调开发者：onVideoSkip： " + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
        if (!OooO00o(10) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooOOO0());
        }
    }
}
