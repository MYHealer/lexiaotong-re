package com.yfanads.android.libs.thirdpart.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import com.stub.StubApp;
import com.yfanads.android.libs.thirdpart.lottie.model.LottieCompositionCache;
import com.yfanads.android.libs.thirdpart.lottie.network.NetworkFetcher;
import com.yfanads.android.libs.thirdpart.lottie.parser.LottieCompositionParser;
import com.yfanads.android.libs.thirdpart.lottie.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable) {
        final LottieComposition lottieComposition = LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieTask<>(new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public LottieResult<LottieComposition> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new LottieResult<>(lottieComposition);
                }
            });
        }
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        LottieTask<LottieComposition> lottieTask = new LottieTask<>(callable);
        lottieTask.addListener(new LottieListener<LottieComposition>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.9
            @Override // com.yfanads.android.libs.thirdpart.lottie.LottieListener
            public void onResult(LottieComposition lottieComposition2) {
                if (str != null) {
                    LottieCompositionCache.getInstance().put(str, lottieComposition2);
                }
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        lottieTask.addFailureListener(new LottieListener<Throwable>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.10
            @Override // com.yfanads.android.libs.thirdpart.lottie.LottieListener
            public void onResult(Throwable th) {
                LottieCompositionFactory.taskCache.remove(str);
            }
        });
        map.put(str, lottieTask);
        return lottieTask;
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str) {
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromAssetSync(origApplicationContext, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? fromZipStreamSync(new ZipInputStream(context.getAssets().open(str)), str2) : fromJsonInputStreamSync(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        });
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        try {
            return fromJsonReaderSync(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                Utils.closeQuietly(inputStream);
            }
        }
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        try {
            LottieComposition lottieComposition = LottieCompositionParser.parse(jsonReader);
            LottieCompositionCache.getInstance().put(str, lottieComposition);
            return new LottieResult<>(lottieComposition);
        } catch (Exception e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(new JsonReader(new StringReader(str)), str2);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i) {
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        return cache(rawResCacheKey(i), new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromRawResSync(origApplicationContext, i);
            }
        });
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        try {
            return fromJsonInputStreamSync(context.getResources().openRawResource(i), rawResCacheKey(i));
        } catch (Resources.NotFoundException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return NetworkFetcher.fetch(context, str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return NetworkFetcher.fetchSync(context, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable<LottieResult<LottieComposition>>() { // from class: com.yfanads.android.libs.thirdpart.lottie.LottieCompositionFactory.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public LottieResult<LottieComposition> call() {
                return LottieCompositionFactory.fromZipStreamSync(zipInputStream, str);
            }
        });
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        try {
            return fromZipStreamSyncInternal(zipInputStream, str);
        } finally {
            Utils.closeQuietly(zipInputStream);
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition value = null;
            while (nextEntry != null) {
                if (!nextEntry.getName().contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        value = fromJsonInputStreamSync(zipInputStream, str, false).getValue();
                    } else if (nextEntry.getName().contains(".png")) {
                        String[] strArrSplit = nextEntry.getName().split("/");
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (value == null) {
                return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                LottieImageAsset lottieImageAssetFindImageAssetForFileName = findImageAssetForFileName(value, (String) entry.getKey());
                if (lottieImageAssetFindImageAssetForFileName != null) {
                    lottieImageAssetFindImageAssetForFileName.setBitmap((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, LottieImageAsset> entry2 : value.getImages().entrySet()) {
                if (entry2.getValue().getBitmap() == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().getFileName()));
                }
            }
            LottieCompositionCache.getInstance().put(str, value);
            return new LottieResult<>(value);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    private static String rawResCacheKey(int i) {
        return "rawRes_" + i;
    }
}
