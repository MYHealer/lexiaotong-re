package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f1829a;
    private ViewPager2.PageTransformer b;

    ViewPager2.PageTransformer a() {
        return this.b;
    }

    void a(ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f1829a = linearLayoutManager;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f1829a.getChildCount(); i3++) {
            View childAt = this.f1829a.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f1829a.getChildCount())));
            }
            this.b.transformPage(childAt, (this.f1829a.getPosition(childAt) - i) + f2);
        }
    }
}
