package com.kwad.components.core.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.sdk.utils.cg;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
final class v implements IZipper {
    v() {
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean unZip(Context context, InputStream inputStream, String str) {
        return cg.unZip(context, inputStream, str);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final void zipFile(File file) {
        cg.zipFile(file);
    }

    @Override // com.kwad.components.offline.api.core.api.IZipper
    public final boolean zip(File file, File file2) {
        return cg.zip(file, file2);
    }
}
