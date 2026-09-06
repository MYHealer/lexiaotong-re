package com.ubixnow.ooooo;

import com.ubixnow.adtype.nativead.api.UMNNativeAd;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMediaListener;
import com.ubixnow.adtype.nativead.api.UMNNativeStatusListener;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oo0o0Oo extends o00O0O0 {
    public UMNNativeMediaListener OooOOO;
    public UMNNativeEventListener OooOOO0;

    public class OooO implements Runnable {
        public final /* synthetic */ oo000o OooO00o;

        public OooO(oo000o oo000oVar) {
            this.OooO00o = oo000oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onVideoStart： " + this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO);
            oo0o0Oo.this.OooOOO.onVideoStart();
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ o00O0 OooO00o;
        public final /* synthetic */ oo000o OooO0O0;

        public OooO00o(o00O0 o00o0, oo000o oo000oVar) {
            this.OooO00o = o00o0;
            this.OooO0O0 = oo000oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            oo0o0Oo.this.OooOO0O.add(2);
            oo0o0Oo.this.OooO0O0(this.OooO00o.OooOOo0, this.OooO0O0, 0);
            oo0o0Oo.this.OooOOO0.onAdExposure();
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ oo000o OooO00o;
        public final /* synthetic */ boolean OooO0O0;
        public final /* synthetic */ o00O0 OooO0OO;

        public OooO0O0(oo000o oo000oVar, boolean z, o00O0 o00o0) {
            this.OooO00o = oo000oVar;
            this.OooO0O0 = z;
            this.OooO0OO = o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            oo0o0Oo.this.OooOO0O.add(3);
            o0O0OOOo.OooO00o(this.OooO00o);
            if (this.OooO0O0) {
                oo0o0Oo.this.OooO00o(this.OooO0OO.OooOOo0, this.OooO00o, 2);
            } else {
                oo0o0Oo.this.OooO00o(this.OooO0OO.OooOOo0, this.OooO00o, 0);
                oo0o0Oo.this.OooOOO0.onAdClicked();
            }
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ oo000o OooO00o;

        public OooO0OO(oo000o oo000oVar) {
            this.OooO00o = oo000oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onAdDismiss： " + this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO);
            oo0o0Oo.this.OooOO0O.add(4);
            oo0o0Oo.this.OooOOO0.onAdClose();
        }
    }

    public class OooO0o implements Runnable {
        public OooO0o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onAdStatusChanged");
            ((UMNNativeStatusListener) oo0o0Oo.this.OooOOO0).onAdStatusChanged();
        }
    }

    public class OooOO0 implements Runnable {
        public final /* synthetic */ oo000o OooO00o;

        public OooOO0(oo000o oo000oVar) {
            this.OooO00o = oo000oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onVideoEnd： " + this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO);
            oo0o0Oo.this.OooOOO.onVideoEnd();
        }
    }

    public class OooOO0O implements Runnable {
        public final /* synthetic */ oo000o OooO00o;

        public OooOO0O(oo000o oo000oVar) {
            this.OooO00o = oo000oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onVideoError： " + this.OooO00o.getBaseAdConfig().OooO00o.OooO0OO);
            oo0o0Oo.this.OooOOO.onVideoError();
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public void OooO00o(o00O0 o00o0, ErrorInfo errorInfo) {
    }

    public synchronized void OooO00o(o00O0 o00o0, oo000o oo000oVar) {
        ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onAdClicked： " + oo000oVar.getBaseAdConfig().OooO00o.OooO0OO);
        boolean zOooO0O0 = OooO0O0(oo000oVar);
        if (OooO00o(3)) {
            if (this.OooOOO0 != null && OooO0OO(oo000oVar)) {
                this.OooOOO0.onAdClicked();
            }
            OooO00o(o00o0.OooOOo0, oo000oVar, 1);
        } else if (this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO0O0(oo000oVar, zOooO0O0, o00o0));
        }
    }

    public synchronized void OooO0O0(o00O0 o00o0, oo000o oo000oVar) {
        if (!OooO00o(4) && this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO0OO(oo000oVar));
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0
    public void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
    }

    public synchronized void OooO0OO(o00O0 o00o0, oo000o oo000oVar) {
        ooooO000.OooO0O0(UMNNativeAd.TAG, "回调开发者：onAdExposure： " + oo000oVar.getBaseAdConfig().OooO00o.OooO0OO);
        if (OooO00o(2)) {
            OooO0O0(o00o0.OooOOo0, oo000oVar, 1);
        } else if (this.OooOOO0 != null) {
            BaseUtils.runInMainThread(new OooO00o(o00o0, oo000oVar));
        }
    }

    public synchronized void OooO0Oo(o00O0 o00o0, oo000o oo000oVar) {
        UMNNativeEventListener uMNNativeEventListener = this.OooOOO0;
        if (uMNNativeEventListener != null && (uMNNativeEventListener instanceof UMNNativeStatusListener)) {
            BaseUtils.runInMainThread(new OooO0o());
        }
    }

    public synchronized void OooO0o(o00O0 o00o0, oo000o oo000oVar) {
        if (this.OooOOO != null) {
            BaseUtils.runInMainThread(new OooOO0O(oo000oVar));
        }
    }

    public synchronized void OooO0o0(o00O0 o00o0, oo000o oo000oVar) {
        if (this.OooOOO != null) {
            BaseUtils.runInMainThread(new OooOO0(oo000oVar));
        }
    }

    public synchronized void OooO0oO(o00O0 o00o0, oo000o oo000oVar) {
        if (this.OooOOO != null) {
            BaseUtils.runInMainThread(new OooO(oo000oVar));
        }
    }
}
