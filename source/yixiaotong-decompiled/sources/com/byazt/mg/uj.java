package com.byazt.mg;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 170, 15})
public class uj {
    public static void c(File file, String str, boolean z) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                a.c(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                a.c(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean c(File file) {
        return file.exists() && file.delete();
    }

    public static String c(String str, String str2) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        a.c(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    a.c(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String tt(String str) throws IOException {
        return c(str, null);
    }

    public static com.byazt.xz.ve ve(String str) {
        try {
            JSONObject jSONObject = new JSONObject(tt(str));
            com.byazt.xz.ve veVar = new com.byazt.xz.ve();
            veVar.c(jSONObject.optString("url"));
            veVar.c(jSONObject.optJSONObject(TtmlNode.TAG_BODY));
            veVar.tt(jSONObject.optString("dump_file"));
            veVar.c(jSONObject.optBoolean("encrypt", false));
            return veVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return c(file, str, str2, jSONObject, null, z);
    }

    public static String c(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put(TtmlNode.TAG_BODY, jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            c(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            com.byazt.nr.m.c(e);
        } catch (JSONException e2) {
            com.byazt.nr.m.c(e2);
        }
        return file2.getAbsolutePath();
    }

    public static void c(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(PPSLabelView.Code);
            if (str == null) {
                str = "null";
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(PPSLabelView.Code);
            if (str2 == null) {
                str2 = "null";
            }
            c(x.tt(context), sbAppend2.append(str2).append(IOUtils.LINE_SEPARATOR_UNIX).toString(), true);
        } catch (IOException e) {
            com.byazt.nr.m.c(e);
        }
    }
}
