package com.jd.ad.sdk.jad_rc;

import android.content.Context;
import android.net.Uri;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.jad_qb.jad_ob;
import com.jd.ad.sdk.jad_qb.jad_re;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements jad_na<Uri, InputStream> {
    public final Context jad_an;

    public static class jad_an implements jad_ob<Uri, InputStream> {
        public final Context jad_an;

        public jad_an(Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<Uri, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_bo(this.jad_an);
        }
    }

    public jad_bo(Context context) {
        this.jad_an = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<InputStream> jad_an(Uri uri, int i, int i2, jad_jw jad_jwVar) {
        Uri uri2 = uri;
        if (!com.jd.ad.sdk.jad_lw.jad_bo.jad_an(i, i2)) {
            return null;
        }
        com.jd.ad.sdk.jad_hq.jad_bo jad_boVar = new com.jd.ad.sdk.jad_hq.jad_bo(uri2);
        Context context = this.jad_an;
        return new jad_na.jad_an<>(jad_boVar, Collections.emptyList(), com.jd.ad.sdk.jad_lw.jad_cp.jad_an(context, uri2, new com.jd.ad.sdk.jad_lw.jad_cp.jad_an(context.getContentResolver())));
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public boolean jad_an(Uri uri) {
        return com.jd.ad.sdk.jad_lw.jad_bo.jad_an(uri) && !uri.getPathSegments().contains("video");
    }
}
