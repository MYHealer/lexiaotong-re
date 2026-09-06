package com.opos.mobad.service.b;

import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    private static int a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return c(new File(str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("MobFileTool", "", (Throwable) e);
            return 0;
        }
    }

    public static void a(File file) {
        String str;
        if (file != null && file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (e.a(file2)) {
                        a(file2, false);
                    }
                }
                return;
            }
            str = "clearEmptyDir but null listFiles";
        } else {
            str = "clearEmptyDir but folder not exist";
        }
        com.opos.cmn.an.f.a.b("MobFileTool", str);
    }

    public static void a(File file, long j, int i) {
        a(file, j, i, false);
    }

    private static void a(File file, long j, int i, boolean z) {
        File[] fileArrListFiles;
        if (!file.exists() || !file.isDirectory()) {
            com.opos.cmn.an.f.a.b("MobFileTool", "folder not exist");
            return;
        }
        long jB = b(file);
        int iA = a(file.getAbsolutePath());
        if (jB < j && iA < i) {
            com.opos.cmn.an.f.a.b("MobFileTool", "video cache size not over max size or over max count,don't need clear video cache.");
            return;
        }
        com.opos.cmn.an.f.a.b("MobFileTool", "video cache size over max size or over max count,start clear video cache.");
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.opos.mobad.service.b.c.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file2, File file3) {
                long jLastModified = file2.lastModified() - file3.lastModified();
                if (jLastModified > 0) {
                    return 1;
                }
                return jLastModified == 0 ? 0 : -1;
            }

            @Override // java.util.Comparator
            public boolean equals(Object obj) {
                return true;
            }
        });
        for (int i2 = 0; i2 < fileArrListFiles.length / 2; i2++) {
            a(fileArrListFiles[i2], z);
        }
    }

    public static void a(File file, File file2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        com.opos.cmn.an.f.a.b("MobFileTool", "dir not directory");
                        return;
                    }
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                        for (File file3 : fileArrListFiles) {
                            if (!file3.isDirectory()) {
                                String name = file3.getName();
                                if (TextUtils.isEmpty(name) || file2 == null || !name.equals(file2.getName())) {
                                    a(file3, true);
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MobFileTool", "", (Throwable) e);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("MobFileTool", "clear but null file");
    }

    private static final void a(File file, boolean z) {
        if (file == null || !file.exists()) {
            com.opos.cmn.an.f.a.b("MobFileTool", "dirtyFile not exists");
            return;
        }
        if (z && file.isDirectory()) {
            com.opos.cmn.an.f.a.b("MobFileTool", "skip for directFile", file.getAbsolutePath());
            return;
        }
        File file2 = new File(file.getAbsolutePath() + "_dirty");
        if (file2.exists()) {
            com.opos.cmn.an.f.a.b("MobFileTool", "dirtyFile exist");
            d(file2);
        } else if (file.renameTo(file2)) {
            d(file2);
        } else {
            com.opos.cmn.an.f.a.b("MobFileTool", "rn fail");
        }
    }

    public static long b(File file) {
        long jB = 0;
        if (!com.opos.cmn.an.e.b.a.a(file)) {
            return 0L;
        }
        try {
            if (!file.isDirectory()) {
                return file.length();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return 0L;
            }
            for (File file2 : fileArrListFiles) {
                jB += file2.isDirectory() ? b(file2) : file2.length();
            }
            return jB;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("FileTool", "", e);
        }
    }

    private static int c(File file) {
        File[] fileArrListFiles;
        int length = 0;
        if (file != null) {
            try {
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    length = fileArrListFiles.length;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("MobFileTool", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("MobFileTool", "getFolderFilesCount folderFile=" + (file != null ? file.getAbsolutePath() : "null") + ",count=" + length);
        return length;
    }

    private static void d(File file) {
        StringBuilder sb;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    d(file2);
                }
            }
            sb = new StringBuilder("removeDirectory = ");
        } else {
            sb = new StringBuilder("removeFile = ");
        }
        com.opos.cmn.an.f.a.b("MobFileTool", sb.append(file.getAbsolutePath()).toString());
        file.delete();
    }
}
