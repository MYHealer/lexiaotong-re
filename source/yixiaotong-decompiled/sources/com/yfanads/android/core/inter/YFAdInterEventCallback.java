package com.yfanads.android.core.inter;

import android.app.Activity;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.model.template.InterTemplateData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFAdInterEventCallback {
    void bindAdData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder);

    void onAdConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i);

    void onAdExposed();
}
