package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class FileService {
    FileService() {
    }

    public boolean exists(File file) {
        return file.exists();
    }

    public long length(File file) {
        return file.length();
    }

    public File get(String str) {
        return new File(str);
    }
}
