package com.kuaishou.weapon.p0;

import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ae {
    public boolean a(String str) {
        return new File(File.separator + "proc" + File.separator + str).canWrite();
    }

    public boolean b(String str) {
        return a(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    public boolean a(String str, boolean z) {
        FileOutputStream fileOutputStream;
        String string = "";
        if (z) {
            try {
                str = str + "/-" + System.currentTimeMillis();
                string = new StringBuilder().append(System.currentTimeMillis()).toString();
            } catch (Throwable unused) {
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                } catch (Exception unused2) {
                    return false;
                }
            }
        }
        File file = new File(str);
        file.exists();
        fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            if (z) {
                file.delete();
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception unused3) {
                return true;
            }
        } catch (Throwable unused4) {
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/data", true) ? 1 : 0);
            jSONObject.put("1", a("/system/bin", true) ? 1 : 0);
            jSONObject.put("2", a("/system/lib", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a("/sys", true) ? 1 : 0);
            jSONObject.put("1", a("/sbin", true) ? 1 : 0);
            jSONObject.put("2", a("/etc", true) ? 1 : 0);
            jSONObject.put("3", a("/dev", true) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
