package com.ubixnow.ooooo;

import android.content.Context;
import com.ubixnow.utils.BaseUtils;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O00O {
    private static o0O00O OooO00o;
    private static o0O00OOO OooO0O0;
    private static o0O00OO OooO0OO;

    private o0O00O() {
        if (BaseUtils.getContext() != null) {
            OooO00o(BaseUtils.getContext());
        }
    }

    public static o0O00O OooO00o() {
        if (OooO00o == null) {
            OooO00o = new o0O00O();
        }
        return OooO00o;
    }

    public synchronized String OooO00o(String str) {
        try {
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
        return OooO0O0.OooO00o(str);
    }

    public synchronized void OooO00o(Context context) {
        OooO0O0 = new o0O00OOO(context);
        OooO0OO = new o0O00OO(context);
    }

    public synchronized void OooO00o(o0oO0Ooo o0oo0ooo) {
        try {
            OooO0O0.OooO00o(o0oo0ooo);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void OooO00o(String str, long j) {
        try {
            OooO0OO.OooO00o(str, j);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void OooO00o(String str, long j, byte[] bArr) {
        try {
            OooO0OO.OooO00o(str, j, bArr);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void OooO00o(String str, long j, byte[] bArr, byte[] bArr2) {
        try {
            OooO0OO.OooO00o(str, j, bArr, bArr2);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void OooO00o(String... strArr) {
        try {
            OooO0O0.OooO00o(strArr);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized List<ooOOOOoo.OooO0OO> OooO0O0(String str) {
        try {
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
        return OooO0OO.OooO00o(str);
    }

    public synchronized void OooO0O0(String... strArr) {
        try {
            OooO0OO.OooO00o(strArr);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized long OooO0OO(String str) {
        try {
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return 0L;
        }
        return OooO0OO.OooO0O0(str);
    }

    public synchronized byte[] OooO0Oo(String str) {
        try {
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
        return OooO0OO.OooO0OO(str);
    }

    public synchronized byte[] OooO0o0(String str) {
        try {
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return null;
        }
        return OooO0OO.OooO0Oo(str);
    }
}
