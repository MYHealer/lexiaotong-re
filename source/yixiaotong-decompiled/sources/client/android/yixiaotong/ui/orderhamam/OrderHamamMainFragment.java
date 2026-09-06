package client.android.yixiaotong.ui.orderhamam;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OrderHamamMainFragment extends BaseFragment {
    public static OrderHamamMainFragment newInstance() {
        return new OrderHamamMainFragment();
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_order_hamam_main, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
