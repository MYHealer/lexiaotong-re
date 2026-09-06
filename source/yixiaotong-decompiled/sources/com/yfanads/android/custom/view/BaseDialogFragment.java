package com.yfanads.android.custom.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.yfanads.ads.libs.R;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseDialogFragment extends DialogFragment {
    protected static final String ANIMATION = "mAnimation";
    protected static final String GRAVITY = "mGravity";
    protected static final String HEIGHT = "mHeight";
    protected static final String OFFSET_X = "mOffsetX";
    protected static final String OFFSET_Y = "mOffsetY";
    protected static final String WIDTH = "mWidth";
    protected DialogBindData mDialogBindData;
    protected DialogDismissListener mDialogDismissListener;
    protected DialogResultListener mDialogResultListener;
    protected int mWidth = -2;
    protected int mHeight = -2;
    protected int mGravity = 17;
    protected int mOffsetX = 0;
    protected int mOffsetY = 0;
    protected int mAnimation = R.style.DialogBaseAnimation;

    public static abstract class Builder<T extends Builder, D extends BaseDialogFragment> {
        private int mWidth = -2;
        private int mHeight = -2;
        private int mGravity = 17;
        private int mOffsetX = 0;
        private int mOffsetY = 0;
        private int mAnimation = R.style.DialogBaseAnimation;

        public abstract D build();

        public void clear() {
            this.mWidth = -2;
            this.mHeight = -2;
            this.mGravity = 17;
            this.mOffsetX = 0;
            this.mOffsetY = 0;
        }

        public T setAnimation(int i) {
            this.mAnimation = i;
            return this;
        }

        public T setGravity(int i) {
            this.mGravity = i;
            return this;
        }

        public T setOffsetX(int i) {
            this.mOffsetX = i;
            return this;
        }

        public T setOffsetY(int i) {
            this.mOffsetY = i;
            return this;
        }

        public T setSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
            return this;
        }
    }

    public interface DialogBindData {
        void bindViewData(View view);
    }

    public interface DialogDismissListener {
        void dismiss(DialogFragment dialogFragment);
    }

    public interface DialogResultListener<T> {
        void result(T t);
    }

    private void checkReStoreDialog() {
        if (this.mDialogBindData == null) {
            Log.i(Util.TAG, "checkReStoreDialog dismissAllowingStateLoss");
            try {
                dismissAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bundle getArgumentBundle(Builder builder) {
        Bundle bundle = new Bundle();
        bundle.putInt(WIDTH, builder.mWidth);
        bundle.putInt(HEIGHT, builder.mHeight);
        bundle.putInt(GRAVITY, builder.mGravity);
        bundle.putInt(OFFSET_X, builder.mOffsetX);
        bundle.putInt(OFFSET_Y, builder.mOffsetY);
        bundle.putInt(ANIMATION, builder.mAnimation);
        return bundle;
    }

    public void adjustWindow(int i, int i2) {
        adjustWindow(i, i2, false, false);
    }

    public void adjustWindow(int i, int i2, boolean z, boolean z2) {
        try {
            Dialog dialog = getDialog();
            if (dialog == null) {
                Log.e(Util.TAG, "getDialog is null");
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = i;
                attributes.height = i2;
                if (z) {
                    attributes.x = ScreenUtil.dip2px(dialog.getContext(), this.mOffsetX);
                    attributes.y = ScreenUtil.dip2px(dialog.getContext(), this.mOffsetY);
                }
                if (z2) {
                    attributes.gravity = this.mGravity;
                }
                window.setAttributes(attributes);
                window.getDecorView().setBackgroundColor(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mWidth = getArguments().getInt(WIDTH);
            this.mHeight = getArguments().getInt(HEIGHT);
            this.mOffsetX = getArguments().getInt(OFFSET_X);
            this.mOffsetY = getArguments().getInt(OFFSET_Y);
            this.mAnimation = getArguments().getInt(ANIMATION);
            this.mGravity = getArguments().getInt(GRAVITY);
        }
        setStyle(1, R.style.base_yf_dialog);
        checkReStoreDialog();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return setView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogDismissListener dialogDismissListener = this.mDialogDismissListener;
        if (dialogDismissListener != null) {
            dialogDismissListener.dismiss(this);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        adjustWindow(this.mWidth, this.mHeight, true, true);
    }

    public BaseDialogFragment setDialogDismissListener(DialogDismissListener dialogDismissListener) {
        this.mDialogDismissListener = dialogDismissListener;
        return this;
    }

    public BaseDialogFragment setDialogResultListener(DialogResultListener dialogResultListener) {
        this.mDialogResultListener = dialogResultListener;
        return this;
    }

    public abstract View setView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);
}
