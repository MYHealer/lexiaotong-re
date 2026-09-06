package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f9114a;
    private final cg b;
    private bu c;

    public be() {
        this(new bo.a());
    }

    public be(bw bwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f9114a = byteArrayOutputStream;
        cg cgVar = new cg(byteArrayOutputStream);
        this.b = cgVar;
        this.c = bwVar.a(cgVar);
    }

    public byte[] a(av avVar) throws bb {
        this.f9114a.reset();
        avVar.write(this.c);
        return this.f9114a.toByteArray();
    }

    public String a(av avVar, String str) throws bb {
        try {
            return new String(a(avVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public String b(av avVar) throws bb {
        return new String(a(avVar));
    }
}
