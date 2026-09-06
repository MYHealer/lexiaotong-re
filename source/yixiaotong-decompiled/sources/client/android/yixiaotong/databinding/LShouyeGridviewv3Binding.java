package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.pullrefresh.MyGridView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class LShouyeGridviewv3Binding implements ViewBinding {
    private final MyGridView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public MyGridView getRoot() {
        return this.rootView;
    }

    private LShouyeGridviewv3Binding(MyGridView myGridView) {
        this.rootView = myGridView;
    }

    public static LShouyeGridviewv3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LShouyeGridviewv3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.l_shouye_gridviewv3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LShouyeGridviewv3Binding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new LShouyeGridviewv3Binding((MyGridView) view);
    }
}
