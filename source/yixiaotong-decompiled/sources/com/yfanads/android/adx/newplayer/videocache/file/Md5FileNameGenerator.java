package com.yfanads.android.adx.newplayer.videocache.file;

import android.text.TextUtils;
import com.yfanads.android.adx.newplayer.videocache.ProxyCacheUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    private String getExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.file.FileNameGenerator
    public String generate(String str) {
        String extension = getExtension(str);
        String strComputeMD5 = ProxyCacheUtils.computeMD5(str);
        return TextUtils.isEmpty(extension) ? strComputeMD5 : strComputeMD5 + "." + extension;
    }
}
