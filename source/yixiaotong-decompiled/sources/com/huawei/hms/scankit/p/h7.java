package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: X12Encoder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class h7 extends b0 {
    h7() {
    }

    @Override // com.huawei.hms.scankit.p.b0
    public int a() {
        return 3;
    }

    @Override // com.huawei.hms.scankit.p.b0, com.huawei.hms.scankit.p.l2
    public void a(o2 o2Var) {
        StringBuilder sb = new StringBuilder();
        while (o2Var.i()) {
            char c = o2Var.c();
            o2Var.f++;
            a(c, sb);
            if (sb.length() % 3 == 0) {
                b0.b(o2Var, sb);
                if (m3.a(o2Var.d(), o2Var.f, a()) != a()) {
                    o2Var.b(0);
                    break;
                }
            }
        }
        a(o2Var, sb);
    }

    @Override // com.huawei.hms.scankit.p.b0
    int a(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
        } else {
            m3.a(c);
        }
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.b0
    void a(o2 o2Var, StringBuilder sb) {
        o2Var.l();
        int iA = o2Var.g().a() - o2Var.a();
        o2Var.f -= sb.length();
        if (o2Var.f() > 1 || iA > 1 || o2Var.f() != iA) {
            o2Var.a((char) 254);
        }
        if (o2Var.e() < 0) {
            o2Var.b(0);
        }
    }
}
