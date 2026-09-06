package com.jd.ad.sdk.jad_kv;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an extends jad_ly<AssetFileDescriptor> {
    public jad_an(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public Class<AssetFileDescriptor> jad_an() {
        return AssetFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public void jad_an(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public AssetFileDescriptor jad_an(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
