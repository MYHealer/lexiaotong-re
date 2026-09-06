package com.ubixnow.ooooo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ubixnow.core.R;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0OOooO0 extends RelativeLayout {
    private HashMap<String, String> OooO00o;
    private View.OnClickListener OooO0O0;
    private EditText OooO0OO;
    private TextView OooO0Oo;
    private TextView OooO0o0;

    public class OooO00o implements View.OnClickListener {
        public OooO00o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ooooO000.OooO0O0("------feedback", "dialog_close");
            if (o0OOooO0.this.OooO0O0 != null) {
                o0OOooO0.this.OooO0O0.onClick(view);
            }
        }
    }

    public class OooO0O0 implements View.OnClickListener {
        public OooO0O0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (TextUtils.isEmpty(o0OOooO0.this.OooO0OO.getText().toString().trim())) {
                    return;
                }
                String str = (String) o0OOooO0.this.OooO00o.get(o0OO000o.o000o00);
                if (o0OO0O0.OooO00o.contains(str)) {
                    o0OO.OooO00o("您已成功提交反馈，请勿重复提交哦！");
                    Toast.makeText(BaseUtils.getContext(), "您已成功提交反馈，请勿重复提交哦！", 0).show();
                } else {
                    String str2 = (String) o0OOooO0.this.OooO00o.get(o0OO000o.o00O000);
                    if (!TextUtils.isEmpty(str2)) {
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put("mubix_dislike_type", "9");
                        jSONObject.put("mubix_dislike_msg", o0OOooO0.this.OooO0OO.getText().toString());
                        o0OOooO0.this.OooO00o.put(o0OO000o.o00O000, jSONObject.toString());
                    }
                    o0OO000.OooO00o(o0OO000o.o000OOo0, o0OOooO0.this.OooO00o, new Object[0]);
                    ooooO0O0.OooOoO().flush();
                    o0OO.OooO00o("感谢您的反馈，我们会尽快处理您的意见，提高您的使用体验。");
                    o0OO0O0.OooO00o.add(str);
                }
                o0OOooO0.this.OooO0O0.onClick(view);
                o0OOooO0 o0ooooo0 = o0OOooO0.this;
                o0ooooo0.OooO00o(o0ooooo0.OooO0OO);
            } catch (Throwable unused) {
            }
        }
    }

    public class OooO0OO implements TextWatcher {
        public OooO0OO() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView textView;
            int i;
            int length = editable.toString().trim().length();
            o0OOooO0.this.OooO0Oo.setText(length + "/200");
            if (length == 0) {
                textView = o0OOooO0.this.OooO0o0;
                i = 855638016;
            } else {
                textView = o0OOooO0.this.OooO0o0;
                i = -654311424;
            }
            textView.setTextColor(i);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class OooO0o implements Runnable {
        public OooO0o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) o0OOooO0.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    public o0OOooO0(Context context) {
        this(context, null);
    }

    public o0OOooO0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public o0OOooO0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            OooO00o();
        } catch (Exception unused) {
        }
    }

    private void OooO00o() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.ubixnow_feedback_dialog_edt_layout, this);
        viewInflate.findViewById(R.id.dialog_close).setOnClickListener(new OooO00o());
        TextView textView = (TextView) viewInflate.findViewById(R.id.dialog_submit);
        this.OooO0o0 = textView;
        textView.setOnClickListener(new OooO0O0());
        this.OooO0OO = (EditText) findViewById(R.id.report_edt);
        this.OooO0Oo = (TextView) findViewById(R.id.report_text_nub);
        this.OooO0o0.setTextColor(855638016);
        this.OooO0OO.addTextChangedListener(new OooO0OO());
        OooO0O0();
        this.OooO0OO.requestFocus();
    }

    private void OooO0O0() {
        this.OooO0OO.requestFocus();
        new Handler(Looper.getMainLooper()).postDelayed(new OooO0o(), 200L);
    }

    public void OooO00o(EditText editText) {
        Context context = getContext();
        getContext();
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.OooO0O0 = onClickListener;
    }

    public void setTrackingInfo(HashMap<String, String> map) {
        this.OooO00o = map;
    }
}
