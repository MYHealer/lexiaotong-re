package com.ubix.ssp.ad.c.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.ErrorCode;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.ad.e.v.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends c {
    private boolean k;

    public a(Context context, Bundle bundle) {
        super(context, bundle);
        this.k = false;
    }

    @Override // com.ubix.ssp.ad.c.c.c
    public boolean a(Bundle bundle) {
        try {
            this.k = bundle.getBoolean("IS_DOWNLOAD");
            ImageView imageView = (ImageView) findViewById(100010);
            if (imageView != null) {
                imageView.setBackgroundDrawable(new BitmapDrawable(com.ubix.ssp.ad.e.a0.c.b(bundle.getStringArray("IMAGE_URL")[0])));
                e.b().b(bundle.getStringArray("IMAGE_URL")[0], imageView);
            }
            ImageView imageView2 = (ImageView) findViewById(100008);
            if (imageView2 != null) {
                imageView2.setBackground(q.a("ubix/ic_logo_dark_bg.webp", this.j));
            }
            ImageView imageView3 = (ImageView) findViewById(ErrorCode.d.hnadsk);
            if (imageView3 != null) {
                imageView3.setBackground(q.a("ubix/ic_close_gray.webp"));
            }
            TextView textView = (TextView) findViewById(100009);
            if (textView != null && !TextUtils.isEmpty(bundle.getString("AD_SOURCE", ""))) {
                textView.setShadowLayer(4.0f, 0.0f, 1.0f, 1711276032);
                textView.setText(bundle.getString("AD_SOURCE", ""));
            }
            TextView textView2 = (TextView) findViewById(ErrorCode.d.hnadsc);
            if (textView2 != null) {
                textView2.setText(bundle.getString("TITLE"));
            }
            TextView textView3 = (TextView) findViewById(ErrorCode.d.hnadsg);
            if (textView3 == null) {
                return true;
            }
            String string = bundle.getString("BUTTON_TEXT");
            if (TextUtils.isEmpty(string)) {
                string = this.k ? "立即下载" : "查看详情";
            }
            textView3.setText(string);
            textView3.setBackground(com.ubix.ssp.ad.e.a0.c.a(getContext(), Color.parseColor("#FA800F"), 120));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int left;
        ViewGroup.LayoutParams layoutParams;
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsb, getWidth() + "");
        this.e.put(com.hihonor.adsdk.base.g.j.e.c.hnadsa, getHeight() + "");
        this.e.put("__IMP_AREA__", getLeft() + "_" + getTop() + "_" + getRight() + "_" + getBottom());
        this.e.put("adLeft", getLeft() + "");
        this.e.put("adRight", getRight() + "");
        this.e.put("adTop", getTop() + "");
        this.e.put("adBottom", getBottom() + "");
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            int id = childAt.getId();
            if (id != 100002) {
                if (id == 100004) {
                    left = i3 / 4;
                    childAt.layout((i3 - left) + (this.f8586a * 2), (i4 - childAt.getMeasuredHeight()) / 2, i3 - (this.f8586a * 2), (childAt.getMeasuredHeight() + i4) / 2);
                    layoutParams = childAt.getLayoutParams();
                    i5 = this.f8586a * 4;
                } else if (id != 920101) {
                    switch (id) {
                        case ErrorCode.d.hnadsk /* 100007 */:
                            double d = i3;
                            int i7 = this.f8586a;
                            double d2 = ((double) i7) * 0.2d;
                            double d3 = ((double) (i7 * 4)) + d2;
                            childAt.layout((int) (d - d3), (int) d2, (int) (d - d2), (int) d3);
                            break;
                        case 100008:
                            int i8 = this.f8586a;
                            int i9 = this.c;
                            childAt.layout(i3 - (i8 * 7), i9 - (i8 * 3), i3, i9);
                            break;
                        case 100009:
                            View viewFindViewById = findViewById(100008);
                            childAt.layout(viewFindViewById.getLeft() - childAt.getMeasuredWidth(), viewFindViewById.getTop(), viewFindViewById.getLeft(), viewFindViewById.getBottom());
                            break;
                        case 100010:
                            childAt.layout(0, 0, (i3 - i) / 4, i2 + this.c);
                            break;
                    }
                } else {
                    View viewFindViewById2 = findViewById(100008);
                    childAt.layout(0, i4 - childAt.getMeasuredHeight(), viewFindViewById2.getLeft() - this.f8586a, i4);
                    layoutParams = childAt.getLayoutParams();
                    left = viewFindViewById2.getLeft();
                    i5 = this.f8586a;
                }
                layoutParams.width = left - i5;
            } else {
                int i10 = (i3 - i) / 4;
                childAt.layout(i10, 0, i10 * 3, i4);
                childAt.getLayoutParams().width = i3 / 2;
                childAt.setBackgroundColor(0);
                childAt.getLayoutParams().height = i4;
            }
        }
    }
}
