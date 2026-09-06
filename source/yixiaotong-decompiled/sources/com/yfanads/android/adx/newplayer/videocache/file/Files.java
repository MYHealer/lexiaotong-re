package com.yfanads.android.adx.newplayer.videocache.file;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class Files {

    /* JADX INFO: renamed from: com.yfanads.android.adx.newplayer.videocache.file.Files$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class LastModifiedComparator implements Comparator<File> {
        private LastModifiedComparator() {
        }

        public /* synthetic */ LastModifiedComparator(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    public static List<File> getLruListFiles(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new LastModifiedComparator(null));
        return listAsList;
    }

    public static void makeDir(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static void modify(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            recreateZeroSizeFile(file);
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte b = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(b);
        randomAccessFile.close();
    }

    private static void recreateZeroSizeFile(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    public static void setLastModifiedNow(File file) throws IOException {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            modify(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                Log.w("Files", "Last modified date {} is not set for file {}" + new Date(file.lastModified()) + "|" + file.getAbsolutePath());
            }
        }
    }
}
