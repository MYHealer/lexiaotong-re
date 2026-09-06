package com.yfanads.android.core.nat;

import com.yfanads.android.callback.BaseExpAdListener;
import com.yfanads.android.model.ExpView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFNativeExpressListener extends BaseExpAdListener<ExpView> {
    void onAdRenderSuccess(List<ExpView> list);
}
