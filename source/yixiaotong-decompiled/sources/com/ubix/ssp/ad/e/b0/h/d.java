package com.ubix.ssp.ad.e.b0.h;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8781a = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern b = Pattern.compile("GET /(.*) HTTP");
    public final String c;
    public final long d;
    public final boolean e;

    public d(String str) {
        l.a(str);
        long jA = a(str);
        this.d = Math.max(0L, jA);
        this.e = jA >= 0;
        this.c = b(str);
    }

    private long a(String str) {
        Matcher matcher = f8781a.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    public static d a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new d(sb.toString());
            }
            sb.append(line).append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.d + ", partial=" + this.e + ", uri='" + this.c + "'}";
    }
}
