package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.adprof.sdk.api.AdAppInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class s3 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f1412a;
    public TextView b;

    public s3(Context context) {
        super(context);
    }

    public View getSixDownloadView() {
        return this.b;
    }

    public void setDownloadButtonVisible(boolean z) {
        TextView textView = this.f1412a;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
    }

    public void setValue(d dVar) {
        setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f1412a = textView;
        textView.setText("立即下载");
        this.f1412a.setBackground(getResources().getDrawable(R.drawable.adprof_shape_cta_bg));
        this.f1412a.setTextColor(-1);
        this.f1412a.setGravity(17);
        addView(this.f1412a, new LinearLayout.LayoutParams(-1, h8.a(40.0f)));
        TextView textView2 = new TextView(getContext());
        this.b = textView2;
        textView2.setMaxLines(2);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView3 = this.b;
        Object[] objArr = new Object[3];
        objArr[0] = dVar.m601c();
        AdAppInfo adAppInfo = dVar.f182a;
        objArr[1] = adAppInfo != null ? adAppInfo.getVersionName() : "";
        AdAppInfo adAppInfo2 = dVar.f182a;
        objArr[2] = adAppInfo2 != null ? adAppInfo2.getDeveloper() : "";
        textView3.setText(String.format("应用名称：%s |版本%s |开发者：%s |应用权限|隐私协议|功能介绍", objArr));
        this.b.setTextSize(2, 11.0f);
        this.b.setTextColor(-13421773);
        this.b.setPadding(0, h8.a(1.0f), 0, h8.a(5.0f));
        addView(this.b);
        this.b.setTag("setTag");
        this.b.setId(102060003);
    }
}
