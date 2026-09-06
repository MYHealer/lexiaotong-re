package com.yfanads.android.utils;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.stub.StubApp;
import com.yfanads.android.libs.thirdpart.transformations.BlurTransformation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class ViewUtils {

    public interface ViewImageCallback {
        void onResourceReady();
    }

    private ViewUtils() {
    }

    private static RequestListener<Drawable> createReadyListener(final ViewImageCallback viewImageCallback) {
        return new RequestListener<Drawable>() { // from class: com.yfanads.android.utils.ViewUtils.2
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                ViewImageCallback viewImageCallback2 = viewImageCallback;
                if (viewImageCallback2 == null) {
                    return false;
                }
                viewImageCallback2.onResourceReady();
                return false;
            }
        };
    }

    private static RequestManager getRequestManager(Object obj, ImageView imageView) {
        if (obj != null && imageView != null && !isEmptyString(obj)) {
            try {
                return Glide.with(StubApp.getOrigApplicationContext(imageView.getContext().getApplicationContext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        try {
            Glide.get(context).setMemoryCategory(MemoryCategory.NORMAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isEmptyString(Object obj) {
        return (obj instanceof String) && TextUtils.isEmpty((String) obj);
    }

    public static boolean isHorizontal(int i, int i2) {
        return i2 > 0 && i / i2 >= 1;
    }

    public static void loadBlurImage(String str, ImageView imageView) {
        loadInto(str, imageView, new RequestOptions().transforms(new FitCenter(), new BlurTransformation(1, 20)), null, false);
    }

    public static void loadBlurImage(String str, ImageView imageView, int i) {
        if (i == 0) {
            i = 1;
        }
        loadInto(str, imageView, RequestOptions.bitmapTransform(new BlurTransformation(i, 20)), null, false);
    }

    public static void loadCircleImage(String str, ImageView imageView, int i) {
        setRadius(imageView, i);
        loadInto(str, imageView, null, null, false);
    }

    public static void loadImage(String str, ImageView imageView) {
        loadInto(str, imageView, null, null, false);
    }

    public static void loadImage(String str, ImageView imageView, ViewImageCallback viewImageCallback) {
        loadInto(str, imageView, null, createReadyListener(viewImageCallback), false);
    }

    public static void loadImageByCircle(String str, ImageView imageView) {
        loadInto(str, imageView, null, null, true);
    }

    public static void loadImageByLocal(int i, ImageView imageView) {
        if (i <= 0) {
            return;
        }
        loadInto(Integer.valueOf(i), imageView, null, null, false);
    }

    private static void loadInto(Object obj, ImageView imageView, RequestOptions requestOptions, RequestListener<Drawable> requestListener, boolean z) {
        RequestManager requestManager = getRequestManager(obj, imageView);
        if (requestManager == null) {
            return;
        }
        try {
            RequestBuilder<Drawable> requestBuilderLoad = requestManager.asDrawable().load(obj);
            if (requestOptions != null) {
                requestBuilderLoad = requestBuilderLoad.apply((BaseRequestOptions<?>) requestOptions);
            }
            if (requestListener != null) {
                requestBuilderLoad = requestBuilderLoad.listener(requestListener);
            }
            if (z) {
                requestBuilderLoad = (RequestBuilder) requestBuilderLoad.circleCrop();
            }
            requestBuilderLoad.into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setRadius(View view, final int i) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.yfanads.android.utils.ViewUtils.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), i);
            }
        });
        view.setClipToOutline(true);
    }

    public static void setViewSize(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }
}
