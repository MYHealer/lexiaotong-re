package com.opos.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class h {

    /* JADX INFO: renamed from: com.opos.videocache.a.h$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a implements Comparator<File> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    static void a(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new a(null));
        return listAsList;
    }

    static void c(File file) throws Throwable {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                com.opos.cmn.an.f.a.a("Files", "Last modified date {} is not set for file {}" + new Date(file.lastModified()) + file.getAbsolutePath());
            }
        }
    }

    static void d(File file) throws Throwable {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j = length - 1;
                try {
                    randomAccessFile2.seek(j);
                    byte b = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j);
                    randomAccessFile2.write(b);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    randomAccessFile = randomAccessFile2;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            throw e3;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
        }
    }

    private static void e(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }
}
