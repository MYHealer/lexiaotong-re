package com.adprof.sdk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public m0 f518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f520a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List f521b;

    public o0(wi wiVar) {
        this.f519a = "";
        this.b = "";
        this.f518a = null;
        if (wiVar != null) {
            try {
                Integer num = wiVar.f804a;
                this.f1332a = num != null ? num.intValue() : 0;
                try {
                    if (pk.m706a()) {
                        xi.m726a(wiVar);
                        pk.d("server返回数据 template_type = " + this.f1332a);
                    }
                } catch (Throwable unused) {
                }
                this.f520a = new ArrayList();
                List list = wiVar.f805a;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        this.f520a.add(new m0((kj) it.next()));
                    }
                }
                this.f521b = new ArrayList();
                List list2 = wiVar.f806b;
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        this.f521b.add(new n0((qj) it2.next()));
                    }
                }
                oj ojVar = wiVar.f803a;
                if (ojVar != null) {
                    this.f519a = ojVar.f1347a;
                }
                oj ojVar2 = wiVar.b;
                if (ojVar2 != null) {
                    this.b = ojVar2.f1347a;
                }
                kj kjVar = wiVar.f1503a;
                if (kjVar != null) {
                    this.f518a = new m0(kjVar);
                }
            } catch (Throwable th) {
                pk.b("adprofsdk", th);
            }
        }
    }
}
