package com.jd.ad.sdk.jad_qb;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jw implements jad_hu {
    public final Map<String, List<jad_iv>> jad_bo;
    public volatile Map<String, String> jad_cp;

    public static final class jad_an {
        public static final Map<String, List<jad_iv>> jad_bo;
        public Map<String, List<jad_iv>> jad_an = jad_bo;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char cCharAt = property.charAt(i);
                    if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                        cCharAt = '?';
                    }
                    sb.append(cCharAt);
                }
                property = sb.toString();
            }
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                map.put("User-Agent", Collections.singletonList(new jad_bo(property)));
            }
            jad_bo = Collections.unmodifiableMap(map);
        }
    }

    public static final class jad_bo implements jad_iv {
        public final String jad_an;

        public jad_bo(String str) {
            this.jad_an = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof jad_bo) {
                return this.jad_an.equals(((jad_bo) obj).jad_an);
            }
            return false;
        }

        public int hashCode() {
            return this.jad_an.hashCode();
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_iv
        public String jad_an() {
            return this.jad_an;
        }

        public String toString() {
            return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("StringHeaderFactory{value='").append(this.jad_an).append('\'').append('}').toString();
        }
    }

    public jad_jw(Map<String, List<jad_iv>> map) {
        this.jad_bo = Collections.unmodifiableMap(map);
    }

    public boolean equals(Object obj) {
        if (obj instanceof jad_jw) {
            return this.jad_bo.equals(((jad_jw) obj).jad_bo);
        }
        return false;
    }

    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_hu
    public Map<String, String> jad_an() {
        if (this.jad_cp == null) {
            synchronized (this) {
                if (this.jad_cp == null) {
                    this.jad_cp = Collections.unmodifiableMap(jad_bo());
                }
            }
        }
        return this.jad_cp;
    }

    public final Map<String, String> jad_bo() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<jad_iv>> entry : this.jad_bo.entrySet()) {
            List<jad_iv> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                String strJad_an = value.get(i).jad_an();
                if (!TextUtils.isEmpty(strJad_an)) {
                    sb.append(strJad_an);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put(entry.getKey(), string);
            }
        }
        return map;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_gr.jad_ly.jad_an("LazyHeaders{headers=").append(this.jad_bo).append('}').toString();
    }
}
