package com.yfanads.android.custom.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.stub.StubApp;
import com.yfanads.ads.libs.R;
import com.yfanads.android.lifecycle.DialogManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CustomByDialog {
    private static final String TAG = "CustomByDialog";
    private String activityLocalName;
    private Context context;
    private Dialog dialog;
    private View dialogView;
    private int layoutId;

    /* JADX INFO: renamed from: com.yfanads.android.custom.view.CustomByDialog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CustomByDialogBuilder {
        private final CustomByDialog dialog = new CustomByDialog(null);

        public CustomByDialog build() {
            return this.dialog;
        }

        public CustomByDialogBuilder setLayoutId(int i) {
            this.dialog.layoutId = i;
            return this;
        }
    }

    private CustomByDialog() {
    }

    public /* synthetic */ CustomByDialog(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void createDialog(Activity activity) {
        this.context = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.dialog = new ProxyDialog(activity, R.style.CustomDialogTheme);
        this.dialogView = LayoutInflater.from(this.context).inflate(this.layoutId, (ViewGroup) null);
        Window window = this.dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setFlags(1792, 1792);
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        this.dialog.setContentView(this.dialogView);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setCancelable(false);
        this.activityLocalName = activity.getLocalClassName();
        DialogManager.getInstance().registerDialog(this.activityLocalName, this.dialog);
    }

    public void create(Activity activity) {
        createDialog(activity);
    }

    public void dismiss() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
        DialogManager.getInstance().unregisterDialog(this.activityLocalName, this.dialog);
    }

    public View getDialogView() {
        return this.dialogView;
    }

    public boolean isShowing() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }

    public void show() {
        Dialog dialog = this.dialog;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.dialog.show();
    }
}
