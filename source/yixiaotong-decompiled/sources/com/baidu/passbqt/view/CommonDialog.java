package com.baidu.passbqt.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.passbqt.NoProguard;
import com.baidu.passbqt.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class CommonDialog extends Dialog implements NoProguard {
    public CommonDialog(Context context, int i) {
        super(context, i);
    }

    public static class Builder implements NoProguard {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f1949a;
        private CharSequence b;
        private String c;
        private boolean d;
        private boolean e = false;
        private int f = 100;
        private String g;
        private View.OnClickListener h;
        private String i;
        private View.OnClickListener j;
        private int k;

        public Builder a(int i) {
            this.k = i;
            return this;
        }

        public Builder a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public Builder a(String str) {
            this.c = str;
            return this;
        }

        public Builder a(String str, View.OnClickListener onClickListener) {
            this.g = str;
            this.h = onClickListener;
            return this;
        }

        public Builder a(boolean z) {
            this.e = z;
            return this;
        }

        public Builder b(int i) {
            this.f = i;
            return this;
        }

        public Builder b(String str, View.OnClickListener onClickListener) {
            this.i = str;
            this.j = onClickListener;
            return this;
        }

        public Builder b(boolean z) {
            this.d = z;
            return this;
        }

        public Builder(Context context) {
            this.f1949a = context;
        }

        public CommonDialog a() {
            View viewInflate = LayoutInflater.from(this.f1949a).inflate(R.layout.pass_sdk_base_ui_common_dialog, (ViewGroup) null);
            final CommonDialog commonDialog = new CommonDialog(this.f1949a, R.style.pass_base_ui_common_dialog_style);
            TextView textView = (TextView) viewInflate.findViewById(R.id.pass_base_ui_dialog_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.pass_base_ui_dialog_content);
            View viewFindViewById = viewInflate.findViewById(R.id.pass_base_ui_dialog_horizontal_split_line);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.negative_btn);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.positive_btn);
            View viewFindViewById2 = viewInflate.findViewById(R.id.pass_base_ui_dialog_vertical_split_line);
            textView.setText(this.c);
            textView2.setText(TextUtils.isEmpty(this.b) ? "" : this.b);
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
            int i = this.k;
            if (i > 0) {
                textView2.setGravity(i);
            }
            textView3.setText(this.i);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.passbqt.view.CommonDialog.Builder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.j.onClick(view);
                    commonDialog.dismiss();
                }
            });
            textView4.setText(this.g);
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.passbqt.view.CommonDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Builder.this.h.onClick(view);
                    commonDialog.dismiss();
                }
            });
            commonDialog.setContentView(viewInflate);
            commonDialog.setCancelable(this.e);
            commonDialog.setCanceledOnTouchOutside(this.e);
            int i2 = this.f;
            if (i2 != 100) {
                CommonDialog.b(textView, i2);
                CommonDialog.b(textView2, this.f);
                CommonDialog.b(textView3, this.f);
                CommonDialog.b(textView4, this.f);
            }
            Window window = commonDialog.getWindow();
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 30;
            attributes.y = 30;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (this.d) {
                viewInflate.findViewById(R.id.pass_base_ui_dialog_root_view).setBackgroundResource(R.drawable.pass_base_ui_common_dialog_dark_bg);
                textView.setTextColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_title_dark_text_color));
                textView2.setTextColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_content_text_dark_color));
                viewFindViewById.setBackgroundColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
                textView3.setTextColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_negative_btn_text_dark_color));
                textView4.setTextColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_positive_btn_text_dark_color));
                viewFindViewById2.setBackgroundColor(this.f1949a.getResources().getColor(R.color.pass_base_ui_dialog_split_line_dark_color));
            }
            Context context = this.f1949a;
            if (context instanceof Activity) {
                Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
                WindowManager.LayoutParams attributes2 = commonDialog.getWindow().getAttributes();
                attributes.width = defaultDisplay.getWidth();
                attributes.height = -2;
                commonDialog.getWindow().setAttributes(attributes2);
            }
            return commonDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(TextView textView, int i) {
        if (textView != null) {
            textView.setTextSize(0, (textView.getTextSize() * i) / 100.0f);
        }
    }
}
