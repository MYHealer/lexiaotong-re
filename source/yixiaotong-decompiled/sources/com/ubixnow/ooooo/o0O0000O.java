package com.ubixnow.ooooo;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O0000O extends o0oOO {
    public WeakReference<Context> OooO0o;
    private int OooO0oO;
    private o0O0o OooOO0;
    private oo00o OooOOO0;
    private String OooO0o0 = "----ubix_in_waterfall:";
    private final AtomicInteger OooO0oo = new AtomicInteger(0);
    private final AtomicInteger OooO = new AtomicInteger(0);
    private List<Integer> OooOO0O = new ArrayList();
    private AtomicBoolean OooOO0o = new AtomicBoolean();
    private int OooOOO = 1;
    private final o00O00o0 OooOOOO = new OooO();

    public class OooO extends o00O00o0 {
        public OooO() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            ooooO000.OooO0O0(o0O0000O.this.OooO0o0, ooooO000.OooO0OO("f7") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
            o0O0000O.this.OooOO0.onCallbackAdLoaded(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            if (errorInfo != null) {
                ooooO000.OooO0O0(o0O0000O.this.OooO0o0, ooooO000.OooO0OO("f8") + errorInfo.toString());
                o0O0000O.this.OooOO0.onCallbackNoAdError(errorInfo);
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public class OooO00o implements Comparator<Integer> {
        public OooO00o() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: OooO00o, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return num.intValue() - num2.intValue();
        }
    }

    public class OooO0O0 extends o00O00o0 {
        public final /* synthetic */ AtomicBoolean OooO00o;
        public final /* synthetic */ AtomicBoolean OooO0O0;
        public final /* synthetic */ AtomicInteger OooO0OO;
        public final /* synthetic */ o00O00O.OooO00o OooO0Oo;

        public OooO0O0(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicInteger atomicInteger, o00O00O.OooO00o oooO00o) {
            this.OooO00o = atomicBoolean;
            this.OooO0O0 = atomicBoolean2;
            this.OooO0OO = atomicInteger;
            this.OooO0Oo = oooO00o;
        }

        private boolean OooO00o(boolean z) {
            if (this.OooO00o.get() || this.OooO0O0.get() || o0O0000O.this.OooOOO0 != null) {
                return false;
            }
            if (!z && this.OooO0OO.get() != this.OooO0Oo.OooO00o.size()) {
                return false;
            }
            this.OooO00o.set(true);
            return true;
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            this.OooO0OO.getAndAdd(1);
            this.OooO0O0.set(true);
            o0O0000O.this.OooOOO0 = oo00oVar;
            this.OooO0Oo.OooO0O0.cancle();
            ooooO000.OooO0O0(o0O0000O.this.OooO0o0, ooooO000.OooO0OO("f4") + (this.OooO0OO.get() == this.OooO0Oo.OooO00o.size()));
            if (this.OooO0OO.get() == this.OooO0Oo.OooO00o.size()) {
                o0O0000O.this.OooOOOO.onCallbackAdLoaded(oo00oVar);
            } else if (o0O0000O.this.OooOO0o.get()) {
                o0O0000O.this.OooOOOO.onCallbackAdLoaded(oo00oVar);
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
            this.OooO0OO.getAndAdd(1);
            if (this.OooO0OO.get() == this.OooO0Oo.OooO00o.size() && this.OooO0O0.get() && o0O0000O.this.OooOOO0 != null) {
                this.OooO0Oo.OooO0O0.cancle();
                o0O0000O.this.OooOOOO.onCallbackAdLoaded(o0O0000O.this.OooOOO0);
            } else if (o0O0000O.this.OooO0oo.addAndGet(1) == o0O0000O.this.OooO0O0.OooO) {
                this.OooO0Oo.OooO0O0.cancle();
                o0O0000O.this.OooOOOO.onCallbackNoAdError(TextUtils.isEmpty(errorInfo.platFormMsg) ? new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_no_ad_return_msg, errorInfo.code, errorInfo.msg) : new ErrorInfo(o0OO000o.o0000Oo, oOO00O0.ubix_no_ad_return_msg, errorInfo.platFormCode, errorInfo.platFormMsg));
            } else if (OooO00o(false)) {
                o0O0000O.this.OooO00o();
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
            try {
                o0O0000O o0o0000o = o0O0000O.this;
                o0o0000o.OooO00o(o0o0000o.OooO0o0, ooooO000.OooO0OO("f5"));
                if (OooO00o(true)) {
                    o0O0000O.this.OooO00o();
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
    }

    public class OooO0OO extends o00O00o0 {
        public final /* synthetic */ o00O000 OooO00o;
        public final /* synthetic */ o00O00o0 OooO0O0;
        public final /* synthetic */ o00O OooO0OO;

        public class OooO00o extends o0O000O<oo00o> {
            public final /* synthetic */ oo00o OooO00o;

            public OooO00o(oo00o oo00oVar) {
                this.OooO00o = oo00oVar;
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(o0O000Oo o0o000oo) {
                o0O0000O o0o0000o = o0O0000O.this;
                o0o0000o.OooO00o(o0o0000o.OooO0o0, "filter: code" + o0o000oo.OooO0o + " msg:" + o0o000oo.OooO0oO + " errorCode:" + o0o000oo.OooO0oo + " errorMsg:" + o0o000oo.OooO);
                o0O0000O o0o0000o2 = o0O0000O.this;
                o0o0000o2.OooO00o(o0o0000o2.OooO0O0, this.OooO00o, o0o000oo);
                OooO0OO.this.OooO0O0.onNoAdError(new ErrorInfo(o0o000oo.OooO0oo, o0o000oo.OooO));
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(oo00o oo00oVar) {
                OooO0OO oooO0OO = OooO0OO.this;
                o0O0000O o0o0000o = o0O0000O.this;
                o00O0 o00o0 = o0o0000o.OooO0O0;
                if (o00o0.OooO0OO.OooOO0) {
                    ooooO000.OooO0O0(o0o0000o.OooO0o0, ooooO000.OooO0OO("g7") + oo00oVar.checkMaterialStatus);
                    ConcurrentHashMap<String, o00OOO0O> concurrentHashMap = o0O0000O.this.OooO0O0.OooO0OO.OooO0oo;
                    String str = o0O0000O.this.OooO0O0.OooO0OO.OooO + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0;
                    OooO0OO oooO0OO2 = OooO0OO.this;
                    o0O0000O o0o0000o2 = o0O0000O.this;
                    concurrentHashMap.put(str, o0o0000o2.OooO00o(o0o0000o2.OooO0O0, oooO0OO2.OooO0OO));
                } else {
                    o0o0Oo.OooO00o(o00o0, oooO0OO.OooO0OO);
                }
                OooO0OO.this.OooO0O0.onAdCacheSuccess(oo00oVar);
            }
        }

        public OooO0OO(o00O000 o00o000, o00O00o0 o00o00o0, o00O o00o) {
            this.OooO00o = o00o000;
            this.OooO0O0 = o00o00o0;
            this.OooO0OO = o00o;
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0O0000O o0o0000o = o0O0000O.this;
            o0o0000o.OooO00o(o0o0000o.OooO0o0, "【wfAdSource】 onAdLoaded:" + ooooO000.OooO0OO("b7") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + ooooO000.OooO0OO("k8") + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO + " MaterialStatus:" + oo00oVar.checkMaterialStatus);
            o0O0o0 o0o0o0 = oo00oVar.material;
            if (o0o0o0 != null) {
                o0o0o0.OooO0OO();
            }
            o0O0000O o0o0000o2 = o0O0000O.this;
            o0o0000o2.OooO00o(o0o0000o2.OooO0O0, this.OooO00o, oo00oVar);
            if (o0O0000O.this.OooO00o(oo00oVar)) {
                return;
            }
            new o0OoOoOo().OooO00o(new o0O000o0()).OooO00o(o0O0000O.this.OooO0O0, oo00oVar, new OooO00o(oo00oVar));
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
            o0O0000O o0o0000o = o0O0000O.this;
            o0o0000o.OooO00o(o0o0000o.OooO0o0, "【wfAdSource】 onAdDataLoaded:  " + ooooO000.OooO0OO("b7") + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0);
            o0O0000O o0o0000o2 = o0O0000O.this;
            o0o0000o2.OooO0O0(o0o0000o2.OooO0O0, oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
            o0O0000O o0o0000o = o0O0000O.this;
            o0o0000o.OooO00o(o0o0000o.OooO0o0, "【wfAdSource】 onAdRenderFail " + errorInfo.msg);
            o0O0000O o0o0000o2 = o0O0000O.this;
            o0o0000o2.OooO00o(o0o0000o2.OooO0O0, this.OooO00o, errorInfo);
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            if (!"500041".equals(errorInfo.code)) {
                o0O0000O o0o0000o = o0O0000O.this;
                o0o0000o.OooO0O0(o0o0000o.OooO0O0, this.OooO00o, errorInfo);
            }
            if (o0O0000O.this.OooO00o(errorInfo)) {
                return;
            }
            o0O0000O o0o0000o2 = o0O0000O.this;
            o0o0000o2.OooO00o(o0o0000o2.OooO0o0, "【requestAdSource】 onNoAdError:" + errorInfo.toString());
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onPreRedirectFail(ErrorInfo errorInfo) {
            o0O0000O o0o0000o = o0O0000O.this;
            o0o0000o.OooO00o(o0o0000o.OooO0o0, "【requestAdSource】 onPreRedirectFail:" + errorInfo.toString());
            o0O0000O o0o0000o2 = o0O0000O.this;
            o0o0000o2.OooO00o(o0o0000o2.OooO0O0, this.OooO00o.OooO00o, errorInfo);
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ o00O000 OooO00o;
        public final /* synthetic */ o00O OooO0O0;
        public final /* synthetic */ o00O00o0 OooO0OO;

        public OooO0o(o00O000 o00o000, o00O o00o, o00O00o0 o00o00o0) {
            this.OooO00o = o00o000;
            this.OooO0O0 = o00o;
            this.OooO0OO = o00o00o0;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ooooO000.OooO0O0(o0O0000O.this.OooO0o0, ooooO000.OooO0OO("g8") + oO00000o.o0O0O00.OooO00o(this.OooO00o.OooO00o.OooO0OO) + " slotId:" + this.OooO00o.OooO00o.OooO0o0);
                o00O000 o00o000 = this.OooO00o;
                o0O0000O o0o0000o = o0O0000O.this;
                o00o000.OooOO0o = o0o0000o.OooO0O0.OooOOo0;
                this.OooO0O0.innerLoad(o0o0000o.OooO0o.get(), this.OooO00o, this.OooO0OO);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    public o0O0000O(Context context, o0O00o0 o0o00o0) {
        this.OooO0o = new WeakReference<>(context);
    }

    private void OooO00o(o00O00O.OooO00o oooO00o, o00O000 o00o000) {
        o00O o00oOooO00o;
        String str;
        oO0O0OoO oo0o0ooo;
        try {
            String strOooO00o = o0oOO.OooO00o(o00o000.OooO00o.OooO0OO);
            ooooO000.OooO0O0("------extracted", "---initClass " + strOooO00o);
            Class.forName(strOooO00o);
            int iOooO00o = o0oOO.OooO00o(o00o000.OooO00o.OooOOO0);
            if (this.OooO0O0.OooO0Oo.OooO0O0.equals("1") && iOooO00o == 2) {
                str = "7";
                oo0o0ooo = o00o000.OooO00o;
            } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("5") && iOooO00o == 2) {
                str = "10";
                oo0o0ooo = o00o000.OooO00o;
            } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("04") && iOooO00o == 2) {
                str = "11";
                oo0o0ooo = o00o000.OooO00o;
            } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("03") && iOooO00o == 2) {
                str = "12";
                oo0o0ooo = o00o000.OooO00o;
            } else {
                str = this.OooO0O0.OooO0Oo.OooO0O0;
                oo0o0ooo = o00o000.OooO00o;
            }
            o00oOooO00o = o00O0OOO.OooO00o(OooO00o(str, oo0o0ooo.OooO0OO));
            if (o00oOooO00o != null) {
                try {
                    o00oOooO00o.originType = iOooO00o;
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            o00oOooO00o = null;
        }
        OooO00o(o00oOooO00o, o00o000, oooO00o.OooO0O0);
    }

    private void OooO00o(o00O o00o, o00O000 o00o000, o00O00o0 o00o00o0) {
        if (OooO00o(this.OooO0O0)) {
            return;
        }
        OooO0OO oooO0OO = new OooO0OO(o00o000, o00o00o0, o00o);
        if (this.OooO0o.get() == null) {
            return;
        }
        ErrorInfo errorInfoOooO00o = OooO00o(o00o000, o00o);
        if (errorInfoOooO00o == null) {
            g1.OooO0OO().OooO0OO(new OooO0o(o00o000, o00o, oooO0OO));
        } else {
            oooO0OO.onPreRedirectFail(errorInfoOooO00o);
        }
    }

    public void OooO00o() {
        try {
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            AtomicBoolean atomicBoolean2 = new AtomicBoolean();
            if (OooO00o(this.OooO0O0)) {
                return;
            }
            if (this.OooO.get() >= this.OooO0oO) {
                this.OooOO0o.set(true);
                OooO00o(this.OooO0o0, ooooO000.OooO0OO("f1"));
                return;
            }
            this.OooO0O0.OooOOo0.OooOo.OooO0OO.put(this.OooOOO + "", Long.valueOf(SystemClock.elapsedRealtime()));
            ooooO000.OooO0O0(this.OooO0o0, ooooO000.OooO0OO("f2") + this.OooOO0O.size() + PPSLabelView.Code + this.OooOOO);
            this.OooOOO++;
            o00O00O.OooO00o oooO00o = this.OooO0O0.OooO0OO.OooO0o0.get(this.OooOO0O.get(this.OooO.getAndAdd(1)));
            if (oooO00o != null && oooO00o.OooO0Oo > this.OooO0O0.OooO0OO.OooO0Oo) {
                ooooO000.OooO0O0(this.OooO0o0, ooooO000.OooO0OO("f3") + oooO00o.OooO00o.size() + "");
                OooO0O0 oooO0O0 = new OooO0O0(atomicBoolean, atomicBoolean2, atomicInteger, oooO00o);
                oooO00o.OooO0O0 = oooO0O0;
                oooO0O0.startCountDown4Unite(oooO00o.OooO0OO);
                Iterator<o00O000> it = oooO00o.OooO00o.iterator();
                while (it.hasNext()) {
                    OooO00o(oooO00o, it.next());
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO00o(o00O0 o00o0, o0O0o o0o0o) {
        try {
            this.OooO0O0 = o00o0;
            this.OooOO0 = o0o0o;
            this.OooO0oO = o00o0.OooO0OO.OooO0o0.size();
            OooO00o(o00o0.OooO0OO.OooO0o0);
            OooO00o();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO00o(HashMap<Integer, o00O00O.OooO00o> map) {
        try {
            ArrayList arrayList = new ArrayList(map.keySet());
            this.OooOO0O = arrayList;
            Collections.sort(arrayList, new OooO00o());
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
