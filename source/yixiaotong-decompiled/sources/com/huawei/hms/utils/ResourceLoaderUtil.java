package com.huawei.hms.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class ResourceLoaderUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f4428a;
    public static String b;

    public static int getAnimId(String str) {
        return f4428a.getResources().getIdentifier(str, "anim", b);
    }

    public static int getColorId(String str) {
        return f4428a.getResources().getIdentifier(str, "color", b);
    }

    public static Drawable getDrawable(String str) {
        return f4428a.getResources().getDrawable(getDrawableId(str));
    }

    public static int getDrawableId(String str) {
        return f4428a.getResources().getIdentifier(str, "drawable", b);
    }

    public static int getIdId(String str) {
        return f4428a.getResources().getIdentifier(str, "id", b);
    }

    public static int getLayoutId(String str) {
        return f4428a.getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, b);
    }

    public static String getString(String str) {
        return f4428a.getResources().getString(getStringId(str));
    }

    public static int getStringId(String str) {
        return f4428a.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, b);
    }

    public static int getStyleId(String str) {
        return f4428a.getResources().getIdentifier(str, "style", b);
    }

    public static Context getmContext() {
        return f4428a;
    }

    public static String getString(String str, Object... objArr) {
        return f4428a.getResources().getString(getStringId(str), objArr);
    }

    public static void setmContext(Context context) {
        f4428a = context;
        b = context.getPackageName();
    }
}
