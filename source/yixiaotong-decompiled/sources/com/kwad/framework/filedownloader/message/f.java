package com.kwad.framework.filedownloader.message;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f {
    public static MessageSnapshot a(int i, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new d.a(i, true, length);
            }
            return new d.b(i, true, length);
        }
        if (z) {
            return new h.a(i, true, (int) length);
        }
        return new h.b(i, true, (int) length);
    }

    public static MessageSnapshot a(int i, long j, long j2, boolean z) {
        if (j2 > 2147483647L) {
            if (z) {
                return new d.i(i, j, j2);
            }
            return new d.j(i, j, j2);
        }
        if (z) {
            return new h.i(i, (int) j, (int) j2);
        }
        return new h.j(i, (int) j, (int) j2);
    }

    public static MessageSnapshot a(int i, long j, Throwable th) {
        if (j > 2147483647L) {
            return new d.C0720d(i, j, th);
        }
        return new h.d(i, (int) j, th);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        if (aVar.AN()) {
            return new d.e(aVar.getId(), aVar.AE(), aVar.AG());
        }
        return new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.AH() != -3) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.AH())));
        }
        return new a.C0719a(messageSnapshot);
    }

    public static MessageSnapshot a(byte b, com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.download.d.a aVar) {
        MessageSnapshot bVar;
        IllegalStateException illegalStateException;
        int id = cVar.getId();
        if (b == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b != -3) {
            if (b != -1) {
                if (b == 1) {
                    if (cVar.AN()) {
                        return new d.f(id, cVar.CX(), cVar.getTotal());
                    }
                    return new h.f(id, (int) cVar.CX(), (int) cVar.getTotal());
                }
                if (b == 2) {
                    String filename = cVar.AB() ? cVar.getFilename() : null;
                    if (cVar.AN()) {
                        return new d.c(id, aVar.CC(), cVar.getTotal(), cVar.CY(), filename);
                    }
                    return new h.c(id, aVar.CC(), (int) cVar.getTotal(), cVar.CY(), filename);
                }
                if (b == 3) {
                    if (cVar.AN()) {
                        return new d.g(id, cVar.CX());
                    }
                    return new h.g(id, (int) cVar.CX());
                }
                if (b != 5) {
                    if (b == 6) {
                        return new MessageSnapshot.b(id);
                    }
                    String strC = com.kwad.framework.filedownloader.f.f.c("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b));
                    if (aVar.getException() != null) {
                        illegalStateException = new IllegalStateException(strC, aVar.getException());
                    } else {
                        illegalStateException = new IllegalStateException(strC);
                    }
                    if (cVar.AN()) {
                        return new d.C0720d(id, cVar.CX(), illegalStateException);
                    }
                    return new h.d(id, (int) cVar.CX(), illegalStateException);
                }
                if (cVar.AN()) {
                    bVar = new d.h(id, cVar.CX(), aVar.getException(), aVar.AL());
                } else {
                    bVar = new h.C0721h(id, (int) cVar.CX(), aVar.getException(), aVar.AL());
                }
            } else if (cVar.AN()) {
                bVar = new d.C0720d(id, cVar.CX(), aVar.getException());
            } else {
                bVar = new h.d(id, (int) cVar.CX(), aVar.getException());
            }
        } else if (cVar.AN()) {
            bVar = new d.b(id, false, cVar.getTotal());
        } else {
            bVar = new h.b(id, false, (int) cVar.getTotal());
        }
        return bVar;
    }
}
