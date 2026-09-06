package com.kwad.components.offline.api.core.api;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IZipper {
    boolean unZip(Context context, InputStream inputStream, String str);

    boolean zip(File file, File file2);

    void zipFile(File file);
}
