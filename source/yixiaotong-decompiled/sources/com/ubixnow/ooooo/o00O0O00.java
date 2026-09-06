package com.ubixnow.ooooo;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.stub.StubApp;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00O0O00 {
    public BaseDevConfig OooO00o;
    public Context OooO0O0;
    public o0O00o0 OooO0OO;
    public o00O0 OooO0Oo;
    private final o0oo0000 OooO0o = new OooO0OO();
    public oo0oO0 OooO0o0;

    public class OooO00o implements o0oo0000 {
        public OooO00o() {
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(o00O0 o00o0) {
            o00O0O00 o00o0o00 = o00O0O00.this;
            o00o0o00.OooO0OO.OooO0O0(o00o0o00.OooO0Oo);
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(oOO00OO ooo00oo) {
            o00O0O00.this.OooO0Oo.OooOOOo.onCallbackNoAdError(new ErrorInfo(ooo00oo.code, ooo00oo.msg));
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

    public class OooO0OO implements o0oo0000 {
        public OooO0OO() {
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(o00O0 o00o0) {
            o00O0O00.this.OooO0OO.OooO0O0(o00o0);
        }

        @Override // com.ubixnow.ooooo.o0oo0000
        public void OooO00o(oOO00OO ooo00oo) {
            o00O0 o00o0 = o00O0O00.this.OooO0Oo;
            if (o00o0 == null || o00o0.OooOOOo == null) {
                return;
            }
            ooooO000.OooO0O0("---请求失败：msg" + ooo00oo.msg);
            o00O0O00.this.OooO0Oo.OooOOOo.onCallbackNoAdError(new ErrorInfo(ooo00oo.code, ooo00oo.msg, ooo00oo.platFormCode, ooo00oo.platFormMsg));
        }
    }

    public o00O0O00(Context context, BaseDevConfig baseDevConfig) {
        this.OooO00o = baseDevConfig;
        this.OooO0O0 = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.OooO0OO = OooO00o(context);
    }

    private void OooO0Oo() {
        if (System.currentTimeMillis() - o0OOO0OO.OooO0Oo > oO00000o.o00O0O.OooO0oO * 1000) {
            new o0OOO0OO(3).OooO0O0();
        }
    }

    public o00O0 OooO00o() {
        return this.OooO0Oo;
    }

    public o00O0 OooO00o(String str) {
        o00O0 o00o0 = new o00O0();
        this.OooO0Oo = o00o0;
        if (this.OooO0O0 != null) {
            o00o0.OooOO0O = this.OooO0O0.hashCode() + "";
        }
        o00O0 o00o1 = this.OooO0Oo;
        o00O00 o00o00 = o00o1.OooO0Oo;
        o00o00.OooO00o = this.OooO00o;
        o00o00.OooO0O0 = str;
        o00o00.OooO0OO = 2;
        return o00o1;
    }

    public abstract o0O00o0 OooO00o(Context context);

    public void OooO00o(boolean z) {
        try {
            o00O0 o00o0 = this.OooO0Oo;
            if (o00o0 != null) {
                for (o00OOO00 o00ooo00 : o00o0.OooOOoo) {
                    if (z) {
                        o00ooo00.OooO0O0(this.OooO0Oo.OooO00o);
                    } else {
                        o00ooo00.OooO00o(this.OooO0Oo.OooO00o);
                    }
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO0O0() {
        oO0OOo0o oo0ooo0oOooO00o;
        this.OooO0o0.OooOo.OooO00o = SystemClock.elapsedRealtime();
        o00O0 o00o0 = this.OooO0Oo;
        if (o00o0 != null && o00o0.OooOOO == 2 && !TextUtils.isEmpty(o00o0.OooOOO0)) {
            try {
                oO0Oo0oo oo0oo0ooOooO0oO = oO0000O.OooO0oO(new JSONObject(this.OooO0Oo.OooOOO0).optString(CrashHianalyticsData.MESSAGE));
                if (oo0oo0ooOooO0oO != null && oo0oo0ooOooO0oO.OooO0OO.equals(this.OooO0Oo.OooO00o)) {
                    ooooO000.OooO0O0("---", "load cached server bidding ad!");
                    this.OooO0OO.OooO0O0(this.OooO0Oo);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        ooooO000.OooO0O0("---", "load ad!");
        h1.OooO0O0().OooO00o(true);
        ooo0Oo0 ooo0oo0 = new ooo0Oo0();
        byte[] bArrOooO0oo = oOo00o00.OooO0oo(this.OooO0Oo.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0Oo.OooO0Oo.OooO00o.slotId);
        if ((bArrOooO0oo != null && bArrOooO0oo.length > 0) || "1".equals(oOo00o00.OooO0o0(oO00000o.o00000O0.OooOoO + this.OooO0Oo.OooO0Oo.OooO00o.slotId)) || (oo0ooo0oOooO00o = oO0000O.OooO00o(this.OooO0Oo.OooO0Oo.OooO00o.slotId, UMNAdManager.localStrategyPath, o0O0ooO.OooO00o + ".ubix")) == null) {
            OooO0Oo();
            ooo0oo0.OooO0O0(this.OooO0Oo, this.OooO0o);
            h1.OooO0O0().OooO00o();
        } else {
            o00O0 o00o1 = this.OooO0Oo;
            o00o1.OooOOo0.OooOOo0 = 3;
            ooo0oo0.OooO00o(o00o1, oo0ooo0oOooO00o, true, (o0oo0000) new OooO00o());
            ooo0oo0.OooO0OO(this.OooO0Oo, new OooO0O0());
        }
    }

    public void OooO0O0(String str) {
        String str2;
        try {
            i1.OooOOoo();
            oo0oO0 oo0oo0 = new oo0oO0();
            this.OooO0o0 = oo0oo0;
            o00O0 o00o0 = this.OooO0Oo;
            oo0oo0.OooO0oO = o00o0.OooO00o;
            oo0oo0.OooO0O0 = str;
            oo0oo0.OooO0OO = o00o0.OooO0Oo.OooO0OO;
            oo0oo0.OooOo.OooO00o = SystemClock.elapsedRealtime();
            BaseDevConfig baseDevConfig = this.OooO0Oo.OooO0Oo.OooO00o;
            if (baseDevConfig != null && (str2 = baseDevConfig.slotId) != null) {
                this.OooO0o0.OooO00o = str2;
            }
            if (baseDevConfig != null) {
                this.OooO0o0.OooO0oo = oOo00o00.OooO00o(this.OooO0Oo.OooO0Oo.OooO00o.slotId + oO00000o.o00000O0.OooO0oo, 3000);
            }
            this.OooO0Oo.OooOOo0 = this.OooO0o0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OooO0OO() {
        this.OooO0O0 = null;
        this.OooO0Oo.OooOOoo.clear();
    }

    public void OooO0o0() {
        this.OooO0Oo.OooO0o0 = true;
    }
}
