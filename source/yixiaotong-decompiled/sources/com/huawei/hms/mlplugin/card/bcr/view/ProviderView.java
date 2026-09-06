package com.huawei.hms.mlplugin.card.bcr.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.huawei.hms.mlplugin.card.bcr.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ProviderView extends LinearLayout {
    public ProviderView(Context context, boolean z) {
        super(context);
        a(z);
    }

    private void a(boolean z) {
        if (z) {
            LayoutInflater.from(getContext()).inflate(R.layout.mlkit_bcr_layout_customed, this);
        } else {
            LayoutInflater.from(getContext()).inflate(R.layout.mlkit_bcr_layout_customed, this);
        }
    }
}
