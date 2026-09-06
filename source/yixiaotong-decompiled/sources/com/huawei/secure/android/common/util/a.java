package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4578a;
    private Character b;
    private Character c;
    private int d = 0;
    private int e = 0;

    public a(String str) {
        this.f4578a = str;
    }

    public static boolean c(Character ch) {
        char cCharValue;
        return ch != null && (cCharValue = ch.charValue()) >= '0' && cCharValue <= '7';
    }

    public void a(Character ch) {
        this.b = ch;
    }

    public int b() {
        return this.d;
    }

    public void c() {
        this.c = this.b;
        this.e = this.d;
    }

    public Character e() {
        Character chD = d();
        if (chD != null && b(chD)) {
            return chD;
        }
        return null;
    }

    public Character f() {
        Character chD = d();
        if (chD != null && c(chD)) {
            return chD;
        }
        return null;
    }

    protected String h() {
        String strSubstring = this.f4578a.substring(this.d);
        return this.b != null ? this.b + strSubstring : strSubstring;
    }

    public void i() {
        this.b = this.c;
        this.d = this.e;
    }

    public static boolean b(Character ch) {
        if (ch == null) {
            return false;
        }
        char cCharValue = ch.charValue();
        return (cCharValue >= '0' && cCharValue <= '9') || (cCharValue >= 'a' && cCharValue <= 'f') || (cCharValue >= 'A' && cCharValue <= 'F');
    }

    public Character g() {
        Character ch = this.b;
        if (ch != null) {
            return ch;
        }
        String str = this.f4578a;
        if (str == null || str.length() == 0 || this.d >= this.f4578a.length()) {
            return null;
        }
        return Character.valueOf(this.f4578a.charAt(this.d));
    }

    public boolean a() {
        if (this.b != null) {
            return true;
        }
        String str = this.f4578a;
        return (str == null || str.length() == 0 || this.d >= this.f4578a.length()) ? false : true;
    }

    public Character d() {
        Character ch = this.b;
        if (ch != null) {
            this.b = null;
            return ch;
        }
        String str = this.f4578a;
        if (str == null || str.length() == 0 || this.d >= this.f4578a.length()) {
            return null;
        }
        String str2 = this.f4578a;
        int i = this.d;
        this.d = i + 1;
        return Character.valueOf(str2.charAt(i));
    }

    public boolean a(char c) {
        Character ch = this.b;
        if (ch != null && ch.charValue() == c) {
            return true;
        }
        String str = this.f4578a;
        return str != null && str.length() != 0 && this.d < this.f4578a.length() && this.f4578a.charAt(this.d) == c;
    }
}
