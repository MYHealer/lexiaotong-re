package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ControllerListener<INFO> {
    void onFailure(String str, Throwable th);

    void onFinalImageSet(String str, @Nullable INFO info, @Nullable Animatable animatable);

    void onIntermediateImageFailed(String str, Throwable th);

    void onIntermediateImageSet(String str, @Nullable INFO info);

    void onRelease(String str);

    void onSubmit(String str, Object obj);
}
