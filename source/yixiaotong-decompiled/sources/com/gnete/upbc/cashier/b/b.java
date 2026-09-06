package com.gnete.upbc.cashier.b;

import com.cdo.oaps.ad.OapsKey;
import com.gnete.upbc.cashier.GnetePayChannel;
import java.io.Serializable;

/* JADX INFO: compiled from: CashierData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3271a;
    private String b;
    private String c;
    private String d;
    private String e;
    private GnetePayChannel f;
    private i g;
    private e h;

    private b() {
    }

    public static b a(String str) {
        return new b(str);
    }

    public void a(GnetePayChannel gnetePayChannel) {
        this.f = gnetePayChannel;
    }

    public String b() {
        return this.d;
    }

    public void b(e eVar) {
        this.h = eVar;
    }

    public void b(i iVar) {
        this.g = iVar;
    }

    public String c() {
        return this.f3271a;
    }

    public e d() {
        return this.h;
    }

    public i e() {
        return this.g;
    }

    public GnetePayChannel f() {
        return this.f;
    }

    public com.gnete.upbc.cashier.g.a.C0391a g() {
        return com.gnete.upbc.cashier.g.a.b().b(OapsKey.KEY_TOKEN, this.b).b("gwId", this.c).b("busiMerNo", this.d).b("merOrdrNo", this.e);
    }

    public String h() {
        return String.format("token=%s&gwId=%s&busiMerNo=%s&merOrdrNo=%s", this.b, this.c, this.d, this.e);
    }

    private b(String str) {
        this.f3271a = str;
        String[] strArrSplit = str.split("[?]");
        if (strArrSplit.length > 1) {
            for (String str2 : strArrSplit[1].split("[&]")) {
                String[] strArrSplit2 = str2.split("[=]");
                String str3 = strArrSplit2.length > 1 ? strArrSplit2[1] : "";
                String str4 = strArrSplit2[0];
                str4.hashCode();
                str4.hashCode();
                switch (str4) {
                    case "busiMerNo":
                        this.d = str3;
                        break;
                    case "gwId":
                        this.c = str3;
                        break;
                    case "token":
                        this.b = str3;
                        break;
                    case "merOrdrNo":
                        this.e = str3;
                        break;
                }
            }
        }
    }

    public b a(i iVar) {
        b bVarA = a();
        bVarA.g = iVar;
        return bVarA;
    }

    public b a(e eVar) {
        b bVarA = a();
        bVarA.h = eVar;
        return bVarA;
    }

    public b a() {
        b bVar = new b();
        bVar.b = this.b;
        bVar.c = this.c;
        bVar.d = this.d;
        bVar.e = this.e;
        bVar.f = this.f;
        return bVar;
    }
}
