package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    private float mAspectRatio;
    private final AspectRatioMeasure.Spec mMeasureSpec;

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public GenericDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context);
        this.mAspectRatio = 0.0f;
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        setHierarchy(genericDraweeHierarchy);
    }

    public GenericDraweeView(Context context) {
        super(context);
        this.mAspectRatio = 0.0f;
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        inflateHierarchy(context, null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAspectRatio = 0.0f;
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAspectRatio = 0.0f;
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        inflateHierarchy(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mAspectRatio = 0.0f;
        this.mMeasureSpec = new AspectRatioMeasure.Spec();
        inflateHierarchy(context, attributeSet);
    }

    private void inflateHierarchy(Context context, @Nullable AttributeSet attributeSet) {
        int i;
        boolean z;
        int resourceId;
        int i2;
        int i3;
        int resourceId2;
        int resourceId3;
        int integer;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i8;
        int i9;
        Resources resources = context.getResources();
        ScalingUtils.ScaleType scaleType = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        ScalingUtils.ScaleType scaleTypeFromXml = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        ScalingUtils.ScaleType scaleTypeFromXml2 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        ScalingUtils.ScaleType scaleTypeFromXml3 = GenericDraweeHierarchyBuilder.DEFAULT_SCALE_TYPE;
        ScalingUtils.ScaleType scaleTypeFromXml4 = GenericDraweeHierarchyBuilder.DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        int i10 = 300;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GenericDraweeView);
            try {
                i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.GenericDraweeView_fadeDuration, 300);
                this.mAspectRatio = typedArrayObtainStyledAttributes.getFloat(R.styleable.GenericDraweeView_viewAspectRatio, this.mAspectRatio);
                int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_placeholderImage, 0);
                ScalingUtils.ScaleType scaleTypeFromXml5 = getScaleTypeFromXml(typedArrayObtainStyledAttributes, R.styleable.GenericDraweeView_placeholderImageScaleType, scaleType);
                int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_retryImage, 0);
                scaleTypeFromXml = getScaleTypeFromXml(typedArrayObtainStyledAttributes, R.styleable.GenericDraweeView_retryImageScaleType, scaleTypeFromXml);
                resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_failureImage, 0);
                scaleTypeFromXml2 = getScaleTypeFromXml(typedArrayObtainStyledAttributes, R.styleable.GenericDraweeView_failureImageScaleType, scaleTypeFromXml2);
                resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_progressBarImage, 0);
                scaleTypeFromXml3 = getScaleTypeFromXml(typedArrayObtainStyledAttributes, R.styleable.GenericDraweeView_progressBarImageScaleType, scaleTypeFromXml3);
                integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.GenericDraweeView_progressBarAutoRotateInterval, 0);
                scaleTypeFromXml4 = getScaleTypeFromXml(typedArrayObtainStyledAttributes, R.styleable.GenericDraweeView_actualImageScaleType, scaleTypeFromXml4);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_backgroundImage, 0);
                int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_overlayImage, 0);
                int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.GenericDraweeView_pressedStateOverlayImage, 0);
                boolean z6 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GenericDraweeView_roundAsCircle, false);
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.GenericDraweeView_roundedCornerRadius, 0);
                boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GenericDraweeView_roundTopLeft, true);
                z3 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GenericDraweeView_roundTopRight, true);
                z4 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GenericDraweeView_roundBottomRight, true);
                z5 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.GenericDraweeView_roundBottomLeft, true);
                int color = typedArrayObtainStyledAttributes.getColor(R.styleable.GenericDraweeView_roundWithOverlayColor, 0);
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.GenericDraweeView_roundingBorderWidth, 0);
                int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.GenericDraweeView_roundingBorderColor, 0);
                typedArrayObtainStyledAttributes.recycle();
                i2 = resourceId6;
                i7 = color2;
                i = resourceId5;
                scaleType = scaleTypeFromXml5;
                i3 = resourceId7;
                i5 = color;
                i4 = dimensionPixelSize;
                i6 = dimensionPixelSize2;
                z2 = z7;
                i8 = resourceId4;
                z = z6;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = 0;
            z = false;
            resourceId = 0;
            i2 = 0;
            i3 = 0;
            resourceId2 = 0;
            resourceId3 = 0;
            integer = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            z2 = true;
            z3 = true;
            z4 = true;
            z5 = true;
            i8 = 0;
        }
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.setFadeDuration(i10);
        if (i8 > 0) {
            genericDraweeHierarchyBuilder.setPlaceholderImage(resources.getDrawable(i8), scaleType);
        }
        if (i > 0) {
            genericDraweeHierarchyBuilder.setRetryImage(resources.getDrawable(i), scaleTypeFromXml);
        }
        if (resourceId2 > 0) {
            genericDraweeHierarchyBuilder.setFailureImage(resources.getDrawable(resourceId2), scaleTypeFromXml2);
        }
        if (resourceId3 > 0) {
            Drawable drawable = resources.getDrawable(resourceId3);
            if (integer > 0) {
                drawable = new AutoRotateDrawable(drawable, integer);
            }
            genericDraweeHierarchyBuilder.setProgressBarImage(drawable, scaleTypeFromXml3);
        }
        if (resourceId > 0) {
            genericDraweeHierarchyBuilder.setBackground(resources.getDrawable(resourceId));
        }
        if (i2 > 0) {
            genericDraweeHierarchyBuilder.setOverlay(resources.getDrawable(i2));
        }
        if (i3 > 0) {
            genericDraweeHierarchyBuilder.setPressedStateOverlay(getResources().getDrawable(i3));
        }
        genericDraweeHierarchyBuilder.setActualImageScaleType(scaleTypeFromXml4);
        int i11 = i4;
        if (z || i11 > 0) {
            RoundingParams roundingParams = new RoundingParams();
            roundingParams.setRoundAsCircle(z);
            if (i11 > 0) {
                roundingParams.setCornersRadii(z2 ? i11 : 0.0f, z3 ? i11 : 0.0f, z4 ? i11 : 0.0f, z5 ? i11 : 0.0f);
            }
            int i12 = i5;
            if (i12 != 0) {
                roundingParams.setOverlayColor(i12);
            }
            int i13 = i7;
            if (i13 != 0 && (i9 = i6) > 0) {
                roundingParams.setBorder(i13, i9);
            }
            genericDraweeHierarchyBuilder.setRoundingParams(roundingParams);
        }
        setHierarchy(genericDraweeHierarchyBuilder.build());
    }

    private static ScalingUtils.ScaleType getScaleTypeFromXml(TypedArray typedArray, int i, ScalingUtils.ScaleType scaleType) {
        int i2 = typedArray.getInt(i, -1);
        return i2 < 0 ? scaleType : ScalingUtils.ScaleType.values()[i2];
    }

    public void setAspectRatio(float f) {
        if (f == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = f;
        requestLayout();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mMeasureSpec.width = i;
        this.mMeasureSpec.height = i2;
        AspectRatioMeasure.updateMeasureSpec(this.mMeasureSpec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
    }
}
