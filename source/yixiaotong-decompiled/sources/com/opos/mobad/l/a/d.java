package com.opos.mobad.l.a;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {
    public static File a(Context context, com.opos.mobad.l.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d);
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g);
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, 0), aVar.g);
            }
        }
        return null;
    }

    public static File b(Context context, com.opos.mobad.l.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d + ".tmp");
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g + ".tmp");
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, aVar.e), aVar.g + ".tmp");
            }
        }
        return null;
    }

    public static File c(Context context, com.opos.mobad.l.a aVar) {
        if (context != null && aVar != null) {
            int i = aVar.c;
            if (i == 0) {
                return new File(aVar.d + ".pos");
            }
            if (i == 1) {
                return new File(context.getFilesDir(), aVar.g + ".pos");
            }
            if (i == 2) {
                return new File(context.getDir(aVar.f, aVar.e), aVar.g + ".pos");
            }
        }
        return null;
    }
}
