package com.meishu.sdk.core.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.meishu.sdk.R;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MSDialog extends Dialog {
    private boolean canceledOnTouchOutside;
    private String iconUrl;
    private View.OnClickListener negativeListener;
    private String negativeText;
    private View.OnClickListener positiveListener;
    private String positiveText;
    private boolean showCloseBtn;
    private String title;

    public static class Builder {
        private boolean canceledOnTouchOutside;
        private Context context;
        private String iconUrl;
        private View.OnClickListener negativeListener;
        private String negativeText;
        private View.OnClickListener positiveListener;
        private String positiveText;
        private boolean showCloseBtn;
        private String title;

        public Builder(Context context) {
            this.context = context;
        }

        public MSDialog build() {
            MSDialog mSDialog = new MSDialog(this.context);
            mSDialog.title = this.title;
            mSDialog.iconUrl = this.iconUrl;
            mSDialog.showCloseBtn = this.showCloseBtn;
            mSDialog.canceledOnTouchOutside = this.canceledOnTouchOutside;
            mSDialog.positiveText = this.positiveText;
            mSDialog.negativeText = this.negativeText;
            mSDialog.negativeListener = this.negativeListener;
            mSDialog.positiveListener = this.positiveListener;
            return mSDialog;
        }

        public Builder setCanceledOnTouchOutside(boolean z) {
            this.canceledOnTouchOutside = z;
            return this;
        }

        public Builder setIconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            this.negativeText = str;
            this.negativeListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str, View.OnClickListener onClickListener) {
            this.positiveText = str;
            this.positiveListener = onClickListener;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.showCloseBtn = z;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public MSDialog(Context context) {
        super(context);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        setContentView(R.layout.ms_dialog);
        i iVar = new i(findViewById(R.id.ms_dialog_root));
        if (!TextUtils.isEmpty(this.iconUrl)) {
            iVar.b(R.id.ms_dialog_icon).a(this.iconUrl, false);
        }
        iVar.b(R.id.ms_dialog_title).a(this.title);
        iVar.b(R.id.ms_dialog_close).d(this.showCloseBtn ? 0 : 8);
        if (!TextUtils.isEmpty(this.negativeText)) {
            iVar.b(R.id.ms_dialog_negative).a(this.negativeText);
        }
        i iVarB = iVar.b(R.id.ms_dialog_negative);
        o oVar = new o() { // from class: com.meishu.sdk.core.view.MSDialog.1
            @Override // com.meishu.sdk.core.safe.o
            public void safeOnClick(View view) {
                super.safeOnClick(view);
                MSDialog.this.dismiss();
                if (MSDialog.this.negativeListener != null) {
                    MSDialog.this.negativeListener.onClick(view);
                }
            }
        };
        View view = iVarB.d;
        if (view != null) {
            view.setOnClickListener(oVar);
        }
        if (!TextUtils.isEmpty(this.positiveText)) {
            iVar.b(R.id.ms_dialog_positive).a(this.positiveText);
        }
        o oVar2 = new o() { // from class: com.meishu.sdk.core.view.MSDialog.2
            @Override // com.meishu.sdk.core.safe.o
            public void safeOnClick(View view2) {
                super.safeOnClick(view2);
                MSDialog.this.dismiss();
                if (MSDialog.this.positiveListener != null) {
                    MSDialog.this.positiveListener.onClick(view2);
                }
            }
        };
        View view2 = iVar.b(R.id.ms_dialog_positive).d;
        if (view2 != null) {
            view2.setOnClickListener(oVar2);
        }
        View view3 = iVar.b(R.id.ms_dialog_close).d;
        if (view3 != null) {
            view3.setOnClickListener(oVar2);
        }
        setCanceledOnTouchOutside(this.canceledOnTouchOutside);
        setCancelable(this.canceledOnTouchOutside);
    }
}
