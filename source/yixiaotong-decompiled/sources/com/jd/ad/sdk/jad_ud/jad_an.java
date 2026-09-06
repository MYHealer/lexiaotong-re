package com.jd.ad.sdk.jad_ud;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements Closeable {
    public final HttpURLConnection jad_an;

    public jad_an(HttpURLConnection httpURLConnection) {
        this.jad_an = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.disconnect();
    }

    public String jad_bo() {
        try {
            if (jad_cp()) {
                return null;
            }
            StringBuilder sbAppend = new StringBuilder().append("Unable to fetch ").append(this.jad_an.getURL()).append(". Failed with ").append(this.jad_an.getResponseCode()).append(IOUtils.LINE_SEPARATOR_UNIX);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.jad_an.getErrorStream()));
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
            return sbAppend.append(sb.toString()).toString();
        } catch (IOException e) {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("get error failed ", e);
            return e.getMessage();
        }
    }

    public boolean jad_cp() {
        try {
            return this.jad_an.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }
}
