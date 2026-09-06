package com.byazt.rb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public enum n {
    TRANSLATE("translate", "translation", OapsKey.KEY_POINT),
    TRANSLATE_X("translateX", "translationX", TypedValues.Custom.S_FLOAT),
    TRANSLATE_Y("translateY", "translationY", TypedValues.Custom.S_FLOAT),
    ROTATE_X("rotateX", "rotationX", TypedValues.Custom.S_FLOAT),
    ROTATE_Y("rotateY", "rotationY", TypedValues.Custom.S_FLOAT),
    ROTATE_Z("rotateZ", Key.ROTATION, TypedValues.Custom.S_FLOAT),
    SCALE("scale", "scale", OapsKey.KEY_POINT),
    SCALE_X("scaleX", "scaleX", TypedValues.Custom.S_FLOAT),
    SCALE_Y("scaleY", "scaleY", TypedValues.Custom.S_FLOAT),
    ALPHA("opacity", "alpha", TypedValues.Custom.S_FLOAT),
    BACKGROUND_COLOR(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL),
    BORDER_RADIUS("borderRadius", "borderRadius", TypedValues.Custom.S_FLOAT),
    RIPPLE("ripple", "ripple", TypedValues.Custom.S_FLOAT),
    SHINE("shine", "shine", TypedValues.Custom.S_FLOAT);

    public final String m;
    public final String nu;
    public final String z;

    public String c() {
        return this.z;
    }

    public String tt() {
        return this.m;
    }

    public String ve() {
        return this.nu;
    }

    n(String str, String str2, String str3) {
        this.z = str;
        this.m = str2;
        this.nu = str3;
    }

    public static n c(String str) {
        str.hashCode();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }
}
