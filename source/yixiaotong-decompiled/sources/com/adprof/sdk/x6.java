package com.adprof.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x6 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fk f829a;
    public TextView b;
    public TextView c;
    public TextView d;

    public x6(Context context, int i) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar);
        this.f1516a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        pk.a("SkipInterceptDialog", "Continue watching clicked");
        fk fkVar = this.f829a;
        if (fkVar != null) {
            fkVar.getClass();
            pk.a("RewardView_one", "User chose to continue watching");
            jk jkVar = fkVar.f1175a;
            z5 z5Var = ((yj) jkVar).f866a;
            if (z5Var != null) {
                z5Var.d();
            }
            l8 l8Var = ((yj) jkVar).f864a;
            if (l8Var != null) {
                l8Var.e();
            }
            yg ygVar = jkVar.f399a;
            if (ygVar != null) {
                ygVar.d();
            }
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        pk.a("SkipInterceptDialog", "Exit confirmed clicked");
        fk fkVar = this.f829a;
        if (fkVar != null) {
            fkVar.getClass();
            pk.a("RewardView_one", "User confirmed exit");
            s5.a(((x0) fkVar.f1175a).f821a.k(), "action.reward.video.skip");
            fkVar.f1175a.a();
        }
        dismiss();
    }

    public final void a() {
        this.f828a = (TextView) findViewById(R.id.dialog_title);
        this.b = (TextView) findViewById(R.id.dialog_continue_btn);
        this.c = (TextView) findViewById(R.id.dialog_exit_btn);
        this.d = (TextView) findViewById(R.id.dialog_description);
    }

    public final void b() {
        TextView textView = this.b;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.x6$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.adprof.sdk.x6$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
        }
    }

    public final void c() {
        if (this.f828a != null) {
            String str = "再看" + this.f1516a + "秒，即可获得奖励";
            SpannableString spannableString = new SpannableString(str);
            String strValueOf = String.valueOf(this.f1516a);
            int iIndexOf = str.indexOf(strValueOf);
            if (iIndexOf != -1) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6B35")), iIndexOf, strValueOf.length() + iIndexOf, 33);
            }
            int iIndexOf2 = str.indexOf("奖励");
            if (iIndexOf2 != -1) {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF6B35")), iIndexOf2, iIndexOf2 + 2, 33);
            }
            this.f828a.setText(spannableString);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText("请耐心观看完整视频，即可获得丰厚奖励！");
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (isShowing()) {
                Context context = getContext();
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (activity.isFinishing() || activity.isDestroyed()) {
                        pk.a("SkipInterceptDialog", "Activity is finishing or destroyed, skip dismiss");
                        return;
                    }
                }
                Window window = getWindow();
                if (window == null || window.getDecorView().isAttachedToWindow()) {
                    super.dismiss();
                } else {
                    pk.a("SkipInterceptDialog", "Dialog view not attached to window, skip dismiss");
                }
            }
        } catch (Throwable th) {
            pk.c("SkipInterceptDialog", th);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Context context = getContext();
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                str = (activity.isFinishing() || activity.isDestroyed()) ? "Activity is finishing or destroyed in onCreate" : "Context is null in onCreate";
            }
            requestWindowFeature(1);
            try {
                setContentView(R.layout.adprof_dialog_skip_intercept);
                a();
                b();
                c();
                setCancelable(false);
                setCanceledOnTouchOutside(false);
                return;
            } catch (Exception e) {
                pk.b("SkipInterceptDialog", "Error in onCreate: " + e.getMessage());
                return;
            }
        }
        pk.b("SkipInterceptDialog", str);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        pk.a("SkipInterceptDialog", "Back key pressed, but disabled");
        return true;
    }
}
