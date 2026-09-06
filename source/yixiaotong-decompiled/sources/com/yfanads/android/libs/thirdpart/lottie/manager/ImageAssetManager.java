package com.yfanads.android.libs.thirdpart.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.yfanads.android.libs.thirdpart.lottie.ImageAssetDelegate;
import com.yfanads.android.libs.thirdpart.lottie.LottieImageAsset;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ImageAssetManager {
    private static final Object bitmapHashLock = new Object();
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.imagesFolder;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.imagesFolder += IOUtils.DIR_SEPARATOR_UNIX;
            }
        }
        if (callback instanceof View) {
            this.context = ((View) callback).getContext();
            this.imageAssets = map;
            setDelegate(imageAssetDelegate);
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
        }
    }

    private Bitmap putBitmap(String str, Bitmap bitmap) {
        synchronized (bitmapHashLock) {
            this.imageAssets.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }

    public Bitmap bitmapForId(String str) {
        String str2;
        Bitmap bitmapDecodeStream;
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.delegate;
        if (imageAssetDelegate != null) {
            Bitmap bitmapFetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (bitmapFetchBitmap != null) {
                putBitmap(str, bitmapFetchBitmap);
            }
            return bitmapFetchBitmap;
        }
        String fileName = lottieImageAsset.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!fileName.startsWith("data:") || fileName.indexOf("base64,") <= 0) {
            try {
                if (TextUtils.isEmpty(this.imagesFolder)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                bitmapDecodeStream = BitmapFactory.decodeStream(this.context.getAssets().open(this.imagesFolder + fileName), null, options);
            } catch (IOException e) {
                e = e;
                str2 = "Unable to open asset.";
                Log.w("LOTTIE", str2, e);
                return null;
            }
        } else {
            try {
                byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                bitmapDecodeStream = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
            } catch (IllegalArgumentException e2) {
                e = e2;
                str2 = "data URL did not have correct base64 format.";
                Log.w("LOTTIE", str2, e);
                return null;
            }
        }
        return putBitmap(str, bitmapDecodeStream);
    }

    public boolean hasSameContext(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    public void recycleBitmaps() {
        synchronized (bitmapHashLock) {
            Iterator<Map.Entry<String, LottieImageAsset>> it = this.imageAssets.entrySet().iterator();
            while (it.hasNext()) {
                LottieImageAsset value = it.next().getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        if (bitmap != null) {
            return putBitmap(str, bitmap);
        }
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        Bitmap bitmap2 = lottieImageAsset.getBitmap();
        lottieImageAsset.setBitmap(null);
        return bitmap2;
    }
}
