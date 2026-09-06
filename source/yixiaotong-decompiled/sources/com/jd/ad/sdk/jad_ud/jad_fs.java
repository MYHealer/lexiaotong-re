package com.jd.ad.sdk.jad_ud;

import com.jd.ad.sdk.jad_lu.jad_hu;
import com.jd.ad.sdk.jad_lu.jad_jt;
import com.jd.ad.sdk.jad_lu.jad_sf;
import com.jd.ad.sdk.jad_lu.jad_zm;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs {
    public final jad_er jad_an;
    public final jad_bo jad_bo;

    public jad_fs(jad_er jad_erVar, jad_bo jad_boVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_boVar;
    }

    public final jad_sf<jad_jt> jad_an(String str, InputStream inputStream, String str2, String str3) {
        jad_cp jad_cpVar;
        jad_sf<jad_jt> jad_sfVarJad_an;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            jad_cpVar = jad_cp.ZIP;
            jad_sfVarJad_an = str3 == null ? jad_hu.jad_an(new ZipInputStream(inputStream), (String) null) : jad_hu.jad_an(new ZipInputStream(new FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar))), str);
        } else {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            jad_cpVar = jad_cp.JSON;
            jad_sfVarJad_an = str3 == null ? jad_hu.jad_an(inputStream, (String) null) : jad_hu.jad_an(new FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar).getAbsolutePath()), str);
        }
        if (str3 != null && jad_sfVarJad_an.jad_an != null) {
            jad_er jad_erVar = this.jad_an;
            jad_erVar.getClass();
            File file = new File(jad_erVar.jad_an(), jad_er.jad_an(str, jad_cpVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean zRenameTo = file.renameTo(file2);
            file2.toString();
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            if (!zRenameTo) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an(jad_zm.jad_an("Unable to rename cache file ").append(file.getAbsolutePath()).append(" to ").append(file2.getAbsolutePath()).append(".").toString());
            }
        }
        return jad_sfVarJad_an;
    }
}
