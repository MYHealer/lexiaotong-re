package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private static final String c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f6101a;
    Context b;

    /* JADX INFO: renamed from: com.opos.cmn.func.dl.base.a.a$a, reason: collision with other inner class name */
    static class C0890a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6102a;
        String b;
        String c;
        long d;
        boolean e;
        boolean f = false;

        C0890a() {
        }
    }

    public a(b bVar) {
        this.f6101a = bVar;
        this.b = bVar.f6108a;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00ab  */
    public final C0890a a() {
        String str;
        C0890a c0890a = new C0890a();
        c0890a.c = this.f6101a.h;
        if (!TextUtils.isEmpty(c0890a.c)) {
            File file = new File(this.f6101a.g, c0890a.c);
            c0890a.f = com.opos.cmn.an.e.b.a.a(file) && com.opos.cmn.func.dl.base.i.a.a(this.f6101a.d, file) && !this.f6101a.q.h;
            if (c0890a.f) {
                c0890a.d = com.opos.cmn.an.e.b.a.g(file);
            }
        }
        if (!c0890a.f) {
            com.opos.cmn.func.dl.base.c.a aVar = new com.opos.cmn.func.dl.base.c.a(this.f6101a.r);
            try {
                try {
                    try {
                        InputStream inputStreamA = aVar.a(this.f6101a.p.e(), this.f6101a.e, new com.opos.cmn.func.dl.base.c.b(this.f6101a.q.j));
                        int iD = aVar.d();
                        if (inputStreamA == null) {
                            if (com.opos.cmn.an.h.c.a.d(this.b)) {
                                throw new DlException(1001, iD, aVar.b());
                            }
                            throw new DlException(1003, iD);
                        }
                        String strA = aVar.a("Content-Type");
                        if (TextUtils.isEmpty(strA)) {
                            str = "";
                        } else {
                            String[] strArrSplit = strA.split(";");
                            if (strArrSplit.length > 0) {
                                str = strArrSplit[0];
                            } else {
                                str = "";
                            }
                        }
                        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("text/html")) {
                            throw new DlException(1014);
                        }
                        c0890a.d = aVar.e();
                        c0890a.e = aVar.d() == 206 ? true : "bytes".equals(aVar.a("Accept-Ranges"));
                        c0890a.f6102a = aVar.f6117a.a();
                        c0890a.b = str;
                        String strC = this.f6101a.h;
                        if (TextUtils.isEmpty(strC)) {
                            strC = com.opos.cmn.func.dl.base.i.a.c(aVar.a("Content-Disposition"));
                        }
                        c0890a.c = strC;
                        aVar.c();
                        if (TextUtils.isEmpty(c0890a.c)) {
                            c0890a.c = com.opos.cmn.func.dl.base.i.a.d(TextUtils.isEmpty(c0890a.f6102a) ? this.f6101a.e : c0890a.f6102a);
                        }
                        File file2 = new File(this.f6101a.g, c0890a.c);
                        c0890a.f = com.opos.cmn.an.e.b.a.a(file2) && com.opos.cmn.func.dl.base.i.a.a(c0890a.d, file2) && com.opos.cmn.func.dl.base.i.a.a(this.f6101a.d, file2) && !this.f6101a.q.h;
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c(c, " check failed2!url:" + this.f6101a.e + ",error msg:" + e.getMessage());
                        throw new DlException(1001, e);
                    }
                } catch (DlException e2) {
                    com.opos.cmn.an.f.a.c(c, " check failed1!url:" + this.f6101a.e + ",error msg:" + e2.toString());
                    throw e2;
                }
            } catch (Throwable th) {
                aVar.c();
                throw th;
            }
        }
        this.f6101a.h = c0890a.c;
        this.f6101a.q.c = c0890a.c;
        this.f6101a.k = c0890a.d;
        this.f6101a.m = c0890a.e;
        this.f6101a.f = c0890a.f6102a;
        if (c0890a.f) {
            long length = c0890a.d > 0 ? c0890a.d : this.f6101a.a().length();
            this.f6101a.a(length);
            this.f6101a.l = length;
        }
        return c0890a;
    }

    public final void a(boolean z) throws DlException {
        b bVar = this.f6101a;
        if (z) {
            bVar.n = true;
        }
        if (!z && !bVar.n && !bVar.q.i && com.opos.cmn.an.h.c.a.c(this.b)) {
            throw new DlException(1013);
        }
    }
}
