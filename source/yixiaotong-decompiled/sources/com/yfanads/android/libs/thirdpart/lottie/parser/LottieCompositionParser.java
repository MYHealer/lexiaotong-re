package com.yfanads.android.libs.thirdpart.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.LottieImageAsset;
import com.yfanads.android.libs.thirdpart.lottie.model.Font;
import com.yfanads.android.libs.thirdpart.lottie.model.FontCharacter;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.Layer;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    public static LottieComposition parse(JsonReader jsonReader) {
        SparseArrayCompat<FontCharacter> sparseArrayCompat;
        HashMap map;
        float fDpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        SparseArrayCompat<FontCharacter> sparseArrayCompat2 = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            strNextName.hashCode();
            switch (strNextName) {
                case "assets":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    parseAssets(jsonReader, lottieComposition, map2, map3);
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "layers":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    parseLayers(jsonReader, lottieComposition, arrayList, longSparseArray);
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "h":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "v":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "w":
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case "fr":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "op":
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "chars":
                    parseChars(jsonReader, lottieComposition, sparseArrayCompat2);
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                case "fonts":
                    parseFonts(jsonReader, map4);
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
                default:
                    jsonReader.skipValue();
                    sparseArrayCompat = sparseArrayCompat2;
                    map = map4;
                    map4 = map;
                    sparseArrayCompat2 = sparseArrayCompat;
                    break;
            }
        }
        jsonReader.endObject();
        lottieComposition.init(new Rect(0, 0, (int) (iNextInt2 * fDpScale), (int) (iNextInt * fDpScale)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map2, map3, sparseArrayCompat2, map4);
        return lottieComposition;
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                strNextName.hashCode();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
                            longSparseArray.put(layer.getId(), layer);
                            arrayList.add(layer);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter fontCharacter = FontCharacterParser.parse(jsonReader, lottieComposition);
            sparseArrayCompat.put(fontCharacter.hashCode(), fontCharacter);
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font font = FontParser.parse(jsonReader);
                    map.put(font.getName(), font);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
            if (layer.getLayerType() == Layer.LayerType.Image) {
                i++;
            }
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
            if (i > 4) {
                L.warn("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
