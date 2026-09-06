package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.cp;
import com.huawei.hms.ads.fh;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class k {
    private static final String Code = "CNStrUtil";

    private static String Code(long j) {
        float f = (j * 1.0f) / 1048576.0f;
        if (f < 0.1f) {
            f = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }

    public static String Code(Context context, int i, String str, Object... objArr) {
        StringBuilder sb;
        Resources resources = context.getResources();
        String string = null;
        try {
            if (cp.Code(context).Code()) {
                int identifier = resources.getIdentifier(str + "_zh", TypedValues.Custom.S_STRING, context.getPackageName());
                string = objArr != null ? resources.getString(identifier, objArr) : resources.getString(identifier);
            }
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder("getChinaString ");
            fh.Z(Code, sb.append(e.getClass().getSimpleName()).toString());
        } catch (Exception e2) {
            e = e2;
            sb = new StringBuilder("getChinaString ");
            fh.Z(Code, sb.append(e.getClass().getSimpleName()).toString());
        }
        if (string == null) {
            return (objArr == null || objArr.length <= 0) ? resources.getString(i) : resources.getString(i, objArr);
        }
        return string;
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }
}
