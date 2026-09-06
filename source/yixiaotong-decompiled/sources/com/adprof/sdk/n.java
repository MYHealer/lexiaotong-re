package com.adprof.sdk;

import android.location.Location;
import android.view.MotionEvent;
import com.adprof.sdk.api.IBiddingNotify;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class n extends v5 {
    private static final long serialVersionUID = 1;

    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    public static String c(String str) {
        try {
            switch (str) {
                case "__SLOTX__":
                case "__HW_W__":
                    return String.valueOf(h8.b(h8.b()));
                case "__SLOTY__":
                case "__HW_H__":
                    return String.valueOf(h8.b(h8.m641a()));
                case "_LATITUDE_":
                    Location locationA = v7.a().m721a().a();
                    return locationA != null ? String.valueOf(locationA.getLatitude()) : "";
                case "_LONGITUDE_":
                    Location locationA2 = v7.a().m721a().a();
                    return locationA2 != null ? String.valueOf(locationA2.getLongitude()) : "";
                case "__HW_TURN_X__":
                    return UUID.randomUUID().toString();
                case "__HW_TURN_Y__":
                    return "";
                case "__HW_TURN_Z__":
                    return l.c;
                case "__HW_TURN_TIME__":
                    return System.currentTimeMillis() + "";
                case "__AEVENTTIME__":
                    return System.currentTimeMillis() + "";
                default:
                    return "unFind";
            }
        } catch (Throwable th) {
            pk.b("getMacroValue e = ", th);
            return "unFind";
        }
    }

    public final void a() {
        this.f1472a.put("__AZMX__", "-999");
        this.f1472a.put("__AZMY__", "-999");
        this.f1472a.put("__HW_DOWN_X__", "-999");
        this.f1472a.put("__HW_DOWN_Y__", "-999");
        this.f1472a.put("__AZCX__", "-999");
        this.f1472a.put("__AZCY__", "-999");
        this.f1472a.put("__HW_UP_X__", "-999");
        this.f1472a.put("__HW_UP_Y__", "-999");
    }

    public void a(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        b(motionEvent);
        d(motionEvent);
        b();
    }

    public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null) {
            motionEvent = motionEvent2;
        }
        b(motionEvent);
    }

    public final void b(MotionEvent motionEvent) {
        this.f1472a.put("__AZMX__", String.valueOf(h8.b(motionEvent.getX())));
        this.f1472a.put("__AZMY__", String.valueOf(h8.b(motionEvent.getY())));
        this.f1472a.put("__HW_DOWN_X__", String.valueOf(h8.b(motionEvent.getRawX())));
        this.f1472a.put("__HW_DOWN_Y__", String.valueOf(h8.b(motionEvent.getRawY())));
    }

    public final void d(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.f1472a.put("__AZCX__", String.valueOf(h8.b(motionEvent.getX())));
        this.f1472a.put("__AZCY__", String.valueOf(h8.b(motionEvent.getY())));
        this.f1472a.put("__HW_UP_X__", String.valueOf(h8.b(motionEvent.getRawX())));
        this.f1472a.put("__HW_UP_Y__", String.valueOf(h8.b(motionEvent.getRawY())));
    }

    public void c(MotionEvent motionEvent) {
        this.f1472a.put("__ASLD__", "0");
        this.f1472a.put("__HW_SLD__", "0");
        d(motionEvent);
        this.f1472a.put("__HW_UP_TIME__", String.valueOf(System.currentTimeMillis()));
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f1472a.put("__HW_DOWN_TIME__", String.valueOf(jCurrentTimeMillis));
        this.f1472a.put("__DOWN_TIME__", String.valueOf(jCurrentTimeMillis));
        this.f1472a.put("__AEVENTTIME__", String.valueOf(jCurrentTimeMillis));
    }

    @Override // com.adprof.sdk.v5
    public String b(String str) {
        long jCurrentTimeMillis;
        String strA = "unFind";
        try {
            int iOrdinal = u5.valueOf(str).ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                } else if (iOrdinal == 2 || iOrdinal == 3) {
                    jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                }
                strA = String.valueOf(jCurrentTimeMillis);
            } else {
                strA = t8.a(ig.a());
            }
        } catch (Throwable unused) {
        }
        if (!v5.a(strA)) {
            strA = null;
        }
        if (v5.a(strA)) {
            return strA;
        }
        try {
            String strC = c(str);
            if (v5.a(strC)) {
                return strC;
            }
            return null;
        } catch (Throwable th) {
            pk.b("replaceWithDefault error: ", th);
        }
    }

    public void a(Float f, Float f2, Float f3) {
        if (pk.f594a) {
            pk.c(" updateClickMarco dx ==== " + f + "   dy = " + f2 + "   dz = " + f3);
        }
        this.f1472a.put("__ASLD__", "2");
        this.f1472a.put("__HW_SLD__", "2");
        a();
        b();
        try {
            this.f1472a.put("__AXMAXACC__", ((int) (f.floatValue() * 100.0f)) + "");
        } catch (Exception e) {
            pk.a(e);
            oh.b(e);
        }
        try {
            this.f1472a.put("__AYMAXACC__", ((int) (f2.floatValue() * 100.0f)) + "");
        } catch (Exception e2) {
            pk.a(e2);
            oh.b(e2);
        }
        try {
            this.f1472a.put("__AZMAXACC__", ((int) (f3.floatValue() * 100.0f)) + "");
        } catch (Exception e3) {
            pk.a(e3);
            oh.b(e3);
        }
    }

    public void a(int i, int i2, int i3, long j) {
        if (pk.f594a) {
            pk.c("twistUpdateMacro x = " + i + "   y = " + i2 + "   z = " + i3 + "   twistTime = " + j);
        }
        this.f1472a.put("__ASLD__", "5");
        a();
        this.f1472a.put("__ATURNX__", String.valueOf(i));
        this.f1472a.put("__ATURNY__", String.valueOf(i2));
        this.f1472a.put("__ATURNZ__", String.valueOf(i3));
        this.f1472a.put("__ATURNTIME__", String.valueOf(j));
        b();
    }

    public void a(d dVar, Map map) {
        int i;
        Object obj;
        if (map != null && (obj = map.get(IBiddingNotify.LOSS_FIRST_PRICE)) != null) {
            try {
                pk.d("updateLoss price = " + ((int) Double.parseDouble(obj.toString())) + "  self_price = " + dVar.b);
            } catch (Throwable th) {
                pk.b("updateLoss parse price error: ", th);
            }
        }
        if (map == null) {
            this.f1472a.put("__X_LR__", "100");
            return;
        }
        Object obj2 = map.get(IBiddingNotify.LOSS_REASON);
        if (obj2 != null) {
            try {
                i = Integer.parseInt(obj2.toString());
                try {
                    pk.d("updateLoss lossreason = " + i);
                } catch (Throwable th2) {
                    th = th2;
                    pk.b("updateLoss lossreason price error: ", th);
                }
            } catch (Throwable th3) {
                th = th3;
                i = -1;
            }
        } else {
            i = -1;
        }
        if (i == -1) {
            i = 100;
        }
        this.f1472a.put("__X_LR__", i + "");
    }
}
