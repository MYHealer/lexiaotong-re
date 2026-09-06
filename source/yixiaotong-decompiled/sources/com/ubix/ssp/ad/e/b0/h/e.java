package com.ubix.ssp.ad.e.b0.h;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class e extends m {
    private final h i;
    private final com.ubix.ssp.ad.e.b0.h.s.b j;
    private b k;

    public e(h hVar, com.ubix.ssp.ad.e.b0.h.s.b bVar) {
        super(hVar, bVar);
        this.j = bVar;
        this.i = hVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j) throws IOException, n {
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

    private boolean a(d dVar) {
        long jA = this.i.a();
        return (((jA > 0L ? 1 : (jA == 0L ? 0 : -1)) > 0) && dVar.e && ((float) dVar.d) > ((float) this.j.b()) + (((float) jA) * 0.2f)) ? false : true;
    }

    private String b(d dVar) {
        String strC = this.i.c();
        boolean z = !TextUtils.isEmpty(strC);
        long jB = this.j.c() ? this.j.b() : this.i.a();
        boolean z2 = jB >= 0;
        boolean z3 = dVar.e;
        return (dVar.e ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z2 ? a("Content-Length: %d\n", Long.valueOf(z3 ? jB - dVar.d : jB)) : "") + (z2 && z3 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.d), Long.valueOf(jB - 1), Long.valueOf(jB)) : "") + (z ? a("Content-Type: %s\n", strC) : "") + IOUtils.LINE_SEPARATOR_UNIX;
    }

    private void b(OutputStream outputStream, long j) {
        h hVar = new h(this.i);
        try {
            hVar.a((int) j);
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = hVar.a(bArr);
                if (iA == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, iA);
            }
        } finally {
            hVar.close();
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.m
    protected void a(int i) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(this.j.b, this.i.d(), i);
        }
    }

    public void a(b bVar) {
        this.k = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, n {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.d;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }
}
