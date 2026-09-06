package com.hihonor.hianalytics.hnha;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3664a;
    private List<p3> b = new LinkedList();

    n3(String str) {
        this.f3664a = str;
    }

    public m3 a(byte[] bArr, Map<String, String> map) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            p3 p3Var = this.b.get(i);
            if (p3Var.a()) {
                m3 m3VarA = l3.a(p3Var.f3671a, bArr, map);
                j2.c("ReportInstance", "response code : " + m3VarA.b());
                if (-104 != m3VarA.b()) {
                    p3Var.c();
                    return m3VarA;
                }
                p3Var.b();
            } else {
                j2.c("ReportInstance " + this.f3664a, "No." + i + " address failed more than 5 times. Try with backup address...");
            }
        }
        j2.c("ReportInstance " + this.f3664a, "All backup address not valid.");
        return new m3(-107, "");
    }

    public void a(String[] strArr) {
        for (String str : strArr) {
            this.b.add(new p3(str));
        }
    }
}
