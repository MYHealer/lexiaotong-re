package com.opos.mobad.f.b;

import com.opos.mobad.f.f;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6896a;
    public final String b;
    public final String c;
    public final String d;
    public int f = 0;
    public int g = 0;
    public final Set<f> e = new HashSet();

    public a(String str, String str2, String str3, String str4) {
        this.f6896a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str;
    }

    public void a(f fVar) {
        if (fVar != null) {
            if (this.e.size() > 0) {
                for (f fVar2 : this.e) {
                    if (fVar2 != null && (fVar2 == fVar || fVar2.hashCode() == fVar.hashCode())) {
                        return;
                    }
                }
            }
            this.e.add(fVar);
        }
    }

    public void b(f fVar) {
        if (fVar == null || this.e.size() <= 0) {
            return;
        }
        this.e.remove(fVar);
    }

    public String toString() {
        return "DownloadData{url='" + this.d + "', md5='" + this.c + "', appName='" + this.f6896a + "', pkgName='" + this.b + "'}";
    }
}
