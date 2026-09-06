package client.android.yixiaotong.ui.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ViewUtils {

    public interface OnDoubleClickListener {
        void OnDoubleClick(View view);

        void OnSingleClick(View view);
    }

    private ViewUtils() {
    }

    public static void clearCompoundDrawable(TextView textView) {
        textView.setCompoundDrawables(null, null, null, null);
    }

    public static void setLeftDrawable(TextView textView, int i) {
        Drawable drawable = textView.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    public static void setRightDrawable(TextView textView, int i) {
        Drawable drawable = textView.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    public static void setTopDrawable(TextView textView, int i) {
        Drawable drawable = textView.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static void setBottomDrawable(TextView textView, int i) {
        Drawable drawable = textView.getResources().getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, null, drawable);
    }

    public static void setLeftDrawable(TextView textView, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    public static void setRightDrawable(TextView textView, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    public static void setTopDrawable(TextView textView, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    public static void setBottomDrawable(TextView textView, Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        textView.setCompoundDrawables(null, null, null, drawable);
    }

    public static void registerDoubleClickListener(View view, final OnDoubleClickListener onDoubleClickListener) {
        if (onDoubleClickListener == null || view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.widget.ViewUtils.1
            private static final int DOUBLE_CLICK_TIME = 333;
            private boolean waitDouble = true;

            @Override // android.view.View.OnClickListener
            public void onClick(final View view2) {
                if (this.waitDouble) {
                    this.waitDouble = false;
                    view2.postDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.widget.ViewUtils.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass1.this.waitDouble) {
                                return;
                            }
                            AnonymousClass1.this.waitDouble = true;
                            onDoubleClickListener.OnSingleClick(view2);
                        }
                    }, 333L);
                } else {
                    this.waitDouble = true;
                    onDoubleClickListener.OnDoubleClick(view2);
                }
            }
        });
    }
}
