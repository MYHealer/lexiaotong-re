package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOo0o0oO {
    public static String OooO00o(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            int i = Integer.parseInt(o0OO000o.OooO0O0);
            int i2 = 0;
            while (i2 < str.length()) {
                int i3 = i2 + 8;
                String strSubstring = str.substring(i2, i3);
                i2 += 16;
                String strSubstring2 = str.substring(i3, i2);
                byte b = (byte) Integer.parseInt(strSubstring, 2);
                sb.append((char) ((((byte) (((byte) Integer.parseInt(strSubstring2, 2)) ^ i)) & 255) | ((((byte) (b ^ i)) << 8) & 65535)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void OooO00o() {
        if (o0OO000o.o00O00OO.equals(o0OO000o.o00O00Oo)) {
            o0OO000o.o00O00Oo = OooO00o(o0OO000o.o00O00Oo);
            o0OO000o.o00O000o = OooO00o(o0OO000o.o00O000o);
            o0OO000o.o00O00 = OooO00o(o0OO000o.o00O00);
            o0OO000o.o000o00o = OooO00o(o0OO000o.o000o00o);
            oOO00O.OooO00o = OooO00o(oOO00O.OooO00o);
            oOO00O.OooO0O0 = OooO00o(oOO00O.OooO0O0);
            oOO00O.OooO0OO = OooO00o(oOO00O.OooO0OO);
            oOO00O.OooO0Oo = OooO00o(oOO00O.OooO0Oo);
            oOO00O.OooO0o0 = OooO00o(oOO00O.OooO0o0);
            oOO00O.OooO0o = OooO00o(oOO00O.OooO0o);
            oOO00O.OooO0oO = OooO00o(oOO00O.OooO0oO);
            o0OO000o.o000OO0o = OooO00o(o0OO000o.o000OO0o);
            o0O0OOO0.OooO0O0 = OooO00o(o0O0OOO0.OooO0O0);
        }
    }
}
