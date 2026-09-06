package com.jd.ad.sdk.jad_gr;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public final Map<Class<?>, Object> jad_an;

    public static final class jad_an {
        public final Map<Class<?>, Object> jad_an = new HashMap();
    }

    public jad_fs(jad_an jad_anVar) {
        this.jad_an = Collections.unmodifiableMap(new HashMap(jad_anVar.jad_an));
    }

    public boolean jad_an(Class<Object> cls) {
        return this.jad_an.containsKey(cls);
    }
}
