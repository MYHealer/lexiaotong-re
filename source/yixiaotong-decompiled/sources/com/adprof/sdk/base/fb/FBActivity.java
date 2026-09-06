package com.adprof.sdk.base.fb;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.R;
import com.adprof.sdk.a9;
import com.adprof.sdk.hp;
import com.adprof.sdk.md;
import com.adprof.sdk.oh;
import com.adprof.sdk.pk;
import com.adprof.sdk.x8;
import com.adprof.sdk.y8;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FBActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f1073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.adprof.sdk.d f102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f103a = "0";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f104a = false;
    public TextView b;

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            FBActivity.this.f101a.setText(editable.length() + "/200");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements RadioGroup.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            FBActivity fBActivity;
            String str;
            if (FBActivity.this.f1073a.getVisibility() == 0 && i != R.id.fb_rb_other) {
                FBActivity.a(FBActivity.this, false);
            }
            FBActivity.this.b.setTextColor(-1);
            FBActivity fBActivity2 = FBActivity.this;
            fBActivity2.b.setBackground(fBActivity2.getResources().getDrawable(R.drawable.adprof_shape_cta_bt));
            RadioButton radioButton = (RadioButton) FBActivity.this.findViewById(i);
            if (i == R.id.fb_rb_close) {
                fBActivity = FBActivity.this;
                str = "1";
            } else if (i == R.id.fb_rb_show_exception) {
                fBActivity = FBActivity.this;
                str = "2";
            } else if (i == R.id.fb_rb_uninterested) {
                fBActivity = FBActivity.this;
                str = "3";
            } else if (i == R.id.fb_rb_jump) {
                fBActivity = FBActivity.this;
                str = "4";
            } else if (i == R.id.fb_rb_illegal) {
                fBActivity = FBActivity.this;
                str = "5";
            } else if (i == R.id.fb_rb_vulgar) {
                fBActivity = FBActivity.this;
                str = "6";
            } else if (i == R.id.fb_rb_click) {
                fBActivity = FBActivity.this;
                str = "7";
            } else {
                if (i != R.id.fb_rb_sham) {
                    if (i == R.id.fb_rb_copy) {
                        fBActivity = FBActivity.this;
                        str = "9";
                    } else if (i == R.id.fb_rb_other) {
                        FBActivity fBActivity3 = FBActivity.this;
                        fBActivity3.f103a = "10";
                        FBActivity.a(fBActivity3, true);
                    }
                    pk.a("---FeedBackAct onCheckedChanged " + FBActivity.this.f103a + PPSLabelView.Code + radioButton.getText().toString());
                }
                fBActivity = FBActivity.this;
                str = "8";
            }
            fBActivity.f103a = str;
            pk.a("---FeedBackAct onCheckedChanged " + FBActivity.this.f103a + PPSLabelView.Code + radioButton.getText().toString());
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1076a;

        public c(int i) {
            this.f1076a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                FBActivity fBActivity = FBActivity.this;
                if (fBActivity.f104a) {
                    fBActivity.finish();
                    return;
                }
                if ("0".equals(fBActivity.f103a)) {
                    Toast.makeText(FBActivity.this, "请先选择反馈原因", 0).show();
                    return;
                }
                FBActivity.this.f104a = true;
                FBActivity fBActivity2 = FBActivity.this;
                com.adprof.sdk.d dVar = fBActivity2.f102a;
                dVar.i = fBActivity2.f103a;
                dVar.j = fBActivity2.f1073a.getText().toString();
                com.adprof.sdk.d dVar2 = FBActivity.this.f102a;
                oh.a("feed_back", "", dVar2, dVar2.f190a, null);
                int i = this.f1076a;
                if (i != 0) {
                    a9 a9Var = a9.f14a;
                    y8 y8Var = (y8) a9.f1028a.get(i);
                    if (y8Var != null) {
                        pk.d(" onFeedbackSubmitted ");
                        hp.m656a((View) FBView.this);
                        a9.f1028a.remove(this.f1076a);
                    }
                }
                Toast.makeText(AdprofSdk.getInstance().getContext(), "感谢您的反馈~", 0).show();
                FBActivity.this.finish();
            } catch (Exception e) {
                pk.a(e);
                oh.b(e);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FBActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(11403);
    }

    public static void a(FBActivity fBActivity, boolean z) {
        fBActivity.f1073a.setPivotY(z ? 0.0f : 1.0f);
        fBActivity.f1073a.setScaleY(z ? 0.0f : 1.0f);
        fBActivity.f1073a.setVisibility(0);
        fBActivity.f101a.setVisibility(z ? 0 : 8);
        fBActivity.f1073a.animate().scaleY(z ? 1.0f : 0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new x8(fBActivity, z)).start();
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            if (Build.VERSION.SDK_INT == 26 && md.m682a((Activity) this)) {
                return;
            }
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            pk.b("setRequestedOrientation error: ", th);
        }
    }
}
