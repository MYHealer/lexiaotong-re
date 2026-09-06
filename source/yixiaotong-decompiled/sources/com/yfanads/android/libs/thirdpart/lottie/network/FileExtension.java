package com.yfanads.android.libs.thirdpart.lottie.network;

import com.yfanads.android.libs.thirdpart.lottie.L;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum FileExtension {
    Json(".json"),
    Zip(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        L.warn("Unable to find correct extension for " + str);
        return Json;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
