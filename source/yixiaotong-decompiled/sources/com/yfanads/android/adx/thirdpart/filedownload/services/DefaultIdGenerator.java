package com.yfanads.android.adx.thirdpart.filedownload.services;

import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class DefaultIdGenerator implements FileDownloadHelper.IdGenerator {
    @Override // com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper.IdGenerator
    public int generateId(String str, String str2, boolean z) {
        return z ? FileDownloadUtils.md5(FileDownloadUtils.formatString("%sp%s@dir", str, str2)).hashCode() : FileDownloadUtils.md5(FileDownloadUtils.formatString("%sp%s", str, str2)).hashCode();
    }

    @Override // com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadHelper.IdGenerator
    public int transOldId(int i, String str, String str2, boolean z) {
        return generateId(str, str2, z);
    }
}
