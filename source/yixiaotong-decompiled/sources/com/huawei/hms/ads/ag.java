package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.data.Keyword;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class ag extends ah {
    private static final int B = -111111;
    private static final String Z = "JsbBaseAdRequest";

    public ag(String str) {
        super(str);
    }

    private static void B(AdParam.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setThirdNonPersonalizedAd(num);
    }

    private static void B(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAppCountry(str);
    }

    private static void B(RequestOptions.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setHwNonPersonalizedAd(num);
    }

    private static void B(RequestOptions.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAppCountry(str);
    }

    private void C(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setContentBundle(Z(str));
    }

    private static void C(RequestOptions.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setThirdNonPersonalizedAd(num);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0059  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062 A[SYNTHETIC] */
    private SearchInfo Code(JSONObject jSONObject) {
        String[] strArrSplit;
        int length;
        int i;
        Integer numValueOf;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.aE);
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.aF);
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.aG);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strOptString3)) {
            String[] strArrSplit2 = strOptString3.split(",");
            if (TextUtils.isEmpty(strOptString2)) {
                strArrSplit = null;
            } else {
                strArrSplit = strOptString2.split(",");
                if (!TextUtils.isEmpty(strOptString2)) {
                    length = strArrSplit.length;
                }
                for (i = 0; i < strArrSplit2.length; i++) {
                    if (TextUtils.isEmpty(strArrSplit2[i])) {
                        if (length >= i + 1) {
                            numValueOf = Integer.valueOf(com.huawei.openalliance.ad.utils.bc.Code(strArrSplit[i], 0));
                        } else {
                            numValueOf = null;
                        }
                        arrayList.add(new Keyword(numValueOf, strArrSplit2[i]));
                    }
                }
            }
            length = 0;
            while (i < strArrSplit2.length) {
                if (TextUtils.isEmpty(strArrSplit2[i])) {
                    if (length >= i + 1) {
                        numValueOf = Integer.valueOf(com.huawei.openalliance.ad.utils.bc.Code(strArrSplit[i], 0));
                    } else {
                        numValueOf = null;
                    }
                    arrayList.add(new Keyword(numValueOf, strArrSplit2[i]));
                }
            }
        }
        String strOptString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.aH);
        if (TextUtils.isEmpty(strOptString) && arrayList.isEmpty() && TextUtils.isEmpty(strOptString4)) {
            return null;
        }
        return new SearchInfo(strOptString, arrayList, strOptString4);
    }

    private static void Code(Context context, Boolean bool) {
        if (bool != null) {
            HiAd.getInstance(context).setAppAutoOpenForbidden(bool.booleanValue());
        }
    }

    private static void Code(Context context, Integer num) {
        if (num.intValue() != 0) {
            HiAd.getInstance(context).setAppActivateStyle(num.intValue());
        }
    }

    private void Code(Context context, String str, RequestOptions.Builder builder, AdParam.Builder builder2) {
        String str2;
        String str3;
        JSONObject jSONObject = new JSONObject(str);
        Integer numValueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.n, -111111));
        Integer numValueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.o, -111111));
        Integer numValueOf3 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.j, -111111));
        Integer numValueOf4 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.k, -111111));
        Integer numValueOf5 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.l, -111111));
        Integer numValueOf6 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.m, -111111));
        String strOptString = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.p);
        Boolean boolValueOf = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ba.G, true));
        Boolean boolValueOf2 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ba.H, true));
        Integer numValueOf7 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ba.J, 0));
        Boolean boolValueOf3 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ba.K, false));
        String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.P);
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.x);
        String strOptString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.N);
        String strOptString5 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.O);
        Integer numValueOf8 = Integer.valueOf(jSONObject.optInt("brand", -111111));
        String strOptString6 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.t);
        String strOptString7 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.W);
        Map<String, Bundle> mapD = D(jSONObject.optString(com.huawei.openalliance.ad.constant.ba.M));
        App appV = V(jSONObject.optJSONObject("app"));
        Location locationI = I(str);
        SearchInfo searchInfoCode = Code(jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.ba.aD));
        if (builder != null) {
            Code(builder, numValueOf);
            V(builder, numValueOf2);
            Code(builder, strOptString);
            I(builder, numValueOf4);
            Z(builder, numValueOf3);
            B(builder, numValueOf5);
            C(builder, numValueOf6);
            V(builder, strOptString2);
            I(builder, strOptString3);
            Code(builder, boolValueOf);
            Code(builder, appV);
            str3 = strOptString4;
            Z(builder, str3);
            str2 = strOptString5;
            B(builder, str2);
            Code(builder, mapD);
            Code(builder, searchInfoCode);
        } else {
            str2 = strOptString5;
            str3 = strOptString4;
        }
        if (builder2 != null) {
            Code(builder2, numValueOf);
            V(builder2, numValueOf2);
            Code(builder2, strOptString);
            I(builder2, numValueOf3);
            Z(builder2, numValueOf5);
            B(builder2, numValueOf6);
            V(builder2, strOptString2);
            I(builder2, strOptString3);
            Code(builder2, boolValueOf);
            Code(builder2, appV);
            Z(builder2, str3);
            B(builder2, str2);
            C(builder2, strOptString7);
            Code(builder2, locationI);
            Code(builder2, searchInfoCode);
        }
        V(context, numValueOf8);
        V(context, boolValueOf2);
        Code(context, numValueOf7);
        Code(context, boolValueOf3);
        if (TextUtils.isEmpty(strOptString6)) {
            return;
        }
        HiAd.getInstance(context).setCountryCode(strOptString6);
    }

    private static void Code(AdParam.Builder builder, Location location) {
        if (location != null) {
            builder.setLocation(location);
        }
    }

    private static void Code(AdParam.Builder builder, App app) {
        if (app != null) {
            builder.setAppInfo(app);
        }
    }

    private static void Code(AdParam.Builder builder, SearchInfo searchInfo) {
        if (searchInfo != null) {
            builder.setSearchInfo(searchInfo);
        }
    }

    private static void Code(AdParam.Builder builder, Boolean bool) {
        if (bool != null) {
            builder.setRequestLocation(bool.booleanValue());
        }
    }

    private static void Code(AdParam.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setTagForChildProtection(num);
    }

    private static void Code(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAdContentClassification(str);
    }

    private static void Code(RequestOptions.Builder builder, App app) {
        if (app != null) {
            builder.setApp(app);
        }
    }

    private static void Code(RequestOptions.Builder builder, SearchInfo searchInfo) {
        if (searchInfo != null) {
            builder.setSearchInfo(searchInfo);
        }
    }

    private static void Code(RequestOptions.Builder builder, Boolean bool) {
        if (bool != null) {
            builder.setRequestLocation(bool);
        }
    }

    private static void Code(RequestOptions.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setTagForChildProtection(num);
    }

    private static void Code(RequestOptions.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAdContentClassification(str);
    }

    private static void Code(RequestOptions.Builder builder, Map<String, Bundle> map) {
        if (map != null) {
            builder.setExtras(map);
        }
    }

    private Map<String, Bundle> D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) com.huawei.openalliance.ad.utils.ad.V(str, Map.class, Map.class);
        fh.Code(Z, "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                map2.put(str2, bundle);
            }
        }
        return map2;
    }

    private static void I(AdParam.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setNonPersonalizedAd(num);
    }

    private static void I(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setSearchTerm(str);
    }

    private static void I(RequestOptions.Builder builder, Integer num) {
        if (-111111 != num.intValue()) {
            builder.setIsQueryUseEnabled(num);
        }
    }

    private static void I(RequestOptions.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setSearchTerm(str);
    }

    private App V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("name");
        String strOptString2 = jSONObject.optString("version");
        String strOptString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.z);
        if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString3) && TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new App(strOptString3, strOptString, strOptString2);
    }

    private static void V(Context context, Boolean bool) {
        if (bool != null) {
            HiAd.getInstance(context).setAppInstalledNotify(bool.booleanValue());
        }
    }

    private static void V(Context context, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        HiAd.getInstance(context).setBrand(num.intValue());
    }

    private static void V(AdParam.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setTagForUnderAgeOfPromise(num);
    }

    private static void V(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setConsent(str);
    }

    private static void V(RequestOptions.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setTagForUnderAgeOfPromise(num);
    }

    private static void V(RequestOptions.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setConsent(str);
    }

    private static void Z(AdParam.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setHwNonPersonalizedAd(num);
    }

    private static void Z(AdParam.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAppLang(str);
    }

    private static void Z(RequestOptions.Builder builder, Integer num) {
        if (num == null || -111111 == num.intValue()) {
            return;
        }
        builder.setNonPersonalizedAd(num);
    }

    private static void Z(RequestOptions.Builder builder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        builder.setAppLang(str);
    }

    protected abstract void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    protected Location I(String str) {
        JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("location");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("latitude");
        String strOptString2 = jSONObjectOptJSONObject.optString("longitude");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.ci, strOptString) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.ci, strOptString2)) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(new BigDecimal(strOptString).doubleValue());
        location.setLongitude(new BigDecimal(strOptString2).doubleValue());
        return location;
    }

    protected AdParam I(Context context, String str) {
        AdParam.Builder builder = new AdParam.Builder();
        Code(context, str, (RequestOptions.Builder) null, builder);
        return builder.build();
    }

    protected RequestOptions V(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        Code(context, str, builder, (AdParam.Builder) null);
        return builder.build();
    }

    public String Z(String str) {
        return str;
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.ag.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ag.this.Code(context, str, remoteCallResultCallback);
                } catch (Throwable th) {
                    fh.Code(5, ag.Z, "executeInNetworkThread exception", th);
                    ah.Code(remoteCallResultCallback, ag.this.Code, -1, th.getClass().getSimpleName() + com.huawei.openalliance.ad.constant.x.bQ + th.getMessage(), true);
                }
            }
        });
    }
}
