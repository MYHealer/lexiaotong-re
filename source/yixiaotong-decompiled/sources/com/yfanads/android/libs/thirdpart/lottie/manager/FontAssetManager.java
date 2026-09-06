package com.yfanads.android.libs.thirdpart.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.yfanads.android.libs.thirdpart.lottie.FontAssetDelegate;
import com.yfanads.android.libs.thirdpart.lottie.model.MutablePair;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FontAssetManager {
    private final AssetManager assetManager;
    private FontAssetDelegate delegate;
    private final MutablePair<String> tempPair = new MutablePair<>();
    private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
    private final Map<String, Typeface> fontFamilies = new HashMap();
    private String defaultFontFileExtension = ".ttf";

    public FontAssetManager(Drawable.Callback callback, FontAssetDelegate fontAssetDelegate) {
        AssetManager assets;
        this.delegate = fontAssetDelegate;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.assetManager = assets;
    }

    private Typeface getFontFamily(String str) {
        String fontPath;
        Typeface typeface = this.fontFamilies.get(str);
        if (typeface != null) {
            return typeface;
        }
        FontAssetDelegate fontAssetDelegate = this.delegate;
        Typeface typefaceFetchFont = fontAssetDelegate != null ? fontAssetDelegate.fetchFont(str) : null;
        FontAssetDelegate fontAssetDelegate2 = this.delegate;
        if (fontAssetDelegate2 != null && typefaceFetchFont == null && (fontPath = fontAssetDelegate2.getFontPath(str)) != null) {
            typefaceFetchFont = Typeface.createFromAsset(this.assetManager, fontPath);
        }
        if (typefaceFetchFont == null) {
            typefaceFetchFont = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.defaultFontFileExtension);
        }
        this.fontFamilies.put(str, typefaceFetchFont);
        return typefaceFetchFont;
    }

    private Typeface typefaceForStyle(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else {
            i = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public Typeface getTypeface(String str, String str2) {
        this.tempPair.set(str, str2);
        Typeface typeface = this.fontMap.get(this.tempPair);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceTypefaceForStyle = typefaceForStyle(getFontFamily(str), str2);
        this.fontMap.put(this.tempPair, typefaceTypefaceForStyle);
        return typefaceTypefaceForStyle;
    }

    public void setDefaultFontFileExtension(String str) {
        this.defaultFontFileExtension = str;
    }

    public void setDelegate(FontAssetDelegate fontAssetDelegate) {
        this.delegate = fontAssetDelegate;
    }
}
