package com.hihonor.adsdk.common.b.i;

import com.hihonor.adsdk.common.b.g;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e implements com.hihonor.adsdk.common.b.a {
    private static final int hnadsc = 4000;
    private static final String hnadsd = "HiAds-";
    public static String hnadse = "10024111";
    public static String hnadsf = "env_prod";
    private final boolean hnadsa;
    private final g hnadsb;

    static /* synthetic */ class a {
    }

    public static class b {
        boolean hnadsa;
        g hnadsb;

        /* synthetic */ b(a aVar) {
            this();
        }

        public b hnadsa(g gVar) {
            this.hnadsb = gVar;
            return this;
        }

        public b hnadsa(boolean z) {
            this.hnadsa = z;
            return this;
        }

        private b() {
            this.hnadsa = true;
        }

        public e hnadsa() {
            if (this.hnadsb == null) {
                this.hnadsb = new d();
            }
            return new e(this, null);
        }
    }

    /* synthetic */ e(b bVar, a aVar) {
        this(bVar);
    }

    public static b hnadsa() {
        return new b(null);
    }

    private e(b bVar) {
        this.hnadsa = bVar.hnadsa;
        this.hnadsb = bVar.hnadsb;
    }

    private void hnadsb(int i, String str, String str2) {
        g gVar = this.hnadsb;
        if (gVar != null) {
            gVar.hnadsa(i, str, str2);
        }
    }

    @Override // com.hihonor.adsdk.common.b.a
    public void hnadsa(int i, String str, String str2) {
        String str3 = "[" + hnadse + x.A + hnadsf + "]";
        String str4 = hnadsd + str;
        String str5 = str3 + str2;
        byte[] bytes = (str5 + str4).getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            hnadsb(i, str4, str5);
            return;
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            hnadsb(i, str4, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
    }
}
