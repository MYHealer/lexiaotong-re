package com.jd.ad.sdk.jad_qb;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_uh<Data> implements jad_na<String, Data> {
    public final jad_na<Uri, Data> jad_an;

    public static final class jad_an implements jad_ob<String, AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<String, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class jad_bo implements jad_ob<String, ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<String, ParcelFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class jad_cp implements jad_ob<String, InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<String, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_uh(jad_reVar.jad_an(Uri.class, InputStream.class));
        }
    }

    public jad_uh(jad_na<Uri, Data> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(String str, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Uri uriFromFile;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            uriFromFile = null;
        } else if (str2.charAt(0) == '/') {
            uriFromFile = Uri.fromFile(new File(str2));
        } else {
            uriFromFile = Uri.parse(str2);
            if (uriFromFile.getScheme() == null) {
                uriFromFile = Uri.fromFile(new File(str2));
            }
        }
        if (uriFromFile == null || !this.jad_an.jad_an(uriFromFile)) {
            return null;
        }
        return this.jad_an.jad_an(uriFromFile, i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(String str) {
        return true;
    }
}
