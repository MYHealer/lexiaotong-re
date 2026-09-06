package com.ubix.ssp.ad.e.z;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends h implements View.OnClickListener {
    private TextView h;
    private TextView i;
    private ImageView j;
    private EditText k;
    private View l;
    private int m;
    private int n;
    private float o;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (editable.length() > 0) {
                    c.this.i.setTextColor(-16777216);
                } else {
                    c.this.i.setTextColor(-8158333);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((InputMethodManager) c.this.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.d();
            if (c.this.k != null) {
                c.this.k.requestFocus();
            }
            c.this.postDelayed(new a(), 200L);
        }
    }

    public c(Context context) {
        super(context);
        this.m = r.a().h(context);
        this.n = r.a().c(context);
        this.o = r.a().a(context);
    }

    private void a(EditText editText) {
        if (editText != null) {
            try {
                ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                editText.clearFocus();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.j = new ImageView(getContext());
        this.h = new TextView(getContext());
        this.i = new TextView(getContext());
        this.k = new EditText(getContext());
        this.l = new View(getContext());
        this.j.setImageDrawable(q.a("ubix/ic_web_back.png"));
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h.setText("其他建议");
        this.i.setText("提交");
        this.h.setTextColor(-13421773);
        this.i.setTextColor(-8158333);
        this.k.setBackground(null);
        relativeLayout.setId(20000);
        this.j.setId(20003);
        this.h.setId(20001);
        this.i.setId(20004);
        this.k.setId(20005);
        this.l.setId(20002);
        this.l.setBackgroundColor(-921103);
        this.k.setTextColor(-16777216);
        this.k.setGravity(GravityCompat.START);
        this.k.setTextSize(12.0f);
        this.k.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.m, (int) (this.o * 32.0f));
        int i = (int) (this.o * 22.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (((int) (((double) Math.min(this.m, this.n)) * 0.7d)) - ((int) (this.o * 32.0f))) - 2);
        layoutParams5.addRule(3, 20002);
        int i2 = (int) (this.o * 12.0f);
        layoutParams2.leftMargin = i2;
        layoutParams3.rightMargin = i2;
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 2);
        layoutParams6.addRule(3, 20000);
        this.j.setPadding(10, 10, 10, 10);
        this.i.setPadding(10, 10, 10, 10);
        EditText editText = this.k;
        float f = this.o;
        int i3 = (int) (14.0f * f);
        int i4 = (int) (f * 4.0f);
        editText.setPadding(i3, i4, i3, i4);
        relativeLayout.addView(this.j, layoutParams2);
        relativeLayout.addView(this.h, layoutParams4);
        relativeLayout.addView(this.i, layoutParams3);
        addView(relativeLayout, layoutParams);
        addView(this.l, layoutParams6);
        addView(this.k, layoutParams5);
        setBackgroundColor(-1);
        this.j.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.k.addTextChangedListener(new a());
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
    }

    public int getContentHeight() {
        return this.n;
    }

    public int getContentWidth() {
        return this.m;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 4;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(new b(), 50L);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 20003) {
            l lVar = this.c;
            if (lVar != null && lVar.b()) {
                this.c.a();
            }
            Dialog dialog = this.d;
            if (dialog != null && dialog.isShowing()) {
                this.d.dismiss();
            }
            h.c cVar = this.e;
            if (cVar != null) {
                cVar.a(null);
            }
            h.c cVar2 = this.e;
            if (cVar2 != null) {
                cVar2.b(null);
                return;
            }
            return;
        }
        if (id == 20004 && !TextUtils.isEmpty(this.k.getText().toString())) {
            a(this.k);
            l lVar2 = this.c;
            if (lVar2 != null && lVar2.b()) {
                this.c.a();
            }
            Dialog dialog2 = this.d;
            if (dialog2 != null && dialog2.isShowing()) {
                this.d.dismiss();
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("dislikeId", "601210");
            map.put("dislikeContent", this.k.getText().toString());
            h.c cVar3 = this.e;
            if (cVar3 != null) {
                cVar3.a(this, map);
            }
            h.c cVar4 = this.e;
            if (cVar4 != null) {
                cVar4.b(this);
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.m = r.a().h(getContext());
            this.n = r.a().c(getContext());
            findViewById(20000).getLayoutParams().width = this.m;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.m;
        setMeasuredDimension(i3, (int) (((double) Math.min(i3, this.n)) * 0.7d));
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
    }
}
