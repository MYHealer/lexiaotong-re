package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.os.Process;
import com.huawei.openalliance.ad.constant.x;
import com.qihoo.jiagu.a;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class CrashReportDataFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Calendar f8449a;

    public native String interface9();

    public CrashReportDataFactory(Context context, Calendar calendar) {
        this.f8449a = calendar;
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArrSplit = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        for (int i = 0; i < strArrSplit.length; i++) {
            if (!strArrSplit[i].contains(b.b)) {
                stringBuffer.append(strArrSplit[i]).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return stringBuffer.toString();
    }

    static String a(String str, ArrayList<String> arrayList) {
        int i;
        int i2 = 0;
        if (str == null || arrayList == null) {
            return null;
        }
        String[] strArrSplit = str.split(IOUtils.LINE_SEPARATOR_UNIX);
        int i3 = 0;
        while (true) {
            i = i2;
            if (i3 >= strArrSplit.length - 1) {
                break;
            }
            i2 = strArrSplit[i3].replaceAll("\t", "").trim().startsWith("Caused by:") ? i3 : i;
            i3++;
        }
        for (int i4 = i + 1; i4 < strArrSplit.length; i4++) {
            String strTrim = strArrSplit[i4].replaceAll("\t", "").trim();
            if (strTrim.startsWith("at")) {
                strTrim = strTrim.substring(2).trim();
            }
            if (arrayList.contains(strTrim)) {
                return strTrim;
            }
        }
        return null;
    }

    static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        int iMyPid = Process.myPid();
        map.put("ed", Integer.toString(iMyPid));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + iMyPid + "/status"))));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith("PPid:")) {
                        map.put("epd", line.substring(line.indexOf(x.bQ) + 1).replaceFirst("^\\s*", ""));
                        break;
                    }
                } catch (IOException e) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                    throw th;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
            }
        } catch (FileNotFoundException e5) {
        }
        return map;
    }

    String b() {
        try {
            return interface9();
        } catch (Throwable th) {
            return null;
        }
    }

    static String c() {
        int iIndexOf;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + Process.myPid() + "/cmdline"))));
            try {
                String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                }
                if (line != null && (iIndexOf = line.indexOf("\u0000")) >= 0) {
                    return line.substring(0, iIndexOf);
                }
                return null;
            } catch (IOException e2) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e3) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            return null;
        }
    }

    String a(String str, String str2, ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        if (str2 != null) {
            stringBuffer.append(str2);
        }
        List listAsList = Arrays.asList(a.f8452a);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                String str3 = arrayList.get(i2);
                if (!a((List<String>) listAsList, str3)) {
                    stringBuffer.append(str3);
                }
                i = i2 + 1;
            } else {
                return c.a(stringBuffer.toString().getBytes());
            }
        }
    }

    private static boolean a(List<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (str.startsWith(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    static ArrayList<String> a(Throwable th) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                arrayList.add(stackTraceElement.toString());
            }
            th = th.getCause();
        }
        return arrayList;
    }

    static String a(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(Long.valueOf(calendar.getTimeInMillis()));
    }
}
