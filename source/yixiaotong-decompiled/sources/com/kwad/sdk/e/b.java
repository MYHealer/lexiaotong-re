package com.kwad.sdk.e;

import com.ubixnow.ooooo.oOOOoo00;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements a {
    private static volatile b bgt;
    private static c bgu;

    public static void a(c cVar) {
        bgu = cVar;
    }

    private b() {
    }

    public static synchronized b QY() {
        if (bgt == null) {
            synchronized (b.class) {
                if (bgt == null) {
                    bgt = new b();
                }
            }
        }
        return bgt;
    }

    @Override // com.kwad.sdk.e.a
    public final String getIMEI() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getIMEI();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QO() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QO();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getMac() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getMac();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QP() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QP();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QQ() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QQ();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QR() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QR();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QS() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QS();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QT() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QT();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QU() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QU();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getIp();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QV() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QV();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QW() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QW();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QX() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.QX();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = bgu;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return QZ();
    }

    private static String QZ() {
        return a(false, "", 2);
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z));
        map.put(oOOOoo00.OooOo0o, obj);
        map.put("errorCode", String.valueOf(i));
        return new JSONObject(map).toString();
    }
}
