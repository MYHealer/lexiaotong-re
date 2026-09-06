package com.ubixnow.ooooo;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.ubixnow.core.api.UMNConfigUserInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0 extends o0oOO {
    public WeakReference<Context> OooO0o;
    private o0O0o OooO0oO;
    private oo00o OooO0oo;
    private String OooO0o0 = "----ubix_in_server-biddingControl:";
    public ConcurrentHashMap<String, o00O> OooO = new ConcurrentHashMap<>();
    private final o00O00o0 OooOO0 = new OooO0o();

    public class OooO00o extends o00O00o0 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            oo00oVar.auctionPrice = (int) o0Var.OooO0O0.OooOOo0.OooOO0o;
            o0Var.OooOO0.onCallbackAdLoaded(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0.this.OooOO0.onCallbackNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
            o0.this.OooOO0.onCallbackNoAdError(new ErrorInfo(o0OO000o.o0000OOo, oOO00O0.ubix_request_timeout_msg));
        }
    }

    public class OooO0O0 extends o00O00o0 {
        public final /* synthetic */ AtomicInteger OooO00o;
        public final /* synthetic */ List OooO0O0;

        public OooO0O0(AtomicInteger atomicInteger, List list) {
            this.OooO00o = atomicInteger;
            this.OooO0O0 = list;
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenFail(ErrorInfo errorInfo) {
            this.OooO00o.getAndAdd(1);
            int i = this.OooO00o.get();
            o0 o0Var = o0.this;
            if (i == o0Var.OooO0O0.OooO0oo) {
                if (o0Var.OooO0oo == null) {
                    o0.this.OooOO0.getTokenFail(errorInfo);
                    return;
                }
                oo00o oo00oVar = o0.this.OooO0oo;
                o0 o0Var2 = o0.this;
                oo00oVar.requestToken = o0Var2.OooO00o((List<oO0OoOO0.OooO00o>) this.OooO0O0, o0Var2.OooO0oo);
                o0.this.OooOO0.getTokenSucc(o0.this.OooO0oo);
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenSucc(oo00o oo00oVar) {
            this.OooO00o.getAndAdd(1);
            ooooO000.OooO0O0(o0.this.OooO0o0, "platform:" + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO + " token:" + oo00oVar.getBaseAdConfig().OooOOO);
            this.OooO0O0.add(o0.this.OooO0O0(oo00oVar));
            o0.this.OooO0oo = oo00oVar;
            int i = this.OooO00o.get();
            o0 o0Var = o0.this;
            if (i == o0Var.OooO0O0.OooO0oo) {
                oo00oVar.requestToken = o0Var.OooO00o((List<oO0OoOO0.OooO00o>) this.OooO0O0, oo00oVar);
                o0.this.OooOO0.getTokenSucc(oo00oVar);
            }
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
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
                o0 o0Var = o0.this;
                o0Var.OooO00o(o0Var.OooO0o0, "filter: code" + o0o000oo.OooO0o + " msg:" + o0o000oo.OooO0oO + " errorCode:" + o0o000oo.OooO0oo + " errorMsg:" + o0o000oo.OooO);
                o0 o0Var2 = o0.this;
                o0Var2.OooO00o(o0Var2.OooO0O0, this.OooO00o, o0o000oo);
                OooO0OO.this.OooO0O0.onNoAdError(new ErrorInfo(o0o000oo.OooO0oo, o0o000oo.OooO));
            }

            @Override // com.ubixnow.ooooo.o0O000O
            public void OooO00o(oo00o oo00oVar) {
                OooO0OO oooO0OO = OooO0OO.this;
                o0 o0Var = o0.this;
                if (o0Var.OooO0O0.OooO0OO.OooOO0) {
                    ooooO000.OooO0O0(o0Var.OooO0o0, ooooO000.OooO0OO("g7") + oo00oVar.checkMaterialStatus);
                    ConcurrentHashMap<String, o00OOO0O> concurrentHashMap = o0.this.OooO0O0.OooO0OO.OooO0oo;
                    String str = o0.this.OooO0O0.OooO0OO.OooO + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0;
                    OooO0OO oooO0OO2 = OooO0OO.this;
                    o0 o0Var2 = o0.this;
                    concurrentHashMap.put(str, o0Var2.OooO00o(o0Var2.OooO0O0, oooO0OO2.OooO0OO));
                } else {
                    oooO0OO.OooO0OO.destory();
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
        public void getTokenFail(ErrorInfo errorInfo) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "【server-bidding】 getTokenFail: " + errorInfo.code + "  " + errorInfo.msg);
            if (!"500041".equals(errorInfo.code) && errorInfo.preCheckPass) {
                o0 o0Var2 = o0.this;
                o0Var2.OooO00o(o0Var2.OooO0O0, this.OooO00o.OooO00o, o0OO000o.o00Oo0O0, errorInfo.code, errorInfo.msg);
            }
            this.OooO0O0.getTokenFail(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenSucc(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "【server-bidding】 getTokenSucc: ");
            o0 o0Var2 = o0.this;
            o0Var2.OooO00o(o0Var2.OooO0O0, this.OooO00o.OooO00o, o0OO000o.o00Oo00o, o0OO000o.o00O0oo, "");
            this.OooO0O0.getTokenSucc(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "【requestAdSource】 onAdLoaded: 广告位" + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + "  广告源： " + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO + " hashCode： " + oo00oVar.hashCode());
            o0O0o0 o0o0o0 = oo00oVar.material;
            if (o0o0o0 != null) {
                o0o0o0.OooO0OO();
            }
            o0.this.OooO0O0.OooOOo0.OooOo.OooOO0o = SystemClock.elapsedRealtime();
            o0 o0Var2 = o0.this;
            o0Var2.OooO0O0(o0Var2.OooO0O0, oo00oVar, o0OO000o.o00Oo0o0, o0OO000o.o00OOOo0);
            if (o0.this.OooO00o(oo00oVar)) {
                return;
            }
            new o0OoOoOo().OooO00o(new o0O000o0()).OooO00o(o0.this.OooO0O0, oo00oVar, new OooO00o(oo00oVar));
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "【server-bidding】 onAdDataLoaded: 广告位 " + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0);
            o0 o0Var2 = o0.this;
            o0Var2.OooO0O0(o0Var2.OooO0O0, oo00oVar, o0OO000o.o00Oo0O, o0OO000o.o00OOOOo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "【server-bidding】 onAdRenderFail: " + errorInfo.msg);
            o0 o0Var2 = o0.this;
            o0Var2.OooO00o(o0Var2.OooO0O0, this.OooO00o, errorInfo, o0OO000o.o00Oo0o, o0OO000o.o00OOOo);
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            if (!"500041".equals(errorInfo.code) && errorInfo.preCheckPass) {
                o0 o0Var = o0.this;
                o0Var.OooO00o(o0Var.OooO0O0, this.OooO00o, errorInfo, o0OO000o.o00Oo0Oo, o0OO000o.oOooo0o);
            }
            if (o0.this.OooO00o(errorInfo)) {
                return;
            }
            o0 o0Var2 = o0.this;
            o0Var2.OooO00o(o0Var2.OooO0o0, "【requestAdSource】 onNoAdError:" + errorInfo.toString());
            this.OooO0O0.onNoAdError(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
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
                o0.this.OooO0oO.onCallbackNoAdError(this.OooO00o);
            }
        }

        public OooO0o() {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenFail(ErrorInfo errorInfo) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "server bidding 获取token 失败：" + errorInfo.code + PPSLabelView.Code + errorInfo.msg);
            o0.this.OooO0oO.getTokenFail(errorInfo);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void getTokenSucc(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "server bidding 获取token 成功：");
            o0.this.OooO0oO.getTokenSucc(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdCacheSuccess(oo00o oo00oVar) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "bidding请求成功：" + oo00oVar.getBaseAdConfig().OooO00o.OooO0o0 + " PlatformId:" + oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
            o0.this.OooO0oO.onCallbackAdLoaded(oo00oVar);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdDataLoaded(oo00o oo00oVar) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onAdRenderFail(ErrorInfo errorInfo) {
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onNoAdError(ErrorInfo errorInfo) {
            o0 o0Var = o0.this;
            o0Var.OooO00o(o0Var.OooO0o0, "bidding请求失败：" + errorInfo.toString());
            BaseUtils.postDelayed(new OooO00o(errorInfo), 5L);
        }

        @Override // com.ubixnow.ooooo.o00O00o0
        public void onTimeout() {
        }
    }

    public o0(Context context, o0O00o0 o0o00o0) {
        this.OooO0o = new WeakReference<>(context);
    }

    private o00O OooO00o(o00O000 o00o000) {
        String str;
        int i;
        int iOooO00o = o0oOO.OooO00o(o00o000.OooO00o.OooOOO0);
        if (this.OooO0O0.OooO0Oo.OooO0O0.equals("1") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "7";
        } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("5") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "10";
        } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("04") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "11";
        } else if (this.OooO0O0.OooO0Oo.OooO0O0.equals("03") && iOooO00o == 2) {
            i = o00o000.OooO00o.OooO0OO;
            str = "12";
        } else {
            str = this.OooO0O0.OooO0Oo.OooO0O0;
            i = o00o000.OooO00o.OooO0OO;
        }
        o00O o00oOooO00o = o00O0OOO.OooO00o(OooO00o(str, i));
        if (o00oOooO00o != null) {
            o00oOooO00o.originType = iOooO00o;
        }
        return o00oOooO00o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String OooO00o(List<oO0OoOO0.OooO00o> list, oo00o oo00oVar) {
        String str;
        try {
            if (list.size() == 0) {
                return "";
            }
            h1 h1VarOooO00o = h1.OooO0O0().OooO00o(true);
            oO0OoOO0.OooO0O0 oooO0O0 = new oO0OoOO0.OooO0O0();
            oooO0O0.OooO0OO = this.OooO0O0.OooO0O0.appId;
            oooO0O0.OooO0Oo = BaseUtils.getContext().getPackageName();
            oooO0O0.OooO0o0 = h1VarOooO00o.OooOo0O;
            oooO0O0.OooO0o = this.OooO0O0.OooO0O0.channel;
            oooO0O0.OooO0oO = h1VarOooO00o.OooOo;
            oO0OoOO0.OooO oooO = new oO0OoOO0.OooO();
            UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
            if (uMNConfigUserInfo != null) {
                oooO.OooO0Oo = uMNConfigUserInfo.getChannel();
                oooO.OooO0OO = o0O0ooO.OooO0o0.getUserId();
                oooO.OooO0o = o0O0ooO.OooO0o0.getSubScriber();
                oooO.OooO0o0 = o0O0ooO.OooO0o0.getSubChannel();
                oooO.OooO0oO = o0O0ooO.OooO0o0.getPubSegmentId();
                if (o0O0ooO.OooO0o0.getCustomUserInfo() != null && o0O0ooO.OooO0o0.getCustomUserInfo().size() > 0) {
                    oooO.OooO0oo = new JSONObject(o0O0ooO.OooO0o0.getCustomUserInfo()).toString();
                }
            }
            oO0OoOO0.OooO0OO.OooO0O0 oooO0O1 = new oO0OoOO0.OooO0OO.OooO0O0();
            oooO0O1.OooO0oO = h1VarOooO00o.OooO0OO;
            oooO0O1.OooO0o = h1VarOooO00o.OooO0O0;
            oooO0O1.OooO0OO = h1VarOooO00o.OooOo0;
            oO0OoOO0.OooO0o oooO0o = new oO0OoOO0.OooO0o();
            oooO0o.OooO0OO = h1VarOooO00o.OooO0o0;
            oooO0o.OooO0Oo = h1VarOooO00o.OooO0o;
            oO0OoOO0.OooO0OO oooO0OO = new oO0OoOO0.OooO0OO();
            oooO0OO.OooO0Oo = h1VarOooO00o.OooO0oO;
            oooO0OO.OooO0o0 = h1VarOooO00o.OooO0oo;
            oooO0OO.OooO0o = h1VarOooO00o.OooOO0;
            oooO0OO.OooOoo0 = h1VarOooO00o.OooO;
            oooO0OO.OooO0oO = h1VarOooO00o.OooOO0O;
            oooO0OO.OooO0oo = h1VarOooO00o.OooO0Oo;
            oooO0OO.OooOO0 = h1VarOooO00o.OooOOO;
            oooO0OO.OooO = h1VarOooO00o.OooOOO0;
            oooO0OO.OooOO0O = h1VarOooO00o.OooOOOo;
            oooO0OO.OooOO0o = h1VarOooO00o.OooOOo0;
            oooO0OO.OooOOO0 = oooO0o;
            oooO0OO.OooOOO = h1VarOooO00o.OooOOo;
            oooO0OO.OooOOOO = h1VarOooO00o.OooOOoo;
            oooO0OO.OooOOOo = h1VarOooO00o.OooOo00;
            oooO0OO.OooO0OO = oooO0O1;
            oO0OoOO0 oo0oooo0 = new oO0OoOO0();
            oo0oooo0.OooO0OO = o00O0000.OooO0O0;
            oo0oooo0.OooO0Oo = oooO0O0;
            oo0oooo0.OooO0o0 = oooO0OO;
            oo0oooo0.OooO0o = System.currentTimeMillis() + "";
            oO0O0O00 oo0o0o00 = o0OOO0.OooO00o;
            if (oo0o0o00 == null || !oo0o0o00.OooO0oO) {
                str = " 扫包已关闭: ";
            } else {
                oo0oooo0.OooO0oo = (String[]) o0O0ooO.OooO0OO.toArray(oo0oooo0.OooO0oo);
                str = " mubixInstalledApps: " + o0O0ooO.OooO0OO;
            }
            ooooO000.OooO0O0("-----RequestAd ", str);
            o00O0 o00o0 = this.OooO0O0;
            oo0oooo0.OooO = o00o0.OooO00o;
            oo0oooo0.OooOO0 = oooO;
            o00O00O o00o00o = o00o0.OooO0OO;
            oo0oooo0.OooOO0O = o00o00o.OooO0O0;
            oo0oooo0.OooOO0o = o00o00o.OooOOOo;
            oo0oooo0.OooOOO0 = o00o0.OooO0Oo.OooO00o.slotId;
            oo0oooo0.OooO0oO = (oO0OoOO0.OooO00o[]) list.toArray(new oO0OoOO0.OooO00o[0]);
            o00O0 o00o1 = this.OooO0O0;
            oo0oooo0.OooOOO = o00o1.OooO0Oo.OooO0O0;
            oo0oO0 oo0oo0 = o00o1.OooOOo0;
            oo0oooo0.OooOOOo = oo0oo0.OooOOo;
            o00O00O o00o00o2 = o00o1.OooO0OO;
            oo0oooo0.OooOOOO = o00o00o2.OooOOo0;
            oo0oooo0.OooOOo0 = o00o00o2.OooOOo;
            oo0oooo0.OooOOo = oo0oo0.OooOOo0;
            if (oo00oVar.getBaseAdConfig().OooOO0o.OooOOoo > 0) {
                oo0oooo0.OooOo0 = oo00oVar.getBaseAdConfig().OooOO0o.OooOOoo;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.OooOOo0.OooOo0)) {
                oo0oooo0.OooOOoo = this.OooO0O0.OooOOo0.OooOo0;
            }
            if (!TextUtils.isEmpty(this.OooO0O0.OooOOo0.OooOo0O)) {
                oo0oooo0.OooOo00 = this.OooO0O0.OooOOo0.OooOo0O;
            }
            return oO0000O.OooO00o(oO0000O.OooO0O0(oOo0000O.OooO00o(oo0oooo0)));
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    private void OooO00o(o00O00O.OooO00o oooO00o, o00O000 o00o000) {
        this.OooO0O0.OooOOo0.OooOo.OooOO0O.put(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0, Long.valueOf(SystemClock.elapsedRealtime()));
        OooO00o(OooO00o(o00o000), true, o00o000, oooO00o.OooO0O0);
    }

    private void OooO00o(o00O o00o, boolean z, o00O000 o00o000, o00O00o0 o00o00o0) {
        if (OooO00o(this.OooO0O0)) {
            return;
        }
        OooO0OO oooO0OO = new OooO0OO(o00o000, o00o00o0, o00o);
        if (this.OooO0o.get() == null) {
            return;
        }
        ErrorInfo errorInfoOooO0O0 = OooO0O0(o00o000, o00o);
        if (errorInfoOooO0O0 != null) {
            OooO00o(this.OooO0o0, "【requestAdSource】 onPreRedirectFail:" + errorInfoOooO0O0.toString());
            OooO00o(this.OooO0O0, o00o000.OooO00o, errorInfoOooO0O0);
            errorInfoOooO0O0.preCheckPass = false;
            if (z) {
                oooO0OO.getTokenFail(errorInfoOooO0O0);
                return;
            } else {
                oooO0OO.onNoAdError(errorInfoOooO0O0);
                return;
            }
        }
        OooO00o(this.OooO0o0, "【requestAdSource】server bidding准备请求联盟：" + oO00000o.o0O0O00.OooO00o(o00o000.OooO00o.OooO0OO) + " slotId:" + o00o000.OooO00o.OooO0o0);
        o00o000.OooOO0o = this.OooO0O0.OooOOo0;
        if (z) {
            this.OooO.put(this.OooO0O0.OooO00o + o00o000.OooO00o.OooO0o0, o00o);
            o00o.getBidToken(this.OooO0o.get(), o00o000, oooO0OO);
        } else {
            try {
                o00o.innerLoad(this.OooO0o.get(), o00o000, oooO0OO);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public oO0OoOO0.OooO00o OooO0O0(oo00o oo00oVar) {
        oO0OoOO0.OooO00o oooO00o = new oO0OoOO0.OooO00o();
        oooO00o.OooO0OO = oo00oVar.getBaseAdConfig().OooO00o.OooO0o0;
        oooO00o.OooO0Oo = oo00oVar.getBaseAdConfig().OooO00o.OooO0OO;
        oooO00o.OooO0o0 = oo00oVar.getBaseAdConfig().OooO;
        oooO00o.OooO0o = oo00oVar.getBaseAdConfig().OooOOO;
        oooO00o.OooO0oO = oo00oVar.getBaseAdConfig().OooO00o.OooO0Oo;
        oooO00o.OooOO0O = oo00oVar.getBaseAdConfig().OooO00o.OooOOo;
        oooO00o.OooO0oo = 1;
        oooO00o.OooO = oO0000O.OooO0O0(oo00oVar.getBaseAdConfig().OooO00o.OooO0OO);
        oooO00o.OooOO0 = oo00oVar.getBaseAdConfig().OooO00o.OooOO0;
        return oooO00o;
    }

    public ErrorInfo OooO00o() {
        try {
            JSONObject jSONObject = new JSONObject(this.OooO0O0.OooOOO0);
            String strOptString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            ooooO000.OooO0Oo(this.OooO0o0, "biddingToken:" + this.OooO0O0.OooOOO0);
            String strOptString2 = jSONObject.optString("auction_price");
            oO0Oo0oo oo0oo0ooOooO0oO = oO0000O.OooO0oO(strOptString);
            if (oo0oo0ooOooO0oO != null) {
                if (!Objects.equals(oo0oo0ooOooO0oO.OooO, this.OooO0O0.OooO0OO.OooOOo0)) {
                    o0OO000.OooO00o(o0OO000o.o000OoOO, o0OO000.OooO0o0(this.OooO0O0.OooOOo0, oo0oo0ooOooO0oO.OooO0Oo[0].OooO0Oo + "", oo0oo0ooOooO0oO.OooO0Oo[0].OooO0OO), new Object[0]);
                }
                long j = oo0oo0ooOooO0oO.OooO0o;
                if (j != 200 && j != 0) {
                    return new ErrorInfo(o0OO000o.o00OO0OO, o0OO000o.o00OO0o0);
                }
                oO0o0o[] oo0o0oArr = oo0oo0ooOooO0oO.OooO0Oo;
                if (oo0o0oArr.length == 0) {
                    return new ErrorInfo(o0OO000o.o00OO0o, o0OO000o.o00OO0oO);
                }
                try {
                    oo0oO0.OooO0O0 oooO0O0 = this.OooO0O0.OooOOo0.OooOoO0;
                    oooO0O0.OooO00o = (int) oo0o0oArr[0].OooO0o0;
                    oooO0O0.OooO0O0 = oo0o0oArr[0].OooO0Oo;
                    oooO0O0.OooO0OO = oo0o0oArr[0].OooO0OO;
                    oooO0O0.OooO0Oo = oO0000O.OooO0O0(oo0o0oArr[0].OooO0Oo);
                    oo0oO0 oo0oo0 = this.OooO0O0.OooOOo0;
                    oo0oo0.OooOO0O = (int) oo0oo0ooOooO0oO.OooO0Oo[0].OooOO0O;
                    try {
                        oo0oo0.OooOO0o = Integer.parseInt(strOptString2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    oo0oO0 oo0oo1 = this.OooO0O0.OooOOo0;
                    long j2 = oo0oo1.OooOO0o;
                    if (j2 == 0 || j2 > oo0oo1.OooOO0O) {
                        oo0oo1.OooOO0o = oo0oo1.OooOO0O;
                        oo0oo1.OooOOO0 = 2;
                    }
                } catch (Exception e2) {
                    ooooO000.OooO00o(e2);
                }
                if (System.currentTimeMillis() > oo0oo0ooOooO0oO.OooO0Oo[0].OooO0oo * 1000) {
                    return new ErrorInfo(o0OO000o.o00OO0oo, o0OO000o.oo0O);
                }
                if (oO00000o.o00O0O.OooO00o != 0) {
                    return new ErrorInfo(o0OO000o.o0o0Oo, o0OO000o.o00OOO);
                }
                OooO00o oooO00o = new OooO00o();
                o00O o00oOooO00o = this.OooO.get(this.OooO0O0.OooO00o + oo0oo0ooOooO0oO.OooO0Oo[0].OooO0OO);
                if (o00oOooO00o == null) {
                    for (o00O000 o00o000 : this.OooO0O0.OooO0OO.OooO0oO.OooO00o) {
                        if (o00o000.OooO00o.OooO0o0.equals(oo0oo0ooOooO0oO.OooO0Oo[0].OooO0OO) && (o00oOooO00o = OooO00o(o00o000)) != null) {
                            o00oOooO00o.mBaseAdConfig = o00o000;
                        }
                    }
                }
                if (o00oOooO00o == null) {
                    return new ErrorInfo(o0OO000o.o00OO, o0OO000o.o00OOO00);
                }
                this.OooO0O0.OooOOo0.OooOo.OooO0o0.put(o00oOooO00o.mBaseAdConfig.OooO00o.OooO0Oo + o00oOooO00o.mBaseAdConfig.OooO00o.OooO0o0, Long.valueOf(SystemClock.elapsedRealtime()));
                this.OooO0O0.OooOOo0.OooOo.OooOO0 = SystemClock.elapsedRealtime();
                oooO00o.startCountDown4Unite(this.OooO0O0.OooO0OO.OooO00o);
                o00O000 o00o001 = o00oOooO00o.mBaseAdConfig;
                oO0o0o[] oo0o0oArr2 = oo0oo0ooOooO0oO.OooO0Oo;
                o00o001.OooOOOO = oo0o0oArr2[0].OooO0o;
                o00o001.OooOOOo = oo0o0oArr2[0].OooO0o0;
                o0OO000.OooO00o(o0OO000o.o00Oo00, o0OO000.OooO0Oo(this.OooO0O0.OooOOo0, o0OO000o.o00OOOO0, ""), new Object[0]);
                OooO00o(o00oOooO00o, false, o00oOooO00o.mBaseAdConfig, (o00O00o0) oooO00o);
                return null;
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
        return new ErrorInfo(o0OO000o.o00OO0O0, o0OO000o.o00OO0O);
    }

    public void OooO00o(o00O0 o00o0, o0O0o o0o0o) {
        try {
            this.OooO0O0 = o00o0;
            this.OooO0oO = o0o0o;
            this.OooO0oo = null;
            OooO0O0();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO0O0() {
        AtomicInteger atomicInteger = new AtomicInteger();
        ArrayList arrayList = new ArrayList();
        if (OooO00o(this.OooO0O0)) {
            return;
        }
        OooO00o(this.OooO0o0, "请求server bidding 广告层");
        this.OooO0O0.OooOOo0.OooOo.OooO0OO.put("biddingFloor", Long.valueOf(SystemClock.elapsedRealtime()));
        o00O00O.OooO00o oooO00o = this.OooO0O0.OooO0OO.OooO0oO;
        if (oooO00o == null) {
            return;
        }
        OooO00o(this.OooO0o0, "【server-biddingAdSources】准备请求单元，其中包含个数：" + oooO00o.OooO00o.size());
        oooO00o.OooO0O0 = new OooO0O0(atomicInteger, arrayList);
        Iterator<o00O000> it = oooO00o.OooO00o.iterator();
        while (it.hasNext()) {
            OooO00o(oooO00o, it.next());
        }
    }

    public void OooO0O0(o00O0 o00o0, o0O0o o0o0o) {
        try {
            this.OooO0O0 = o00o0;
            this.OooO0oO = o0o0o;
            this.OooO0oo = null;
            OooO0OO();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO0OO() {
        this.OooO0O0.OooOOo0.OooOo.OooO = SystemClock.elapsedRealtime();
        ErrorInfo errorInfoOooO00o = OooO00o();
        if (errorInfoOooO00o != null) {
            o0OO000.OooO00o(o0OO000o.o00Oo000, o0OO000.OooO0Oo(this.OooO0O0.OooOOo0, errorInfoOooO00o.code, errorInfoOooO00o.msg), new Object[0]);
            this.OooOO0.onCallbackNoAdError(errorInfoOooO00o);
        }
    }
}
