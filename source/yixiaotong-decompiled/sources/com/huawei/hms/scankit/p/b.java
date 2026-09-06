package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: ASCIIEncoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class b implements l2 {
    b() {
    }

    public int a() {
        return 0;
    }

    @Override // com.huawei.hms.scankit.p.l2
    public void a(o2 o2Var) {
        if (m3.a(o2Var.d(), o2Var.f) >= 2) {
            o2Var.a(a(o2Var.d().charAt(o2Var.f), o2Var.d().charAt(o2Var.f + 1)));
            o2Var.f += 2;
            return;
        }
        char c = o2Var.c();
        int iA = m3.a(o2Var.d(), o2Var.f, a());
        if (iA == a()) {
            if (!m3.c(c)) {
                o2Var.a((char) (c + 1));
                o2Var.f++;
                return;
            } else {
                o2Var.a((char) 235);
                o2Var.a((char) (c - 127));
                o2Var.f++;
                return;
            }
        }
        if (iA == 1) {
            o2Var.a((char) 230);
            o2Var.b(1);
            return;
        }
        if (iA == 2) {
            o2Var.a((char) 239);
            o2Var.b(2);
            return;
        }
        if (iA == 3) {
            o2Var.a((char) 238);
            o2Var.b(3);
        } else if (iA == 4) {
            o2Var.a((char) 240);
            o2Var.b(4);
        } else {
            if (iA != 5) {
                throw new IllegalStateException("Illegal mode: " + iA);
            }
            o2Var.a((char) 231);
            o2Var.b(5);
        }
    }

    private static char a(char c, char c2) {
        if (m3.b(c) && m3.b(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
