package com.ubixnow.ooooo;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOo00o00 {
    private static final String OooO00o = BaseUtils.getContext().getPackageName() + "_mdnow_sdk";
    public static final String OooO0O0 = "oaid";
    public static final String OooO0OO = "aid";
    public static final String OooO0Oo = "oaid_save_time";
    public static final String OooO0o = "client_id";
    public static final String OooO0o0 = "aid_save_time";

    public class OooO implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ Boolean OooO0O0;

        public OooO(String str, Boolean bool) {
            this.OooO00o = str;
            this.OooO0O0 = bool;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
            o0oo0ooo.OooO00o = this.OooO00o;
            o0oo0ooo.OooO0O0 = this.OooO0O0 + "";
            o0O00O.OooO00o().OooO00o(o0oo0ooo);
        }
    }

    public class OooO00o implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ String OooO0O0;

        public OooO00o(String str, String str2) {
            this.OooO00o = str;
            this.OooO0O0 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
            o0oo0ooo.OooO00o = this.OooO00o;
            o0oo0ooo.OooO0O0 = this.OooO0O0;
            o0O00O.OooO00o().OooO00o(o0oo0ooo);
        }
    }

    public class OooO0O0 implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ float OooO0O0;

        public OooO0O0(String str, float f) {
            this.OooO00o = str;
            this.OooO0O0 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
            o0oo0ooo.OooO00o = this.OooO00o;
            o0oo0ooo.OooO0O0 = this.OooO0O0 + "";
            o0O00O.OooO00o().OooO00o(o0oo0ooo);
        }
    }

    public class OooO0OO implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ int OooO0O0;

        public OooO0OO(String str, int i) {
            this.OooO00o = str;
            this.OooO0O0 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
            o0oo0ooo.OooO00o = this.OooO00o;
            o0oo0ooo.OooO0O0 = this.OooO0O0 + "";
            o0O00O.OooO00o().OooO00o(o0oo0ooo);
        }
    }

    public class OooO0o implements Runnable {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ long OooO0O0;

        public OooO0o(String str, long j) {
            this.OooO00o = str;
            this.OooO0O0 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0oO0Ooo o0oo0ooo = new o0oO0Ooo();
            o0oo0ooo.OooO00o = this.OooO00o;
            o0oo0ooo.OooO0O0 = this.OooO0O0 + "";
            o0O00O.OooO00o().OooO00o(o0oo0ooo);
        }
    }

    public class OooOO0 implements Runnable {
        public final /* synthetic */ byte[] OooO00o;
        public final /* synthetic */ byte[] OooO0O0;
        public final /* synthetic */ String OooO0OO;
        public final /* synthetic */ long OooO0Oo;

        public OooOO0(byte[] bArr, byte[] bArr2, String str, long j) {
            this.OooO00o = bArr;
            this.OooO0O0 = bArr2;
            this.OooO0OO = str;
            this.OooO0Oo = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            byte[] bArr2 = this.OooO00o;
            if (bArr2 == null || bArr2.length <= 0 || (bArr = this.OooO0O0) == null || bArr.length <= 0) {
                return;
            }
            o0O00O.OooO00o().OooO00o(this.OooO0OO, this.OooO0Oo, this.OooO00o, this.OooO0O0);
        }
    }

    public class OooOO0O implements Runnable {
        public final /* synthetic */ byte[] OooO00o;
        public final /* synthetic */ String OooO0O0;
        public final /* synthetic */ long OooO0OO;

        public OooOO0O(byte[] bArr, String str, long j) {
            this.OooO00o = bArr;
            this.OooO0O0 = str;
            this.OooO0OO = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = this.OooO00o;
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            o0O00O.OooO00o().OooO00o(this.OooO0O0, this.OooO0OO, this.OooO00o);
        }
    }

    public static long OooO(String str) {
        return o0O00O.OooO00o().OooO0OO(str);
    }

    public static int OooO00o(String str, int i) {
        String strOooO00o = o0O00O.OooO00o().OooO00o(str);
        if (TextUtils.isEmpty(strOooO00o)) {
            return i;
        }
        try {
            return Integer.parseInt(strOooO00o);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public static Boolean OooO00o(String str) {
        boolean z;
        String strOooO00o = o0O00O.OooO00o().OooO00o(str);
        if (TextUtils.isEmpty(strOooO00o)) {
            return Boolean.FALSE;
        }
        try {
            z = Boolean.parseBoolean(strOooO00o);
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public static void OooO00o(String str, float f) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooO0O0(str, f));
    }

    public static void OooO00o(String str, long j) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooO0o(str, j));
    }

    public static void OooO00o(String str, long j, byte[] bArr) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooOO0O(bArr, str, j));
    }

    public static void OooO00o(String str, long j, byte[] bArr, byte[] bArr2) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooOO0(bArr, bArr2, str, j));
    }

    public static void OooO00o(String str, Boolean bool) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooO(str, bool));
    }

    public static void OooO00o(String str, String str2) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooO00o(str, str2));
    }

    public static void OooO00o(String... strArr) {
        o0O00O.OooO00o().OooO00o(strArr);
    }

    public static float OooO0O0(String str) {
        String strOooO00o = o0O00O.OooO00o().OooO00o(str);
        if (TextUtils.isEmpty(strOooO00o)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(strOooO00o);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static void OooO0O0(String str, int i) {
        g1.OooO00o("ubixnow_sp").OooO0OO(new OooO0OO(str, i));
    }

    public static void OooO0O0(String str, long j) {
        o0O00O.OooO00o().OooO00o(str, j);
    }

    public static void OooO0O0(String... strArr) {
        o0O00O.OooO00o().OooO0O0(strArr);
    }

    public static int OooO0OO(String str) {
        String strOooO00o = o0O00O.OooO00o().OooO00o(str);
        if (TextUtils.isEmpty(strOooO00o)) {
            return -1;
        }
        try {
            return Integer.parseInt(strOooO00o);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static long OooO0Oo(String str) {
        String strOooO00o = o0O00O.OooO00o().OooO00o(str);
        if (TextUtils.isEmpty(strOooO00o)) {
            return -1L;
        }
        try {
            return Long.parseLong(strOooO00o);
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public static byte[] OooO0o(String str) {
        return o0O00O.OooO00o().OooO0o0(str);
    }

    public static String OooO0o0(String str) {
        String strOooO00o;
        try {
            strOooO00o = o0O00O.OooO00o().OooO00o(str);
        } catch (Exception unused) {
            strOooO00o = null;
        }
        return strOooO00o == null ? "" : strOooO00o;
    }

    public static byte[] OooO0oO(String str) {
        return o0O00O.OooO00o().OooO0Oo(str);
    }

    public static byte[] OooO0oo(String str) {
        return o0O00O.OooO00o().OooO0o0(str);
    }

    public static void OooOO0(String str) {
        SharedPreferences.Editor editorEdit = BaseUtils.getContext().getSharedPreferences(OooO00o, 0).edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }
}
