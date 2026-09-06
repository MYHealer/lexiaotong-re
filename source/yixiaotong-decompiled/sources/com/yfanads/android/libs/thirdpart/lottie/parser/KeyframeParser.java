package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.utils.MiscUtils;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) {
        return z ? parseKeyframe(lottieComposition, jsonReader, f, valueParser) : parseStaticValue(jsonReader, f, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointFJsonToPoint = null;
        PointF pointFJsonToPoint2 = null;
        T t = null;
        T t2 = null;
        PointF pointFJsonToPoint3 = null;
        PointF pointFJsonToPoint4 = null;
        float fNextDouble = 0.0f;
        while (true) {
            boolean z = false;
            while (true) {
                if (!jsonReader.hasNext()) {
                    jsonReader.endObject();
                    if (z) {
                        interpolator = LINEAR_INTERPOLATOR;
                        t2 = t;
                    } else if (pointFJsonToPoint == null || pointFJsonToPoint2 == null) {
                        interpolator = LINEAR_INTERPOLATOR;
                    } else {
                        float f2 = -f;
                        pointFJsonToPoint.x = MiscUtils.clamp(pointFJsonToPoint.x, f2, f);
                        pointFJsonToPoint.y = MiscUtils.clamp(pointFJsonToPoint.y, -100.0f, 100.0f);
                        pointFJsonToPoint2.x = MiscUtils.clamp(pointFJsonToPoint2.x, f2, f);
                        float fClamp = MiscUtils.clamp(pointFJsonToPoint2.y, -100.0f, 100.0f);
                        pointFJsonToPoint2.y = fClamp;
                        int iHashFor = Utils.hashFor(pointFJsonToPoint.x, pointFJsonToPoint.y, pointFJsonToPoint2.x, fClamp);
                        WeakReference<Interpolator> interpolator2 = getInterpolator(iHashFor);
                        Interpolator interpolator3 = interpolator2 != null ? interpolator2.get() : null;
                        if (interpolator2 == null || interpolator3 == null) {
                            Interpolator interpolatorCreate = PathInterpolatorCompat.create(pointFJsonToPoint.x / f, pointFJsonToPoint.y / f, pointFJsonToPoint2.x / f, pointFJsonToPoint2.y / f);
                            try {
                                putInterpolator(iHashFor, new WeakReference(interpolatorCreate));
                            } catch (ArrayIndexOutOfBoundsException unused) {
                            }
                            interpolator = interpolatorCreate;
                        } else {
                            interpolator = interpolator3;
                        }
                    }
                    Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t, t2, interpolator, fNextDouble, null);
                    keyframe.pathCp1 = pointFJsonToPoint3;
                    keyframe.pathCp2 = pointFJsonToPoint4;
                    return keyframe;
                }
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                strNextName.hashCode();
                switch (strNextName) {
                    case "e":
                        t2 = valueParser.parse(jsonReader, f);
                        break;
                    case "h":
                        if (jsonReader.nextInt() == 1) {
                            z = true;
                            break;
                        }
                        break;
                    case "i":
                        pointFJsonToPoint2 = JsonUtils.jsonToPoint(jsonReader, f);
                        break;
                    case "o":
                        pointFJsonToPoint = JsonUtils.jsonToPoint(jsonReader, f);
                        break;
                    case "s":
                        t = valueParser.parse(jsonReader, f);
                        break;
                    case "t":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    case "ti":
                        pointFJsonToPoint4 = JsonUtils.jsonToPoint(jsonReader, f);
                        break;
                    case "to":
                        pointFJsonToPoint3 = JsonUtils.jsonToPoint(jsonReader, f);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
        }
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }
}
