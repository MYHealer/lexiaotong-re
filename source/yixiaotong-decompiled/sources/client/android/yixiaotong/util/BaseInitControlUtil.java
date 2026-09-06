package client.android.yixiaotong.util;

import android.app.ActivityManager;
import android.client.bluetoothsdk.BluetoothSDK;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StrictMode;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.FileUtils;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import com.byazt.hv.TTDownloadField;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.gnete.upbc.cashier.GneteEnv;
import com.gnete.upbc.cashier.GnetePayConfig;
import com.squareup.okhttp.OkHttpClient;
import java.io.File;
import java.net.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaseInitControlUtil {
    public static final boolean DEBUG = false;
    public static final int MAX_IMAGE_DISK_CACHE_SIZE = 524288000;
    public static final int MIN_IMAGE_DISK_CACHE_SIZE = 104857600;
    private Context mContext;

    public String getTmpDirName() {
        return "YKT";
    }

    public void init(Context context) {
        this.mContext = context;
        initImageLoader();
        BluetoothSDK.getInstance().init(context);
        BluetoothSDK.getInstance().isOpenLog(true);
        BluetoothManager.init(context);
        AmmeterBluetoothManager.init(context);
        LeXiaoTongSDK.getInstance().init(context);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
        initAd();
        GnetePayConfig.builder().env(GneteEnv.PRO);
    }

    private void initImageLoader() {
        File httpImageCacheTmpDir = getHttpImageCacheTmpDir();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setProxy(Proxy.NO_PROXY);
        Fresco.initialize(this.mContext, OkHttpImagePipelineConfigFactory.newBuilder(this.mContext, okHttpClient).setMainDiskCacheConfig(DiskCacheConfig.newBuilder().setMaxCacheSize(524288000L).setMaxCacheSizeOnLowDiskSpace(104857600L).setBaseDirectoryName("image").setBaseDirectoryPath(httpImageCacheTmpDir).build()).setBitmapMemoryCacheParamsSupplier(new PetstarBitmapMemoryCacheParamsSupplier(this.mContext)).setEncodedMemoryCacheParamsSupplier(new PetstarBitmapMemoryCacheParamsSupplier(this.mContext)).setDownsampleEnabled(true).setResizeAndRotateEnabledForNetwork(true).setBitmapsConfig(Bitmap.Config.RGB_565).build());
    }

    private static class PetstarBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
        private static final int MAX_CACHE_ENTRIES = 128;
        private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
        private static final int MAX_EVICTION_QUEUE_ENTRIES = 64;
        private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
        private final Context mContext;

        public PetstarBitmapMemoryCacheParamsSupplier(Context context) {
            this.mContext = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.common.internal.Supplier
        public MemoryCacheParams get() {
            return new MemoryCacheParams(calculateMemoryCacheSize(this.mContext), 128, Integer.MAX_VALUE, 64, Integer.MAX_VALUE);
        }

        static int calculateMemoryCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) getService(context, TTDownloadField.TT_ACTIVITY);
            boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
            int memoryClass = activityManager.getMemoryClass();
            if (z) {
                memoryClass = ActivityManagerHoneycomb.getLargeMemoryClass(activityManager);
            }
            return (memoryClass * 1048576) / 5;
        }

        private static class ActivityManagerHoneycomb {
            private ActivityManagerHoneycomb() {
            }

            static int getLargeMemoryClass(ActivityManager activityManager) {
                return activityManager.getLargeMemoryClass();
            }
        }

        static <T> T getService(Context context, String str) {
            return (T) context.getSystemService(str);
        }
    }

    public File getImageTmpDir() {
        File file = new File(getTmpDir(), "image_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.makeNoMediaFile(file);
        return file;
    }

    public File getFaqImageTmpDir() {
        File file = new File(getTmpDir(), "image_faq");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.makeNoMediaFile(file);
        return file;
    }

    public File getHttpImageCacheTmpDir() {
        File file = new File(getTmpDir(), "http_image_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtils.makeNoMediaFile(file);
        return file;
    }

    public File getTmpDir() {
        return getTmpDir(false);
    }

    public File getTmpDir(boolean z) {
        File file;
        boolean zEquals = Environment.getExternalStorageState().equals("mounted");
        if (z && !zEquals && !zEquals) {
            return null;
        }
        if (zEquals || z) {
            file = new File(Environment.getExternalStorageDirectory(), getTmpDirName());
        } else {
            file = new File(this.mContext.getCacheDir(), getTmpDirName());
        }
        File file2 = new File(file, AccountManager.getInstance().getLoginAccount().getUuid());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    private void initAd() {
        LocalBusinessStore.getLoginLicenseTip(this.mContext);
        AdvControlUtil.getInstance().initAd();
    }
}
