package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: EdifactEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class i2 implements l2 {
    i2() {
    }

    public int a() {
        return 4;
    }

    @Override // com.huawei.hms.scankit.p.l2
    public void a(o2 o2Var) {
        StringBuilder sb = new StringBuilder();
        while (o2Var.i()) {
            a(o2Var.c(), sb);
            o2Var.f++;
            if (sb.length() >= 4) {
                o2Var.a(a(sb, 0));
                sb.delete(0, 4);
                if (m3.a(o2Var.d(), o2Var.f, a()) != a()) {
                    o2Var.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(o2Var, sb);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x007e A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:3:0x0001, B:9:0x000f, B:11:0x0025, B:20:0x0046, B:26:0x0057, B:28:0x006f, B:31:0x0087, B:30:0x007e, B:34:0x008e, B:35:0x0095), top: B:39:0x0001 }] */
    private static void a(o2 o2Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                o2Var.b(0);
                return;
            }
            boolean z = true;
            if (length == 1) {
                o2Var.l();
                int iA = o2Var.g().a() - o2Var.a();
                int iF = o2Var.f();
                if (iF > iA) {
                    o2Var.c(o2Var.a() + 1);
                    iA = o2Var.g().a() - o2Var.a();
                }
                if (iF <= iA && iA <= 2) {
                    o2Var.b(0);
                    return;
                }
            }
            if (length <= 4) {
                int i = length - 1;
                String strA = a(charSequence, 0);
                if (!(!o2Var.i()) || i > 2) {
                    z = false;
                }
                if (i <= 2) {
                    o2Var.c(o2Var.a() + i);
                    if (o2Var.g().a() - o2Var.a() >= 3) {
                        o2Var.c(o2Var.a() + strA.length());
                    } else if (z) {
                        o2Var.k();
                        o2Var.f -= i;
                    }
                    o2Var.a(strA);
                } else if (z) {
                    o2Var.k();
                    o2Var.f -= i;
                } else {
                    o2Var.a(strA);
                }
                o2Var.b(0);
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } catch (Throwable th) {
            o2Var.b(0);
            throw th;
        }
    }

    private static void a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c >= '@' && c <= '^') {
            sb.append((char) (c - '@'));
        } else {
            m3.a(c);
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
            char c = (char) ((iCharAt >> 16) & 255);
            char c2 = (char) ((iCharAt >> 8) & 255);
            char c3 = (char) (iCharAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c);
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
