package com.hihonor.adsdk.base.net.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.g.j.d.f0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.m;
import com.hihonor.adsdk.common.f.a0;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class GlideLoadBuild {
    public static final int LOAD_TYPE_LOAD_IMG_VIEW = 0;
    public static final int LOAD_TYPE_PRE_LOAD = 1;
    private static final String LOG_TAG = "GlideLoadBuild";
    private final boolean isNeedReport;
    private final com.hihonor.adsdk.base.g.j.d.h1.a mAdBaseEventBean;
    private final String mAdUnitId;
    private final List<String> mCommonTrackUrls;
    private final Context mContext;
    private final int mCornerRadius;
    private final int mDefaultDrawableColorId;
    private final b mGlideLoadListener;
    private final ImageView mImageView;
    private boolean mIsReportedFail;
    private final Boolean[] mPartCornerRadius;
    private final c mRequestImageListener;
    private final String mUrl;

    public static final class Builder {
        private com.hihonor.adsdk.base.g.j.d.h1.a adBaseEventBean;
        private String adUnitId;
        private List<String> commonTrackUrls;
        private Context context;
        private int cornerRadius;
        private int defaultDrawableColorId = R.color.honor_ads_magic_color_quaternary;
        private ImageView imageView;
        private boolean isNeedReport;
        private b mGlideLoadListener;
        private Boolean[] partCornerRadius;
        private String url;

        public GlideLoadBuild build() {
            return new GlideLoadBuild(this, null);
        }

        public Builder setAdUnitId(String str) {
            this.adUnitId = str;
            return this;
        }

        public Builder setBaseEventBean(com.hihonor.adsdk.base.g.j.d.h1.a aVar) {
            this.adBaseEventBean = aVar;
            return this;
        }

        public Builder setCommonTrackUrls(List<String> list) {
            this.commonTrackUrls = list;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setCornerRadius(int i) {
            this.cornerRadius = i;
            return this;
        }

        public Builder setDefaultDrawableColorId(int i) {
            this.defaultDrawableColorId = i;
            return this;
        }

        public Builder setGlideLoadListener(b bVar) {
            this.mGlideLoadListener = bVar;
            return this;
        }

        public Builder setImageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder setNeedReport(boolean z) {
            this.isNeedReport = z;
            return this;
        }

        public Builder setPartCornerRadiuss(Boolean[] boolArr) {
            this.partCornerRadius = boolArr;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    public interface b {
        void hnadsa();
    }

    private class c implements RequestListener<Drawable> {
        private int hnadsa;

        private c() {
            this.hnadsa = 0;
        }

        public void hnadsa(int i) {
            this.hnadsa = i;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
            if (GlideLoadBuild.this.mGlideLoadListener != null) {
                GlideLoadBuild.this.mGlideLoadListener.hnadsa();
            }
            String message = glideException != null ? glideException.getMessage() : "";
            com.hihonor.adsdk.common.b.b.hnadsc(GlideLoadBuild.LOG_TAG, "onLoadFailed: msg is " + message + ", loadType is [" + GlideLoadBuild.this.getLoadTypeDesc(this.hnadsa) + "]", new Object[0]);
            if (GlideLoadBuild.this.mIsReportedFail) {
                com.hihonor.adsdk.common.b.b.hnadsc(GlideLoadBuild.LOG_TAG, "The img is reported.", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder("onLoadFailed,this.url is : ");
            sb.append(GlideLoadBuild.this.mUrl).append(",").append(message);
            if (GlideLoadBuild.this.mAdBaseEventBean != null) {
                new f0(GlideLoadBuild.this.mAdUnitId, GlideLoadBuild.this.mAdBaseEventBean, ErrorCode.c.hnadsg, sb.toString()).hnadse();
                if (GlideLoadBuild.this.mCommonTrackUrls == null || GlideLoadBuild.this.mCommonTrackUrls.isEmpty()) {
                    com.hihonor.adsdk.common.b.b.hnadse(GlideLoadBuild.LOG_TAG, "The common track URL list is empty.", new Object[0]);
                } else {
                    new m(ErrorCode.c.hnadsg, sb.toString()).hnadsc(GlideLoadBuild.this.mAdBaseEventBean.hnadsa(), GlideLoadBuild.this.mAdUnitId, GlideLoadBuild.this.mAdBaseEventBean.hnadsk(), GlideLoadBuild.this.mCommonTrackUrls);
                    GlideLoadBuild.this.mIsReportedFail = true;
                }
            }
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            com.hihonor.adsdk.common.b.b.hnadsc(GlideLoadBuild.LOG_TAG, "onResourceReady#LoadType is [" + GlideLoadBuild.this.getLoadTypeDesc(this.hnadsa) + "]", new Object[0]);
            if (GlideLoadBuild.this.mGlideLoadListener != null) {
                GlideLoadBuild.this.mGlideLoadListener.hnadsa();
            }
            return false;
        }

        /* synthetic */ c(GlideLoadBuild glideLoadBuild, a aVar) {
            this();
        }
    }

    /* synthetic */ GlideLoadBuild(Builder builder, a aVar) {
        this(builder);
    }

    private static boolean checkIsDestroyed(Context context) {
        if (!(context instanceof Activity) || !((Activity) context).isDestroyed()) {
            return false;
        }
        new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.GLIDE_EXCEPTION_ACTIVITY_IS_DESTROYED, ErrorCode.GLIDE_EXCEPTION_ACTIVITY_IS_DESTROYED_MSG).hnadse();
        com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "checkIsDestroyed, glide load image exception, activity is destroyed", new Object[0]);
        return true;
    }

    private boolean checkUrlIsEmpty() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVar = this.mAdBaseEventBean;
        com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "checkUrlIsEmpty, mUrl is null adId = " + (aVar != null ? aVar.hnadsa() : ""), new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLoadTypeDesc(int i) {
        if (i != 0) {
            return i != 1 ? "unknow load type." : "Preload type, don't render to imageView";
        }
        return "Default load type will render to imageView";
    }

    private int setCornerRadius(boolean z, int i) {
        if (z) {
            return i;
        }
        return 0;
    }

    /* JADX INFO: renamed from: lambda$loadImage$0$com-hihonor-adsdk-base-net-glide-GlideLoadBuild, reason: not valid java name */
    /* synthetic */ void m894x71acd931() {
        if (checkIsDestroyed(this.mContext)) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "loadImage, activity is destroyed", new Object[0]);
            return;
        }
        this.mRequestImageListener.hnadsa(0);
        if (this.isNeedReport) {
            loadImage(this.mContext, this.mUrl, this.mImageView, this.mCornerRadius, this.mRequestImageListener);
        } else {
            loadImage(this.mContext, this.mUrl, this.mImageView, this.mCornerRadius);
        }
    }

    public void loadImage() {
        checkUrlIsEmpty();
        a0.hnadsc(new Runnable() { // from class: com.hihonor.adsdk.base.net.glide.GlideLoadBuild$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m894x71acd931();
            }
        });
    }

    private GlideLoadBuild(Builder builder) {
        this.mIsReportedFail = false;
        this.mRequestImageListener = new c(this, null);
        this.mContext = builder.context;
        this.mUrl = builder.url;
        this.mAdBaseEventBean = builder.adBaseEventBean;
        this.mAdUnitId = builder.adUnitId;
        this.mImageView = builder.imageView;
        this.mCornerRadius = builder.cornerRadius;
        this.mPartCornerRadius = builder.partCornerRadius;
        this.isNeedReport = builder.isNeedReport;
        this.mCommonTrackUrls = builder.commonTrackUrls;
        this.mDefaultDrawableColorId = builder.defaultDrawableColorId;
        this.mGlideLoadListener = builder.mGlideLoadListener;
    }

    private float[] setDefaultDrawableByPartCorner(Boolean[] boolArr, int i) {
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < boolArr.length; i2++) {
            int i3 = i2 * 2;
            float cornerRadius = setCornerRadius(boolArr[i2].booleanValue(), i);
            fArr[i3] = cornerRadius;
            fArr[i3 + 1] = cornerRadius;
        }
        return fArr;
    }

    public void preload() {
        if (this.mAdBaseEventBean != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "preload enter. adId:" + this.mAdBaseEventBean.hnadsa(), new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "preload enter.", new Object[0]);
        }
        if (checkIsDestroyed(this.mContext)) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "preload, activity is destroyed", new Object[0]);
            return;
        }
        if (checkUrlIsEmpty()) {
            new x(this.mAdUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REPORT_GLIDE_URL_EMPTY, ErrorCode.MSG_REPORT_GLIDE_URL_EMPTY).hnadse();
            return;
        }
        this.mRequestImageListener.hnadsa(1);
        try {
            Glide.with(this.mContext).load(this.mUrl).diskCacheStrategy(DiskCacheStrategy.DATA).listener(this.mRequestImageListener).preload();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "preload fail e = " + e.getMessage(), new Object[0]);
            new x(this.mAdUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REPORT_GLIDE_PRELOAD_EXCEPTION, ErrorCode.MSG_REPORT_GLIDE_LOAD_EXCEPTION + e.getMessage()).hnadse();
        }
    }

    private void loadImage(Context context, String str, ImageView imageView, int i, RequestListener<Drawable> requestListener) {
        RequestOptions requestOptionsTransform;
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(context.getResources().getColor(this.mDefaultDrawableColorId));
            if (i <= 0) {
                Glide.with(context).load(str).error((Drawable) gradientDrawable).addListener(requestListener).into(imageView);
                return;
            }
            Boolean[] boolArr = this.mPartCornerRadius;
            if (boolArr != null && boolArr.length == 4) {
                com.hihonor.adsdk.base.net.glide.a aVar = new com.hihonor.adsdk.base.net.glide.a(context, i);
                aVar.hnadsa(this.mPartCornerRadius[0].booleanValue(), this.mPartCornerRadius[1].booleanValue(), this.mPartCornerRadius[2].booleanValue(), this.mPartCornerRadius[3].booleanValue());
                gradientDrawable.setCornerRadii(setDefaultDrawableByPartCorner(this.mPartCornerRadius, i));
                requestOptionsTransform = new RequestOptions().transform(aVar);
            } else {
                gradientDrawable.setCornerRadius(i);
                requestOptionsTransform = new RequestOptions().transform(new RoundedCorners(i));
            }
            Glide.with(context).load(str).error((Drawable) gradientDrawable).addListener(requestListener).apply((BaseRequestOptions<?>) requestOptionsTransform).into(imageView);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "loadImage listener fail e = " + e.getMessage(), new Object[0]);
            new x(this.mAdUnitId, com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.REPORT_GLIDE_LOAD_EXCEPTION, ErrorCode.MSG_REPORT_GLIDE_LOAD_EXCEPTION + e.getMessage()).hnadse();
        }
    }

    private void loadImage(Context context, String str, ImageView imageView, int i) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(context.getResources().getColor(this.mDefaultDrawableColorId));
            if (i <= 0) {
                Glide.with(context).load(str).error((Drawable) gradientDrawable).into(imageView);
                return;
            }
            gradientDrawable.setCornerRadius(i);
            Glide.with(context).load(str).error((Drawable) gradientDrawable).apply((BaseRequestOptions<?>) new RequestOptions().transform(new RoundedCorners(i))).into(imageView);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(LOG_TAG, "loadImage fail e = " + e.getMessage(), new Object[0]);
        }
    }
}
