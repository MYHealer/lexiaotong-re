package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;
import java.util.zip.Adler32;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8537a;
    static final Object d = new Object();

    static long a(a aVar) {
        if (aVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", aVar.f(), aVar.getDeviceId(), Long.valueOf(aVar.a()), aVar.getImsi(), aVar.e());
        if (g.m1003a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    private static a a(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (d) {
            String value = c.a(context).getValue();
            if (g.m1003a(value)) {
                return null;
            }
            if (value.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
                value = value.substring(0, value.length() - 1);
            }
            a aVar = new a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.ta.utdid2.a.a.e.a(context);
            String strC = com.ta.utdid2.a.a.e.c(context);
            aVar.d(strA);
            aVar.b(strA);
            aVar.b(jCurrentTimeMillis);
            aVar.c(strC);
            aVar.e(value);
            aVar.a(a(aVar));
            return aVar;
        }
    }

    public static synchronized a b(Context context) {
        a aVar = f8537a;
        if (aVar != null) {
            return aVar;
        }
        if (context == null) {
            return null;
        }
        a aVarA = a(context);
        f8537a = aVarA;
        return aVarA;
    }
}
