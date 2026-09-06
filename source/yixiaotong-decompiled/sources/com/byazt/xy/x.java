package com.byazt.xy;

import android.content.Context;
import android.util.Pair;
import com.byazt.ga.t;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2098, 71})
public class x {
    public final sp c;
    public final a tt;

    public x(sp spVar, a aVar) {
        this.c = spVar;
        this.tt = aVar;
    }

    public t<com.byazt.ga.a> c(Context context, String str, String str2) {
        com.byazt.ga.a aVarTt = tt(context, str, str2);
        if (aVarTt != null) {
            return new t<>(aVarTt);
        }
        com.byazt.kk.a.c("Animation for " + str + " not found in cache. Fetching from network.");
        return ve(context, str, str2);
    }

    private com.byazt.ga.a tt(Context context, String str, String str2) {
        sp spVar;
        Pair<ve, InputStream> pairC;
        t<com.byazt.ga.a> tVarTt;
        if (str2 == null || (spVar = this.c) == null || (pairC = spVar.c(str2)) == null) {
            return null;
        }
        ve veVar = (ve) pairC.first;
        InputStream inputStream = (InputStream) pairC.second;
        if (veVar == ve.ZIP) {
            tVarTt = com.byazt.ga.sp.c(context, new ZipInputStream(inputStream), str2);
        } else {
            tVarTt = com.byazt.ga.sp.tt(inputStream, str2);
        }
        if (tVarTt.c() != null) {
            return tVarTt.c();
        }
        return null;
    }

    private t<com.byazt.ga.a> ve(Context context, String str, String str2) {
        com.byazt.kk.a.c("Fetching " + str);
        uj ujVar = null;
        try {
            try {
                uj ujVarC = this.tt.c(str);
                if (!ujVarC.c()) {
                    t<com.byazt.ga.a> tVar = new t<>(new IllegalArgumentException(ujVarC.uj()));
                    if (ujVarC != null) {
                        try {
                            ujVarC.close();
                        } catch (IOException e) {
                            com.byazt.kk.a.c("LottieFetchResult close failed ", e);
                        }
                    }
                    return tVar;
                }
                t<com.byazt.ga.a> tVarC = c(context, str, ujVarC.tt(), ujVarC.ve(), str2);
                com.byazt.kk.a.c("Completed fetch from network. Success: " + (tVarC.c() != null));
                if (ujVarC != null) {
                    try {
                        ujVarC.close();
                    } catch (IOException e2) {
                        com.byazt.kk.a.c("LottieFetchResult close failed ", e2);
                    }
                }
                return tVarC;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        ujVar.close();
                    } catch (IOException e3) {
                        com.byazt.kk.a.c("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            t<com.byazt.ga.a> tVar2 = new t<>(e4);
            if (0 != 0) {
                try {
                    ujVar.close();
                } catch (IOException e5) {
                    com.byazt.kk.a.c("LottieFetchResult close failed ", e5);
                }
            }
            return tVar2;
        }
    }

    private t<com.byazt.ga.a> c(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        t<com.byazt.ga.a> tVarC;
        ve veVar;
        sp spVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.byazt.kk.a.c("Handling zip response.");
            ve veVar2 = ve.ZIP;
            tVarC = c(context, str, inputStream, str3);
            veVar = veVar2;
        } else {
            com.byazt.kk.a.c("Received json response.");
            veVar = ve.JSON;
            tVarC = c(str, inputStream, str3);
        }
        if (str3 != null && tVarC.c() != null && (spVar = this.c) != null) {
            spVar.c(str3, veVar);
        }
        return tVarC;
    }

    private t<com.byazt.ga.a> c(Context context, String str, InputStream inputStream, String str2) throws IOException {
        sp spVar;
        if (str2 == null || (spVar = this.c) == null) {
            return com.byazt.ga.sp.c(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.byazt.ga.sp.c(context, new ZipInputStream(new FileInputStream(spVar.c(str2, inputStream, ve.ZIP))), str);
    }

    private t<com.byazt.ga.a> c(String str, InputStream inputStream, String str2) throws IOException {
        sp spVar;
        if (str2 == null || (spVar = this.c) == null) {
            return com.byazt.ga.sp.tt(inputStream, (String) null);
        }
        return com.byazt.ga.sp.tt(new FileInputStream(spVar.c(str2, inputStream, ve.JSON).getAbsolutePath()), str);
    }
}
