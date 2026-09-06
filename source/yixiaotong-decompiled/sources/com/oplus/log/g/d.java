package com.oplus.log.g;

import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.log.d.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {

    public interface a {
        void a(int i, File file);

        void a(int i, String str);
    }

    private static List<File> a(long j, long j2, String str, final String str2) {
        long time;
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        try {
            time = simpleDateFormat.parse(simpleDateFormat.format(new Date(j))).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            time = j;
        }
        File fileA = h.a(str);
        if (fileA != null && (fileArrListFiles = fileA.listFiles(new FilenameFilter() { // from class: com.oplus.log.g.d.1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str3) {
                if (!TextUtils.isEmpty(str3)) {
                    boolean z = str3.endsWith(".dog3") || str3.endsWith(".dog1") || str3.endsWith(".dog2");
                    boolean z2 = TextUtils.isEmpty(str2) || str3.startsWith(str2);
                    if (z && z2) {
                        return true;
                    }
                }
                return false;
            }
        })) != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                try {
                    String[] strArrSplit = file.getName().split("\\.")[0].split("_");
                    long time2 = simpleDateFormat.parse(strArrSplit[strArrSplit.length - 4] + x.A + strArrSplit[strArrSplit.length - 3] + x.A + strArrSplit[strArrSplit.length - 2] + x.A + strArrSplit[strArrSplit.length - 1]).getTime();
                    if (j <= 0 || j2 <= 0 || (time2 >= time && time2 <= j2)) {
                        arrayList.add(file);
                    }
                } catch (Exception e2) {
                    if (com.oplus.log.b.c()) {
                        e2.printStackTrace();
                    }
                }
            }
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.oplus.log.g.d.2
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file2, File file3) {
                    return file2.lastModified() <= file3.lastModified() ? 1 : -1;
                }
            });
        }
        return arrayList;
    }

    public static void a(long j, long j2, com.oplus.log.c cVar, String str, String str2, a aVar) {
        List<File> listA = a(j, j2, cVar.e(), cVar.g());
        if (listA.size() == 0) {
            aVar.a(IBidding.ECPM_STATUS_NULL_AD_IMPL, "no match file");
            return;
        }
        StringBuilder sb = new StringBuilder("opluslog_");
        sb.append(str2).append("_").append(UUID.randomUUID()).append(".zip");
        a(sb.toString(), str, listA, aVar);
    }

    private static void a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static void a(String str) {
        File fileA = h.a(str);
        if (fileA == null) {
            return;
        }
        a(fileA);
    }

    private static void a(String str, String str2, List<File> list, a aVar) {
        File fileA = h.a(str2);
        if (fileA == null || !fileA.isDirectory() || list == null || list.size() == 0) {
            if (aVar != null) {
                aVar.a(IBidding.ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE, "");
                return;
            }
            return;
        }
        File fileB = h.b(str2 + File.separator + str);
        if (fileB == null) {
            if (aVar != null) {
                aVar.a(IBidding.ECPM_PRICE_STATUS_NULL_AD, "");
                return;
            }
            return;
        }
        byte[] bArr = new byte[1024];
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileB);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                try {
                    int i = 100;
                    long length = 0;
                    for (File file : list) {
                        length += file.length();
                        if (length >= 3145728) {
                            i = 101;
                            break;
                        }
                        try {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                                while (true) {
                                    int i2 = fileInputStream.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    } else {
                                        zipOutputStream.write(bArr, 0, i2);
                                    }
                                }
                                zipOutputStream.closeEntry();
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                    throw th2;
                                }
                            }
                        } catch (Exception unused) {
                            i = 102;
                        }
                    }
                    zipOutputStream.close();
                    fileOutputStream.close();
                    if (aVar != null) {
                        if (fileB.length() > 0) {
                            aVar.a(i, fileB);
                        } else {
                            aVar.a(IBidding.ECPM_PRICE_STATUS_LESS_ZERO, "zip file is empty");
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                try {
                    throw th7;
                } catch (Throwable th8) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th9) {
                        th7.addSuppressed(th9);
                    }
                    throw th8;
                }
            }
        } catch (Exception e) {
            if (aVar != null) {
                aVar.a(IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY, e.toString());
            }
        }
    }
}
