package com.byazt.uq;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 67})
public class u {
    public static volatile u c;
    public com.byazt.uk.da tt;

    public void c(com.byazt.uk.da daVar) {
        this.tt = daVar;
    }

    public static u c() {
        if (c == null) {
            synchronized (u.class) {
                if (c == null) {
                    c = new u();
                }
            }
        }
        return c;
    }

    private com.byazt.uk.da tt() {
        if (this.tt == null) {
            ZeusLogger.errReport("zeussp", "getKvStore kvStore is null");
            this.tt = new com.byazt.uk.da() { // from class: com.byazt.uq.u.1
                @Override // com.byazt.uk.da
                public int c(String str, int i) {
                    return 0;
                }

                @Override // com.byazt.uk.da
                public void c(String str) {
                }

                @Override // com.byazt.uk.da
                public void c(String str, String str2) {
                }

                @Override // com.byazt.uk.da
                public void c(String str, boolean z) {
                }

                @Override // com.byazt.uk.da
                public String tt(String str, String str2) {
                    return "";
                }

                @Override // com.byazt.uk.da
                public void tt(String str, int i) {
                }

                @Override // com.byazt.uk.da
                public boolean tt(String str, boolean z) {
                    return false;
                }
            };
        }
        return this.tt;
    }

    public void c(String str) {
        tt().c("282a382c132a362d25".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
    }

    public boolean tt(String str) {
        return !TextUtils.isEmpty(tt().tt("322a2627002a273025".concat(String.valueOf(str)), ""));
    }

    public boolean ve(String str) {
        return !TextUtils.equals(tt().tt("322a2627002a273025".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
    }

    public void uj(String str) {
        tt().tt("322a2627002a273025".concat(String.valueOf(str)), "");
        tt().c("322a2627002a273025".concat(String.valueOf(str)), Zeus.getHostAbi());
    }

    public int n(String str) {
        return tt().c("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), 0);
    }

    public void c(String str, int i) {
        if (n(str) != i) {
            tt().tt("2a29203416253a382a2c2a251a393630352b2a".concat(String.valueOf(str)), i);
        }
    }

    public String a(String str) {
        return tt().tt("322a26270022213c34313c270634".concat(String.valueOf(str)), "");
    }

    public void c(String str, String str2) {
        if (TextUtils.equals(a(str), str2)) {
            return;
        }
        tt().c("322a26270022213c34313c270634".concat(String.valueOf(str)), str2);
    }

    public void c(String str, int i, int i2, int i3) {
        tt().tt("3b353c2c12222b26" + str + "_" + i, i2);
        tt().tt("3b353c2c122a3d26" + str + "_" + i, i3);
    }

    public int tt(String str, int i) {
        return tt().c("3b353c2c12222b26" + str + "_" + i, 0);
    }

    public int ve(String str, int i) {
        int iC = tt().c("3b353c2c122a3d26" + str + "_" + i, Integer.MAX_VALUE);
        if (iC == 0) {
            return Integer.MAX_VALUE;
        }
        return iC;
    }

    public void sp(String str) {
        tt().c("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), true);
    }

    public void x(String str) {
        tt().c("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)));
    }

    public boolean i(String str) {
        return tt().tt("2f2b3c3d0c3f2435363a_".concat(String.valueOf(str)), false);
    }

    public String da(String str) {
        return tt().tt("3321303d0b22312025".concat(String.valueOf(str)), "");
    }

    public void tt(String str, String str2) {
        tt().c("3321303d0b22312025".concat(String.valueOf(str)), str2);
    }

    public void c(String str, int i, boolean z) {
        String str2 = "332b26271e27293c3e3a" + str + com.huawei.openalliance.ad.constant.x.A + i;
        if (z) {
            tt().c(str2, true);
        } else {
            tt().c(str2);
        }
    }

    public boolean uj(String str, int i) {
        return tt().tt(String.format(Locale.getDefault(), "332b26271e27293c3e3a%s-%d", str, Integer.valueOf(i)), false);
    }

    public boolean n(String str, int i) {
        return tt().c(String.format(Locale.getDefault(), "3523333f16252026332b21360d25243525%s", str), -1) == i;
    }

    public void tt(String str, int i, boolean z) {
        tt().c("1e000d2c301b1126091114073a34" + str + "_" + i, z);
    }

    public boolean a(String str, int i) {
        return tt().tt("1e000d2c301b1126091114073a34" + str + "_" + i, false);
    }

    public boolean sp(String str, int i) {
        return tt().tt("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, false);
    }

    public void ve(String str, int i, boolean z) {
        tt().c("1e000d2c2d0e08160c002a002b0a111c25" + str + "_" + i, z);
    }

    public void c(String str, int i, int i2) {
        tt().tt("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, i2);
    }

    public int x(String str, int i) {
        return tt().c("0800181c290e3a1c1411070a000d09181d3a" + str + "_" + i, 0);
    }

    public void c(String str, int i, String str2) {
        tt().tt(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, tt(str, i, str2) + 1);
    }

    public int tt(String str, int i, String str2) {
        return tt().c(str2 + "2503141a330e0126190a001d2b3412111f0b2a01323400170e170c2c" + str + "_" + i, 0);
    }

    public void ve(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt().c("3b293c320c34".concat(String.valueOf(a.c(str))), str2);
    }

    public String sl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return tt().tt("3b293c320c34".concat(String.valueOf(a.c(str))), "");
    }

    public void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt().c("3b293c320c34".concat(String.valueOf(a.c(str))));
    }

    public void uj(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strC = a.c(str);
        String strTt = tt().tt("3b293c320c34293829312a2716262026".concat(String.valueOf(strC)), "");
        if (TextUtils.isEmpty(strTt)) {
            tt().c("3b293c320c34293829312a2716262026".concat(String.valueOf(strC)), str2);
        } else {
            tt().c("3b293c320c34293829312a2716262026".concat(String.valueOf(strC)), strTt + "_" + str2);
        }
    }

    public List<String> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTt = tt().tt("3b293c320c34293829312a2716262026".concat(String.valueOf(a.c(str))), "");
        if (TextUtils.isEmpty(strTt)) {
            return null;
        }
        return Arrays.asList(strTt.split("_"));
    }

    public void yp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt().c("3b293c320c34293829312a2716262026".concat(String.valueOf(a.c(str))));
    }
}
