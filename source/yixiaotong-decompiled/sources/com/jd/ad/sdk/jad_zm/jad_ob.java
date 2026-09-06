package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ob implements Closeable {
    public String jad_an;
    public BufferedInputStream jad_bo;

    public jad_ob(String str, BufferedInputStream bufferedInputStream) {
        this.jad_an = str;
        this.jad_bo = bufferedInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.jad_bo.close();
    }

    public String jad_bo() {
        String strTrim;
        String str = this.jad_an;
        TimeZone timeZone = jad_fs.jad_bo;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("charset")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
            while (true) {
                if (!stringTokenizer.hasMoreElements()) {
                    strTrim = "UTF-8";
                    break;
                }
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf > 0 && "charset".equalsIgnoreCase(strNextToken.substring(0, iIndexOf).trim())) {
                    strTrim = strNextToken.substring(iIndexOf + 1).trim();
                    break;
                }
            }
        } else {
            strTrim = "UTF-8";
            break;
        }
        return TextUtils.isEmpty(strTrim) ? new String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), StandardCharsets.UTF_8) : new String(com.jd.ad.sdk.jad_fq.jad_jt.jad_an(this.jad_bo), strTrim);
    }
}
