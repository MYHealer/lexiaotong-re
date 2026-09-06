package com.facebook.imagepipeline.common;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ImageDecodeOptionsBuilder {
    private boolean mDecodeAllFrames;
    private boolean mDecodePreviewFrame;
    private boolean mForceOldAnimationCode;
    private boolean mUseLastFrameForPreview;
    private int mMinDecodeIntervalMs = 100;
    private int mBackgroundColor = ViewCompat.MEASURED_SIZE_MASK;

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getForceOldAnimationCode() {
        return this.mForceOldAnimationCode;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public ImageDecodeOptionsBuilder setBackgroundColor(int i) {
        this.mBackgroundColor = i;
        return this;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean z) {
        this.mDecodeAllFrames = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean z) {
        this.mDecodePreviewFrame = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceOldAnimationCode(boolean z) {
        this.mForceOldAnimationCode = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int i) {
        this.mMinDecodeIntervalMs = i;
        return this;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean z) {
        this.mUseLastFrameForPreview = z;
        return this;
    }

    ImageDecodeOptionsBuilder() {
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.mBackgroundColor = imageDecodeOptions.backgroundColor;
        this.mForceOldAnimationCode = imageDecodeOptions.forceOldAnimationCode;
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        return this;
    }

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }
}
