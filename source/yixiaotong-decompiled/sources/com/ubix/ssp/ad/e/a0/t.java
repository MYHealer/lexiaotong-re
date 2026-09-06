package com.ubix.ssp.ad.e.a0;

import android.content.Context;
import android.util.Base64;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Calendar f8730a = null;
    int b = 7;
    int c = 10;

    private int a(String str) {
        Date dateA;
        for (int i = 0; i < this.b; i++) {
            if (this.f8730a == null) {
                Calendar calendar = Calendar.getInstance();
                this.f8730a = calendar;
                dateA = calendar.getTime();
            } else {
                dateA = a();
            }
            String strReplace = new String(Base64.decode("Y29tLnRhb2Jhby50YW9iYW9fe2RhdGV9LmRhdGEue251bX0=", 10)).replace("{date}", a(dateA));
            int i2 = 1;
            while (i2 < this.c) {
                int i3 = i2 + 1;
                File file = new File(str + "/" + strReplace.replace("{num}", i2 + ""));
                u.e("tblog=" + file.getAbsolutePath());
                if (file.exists()) {
                    return 0;
                }
                i2 = i3;
            }
        }
        return 4;
    }

    private String a(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    private Date a() {
        this.f8730a.add(5, -1);
        return this.f8730a.getTime();
    }

    public int a(Context context) {
        File parentFile;
        File fileD = k.d(context);
        if (fileD == null || (parentFile = fileD.getParentFile()) == null) {
            return 5;
        }
        File parentFile2 = parentFile.getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            return 1;
        }
        String absolutePath = parentFile2.getAbsolutePath();
        if (!new File(absolutePath + "/" + new String(Base64.decode("Y29tLnRhb2Jhby50YW9iYW8=", 10))).exists()) {
            return 2;
        }
        File file = new File(absolutePath + new String(Base64.decode("L2NvbS50YW9iYW8udGFvYmFvL2ZpbGVzL3RkYXRhX3Y5Lw==", 10)));
        if (file.exists()) {
            return a(file.getAbsolutePath());
        }
        return 3;
    }
}
