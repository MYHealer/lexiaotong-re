package com.bytedance.android.live.base.api;

import android.view.View;
import com.bytedance.android.live.base.api.callback.Callback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IBaseHorizontalLiveListView {
    void refresh();

    View self();

    void setEmptyListener(Callback<Boolean> callback);

    void setErrorListener(Callback<Boolean> callback);

    void setRoomCountListener(Callback<Integer> callback);
}
