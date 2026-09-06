package com.adprof.sdk;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.adprof.sdk.api.AdError;
import com.adprof.sdk.api.AdRequest;
import com.adprof.sdk.api.IBiddingNotify;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class p5 implements IBiddingNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdRequest f1357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fn.a f547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i2 f548a = i2.AdStatusNone;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd f549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f550a;
    public String b;

    public p5(AdRequest adRequest) {
        this.f1357a = adRequest;
        this.f550a = adRequest.getCodeId();
    }

    public d a() {
        return this.f546a;
    }

    public void a(int i, String str) {
        pk.c("---onErrorResponse: " + getClass().getSimpleName() + PPSLabelView.Code + i + PPSLabelView.Code + str);
        AdError adError = AdError.getAdError(i);
        if (adError == null) {
            adError = AdError.ERROR_AD_REQUEST;
            adError.setMessage("code:" + i + "msg: " + str);
        } else if (!TextUtils.isEmpty(str)) {
            adError.setMessage(str);
        }
        a(adError, true, "respond");
    }

    public abstract void a(int i, String str, String str2, wd wdVar);

    public void a(long j) {
        this.f548a = i2.AdStatusLoading;
        he.f348b = true;
        he heVarM644a = he.m644a();
        heVarM644a.getClass();
        long j2 = sl.a().getLong("install_time", 0L);
        heVarM644a.f349a = j2;
        if (j2 == 0) {
            PackageInfo packageInfoA = r3.a(AdprofSdk.getInstance().getContext());
            heVarM644a.f349a = packageInfoA == null ? System.currentTimeMillis() : packageInfoA.firstInstallTime;
            long j3 = heVarM644a.f349a;
            SharedPreferences.Editor editorEdit = sl.a().edit();
            editorEdit.putLong("install_time", j3);
            editorEdit.commit();
        }
        this.f547a = fn.a(new o5(this), j);
        wd wdVar = this.f549a;
        if (wdVar == null) {
            return;
        }
        if (TextUtils.isEmpty(wdVar.f797b)) {
            String string = UUID.randomUUID().toString();
            this.b = string;
            this.f549a.f797b = string;
        } else {
            this.b = this.f549a.f797b;
        }
        pk.c(getClass().getSimpleName() + "---loadAd--timeout = " + j + "   loadid = " + this.f549a.f797b);
        a(this.f549a);
        new ha(this.f549a).a(this);
    }

    public void a(Activity activity) {
    }

    public abstract void a(AdError adError);

    public void a(d dVar, String str) {
    }

    public abstract void a(List list, wd wdVar);

    public boolean a(AdError adError, boolean z, String str) {
        pk.d("---handleError adStatus = " + this.f548a + " category: " + str + "  error = " + adError.getMessage() + PPSLabelView.Code);
        if (z && this.f548a == i2.AdStatusReady) {
            return false;
        }
        i2 i2Var = this.f548a;
        i2 i2Var2 = i2.AdStatusSuc;
        if (i2Var == i2Var2 && (this instanceof df)) {
            return false;
        }
        if ((i2Var == i2.AdStatusLoading || i2Var == i2Var2) && "respond_timeout".equals(str)) {
            return true;
        }
        if ("respond_timeout".equals(str)) {
            return false;
        }
        oh.a(str, adError, this.f549a, this.f546a);
        this.f548a = i2.AdStatusNone;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m699a(d dVar, String str) {
        pk.d("---onCacheEnd: " + getClass().getSimpleName() + PPSLabelView.Code + str);
        if (TextUtils.isEmpty(str)) {
            this.f548a = i2.AdStatusReady;
            oh.a("ready", "", dVar, this.f549a, null);
            return true;
        }
        AdError adError = AdError.ERROR_AD_FILE_DOWNLOAD;
        adError.setMessage(str);
        a(adError, true, "respond_cacheend_error");
        return false;
    }

    public void b(Activity activity) {
    }

    public int getBidPrice() {
        d dVar = this.f546a;
        if (dVar != null) {
            return dVar.b;
        }
        return 0;
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public final void sendLossNotify(Map map) {
        d dVar = this.f546a;
        try {
            if (dVar == null) {
                return;
            }
            try {
                if (dVar.m591a() != null) {
                    this.f546a.m591a().a(this.f546a, map);
                }
            } catch (Throwable th) {
                pk.a(th);
                oh.b(th);
            }
            kl klVarMo698a = mo698a();
            if (klVarMo698a != null) {
                d dVar2 = this.f546a;
                if (map == null) {
                    map = new HashMap();
                }
                ((a2) klVarMo698a).a(dVar2, "lose", map);
            }
        } catch (Throwable th2) {
            pk.a(th2);
            oh.b(th2);
        }
    }

    @Override // com.adprof.sdk.api.IBiddingNotify
    public final void sendWinNotify(Map map) {
        d dVar;
        kl klVarMo698a = mo698a();
        if (klVarMo698a == null || (dVar = this.f546a) == null) {
            return;
        }
        ((a2) klVarMo698a).a(dVar, "win", map);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public kl mo698a() {
        d dVar = this.f546a;
        if (dVar == null) {
            return null;
        }
        kl klVar = dVar.f185a;
        if (klVar != null) {
            return klVar;
        }
        a2 a2Var = new a2();
        a2Var.a(dVar);
        return a2Var;
    }

    public boolean a(d dVar) {
        if (dVar != null && (dVar.m603d() || dVar.m605f())) {
            pk.d("-----onSuccess: " + getClass().getSimpleName() + PPSLabelView.Code + dVar.m603d() + PPSLabelView.Code + dVar.m605f() + PPSLabelView.Code + dVar);
            this.f546a = dVar;
            this.f548a = i2.AdStatusSuc;
            dVar.f197a = true;
            HashMap map = new HashMap();
            wd wdVar = this.f549a;
            try {
                fh fhVar = new fh();
                ((mh) fhVar).f468b = "100";
                if (wdVar != null && wdVar.f793a > 0) {
                    fhVar.f294a = System.currentTimeMillis() - wdVar.f793a;
                    wdVar.f793a = System.currentTimeMillis();
                }
                fhVar.a("respond");
                oh.a(dVar, fhVar);
                oh.a(wdVar, fhVar);
                oh.a(fhVar);
                if (!map.isEmpty()) {
                    ((mh) fhVar).f469c = new JSONObject(map).toString();
                }
                fhVar.mo685a();
            } catch (Throwable th) {
                oh.b(th);
                pk.d("sendPointEvent = " + Log.getStackTraceString(th));
            }
            return true;
        }
        a(AdError.ERROR_AD_INFORMATION_LOSE, true, "respond");
        return false;
    }

    public void a(wd wdVar) {
        y0 y0Var;
        long j;
        int i;
        String string;
        wdVar.f793a = System.currentTimeMillis();
        oh.a("request", "", null, wdVar, null);
        String str = wdVar.f795a;
        Integer intOrNull = (str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null) ? null : StringsKt.toIntOrNull(string);
        if (intOrNull == null) {
            pk.b("recordSlotReq invalid slotId: " + str);
            return;
        }
        e2 e2VarA = d1.f1121a.a().a(intOrNull.intValue());
        if (e2VarA == null || (y0Var = e2VarA.f230a) == null || y0Var.f1529a <= 0) {
            pk.d("request no need record to sp");
            return;
        }
        String str2 = "req_count_" + str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string2 = sl.a().getString(str2, "");
        int i2 = 1;
        if (!TextUtils.isEmpty(string2)) {
            Intrinsics.checkNotNull(string2);
            if (StringsKt.contains$default((CharSequence) string2, (CharSequence) "_", false, 2, (Object) null)) {
                List listSplit$default = StringsKt.split$default((CharSequence) string2, new String[]{"_"}, false, 0, 6, (Object) null);
                if (listSplit$default.size() == 2) {
                    j = Long.parseLong((String) listSplit$default.get(0));
                    i = Integer.parseInt((String) listSplit$default.get(1));
                } else {
                    j = 0;
                    i = 1;
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jCurrentTimeMillis);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(j);
                if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
                    i2 = 1 + i;
                }
            }
        }
        sl.a(str2, new StringBuilder().append(jCurrentTimeMillis).append('_').append(i2).toString());
    }
}
