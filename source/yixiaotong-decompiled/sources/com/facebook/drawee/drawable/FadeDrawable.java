package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class FadeDrawable extends ArrayDrawable {
    public static final int TRANSITION_NONE = 2;
    public static final int TRANSITION_RUNNING = 1;
    public static final int TRANSITION_STARTING = 0;
    int mAlpha;
    int[] mAlphas;
    int mDurationMs;
    boolean[] mIsLayerOn;
    private final Drawable[] mLayers;
    int mPreventInvalidateCount;
    int[] mStartAlphas;
    long mStartTimeMs;
    int mTransitionState;

    public void beginBatchMode() {
        this.mPreventInvalidateCount++;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    public int getTransitionDuration() {
        return this.mDurationMs;
    }

    public int getTransitionState() {
        return this.mTransitionState;
    }

    public void setTransitionDuration(int i) {
        this.mDurationMs = i;
        if (this.mTransitionState == 1) {
            this.mTransitionState = 0;
        }
    }

    public FadeDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        Preconditions.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.mLayers = drawableArr;
        this.mStartAlphas = new int[drawableArr.length];
        this.mAlphas = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mIsLayerOn = new boolean[drawableArr.length];
        this.mPreventInvalidateCount = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mPreventInvalidateCount == 0) {
            super.invalidateSelf();
        }
    }

    public void endBatchMode() {
        this.mPreventInvalidateCount--;
        invalidateSelf();
    }

    private void resetInternal() {
        this.mTransitionState = 2;
        Arrays.fill(this.mStartAlphas, 0);
        this.mStartAlphas[0] = 255;
        Arrays.fill(this.mAlphas, 0);
        this.mAlphas[0] = 255;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[0] = true;
    }

    public void reset() {
        resetInternal();
        invalidateSelf();
    }

    public void fadeInLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeOutLayer(int i) {
        this.mTransitionState = 0;
        this.mIsLayerOn[i] = false;
        invalidateSelf();
    }

    public void fadeInAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, true);
        invalidateSelf();
    }

    public void fadeOutAllLayers() {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        invalidateSelf();
    }

    public void fadeToLayer(int i) {
        this.mTransitionState = 0;
        Arrays.fill(this.mIsLayerOn, false);
        this.mIsLayerOn[i] = true;
        invalidateSelf();
    }

    public void fadeUpToLayer(int i) {
        this.mTransitionState = 0;
        int i2 = i + 1;
        Arrays.fill(this.mIsLayerOn, 0, i2, true);
        Arrays.fill(this.mIsLayerOn, i2, this.mLayers.length, false);
        invalidateSelf();
    }

    public void finishTransitionImmediately() {
        this.mTransitionState = 2;
        for (int i = 0; i < this.mLayers.length; i++) {
            this.mAlphas[i] = this.mIsLayerOn[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean updateAlphas(float f) {
        boolean z = true;
        for (int i = 0; i < this.mLayers.length; i++) {
            boolean z2 = this.mIsLayerOn[i];
            int i2 = z2 ? 1 : -1;
            int[] iArr = this.mAlphas;
            int i3 = (int) (this.mStartAlphas[i] + (i2 * 255 * f));
            iArr[i] = i3;
            if (i3 < 0) {
                iArr[i] = 0;
            }
            if (iArr[i] > 255) {
                iArr[i] = 255;
            }
            if (z2 && iArr[i] < 255) {
                z = false;
            }
            if (!z2 && iArr[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[LOOP:0: B:25:0x004e->B:27:0x0053, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064 A[EDGE_INSN: B:31:0x0064->B:28:0x0064 BREAK  A[LOOP:0: B:25:0x004e->B:27:0x0053], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean zUpdateAlphas;
        Drawable[] drawableArr;
        int i = this.mTransitionState;
        int i2 = 0;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                Preconditions.checkState(this.mDurationMs > 0);
                zUpdateAlphas = updateAlphas((getCurrentTimeMs() - this.mStartTimeMs) / this.mDurationMs);
                this.mTransitionState = zUpdateAlphas ? 2 : 1;
            }
            while (true) {
                drawableArr = this.mLayers;
                if (i2 < drawableArr.length) {
                    break;
                }
                drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
                i2++;
            }
            if (z) {
            }
            invalidateSelf();
        }
        System.arraycopy(this.mAlphas, 0, this.mStartAlphas, 0, this.mLayers.length);
        this.mStartTimeMs = getCurrentTimeMs();
        zUpdateAlphas = updateAlphas(this.mDurationMs == 0 ? 1.0f : 0.0f);
        this.mTransitionState = zUpdateAlphas ? 2 : 1;
        z = zUpdateAlphas;
        while (true) {
            drawableArr = this.mLayers;
            if (i2 < drawableArr.length) {
                break;
                break;
            } else {
                drawDrawableWithAlpha(canvas, drawableArr[i2], (this.mAlphas[i2] * this.mAlpha) / 255);
                i2++;
            }
        }
        if (z) {
            invalidateSelf();
        }
    }

    private void drawDrawableWithAlpha(Canvas canvas, Drawable drawable, int i) {
        if (drawable == null || i <= 0) {
            return;
        }
        this.mPreventInvalidateCount++;
        drawable.mutate().setAlpha(i);
        this.mPreventInvalidateCount--;
        drawable.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    protected long getCurrentTimeMs() {
        return SystemClock.uptimeMillis();
    }

    public boolean isLayerOn(int i) {
        return this.mIsLayerOn[i];
    }
}
