package client.android.yixiaotong.v3.util;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MyViewUtil {
    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view) {
        addAdViewToAdContainer(viewGroup, view, null);
    }

    public static void addAdViewToAdContainer(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup == null) {
            return;
        }
        if (view == null) {
            viewGroup.removeAllViews();
            return;
        }
        if (viewGroup.getChildCount() <= 0 || viewGroup.getChildAt(0) != view) {
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (layoutParams != null) {
                viewGroup.addView(view, layoutParams);
            } else {
                viewGroup.addView(view);
            }
        }
    }
}
