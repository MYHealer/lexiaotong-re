package com.meishu.sdk.core.ad.recycler;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.ReflectUtil;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: RecyclerAdUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<Class<? extends ViewGroup>> f4764a;

    static {
        ArrayList<Class<? extends ViewGroup>> arrayList = new ArrayList<>();
        f4764a = arrayList;
        arrayList.add(TouchAdContainer.class);
        if (AdSdk.getGDTVersionName() != null) {
            f4764a.add(NativeAdContainer.class);
        }
        if (AdSdk.getOPPOVersionName() != null) {
            f4764a.add(NativeAdvanceContainer.class);
        }
        try {
            Class<?> cls = ReflectUtil.getClass("com.zj.zjsdk.api.v2.nativead.ZJNativeAdContainer");
            if (cls != null) {
                f4764a.add((Class<? extends ViewGroup>) cls);
            }
        } catch (Throwable unused) {
        }
    }

    public static ViewGroup a(ViewGroup viewGroup) {
        ViewGroup viewGroupA;
        Object tag = viewGroup.getTag(R.id.ms_ad_container_tag_recycler);
        if (tag != null && tag.equals("meishu_ad_container_tag_recycler")) {
            return viewGroup;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof ViewGroup) && (viewGroupA = a((ViewGroup) childAt)) != null) {
                return viewGroupA;
            }
        }
        return null;
    }

    public static void b(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = null;
        ViewGroup viewGroup3 = viewGroup;
        while (viewGroup3 != null) {
            ViewParent parent = viewGroup3.getParent();
            if (!(parent instanceof ViewGroup)) {
                break;
            }
            viewGroup3 = (ViewGroup) parent;
            Iterator<Class<? extends ViewGroup>> it = f4764a.iterator();
            while (it.hasNext()) {
                if (it.next().isInstance(viewGroup3)) {
                    viewGroup2 = viewGroup3;
                    break;
                }
            }
        }
        if (viewGroup2 != null) {
            ViewParent parent2 = viewGroup2.getParent();
            if (parent2 instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) parent2;
                int iIndexOfChild = viewGroup4.indexOfChild(viewGroup2);
                if (viewGroup.getParent() instanceof ViewGroup) {
                    ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                }
                viewGroup4.removeView(viewGroup2);
                viewGroup4.addView(viewGroup, iIndexOfChild, viewGroup2.getLayoutParams());
            }
        }
    }

    public static ViewGroup[] a(ViewGroup viewGroup, Class cls, Class cls2) {
        ViewGroup[] viewGroupArr = {null, null};
        ViewGroup viewGroupA = a(viewGroup);
        if (viewGroupA == null) {
            viewGroupArr[0] = viewGroup;
            viewGroup.setTag(R.id.ms_ad_container_tag_recycler, "meishu_ad_container_tag_recycler");
        } else {
            viewGroupArr[0] = viewGroupA;
            Object tag = viewGroupA.getTag(R.id.ms_ad_container_class_recycler);
            if (tag != null && tag.equals(cls)) {
                ViewGroup viewGroup2 = viewGroupA;
                int i = 1;
                while ((viewGroup2 instanceof ViewGroup) && i < 20) {
                    i++;
                    if (cls2.isInstance(viewGroup2)) {
                        viewGroupArr[1] = viewGroup2;
                        break;
                    }
                    if (viewGroup2.getParent() instanceof ViewGroup) {
                        viewGroup2 = (ViewGroup) viewGroup2.getParent();
                    }
                }
            }
            if (viewGroupArr[1] == null) {
                b(viewGroupA);
            }
        }
        viewGroupArr[0].setTag(R.id.ms_ad_container_class_recycler, cls);
        return viewGroupArr;
    }
}
