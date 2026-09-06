package com.meishu.sdk.meishu_ad.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: LifecycleHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5037a = c.class.getName();
    public Activity b;

    public void a(d dVar) {
        try {
            Activity activity = this.b;
            if (activity == null) {
                LogUtil.e(this.f5037a, "setLifecycleListener: ", new Exception("View Context非Activity"));
                return;
            }
            if (!(activity instanceof FragmentActivity)) {
                int i = a.b;
                FragmentManager fragmentManager = activity.getFragmentManager();
                a aVar = (a) fragmentManager.findFragmentByTag("LifecycleFragment");
                if (aVar == null && !activity.isFinishing()) {
                    aVar = new a();
                    fragmentManager.beginTransaction().add(aVar, "LifecycleFragment").commitAllowingStateLoss();
                }
                if (aVar != null) {
                    aVar.f5035a = dVar;
                    return;
                }
                return;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            int i2 = b.b;
            androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            b bVar = (b) supportFragmentManager.findFragmentByTag("LifecycleFragment_V4");
            if (bVar == null && !fragmentActivity.isFinishing()) {
                bVar = new b();
                supportFragmentManager.beginTransaction().add(bVar, "LifecycleFragment_V4").commitAllowingStateLoss();
            }
            if (bVar != null) {
                bVar.f5036a = dVar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
