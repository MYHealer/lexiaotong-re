package com.hihonor.adsdk.base.net.request;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.hihonor.adsdk.base.AdSlot;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.e.b;
import com.hihonor.adsdk.base.e.c;
import com.hihonor.adsdk.base.f.l.d;
import com.hihonor.adsdk.base.j.e;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.j.n.g;
import com.hihonor.adsdk.common.f.q;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "BodyProvider";
    private static final MediaType hnadsb = MediaType.parse("application/json; charset=utf-8");
    private static final String hnadsc = "honorMarketInstalled";
    private static final String hnadsd = "hasInstallerSdk";
    private static final String hnadse = "com.hihonor.appmarket";
    private static final String hnadsf = "1";

    public static BaseRequest hnadsa(AdSlot adSlot, int i) {
        BaseRequest baseRequest = new BaseRequest();
        AdUnit adUnit = new AdUnit();
        adUnit.setAdUnitId(adSlot.getSlotId());
        adUnit.setAdType(i);
        adUnit.setRenderMode(adSlot.getRenderType());
        adUnit.setIndustryIds(adSlot.getIndustryIds());
        baseRequest.setAdUnit(adUnit);
        String strHnadsa = hnadsa(adSlot);
        if (!TextUtils.isEmpty(strHnadsa)) {
            baseRequest.setAdContext(strHnadsa);
        }
        return baseRequest;
    }

    public static RequestBody hnadsa(Context context, BaseRequest baseRequest) {
        hnadsa(baseRequest, context, HnAds.get().getCfg().getAppId());
        return RequestBody.create(hnadsb, baseRequest.getJsonCache());
    }

    public static RequestBody hnadsa(String str) {
        return RequestBody.create(hnadsb, str);
    }

    private static void hnadsa(BaseRequest baseRequest, Context context, String str) {
        DeviceData.a aVarHnadsl = new DeviceData.a().hnadsc(e.hnadsb().hnadsg()).hnadsa(e.hnadsb().hnadsc()).hnadsb(e.hnadsb().hnadsd()).hnadsa(e.hnadsb().hnadse()).hnadsd("CN").hnadsi(j.hnadsd(context)).hnadsk(j.hnadsh()).hnadsm(j.hnadsd()).hnadse(com.hihonor.adsdk.common.f.j.hnadsd(context)).hnadsn("android").hnadso(j.hnadsa()).hnadsf(com.hihonor.adsdk.common.f.j.hnadsa(context)).hnadsh(e.hnadsb().hnadsi()).hnadsg(e.hnadsb().hnadsh()).hnadsq("1.0.24.300").hnadsj(j.hnadsf()).hnadsa(System.currentTimeMillis()).hnadsr(e.hnadsb().hnadsj()).hnadsb(e.hnadsb().hnadsf()).hnadsp(j.hnadsi()).hnadsl(c.hnadsa().hnadsc());
        hnadsa(aVarHnadsl);
        Address addressHnadsb = g.hnadsa().hnadsb();
        if (addressHnadsb != null) {
            com.hihonor.adsdk.base.bean.Address address = new com.hihonor.adsdk.base.bean.Address();
            address.setCountryName(addressHnadsb.getCountryName());
            address.setProvinceName(addressHnadsb.getAdminArea());
            address.setCityName(addressHnadsb.getLocality());
            aVarHnadsl.hnadsa(address);
        }
        MediaData mediaData = new MediaData();
        mediaData.setMediaId(str);
        mediaData.setSdkVersion("1.0.24.300");
        mediaData.setAppVersion(e.hnadsb().hnadsc());
        mediaData.setMediaPackage(context.getPackageName());
        mediaData.setAllianceChannelInfo(b.hnadse().hnadsf());
        mediaData.setWechatVersion(d.hnadsl());
        mediaData.setWechatOpenSdkVersion(d.hnadsk());
        baseRequest.setDeviceData(aVarHnadsl.hnadsa());
        baseRequest.setMediaData(mediaData);
    }

    private static void hnadsa(DeviceData.a aVar) {
        com.hihonor.adsdk.base.init.b.C0440b c0440bHnadsf = com.hihonor.adsdk.base.init.b.hnadsc().hnadsf();
        if (c0440bHnadsf != null) {
            aVar.hnadsg(c0440bHnadsf.hnadsa());
            aVar.hnadsh(com.hihonor.adsdk.base.j.b.hnadsc(c0440bHnadsf.hnadsa().getBytes(StandardCharsets.UTF_8)));
            aVar.hnadsd(c0440bHnadsf.hnadsb() ? 1 : 0);
        }
    }

    public static com.hihonor.adsdk.base.net.e hnadsa(Context context, String str, String str2) {
        return hnadsa(context, str, str2, null);
    }

    public static com.hihonor.adsdk.base.net.e hnadsa(Context context, String str, String str2, String str3) {
        long jHnadsa = hnadsa(new Date());
        String appId = HnAds.get().getCfg().getAppId();
        String appKey = HnAds.get().getCfg().getAppKey();
        if (TextUtils.isEmpty(str3)) {
            str3 = UUID.randomUUID().toString();
        }
        com.hihonor.adsdk.base.net.e.a aVarHnadsb = new com.hihonor.adsdk.base.net.e.a().hnadsf(str3).hnadsi("HmacSHA256").hnadsh(str3).hnadsa(jHnadsa).hnadsj(appId).hnadsd(e.hnadsb().hnadsc()).hnadse(context.getPackageName()).hnadsb("1");
        com.hihonor.adsdk.base.init.b.C0440b c0440bHnadsf = com.hihonor.adsdk.base.init.b.hnadsc().hnadsf();
        if (c0440bHnadsf != null) {
            aVarHnadsb.hnadsc(c0440bHnadsf.hnadsa());
        }
        aVarHnadsb.hnadsk(com.hihonor.adsdk.base.j.b.hnadsa(context, str + aVarHnadsb.hnadsb() + str2, appKey));
        return aVarHnadsb.hnadsa();
    }

    private static int hnadsa(Date date) {
        String strValueOf;
        int length;
        if (date != null && (length = (strValueOf = String.valueOf(date.getTime())).length()) > 3) {
            return q.hnadsa(strValueOf.substring(0, length - 3), 0);
        }
        return 0;
    }

    private static String hnadsa(AdSlot adSlot) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "getAdContext");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(hnadsc, com.hihonor.adsdk.base.j.b.hnadsa(HnAds.get().getContext(), hnadse) ? 1 : 2);
            jSONObject.put(hnadsd, 1);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getAdContext errorMsg = " + e.getMessage(), new Object[0]);
        }
        hnadsa(jSONObject, adSlot);
        int length = jSONObject.length();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getAdContext jsonObjectLength = %d", Integer.valueOf(length));
        if (length > 0) {
            return jSONObject.toString();
        }
        return null;
    }

    private static void hnadsa(JSONObject jSONObject, AdSlot adSlot) {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "handleMediaAdContext");
        if (TextUtils.isEmpty(adSlot.getAdContext())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "handleMediaAdContext adContext is empty", new Object[0]);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(adSlot.getAdContext());
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!hnadsc.equals(next) && !hnadsd.equals(next)) {
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "handleMediaAdContext errorMsg = " + e.getMessage(), new Object[0]);
        }
    }
}
