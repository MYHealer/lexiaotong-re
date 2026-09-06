package com.adprof.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a2 implements kl {
    public final void a(d dVar, String str, String str2, final Map map) {
        if (dVar.e > 0) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("closeType", Integer.valueOf(dVar.e));
        }
        oh.a(str, str2, dVar, null, new nh() { // from class: com.adprof.sdk.a2$$ExternalSyntheticLambda0
            @Override // com.adprof.sdk.nh
            public final void a(Object obj) {
                a2.a(map, obj);
            }
        });
    }

    public boolean a(d dVar) {
        if (dVar == null) {
            pk.b("createDisplaySession: adUnit is null");
            return false;
        }
        dVar.f185a = this;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005b  */
    public boolean a(d dVar, String str, Map map) {
        byte b = 0;
        if (dVar == null) {
            pk.b("recordDisplayEvent: adUnit is null, event: " + str);
            return false;
        }
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1812079383) {
                if (iHashCode != 3532159) {
                    if (iHashCode != 94756344) {
                        if (iHashCode == 911849964 && str.equals("four_elements_show")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (str.equals("close")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (!str.equals(com.huawei.openalliance.ad.constant.dd.F)) {
                    b = -1;
                }
            } else if (str.equals("four_elements_close")) {
                b = 3;
            } else {
                b = -1;
            }
            if (b != 0 && b != 1 && b != 2 && b != 3) {
                qn.a(dVar, str);
            }
            a(dVar, str, "", map);
        } catch (Throwable th) {
            pk.b("pointEventRecord error: ", th);
            oh.b(th);
        }
        return true;
    }

    public boolean b(d dVar) {
        if (dVar == null) {
            pk.b("endDisplaySession: adUnit is null");
            return false;
        }
        a(dVar, "close", "", null);
        return true;
    }

    public static void a(Map map, Object obj) {
        if (obj instanceof fh) {
            fh fhVar = (fh) obj;
            if (map != null) {
                try {
                    ((mh) fhVar).f469c = new JSONObject(map).toString();
                } catch (Throwable th) {
                    pk.b("pointEventRecord put extra error: ", th);
                    oh.b(th);
                }
            }
        }
    }
}
