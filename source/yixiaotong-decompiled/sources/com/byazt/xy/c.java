package com.byazt.xy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2098, 20})
public class c implements uj {
    public final HttpURLConnection c;

    public c(HttpURLConnection httpURLConnection) {
        this.c = httpURLConnection;
    }

    @Override // com.byazt.xy.uj
    public boolean c() {
        try {
            return this.c.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.byazt.xy.uj
    public InputStream tt() throws IOException {
        return this.c.getInputStream();
    }

    @Override // com.byazt.xy.uj
    public String ve() {
        return this.c.getContentType();
    }

    @Override // com.byazt.xy.uj
    public String uj() {
        try {
            if (c()) {
                return null;
            }
            return "Unable to fetch " + this.c.getURL() + ". Failed with " + this.c.getResponseCode() + IOUtils.LINE_SEPARATOR_UNIX + c(this.c);
        } catch (IOException e) {
            com.byazt.kk.a.c("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.disconnect();
    }

    private String c(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
