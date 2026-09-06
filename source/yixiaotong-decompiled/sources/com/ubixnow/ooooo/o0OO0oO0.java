package com.ubixnow.ooooo;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubixnow.core.R;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OO0oO0 extends RelativeLayout {
    private o0OO0o OooO00o;
    private HashMap<String, String> OooO0O0;
    private RadioGroup OooO0OO;
    private RadioGroup OooO0Oo;
    private RadioButton OooO0o;
    private EditText OooO0o0;
    private TextView OooO0oO;
    private int OooO0oo;

    public class OooO00o implements View.OnClickListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o0OO0oO0.this.OooO00o != null) {
                o0OO0oO0.this.OooO00o.OooO00o();
            }
        }
    }

    public class OooO0O0 implements TextWatcher {
        public OooO0O0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            o0OO0oO0.this.OooO00o(false);
            o0OO0oO0.this.OooO0oO.setText(editable.toString().trim().length() + "/200");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class OooO0OO implements View.OnClickListener {
        public OooO0OO() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o0OO0oO0.this.OooO0o.isChecked()) {
                if (o0OO0oO0.this.OooO0oo == 0) {
                    o0OO0oO0.this.OooO0oo = o0OO0.OooO;
                }
                o0OO0oO0.this.OooO0O0();
                if (o0OO0oO0.this.OooO00o != null) {
                    o0OO0oO0.this.OooO00o.OooO00o();
                }
            }
        }
    }

    public class OooO0o implements View.OnClickListener {
        public final /* synthetic */ RadioGroup OooO00o;
        public final /* synthetic */ int OooO0O0;

        public OooO0o(RadioGroup radioGroup, int i) {
            this.OooO00o = radioGroup;
            this.OooO0O0 = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RadioGroup radioGroup;
            if (this.OooO00o.getId() == R.id.report_quality_rg) {
                o0OO0oO0.this.OooO0OO.clearCheck();
                radioGroup = o0OO0oO0.this.OooO0OO;
            } else {
                o0OO0oO0.this.OooO0Oo.clearCheck();
                radioGroup = o0OO0oO0.this.OooO0Oo;
            }
            radioGroup.setTag(null);
            o0OO0oO0.this.OooO00o(0);
            Integer num = (Integer) this.OooO00o.getTag();
            if (num == null) {
                this.OooO00o.clearCheck();
            } else if (num.intValue() == this.OooO0O0) {
                this.OooO00o.clearCheck();
                this.OooO00o.setTag(null);
                o0OO0oO0.this.OooO00o(false);
                o0OO0oO0.this.OooO00o(0);
                return;
            }
            this.OooO00o.check(view.getId());
            this.OooO00o.setTag(Integer.valueOf(this.OooO0O0));
            o0OO0oO0.this.OooO00o(true);
            o0OO0oO0.this.OooO00o(view.getId());
        }
    }

    public o0OO0oO0(Context context) {
        this(context, null);
    }

    public o0OO0oO0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o0OO0oO0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        OooO00o();
    }

    private void OooO00o() {
        LayoutInflater.from(getContext()).inflate(R.layout.ubixnow_feedback_layout, this);
        findViewById(R.id.iv_finish).setOnClickListener(new OooO00o());
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.report_quality_rg);
        this.OooO0Oo = radioGroup;
        OooO00o(radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.report_rg);
        this.OooO0OO = radioGroup2;
        OooO00o(radioGroup2);
        this.OooO0o0 = (EditText) findViewById(R.id.report_edt);
        this.OooO0oO = (TextView) findViewById(R.id.inputNum);
        this.OooO0o0.addTextChangedListener(new OooO0O0());
        RadioButton radioButton = (RadioButton) findViewById(R.id.feedback_submit);
        this.OooO0o = radioButton;
        radioButton.setOnClickListener(new OooO0OO());
        this.OooO0o.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x0042  */
    public void OooO00o(int i) {
        int i2;
        if (i == 0) {
            i2 = 0;
        } else if (i == R.id.show_error) {
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
        } else if (i == R.id.not_for_children) {
            i2 = o0OO0.OooOO0;
        } else {
            i2 = 0;
        }
        this.OooO0oo = i2;
    }

    private void OooO00o(RadioGroup radioGroup) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setOnClickListener(new OooO0o(radioGroup, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO00o(boolean z) {
        boolean z2 = !TextUtils.isEmpty(this.OooO0o0.getText().toString().trim()) || z;
        this.OooO0o.setChecked(z2);
        this.OooO0o.setEnabled(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OooO0O0() {
        HashMap<String, String> map = this.OooO0O0;
        if (map != null) {
            try {
                String str = map.get(o0OO000o.o000o00);
                String str2 = this.OooO0O0.get(o0OO000o.o00O000);
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    jSONObject.put("mubix_dislike_type", this.OooO0oo + "");
                    if (!TextUtils.isEmpty(this.OooO0o0.getText().toString().trim())) {
                        jSONObject.put("mubix_dislike_msg", this.OooO0o0.getText().toString().trim() + "");
                    }
                    this.OooO0O0.put(o0OO000o.o00O000, jSONObject.toString());
                }
                o0OO000.OooO00o(o0OO000o.o000OOo0, this.OooO0O0, new Object[0]);
                ooooO0O0.OooOoO().flush();
                o0OO.OooO00o("感谢您的反馈，我们会尽快处理您的意见，提高您的使用体验。");
                o0OO0O0.OooO00o.add(str);
                OooO00o(this.OooO0o0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void OooO00o(EditText editText) {
        Context context = getContext();
        getContext();
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
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
