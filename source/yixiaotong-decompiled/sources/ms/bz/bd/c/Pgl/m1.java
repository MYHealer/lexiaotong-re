package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class m1 {
    public static String c(Context context) {
        String str;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains("/")) {
                    str = string.split("/")[0];
                    str2 = str;
                } else {
                    str2 = string;
                }
            }
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]").append(packageName);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }

    public static String tt(Context context) {
        String str;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (!TextUtils.isEmpty(string)) {
                if (string.contains("/")) {
                    str = string.split("/")[0];
                    str2 = str;
                } else {
                    str2 = string;
                }
            }
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                String str3 = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]").append(str3);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }
}
