package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class bk {
    public static String b() {
        return "0";
    }

    public static int a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            TimeZone timeZone = Calendar.getInstance().getTimeZone();
            if (timeZone == null) {
                return null;
            }
            jSONObject.put("0", String.valueOf(timeZone.getOffset(System.currentTimeMillis()) / 1000));
            jSONObject.put("1", timeZone.getID());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        String string;
        try {
            string = Locale.getDefault().toString();
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    public static JSONObject d() {
        BufferedReader bufferedReader;
        JSONObject jSONObject = new JSONObject();
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("lsmod").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        } else if (!TextUtils.isEmpty(line)) {
                            String strA = bm.a(line);
                            if (strA.contains(com.huawei.openalliance.ad.constant.x.A) && strA.contains(";")) {
                                String[] strArrSplit = strA.replace(";;;", ";").split(";");
                                if (strArrSplit.length > 1) {
                                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                                } else {
                                    continue;
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (bufferedReader != null) {
                        }
                        return jSONObject;
                    }
                }
                dataInputStream2.close();
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused6) {
        }
        return jSONObject;
    }
}
