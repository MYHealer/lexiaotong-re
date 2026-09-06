package com.hihonor.adsdk.common.video.g.k;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.adsdk.common.video.g.d;
import com.hihonor.adsdk.common.video.g.f;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements b {
    private static final String hnadsg = "HttpUrlSource";
    private static final OkHttpClient hnadsh = new OkHttpClient();
    public final String hnadsa;
    private Call hnadsb;
    private InputStream hnadsc;
    private volatile long hnadsd;
    private volatile String hnadse;
    private Map<String, String> hnadsf;

    public a(String str) {
        this(str, com.hihonor.adsdk.common.video.g.l.a.hnadsd(str));
    }

    private Response hnadsb(long j) throws IOException {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) ("Open okHttpClient " + (j > 0 ? " with offset " + j : "") + " to " + this.hnadsa));
        Request.Builder builderUrl = new Request.Builder().url(this.hnadsa);
        if (this.hnadsf != null) {
            hnadsa(builderUrl);
        }
        if (j > 0) {
            builderUrl.addHeader("Range", "bytes=" + j + x.A);
        }
        Call callNewCall = hnadsh.newCall(builderUrl.build());
        this.hnadsb = callNewCall;
        return callNewCall.execute();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c7  */
    private void hnadsc() throws Throwable {
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsg, (Object) ("Read content info from " + this.hnadsa));
        Response response = null;
        try {
            Response responseHnadsb = hnadsb(0L);
            try {
                this.hnadsd = hnadsa(responseHnadsb);
                this.hnadse = responseHnadsb.header("Content-Type");
                if (responseHnadsb.body() == null) {
                    throw new f(d.hnadsb, "Error fetching info,response body is null");
                }
                InputStream inputStreamByteStream = responseHnadsb.body().byteStream();
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "Content info for `" + this.hnadsa + "`: mime: " + this.hnadse + ", content-length: " + this.hnadsd, new Object[0]);
                com.hihonor.adsdk.common.video.g.l.a.hnadsa(inputStreamByteStream);
                this.hnadsb.cancel();
            } catch (IOException e) {
                e = e;
                response = responseHnadsb;
                try {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "Error fetching info from " + this.hnadsa, e);
                    throw new f(d.hnadsa, "Error fetching info from " + this.hnadsa + e.getMessage());
                } catch (Throwable th) {
                    th = th;
                    com.hihonor.adsdk.common.video.g.l.a.hnadsa(response);
                    if (response != null) {
                        this.hnadsb.cancel();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                response = null;
                response = responseHnadsb;
                com.hihonor.adsdk.common.video.g.l.a.hnadsa(response);
                if (response != null) {
                    this.hnadsb.cancel();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
            response = null;
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.k.b
    public void hnadsa(long j) throws f {
        try {
            Response responseHnadsb = hnadsb(j);
            this.hnadse = responseHnadsb.header("Content-Type");
            if (responseHnadsb.body() == null) {
                throw new f(d.hnadsb, "Error opening okHttpClient,response.body is null");
            }
            this.hnadsc = new BufferedInputStream(responseHnadsb.body().byteStream(), 8192);
            this.hnadsd = hnadsa(responseHnadsb, j, responseHnadsb.code());
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "open, IOException: " + e.getMessage(), new Object[0]);
            throw new f(d.hnadsa, "Error opening okHttpClient for " + this.hnadsa + " with offset " + j + e.getMessage());
        }
    }

    public synchronized String hnadsd() throws f {
        if (TextUtils.isEmpty(this.hnadse)) {
            hnadsc();
        }
        return this.hnadse;
    }

    public String hnadse() {
        return this.hnadsa;
    }

    public String toString() {
        return "HttpUrlSource{url='" + this.hnadsa + i.d;
    }

    public a(String str, Map<String, String> map) {
        this(str, com.hihonor.adsdk.common.video.g.l.a.hnadsd(str));
        this.hnadsf = map;
    }

    public a(String str, String str2) {
        this.hnadsb = null;
        this.hnadsd = -2147483648L;
        this.hnadsa = str;
        this.hnadse = str2;
    }

    @Override // com.hihonor.adsdk.common.video.g.k.b
    public synchronized long hnadsb() throws f {
        if (this.hnadsd == -2147483648L) {
            hnadsc();
        }
        return this.hnadsd;
    }

    private void hnadsa(Request.Builder builder) {
        for (Map.Entry<String, String> entry : this.hnadsf.entrySet()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "request header key:" + entry.getKey() + " Value" + entry.getValue(), new Object[0]);
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    private long hnadsa(Response response, long j, int i) {
        long jHnadsa = hnadsa(response);
        if (i == 200) {
            return jHnadsa;
        }
        return i == 206 ? jHnadsa + j : this.hnadsd;
    }

    public a(a aVar) {
        this.hnadsb = null;
        this.hnadsd = -2147483648L;
        this.hnadsa = aVar.hnadsa;
        this.hnadse = aVar.hnadse;
        this.hnadsd = aVar.hnadsd;
    }

    private long hnadsa(Response response) {
        return q.hnadsa(response.header("Content-Length", "-1"), -1L);
    }

    @Override // com.hihonor.adsdk.common.video.g.k.b
    public int hnadsa(byte[] bArr) throws f {
        InputStream inputStream = this.hnadsc;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "read, InterruptedIOException: " + e.getMessage(), new Object[0]);
                throw new f(d.hnadsa, "Reading source " + this.hnadsa + " is interrupted: " + e.getMessage());
            } catch (IOException e2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "read, IOException: " + e2.getMessage(), new Object[0]);
                throw new f(d.hnadsa, "Error reading data from " + this.hnadsa + e2.getMessage());
            }
        }
        throw new f(d.hnadsb, "Error reading data from " + this.hnadsa + ": okHttpClient is absent!");
    }

    @Override // com.hihonor.adsdk.common.video.g.k.b
    public void hnadsa() throws f {
        Call call = this.hnadsb;
        if (call != null) {
            call.cancel();
        }
        InputStream inputStream = this.hnadsc;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsg, "close, inputStream close IOException: " + e.getMessage(), new Object[0]);
                throw new f(d.hnadsa, "inputStream close " + e.getMessage());
            }
        }
    }
}
