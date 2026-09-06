package com.miui.zeus.mimo.sdk.base;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.b;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import ijiami_1011.s.s.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class BaseAd<T extends BaseAdImpl> {
    private static final String TAG = s.d(new byte[]{116, 86, Ascii.NAK, 1, 35, 85}, "67fdb1");
    public T mAdImpl;

    public static class IBidding {
        public static final String EXPECT_COST_PRICE = s.d(new byte[]{113, 96, 102, 124, 34, 97, 62, 39, 41, 49, 101, 58, 100, 106, 127, 122, 36}, "4869a5");
        public static final String HIGHEST_LOSS_PRICE = s.d(new byte[]{42, 124, 126, 122, 35, 101, 53, 59, 42, 45, 98, 54, Base64.padSymbol, 101, 107, 123, 37, 115}, "b592f6");
        public static final String WIN_PRICE = s.d(new byte[]{111, 124, 120, 104, 50, 99, 40, 39, 35}, "8567b1");
        public static final String LOSS_REASON = s.d(new byte[]{45, 124, 53, 54, 111, 106, 36, 37, 53, 45, 127}, "a3fe08");
        public static final String ADN_ID = s.d(new byte[]{34, 113, 121, 108, 45, 118}, "c573d2");
    }

    public enum LossReason {
        TYPE_TIME_OUT(1, s.d(new byte[]{-117, -45, -32, -48, -82, -127, -114, -40, -22, -123, -100, -20, -122, -37, -32, -48, -82, -127, -120, -13, -46, -118, -114, -30, -118, -16, -38, -33, -83, -82, -119, -37, -31, -121, -66, -25, -124, -50, -5, -48, -91, -115, -123, -40, -4}, "cee697")),
        TYPE_CACHE_EXPIRE(2, s.d(new byte[]{-42, -38, -93, -48, -49, -6, -124, -35, -39, -121, -96, -17, -39, -39, -73, -45, -2, -3}, "1f05bb")),
        TYPE_LOWER_LIMIT_PRICE(3, s.d(new byte[]{-44, -34, -45, -128, -108, -34, -123, -39, -24, -122, -117, -21, -43, -36, -37, -125, -91, -24, -123, -39, -21, -121, -117, -16, -44, -34, -45}, "0edf4b")),
        TYPE_LOWER_OTHER_BIDDER_PRICE(4, s.d(new byte[]{-121, -40, -47, -42, -111, -118, -123, -39, -24, -122, -117, -21, -122, -26, -48, -44, -118, -96, 3, 13, 2, 6, 84, Ascii.ETB}, "ccf016")),
        TYPE_HIT_BLACKLIST(5, s.d(new byte[]{-121, -117, -36, -46, -13, -77, -122, -19, -49, -124, -89, -4, -123, -97, -22, -46, -13, -124, -123, -36, -53, -117, -118, -12, -121, -94, -18, -46, -17, -84, -120, -28, -35, -118, -113, -12}, "b2c7b9")),
        TYPE_NO_PARTICIPATE(6, s.d(new byte[]{-128, -92, -97, -47, -22, -69, -123, -36, -24, -123, -102, -5, -126, -125, -126}, "f854e9")),
        TYPE_OTHER(100, s.d(new byte[]{-48, -80, -114, -35, -105, -31, -124, -22, -7, -121, -86, -59, Ascii.EM, Ascii.NAK}, "55889b"));

        private String message;
        private int value;

        LossReason(int i, String str) {
            this.value = i;
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }

        public int getValue() {
            return this.value;
        }
    }

    public long getId() {
        MimoAdInfo mimoAdInfo = this.mAdImpl.f5377a;
        if (mimoAdInfo != null) {
            return mimoAdInfo.d;
        }
        return 0L;
    }

    public Map<String, Object> getMediaExtraInfo() {
        MimoAdInfo mimoAdInfo = this.mAdImpl.f5377a;
        return mimoAdInfo != null ? mimoAdInfo.j0 : new HashMap();
    }

    @Deprecated
    public void loss(LossReason lossReason) {
        if (lossReason != null) {
            this.mAdImpl.a(Collections.singletonMap(s.d(new byte[]{125, 127, 102, 106, 62, 52, 36, 37, 53, 45, 127}, "1059af"), lossReason));
        }
    }

    @Deprecated
    public void loss(String str) {
        this.mAdImpl.a(Collections.singletonMap(s.d(new byte[]{41, 42, 102, 55, 105, 55, 36, 37, 53, 45, 127}, "ee5d6e"), str));
    }

    public void loss(Map<String, Object> map) {
        this.mAdImpl.a(map);
    }

    public void setMute(boolean z) {
        this.mAdImpl.a(z);
    }

    public void setPrice(long j) {
        this.mAdImpl.a(j);
    }

    @Deprecated
    public void win(long j) {
        T t = this.mAdImpl;
        Map<String, Long> mapSingletonMap = Collections.singletonMap(s.d(new byte[]{43, 42, 33, 113, 38, 100, 53, 59, 42, 45, 98, 54, 60, 51, 52, 112, 32, 114}, "ccf9c7"), Long.valueOf(j));
        t.getClass();
        AdEvent adEvent = AdEvent.WIN;
        MimoAdInfo mimoAdInfo = t.f5377a;
        k6 k6Var = new k6();
        k6Var.d = mapSingletonMap;
        b.a(adEvent, mimoAdInfo, (n6) null, k6Var);
    }

    public void win(Map<String, Long> map) {
        T t = this.mAdImpl;
        t.getClass();
        AdEvent adEvent = AdEvent.WIN;
        MimoAdInfo mimoAdInfo = t.f5377a;
        k6 k6Var = new k6();
        k6Var.d = map;
        b.a(adEvent, mimoAdInfo, (n6) null, k6Var);
    }
}
