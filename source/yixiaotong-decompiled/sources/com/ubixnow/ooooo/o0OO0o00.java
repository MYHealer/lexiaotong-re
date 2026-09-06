package com.ubixnow.ooooo;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.ubixnow.core.R;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO0o00 extends RelativeLayout {
    private o0OO0o OooO00o;
    private HashMap<String, String> OooO0O0;
    private RadioGroup OooO0OO;
    private RadioGroup OooO0Oo;
    private Context OooO0o;
    private int OooO0o0;

    public class OooO00o implements View.OnClickListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                o0OO0o00.this.OooO00o.OooO00o();
                oo0ooO oo0oooOooO00o = new oo0ooO.OooO0O0(o0OO0o00.this.OooO0o).OooO00o(2, o0OO0o00.this.OooO0O0);
                Window window = oo0oooOooO00o.getWindow();
                window.setGravity(16);
                window.setLayout(-1, -2);
                window.setGravity(80);
                oo0oooOooO00o.show();
            } catch (Throwable unused) {
            }
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public final /* synthetic */ RadioGroup OooO00o;

        public OooO0O0(RadioGroup radioGroup) {
            this.OooO00o = radioGroup;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RadioGroup radioGroup;
            o0OO0o00.this.OooO0O0(view.getId());
            if (this.OooO00o.getId() == R.id.report_quality_rg) {
                o0OO0o00.this.OooO0OO.clearCheck();
                radioGroup = o0OO0o00.this.OooO0OO;
            } else {
                o0OO0o00.this.OooO0Oo.clearCheck();
                radioGroup = o0OO0o00.this.OooO0Oo;
            }
            radioGroup.setTag(null);
            o0OO0o00.this.OooO00o.OooO00o();
        }
    }

    public class OooO0OO implements View.OnClickListener {
        public OooO0OO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0OO0o00.this.OooO0O0(view.getId());
            o0OO0o00.this.OooO00o.OooO00o();
        }
    }

    public o0OO0o00(Context context) {
        this(context, null);
        this.OooO0o = context;
    }

    public o0OO0o00(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.OooO0o = context;
    }

    public o0OO0o00(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OooO0o0 = 0;
        this.OooO0o = context;
        OooO00o();
    }

    private void OooO00o() {
        LayoutInflater.from(getContext()).inflate(R.layout.ubixnow_feedback_dialog_layout, this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.report_quality_rg);
        this.OooO0Oo = radioGroup;
        OooO00o(radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.report_rg);
        this.OooO0OO = radioGroup2;
        OooO00o(radioGroup2);
        findViewById(R.id.report_edt).setOnClickListener(new OooO00o());
    }

    private void OooO00o(int i) {
        int i2;
        if (i == R.id.show_error) {
            i2 = o0OO0.OooO00o;
        } else if (i == R.id.not_close) {
            i2 = o0OO0.OooO0O0;
        } else if (i == R.id.no_interest) {
            i2 = o0OO0.OooO0OO;
        } else if (i == R.id.click_exception) {
            i2 = o0OO0.OooO0Oo;
        } else if (i == R.id.attractive_rb) {
            i2 = o0OO0.OooO0o0;
        } else if (i == R.id.vulgar_rb) {
            i2 = o0OO0.OooO0o;
        } else if (i == R.id.illegality_rb) {
            i2 = o0OO0.OooO0oO;
        } else if (i == R.id.copy_rb) {
            i2 = o0OO0.OooO0oo;
        } else if (i != R.id.not_for_children) {
            return;
        } else {
            i2 = o0OO0.OooOO0;
        }
        this.OooO0o0 = i2;
    }

    private void OooO00o(RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setOnClickListener(new OooO0O0(radioGroup));
        }
        findViewById(R.id.copy_rb).setOnClickListener(new OooO0OO());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0(int i) {
        try {
            OooO00o(i);
            String str = this.OooO0O0.get(o0OO000o.o000o00);
            String str2 = this.OooO0O0.get(o0OO000o.o00O000);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("mubix_dislike_type", this.OooO0o0 + "");
                this.OooO0O0.put(o0OO000o.o00O000, jSONObject.toString());
            }
            o0OO000.OooO00o(o0OO000o.o000OOo0, this.OooO0O0, new Object[0]);
            ooooO0O0.OooOoO().flush();
            o0OO.OooO00o("感谢您的反馈，我们会尽快处理您的意见，提高您的使用体验。");
            o0OO0O0.OooO00o.add(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void setDislikeCallback(o0OO0o o0oo0o) {
        this.OooO00o = o0oo0o;
    }

    public void setTrackingInfo(HashMap<String, String> map) {
        this.OooO0O0 = map;
    }
}
