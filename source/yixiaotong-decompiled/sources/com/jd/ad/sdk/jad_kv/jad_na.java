package com.jd.ad.sdk.jad_kv;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na extends jad_bo<InputStream> {
    public jad_na(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public void jad_an(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_bo
    public InputStream jad_an(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
