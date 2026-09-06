package com.oplus.log.d;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5824a = "com.oplus.log.d.k";

    public static String a(String str, String str2, long j, int i, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, com.oplus.log.a aVar) {
        HashMap map = new HashMap();
        map.put("specificId", str);
        map.put("reportReason", str2);
        map.put("ts", String.valueOf(j));
        map.put("businessVersion", b.c(b.a()));
        map.put("protocolVersion", "3");
        map.put("errorCode", String.valueOf(i));
        map.put("subType", str3);
        map.put("brand", f.b());
        map.put("model", Build.MODEL);
        map.put("osVersion", f.c());
        map.put("romVersion", f.a());
        map.put("androidVersion", Build.VERSION.RELEASE);
        map.put("imei", str4.replace("%23", "#"));
        map.put("openId", str5.replace("%23", "#"));
        map.put("tracePkg", str6);
        map.put("program", str7);
        if (!TextUtils.isEmpty(str8)) {
            map.put("fileName", str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            map.put(MediationConstant.KEY_ERROR_MSG, str9);
        }
        String str12 = str10 + File.separator + str8;
        String strA = a(map);
        aVar.a("NearX-HLog", "签名生成空格替换前参数: " + strA + "url: " + str12);
        String strReplaceAll = strA.replaceAll(PPSLabelView.Code, "_");
        byte[] bytes = strReplaceAll.getBytes();
        byte[] bArrA = h.a(h.b(str12));
        if (bArrA == null) {
            Log.e("SecurityUtils", "log zip file is null");
        } else {
            byte[] bArr = new byte[bytes.length + bArrA.length];
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
            System.arraycopy(bArrA, 0, bArr, bytes.length, bArrA.length);
            bytes = bArr;
        }
        String strA2 = a(bytes, str11);
        aVar.a("NearX-HLog", "签名生成空格替换后参数: " + strReplaceAll + "url: " + str12 + "\n sign: " + strA2);
        return strA2;
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str).append("=").append(map.get(str)).append("&");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                sb.append("0");
            }
            sb.append(Long.toString(bArr[i] & 255, 16));
        }
        return sb.toString();
    }

    private static String a(byte[] bArr, String str) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes("UTF-8"), mac.getAlgorithm()));
            return a(mac.doFinal(bArr));
        } catch (Exception e) {
            throw new RuntimeException("HMAC-SHA1 encode error", e);
        }
    }
}
