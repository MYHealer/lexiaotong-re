package com.kwad.sdk.utils;

import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bj {
    private static Context bqf;
    private static Map<String, m> bqg = new HashMap();

    private static boolean Wn() {
        return bqf != null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (Wn()) {
            if (bqg.containsKey("baseStationEnable")) {
                boolean zFH = hVar.FH();
                m mVarIb = ib("baseStationEnable");
                if (mVarIb != null) {
                    mVarIb.cs(zFH);
                }
            }
            if (bqg.containsKey("simCardInfoEnable")) {
                boolean zFF = hVar.FF();
                m mVarIb2 = ib("simCardInfoEnable");
                if (mVarIb2 != null) {
                    mVarIb2.cs(zFF);
                    return;
                }
                return;
            }
            return;
        }
        bqf = StubApp.getOrigApplicationContext(context.getApplicationContext());
        bqg.put("baseStationEnable", new a(hVar.FH()));
        bqg.put("simCardInfoEnable", new b(hVar.FF()));
    }

    private static <T> m<T> ib(String str) {
        try {
            return bqg.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static com.kwad.sdk.k.a.b TB() {
        if (Wn()) {
            return (com.kwad.sdk.k.a.b) ic("baseStationEnable");
        }
        return null;
    }

    public static com.kwad.sdk.k.a.f TC() {
        if (Wn()) {
            return (com.kwad.sdk.k.a.f) ic("simCardInfoEnable");
        }
        return null;
    }

    private static <T> T ic(String str) {
        m mVarIb = ib(str);
        if (mVarIb != null) {
            return (T) mVarIb.cX(bqf);
        }
        return null;
    }

    static class a extends m<com.kwad.sdk.k.a.b> {
        private static com.kwad.sdk.k.a.b bqh;

        public a(boolean z) {
            super(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.m
        /* JADX INFO: renamed from: ek, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.k.a.b cY(Context context) {
            int lac;
            int cid;
            if (be.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(64L)) {
                return bqh;
            }
            com.kwad.sdk.k.a.b bVar = bqh;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || be.readLocationDisable()) {
                return null;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1) {
                return null;
            }
            if (bt.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    cid = cdmaCellLocation.getBaseStationId();
                    lac = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    cid = gsmCellLocation.getCid();
                    lac = gsmCellLocation.getLac();
                } else {
                    lac = -1;
                    cid = -1;
                }
                for (CellInfo cellInfo2 : telephonyManager.getAllCellInfo()) {
                    if (cellInfo2 != null && cellInfo2.isRegistered()) {
                        cellInfo = cellInfo2;
                        break;
                    }
                }
                bqh = new com.kwad.sdk.k.a.b(cid, lac, cellInfo != null ? a(cellInfo) : -1);
            }
            return bqh;
        }

        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) ab.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }
    }

    static class b extends m<com.kwad.sdk.k.a.f> {
        @Override // com.kwad.sdk.utils.m
        protected final /* synthetic */ com.kwad.sdk.k.a.f cY(Context context) {
            return el(context);
        }

        public b(boolean z) {
            super(z);
        }

        private static com.kwad.sdk.k.a.f el(Context context) {
            com.kwad.sdk.k.a.f fVar = new com.kwad.sdk.k.a.f();
            fVar.bmF = bf.dX(context);
            fVar.bmE = bf.dV(context);
            return fVar;
        }
    }
}
