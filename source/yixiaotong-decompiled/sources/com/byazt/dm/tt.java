package com.byazt.dm;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 204, 13})
public class tt {

    public interface c<T> {
        T tt();
    }

    public static <T> T c(boolean z, String str, c<T> cVar) {
        try {
            return cVar.tt();
        } catch (Throwable th) {
            if (th instanceof com.byazt.dm.c) {
                throw th;
            }
            ve.c().c(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T c(c<T> cVar) {
        return (T) c(true, null, cVar);
    }

    public static void c(final Runnable runnable) {
        c(new c<Void>() { // from class: com.byazt.dm.tt.1
            @Override // com.byazt.dm.tt.c
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void tt() {
                runnable.run();
                return null;
            }
        });
    }
}
