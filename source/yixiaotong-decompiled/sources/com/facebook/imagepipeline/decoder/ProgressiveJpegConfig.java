package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ProgressiveJpegConfig {
    int getNextScanNumberToDecode(int i);

    QualityInfo getQualityInfo(int i);
}
