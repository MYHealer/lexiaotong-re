package com.yfanads.android.libs.thirdpart.lottie.utils;

import android.view.Choreographer;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private LottieComposition composition;
    protected boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;
    private long lastFrameTimeNs = 0;
    private float frame = 0.0f;
    private int repeatCount = 0;
    private float minFrame = -2.14748365E9f;
    private float maxFrame = 2.14748365E9f;

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.speed);
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    private void verifyFrame() {
        if (this.composition == null) {
            return;
        }
        float f = this.frame;
        if (f < this.minFrame || f > this.maxFrame) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.minFrame), Float.valueOf(this.maxFrame), Float.valueOf(this.frame)));
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        notifyCancel();
        removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        postFrameCallback();
        if (this.composition == null || !isRunning()) {
            return;
        }
        long jNanoTime = System.nanoTime();
        float frameDurationNs = (jNanoTime - this.lastFrameTimeNs) / getFrameDurationNs();
        float f = this.frame;
        if (isReversed()) {
            frameDurationNs = -frameDurationNs;
        }
        float f2 = f + frameDurationNs;
        this.frame = f2;
        boolean z = !MiscUtils.contains(f2, getMinFrame(), getMaxFrame());
        this.frame = MiscUtils.clamp(this.frame, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = jNanoTime;
        notifyUpdate();
        if (z) {
            if (getRepeatCount() == -1 || this.repeatCount < getRepeatCount()) {
                notifyRepeat();
                this.repeatCount++;
                if (getRepeatMode() == 2) {
                    this.speedReversedForRepeatMode = !this.speedReversedForRepeatMode;
                    reverseAnimationSpeed();
                } else {
                    this.frame = isReversed() ? getMaxFrame() : getMinFrame();
                }
                this.lastFrameTimeNs = jNanoTime;
            } else {
                this.frame = getMaxFrame();
                removeFrameCallback();
                notifyEnd(isReversed());
            }
        }
        verifyFrame();
    }

    public void endAnimation() {
        removeFrameCallback();
        notifyEnd(isReversed());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float maxFrame;
        float minFrame;
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            maxFrame = getMaxFrame();
            minFrame = this.frame;
        } else {
            maxFrame = this.frame;
            minFrame = getMinFrame();
        }
        return (maxFrame - minFrame) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.frame - lottieComposition.getStartFrame()) / (this.composition.getEndFrame() - this.composition.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.maxFrame;
        return f == 2.14748365E9f ? lottieComposition.getEndFrame() : f;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.minFrame;
        return f == -2.14748365E9f ? lottieComposition.getStartFrame() : f;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    public void pauseAnimation() {
        removeFrameCallback();
    }

    public void playAnimation() {
        this.running = true;
        notifyStart(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.lastFrameTimeNs = System.nanoTime();
        this.repeatCount = 0;
        postFrameCallback();
    }

    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    public void resumeAnimation() {
        float minFrame;
        this.running = true;
        postFrameCallback();
        this.lastFrameTimeNs = System.nanoTime();
        if (isReversed() && getFrame() == getMinFrame()) {
            minFrame = getMaxFrame();
        } else if (isReversed() || getFrame() != getMaxFrame()) {
            return;
        } else {
            minFrame = getMinFrame();
        }
        this.frame = minFrame;
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setComposition(LottieComposition lottieComposition) {
        int startFrame;
        float endFrame;
        boolean z = this.composition == null;
        this.composition = lottieComposition;
        if (z) {
            startFrame = (int) Math.max(this.minFrame, lottieComposition.getStartFrame());
            endFrame = Math.min(this.maxFrame, lottieComposition.getEndFrame());
        } else {
            startFrame = (int) lottieComposition.getStartFrame();
            endFrame = lottieComposition.getEndFrame();
        }
        setMinAndMaxFrames(startFrame, (int) endFrame);
        setFrame((int) this.frame);
        this.lastFrameTimeNs = System.nanoTime();
    }

    public void setFrame(int i) {
        float f = i;
        if (this.frame == f) {
            return;
        }
        this.frame = MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
        this.lastFrameTimeNs = System.nanoTime();
        notifyUpdate();
    }

    public void setMaxFrame(int i) {
        setMinAndMaxFrames((int) this.minFrame, i);
    }

    public void setMinAndMaxFrames(int i, int i2) {
        LottieComposition lottieComposition = this.composition;
        float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
        LottieComposition lottieComposition2 = this.composition;
        float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
        float f = i;
        this.minFrame = MiscUtils.clamp(f, startFrame, endFrame);
        float f2 = i2;
        this.maxFrame = MiscUtils.clamp(f2, startFrame, endFrame);
        setFrame((int) MiscUtils.clamp(this.frame, f, f2));
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames(i, (int) this.maxFrame);
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.speedReversedForRepeatMode) {
            return;
        }
        this.speedReversedForRepeatMode = false;
        reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.speed = f;
    }
}
