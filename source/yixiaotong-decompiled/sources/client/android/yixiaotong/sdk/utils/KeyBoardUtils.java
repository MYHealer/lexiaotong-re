package client.android.yixiaotong.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class KeyBoardUtils {

    public interface OnKeyBoardListener {
        void onKeyBoardHide();

        void onKeyBoardShow(int i);
    }

    private KeyBoardUtils() {
    }

    public static void showSoftInput(Context context, View view) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setSoftInputMode(2);
        }
        view.setFocusableInTouchMode(true);
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
        if (view instanceof EditText) {
            Editable text = ((EditText) view).getText();
            Selection.setSelection(text, text.length());
        }
    }

    public static void hideSoftInput(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            activity.getWindow().setSoftInputMode(3);
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void hideSoftInput(Context context, View view) {
        if (context instanceof Activity) {
            ((Activity) context).getWindow().setSoftInputMode(3);
        }
        view.requestFocus();
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void listenKeyBoard(View view, OnKeyBoardListener onKeyBoardListener) {
        CustomOnGlobalLayoutListener customOnGlobalLayoutListener = new CustomOnGlobalLayoutListener(view, onKeyBoardListener);
        view.getViewTreeObserver().addOnGlobalLayoutListener(customOnGlobalLayoutListener);
        view.setTag(customOnGlobalLayoutListener);
    }

    public static void clearKeyBoardListener(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof CustomOnGlobalLayoutListener)) {
            return;
        }
        view.getViewTreeObserver().removeGlobalOnLayoutListener((CustomOnGlobalLayoutListener) view.getTag());
    }

    public static class CustomOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private View mFocusView;
        private OnKeyBoardListener mOnKeyBoardListener;
        private int mSoftKeyBoardHeight = 0;
        private int mLastVisibleHeight = 0;
        private int mLastSoftKeyBoardHeight = 0;

        public CustomOnGlobalLayoutListener(View view, OnKeyBoardListener onKeyBoardListener) {
            this.mFocusView = view;
            this.mOnKeyBoardListener = onKeyBoardListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            OnKeyBoardListener onKeyBoardListener;
            Rect rect = new Rect();
            this.mFocusView.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            int i = this.mLastVisibleHeight;
            if (i == 0) {
                this.mLastVisibleHeight = iHeight;
                return;
            }
            if (i == iHeight) {
                return;
            }
            this.mLastSoftKeyBoardHeight = this.mSoftKeyBoardHeight;
            int i2 = i - iHeight;
            this.mSoftKeyBoardHeight = i2;
            this.mLastVisibleHeight = iHeight;
            if (i2 > 0 && i2 > ScreenUtils.getScreenHeight(this.mFocusView.getContext()) / 4) {
                OnKeyBoardListener onKeyBoardListener2 = this.mOnKeyBoardListener;
                if (onKeyBoardListener2 != null) {
                    onKeyBoardListener2.onKeyBoardShow(this.mSoftKeyBoardHeight);
                    return;
                }
                return;
            }
            int i3 = this.mSoftKeyBoardHeight;
            if (i3 >= 0 || Math.abs(i3) <= ScreenUtils.getScreenHeight(this.mFocusView.getContext()) / 4 || (onKeyBoardListener = this.mOnKeyBoardListener) == null) {
                return;
            }
            onKeyBoardListener.onKeyBoardHide();
        }
    }
}
