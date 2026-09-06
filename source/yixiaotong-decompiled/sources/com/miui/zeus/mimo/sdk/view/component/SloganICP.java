package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.t6;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SloganICP extends RelativeLayout implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f5712a;
    public ImageView b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5713a;

        public a(i8 i8Var) {
            this.f5713a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5713a;
            if (i8Var != null) {
                i8Var.onClick(view, SloganICP.this.getClickAreaType());
            }
        }
    }

    public SloganICP(Context context) {
        super(context);
        a();
    }

    public SloganICP(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SloganICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public final void a() {
        Drawable applicationIcon;
        setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        this.b = new ImageView(getContext());
        int iA = f9.a(getContext(), 37.5f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 16;
        ImageView imageView = this.b;
        Context context = y8.f5752a;
        String str = null;
        try {
            applicationIcon = context.getPackageManager().getApplicationIcon(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            m.b(s.d(new byte[]{37, 94, 7, 17, 87, 95, 5, 49, Ascii.DC2, 11, 93, Ascii.SYN}, "d0cc86"), s.d(new byte[]{80, 84, 17, 37, 17, SignedBytes.MAX_POWER_OF_TWO, 40, 7, 9, 12, 117, Ascii.ETB, 86, 70, 4, 6, 13, 85, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 67, 88, 10, 10}, "71eda0"), e);
            applicationIcon = null;
        }
        imageView.setBackground(applicationIcon);
        this.b.setOutlineProvider(new t6(f9.a(getContext(), 5.4f)));
        this.b.setClipToOutline(true);
        linearLayout.addView(this.b, layoutParams2);
        this.f5712a = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = f9.a(getContext(), 8.7f);
        layoutParams3.gravity = 16;
        this.f5712a.setTextColor(-536870912);
        this.f5712a.setTextSize(1, 17.0f);
        TextView textView = this.f5712a;
        Context context2 = y8.f5752a;
        String packageName = context2.getPackageName();
        try {
            PackageManager packageManager = context2.getPackageManager();
            str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0));
        } catch (Exception unused) {
        }
        textView.setText(str);
        linearLayout.addView(this.f5712a, layoutParams3);
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_SLOGAN;
    }

    public void setIClickAreaListener(i8 i8Var) {
        setOnClickListener(new a(i8Var));
    }

    public void setRpkIcon(String str) {
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            Glide.with(y8.f5752a).load(str).placeholder(getResources().getDrawable(a0.i4)).into(this.b);
        }
    }

    public void setRpkText(String str) {
        TextView textView = this.f5712a;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
