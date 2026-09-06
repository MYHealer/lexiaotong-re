package com.ubixnow.ooooo;

import android.os.Build;
import android.text.TextUtils;
import com.ubixnow.utils.BaseUtils;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h1 {
    public static h1 OooO00o;
    public String OooOoO;
    public String OooOoO0;
    public String OooO0O0 = OooO00o(i1.OooO0o);
    public String OooO0OO = OooO00o(i1.OooO0oO);
    public String OooO0Oo = OooO00o(Build.MODEL);
    public int OooO0o0 = i1.OooOOO;
    public int OooO0o = i1.OooOOOO;
    public int OooO0oO = i1.OooOO0O();
    public int OooO0oo = 1;
    public String OooO = OooO00o(i1.OooO0o0());
    public String OooOO0 = OooO00o(Build.VERSION.RELEASE);
    public String OooOO0O = OooO00o(Build.MANUFACTURER);
    public String OooOO0o = OooO00o(Build.BRAND);
    public String OooOOO0 = OooO00o(Build.PRODUCT);
    public String OooOOO = OooO00o(Build.CPU_ABI);
    public String OooOOOO = OooO00o(Build.HARDWARE);
    public String OooOOOo = OooO00o(Locale.getDefault().getLanguage());
    public int OooOOo0 = i1.OooO0oo();
    public float OooOOo = i1.OooO0Oo();
    public String OooOOoo = OooO00o(Build.DEVICE);
    public int OooOo00 = i1.OooO();
    public String OooOo0 = OooO00o(i1.OooO0OO());
    public String OooOo0O = OooO00o(i1.OooOOo0());
    public String OooOo0o = OooO00o(BaseUtils.getContext().getPackageName());
    public String OooOo = OooO00o(i1.OooO0o());

    private String OooO00o(int i) {
        if (!TextUtils.isEmpty(this.OooOoO0)) {
            return this.OooOoO0;
        }
        if (i != 2 && i != 3) {
            return this.OooOoO0;
        }
        String str = i1.OooOOOO() == 1 ? "1" : "2";
        this.OooOoO0 = str;
        return str;
    }

    public static h1 OooO0O0() {
        if (OooO00o == null) {
            synchronized (h1.class) {
                if (OooO00o == null) {
                    OooO00o = new h1();
                }
            }
        }
        return OooO00o;
    }

    private String OooO0O0(int i) {
        if (!TextUtils.isEmpty(this.OooOoO)) {
            return this.OooOoO;
        }
        if (i != 2 && i != 3) {
            return this.OooOoO;
        }
        String str = i1.OooOOOo() == 2 ? "2" : "1";
        this.OooOoO = str;
        return str;
    }

    public h1 OooO00o(boolean z) {
        this.OooO0OO = OooO00o(i1.OooO00o(z));
        this.OooO0O0 = OooO00o(i1.OooO0O0(z));
        return OooO00o;
    }

    public String OooO00o(String str) {
        return str == null ? "" : str;
    }

    public void OooO00o() {
        OooO0O0(oO00000o.o00O0O.OooOOo);
        OooO00o(oO00000o.o00O0O.OooOOoo);
    }

    public boolean OooO0OO() {
        int i = oO00000o.o00O0O.OooOOo;
        int i2 = oO00000o.o00O0O.OooOOoo;
        return ("2".equals(OooO0O0(i)) && i == 3) || ("1".equals(OooO00o(i2)) && i2 == 3);
    }
}
