package com.oplus.log.f;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.oplus.log.a.a f5829a;

    public c(com.oplus.log.a.a aVar) {
        this.f5829a = aVar;
    }

    private static String a(String str) {
        long j;
        try {
            j = Long.parseLong(str);
        } catch (Throwable unused) {
            j = 0;
        }
        return new DecimalFormat("##.##").format(j / 1048576.0f);
    }

    private static String c(com.oplus.log.b.b bVar) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(bVar.c)) {
            sb.append(bVar.c);
            sb.append("|");
        }
        sb.append(d(bVar));
        sb.append(bVar.b);
        return sb.toString();
    }

    private static String d(com.oplus.log.b.b bVar) {
        String key;
        StringBuilder sb = new StringBuilder();
        if (bVar.f != null) {
            Iterator<Map.Entry<String, String>> it = bVar.f.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String value = null;
                try {
                    key = next.getKey();
                    try {
                        value = next.getValue();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    key = null;
                }
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    if ("RAMSize".equals(key)) {
                        value = a(value) + "GB";
                    }
                    if ("InternalFreeSpace".equals(key)) {
                        value = a(value) + "GB";
                    }
                    sb.append(key);
                    sb.append(x.bQ);
                    sb.append(value);
                    if (it.hasNext()) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("|");
        }
        return sb.toString();
    }

    public final int a() {
        return 104;
    }

    @Override // com.oplus.log.f.d
    public final void a(com.oplus.log.b.b bVar) {
        if (this.f5829a == null || !(bVar.b instanceof String)) {
            return;
        }
        this.f5829a.a(bVar.e, c(bVar), bVar.d, a());
    }

    @Override // com.oplus.log.f.d
    public final void b(com.oplus.log.b.b bVar) {
        if (this.f5829a == null || !(bVar.b instanceof String)) {
            return;
        }
        this.f5829a.a(bVar.e, c(bVar), bVar.d, a());
    }
}
