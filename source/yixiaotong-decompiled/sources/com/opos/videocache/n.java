package com.opos.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class n extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f8440a;
    private final com.opos.videocache.a.b b;
    private b c;

    public n(d dVar, com.opos.videocache.a.b bVar) {
        super(dVar, bVar);
        this.b = bVar;
        this.f8440a = dVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int iA = a(bArr, j, 8192);
            if (iA == -1) {
                outputStream.flush();
                return;
            } else {
                outputStream.write(bArr, 0, iA);
                j += (long) iA;
            }
        }
    }

    private boolean a(m mVar) {
        long jA = this.f8440a.a();
        return (((jA > 0L ? 1 : (jA == 0L ? 0 : -1)) > 0) && mVar.c && ((float) mVar.b) > ((float) this.b.a()) + (((float) jA) * 0.2f)) ? false : true;
    }

    private String b(m mVar) {
        String strC = this.f8440a.c();
        boolean z = !TextUtils.isEmpty(strC);
        long jA = this.b.d() ? this.b.a() : this.f8440a.a();
        boolean z2 = jA >= 0;
        return (mVar.c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? a("Content-Length: %d\n", Long.valueOf(mVar.c ? jA - mVar.b : jA)) : "") + (z2 && mVar.c ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(mVar.b), Long.valueOf(jA - 1), Long.valueOf(jA)) : "") + (z ? a("Content-Type: %s\n", strC) : "") + IOUtils.LINE_SEPARATOR_UNIX;
    }

    private void b(OutputStream outputStream, long j) {
        d dVar = new d(this.f8440a);
        try {
            dVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = dVar.a(bArr);
                if (iA == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, iA);
            }
        } finally {
            dVar.b();
        }
    }

    @Override // com.opos.videocache.r
    protected void a(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.f8426a, this.f8440a.d(), i);
        }
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public void a(m mVar, Socket socket) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(mVar).getBytes("UTF-8"));
        long j = mVar.b;
        if (a(mVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
