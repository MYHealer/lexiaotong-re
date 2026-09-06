package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ep {
    private static final byte[] I = new byte[0];
    private static ep V;
    private final Map<String, Class<? extends ae>> B;
    private final Map<String, ae> Z = new HashMap();

    private ep() {
        HashMap map = new HashMap();
        this.B = map;
        map.put(ak.Z, es.class);
        map.put(ak.k, ex.class);
    }

    public static ep Code() {
        ep epVar;
        synchronized (I) {
            if (V == null) {
                V = new ep();
            }
            epVar = V;
        }
        return epVar;
    }

    public ae Code(String str) throws IllegalAccessException, InstantiationException {
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(str)) {
            ae aeVarNewInstance = this.Z.get(str);
            if (aeVarNewInstance == null) {
                fh.Code("JsbInterstitialManger", "create command %s", str);
                Class<? extends ae> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder("no class found for cmd: ");
                } else {
                    try {
                        aeVarNewInstance = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fh.I("JsbInterstitialManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fh.I("JsbInterstitialManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (aeVarNewInstance == null) {
                        sb = new StringBuilder("no instance created for cmd: ");
                    } else {
                        this.Z.put(str, aeVarNewInstance);
                    }
                }
                string = sb.append(str).toString();
            }
            return aeVarNewInstance;
        }
        string = "get cmd, method is empty";
        fh.I("JsbInterstitialManger", string);
        return null;
    }
}
