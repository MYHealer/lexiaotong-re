package com.opos.exoplayer.core.f.f;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e {
    public static b a(b bVar, String[] strArr, Map<String, b> map) {
        if (bVar == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (bVar == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (bVar == null && strArr.length > 1) {
            b bVar2 = new b();
            int length = strArr.length;
            while (i < length) {
                bVar2.a(map.get(strArr[i]));
                i++;
            }
            return bVar2;
        }
        if (bVar != null && strArr != null && strArr.length == 1) {
            return bVar.a(map.get(strArr[0]));
        }
        if (bVar != null && strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i < length2) {
                bVar.a(map.get(strArr[i]));
                i++;
            }
        }
        return bVar;
    }

    static String a(String str) {
        return str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, IOUtils.LINE_SEPARATOR_UNIX).replaceAll(" *\n *", IOUtils.LINE_SEPARATOR_UNIX).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, PPSLabelView.Code).replaceAll("[ \t\\x0B\f\r]+", PPSLabelView.Code);
    }

    static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, b bVar) {
        Object absoluteSizeSpan;
        if (bVar.a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(bVar.a()), i, i2, 33);
        }
        if (bVar.b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (bVar.c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (bVar.f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(bVar.e()), i, i2, 33);
        }
        if (bVar.h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(bVar.g()), i, i2, 33);
        }
        if (bVar.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(bVar.d()), i, i2, 33);
        }
        if (bVar.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(bVar.j()), i, i2, 33);
        }
        int iK = bVar.k();
        if (iK == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) bVar.l(), true);
        } else if (iK == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l());
        } else if (iK != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(bVar.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, i2, 33);
    }
}
