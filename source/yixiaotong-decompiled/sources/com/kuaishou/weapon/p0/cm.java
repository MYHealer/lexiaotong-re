package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.kuaishou.weapon.p0.jni.Engine;
import com.masget.base.AppConfig;
import com.unionpay.tsmservice.data.Constant;
import com.yfanads.android.model.YFAdError;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4675a;

    public cm(Context context) {
        this.f4675a = context;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        JSONObject jSONObjectA2;
        try {
            ck ckVar = new ck(str, ci.j);
            String strA = dj.a(cs.f4682a);
            String strB = b(strA);
            if (TextUtils.isEmpty(strB) || (jSONObjectA = ckVar.a(this.f4675a)) == null) {
                return null;
            }
            String str2 = cs.h + "?" + ct.a(this.f4675a);
            if (cs.a() && cs.f4682a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", strB);
            jSONObject.put("host", strA);
            jSONObject.put("path", str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put(AppConfig.CONF_COOKIE, str3);
            }
            jSONObject.put(TtmlNode.TAG_HEAD, jSONObjectA);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(ci.i) && (jSONObjectA2 = a()) != null) {
                jSONObject.put("sjd", jSONObjectA2);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONObject a() throws JSONException {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.f4675a, "re_po_rt");
            hVarA.e("a1_p_s_p_s");
            hVarA.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f4675a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put("24", ajVar.e());
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, ab.b() ? 1 : 0);
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, ab.a(this.f4675a) ? 1 : 0);
            Object objA = ai.a(this.f4675a);
            if (objA != null) {
                jSONObject.put("4", objA);
            }
            hVarA.b(dd.ac, 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean zA = acVar.a(this.f4675a);
            jSONObject.put("8", zA ? 1 : 0);
            if (zA) {
                jSONObject.put("61", acVar.b(this.f4675a));
            }
            jSONObject.put("10", acVar.e(this.f4675a));
            jSONObject.put("11", acVar.c(this.f4675a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean zB = aoVar.b();
            jSONObject.put("66", zB ? 1 : 0);
            if (zB) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put(PPSLauncherActivity.Code, aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put(YFAdError.ERROR_DEFAULT, new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bt.a(this.f4675a));
            jSONObject2.put("03014", bf.g(this.f4675a));
            jSONObject2.put("03020", bt.b(this.f4675a));
            jSONObject2.put("03030", be.d(this.f4675a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put(BiddingConst.ADN_ID.VIVO, new an().d());
            jSONObject.put(Constant.TRANS_TYPE_LOAD, ab.b(this.f4675a) ? 1 : 0);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bf.c(com.kwad.sdk.e.b.QY().QX()));
                jSONObject.put("11302", bf.c(com.kwad.sdk.e.b.QY().getSdkVersion()));
                jSONObject.put("11303", bf.c(com.kwad.sdk.e.b.QY().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dj.a(str)).getHostAddress();
            try {
                return (TextUtils.isEmpty(hostAddress) || !hostAddress.contains(".")) ? "" : hostAddress;
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }
}
