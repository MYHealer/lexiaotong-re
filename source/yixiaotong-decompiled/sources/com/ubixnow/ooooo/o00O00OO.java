package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UMNError;
import com.ubixnow.core.api.getTokenStatusListener;
import com.ubixnow.core.bean.UMNEcpmInfo;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.utils.BaseUtils;
import com.ubixnow.utils.monitor.data.UbixDataContentProvider;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O00OO {
    public o00O0 ad;
    public o00O0O00 baseAdManager;
    public BaseDevConfig devConfig;
    private UMNEcpmInfo ecpmInfo = new UMNEcpmInfo();
    private boolean isLoad = false;
    public boolean isShow = false;

    public class OooO00o implements o0oo0000 {
        public final /* synthetic */ getTokenStatusListener OooO00o;

        /* JADX INFO: renamed from: com.ubixnow.ooooo.o00O00OO$OooO00o$OooO00o, reason: collision with other inner class name */
        public class C1138OooO00o implements OooO0OO {
            public final /* synthetic */ o00O0 OooO00o;

            public C1138OooO00o(o00O0 o00o0) {
                this.OooO00o = o00o0;
            }

            @Override // com.ubixnow.ooooo.o00O00OO.OooO0OO
            public void OooO00o(ErrorInfo errorInfo) {
                o0OO000.OooO00o(o0OO000o.o00OOoo, o0OO000.OooO00o(this.OooO00o.OooOOo0, o0OO000o.oo0oOO0, o0OO000o.o00O0Oo), new Object[0]);
                OooO00o.this.OooO00o.onError(new UMNError(o0OO000o.oo0oOO0, o0OO000o.o00O0Oo, errorInfo.code, errorInfo.msg));
            }

            @Override // com.ubixnow.ooooo.o00O00OO.OooO0OO
            public void onSucc(String str) {
                o0OO000.OooO00o(o0OO000o.o00OOooO, o0OO000.OooO0O0(this.OooO00o.OooOOo0, o0OO000o.o00O0Oo0, ""), new Object[0]);
                OooO00o.this.OooO00o.onSucc(str);
            }
        }

        public OooO00o(getTokenStatusListener gettokenstatuslistener) {
            this.OooO00o = gettokenstatuslistener;
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(o00O0 o00o0) {
            o00O00OO.this.baseAdManager.OooO00o(BaseUtils.getContext()).OooO00o(o00o0, new C1138OooO00o(o00o0));
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(oOO00OO ooo00oo) {
            getTokenStatusListener gettokenstatuslistener;
            UMNError uMNError;
            if (ooo00oo.code.equals(o0OO000o.OoooO0)) {
                o0OO000.OooO00o(o0OO000o.o00OOoo, o0OO000.OooO00o(o00O00OO.this.ad.OooOOo0, o0OO000o.o00O0oO, "sdk接入类型不一致"), new Object[0]);
                gettokenstatuslistener = this.OooO00o;
                uMNError = new UMNError(o0OO000o.o00O0oO, "sdk接入类型不一致");
            } else {
                o0OO000.OooO00o(o0OO000o.o00OOoo, o0OO000.OooO00o(o00O00OO.this.ad.OooOOo0, o0OO000o.o00O0oOo, o0OO000o.o00O0oo0), new Object[0]);
                gettokenstatuslistener = this.OooO00o;
                uMNError = new UMNError(o0OO000o.o00O0oOo, o0OO000o.o00O0oo0);
            }
            gettokenstatuslistener.onError(uMNError);
        }
    }

    public class OooO0O0 implements o0oo0000 {
        public OooO0O0() {
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(o00O0 o00o0) {
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(oOO00OO ooo00oo) {
        }
    }

    public interface OooO0OO {
        void OooO00o(ErrorInfo errorInfo);

        void onSucc(String str);
    }

    public UMNError checkParams() {
        if (oO00000o.o00O0O.OooO00o != 0) {
            return new UMNError(o0OO000o.o00O0OoO, "SDK开关关闭");
        }
        if (TextUtils.isEmpty(this.devConfig.slotId)) {
            return new UMNError(o0OO000o.o00O0o00, "广告位不应为空");
        }
        if (UMNAdManager.isInit) {
            return null;
        }
        return new UMNError(o0OO000o.o00O0o0, "聚合SDK未初始化");
    }

    public void getBiddingToken(getTokenStatusListener gettokenstatuslistener) {
        if (SystemClock.elapsedRealtime() - UbixDataContentProvider.OooO0O0 > 6000) {
            this.ad.OooOOo0.OooOOoo = 1;
        } else {
            this.ad.OooOOo0.OooOOoo = 2;
        }
        this.ad.OooOOo0.OooOo.OooO0oo = SystemClock.elapsedRealtime();
        o00O0 o00o0 = this.ad;
        oo0oO0 oo0oo0 = o00o0.OooOOo0;
        oo0oo0.OooOOOo = 2;
        o00o0.OooOOO = 2;
        o0OO000.OooO00o(o0OO000o.o00OOOoO, o0OO000.OooO00o(oo0oo0), new Object[0]);
        UMNError uMNErrorCheckParams = checkParams();
        if (uMNErrorCheckParams != null) {
            o0OO000.OooO00o(o0OO000o.o00OOoo, o0OO000.OooO00o(this.ad.OooOOo0, uMNErrorCheckParams.code, uMNErrorCheckParams.msg), new Object[0]);
            gettokenstatuslistener.onError(uMNErrorCheckParams);
            return;
        }
        ooo0Oo0 ooo0oo0 = new ooo0Oo0();
        oO0OOo0o oo0ooo0oOooO00o = ooo0oo0.OooO00o(this.devConfig.slotId);
        if (oo0ooo0oOooO00o != null) {
            ooooO000.OooO0O0("---server-bidding", "use online strategy！");
            this.ad.OooOOo0.OooOOo0 = 1;
        } else {
            if ("1".equals(oOo00o00.OooO0o0(oO00000o.o00000O0.OooOoO + this.devConfig.slotId)) || (oo0ooo0oOooO00o = oO0000O.OooO00o(this.devConfig.slotId, UMNAdManager.localStrategyPath, o0O0ooO.OooO00o + ".ubix")) == null) {
                oo0oO0 oo0oo1 = this.ad.OooOOo0;
                oo0oo1.OooOOo0 = 0;
                o0OO000.OooO00o(o0OO000o.OooOooO, o0OO000.OooO0OO(oo0oo1, o0OO000o.Oooo, o0OO000o.OoooO00), new Object[0]);
                o0OO000.OooO00o(o0OO000o.o00OOoo, o0OO000.OooO00o(this.ad.OooOOo0, o0OO000o.o00O0o0o, o0OO000o.o00O0o), new Object[0]);
                gettokenstatuslistener.onError(new UMNError(o0OO000o.o00O0o0o, o0OO000o.o00O0o));
                updateStrategy(ooo0oo0);
                return;
            }
            ooooO000.OooO0O0("---server-bidding", "use pre strategy！");
            this.ad.OooOOo0.OooOOo0 = 3;
        }
        ooo0oo0.OooO00o(this.ad, oo0ooo0oOooO00o, true, (o0oo0000) new OooO00o(gettokenstatuslistener));
        updateStrategy(ooo0oo0);
    }

    public UMNEcpmInfo getEcpmInfo() {
        return this.ecpmInfo;
    }

    public String getRequestId() {
        o00O0 o00o0 = this.ad;
        return o00o0 != null ? o00o0.OooO00o : "";
    }

    public String[] isCanLoadAd(oo0oO0 oo0oo0) {
        requestStart(oo0oo0);
        String[] strArr = new String[2];
        if (this.isLoad) {
            ooooO000.OooO0O0("一个广告对象只能请求一次");
            strArr[0] = o0OO000o.OooOOo0;
            strArr[1] = o0OO000o.OooOOo;
        } else if (TextUtils.isEmpty(oo0oo0.OooO00o)) {
            ooooO000.OooO0O0("广告位为空");
            strArr[0] = o0OO000o.OooOo0;
            strArr[1] = "广告位不应为空";
        } else if (!UMNAdManager.isInit) {
            ooooO000.OooO0O0("加载广告前请,请先初始化SDK");
            strArr[0] = o0OO000o.OooOo0o;
            strArr[1] = "聚合SDK未初始化";
        } else if (oO00000o.o00O0O.OooO00o != 0) {
            strArr[0] = o0OO000o.OooOOoo;
            strArr[1] = o0OO000o.o0000o;
        }
        if (TextUtils.isEmpty(strArr[0])) {
            this.isLoad = true;
            return null;
        }
        HashMap map = new HashMap();
        map.put(o0OO000o.o000o0oo, strArr[0]);
        map.put(o0OO000o.o000o00, oo0oo0.OooO0oO);
        map.put(o0OO000o.o000OooO, oo0oo0.OooO00o);
        map.put("ad_type", oo0oo0.OooO0O0);
        map.put(o0OO000o.o000oo0o, strArr[1]);
        if (oo0oo0.OooOOoo > 0) {
            map.put(o0OO000o.o00Oo0oo, oo0oo0.OooOOoo + "");
        }
        if (!o0OO000o.OooOo0o.equals(strArr[0])) {
            o0OO000.OooO00o(o0OO000o.OooOOO, map, new Object[0]);
        }
        return strArr;
    }

    public void requestStart(oo0oO0 oo0oo0) {
        if (oo0oo0.OooOOOo != 2) {
            o0OO000.OooO00o(o0OO000o.OooOO0o, o0OO000.OooO0Oo(oo0oo0, o0OO000o.OooOOO0), new Object[0]);
        }
    }

    public void setBiddingToken(String str) {
        o00O0 o00o0 = this.ad;
        if (o00o0 != null) {
            o00o0.OooOOo0.OooOOOo = 2;
            o00o0.OooOOO = 2;
            o00o0.OooOOO0 = str;
        }
    }

    public void updateStrategy(ooo0Oo0 ooo0oo0) {
        ooo0oo0.OooO0OO(this.ad, new OooO0O0());
    }
}
