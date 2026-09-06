package com.jd.ad.sdk.jad_kv;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public static final jad_er.jad_an<?> jad_bo = new jad_an();
    public final Map<Class<?>, jad_er.jad_an<?>> jad_an = new HashMap();

    public class jad_an implements jad_er.jad_an<Object> {
        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public jad_er<Object> jad_an(Object obj) {
            return new jad_bo(obj);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public Class<Object> jad_an() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public static final class jad_bo implements jad_er<Object> {
        public final Object jad_an;

        public jad_bo(Object obj) {
            this.jad_an = obj;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er
        public Object jad_an() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er
        public void jad_bo() {
        }
    }
}
