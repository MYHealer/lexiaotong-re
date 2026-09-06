package com.adprof.sdk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class i1 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f1220a;
    public List b;
    public List c;
    public List d;
    public List e;
    public List f;
    public List g;
    public List h;
    public List i;
    public List j;
    public List k;

    public i1(ij ijVar) {
        if (ijVar == null) {
            this.g = new ArrayList();
            this.h = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.f1220a = new ArrayList();
            this.b = new ArrayList();
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.i = new ArrayList();
            this.j = new ArrayList();
            this.k = new ArrayList();
            return;
        }
        this.g = ijVar.f1233a != null ? new ArrayList(ijVar.f1233a) : new ArrayList();
        this.h = ijVar.b != null ? new ArrayList(ijVar.b) : new ArrayList();
        this.c = ijVar.e != null ? new ArrayList(ijVar.e) : new ArrayList();
        this.d = ijVar.f != null ? new ArrayList(ijVar.f) : new ArrayList();
        this.f1220a = ijVar.g != null ? new ArrayList(ijVar.g) : new ArrayList();
        this.b = ijVar.h != null ? new ArrayList(ijVar.h) : new ArrayList();
        this.e = ijVar.i != null ? new ArrayList(ijVar.i) : new ArrayList();
        this.f = ijVar.j != null ? new ArrayList(ijVar.j) : new ArrayList();
        this.i = ijVar.c != null ? new ArrayList(ijVar.c) : new ArrayList();
        this.j = ijVar.d != null ? new ArrayList(ijVar.d) : new ArrayList();
        this.k = new ArrayList();
        List list = ijVar.k;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.k.add(new h1((ej) it.next()));
            }
        }
    }
}
