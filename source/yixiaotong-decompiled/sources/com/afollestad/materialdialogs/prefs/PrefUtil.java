package com.afollestad.materialdialogs.prefs;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import com.afollestad.materialdialogs.commons.R;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class PrefUtil {
    private PrefUtil() {
    }

    public static void setLayoutResource(Context context, Preference preference, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = false;
        if (attributeSet == null) {
            z = false;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= attributeSet.getAttributeCount()) {
                z = false;
                break;
            } else {
                if (((XmlResourceParser) attributeSet).getAttributeNamespace(0).equals("http://schemas.android.com/apk/res/android") && attributeSet.getAttributeName(i).equals(TtmlNode.TAG_LAYOUT)) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.Preference, 0, 0);
            try {
                z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Preference_useStockLayout, false);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        if (z || z2) {
            return;
        }
        preference.setLayoutResource(R.layout.md_preference_custom);
    }

    public static void registerOnActivityDestroyListener(Preference preference, PreferenceManager.OnActivityDestroyListener onActivityDestroyListener) {
        try {
            PreferenceManager preferenceManager = preference.getPreferenceManager();
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod("registerOnActivityDestroyListener", PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, onActivityDestroyListener);
        } catch (Exception unused) {
        }
    }

    public static void unregisterOnActivityDestroyListener(Preference preference, PreferenceManager.OnActivityDestroyListener onActivityDestroyListener) {
        try {
            PreferenceManager preferenceManager = preference.getPreferenceManager();
            Method declaredMethod = preferenceManager.getClass().getDeclaredMethod("unregisterOnActivityDestroyListener", PreferenceManager.OnActivityDestroyListener.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(preferenceManager, onActivityDestroyListener);
        } catch (Exception unused) {
        }
    }
}
