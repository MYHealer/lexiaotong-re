package com.adprof.sdk;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.adprof.sdk.base.view.LogoImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sf extends RelativeLayout {
    public sf(Context context) {
        super(context);
    }

    public void a(View.OnClickListener onClickListener, int i, d dVar) {
        z2 z2Var;
        removeAllViews();
        LogoImageView logoImageView = new LogoImageView(getContext());
        logoImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        logoImageView.setAdjustViewBounds(true);
        logoImageView.setImageResource(R.drawable.adprof_ad_logo);
        int iGenerateViewId = View.generateViewId();
        logoImageView.setId(iGenerateViewId);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, h8.a(20.0f));
        layoutParams.addRule(20);
        layoutParams.addRule(15);
        layoutParams.setMarginStart(h8.a(5.0f));
        addView(logoImageView, layoutParams);
        if (dVar != null) {
            try {
                ul ulVarA = vl.a(dVar);
                if (ulVarA != null && "1".equals(ulVarA.s)) {
                    q0 q0Var = dVar.f188a;
                    int i2 = (q0Var == null || (z2Var = q0Var.f643a) == null) ? 0 : z2Var.f1548a;
                    TextView textView = new TextView(getContext());
                    textView.setText(String.valueOf(i2));
                    textView.setTextColor(-7829368);
                    textView.setTextSize(2, 12.0f);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(17, iGenerateViewId);
                    layoutParams2.addRule(15);
                    layoutParams2.setMarginStart(h8.a(6.0f));
                    addView(textView, layoutParams2);
                }
            } catch (Throwable th) {
                pk.a(th);
            }
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.adprof_ad_close);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(h8.a(20.0f), h8.a(20.0f));
        if (i == 2) {
            layoutParams3.width = h8.a(15.0f);
            layoutParams3.height = h8.a(15.0f);
        }
        layoutParams3.addRule(21);
        layoutParams3.addRule(15);
        layoutParams3.setMarginEnd(h8.a(5.0f));
        imageView.setLayoutParams(layoutParams3);
        imageView.setOnClickListener(onClickListener);
        addView(imageView);
    }

    public void setValue(View.OnClickListener onClickListener) {
        a(onClickListener, 0, null);
    }
}
