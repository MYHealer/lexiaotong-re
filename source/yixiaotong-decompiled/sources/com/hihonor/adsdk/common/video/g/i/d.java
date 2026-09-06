package com.hihonor.adsdk.common.video.g.i;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class d {
    private static final String hnadsa = "Files";

    static /* synthetic */ class a {
    }

    private static final class b implements Comparator<File> {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return hnadsa(file.lastModified(), file2.lastModified());
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        private int hnadsa(long j, long j2) {
            return Long.compare(j, j2);
        }
    }

    d() {
    }

    static List<File> hnadsa(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return linkedList;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        Collections.sort(listAsList, new b(null));
        return listAsList;
    }

    static void hnadsb(File file) throws com.hihonor.adsdk.common.video.g.f {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "File " + file + " is not directory!");
            }
            return;
        }
        boolean zMkdirs = file.mkdirs();
        try {
            String canonicalPath = file.getCanonicalPath();
            if (!zMkdirs) {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, String.format("Directory %s can't be created", canonicalPath));
            }
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "makeDir, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "makeDir get path error" + e.getMessage());
        }
    }

    static void hnadsc(File file) throws com.hihonor.adsdk.common.video.g.f {
        long length = file.length();
        if (length == 0) {
            hnadsd(file);
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            randomAccessFile.seek(j);
            byte b2 = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(b2);
            randomAccessFile.close();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "modify, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error modify file " + file);
        }
    }

    private static void hnadsd(File file) throws com.hihonor.adsdk.common.video.g.f {
        try {
            if (file.delete() && file.createNewFile()) {
            } else {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error recreate zero-size file " + file);
            }
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "recreateZeroSizeFile, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error recreate zero-size file " + file);
        }
    }

    static void hnadse(File file) throws com.hihonor.adsdk.common.video.g.f {
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(jCurrentTimeMillis)) {
                return;
            }
            hnadsc(file);
            if (file.lastModified() < jCurrentTimeMillis) {
                try {
                    com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "Last modified date {} is not set for file {}", new Date(file.lastModified()), file.getCanonicalPath());
                } catch (IOException e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "setLastModifiedNow, IOException: " + e.getMessage(), new Object[0]);
                    throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "setLastModifiedNow get path error" + e.getMessage());
                }
            }
        }
    }
}
