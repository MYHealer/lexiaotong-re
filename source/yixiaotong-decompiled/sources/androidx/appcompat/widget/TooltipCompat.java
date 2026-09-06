package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class TooltipCompat {
    public static void setTooltipText(View view, CharSequence charSequence) {
        Api26Impl.setTooltipText(view, charSequence);
    }

    private TooltipCompat() {
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }
}
