package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ew {
    private static final byte[] I = new byte[0];
    private static ew V;
    private final Map<String, Class<? extends ae>> B;
    private final Map<String, ae> Z = new HashMap();

    private ew() {
        HashMap map = new HashMap();
        this.B = map;
        map.put(ak.I, ev.class);
        map.put(ak.j, ey.class);
    }

    public static ew Code() {
        ew ewVar;
        synchronized (I) {
            if (V == null) {
                V = new ew();
            }
            ewVar = V;
        }
        return ewVar;
    }

    public ae Code(String str) throws IllegalAccessException, InstantiationException {
        StringBuilder sb;
        String string;
        if (!TextUtils.isEmpty(str)) {
            ae aeVarNewInstance = this.Z.get(str);
            if (aeVarNewInstance == null) {
                fh.V("JsbRewardManger", "create command " + str);
                Class<? extends ae> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder("no class found for cmd: ");
                } else {
                    try {
                        aeVarNewInstance = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fh.I("JsbRewardManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fh.I("JsbRewardManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
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
        fh.I("JsbRewardManger", string);
        return null;
    }
}
