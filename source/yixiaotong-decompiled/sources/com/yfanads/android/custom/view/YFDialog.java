package com.yfanads.android.custom.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFDialog extends Dialog {
    private int closeId;
    private Context context;
    private int layoutId;
    protected SoftReference<DialogBindData> mDialogBindData;
    protected SoftReference<DialogDismiss> mDialogDismiss;
    private int mGravity;
    private int mHeight;
    private int mWidth;

    public static class Builder {
        private YFDialog dialog;

        public Builder(Context context) {
            this.dialog = new YFDialog(context);
        }

        public YFDialog build() {
            return this.dialog;
        }

        public Builder setCloseId(int i) {
            this.dialog.closeId = i;
            return this;
        }

        public Builder setGravity(int i) {
            this.dialog.mGravity = i;
            return this;
        }

        public Builder setLayoutId(int i) {
            this.dialog.layoutId = i;
            return this;
        }

        public Builder setSize(int i, int i2) {
            this.dialog.mWidth = i;
            this.dialog.mHeight = i2;
            return this;
        }
    }

    public interface DialogBindData {
        void bindViewData(View view);
    }

    public interface DialogDismiss {
        void onDismiss();
    }

    public YFDialog(Context context) {
        super(context);
        this.mWidth = -2;
        this.mHeight = -2;
        this.mGravity = 17;
        this.context = context;
    }

    public YFDialog(Context context, int i) {
        super(context, i);
        this.mWidth = -2;
        this.mHeight = -2;
        this.mGravity = 17;
        this.context = context;
    }

    public YFDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mWidth = -2;
        this.mHeight = -2;
        this.mGravity = 17;
        this.context = context;
    }

    public YFDialog bindData(DialogBindData dialogBindData) {
        this.mDialogBindData = new SoftReference<>(dialogBindData);
        return this;
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-yfanads-android-custom-view-YFDialog, reason: not valid java name */
    /* synthetic */ void m1257lambda$onCreate$0$comyfanadsandroidcustomviewYFDialog(DialogInterface dialogInterface) {
        SoftReference<DialogDismiss> softReference = this.mDialogDismiss;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        this.mDialogDismiss.get().onDismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(this.context).inflate(this.layoutId, (ViewGroup) null, false);
        setContentView(viewInflate);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mHeight;
            layoutParams.gravity = this.mGravity;
            window.setAttributes(layoutParams);
        }
        SoftReference<DialogBindData> softReference = this.mDialogBindData;
        if (softReference != null && softReference.get() != null) {
            this.mDialogBindData.get().bindViewData(viewInflate);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yfanads.android.custom.view.YFDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.m1257lambda$onCreate$0$comyfanadsandroidcustomviewYFDialog(dialogInterface);
            }
        });
    }

    public YFDialog setDismiss(DialogDismiss dialogDismiss) {
        this.mDialogDismiss = new SoftReference<>(dialogDismiss);
        return this;
    }
}
