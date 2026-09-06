package com.hihonor.adsdk.base.callback;

import android.view.View;
import com.hihonor.adsdk.base.bean.DislikeInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface DislikeItemClickListener {
    void onCancel();

    void onFeedItemClick(int i, DislikeInfo dislikeInfo, View view);

    void onShow();
}
