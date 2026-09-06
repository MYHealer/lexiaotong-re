package com.opos.mobad.service.h;

import com.opos.cmn.i.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7386a;
    private StringBuilder b = new StringBuilder();

    public b(String str) {
        this.f7386a = str;
    }

    public b a() {
        this.b.append(this.f7386a);
        return this;
    }

    public b a(float f) {
        if (this.b.length() > 0) {
            this.b.append(this.f7386a);
        }
        this.b.append(f);
        return this;
    }

    public b a(int i) {
        if (this.b.length() > 0) {
            this.b.append(this.f7386a);
        }
        this.b.append(i);
        return this;
    }

    public b a(b bVar) {
        if (this.b.length() > 0) {
            this.b.append(this.f7386a);
        }
        this.b.append((CharSequence) bVar.b);
        return this;
    }

    public b a(String str) {
        if (this.b.length() > 0) {
            this.b.append(this.f7386a);
        }
        this.b.append(o.a(str));
        return this;
    }

    public String toString() {
        return this.b.toString();
    }
}
