package com.jd.ad.sdk.jad_kv;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv extends jad_ly<ParcelFileDescriptor> {
    public jad_iv(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_dq
    public Class<ParcelFileDescriptor> jad_an() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public void jad_an(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_ly
    public ParcelFileDescriptor jad_an(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.k);
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
