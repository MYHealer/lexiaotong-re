package com.opos.exoplayer.core.f.d;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.opos.exoplayer.core.f.c;
import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.p;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f6438a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private int f;

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list == null || list.isEmpty()) {
            this.b = false;
            return;
        }
        this.b = true;
        String str = new String(list.get(0));
        com.opos.exoplayer.core.i.a.a(str.startsWith("Format: "));
        b(str);
        a(new p(list.get(1)));
    }

    public static long a(String str) {
        Matcher matcher = f6438a.matcher(str);
        if (matcher.matches()) {
            return (Long.parseLong(matcher.group(1)) * 3600000000L) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return -9223372036854775807L;
    }

    private void a(p pVar) {
        String strZ;
        do {
            strZ = pVar.z();
            if (strZ == null) {
                return;
            }
        } while (!strZ.startsWith("[Events]"));
    }

    private void a(p pVar, List<com.opos.exoplayer.core.f.b> list, k kVar) {
        while (true) {
            String strZ = pVar.z();
            if (strZ == null) {
                return;
            }
            if (!this.b && strZ.startsWith("Format: ")) {
                b(strZ);
            } else if (strZ.startsWith("Dialogue: ")) {
                a(strZ, list, kVar);
            }
        }
    }

    private void a(String str, List<com.opos.exoplayer.core.f.b> list, k kVar) {
        long jA;
        StringBuilder sb;
        if (this.c == 0) {
            sb = new StringBuilder("Skipping dialogue line before complete format: ");
        } else {
            String[] strArrSplit = str.substring(10).split(",", this.c);
            if (strArrSplit.length != this.c) {
                sb = new StringBuilder("Skipping dialogue line with fewer columns than format: ");
            } else {
                long jA2 = a(strArrSplit[this.d]);
                if (jA2 != -9223372036854775807L) {
                    String str2 = strArrSplit[this.e];
                    if (str2.trim().isEmpty()) {
                        jA = -9223372036854775807L;
                    } else {
                        jA = a(str2);
                        if (jA == -9223372036854775807L) {
                            sb = new StringBuilder("Skipping invalid timing: ");
                        }
                    }
                    list.add(new com.opos.exoplayer.core.f.b(strArrSplit[this.f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", IOUtils.LINE_SEPARATOR_UNIX).replaceAll("\\\\n", IOUtils.LINE_SEPARATOR_UNIX)));
                    kVar.a(jA2);
                    if (jA != -9223372036854775807L) {
                        list.add(null);
                        kVar.a(jA);
                        return;
                    }
                    return;
                }
                sb = new StringBuilder("Skipping invalid timing: ");
            }
        }
        com.opos.cmn.an.f.a.c("SsaDecoder", sb.append(str).toString());
    }

    private void b(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(8), ",");
        this.c = strArrSplit.length;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        for (int i = 0; i < this.c; i++) {
            String strD = y.d(strArrSplit[i].trim());
            strD.hashCode();
            switch (strD) {
                case "end":
                    this.e = i;
                    break;
                case "text":
                    this.f = i;
                    break;
                case "start":
                    this.d = i;
                    break;
            }
        }
        if (this.d == -1 || this.e == -1 || this.f == -1) {
            this.c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.opos.exoplayer.core.f.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        p pVar = new p(bArr, i);
        if (!this.b) {
            a(pVar);
        }
        a(pVar, arrayList, kVar);
        com.opos.exoplayer.core.f.b[] bVarArr = new com.opos.exoplayer.core.f.b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, kVar.b());
    }
}
