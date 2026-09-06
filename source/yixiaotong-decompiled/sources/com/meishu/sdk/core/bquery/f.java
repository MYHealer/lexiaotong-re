package com.meishu.sdk.core.bquery;

import com.meishu.sdk.core.safe.l;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: compiled from: BQUtility.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f4772a;
    public final /* synthetic */ long b;

    public f(File file, long j) {
        this.f4772a = file;
        this.b = j;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        File file = this.f4772a;
        long j = this.b;
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles);
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    file2.length();
                    if (System.currentTimeMillis() - file2.lastModified() >= j) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
