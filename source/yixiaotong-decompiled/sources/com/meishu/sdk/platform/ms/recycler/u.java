package com.meishu.sdk.platform.ms.recycler;

import android.view.View;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ReflectUtil;

/* JADX INFO: compiled from: ViewPagerChecker.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5231a;
    public Boolean b;

    public u(View view) {
        Class<?> cls;
        this.f5231a = false;
        this.b = Boolean.FALSE;
        if (view == null) {
            return;
        }
        try {
            if ("androidx.viewpager2.widget.ViewPager2$RecyclerViewImpl".equals(view.getClass().getName()) && (cls = ReflectUtil.getClass("androidx.viewpager2.widget.ViewPager2")) != null && "androidx.viewpager2.widget.ViewPager2".equals(view.getParent().getClass().getName())) {
                this.f5231a = true;
                this.b = (Boolean) ReflectUtil.getValue(cls, "mUserInputEnabled", view.getParent());
                LogUtil.dev("u", "orientation:" + ((Integer) ReflectUtil.invokeMethod(ReflectUtil.getMethod(cls, "getOrientation", new Class[0]), view.getParent(), new Object[0])) + " mUserInputEnabled:" + this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean a() {
        return Boolean.TRUE.equals(this.b);
    }
}
