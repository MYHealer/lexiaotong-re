package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.ubixnow.core.api.UMNAdConfig;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UMNConfigUserInfo;
import com.ubixnow.utils.BaseUtils;
import java.net.HttpURLConnection;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OOOO00 extends a1 {
    private UMNAdConfig OooO0o;
    private o00O0 OooO0oO;
    private int OooO0oo;

    public o0OOOO00(o00O0 o00o0, int i) {
        super(a1.OooO0O0.Post);
        this.OooO0o = UMNAdManager.getInstance().getConfig();
        this.OooO0oO = o00o0;
        this.OooO0oo = i;
    }

    private void OooO00o(oO0O00o0 oo0o00o0) {
        byte[] bArrOooO0Oo;
        try {
            if (this.OooO0oo != 1 || (bArrOooO0Oo = o0O00O.OooO00o().OooO0Oo(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.Oooo0O0)) == null || bArrOooO0Oo.length <= 0) {
                return;
            }
            oo0o00o0.OooOOO0 = new String(bArrOooO0Oo);
        } catch (Exception unused) {
        }
    }

    private ooOOOOoo.OooO0OO[] OooO0o() {
        int i = this.OooO0oo;
        if (i == 1) {
            List<ooOOOOoo.OooO0OO> listOooO0O0 = o0O00O.OooO00o().OooO0O0(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.OooOoO0);
            if (listOooO0O0 == null || listOooO0O0.isEmpty()) {
                return null;
            }
            return (ooOOOOoo.OooO0OO[]) listOooO0O0.toArray(new ooOOOOoo.OooO0OO[0]);
        }
        if (i != 2 || this.OooO0oO == null) {
            return null;
        }
        ooOOOOoo.OooO0OO oooO0OO = new ooOOOOoo.OooO0OO();
        o00O0 o00o0 = this.OooO0oO;
        oooO0OO.OooO0OO = o00o0.OooO0Oo.OooO00o.slotId;
        int i2 = o00o0.OooOOo0.OooOOoo;
        if (i2 > 0) {
            oooO0OO.OooOO0O = i2;
        }
        byte[] bArrOooO0oO = oOo00o00.OooO0oO(this.OooO0oO.OooO0O0.appId + oO00000o.o00000O0.OooOoO0 + this.OooO0oO.OooO0Oo.OooO00o.slotId);
        if (bArrOooO0oO != null && bArrOooO0oO.length > 0) {
            try {
                oooO0OO.OooOO0o = oO00OOO.OooO00o(bArrOooO0oO).OooO0o;
            } catch (Exception unused) {
            }
        }
        o00O0 o00o1 = this.OooO0oO;
        oooO0OO.OooOOO0 = o00o1.OooO00o;
        oooO0OO.OooOO0 = oO0000O.OooO0OO(o00o1.OooO0Oo.OooO0O0);
        return new ooOOOOoo.OooO0OO[]{oooO0OO};
    }

    private oO0O00o0 OooO0o0() {
        h1 h1VarOooO00o = h1.OooO0O0().OooO00o(false);
        ooOOOOoo.OooO00o oooO00o = new ooOOOOoo.OooO00o();
        oooO00o.OooO0OO = this.OooO0o.appId;
        oooO00o.OooO0Oo = BaseUtils.getContext().getPackageName();
        oooO00o.OooO0o0 = h1VarOooO00o.OooOo0O;
        oooO00o.OooO0o = this.OooO0o.channel;
        oooO00o.OooO0oO = h1VarOooO00o.OooOo;
        ooOOOOoo.OooOO0 oooOO0 = new ooOOOOoo.OooOO0();
        UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
        if (uMNConfigUserInfo != null) {
            oooOO0.OooO0Oo = uMNConfigUserInfo.getChannel();
            oooOO0.OooO0OO = o0O0ooO.OooO0o0.getUserId();
            oooOO0.OooO0o = o0O0ooO.OooO0o0.getSubScriber();
            oooOO0.OooO0o0 = o0O0ooO.OooO0o0.getSubChannel();
            oooOO0.OooO0oO = o0O0ooO.OooO0o0.getPubSegmentId();
            if (o0O0ooO.OooO0o0.getCustomUserInfo() != null && o0O0ooO.OooO0o0.getCustomUserInfo().size() > 0) {
                oooOO0.OooO0oo = new JSONObject(o0O0ooO.OooO0o0.getCustomUserInfo()).toString();
            }
        }
        oO000Oo0 oo000oo0 = new oO000Oo0();
        oo000oo0.OooO0oo = h1VarOooO00o.OooO0OO;
        oo000oo0.OooO0oO = h1VarOooO00o.OooO0O0;
        ooOOOOoo.OooO oooO = new ooOOOOoo.OooO();
        oooO.OooO0OO = h1VarOooO00o.OooO0o0;
        oooO.OooO0Oo = h1VarOooO00o.OooO0o;
        ooOOOOoo.OooO0O0 oooO0O0 = new ooOOOOoo.OooO0O0();
        oooO0O0.OooO0Oo = h1VarOooO00o.OooO0oO;
        oooO0O0.OooO0o0 = h1VarOooO00o.OooO0oo;
        oooO0O0.OooO0o = h1VarOooO00o.OooOO0;
        oooO0O0.OooOoo0 = h1VarOooO00o.OooO;
        oooO0O0.OooO0oO = h1VarOooO00o.OooOO0O;
        oooO0O0.OooO0oo = h1VarOooO00o.OooO0Oo;
        oooO0O0.OooOO0 = h1VarOooO00o.OooOOO;
        oooO0O0.OooO = h1VarOooO00o.OooOOO0;
        oooO0O0.OooOO0O = h1VarOooO00o.OooOOOo;
        oooO0O0.OooOO0o = h1VarOooO00o.OooOOo0;
        oooO0O0.OooOOO0 = oooO;
        oooO0O0.OooOOO = h1VarOooO00o.OooOOo;
        oooO0O0.OooOOOO = h1VarOooO00o.OooOOoo;
        oooO0O0.OooOOOo = h1VarOooO00o.OooOo00;
        oooO0O0.OooO0OO = oo000oo0;
        oO0O00o0 oo0o00o0 = new oO0O00o0();
        oo0o00o0.OooO0OO = o00O0000.OooO0O0;
        oo0o00o0.OooO0Oo = oooO00o;
        oo0o00o0.OooO0o0 = oooO0O0;
        oo0o00o0.OooO0o = this.OooO0oo;
        oo0o00o0.OooO0oO = System.currentTimeMillis() + "";
        oO0O0O00 oo0o0o00 = o0OOO0.OooO00o;
        if (oo0o0o00 != null && oo0o0o00.OooO0oO) {
            oo0o00o0.OooOO0 = (String[]) o0O0ooO.OooO0OO.toArray(oo0o00o0.OooOO0);
            ooooO000.OooO0O0("-----RequestAd ", " mubixInstalledApps: " + o0O0ooO.OooO0OO);
        }
        oo0o00o0.OooOO0O = oooOO0;
        oo0o00o0.OooOO0o = TextUtils.isEmpty(oO00000o.o00O0O.OooOOo0) ? oOo00o00.OooO0o0(oO00000o.o00000O0.OooOOo0) : oO00000o.o00O0O.OooOOo0;
        ooOOOOoo.OooO0OO[] oooO0OOArrOooO0o = OooO0o();
        if (oooO0OOArrOooO0o != null && oooO0OOArrOooO0o.length > 0) {
            oo0o00o0.OooO0oo = oooO0OOArrOooO0o;
        }
        OooO00o(oo0o00o0);
        if (ooooO000.OooO00o) {
            ooooO000.OooO0O0("----广告请求参数", "-----Request: " + oO0Oo0o0.OooO0O0().OooO0O0(oOo0000O.OooO00o(oo0o00o0)));
        }
        return oo0o00o0;
    }

    @Override // com.ubixnow.ooooo.e1
    public e1.OooO00o OooO00o() {
        return e1.OooO00o.ADD_NEW;
    }

    @Override // com.ubixnow.ooooo.a1
    public void OooO0O0(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuf");
        httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
        o00O0 o00o0 = this.OooO0oO;
        if (o00o0 != null) {
            httpURLConnection.setRequestProperty("UbiX-Trace-ID", o00o0.OooO00o);
        }
        httpURLConnection.setRequestProperty("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
        httpURLConnection.setRequestProperty("U-SEC-Encoding", "base64");
    }

    @Override // com.ubixnow.ooooo.a1
    public byte[] OooO0OO() {
        return oO0000O.OooO0O0(oO0Oo0o0.OooO0O0().OooO00o(oOo0000O.OooO00o(OooO0o0())));
    }

    @Override // com.ubixnow.ooooo.a1
    public String OooO0Oo() throws Exception {
        return oO00000o.OooO00o.OooO00o + oO00000o.OooO00o.OooOO0;
    }

    @Override // com.ubixnow.ooooo.e1
    public String getName() {
        return getClass().getSimpleName();
    }
}
