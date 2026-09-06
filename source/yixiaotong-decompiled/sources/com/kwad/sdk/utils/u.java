package com.kwad.sdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class u {
    public static void e(File file, File file2) {
        if (file.exists() && file.isDirectory()) {
            if (file2.exists()) {
                O(file2);
            }
            if (file2.mkdirs()) {
                a(file, file2, new int[]{0}, P(file));
                O(file);
            }
        }
    }

    private static void a(File file, File file2, int[] iArr, int i) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            com.kwad.sdk.core.d.c.d("DirectoryMover", "moveDirectoryContents file " + file3.getAbsolutePath());
            File file4 = new File(file2, file3.getName());
            if (file3.isDirectory()) {
                if (!file4.mkdirs()) {
                    com.kwad.sdk.core.d.c.d("DirectoryMover", "无法创建目录: " + file4.getAbsolutePath());
                }
                a(file3, file4, iArr, i);
                if (!file3.delete()) {
                    com.kwad.sdk.core.d.c.d("DirectoryMover", "无法删除目录: " + file3.getAbsolutePath());
                }
            } else {
                if (!f(file3, file4)) {
                    com.kwad.sdk.core.d.c.d("DirectoryMover", "无法移动文件: " + file3.getAbsolutePath());
                }
                iArr[0] = iArr[0] + 1;
            }
        }
    }

    private static boolean f(File file, File file2) {
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel2.transferFrom(channel, 0L, channel.size());
                    boolean zDelete = file.delete();
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    return zDelete;
                } catch (Throwable th) {
                    if (channel2 != null) {
                        try {
                            channel2.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private static boolean O(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (!O(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static int P(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return 0;
        }
        int iP = 0;
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                iP++;
            } else if (file2.isDirectory()) {
                iP += P(file2);
            }
        }
        return iP;
    }
}
