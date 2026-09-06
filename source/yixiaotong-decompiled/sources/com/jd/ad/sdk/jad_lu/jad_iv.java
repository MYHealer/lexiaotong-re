package com.jd.ad.sdk.jad_lu;

import android.content.Context;
import android.util.Pair;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ Context jad_an;
    public final /* synthetic */ String jad_bo;
    public final /* synthetic */ String jad_cp;

    public jad_iv(Context context, String str, String str2) {
        this.jad_an = context;
        this.jad_bo = str;
        this.jad_cp = str2;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00c8  */
    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        jad_jt jad_jtVar;
        jad_sf<jad_jt> jad_sfVar;
        jad_jt jad_jtVar2;
        Pair pair;
        com.jd.ad.sdk.jad_ud.jad_er jad_erVar;
        Context context = this.jad_an;
        com.jd.ad.sdk.jad_ud.jad_fs jad_fsVar = jad_dq.jad_bo;
        if (jad_fsVar == null) {
            synchronized (com.jd.ad.sdk.jad_ud.jad_fs.class) {
                jad_fsVar = jad_dq.jad_bo;
                if (jad_fsVar == null) {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    com.jd.ad.sdk.jad_ud.jad_er jad_erVar2 = jad_dq.jad_cp;
                    if (jad_erVar2 == null) {
                        synchronized (com.jd.ad.sdk.jad_ud.jad_er.class) {
                            jad_erVar = jad_dq.jad_cp;
                            if (jad_erVar == null) {
                                jad_erVar = new com.jd.ad.sdk.jad_ud.jad_er(new jad_cp(origApplicationContext));
                                jad_dq.jad_cp = jad_erVar;
                            }
                        }
                        jad_erVar2 = jad_erVar;
                    }
                    jad_fsVar = new com.jd.ad.sdk.jad_ud.jad_fs(jad_erVar2, new com.jd.ad.sdk.jad_ud.jad_bo());
                    jad_dq.jad_bo = jad_fsVar;
                }
            }
        }
        String str = this.jad_bo;
        String str2 = this.jad_cp;
        com.jd.ad.sdk.jad_ud.jad_an jad_anVar = null;
        if (str2 == null) {
            jad_jtVar = null;
        } else {
            com.jd.ad.sdk.jad_ud.jad_er jad_erVar3 = jad_fsVar.jad_an;
            jad_erVar3.getClass();
            try {
                File fileJad_an = jad_erVar3.jad_an();
                com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.JSON;
                File file = new File(fileJad_an, com.jd.ad.sdk.jad_ud.jad_er.jad_an(str, jad_cpVar, false));
                if (!file.exists()) {
                    file = new File(jad_erVar3.jad_an(), com.jd.ad.sdk.jad_ud.jad_er.jad_an(str, com.jd.ad.sdk.jad_ud.jad_cp.ZIP, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
                if (file == null) {
                    pair = null;
                } else {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (file.getAbsolutePath().endsWith(".zip")) {
                        jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.ZIP;
                    }
                    file.getAbsolutePath();
                    com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                    pair = new Pair(jad_cpVar, fileInputStream);
                }
            } catch (FileNotFoundException unused) {
            }
            if (pair == null) {
                jad_jtVar = null;
            } else {
                com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_ud.jad_cp) pair.first;
                InputStream inputStream = (InputStream) pair.second;
                jad_jt jad_jtVar3 = (jad_cpVar2 == com.jd.ad.sdk.jad_ud.jad_cp.ZIP ? jad_hu.jad_an(new ZipInputStream(inputStream), str) : jad_hu.jad_an(inputStream, str)).jad_an;
                if (jad_jtVar3 != null) {
                    jad_jtVar = jad_jtVar3;
                } else {
                    jad_jtVar = null;
                }
            }
        }
        if (jad_jtVar != null) {
            jad_sfVar = new jad_sf<>(jad_jtVar);
        } else {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            try {
                try {
                    com.jd.ad.sdk.jad_ud.jad_an jad_anVarJad_an = jad_fsVar.jad_bo.jad_an(str);
                    if (jad_anVarJad_an.jad_cp()) {
                        jad_sfVar = jad_fsVar.jad_an(str, jad_anVarJad_an.jad_an.getInputStream(), jad_anVarJad_an.jad_an.getContentType(), str2);
                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                    } else {
                        jad_sfVar = new jad_sf<>(new IllegalArgumentException(jad_anVarJad_an.jad_bo()));
                    }
                    try {
                        jad_anVarJad_an.jad_an.disconnect();
                    } catch (IOException e) {
                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e);
                    }
                } catch (Exception e2) {
                    jad_sf<jad_jt> jad_sfVar2 = new jad_sf<>(e2);
                    if (0 != 0) {
                        try {
                            jad_anVar.jad_an.disconnect();
                        } catch (IOException e3) {
                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e3);
                        }
                    }
                    jad_sfVar = jad_sfVar2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        jad_anVar.jad_an.disconnect();
                    } catch (IOException e4) {
                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e4);
                    }
                }
                throw th;
            }
        }
        String str3 = this.jad_cp;
        if (str3 != null && (jad_jtVar2 = jad_sfVar.jad_an) != null) {
            com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str3, jad_jtVar2);
        }
        return jad_sfVar;
    }
}
