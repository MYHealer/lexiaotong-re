package com.jd.ad.sdk.jad_qb;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_wj<Data> implements jad_na<Uri, Data> {
    public static final Set<String> jad_bo = Collections.unmodifiableSet(new HashSet(Arrays.asList(UriUtil.LOCAL_FILE_SCHEME, "android.resource", "content")));
    public final jad_cp<Data> jad_an;

    public static final class jad_an implements jad_ob<Uri, AssetFileDescriptor>, jad_cp<AssetFileDescriptor> {
        public final ContentResolver jad_an;

        public jad_an(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<AssetFileDescriptor> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_an(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    public static class jad_bo implements jad_ob<Uri, ParcelFileDescriptor>, jad_cp<ParcelFileDescriptor> {
        public final ContentResolver jad_an;

        public jad_bo(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<ParcelFileDescriptor> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_iv(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, ParcelFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    public interface jad_cp<Data> {
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_an(Uri uri);
    }

    public static class jad_dq implements jad_ob<Uri, InputStream>, jad_cp<InputStream> {
        public final ContentResolver jad_an;

        public jad_dq(ContentResolver contentResolver) {
            this.jad_an = contentResolver;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_wj.jad_cp
        public com.jd.ad.sdk.jad_kv.jad_dq<InputStream> jad_an(Uri uri) {
            return new com.jd.ad.sdk.jad_kv.jad_ob(this.jad_an, uri);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_wj(this);
        }
    }

    public jad_wj(jad_cp<Data> jad_cpVar) {
        this.jad_an = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(Uri uri, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), Collections.emptyList(), this.jad_an.jad_an(uri2));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Uri uri) {
        return jad_bo.contains(uri.getScheme());
    }
}
