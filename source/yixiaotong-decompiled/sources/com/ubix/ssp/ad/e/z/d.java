package com.ubix.ssp.ad.e.z;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends h implements View.OnClickListener {
    private int h;
    private int i;
    private int j;
    private int k;
    private LinearLayout[] l;
    private TextView[] m;
    private TextView[] n;
    private LinearLayout o;
    private TextView p;
    private int q;
    private int r;
    private boolean s;

    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Dialog dialog;
            if (d.this.s || (dialog = d.this.d) == null || dialog.isShowing()) {
                return;
            }
            d.this.d.show();
        }
    }

    class b implements h.c {
        b() {
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(h hVar) {
            Dialog dialog = d.this.d;
            if (dialog == null || dialog.isShowing()) {
                return;
            }
            d.this.d.show();
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(h hVar, HashMap<String, String> map) {
            d.this.s = true;
            d dVar = d.this;
            h.c cVar = dVar.e;
            if (cVar != null) {
                cVar.a(dVar, map);
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void b(h hVar) {
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void c(h hVar) {
        }
    }

    public d(Context context) {
        super(context);
        this.l = new LinearLayout[6];
        this.m = new TextView[6];
        this.n = new TextView[4];
        this.s = false;
        this.j = r.a().h(context);
        int iC = r.a().c(context) / 2;
        this.k = iC;
        int i = this.j;
        this.h = i / 20;
        this.i = Math.max(iC, i / 2) / 20;
        u.e("topMargin=" + this.i);
        int i2 = (int) (((double) this.j) / 2.5d);
        this.q = i2;
        this.r = (int) (((double) i2) / 3.8d);
        d();
        setData(null);
        setBackgroundColor(-1);
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    private int a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : this.j;
    }

    private void d() {
        u.e("child.getId()=" + this.j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, 2);
        for (int i = 0; i < 6; i++) {
            this.l[i] = new LinearLayout(getContext());
            this.m[i] = new TextView(getContext());
            this.m[i].setId(150001 + i);
            this.l[i].addView(this.m[i]);
            this.l[i].setId(110001 + i);
            this.l[i].setGravity(16);
            this.m[i].setTextColor(-16777216);
            LinearLayout linearLayout = this.l[i];
            int i2 = this.i / 2;
            linearLayout.setPadding(0, i2, 0, i2);
            this.m[i].setTextSize(12.0f);
            this.l[i].setOnClickListener(this);
            addView(this.l[i]);
            if (i < 5) {
                View view = new View(getContext());
                view.setId(120001 + i);
                view.setBackgroundColor(-921103);
                addView(view, layoutParams);
            }
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.n[i3] = new TextView(getContext());
            this.n[i3].setId(130001 + i3);
            this.n[i3].setBackgroundColor(-921103);
            this.n[i3].setTextColor(-16777216);
            this.n[i3].setPadding(20, 10, 20, 10);
            this.n[i3].setTextSize(12.0f);
            this.n[i3].setOnClickListener(this);
            addView(this.n[i3]);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setStroke(2, -921103);
        gradientDrawable.setCornerRadius(4.0f);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.o = linearLayout2;
        linearLayout2.setGravity(16);
        TextView textView = new TextView(getContext());
        this.p = textView;
        textView.setTextColor(-7829368);
        this.o.addView(this.p);
        this.o.setId(140001);
        this.p.setId(140002);
        this.o.setBackground(gradientDrawable);
        this.o.setPadding(5, 20, 5, 20);
        this.p.setTextSize(12.0f);
        this.o.setOnClickListener(this);
        addView(this.o);
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    public int getContentHeight() {
        return this.k;
    }

    public int getContentWidth() {
        return this.j;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 4;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        HashMap<String, String> map;
        h.c cVar;
        int id = view.getId();
        if (id != 140001) {
            switch (id) {
                case 110001:
                    str = "601201";
                    break;
                case 110002:
                    str = "601202";
                    break;
                case 110003:
                    str = "601203";
                    break;
                case 110004:
                    str = "601204";
                    break;
                case 110005:
                    str = "601205";
                    break;
                default:
                    switch (id) {
                        case 130001:
                            str = "601206";
                            break;
                        case 130002:
                            str = "601207";
                            break;
                        case 130003:
                            str = "601208";
                            break;
                        case 130004:
                            str = "601209";
                            break;
                    }
                    break;
            }
            if (TextUtils.isEmpty(str)) {
            }
            map = new HashMap<>();
            map.put("dislikeId", str);
            cVar = this.e;
            if (cVar != null) {
                cVar.a(this, map);
            }
        }
        Dialog dialog = this.d;
        if (dialog != null) {
            dialog.dismiss();
        }
        l lVar = this.c;
        if (lVar != null) {
            lVar.a();
        }
        Dialog dialog2 = new Dialog(getContext(), R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        c cVar2 = new c(getContext());
        Window window = dialog2.getWindow();
        window.setLayout(-1, -2);
        window.setBackgroundDrawableResource(R.color.transparent);
        window.setDimAmount(0.3f);
        window.addFlags(2);
        window.setGravity(80);
        dialog2.setOnDismissListener(new a());
        cVar2.a(dialog2, new b(), (h.b) null);
        linearLayout.addView(cVar2);
        linearLayout.setGravity(GravityCompat.START);
        dialog2.setContentView(linearLayout);
        dialog2.show();
        str = "";
        if (TextUtils.isEmpty(str)) {
            map = new HashMap<>();
            map.put("dislikeId", str);
            cVar = this.e;
            if (cVar != null) {
                cVar.a(this, map);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int bottom;
        int i6;
        int bottom2;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onLayout(z, i, i2, i3, i4);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            int id = childAt.getId();
            if (id != 140001) {
                switch (id) {
                    case 110001:
                        int i12 = this.j;
                        int i13 = i12 / 20;
                        childAt.layout(i13, 0, i12 - i13, (this.i / 10) + childAt.getMeasuredHeight());
                        childAt.getLayoutParams().height = childAt.getMeasuredHeight();
                        break;
                    case 110002:
                        i5 = this.j / 20;
                        i8 = 120001;
                        bottom = findViewById(i8).getBottom();
                        int i14 = this.j;
                        i6 = i14 - (i14 / 20);
                        bottom2 = findViewById(i8).getBottom();
                        i7 = this.i / 10;
                        break;
                    case 110003:
                        i5 = this.j / 20;
                        i8 = 120002;
                        bottom = findViewById(i8).getBottom();
                        int i15 = this.j;
                        i6 = i15 - (i15 / 20);
                        bottom2 = findViewById(i8).getBottom();
                        i7 = this.i / 10;
                        break;
                    case 110004:
                        i5 = this.j / 20;
                        i8 = 120003;
                        bottom = findViewById(i8).getBottom();
                        int i16 = this.j;
                        i6 = i16 - (i16 / 20);
                        bottom2 = findViewById(i8).getBottom();
                        i7 = this.i / 10;
                        break;
                    case 110005:
                        i5 = this.j / 20;
                        i8 = 120004;
                        bottom = findViewById(i8).getBottom();
                        int i17 = this.j;
                        i6 = i17 - (i17 / 20);
                        bottom2 = findViewById(i8).getBottom();
                        i7 = this.i / 10;
                        break;
                    case 110006:
                        i5 = this.j / 20;
                        i8 = 120005;
                        bottom = findViewById(i8).getBottom();
                        int i18 = this.j;
                        i6 = i18 - (i18 / 20);
                        bottom2 = findViewById(i8).getBottom();
                        i7 = this.i / 10;
                        break;
                    default:
                        switch (id) {
                            case 120001:
                                i9 = this.j / 20;
                                i10 = 110001;
                                int bottom3 = findViewById(i10).getBottom();
                                int i19 = this.j;
                                childAt.layout(i9, bottom3, i19 - (i19 / 20), findViewById(i10).getBottom() + 2);
                                childAt.getLayoutParams().height = 2;
                                break;
                            case 120002:
                                i9 = this.j / 20;
                                i10 = 110002;
                                int bottom4 = findViewById(i10).getBottom();
                                int i110 = this.j;
                                childAt.layout(i9, bottom4, i110 - (i110 / 20), findViewById(i10).getBottom() + 2);
                                childAt.getLayoutParams().height = 2;
                                break;
                            case 120003:
                                i9 = this.j / 20;
                                i10 = 110003;
                                int bottom5 = findViewById(i10).getBottom();
                                int i111 = this.j;
                                childAt.layout(i9, bottom5, i111 - (i111 / 20), findViewById(i10).getBottom() + 2);
                                childAt.getLayoutParams().height = 2;
                                break;
                            case 120004:
                                i9 = this.j / 20;
                                i10 = 110004;
                                int bottom6 = findViewById(i10).getBottom();
                                int i112 = this.j;
                                childAt.layout(i9, bottom6, i112 - (i112 / 20), findViewById(i10).getBottom() + 2);
                                childAt.getLayoutParams().height = 2;
                                break;
                            case 120005:
                                i9 = this.j / 20;
                                i10 = 110005;
                                int bottom7 = findViewById(i10).getBottom();
                                int i113 = this.j;
                                childAt.layout(i9, bottom7, i113 - (i113 / 20), findViewById(i10).getBottom() + 2);
                                childAt.getLayoutParams().height = 2;
                                break;
                            default:
                                switch (id) {
                                    case 130001:
                                        childAt.layout(this.j / 20, findViewById(110006).getBottom(), (this.j / 20) + childAt.getMeasuredWidth(), findViewById(110006).getBottom() + childAt.getMeasuredHeight());
                                        break;
                                    case 130002:
                                        childAt.layout(findViewById(130001).getRight() + (this.i / 2), findViewById(110006).getBottom(), findViewById(130001).getRight() + (this.i / 2) + childAt.getMeasuredWidth(), findViewById(110006).getBottom() + childAt.getMeasuredHeight());
                                        break;
                                    case 130003:
                                        childAt.layout(findViewById(130002).getRight() + (this.i / 2), findViewById(110006).getBottom(), findViewById(130002).getRight() + (this.i / 2) + childAt.getMeasuredWidth(), findViewById(110006).getBottom() + childAt.getMeasuredHeight());
                                        break;
                                    case 130004:
                                        if (this.j - (findViewById(130003).getRight() + (this.j / 20)) < childAt.getMeasuredWidth()) {
                                            childAt.layout(this.j / 20, findViewById(130001).getBottom() + (this.i / 5), (this.j / 20) + childAt.getMeasuredWidth(), findViewById(130001).getBottom() + (this.i / 5) + childAt.getMeasuredHeight());
                                        } else {
                                            childAt.layout(findViewById(130003).getRight() + (this.i / 2), findViewById(110006).getBottom(), findViewById(130003).getRight() + (this.i / 2) + childAt.getMeasuredWidth(), findViewById(110006).getBottom() + childAt.getMeasuredHeight());
                                        }
                                        break;
                                    default:
                                        continue;
                                }
                                childAt.getLayoutParams().height = childAt.getMeasuredHeight();
                                break;
                        }
                        break;
                }
            } else {
                i5 = this.j / 20;
                bottom = findViewById(130004).getBottom() + ((int) (((double) this.i) / 1.5d));
                int i20 = this.j;
                i6 = i20 - (i20 / 20);
                bottom2 = findViewById(130004).getBottom();
                i7 = (int) (((double) this.i) / 1.5d);
            }
            childAt.layout(i5, bottom, i6, bottom2 + i7 + childAt.getMeasuredHeight());
            childAt.getLayoutParams().height = childAt.getMeasuredHeight();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.k = 0;
        this.j = a(i);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            if (id == 130001) {
                this.k += this.i / 5;
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.k += childAt.getMeasuredHeight();
                u.e("child.getId()=" + childAt.getId() + ";h=" + this.k);
                int i4 = this.k + marginLayoutParams.topMargin;
                this.k = i4;
                this.k = i4 + marginLayoutParams.bottomMargin;
            } else if (id != 140001) {
                switch (id) {
                    case 110001:
                    case 110002:
                    case 110003:
                    case 110004:
                    case 110005:
                    case 110006:
                        break;
                    default:
                        switch (id) {
                            case 120001:
                            case 120002:
                            case 120003:
                            case 120004:
                            case 120005:
                                break;
                            default:
                                continue;
                        }
                        break;
                }
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.k += childAt.getMeasuredHeight();
                u.e("child.getId()=" + childAt.getId() + ";h=" + this.k);
                int i5 = this.k + marginLayoutParams2.topMargin;
                this.k = i5;
                this.k = i5 + marginLayoutParams2.bottomMargin;
            } else {
                this.k += this.j / 20;
                this.k += this.i / 5;
                measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                this.k += childAt.getMeasuredHeight();
                u.e("child.getId()=" + childAt.getId() + ";h=" + this.k);
                int i6 = this.k + marginLayoutParams3.topMargin;
                this.k = i6;
                this.k = i6 + marginLayoutParams3.bottomMargin;
            }
        }
        this.k += 20;
        u.e(" setMeasuredDimension(width, height)=" + this.k);
        setMeasuredDimension(this.j, this.k);
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        ((TextView) findViewById(150001)).setText("内容无法正常展示（卡顿、黑白屏）");
        ((TextView) findViewById(150002)).setText("不感兴趣");
        ((TextView) findViewById(150003)).setText("无法关闭广告");
        ((TextView) findViewById(150004)).setText("点击异常、频繁跳转");
        ((TextView) findViewById(150005)).setText("投放内容与用户年龄不符");
        ((TextView) findViewById(FraudVerifyCode.RerwardFraudRepeatRequest)).setText("反馈广告质量");
        ((TextView) findViewById(130001)).setText("低俗色情");
        ((TextView) findViewById(130002)).setText("诱导点击");
        ((TextView) findViewById(130003)).setText("违规违法");
        ((TextView) findViewById(130004)).setText("疑似抄袭");
        this.p.setText("详细的描述有助于我们快速定位问题");
    }
}
