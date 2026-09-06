package com.byazt.xn;

import android.text.TextUtils;
import com.byazt.gqp.i;
import com.byazt.gqp.m;
import com.byazt.gqp.sl;
import com.byazt.gqp.yp;
import com.byazt.gqp.z;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 20})
public class c implements com.byazt.gqp.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f2872a;
    public yp c;
    public uj tt;
    public AtomicBoolean n = new AtomicBoolean(false);
    public final String ve = com.byazt.na.uj.c(UUID.randomUUID().toString()).c();
    public sl uj = new sl();

    @Override // com.byazt.gqp.tt
    public yp c() {
        return this.c;
    }

    public c(yp ypVar, uj ujVar) {
        this.c = ypVar;
        this.tt = ujVar;
    }

    @Override // com.byazt.gqp.tt
    public void c(com.byazt.gqp.ve veVar) {
        try {
            synchronized (this) {
                if (this.f2872a) {
                    throw new IllegalStateException("Already Executed");
                }
                this.f2872a = true;
            }
            this.tt.c(new C0327c(veVar, this));
        } catch (Throwable th) {
            if (veVar != null) {
                veVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.gqp.tt
    public m tt() throws IOException {
        synchronized (this) {
            if (this.f2872a) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2872a = true;
        }
        try {
            this.tt.c(this);
            return n();
        } finally {
            this.tt.tt(this);
        }
    }

    public m n() {
        if (this.n.get()) {
            return null;
        }
        try {
            if (this.c.c != null && this.c.c.c != null && this.c.c.c.size() > 0) {
                ArrayList arrayList = new ArrayList(this.c.c.c);
                arrayList.add(new i() { // from class: com.byazt.xn.c.1
                    @Override // com.byazt.gqp.i
                    public m c(i.c cVar) throws IOException {
                        return c.this.c(cVar.c());
                    }
                });
                return ((i) arrayList.get(0)).c(new tt(arrayList, this.c));
            }
            return c(this.c);
        } catch (Throwable unused) {
            return null;
        }
    }

    public m c(yp ypVar) throws IOException {
        try {
            sl slVar = this.uj;
            if (slVar != null) {
                slVar.tt();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(ypVar.tt().c().toString()).openConnection();
            if (ypVar.uj() != null && ypVar.uj().size() > 0) {
                for (Map.Entry<String, List<String>> entry : ypVar.uj().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (ypVar.c != null) {
                if (ypVar.c.ve != null) {
                    httpURLConnection.setConnectTimeout((int) ypVar.c.ve.toMillis(ypVar.c.tt));
                }
                if (ypVar.c.n != null) {
                    httpURLConnection.setReadTimeout((int) ypVar.c.n.toMillis(ypVar.c.uj));
                }
            }
            if (ypVar.a() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!sp() && ypVar.a().ve != null) {
                    httpURLConnection.addRequestProperty("Content-Type", ypVar.a().ve.toString());
                }
                httpURLConnection.setRequestMethod(ypVar.ve());
                if (c(ypVar.a())) {
                    c(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(ypVar.ve())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (ve(ypVar.a())) {
                        outputStream.write(ypVar.a().uj.getBytes());
                    } else if (c(ypVar.a())) {
                        c(ypVar.a().n, outputStream, ypVar.a().tt(), ypVar.a().c());
                    } else if (tt(ypVar.a())) {
                        outputStream.write(ypVar.a().n);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            sl slVar2 = this.uj;
            if (slVar2 != null) {
                slVar2.ve();
                this.uj.c(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.n.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            a aVar = new a(httpURLConnection, ypVar);
            aVar.uj = jCurrentTimeMillis;
            aVar.ve = jCurrentTimeMillis2;
            sl slVar3 = this.uj;
            if (slVar3 != null) {
                slVar3.tt(jCurrentTimeMillis2);
            }
            aVar.n = this.uj;
            return aVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.ve);
    }

    private void c(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.ve)).append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.append((CharSequence) ("--" + this.ve + "--")).append((CharSequence) IOUtils.LINE_SEPARATOR_WINDOWS);
        printWriter.flush();
        printWriter.close();
    }

    private boolean c(z zVar) {
        yp ypVar;
        return zVar != null && (ypVar = this.c) != null && "POST".equalsIgnoreCase(ypVar.ve()) && zVar.f2272a == z.c.FILE_TYPE && zVar.n != null && zVar.n.length > 0;
    }

    private boolean tt(z zVar) {
        yp ypVar;
        return zVar != null && (ypVar = this.c) != null && "POST".equalsIgnoreCase(ypVar.ve()) && zVar.f2272a == z.c.BYTE_ARRAY_TYPE && zVar.n != null && zVar.n.length > 0;
    }

    private boolean ve(z zVar) {
        yp ypVar;
        return (zVar == null || (ypVar = this.c) == null || !"POST".equalsIgnoreCase(ypVar.ve()) || zVar.f2272a != z.c.STRING_TYPE || TextUtils.isEmpty(zVar.uj)) ? false : true;
    }

    private boolean sp() {
        if (this.c.uj() == null) {
            return false;
        }
        return this.c.uj().containsKey("Content-Type");
    }

    @Override // com.byazt.gqp.tt
    public void ve() {
        this.n.set(true);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.byazt.gqp.tt clone() {
        return new c(this.c, this.tt);
    }

    @Override // com.byazt.gqp.tt
    public boolean uj() {
        return this.n.get();
    }

    /* JADX INFO: renamed from: com.byazt.xn.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 873, 44})
    final class C0327c extends com.byazt.na.n {
        public final c uj;
        public final com.byazt.gqp.ve ve;

        public C0327c(com.byazt.gqp.ve veVar, c cVar) {
            super("net-async-call", new Object[0]);
            this.ve = veVar;
            this.uj = cVar;
        }

        public void c() {
            c cVar = this.uj;
            if (cVar == null || cVar.uj == null) {
                return;
            }
            this.uj.uj.uj();
        }

        @Override // com.byazt.na.n
        public void tt() {
            try {
                c cVar = this.uj;
                if (cVar != null && cVar.uj != null) {
                    this.uj.uj.c();
                }
                m mVarN = c.this.n();
                if (mVarN == null) {
                    this.ve.onFailure(c.this, new IOException("response is null"));
                } else {
                    this.ve.onResponse(c.this, mVarN);
                }
                try {
                    this.uj.tt.tt(this);
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            } catch (Throwable th2) {
                try {
                    if (th2 instanceof IOException) {
                        this.ve.onFailure(c.this, th2);
                    } else {
                        this.ve.onFailure(c.this, new IOException(th2));
                    }
                } finally {
                    try {
                        this.uj.tt.tt(this);
                    } catch (Throwable th3) {
                        com.byazt.nr.m.c(th3);
                    }
                }
            }
        }
    }
}
