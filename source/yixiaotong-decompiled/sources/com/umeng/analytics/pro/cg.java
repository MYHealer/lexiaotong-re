package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: TIOStreamTransport.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class cg extends ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f9139a;
    protected OutputStream b;

    @Override // com.umeng.analytics.pro.ci
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ci
    public void b() throws cj {
    }

    protected cg() {
        this.f9139a = null;
        this.b = null;
    }

    public cg(InputStream inputStream) {
        this.b = null;
        this.f9139a = inputStream;
    }

    public cg(OutputStream outputStream) {
        this.f9139a = null;
        this.b = outputStream;
    }

    public cg(InputStream inputStream, OutputStream outputStream) {
        this.f9139a = inputStream;
        this.b = outputStream;
    }

    @Override // com.umeng.analytics.pro.ci
    public void c() {
        InputStream inputStream = this.f9139a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f9139a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public int a(byte[] bArr, int i, int i2) throws cj {
        InputStream inputStream = this.f9139a;
        if (inputStream == null) {
            throw new cj(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new cj(4);
        } catch (IOException e) {
            throw new cj(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void b(byte[] bArr, int i, int i2) throws cj {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new cj(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new cj(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.ci
    public void d() throws cj {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new cj(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e) {
            throw new cj(0, e);
        }
    }
}
