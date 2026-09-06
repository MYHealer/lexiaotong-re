package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4649a;

    public bl(Context context) {
        this.f4649a = context;
    }

    public String a(String str, String str2) {
        try {
            return c(str, new String(c.a(str2.getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String a(String str) {
        try {
            return b(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            String str2 = new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            return new String(d.b(i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), c.a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str, String str2) {
        byte[] bArrA;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] bArrA2 = c.a(str.getBytes(), 2);
            if (Engine.loadSuccess) {
                bArrA = Engine.getInstance(this.f4649a).dr(Engine.getInstance(this.f4649a).dc(bArrA2, str2.substring(0, 16).getBytes()), str2.getBytes());
            } else {
                bArrA = i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), bArrA2), str2.substring(0, 16));
            }
            return new String(d.b(bArrA));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str) {
        try {
            return c(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(String str, String str2) {
        byte[] bArrA;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                for (int i = 0; i < 16 - length; i++) {
                    sb.append("0");
                }
                str2 = sb.toString();
            } else if (str2.length() > 16) {
                str2 = str2.substring(0, 16);
            }
            byte[] bArrA2 = d.a(str.getBytes());
            if (Engine.loadSuccess) {
                bArrA = Engine.getInstance(this.f4649a).ac(Engine.getInstance(this.f4649a).ar(bArrA2, str2.getBytes()), str2.substring(0, 16).getBytes());
            } else {
                try {
                    bArrA = b.a(str2.substring(0, 16), str2.substring(0, 16), i.b(bArrA2, str2));
                } catch (Throwable unused) {
                    bArrA = null;
                }
            }
            if (bArrA != null && bArrA.length > 0) {
                return c.b(bArrA, 2);
            }
        } catch (Exception unused2) {
        }
        return null;
    }
}
