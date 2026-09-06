package com.baidu.mobads.sdk.internal.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.OnPageChangeCallback> f1827a;

    CompositeOnPageChangeCallback(int i) {
        this.f1827a = new ArrayList(i);
    }

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1827a.add(onPageChangeCallback);
    }

    void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1827a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f1827a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f1827a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f1827a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
