package com.xiaomi.onetrack;

import android.content.Context;
import android.content.Intent;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.xiaomi.onetrack.api.m;
import com.xiaomi.onetrack.f.a;
import com.xiaomi.onetrack.util.i;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class OneTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9380a;
    private static boolean b;
    private static boolean c;
    private m d;

    public interface ICommonPropertyProvider {
        Map<String, Object> getDynamicProperty(String str);
    }

    public interface IEventHook {
        boolean isCustomDauEvent(String str);

        boolean isRecommendEvent(String str);
    }

    public enum Mode {
        APP(s.d(new byte[]{83, 17, SignedBytes.MAX_POWER_OF_TWO}, "2a0c68")),
        PLUGIN(s.d(new byte[]{17, 92, 16, 3, 13, 88}, "a0edd6")),
        SDK(s.d(new byte[]{70, 7, 95}, "5c4f68"));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9382a;

        Mode(String str) {
            this.f9382a = str;
        }

        public String getType() {
            return this.f9382a;
        }
    }

    public enum NetType {
        NOT_CONNECTED(s.d(new byte[]{120, 46, 125, 125}, "6a381d")),
        MOBILE_2G(s.d(new byte[]{3, 117}, "12b0e5")),
        MOBILE_3G(s.d(new byte[]{4, 115}, "74745f")),
        MOBILE_4G(s.d(new byte[]{82, 36}, "fc3d78")),
        MOBILE_5G(s.d(new byte[]{5, 119}, "000019")),
        WIFI(s.d(new byte[]{53, 120, 116, 42}, "b12cec")),
        ETHERNET(s.d(new byte[]{115, 48, 113, 116, 102, 121, 36, 48}, "6d9147")),
        UNKNOWN(s.d(new byte[]{52, 45, 40, 123, 41, 102, 47}, "acc5f1")),
        CONNECTED(s.d(new byte[]{119, 119, 43, 40, 39, 34, 53, 33, 34}, "48efba"));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9383a;

        NetType(String str) {
            this.f9383a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f9383a;
        }
    }

    public enum UserIdType {
        XIAOMI(s.d(new byte[]{79, 11, 0, 95, 89, 88}, "7ba041")),
        PHONE_NUMBER(s.d(new byte[]{Ascii.SYN, 92, 14, 95, 0, 58, 15, 17, 11, 0, 84, Ascii.ETB}, "f4a1ee")),
        WEIXIN(s.d(new byte[]{Ascii.DC2, 81, 15, 26, 13, 13}, "e4fbdc")),
        WEIBO(s.d(new byte[]{71, 80, 12, 85, 89}, "05e762")),
        QQ(s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB}, "1ff9c4")),
        OTHER(s.d(new byte[]{11, 67, 11, 3, 74}, "d7cf83"));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9384a;

        UserIdType(String str) {
            this.f9384a = str;
        }

        public String getUserIdType() {
            return this.f9384a;
        }
    }

    private OneTrack(Context context, Configuration configuration) {
        a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.d = new m(context, configuration);
        setEventHook(new DefaultEventHook());
    }

    private static void a(Context context) {
        if (context == null) {
            throw new IllegalStateException(s.d(new byte[]{1, 90, 90, Ascii.DC2, 84, 75, Ascii.NAK, 68, 15, 17, 17, 11, Ascii.ETB, 89, 88, 71}, "b54f13"));
        }
        a.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    public static OneTrack createInstance(Context context, Configuration configuration) {
        return new OneTrack(context, configuration);
    }

    public static boolean isDisable() {
        return f9380a;
    }

    public static boolean isRestrictGetNetworkInfo() {
        return c;
    }

    public static boolean isUseSystemNetTrafficOnly() {
        return b;
    }

    public static void registerCrashHook(Context context) {
        CrashAnalysis.a(context);
    }

    public static String sdkVersion() {
        return s.d(new byte[]{7, 72, 6, Ascii.SYN, 83}, "5f78ae");
    }

    public static void setAccessNetworkEnable(Context context, final boolean z) {
        a(context);
        i.a(new Runnable() { // from class: com.xiaomi.onetrack.OneTrack.1
            @Override // java.lang.Runnable
            public void run() {
                com.xiaomi.onetrack.c.i.a(z);
                com.xiaomi.onetrack.c.i.b(z);
            }
        });
    }

    public static void setDebugMode(boolean z) {
        p.a(z);
    }

    public static void setDisable(boolean z) {
        f9380a = z;
    }

    public static void setRestrictGetNetworkInfo(boolean z) {
        c = z;
    }

    public static void setTestMode(boolean z) {
        p.b(z);
    }

    public static void setUseSystemNetTrafficOnly() {
        b = true;
    }

    public void adTrack(String str, Map<String, Object> map) {
        this.d.a(str, map, (List<String>) null);
    }

    public void adTrack(String str, Map<String, Object> map, List<String> list) {
        this.d.a(str, map, list);
    }

    public String appActiveBroadcast(Intent intent) {
        return this.d.a(intent);
    }

    public void clearCommonProperty() {
        this.d.a();
    }

    public String getAndroidId(Context context) {
        return this.d.b(context);
    }

    public String getInstanceId() {
        return this.d.b();
    }

    public String getOAID(Context context) {
        return this.d.a(context);
    }

    public boolean hasMemoryOaid() {
        return this.d.d();
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map) {
        login(str, userIdType, map, false);
    }

    public void login(String str, UserIdType userIdType, Map<String, Object> map, boolean z) {
        this.d.a(str, userIdType, map, z);
    }

    public void logout() {
        logout(null, false);
    }

    public void logout(Map<String, Object> map, boolean z) {
        this.d.a(map, z);
    }

    public void refreshGetOaidTime() {
        this.d.c();
    }

    public void removeCommonProperty(String str) {
        this.d.b(str);
    }

    public void setBasicModeEnable(boolean z) {
        this.d.c(z);
    }

    public void setCloseOaidDependMsaSDK(boolean z) {
        this.d.d(z);
    }

    public void setCommonProperty(Map<String, Object> map) {
        this.d.c(map);
    }

    public void setCustomPrivacyPolicyAccepted(boolean z) {
        this.d.b(z);
    }

    public void setDynamicCommonProperty(ICommonPropertyProvider iCommonPropertyProvider) {
        this.d.a(iCommonPropertyProvider);
    }

    public void setEventHook(IEventHook iEventHook) {
        this.d.a(iEventHook);
    }

    public void setInstanceId(String str) {
        this.d.c(str);
    }

    public void setUserProfile(String str, Object obj) {
        this.d.a(str, obj);
    }

    public void setUserProfile(Map<String, Object> map) {
        this.d.a(map);
    }

    public void track(String str, List<String> list, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(s.d(new byte[]{1, 65, Ascii.DC2, 104, 94, 83}, "d9b777"), String.join(s.d(new byte[]{Ascii.NAK}, "93744d"), list));
        this.d.a(str, (Map<String, Object>) map2);
    }

    public void track(String str, Map<String, Object> map) {
        this.d.a(str, map);
    }

    public void trackEventFromH5(String str) {
        this.d.a(str);
    }

    public void trackPluginEvent(String str, String str2, Map<String, Object> map) {
        this.d.a(str, str2, map);
    }

    public void trackServiceQualityEvent(ServiceQualityEvent serviceQualityEvent) {
        this.d.a(serviceQualityEvent);
    }

    public void userProfileIncrement(String str, Number number) {
        this.d.a(str, number);
    }

    public void userProfileIncrement(Map<String, ? extends Number> map) {
        this.d.b(map);
    }
}
