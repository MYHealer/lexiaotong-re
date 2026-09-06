package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: C40Encoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class b0 implements l2 {
    b0() {
    }

    static void b(o2 o2Var, StringBuilder sb) {
        o2Var.a(a(sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.l2
    public void a(o2 o2Var) {
        StringBuilder sb = new StringBuilder();
        while (o2Var.i()) {
            char c = o2Var.c();
            o2Var.f++;
            int iA = a(c, sb);
            int iA2 = o2Var.a() + ((sb.length() / 3) * 2);
            o2Var.c(iA2);
            int iA3 = o2Var.g().a() - iA2;
            if (!o2Var.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA3 < 2 || iA3 > 2)) {
                    iA = a(o2Var, sb, sb2, iA);
                }
                while (sb.length() % 3 == 1 && ((iA <= 3 && iA3 != 1) || iA > 3)) {
                    iA = a(o2Var, sb, sb2, iA);
                }
                break;
            }
            if (sb.length() % 3 == 0 && m3.a(o2Var.d(), o2Var.f, a()) != a()) {
                o2Var.b(0);
                break;
            }
        }
        a(o2Var, sb);
    }

    private int a(o2 o2Var, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        o2Var.f--;
        int iA = a(o2Var.c(), sb2);
        o2Var.k();
        return iA;
    }

    void a(o2 o2Var, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int iA = o2Var.a() + length;
        o2Var.c(iA);
        int iA2 = o2Var.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(o2Var, sb);
            }
            if (o2Var.i()) {
                o2Var.a((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(o2Var, sb);
            }
            if (o2Var.i()) {
                o2Var.a((char) 254);
            }
            o2Var.f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(o2Var, sb);
            }
            if (iA2 > 0 || o2Var.i()) {
                o2Var.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                x3.b("exception", "Exception");
            }
        }
        o2Var.b(0);
    }

    int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }
}
