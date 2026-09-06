package com.hihonor.adsdk.common.video.g.j;

import android.text.TextUtils;
import com.hihonor.adsdk.common.f.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class c {
    private static final String hnadsd = "GetRequest";
    private static final Pattern hnadse = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern hnadsf = Pattern.compile("GET /(.*) HTTP");
    public final String hnadsa;
    public final long hnadsb;
    public final boolean hnadsc;

    public c(String str) {
        long jHnadsa = hnadsa(str);
        long jMax = Math.max(0L, jHnadsa);
        this.hnadsb = jMax;
        boolean z = jHnadsa >= 0;
        this.hnadsc = z;
        String strHnadsb = hnadsb(str);
        this.hnadsa = strHnadsb;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "rangeOffset: " + jMax + ",partial: " + z + ",uri: " + strHnadsb, new Object[0]);
    }

    public static c hnadsa(InputStream inputStream) throws com.hihonor.adsdk.common.video.g.f {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (TextUtils.isEmpty(line)) {
                    return new c(sb.toString());
                }
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "read line:" + line, new Object[0]);
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "read, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "GetRequest.read:" + e.getMessage());
        }
    }

    private String hnadsb(String str) {
        Matcher matcher = hnadsf.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.hnadsb + ", partial=" + this.hnadsc + ", uri='" + this.hnadsa + "'}";
    }

    private long hnadsa(String str) {
        Matcher matcher = hnadse.matcher(str);
        if (matcher.find()) {
            return q.hnadsa(matcher.group(1), -1L);
        }
        return -1L;
    }
}
