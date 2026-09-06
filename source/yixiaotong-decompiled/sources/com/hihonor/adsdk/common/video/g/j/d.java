package com.hihonor.adsdk.common.video.g.j;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class d extends i {
    private static final String hnadsp = "HttpProxyCache";
    private static final float hnadsq = 0.2f;
    private final com.hihonor.adsdk.common.video.g.k.a hnadsm;
    private final com.hihonor.adsdk.common.video.g.i.b hnadsn;
    private b hnadso;

    public d(com.hihonor.adsdk.common.video.g.k.a aVar, com.hihonor.adsdk.common.video.g.i.b bVar) {
        super(aVar, bVar);
        this.hnadsn = bVar;
        this.hnadsm = aVar;
    }

    private String hnadsb(c cVar) throws com.hihonor.adsdk.common.video.g.f {
        String strHnadsd = this.hnadsm.hnadsd();
        boolean z = !TextUtils.isEmpty(strHnadsd);
        long jHnadsc = this.hnadsn.hnadsd() ? this.hnadsn.hnadsc() : this.hnadsm.hnadsb();
        boolean z2 = jHnadsc >= 0;
        boolean z3 = cVar.hnadsc;
        return (cVar.hnadsc ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes" + System.lineSeparator() + (z2 ? hnadsa("Content-Length: %d\n", Long.valueOf(z3 ? jHnadsc - cVar.hnadsb : jHnadsc)) : "") + (z2 && z3 ? hnadsa("Content-Range: bytes %d-%d/%d\n", Long.valueOf(cVar.hnadsb), Long.valueOf(jHnadsc - 1), Long.valueOf(jHnadsc)) : "") + (z ? hnadsa("Content-Type: %s\n", strHnadsd) : "") + System.lineSeparator();
    }

    public void hnadsa(b bVar) {
        this.hnadso = bVar;
    }

    public void hnadsa(c cVar, Socket socket) throws com.hihonor.adsdk.common.video.g.f {
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(hnadsb(cVar).getBytes("UTF-8"));
            long j = cVar.hnadsb;
            if (hnadsa(cVar)) {
                hnadsa(bufferedOutputStream, j);
            } else {
                hnadsb(bufferedOutputStream, j);
            }
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsp, "processRequest, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "processRequest:" + e.getMessage());
        }
    }

    private void hnadsb(OutputStream outputStream, long j) throws com.hihonor.adsdk.common.video.g.f {
        com.hihonor.adsdk.common.video.g.k.a aVar = new com.hihonor.adsdk.common.video.g.k.a(this.hnadsm);
        try {
            try {
                aVar.hnadsa((int) j);
                byte[] bArr = new byte[8192];
                while (true) {
                    int iHnadsa = aVar.hnadsa(bArr);
                    if (iHnadsa != -1) {
                        outputStream.write(bArr, 0, iHnadsa);
                    } else {
                        outputStream.flush();
                        aVar.hnadsa();
                        return;
                    }
                }
            } catch (IOException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsp, "responseWithoutCache, IOException: " + e.getMessage(), new Object[0]);
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "responseWithoutCache: " + e.getMessage());
            }
        } catch (Throwable th) {
            aVar.hnadsa();
            throw th;
        }
    }

    private String hnadsa(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private boolean hnadsa(c cVar) throws com.hihonor.adsdk.common.video.g.f {
        long jHnadsb = this.hnadsm.hnadsb();
        return (((jHnadsb > 0L ? 1 : (jHnadsb == 0L ? 0 : -1)) > 0) && cVar.hnadsc && ((float) cVar.hnadsb) > ((float) this.hnadsn.hnadsc()) + (((float) jHnadsb) * 0.2f)) ? false : true;
    }

    public void hnadsa(long j) throws com.hihonor.adsdk.common.video.g.f {
        byte[] bArr = new byte[8192];
        while (true) {
            int iHnadsa = hnadsa(bArr, j, 8192);
            if (iHnadsa == -1) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsp, "processPreCache,all data size--->" + j, new Object[0]);
                return;
            }
            j += (long) iHnadsa;
        }
    }

    private void hnadsa(OutputStream outputStream, long j) throws com.hihonor.adsdk.common.video.g.f {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsp, "responseWithCache,offset--->" + j, new Object[0]);
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int iHnadsb = hnadsb(bArr, j, 8192);
                if (iHnadsb != -1) {
                    outputStream.write(bArr, 0, iHnadsb);
                    j += (long) iHnadsb;
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsp, "responseWithCache,play after cache,data size--->" + j, new Object[0]);
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsp, "responseWithCache,socket out.flush", new Object[0]);
                    outputStream.flush();
                    return;
                }
            }
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsp, "responseWithCache, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "responseWithCache: " + e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.j.i
    protected void hnadsa(int i) {
        b bVar = this.hnadso;
        if (bVar != null) {
            bVar.hnadsa(this.hnadsn.hnadsa, this.hnadsm.hnadse(), i);
        }
    }
}
