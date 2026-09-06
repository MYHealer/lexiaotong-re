package com.jd.ad.sdk.jad_kv;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.jd.ad.sdk.jad_te.jad_sf;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx implements jad_er<InputStream> {
    public final jad_sf jad_an;

    public static final class jad_an implements jad_er.jad_an<InputStream> {
        public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

        public jad_an(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public jad_er<InputStream> jad_an(InputStream inputStream) {
            return new jad_kx(inputStream, this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_er.jad_an
        public Class<InputStream> jad_an() {
            return InputStream.class;
        }
    }

    public jad_kx(InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        jad_sf jad_sfVar = new jad_sf(inputStream, jad_boVar);
        this.jad_an = jad_sfVar;
        jad_sfVar.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    public void jad_bo() {
        this.jad_an.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_er
    /* JADX INFO: renamed from: jad_cp, reason: merged with bridge method [inline-methods] */
    public InputStream jad_an() {
        this.jad_an.reset();
        return this.jad_an;
    }
}
