package com.jd.ad.sdk.jad_qb;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import java.io.InputStream;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an<Data> implements jad_na<Uri, Data> {
    public final AssetManager jad_an;
    public final InterfaceC0576jad_an<Data> jad_bo;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_qb.jad_an$jad_an, reason: collision with other inner class name */
    public interface InterfaceC0576jad_an<Data> {
        com.jd.ad.sdk.jad_kv.jad_dq<Data> jad_an(AssetManager assetManager, String str);
    }

    public static class jad_bo implements jad_ob<Uri, AssetFileDescriptor>, InterfaceC0576jad_an<AssetFileDescriptor> {
        public final AssetManager jad_an;

        public jad_bo(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0576jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<AssetFileDescriptor> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_kv.jad_hu(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, AssetFileDescriptor> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    public static class jad_cp implements jad_ob<Uri, InputStream>, InterfaceC0576jad_an<InputStream> {
        public final AssetManager jad_an;

        public jad_cp(AssetManager assetManager) {
            this.jad_an = assetManager;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_an.InterfaceC0576jad_an
        public com.jd.ad.sdk.jad_kv.jad_dq<InputStream> jad_an(AssetManager assetManager, String str) {
            return new com.jd.ad.sdk.jad_kv.jad_na(assetManager, str);
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_an(this.jad_an, this);
        }
    }

    public jad_an(AssetManager assetManager, InterfaceC0576jad_an<Data> interfaceC0576jad_an) {
        this.jad_an = assetManager;
        this.jad_bo = interfaceC0576jad_an;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an jad_an(Uri uri, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        Uri uri2 = uri;
        String strSubstring = uri2.toString().substring(22);
        return new jad_na.jad_an(new com.jd.ad.sdk.jad_hq.jad_bo(uri2), Collections.emptyList(), this.jad_bo.jad_an(this.jad_an, strSubstring));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Uri uri) {
        Uri uri2 = uri;
        return UriUtil.LOCAL_FILE_SCHEME.equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
