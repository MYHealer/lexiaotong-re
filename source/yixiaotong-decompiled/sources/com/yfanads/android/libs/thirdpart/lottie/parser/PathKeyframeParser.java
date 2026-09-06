package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.animation.keyframe.PathKeyframe;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    public static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
