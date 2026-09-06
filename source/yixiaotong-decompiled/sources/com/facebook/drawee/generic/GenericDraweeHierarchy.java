package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.SettableDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    private final int mActualImageIndex;
    private final SettableDrawable mActualImageSettableDrawable;
    private final int mControllerOverlayIndex;
    private final Drawable mEmptyActualImageDrawable;
    private final Drawable mEmptyControllerOverlayDrawable;
    private Drawable mEmptyPlaceholderDrawable;
    private final FadeDrawable mFadeDrawable;
    private final int mFailureImageIndex;
    private final int mPlaceholderImageIndex;
    private final int mProgressBarImageIndex;
    private final Resources mResources;
    private final int mRetryImageIndex;
    private RoundingParams mRoundingParams;
    private final RootDrawable mTopLevelDrawable;

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    public static class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {

        @Nullable
        private VisibilityCallback mVisibilityCallback;

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return -1;
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return -1;
        }

        @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
        public void setVisibilityCallback(@Nullable VisibilityCallback visibilityCallback) {
            this.mVisibilityCallback = visibilityCallback;
        }

        public RootDrawable(Drawable drawable) {
            super(drawable);
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            VisibilityCallback visibilityCallback = this.mVisibilityCallback;
            if (visibilityCallback != null) {
                visibilityCallback.onVisibilityChange(z);
            }
            return super.setVisible(z, z2);
        }

        @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (isVisible()) {
                VisibilityCallback visibilityCallback = this.mVisibilityCallback;
                if (visibilityCallback != null) {
                    visibilityCallback.onDraw();
                }
                super.draw(canvas);
            }
        }
    }

    GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i = 0;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.mEmptyActualImageDrawable = colorDrawable;
        this.mEmptyControllerOverlayDrawable = new ColorDrawable(0);
        Resources resources = genericDraweeHierarchyBuilder.getResources();
        this.mResources = resources;
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        int size = genericDraweeHierarchyBuilder.getBackgrounds() != null ? genericDraweeHierarchyBuilder.getBackgrounds().size() : 0;
        Drawable placeholderImage = genericDraweeHierarchyBuilder.getPlaceholderImage();
        Drawable drawableMaybeWrapWithScaleType = maybeWrapWithScaleType(maybeApplyRoundingBitmapOnly(this.mRoundingParams, resources, placeholderImage == null ? getEmptyPlaceholderDrawable() : placeholderImage), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        this.mPlaceholderImageIndex = size;
        SettableDrawable settableDrawable = new SettableDrawable(colorDrawable);
        this.mActualImageSettableDrawable = settableDrawable;
        Drawable drawableMaybeWrapWithMatrix = maybeWrapWithMatrix(maybeWrapWithScaleType(settableDrawable, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint()), genericDraweeHierarchyBuilder.getActualImageMatrix());
        drawableMaybeWrapWithMatrix.setColorFilter(genericDraweeHierarchyBuilder.getActualImageColorFilter());
        this.mActualImageIndex = size + 1;
        Drawable progressBarImage = genericDraweeHierarchyBuilder.getProgressBarImage();
        int i2 = size + 3;
        this.mProgressBarImageIndex = size + 2;
        progressBarImage = progressBarImage != null ? maybeWrapWithScaleType(progressBarImage, genericDraweeHierarchyBuilder.getProgressBarImageScaleType()) : progressBarImage;
        Drawable retryImage = genericDraweeHierarchyBuilder.getRetryImage();
        int i3 = size + 4;
        this.mRetryImageIndex = i2;
        retryImage = retryImage != null ? maybeWrapWithScaleType(retryImage, genericDraweeHierarchyBuilder.getRetryImageScaleType()) : retryImage;
        Drawable failureImage = genericDraweeHierarchyBuilder.getFailureImage();
        int i4 = size + 5;
        this.mFailureImageIndex = i3;
        failureImage = failureImage != null ? maybeWrapWithScaleType(failureImage, genericDraweeHierarchyBuilder.getFailureImageScaleType()) : failureImage;
        int size2 = (genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 0) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        int i5 = i4 + size2;
        this.mControllerOverlayIndex = i5;
        Drawable[] drawableArr = new Drawable[i5 + 1];
        if (size > 0) {
            Iterator<Drawable> it = genericDraweeHierarchyBuilder.getBackgrounds().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                drawableArr[i6] = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, it.next());
                i6++;
            }
        }
        drawableArr[this.mPlaceholderImageIndex] = drawableMaybeWrapWithScaleType;
        drawableArr[this.mActualImageIndex] = drawableMaybeWrapWithMatrix;
        drawableArr[this.mProgressBarImageIndex] = progressBarImage;
        drawableArr[this.mRetryImageIndex] = retryImage;
        drawableArr[this.mFailureImageIndex] = failureImage;
        if (size2 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                Iterator<Drawable> it2 = genericDraweeHierarchyBuilder.getOverlays().iterator();
                while (it2.hasNext()) {
                    drawableArr[i + i4] = it2.next();
                    i++;
                }
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i4 + i] = genericDraweeHierarchyBuilder.getPressedStateOverlay();
            }
        }
        int i7 = this.mControllerOverlayIndex;
        if (i7 >= 0) {
            drawableArr[i7] = this.mEmptyControllerOverlayDrawable;
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        RootDrawable rootDrawable = new RootDrawable(maybeWrapWithRoundedOverlayColor(this.mRoundingParams, fadeDrawable));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.mutate();
        resetFade();
    }

    private static Drawable maybeWrapWithScaleType(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        return maybeWrapWithScaleType(drawable, scaleType, null);
    }

    private static Drawable maybeWrapWithScaleType(Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, @Nullable PointF pointF) {
        Preconditions.checkNotNull(drawable);
        if (scaleType == null) {
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scaleType);
        if (pointF != null) {
            scaleTypeDrawable.setFocusPoint(pointF);
        }
        return scaleTypeDrawable;
    }

    private static Drawable maybeWrapWithMatrix(Drawable drawable, @Nullable Matrix matrix) {
        Preconditions.checkNotNull(drawable);
        return matrix == null ? drawable : new MatrixDrawable(drawable, matrix);
    }

    private static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.getRoundAsCircle());
        rounded.setRadii(roundingParams.getCornersRadii());
        rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
    }

    private static Drawable maybeWrapWithRoundedOverlayColor(@Nullable RoundingParams roundingParams, Drawable drawable) {
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            return drawable;
        }
        RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
        applyRoundingParams(roundedCornersDrawable, roundingParams);
        roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
        return roundedCornersDrawable;
    }

    private static Drawable maybeApplyRoundingBitmapOnly(@Nullable RoundingParams roundingParams, Resources resources, Drawable drawable) {
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY) {
            return drawable;
        }
        if ((drawable instanceof BitmapDrawable) || (drawable instanceof ColorDrawable)) {
            return applyRounding(roundingParams, resources, drawable);
        }
        Drawable drawable2 = drawable;
        for (Drawable current = drawable.getCurrent(); current != null && drawable2 != current; current = current.getCurrent()) {
            if ((drawable2 instanceof ForwardingDrawable) && ((current instanceof BitmapDrawable) || (current instanceof ColorDrawable))) {
                ((ForwardingDrawable) drawable2).setCurrent(applyRounding(roundingParams, resources, current));
            }
            drawable2 = current;
        }
        return drawable;
    }

    private static Drawable applyRounding(@Nullable RoundingParams roundingParams, Resources resources, Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            RoundedBitmapDrawable roundedBitmapDrawableFromBitmapDrawable = RoundedBitmapDrawable.fromBitmapDrawable(resources, (BitmapDrawable) drawable);
            applyRoundingParams(roundedBitmapDrawableFromBitmapDrawable, roundingParams);
            return roundedBitmapDrawableFromBitmapDrawable;
        }
        if (!(drawable instanceof ColorDrawable)) {
            return drawable;
        }
        RoundedColorDrawable roundedColorDrawableFromColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
        applyRoundingParams(roundedColorDrawableFromColorDrawable, roundingParams);
        return roundedColorDrawableFromColorDrawable;
    }

    private void resetActualImages() {
        SettableDrawable settableDrawable = this.mActualImageSettableDrawable;
        if (settableDrawable != null) {
            settableDrawable.setDrawable(this.mEmptyActualImageDrawable);
        }
    }

    private void resetFade() {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            this.mFadeDrawable.fadeInAllLayers();
            fadeOutBranches();
            fadeInLayer(this.mPlaceholderImageIndex);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    private void fadeOutBranches() {
        fadeOutLayer(this.mPlaceholderImageIndex);
        fadeOutLayer(this.mActualImageIndex);
        fadeOutLayer(this.mProgressBarImageIndex);
        fadeOutLayer(this.mRetryImageIndex);
        fadeOutLayer(this.mFailureImageIndex);
    }

    private void fadeInLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeInLayer(i);
        }
    }

    private void fadeOutLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeOutLayer(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setProgress(float f) {
        Drawable layerChildDrawable = getLayerChildDrawable(this.mProgressBarImageIndex);
        if (layerChildDrawable == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (layerChildDrawable instanceof Animatable) {
                ((Animatable) layerChildDrawable).stop();
            }
            fadeOutLayer(this.mProgressBarImageIndex);
        } else {
            if (layerChildDrawable instanceof Animatable) {
                ((Animatable) layerChildDrawable).start();
            }
            fadeInLayer(this.mProgressBarImageIndex);
        }
        layerChildDrawable.setLevel(Math.round(f * 10000.0f));
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        resetActualImages();
        resetFade();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(Drawable drawable, float f, boolean z) {
        Drawable drawableMaybeApplyRoundingBitmapOnly = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, drawable);
        drawableMaybeApplyRoundingBitmapOnly.mutate();
        this.mActualImageSettableDrawable.setDrawable(drawableMaybeApplyRoundingBitmapOnly);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(this.mActualImageIndex);
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float f, boolean z) {
        this.mFadeDrawable.beginBatchMode();
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(this.mFailureImageIndex) != null) {
            fadeInLayer(this.mFailureImageIndex);
        } else {
            fadeInLayer(this.mPlaceholderImageIndex);
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(this.mRetryImageIndex) != null) {
            fadeInLayer(this.mRetryImageIndex);
        } else {
            fadeInLayer(this.mPlaceholderImageIndex);
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = this.mEmptyControllerOverlayDrawable;
        }
        this.mFadeDrawable.setDrawable(this.mControllerOverlayIndex, drawable);
    }

    public void setFadeDuration(int i) {
        this.mFadeDrawable.setTransitionDuration(i);
    }

    private Drawable getLayerDrawable(int i, boolean z) {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        Drawable drawable = fadeDrawable.getDrawable(i);
        if (drawable instanceof MatrixDrawable) {
            fadeDrawable = drawable;
            drawable = drawable.getCurrent();
        }
        if (drawable instanceof ScaleTypeDrawable) {
            fadeDrawable = drawable;
            drawable = drawable.getCurrent();
        }
        return z ? fadeDrawable : drawable;
    }

    @Nullable
    private ScaleTypeDrawable findLayerScaleTypeDrawable(int i) {
        Drawable drawable = this.mFadeDrawable.getDrawable(i);
        if (drawable instanceof MatrixDrawable) {
            drawable = drawable.getCurrent();
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        return null;
    }

    private void setLayerChildDrawable(int i, Drawable drawable) {
        Drawable layerDrawable = getLayerDrawable(i, true);
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (layerDrawable == fadeDrawable) {
            fadeDrawable.setDrawable(i, drawable);
        } else {
            ((ForwardingDrawable) layerDrawable).setCurrent(drawable);
        }
    }

    private Drawable getLayerChildDrawable(int i) {
        return getLayerDrawable(i, false);
    }

    private Drawable getEmptyPlaceholderDrawable() {
        if (this.mEmptyPlaceholderDrawable == null) {
            this.mEmptyPlaceholderDrawable = new ColorDrawable(0);
        }
        return this.mEmptyPlaceholderDrawable;
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        ScaleTypeDrawable scaleTypeDrawableFindLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
        if (scaleTypeDrawableFindLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        scaleTypeDrawableFindLayerScaleTypeDrawable.setFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Preconditions.checkNotNull(scaleType);
        ScaleTypeDrawable scaleTypeDrawableFindLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mActualImageIndex);
        if (scaleTypeDrawableFindLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        scaleTypeDrawableFindLayerScaleTypeDrawable.setScaleType(scaleType);
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.mFadeDrawable.getDrawable(this.mActualImageIndex).setColorFilter(colorFilter);
    }

    public void getActualImageBounds(RectF rectF) {
        this.mActualImageSettableDrawable.getTransformedBounds(rectF);
    }

    public void setPlaceholderImage(Drawable drawable) {
        setPlaceholderImage(drawable, null);
    }

    public void setPlaceholderImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        if (drawable == null) {
            drawable = getEmptyPlaceholderDrawable();
        }
        setDrawableAndScaleType(drawable, scaleType, this.mPlaceholderImageIndex);
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        ScaleTypeDrawable scaleTypeDrawableFindLayerScaleTypeDrawable = findLayerScaleTypeDrawable(this.mPlaceholderImageIndex);
        if (scaleTypeDrawableFindLayerScaleTypeDrawable == null) {
            throw new UnsupportedOperationException("ScaleTypeDrawable not found!");
        }
        scaleTypeDrawableFindLayerScaleTypeDrawable.setFocusPoint(pointF);
    }

    public void setPlaceholderImage(int i) {
        setPlaceholderImage(this.mResources.getDrawable(i));
    }

    public void setFailureImage(Drawable drawable) {
        setFailureImage(drawable, null);
    }

    public void setFailureImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mFailureImageIndex);
    }

    public void setRetryImage(Drawable drawable) {
        setRetryImage(drawable, null);
    }

    public void setRetryImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mRetryImageIndex);
    }

    public void setProgressBarImage(Drawable drawable) {
        setProgressBarImage(drawable, null);
    }

    public void setProgressBarImage(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType) {
        setDrawableAndScaleType(drawable, scaleType, this.mProgressBarImageIndex);
    }

    private void setDrawableAndScaleType(@Nullable Drawable drawable, @Nullable ScalingUtils.ScaleType scaleType, int i) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i, null);
            return;
        }
        Drawable drawableMaybeApplyRoundingBitmapOnly = maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, drawable);
        if (scaleType != null) {
            ScaleTypeDrawable scaleTypeDrawableFindLayerScaleTypeDrawable = findLayerScaleTypeDrawable(i);
            if (scaleTypeDrawableFindLayerScaleTypeDrawable != null) {
                scaleTypeDrawableFindLayerScaleTypeDrawable.setScaleType(scaleType);
            } else {
                drawableMaybeApplyRoundingBitmapOnly = maybeWrapWithScaleType(drawableMaybeApplyRoundingBitmapOnly, scaleType);
            }
        }
        setLayerChildDrawable(i, drawableMaybeApplyRoundingBitmapOnly);
    }

    public void setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        updateOverlayColorRounding();
        updateBitmapOnlyRounding();
    }

    private void updateOverlayColorRounding() {
        Drawable current = this.mTopLevelDrawable.getCurrent();
        RoundingParams roundingParams = this.mRoundingParams;
        if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR) {
            if (current instanceof RoundedCornersDrawable) {
                RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) current;
                applyRoundingParams(roundedCornersDrawable, this.mRoundingParams);
                roundedCornersDrawable.setOverlayColor(this.mRoundingParams.getOverlayColor());
                return;
            } else {
                this.mTopLevelDrawable.setCurrent(maybeWrapWithRoundedOverlayColor(this.mRoundingParams, this.mTopLevelDrawable.setCurrent(this.mEmptyActualImageDrawable)));
                return;
            }
        }
        if (current instanceof RoundedCornersDrawable) {
            this.mTopLevelDrawable.setCurrent(((RoundedCornersDrawable) current).setCurrent(this.mEmptyActualImageDrawable));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateBitmapOnlyRounding() {
        RoundingParams roundingParams = this.mRoundingParams;
        int i = 0;
        if (roundingParams != null && roundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY) {
            while (i < this.mFadeDrawable.getNumberOfLayers()) {
                Drawable layerChildDrawable = getLayerChildDrawable(i);
                if (layerChildDrawable instanceof Rounded) {
                    applyRoundingParams((Rounded) layerChildDrawable, this.mRoundingParams);
                } else if (layerChildDrawable != 0) {
                    setLayerChildDrawable(i, this.mEmptyActualImageDrawable);
                    setLayerChildDrawable(i, maybeApplyRoundingBitmapOnly(this.mRoundingParams, this.mResources, layerChildDrawable));
                }
                i++;
            }
            return;
        }
        while (i < this.mFadeDrawable.getNumberOfLayers()) {
            Object layerChildDrawable2 = getLayerChildDrawable(i);
            if (layerChildDrawable2 instanceof Rounded) {
                resetRoundedDrawable((Rounded) layerChildDrawable2);
            }
            i++;
        }
    }

    private static void resetRoundedDrawable(Rounded rounded) {
        rounded.setCircle(false);
        rounded.setRadius(0.0f);
        rounded.setBorder(0, 0.0f);
    }
}
