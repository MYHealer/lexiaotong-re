package com.adprof.sdk;

import android.text.TextUtils;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.BannerAd;
import com.adprof.sdk.api.IBiddingNotify;
import com.adprof.sdk.api.InterstitialAd;
import com.adprof.sdk.api.NativeAd;
import com.adprof.sdk.api.RewardAd;
import com.adprof.sdk.api.SplashAd;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class h implements IBiddingNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AdRequest f1199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p5 f325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i2 f324a = i2.AdStatusNone;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q1.a f326a = new g(this);

    public h(AdRequest adRequest) {
        this.f1199a = adRequest;
        if (adRequest != null) {
            this.f327a = adRequest.getCodeId();
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0182  */
    /* JADX WARN: Code duplicated, block: B:74:0x022e  */
    public AdError a() {
        String str;
        int i;
        int i2;
        long j;
        int i3;
        long j2;
        int i4;
        y0 y0Var;
        y0 y0Var2;
        y0 y0Var3;
        String string;
        AdRequest adRequest = this.f1199a;
        if (adRequest == null || TextUtils.isEmpty(adRequest.getCodeId())) {
            pk.b("PlacementId with AdRequest can't is null");
            return AdError.ERROR_AD_CODE_ID_EMPTY;
        }
        String strTrim = this.f1199a.getCodeId().trim();
        if (!TextUtils.isDigitsOnly(strTrim)) {
            pk.b("PlacementId format invalid: " + strTrim);
            return AdError.ERROR_AD_BAD_REQUEST;
        }
        if (!AdprofSdk.getInstance().isInit()) {
            pk.b("GtAdSdk not initialize");
            return AdError.ERROR_AD_NOT_INIT;
        }
        if (this.f324a == i2.AdStatusLoading) {
            pk.b("Ad is Loading");
            return AdError.ERROR_AD_LOAD_FAIL_LOADING;
        }
        String codeId = this.f325a.f1357a.getCodeId();
        Integer intOrNull = (codeId == null || (string = StringsKt.trim((CharSequence) codeId).toString()) == null) ? null : StringsKt.toIntOrNull(string);
        if (intOrNull == null) {
            pk.b("allowAdxRequest invalid slotId: " + codeId);
            return null;
        }
        e2 e2VarA = d1.f1121a.a().a(intOrNull.intValue());
        int i5 = (e2VarA == null || (y0Var3 = e2VarA.f230a) == null) ? 0 : y0Var3.f1529a;
        int i6 = (e2VarA == null || (y0Var2 = e2VarA.f230a) == null) ? 0 : y0Var2.b;
        int i7 = (e2VarA == null || (y0Var = e2VarA.f230a) == null) ? 0 : y0Var.c;
        String string2 = sl.a().getString("req_count_" + codeId, "");
        m1 m1Var = new m1(0, 0, 0, 0L, 0L, 0L, 0, 0, 255);
        pk.a("value=" + string2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(string2)) {
            str = "_";
            i = 5;
            i2 = 2;
            j = 0;
            i3 = 0;
        } else {
            Intrinsics.checkNotNull(string2);
            if (StringsKt.contains$default((CharSequence) string2, (CharSequence) "_", false, 2, (Object) null)) {
                str = "_";
                i2 = 2;
                List listSplit$default = StringsKt.split$default((CharSequence) string2, new String[]{"_"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 2) {
                    j = Long.parseLong((String) listSplit$default.get(0));
                    i3 = Integer.parseInt((String) listSplit$default.get(1));
                    Calendar calendar = Calendar.getInstance();
                    i5 = i5;
                    calendar.setTimeInMillis(jCurrentTimeMillis);
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTimeInMillis(j);
                    if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2)) {
                        i = 5;
                        if (calendar.get(5) != calendar2.get(5)) {
                        }
                    } else {
                        i = 5;
                    }
                    i3 = 0;
                } else {
                    i = 5;
                }
            } else {
                str = "_";
                i = 5;
                i2 = 2;
            }
            j = 0;
            i3 = 0;
        }
        m1Var.f458c = j;
        m1Var.d = i3;
        String string3 = sl.a().getString("show_count_" + codeId, "");
        m1 m1Var2 = new m1(0, 0, 0, 0L, 0L, 0L, 0, 0, 255);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (TextUtils.isEmpty(string3)) {
            j2 = 0;
            i4 = 0;
        } else {
            Intrinsics.checkNotNull(string3);
            if (StringsKt.contains$default((CharSequence) string3, (CharSequence) str, false, i2, (Object) null)) {
                List listSplit$default2 = StringsKt.split$default((CharSequence) string3, new String[]{str}, false, 0, 6, (Object) null);
                if (listSplit$default2.size() == i2) {
                    j2 = Long.parseLong((String) listSplit$default2.get(0));
                    i4 = Integer.parseInt((String) listSplit$default2.get(1));
                    Calendar calendar3 = Calendar.getInstance();
                    calendar3.setTimeInMillis(jCurrentTimeMillis2);
                    Calendar calendar4 = Calendar.getInstance();
                    calendar4.setTimeInMillis(j2);
                    if (calendar3.get(1) != calendar4.get(1) || calendar3.get(i2) != calendar4.get(i2) || calendar3.get(i) != calendar4.get(i)) {
                    }
                } else {
                    j2 = 0;
                }
                i4 = 0;
            } else {
                j2 = 0;
                i4 = 0;
            }
        }
        m1Var2.f457b = j2;
        m1Var2.e = i4;
        int i8 = i5;
        pk.a("slotId=" + codeId + ", impFreqByDay=" + i6 + ", reqFreq=" + i8 + ", minImpInterval=" + i7 + ", ");
        if (pk.f594a) {
            pk.a("reqRecord=" + m1Var);
            pk.a("showRecord=" + m1Var2);
        }
        if ((i8 <= 0 || m1Var.d < i8) && ((i6 <= 0 || m1Var2.e < i6) && (i7 <= 0 || System.currentTimeMillis() - m1Var2.f457b >= i7 * 1000))) {
            return null;
        }
        pk.a("不满足频控");
        wd wdVar = new wd();
        wdVar.f795a = this.f1199a.getCodeId();
        oh.a("frequency", "", null, wdVar, null);
        return AdError.ERROR_AD_FREQUENCY;
    }

    public i2 getAdStatus() {
        p5 p5Var = this.f325a;
        return p5Var != null ? p5Var.f548a : this.f324a;
    }

    public int getBidPrice() {
        pk.a(getClass().getSimpleName() + "----getBidPrice" + this.f325a);
        p5 p5Var = this.f325a;
        if (p5Var != null) {
            return p5Var.getBidPrice();
        }
        return 0;
    }

    public String getBidToken() {
        AdRequest adRequest;
        String str = "";
        try {
            if (AdprofSdk.getInstance().isInit() && (adRequest = this.f1199a) != null && !TextUtils.isEmpty(adRequest.getCodeId())) {
                p5 p5Var = this.f325a;
                if (p5Var != null) {
                    wd wdVar = p5Var.f549a;
                    if (wdVar != null) {
                        if (TextUtils.isEmpty(wdVar.f797b)) {
                            String string = UUID.randomUUID().toString();
                            p5Var.b = string;
                            p5Var.f549a.f797b = string;
                        } else {
                            p5Var.b = p5Var.f549a.f797b;
                        }
                    }
                    d dVarA = this.f325a.a();
                    if (dVarA != null) {
                        String str2 = dVarA.f198b;
                        if (str2 == null) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            return str2;
                        }
                    }
                    wd wdVar2 = this.f325a.f549a;
                    if (wdVar2 != null) {
                        oh.a("gettoken", "", null, wdVar2, null);
                        String str3 = wdVar2.f798c;
                        if (!TextUtils.isEmpty(str3)) {
                            return str3;
                        }
                        try {
                            str = new ha(wdVar2).a(System.currentTimeMillis()).b;
                            return str;
                        } catch (Throwable th) {
                            pk.a(th);
                            return "";
                        }
                    }
                }
                return str;
            }
            return "";
        } catch (Throwable th2) {
            pk.a(th2);
            oh.b(th2);
        }
    }

    public Map<String, Object> getExtraInfo() {
        p5 p5Var = this.f325a;
        if (p5Var == null) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        map.put("codeId", p5Var.f550a);
        map.put("loadId", p5Var.b);
        return map;
    }

    public void setBidResponse(String str) {
        AdRequest adRequest;
        int i;
        try {
            p5 p5Var = this.f325a;
            AdRequest adRequest2 = p5Var != null ? p5Var.f1357a : null;
            if (adRequest2 == null) {
                adRequest2 = this.f1199a;
            }
            if (adRequest2 != null) {
                adRequest2.setS2sBidResponse(str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            p5 p5Var2 = this.f325a;
            wd wdVar = p5Var2 != null ? p5Var2.f549a : null;
            if (wdVar == null && (adRequest = this.f1199a) != null) {
                if (this instanceof BannerAd) {
                    i = 3;
                } else if (this instanceof NativeAd) {
                    i = 1;
                } else if (this instanceof SplashAd) {
                    i = 2;
                } else if (this instanceof RewardAd) {
                    i = 5;
                } else {
                    boolean z = this instanceof InterstitialAd;
                    i = 4;
                }
                wdVar = new wd(adRequest, i);
            }
            if (wdVar != null) {
                oh.a("setresponse", "", null, wdVar, null);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }
}
