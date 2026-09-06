package com.byazt.gqp;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public enum u {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    public final String n;

    @Override // java.lang.Enum
    public String toString() {
        return this.n;
    }

    u(String str) {
        this.n = str;
    }

    public static u c(String str) throws IOException {
        u uVar = HTTP_1_0;
        if (str.equals(uVar.n)) {
            return uVar;
        }
        u uVar2 = HTTP_1_1;
        if (str.equals(uVar2.n)) {
            return uVar2;
        }
        u uVar3 = HTTP_2;
        if (str.equals(uVar3.n)) {
            return uVar3;
        }
        u uVar4 = SPDY_3;
        if (str.equals(uVar4.n)) {
            return uVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }
}
