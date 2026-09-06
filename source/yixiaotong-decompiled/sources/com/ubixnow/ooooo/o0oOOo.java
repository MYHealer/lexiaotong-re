package com.ubixnow.ooooo;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0oOOo extends o0oOO {
    private oo00o OooO;
    public WeakReference<Context> OooO0o;
    private o0O0o OooO0oo;
    private String OooO0o0 = "----ubix_in_biddingControl:";
    private final AtomicInteger OooO0oO = new AtomicInteger(0);
    private final o00O00o0 OooOO0 = new OooO0o();

    public class OooO00o extends o00O00o0 {
        public final /* synthetic */ AtomicInteger OooO00o;
        public final /* synthetic */ o00O00O.OooO00o OooO0O0;

        public OooO00o(AtomicInteger atomicInteger, o00O00O.OooO00o oooO00o) {
            this.OooO00o = atomicInteger;
            this.OooO0O0 = oooO00o;
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            this.OooO00o.getAndAdd(1);
            o0oOOo.this.OooO = oo00oVar;
            if (this.OooO00o.get() == o0oOOo.this.OooO0O0.OooO0oO) {
                this.OooO0O0.OooO0O0.cancle();
                o0oOOo.this.OooOO0.onCallbackAdLoaded(oo00oVar);
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            this.OooO00o.getAndAdd(1);
            int i = this.OooO00o.get();
            o0oOOo o0oooo = o0oOOo.this;
            if (i == o0oooo.OooO0O0.OooO0oO && o0oooo.OooO != null) {
                this.OooO0O0.OooO0O0.cancle();
                o0oOOo.this.OooOO0.onCallbackAdLoaded(o0oOOo.this.OooO);
            } else if (o0oOOo.this.OooO0oO.addAndGet(1) == o0oOOo.this.OooO0O0.OooO0oO) {
                this.OooO0O0.OooO0O0.cancle();
                o0oOOo.this.OooOO0.onCallbackNoAdError(TextUtils.isEmpty(errorInfo.platFormMsg) ? new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_no_ad_return_msg, errorInfo.code, errorInfo.msg) : new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_no_ad_return_msg, errorInfo.platFormCode, errorInfo.platFormMsg));
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
            try {
                o0oOOo o0oooo = o0oOOo.this;
                o0oooo.OooO00o(o0oooo.OooO0o0, ooooO000.OooO0OO("g3"));
                if (o0oOOo.this.OooO != null) {
                    o0oOOo.this.OooOO0.onCallbackAdLoaded(o0oOOo.this.OooO);
                } else {
                    o0oOOo.this.OooOO0.onCallbackNoAdError(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0O0 extends o00O00o0 {
        public final /* synthetic */ o00O000 OooO00o;
        public final /* synthetic */ o00O00o0 OooO0O0;
        public final /* synthetic */ o00O OooO0OO;

        public class OooO00o extends o0O000O<oo00o> {
            public final /* synthetic */ oo00o OooO00o;

            public OooO00o(oo00o oo00oVar) {
                this.OooO00o = oo00oVar;
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(int i) {
                if (i == 2) {
                    o0oOOo o0oooo = o0oOOo.this;
                    o0oooo.OooO00o(o0oooo.OooO0O0, this.OooO00o);
                } else if (i == 1) {
                    OooO0O0 oooO0O0 = OooO0O0.this;
                    o00O o00o = oooO0O0.OooO0OO;
                    o00O0 o00o0 = o0oOOo.this.OooO0O0;
                    oo0O.OooO00o(o00o, o00o0.OooO0OO.OooO0OO, o00o0);
                }
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(o0O000Oo o0o000oo) {
                o0oOOo o0oooo = o0oOOo.this;
                o0oooo.OooO00o(o0oooo.OooO0o0, "filter: code" + o0o000oo.OooO0o + " msg:" + o0o000oo.OooO0oO + " errorCode:" + o0o000oo.OooO0oo + " errorMsg:" + o0o000oo.OooO);
                o0oOOo o0oooo2 = o0oOOo.this;
                o0oooo2.OooO00o(o0oooo2.OooO0O0, this.OooO00o, o0o000oo);
                OooO0O0.this.OooO0O0.onNoAdError(new ErrorInfo(o0o000oo.OooO0oo, o0o000oo.OooO));
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(oo00o oo00oVar) {
                OooO0O0 oooO0O0 = OooO0O0.this;
                o0oOOo o0oooo = o0oOOo.this;
                o00O0 o00o0 = o0oooo.OooO0O0;
                if (o00o0.OooO0OO.OooOO0) {
                    ooooO000.OooO0O0(o0oooo.OooO0o0, ooooO000.OooO0OO("g7") + oo00oVar.checkMaterialStatus);
                    o00O00O o00o00o = o0oOOo.this.OooO0O0.OooO0OO;
                    o00o00o.OooO0Oo = Math.max(o00o00o.OooO0Oo, oo00oVar.getBaseAdConfig().OooO0o);
                    ConcurrentHashMap<String, o00OOO0O> concurrentHashMap = o0oOOo.this.OooO0O0.OooO0OO.OooO0oo;
                    String str = o0oOOo.this.OooO0O0.OooO0OO.OooO + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0;
                    OooO0O0 oooO0O1 = OooO0O0.this;
                    o0oOOo o0oooo2 = o0oOOo.this;
                    concurrentHashMap.put(str, o0oooo2.OooO00o(o0oooo2.OooO0O0, oooO0O1.OooO0OO));
                } else {
                    o0o0Oo.OooO00o(o00o0, oooO0O0.OooO0OO);
                }
                OooO0O0.this.OooO0O0.onAdCacheSuccess(oo00oVar);
            }
        }

        public OooO0O0(o00O000 o00o000, o00O00o0 o00o00o0, o00O o00o) {
            this.OooO00o = o00o000;
            this.OooO0O0 = o00o00o0;
            this.OooO0OO = o00o;
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            ooooO000.OooO0O0(o0oOOo.this.OooO0o0, ooooO000.OooO0OO("g5") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + ooooO000.OooO0OO("k8") + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
            o0O0o0 o0o0o0 = oo00oVar.material;
            if (o0o0o0 != null) {
                o0o0o0.OooO0OO();
            }
            o0oOOo o0oooo = o0oOOo.this;
            o0oooo.OooO00o(o0oooo.OooO0O0, this.OooO00o, oo00oVar);
            if (o0oOOo.this.OooO00o(oo00oVar)) {
                return;
            }
            new o0OoOoOo().OooO00o(new o0O00()).OooO00o(new o0O000o0()).OooO00o(o0oOOo.this.OooO0O0, oo00oVar, new OooO00o(oo00oVar));
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
            ooooO000.OooO0O0(o0oOOo.this.OooO0o0, o0oOOo.this.OooO0o0 + ooooO000.OooO0OO("g4") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0);
            o0oOOo o0oooo = o0oOOo.this;
            o0oooo.OooO0O0(o0oooo.OooO0O0, oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
            o0oOOo o0oooo = o0oOOo.this;
            o0oooo.OooO00o(o0oooo.OooO0o0, "【wfAdSource】 onAdRenderFail: " + errorInfo.msg);
            o0oOOo o0oooo2 = o0oOOo.this;
            o0oooo2.OooO00o(o0oooo2.OooO0O0, this.OooO00o, errorInfo);
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            if (!"500041".equals(errorInfo.code)) {
                o0oOOo o0oooo = o0oOOo.this;
                o0oooo.OooO0O0(o0oooo.OooO0O0, this.OooO00o, errorInfo);
            }
            if (o0oOOo.this.OooO00o(errorInfo)) {
                return;
            }
            o0oOOo o0oooo2 = o0oOOo.this;
            o0oooo2.OooO00o(o0oooo2.OooO0o0, "【requestAdSource】 onNoAdError:" + errorInfo.toString());
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onPreRedirectFail(ErrorInfo errorInfo) {
            o0oOOo o0oooo = o0oOOo.this;
            o0oooo.OooO00o(o0oooo.OooO0o0, "【requestAdSource】 onPreRedirectFail:" + errorInfo.toString());
            o0oOOo o0oooo2 = o0oOOo.this;
            o0oooo2.OooO00o(o0oooo2.OooO0O0, this.OooO00o.OooO00o, errorInfo);
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ o00O000 OooO00o;
        public final /* synthetic */ o00O OooO0O0;
        public final /* synthetic */ o00O00o0 OooO0OO;

        public OooO0OO(o00O000 o00o000, o00O o00o, o00O00o0 o00o00o0) {
            this.OooO00o = o00o000;
            this.OooO0O0 = o00o;
            this.OooO0OO = o00o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ooooO000.OooO0O0(o0oOOo.this.OooO0o0, ooooO000.OooO0OO("g8") + oO00000o.o0O0O00.OooO00o(this.OooO00o.OooO00o.OooO0OO) + " slotId:" + this.OooO00o.OooO00o.OooO0o0);
                o00O000 o00o000 = this.OooO00o;
                o0oOOo o0oooo = o0oOOo.this;
                o00o000.OooOO0o = o0oooo.OooO0O0.OooOOo0;
                this.OooO0O0.innerLoad(o0oooo.OooO0o.get(), this.OooO00o, this.OooO0OO);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    public class OooO0o extends o00O00o0 {

        public class OooO00o implements Runnable {
            public final /* synthetic */ ErrorInfo OooO00o;

            public OooO00o(ErrorInfo errorInfo) {
                this.OooO00o = errorInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                o0oOOo.this.OooO0oo.onCallbackNoAdError(this.OooO00o);
            }
        }

        public OooO0o() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            ooooO000.OooO0O0(o0oOOo.this.OooO0o0, ooooO000.OooO0OO("g9") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
            o0oOOo.this.OooO0oo.onCallbackAdLoaded(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0oOOo o0oooo = o0oOOo.this;
            o0oooo.OooO00o(o0oooo.OooO0o0, "B 请求失败：" + errorInfo.toString());
            BaseUtils.postDelayed(new OooO00o(errorInfo), 5L);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public o0oOOo(Context context, o0O00o0 o0o00o0) {
        this.OooO0o = new WeakReference<>(context);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x007e  */
    private void OooO00o(o00O00O.OooO00o oooO00o, o00O000 o00o000) {
        String strOooO00o;
        int i;
        String str;
        o00O o00oOooO00o;
        int iOooO00o = o0oOO.OooO00o(o00o000.OooO00o.OooOOO0);
        if (this.OooO0O0.OooO0Oo.OooO0O0.equals("1") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "7";
        } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("5") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "10";
        } else {
            if (!this.OooO0O0.OooO0Oo.OooO0O0.equals("04") || iOooO00o != 2) {
                if (this.OooO0O0.OooO0Oo.OooO0O0.equals("03") && iOooO00o == 2) {
                    i = o00o000.OooO00o.OooO0OO;
                    str = "12";
                } else {
                    strOooO00o = OooO00o(this.OooO0O0.OooO0Oo.OooO0O0, o00o000.OooO00o.OooO0OO);
                }
                o00oOooO00o = o00O0OOO.OooO00o(strOooO00o);
                if (o00oOooO00o != null) {
                    o00oOooO00o.originType = iOooO00o;
                }
                OooO00o(o00oOooO00o, o00o000, oooO00o.OooO0O0);
            }
            i = o00o000.OooO00o.OooO0OO;
            str = "11";
        }
        strOooO00o = OooO00o(str, i);
        o00oOooO00o = o00O0OOO.OooO00o(strOooO00o);
        if (o00oOooO00o != null) {
            o00oOooO00o.originType = iOooO00o;
        }
        OooO00o(o00oOooO00o, o00o000, oooO00o.OooO0O0);
    }

    private void OooO00o(o00O o00o, o00O000 o00o000, o00O00o0 o00o00o0) {
        if (OooO00o(this.OooO0O0)) {
            return;
        }
        OooO0O0 oooO0O0 = new OooO0O0(o00o000, o00o00o0, o00o);
        if (this.OooO0o.get() == null) {
            return;
        }
        ErrorInfo errorInfoOooO00o = OooO00o(o00o000, o00o);
        if (errorInfoOooO00o == null) {
            g1.OooO0OO().OooO0OO(new OooO0OO(o00o000, o00o, oooO0O0));
        } else {
            oooO0O0.onPreRedirectFail(errorInfoOooO00o);
        }
    }

    public void OooO00o() {
        AtomicInteger atomicInteger = new AtomicInteger();
        if (OooO00o(this.OooO0O0)) {
            return;
        }
        OooO00o(this.OooO0o0, ooooO000.OooO0OO("g1"));
        this.OooO0O0.OooOOo0.OooOo.OooO0OO.put("biddingFloor", Long.valueOf(SystemClock.elapsedRealtime()));
        o00O00O.OooO00o oooO00o = this.OooO0O0.OooO0OO.OooO0o;
        if (oooO00o == null) {
            return;
        }
        ooooO000.OooO0O0(this.OooO0o0, ooooO000.OooO0OO("g2") + oooO00o.OooO00o.size());
        OooO00o oooO00o2 = new OooO00o(atomicInteger, oooO00o);
        oooO00o.OooO0O0 = oooO00o2;
        oooO00o2.startCountDown4Unite(this.OooO0O0.OooO0OO.OooO00o);
        Iterator<o00O000> it = oooO00o.OooO00o.iterator();
        while (it.hasNext()) {
            OooO00o(oooO00o, it.next());
        }
    }

    public void OooO00o(o00O0 o00o0, o0O0o o0o0o) {
        try {
            this.OooO0O0 = o00o0;
            this.OooO0oo = o0o0o;
            OooO00o();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
