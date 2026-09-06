package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivitySearchAmmeterBinding implements ViewBinding {
    public final ListView ammeterLv;
    public final RelativeLayout rootLayout;
    private final RelativeLayout rootView;
    public final TitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivitySearchAmmeterBinding(RelativeLayout relativeLayout, ListView listView, RelativeLayout relativeLayout2, TitleBar titleBar) {
        this.rootView = relativeLayout;
        this.ammeterLv = listView;
        this.rootLayout = relativeLayout2;
        this.titleBar = titleBar;
    }

    public static ActivitySearchAmmeterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySearchAmmeterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_search_ammeter, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySearchAmmeterBinding bind(View view) {
        int i = R.id.ammeter_lv;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
        if (listView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = R.id.titleBar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i2);
            if (titleBar != null) {
                return new ActivitySearchAmmeterBinding(relativeLayout, listView, relativeLayout, titleBar);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
