package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.common.base.Ascii;
import com.kuaishou.weapon.p0.t;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextFrame;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextProperties;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTransform;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.Layer;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LayerParser {
    private LayerParser() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList;
        float f;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String strNextString = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame documentData = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long jNextInt = 0;
        int iDpScale = 0;
        int iDpScale2 = 0;
        int color = 0;
        int iDpScale3 = 0;
        int iDpScale4 = 0;
        float fNextDouble = 1.0f;
        long jNextInt2 = -1;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble4 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals(IAdInterListener.AdReqParam.HEIGHT)) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 7;
                    }
                    break;
                case 3432:
                    if (strNextName.equals(MediationConstant.ADN_KS)) {
                        b = 8;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 9;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = 10;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 11;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        b = 12;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = 13;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = 14;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = 15;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 16;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = 17;
                    }
                    break;
                case 3717:
                    if (strNextName.equals(a.g)) {
                        b = Ascii.DC2;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = 19;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = Ascii.DC4;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = Ascii.NAK;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    continue;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (contentModel != null) {
                            arrayList3.add(contentModel);
                        }
                    }
                    break;
                case 2:
                    iDpScale4 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    continue;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals(t.t)) {
                            documentData = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 4:
                    iDpScale3 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    continue;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    continue;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.getClass();
                            if (strNextName3.equals("nm")) {
                                arrayList4.add(jsonReader.nextString());
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    continue;
                case 7:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    continue;
                case 9:
                    strNextString2 = jsonReader.nextString();
                    continue;
                case 10:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    continue;
                case 11:
                    color = Color.parseColor(jsonReader.nextString());
                    continue;
                case 12:
                    iDpScale2 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    continue;
                case 13:
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                case 14:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 15:
                    iDpScale = (int) (Utils.dpScale() * jsonReader.nextInt());
                    continue;
                case 16:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue;
                case 17:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    continue;
                case 18:
                    int iNextInt = jsonReader.nextInt();
                    layerType = Layer.LayerType.Unknown;
                    if (iNextInt < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt];
                    } else {
                        continue;
                    }
                    break;
                case 19:
                    jNextInt = jsonReader.nextInt();
                    continue;
                case 20:
                    strNextString = jsonReader.nextString();
                    continue;
                case 21:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.endArray();
        }
        jsonReader.endObject();
        float f2 = fNextDouble2 / fNextDouble;
        float endFrame = fNextDouble4 / fNextDouble;
        ArrayList arrayList5 = new ArrayList();
        if (f2 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f2)));
            f = 0.0f;
        } else {
            arrayList = arrayList5;
            f = 0.0f;
        }
        if (endFrame <= f) {
            endFrame = lottieComposition.getEndFrame();
        }
        arrayList.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, f2, Float.valueOf(endFrame)));
        arrayList.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, endFrame, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, lottieComposition, strNextString2, jNextInt, layerType, jNextInt2, strNextString, arrayList2, animatableTransform, iDpScale, iDpScale2, color, fNextDouble, fNextDouble3, iDpScale3, iDpScale4, documentData, animatableTextProperties, arrayList, matteType2, animatableFloatValue);
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PreComp, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, Collections.emptyList(), Layer.MatteType.None, null);
    }
}
