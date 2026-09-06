package com.opos.cmn.func.dl.base.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f6105a;
    private Context b;
    private com.opos.cmn.func.dl.base.e.c c;
    private com.opos.cmn.func.dl.base.a.b d;
    private f e;
    private b f;
    private long g;
    private long h;

    public c(Context context, b bVar, com.opos.cmn.func.dl.base.a.c cVar, com.opos.cmn.func.dl.base.e.c cVar2) {
        this.b = context;
        this.c = cVar2;
        this.f = bVar;
        this.e = cVar.c;
        this.d = cVar.f6110a;
        this.h = this.c.d;
        this.g = this.c.b + this.h;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x009f A[Catch: all -> 0x011d, Exception -> 0x0120, DlException -> 0x016c, IOException -> 0x019c, TryCatch #5 {all -> 0x011d, blocks: (B:3:0x000b, B:5:0x0021, B:7:0x002a, B:10:0x0043, B:12:0x0049, B:13:0x0060, B:18:0x007f, B:20:0x009f, B:24:0x00af, B:25:0x00b6, B:52:0x0121, B:56:0x015e, B:60:0x016d, B:64:0x019d, B:14:0x0064, B:16:0x006a, B:6:0x0026), top: B:69:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c5 A[Catch: all -> 0x010f, Exception -> 0x0113, DlException -> 0x0116, IOException -> 0x0119, TryCatch #4 {DlException -> 0x0116, IOException -> 0x0119, Exception -> 0x0113, all -> 0x010f, blocks: (B:29:0x00c1, B:31:0x00c5, B:33:0x00ef, B:36:0x00f8), top: B:71:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ef A[Catch: all -> 0x010f, Exception -> 0x0113, DlException -> 0x0116, IOException -> 0x0119, TryCatch #4 {DlException -> 0x0116, IOException -> 0x0119, Exception -> 0x0113, all -> 0x010f, blocks: (B:29:0x00c1, B:31:0x00c5, B:33:0x00ef, B:36:0x00f8), top: B:71:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1 A[EXC_TOP_SPLITTER, LOOP:0: B:71:0x00c1->B:75:?, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x0107 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String str;
        InputStream inputStreamA;
        int i;
        int i2;
        int i3 = 1003;
        InputStream inputStream = null;
        try {
            try {
                long j = (this.c.b + this.c.c) - 1;
                String str2 = TextUtils.isEmpty(this.d.f) ? this.d.e : this.d.f;
                com.opos.cmn.func.dl.base.c.a aVar = new com.opos.cmn.func.dl.base.c.a(this.d.r);
                if (this.c.c <= 0 || !this.d.m) {
                    if (this.d.m) {
                        str = "bytes=" + this.g + x.A;
                    } else {
                        str = null;
                    }
                    com.opos.cmn.an.f.a.a("BlockReadRunnable", "------http request range = ".concat(String.valueOf(str)));
                    inputStreamA = aVar.a(this.b, str2, new com.opos.cmn.func.dl.base.c.b(this.d.q.j));
                    if (inputStreamA == null) {
                        if (com.opos.cmn.an.h.c.a.d(this.d.f6108a)) {
                            i2 = 1001;
                        } else {
                            i2 = 1003;
                        }
                        throw new DlException(i2, aVar.d());
                    }
                    if (inputStreamA == null) {
                        com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                        return;
                    }
                    do {
                        try {
                            if (!this.f6105a) {
                                com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                                return;
                            }
                            a aVarA = this.f.a();
                            i = inputStreamA.read(aVarA.e);
                            aVarA.d = this.c.b + this.h;
                            aVarA.f6103a = this.c.f6131a;
                            aVarA.b = this.d.c;
                            aVarA.c = i;
                            this.e.a(aVarA);
                            if (i > 0) {
                                this.h += (long) i;
                            }
                        } catch (DlException e) {
                            e = e;
                            inputStream = inputStreamA;
                        } catch (IOException e2) {
                            e = e2;
                            inputStream = inputStreamA;
                            com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed1!url:" + this.d.e + ",error msg:" + e.getMessage());
                            this.e.a(new DlException(1003, e));
                            com.opos.cmn.func.dl.base.i.a.a(inputStream);
                            return;
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = inputStreamA;
                            boolean zD = com.opos.cmn.an.h.c.a.d(this.d.f6108a);
                            com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed3!url:" + this.d.e + ",error msg:" + e.getMessage() + ",hasNet=" + zD);
                            f fVar = this.e;
                            if (zD) {
                                i3 = 1000;
                            }
                            fVar.a(new DlException(i3, e));
                            com.opos.cmn.func.dl.base.i.a.a(inputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            inputStream = inputStreamA;
                            com.opos.cmn.func.dl.base.i.a.a(inputStream);
                            throw th;
                        }
                    } while (i != -1);
                    this.e.a(this.c);
                    com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                    return;
                    com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed2!url:" + this.d.e + ",error msg:" + e.b());
                    this.e.a(e);
                    com.opos.cmn.func.dl.base.i.a.a(inputStream);
                }
                str = "bytes=" + this.g + x.A + j;
                aVar.a("Range", str);
                com.opos.cmn.an.f.a.a("BlockReadRunnable", "------http request range = ".concat(String.valueOf(str)));
                inputStreamA = aVar.a(this.b, str2, new com.opos.cmn.func.dl.base.c.b(this.d.q.j));
                if (inputStreamA == null) {
                    if (com.opos.cmn.an.h.c.a.d(this.d.f6108a)) {
                        i2 = 1001;
                    } else {
                        i2 = 1003;
                    }
                    throw new DlException(i2, aVar.d());
                }
                if (inputStreamA == null) {
                    com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                    return;
                }
                do {
                    if (!this.f6105a) {
                        com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                        return;
                    }
                    a aVarA2 = this.f.a();
                    i = inputStreamA.read(aVarA2.e);
                    aVarA2.d = this.c.b + this.h;
                    aVarA2.f6103a = this.c.f6131a;
                    aVarA2.b = this.d.c;
                    aVarA2.c = i;
                    this.e.a(aVarA2);
                    if (i > 0) {
                        this.h += (long) i;
                    }
                } while (i != -1);
                this.e.a(this.c);
                com.opos.cmn.func.dl.base.i.a.a(inputStreamA);
                return;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (DlException e4) {
            e = e4;
        } catch (IOException e5) {
            e = e5;
        } catch (Exception e6) {
            e = e6;
        }
        com.opos.cmn.an.f.a.c("BlockReadRunnable", " download failed2!url:" + this.d.e + ",error msg:" + e.b());
        this.e.a(e);
        com.opos.cmn.func.dl.base.i.a.a(inputStream);
    }
}
