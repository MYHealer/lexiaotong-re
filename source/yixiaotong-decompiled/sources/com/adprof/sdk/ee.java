package com.adprof.sdk;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ee implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f1148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f245a;

    public ee(byte[] bArr, Class cls) {
        this.f245a = bArr;
        this.f1148a = cls;
    }

    public Object readResolve() throws ObjectStreamException {
        Class cls = this.f1148a;
        di diVar = di.b;
        try {
            try {
                return ((di) cls.getField("ADAPTER").get(null)).a(this.f245a);
            } catch (IOException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        } catch (Throwable th) {
            throw new IllegalArgumentException("failed to access " + cls.getName() + "#ADAPTER", th);
        }
    }
}
