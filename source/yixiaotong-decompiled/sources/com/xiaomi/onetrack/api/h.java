package com.xiaomi.onetrack.api;

import android.content.Context;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.util.DeviceUtil;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class h {
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{38, SignedBytes.MAX_POWER_OF_TWO, 7, 8, Ascii.ETB, 116, 0, 16, 7, 32, 68, 12, 15, 82, 7, Ascii.DC4}, "c6bfc0");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9428a = ijiami_1011.s.s.s.d(new byte[]{115}, "127013");
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{42}, "b27c9a");

    public static String a(long j, String str, long j2, long j3, Configuration configuration, OneTrack.IEventHook iEventHook, com.xiaomi.onetrack.util.v vVar, boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{95, 10, 1, Ascii.SYN, Ascii.DC4, 81, 2, 15, 57, Ascii.ETB, 65, 2, 66, 5, 0, 7}, "0ddbf0"), configuration, iEventHook, vVar, z, false));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{15, 82, 71, 69, 110, 70, 4, Ascii.SYN, 57, 1, 94, 1, 6}, "c34110"), j);
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{94, 5, 66, 77, 58, 65, 4, Ascii.SYN, 57, 12, 80, 8, 87}, "2d19e7"), str);
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{91, 66, Ascii.ETB, 105, Ascii.DC2, 7, 19, 59, 5, 13, 85, 0}, "87e6db"), j2);
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{88, 80, 16, 65, 105, 65, 17, 3, Ascii.DC4, 3, 85, 0, 107, 69, 10, 88, 83}, "41c564"), j3);
        jSONObject.put(f9428a, jSONObject2);
        return jSONObject.toString();
    }

    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{90, 95, 85, 71, 69, 88, 2, 15, 57, 1, 69, 4, 106, 66, 68, 82, 67, 76, Ascii.DC2}, "510379"), configuration, iEventHook, vVar, z, false));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{70, 85, 85, 69, 6}, "0490c5"), com.xiaomi.onetrack.c.i.b());
        jSONObject.put(f9428a, jSONObject2);
        return jSONObject.toString();
    }

    public static String a(Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{10, 90, 0, 17, 66, 5, 2, 15, 57, 6, 80, 16}, "e4ee0d"), configuration, iEventHook, vVar, z, false));
        JSONObject jSONObject3 = new JSONObject();
        Context contextB = com.xiaomi.onetrack.f.a.b();
        boolean zS = com.xiaomi.onetrack.util.aa.s();
        if (zS) {
            com.xiaomi.onetrack.util.aa.c(false);
        }
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{80, 95, 75, Ascii.DC2, Ascii.ETB, 108, 14, Ascii.DC4, 3, 12}, "669ac3"), zS);
        if (!(com.xiaomi.onetrack.util.q.a() ? com.xiaomi.onetrack.util.q.h() : configuration.isInternational())) {
            if (configuration.isIMEIEnable()) {
                jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{95, 93, 83, 12, 71}, "606e46"), DeviceUtil.f(contextB));
            }
            if (configuration.isIMSIEnable()) {
                jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{89, 95, 75, 13, 74}, "028d9d"), DeviceUtil.i(contextB));
            }
        }
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{90, 11, 92, 94, 12, 85, 62, Ascii.ETB, Ascii.DC2, 3, 69, 16, 74}, "9d28e2"), f.a(configuration));
        jSONObject2.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(ServiceQualityEvent serviceQualityEvent, Configuration configuration, OneTrack.IEventHook iEventHook, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{93, 77, 107, 71, 82, 75, Ascii.ETB, 13, 5, 7, 110, Ascii.DC4, 71, 88, 88, 93, 67, SignedBytes.MAX_POWER_OF_TWO}, "294479"), configuration, iEventHook, vVar, z, false));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{75, 90, 95, 83, 11, 7}, "8976fb"), serviceQualityEvent.getScheme());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{92, 86, Ascii.NAK, 71}, "49f35c"), serviceQualityEvent.getHost());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{65, 94, Ascii.SYN, Ascii.NAK}, "11dafe"), serviceQualityEvent.getPort());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{69, 2, 76, 92}, "5c8437"), serviceQualityEvent.getPath());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{10, 71, 65}, "c72b38"), serviceQualityEvent.getIps());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 84, 17, Ascii.DC4, 10, 12, Ascii.DC2, 1}, "e1bdeb"), serviceQualityEvent.getResponseCode());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{16, Ascii.NAK, 7, 17, 67, 75}, "cafe68"), serviceQualityEvent.getStatusCode());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{86, 74, 6, 1, Ascii.DC4, Ascii.NAK, 8, 11, 8}, "32edda"), serviceQualityEvent.getExceptionTag());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 86, Ascii.ETB, 76, 14, 70}, "f3d9b2"), serviceQualityEvent.getResultType());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{17, 93, Ascii.NAK, 65, Ascii.FS}, "c8a3e7"), serviceQualityEvent.getRetryCount());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{71, 4, 67, 104, 65, 67}, "5a2750"), serviceQualityEvent.getRequestTimestamp());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 92, Ascii.DC4, 60, 91, 81, Ascii.NAK}, "d9ec54"), serviceQualityEvent.getRequestNetType());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{80, 93, Ascii.ETB}, "43df8b"), serviceQualityEvent.getDnsLookupTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 0, 19, 108, 7, 87, 15, 10, 3, 1, 69}, "acc3d8"), serviceQualityEvent.getTcpConnectTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{92, 84, 91, 0, Ascii.SYN, 89, 0, 15, 3}, "455de1"), serviceQualityEvent.getHandshakeTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{75, 3, Ascii.DC2, 62, 4, 15, 19, Ascii.ETB, Ascii.DC2, Base64.padSymbol, 83, Ascii.FS, 77, 3}, "9faabf"), serviceQualityEvent.getReceiveFirstByteTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 87, 67, 108, 81, 95, 13, 59, 4, Ascii.ESC, 69, 0}, "d20303"), serviceQualityEvent.getReceiveAllByteTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{75, 86, 67, 107, 6, 83, Ascii.NAK, 5, 57, 17, 84, 11, 93}, "9324b2"), serviceQualityEvent.getRequestDataSendTime());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{0, 17, 69, 81, 76, 15, 14, 10}, "dd708f"), serviceQualityEvent.getDuration());
        jSONObject2.put(ijiami_1011.s.s.s.d(new byte[]{91, 92, 65, 105, 75, 87, 10, 59, 16, 7, 67}, "595683"), serviceQualityEvent.getNetSdkVersion());
        Map<String, Object> extraParams = serviceQualityEvent.getExtraParams();
        if (extraParams != null && extraParams.size() > 0) {
            for (Map.Entry<String, Object> entry : extraParams.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (com.xiaomi.onetrack.util.r.b(value)) {
                    jSONObject2.put(key, value);
                }
            }
        }
        jSONObject.put(f9428a, jSONObject2);
        return jSONObject.toString();
    }

    public static String a(i iVar, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(iVar, configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String str, String str2, long j, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, com.xiaomi.onetrack.f.b.a(str2, configuration, iEventHook, vVar, z, false));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{90, 8, 87, 68, 65}, "9d6721"), str);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{65, 78, Ascii.DC2, 93}, "57b8f1"), 2);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{7, 77, Ascii.SYN, 82, Ascii.ETB, 13, 14, 10}, "c8d3cd"), j);
        jSONObject2.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String str, String str2, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, boolean z, com.xiaomi.onetrack.util.v vVar, boolean z2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(b, com.xiaomi.onetrack.f.b.a(str2, configuration, iEventHook, vVar, z2, false));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{81, 92, 88, 17, SignedBytes.MAX_POWER_OF_TWO}, "209b38"), str);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{77, 65, 19, 93}, "98c8c5"), 1);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{88, 72, 70, 111, Ascii.SYN, 17, 0, Ascii.SYN, Ascii.DC2}, "9860ee"), z);
        jSONObject2.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String str, String str2, String str3, String str4, String str5, long j, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObjectA = com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{10, 13, 93, 65, 19, 88, 2, 15, 57, 0, 68, 2, 58, 17, 93, 69, 14, 75, Ascii.NAK}, "ec85a9"), configuration, iEventHook, vVar, z, false);
        if (str5 != null) {
            jSONObjectA.put(com.xiaomi.onetrack.f.b.C1162b.o, str5);
        }
        jSONObject2.put(b, jSONObjectA);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{87, 74, 2, 7, 71, 66, 8, 11, 8}, "22ab76"), str);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{67, 72, Ascii.DC2, 87}, "71b25b"), str3);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{84, 80, Ascii.ETB, 70, 81, 85, 4}, "95d502"), str2);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{4, 86, 5, 69, 19, Ascii.ETB, 4}, "b3d1fe"), str4);
        jSONObject3.put(ijiami_1011.s.s.s.d(new byte[]{80, Ascii.DC4, 5, Ascii.SYN, 14, 16, 8, 9, 3}, "3fdefd"), j);
        jSONObject2.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject3, jSONObject));
        return jSONObject2.toString();
    }

    public static String a(String str, String str2, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(str2, configuration, iEventHook, str, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String str, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, JSONArray jSONArray, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObjectA = com.xiaomi.onetrack.f.b.a(str, configuration, iEventHook, vVar, z, true);
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObjectA.put(com.xiaomi.onetrack.f.b.C1162b.H, jSONArray);
        }
        jSONObject3.put(b, jSONObjectA);
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(String str, JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(str, configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String a(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{93, 69, 62, 69, 65, 90, 7, 13, 10, 7, 110, Ascii.SYN, 87, 69}, "21a535"), configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String b(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{89, SignedBytes.MAX_POWER_OF_TWO, 107, Ascii.DC2, Ascii.ETB, 12, 7, 13, 10, 7, 110, 12, 88, 87, 70, 7, 8, 6, 15, 16}, "644bec"), configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String c(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{11, Ascii.DC2, Base64.padSymbol, 94, 87, 87, 8, 10}, "dfb280"), configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }

    public static String d(JSONObject jSONObject, Configuration configuration, OneTrack.IEventHook iEventHook, JSONObject jSONObject2, com.xiaomi.onetrack.util.v vVar, boolean z) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(b, com.xiaomi.onetrack.f.b.a(ijiami_1011.s.s.s.d(new byte[]{10, 67, 58, 85, 90, 95, 14, 17, Ascii.DC2}, "e7e958"), configuration, iEventHook, vVar, z, false));
        jSONObject3.put(f9428a, com.xiaomi.onetrack.util.r.a(jSONObject, jSONObject2));
        return jSONObject3.toString();
    }
}
