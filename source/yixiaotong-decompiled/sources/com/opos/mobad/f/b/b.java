package com.opos.mobad.f.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static boolean a(Context context, File file) {
        if (context == null || !com.opos.cmn.an.e.b.a.a(file)) {
            return false;
        }
        context.startActivity(b(context, file));
        return true;
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(context, new File(str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InstallUtils", "", (Throwable) e);
            return false;
        }
    }

    private static Intent b(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".MobFileProvider", file);
        intent.setFlags(1);
        context.grantUriPermission(context.getPackageName(), uriForFile, 1);
        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        intent.addFlags(268435456);
        return intent;
    }

    public static Intent b(Context context, String str) {
        return b(context, new File(str));
    }
}
