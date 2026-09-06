package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class MLBcrCaptureConfig {
    public static final int ERROR_CODE_INIT_CAMERA_FAILED = 10101;
    public static final int ORIENTATION_AUTO = 0;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int RESULT_ALL = 2;
    public static final int RESULT_NUM_ONLY = 0;
    public static final int RESULT_SIMPLE = 1;
    public static final int SIMPLE_MODE = 0;
    public static final int STRICT_MODE = 1;
    public static final int SUCCESS = 0;
    public static final int WEAK_MODE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4160a;
    private final int b;
    private final boolean c;
    private final int d;
    private final boolean e;
    private final String f;
    private final IBlankBlockDrawer g;
    private final IImageLoader h;

    public static final class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4161a = false;
        private int b = 0;
        private int c = 1;
        private int d = 1;
        private boolean e = true;
        private String f = "";
        private String g = "";
        private IBlankBlockDrawer h;
        private IImageLoader i;

        public MLBcrCaptureConfig create() {
            return new MLBcrCaptureConfig(this.f4161a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        public Factory setBlankBlockDrawer(IBlankBlockDrawer iBlankBlockDrawer) {
            this.h = iBlankBlockDrawer;
            return this;
        }

        public Factory setImageLoader(IImageLoader iImageLoader) {
            this.i = iImageLoader;
            return this;
        }

        public Factory setIsShowPortraitStatusBar(boolean z) {
            this.e = z;
            return this;
        }

        public Factory setOrientation(int i) {
            this.b = i;
            return this;
        }

        public Factory setRecMode(int i) {
            this.d = i;
            return this;
        }

        public Factory setResultType(int i) {
            this.c = i;
            return this;
        }
    }

    public interface IBlankBlockDrawer {
        Map<Integer, Rect> draw(Context context, Canvas canvas, Rect rect);

        boolean onClick(Context context, int i);
    }

    public interface IImageLoader {
        void clearMemoryCache();

        void loadImage(ImageView imageView, String str);
    }

    static /* synthetic */ class a {
    }

    /* synthetic */ MLBcrCaptureConfig(boolean z, int i, int i2, int i3, boolean z2, String str, String str2, IBlankBlockDrawer iBlankBlockDrawer, IImageLoader iImageLoader, a aVar) {
        this(z, i, i2, i3, z2, str, str2, iBlankBlockDrawer, iImageLoader);
    }

    public final String a() {
        return this.f;
    }

    public final boolean b() {
        return this.c;
    }

    public final boolean c() {
        return this.e;
    }

    public IBlankBlockDrawer getBlankBlockDrawer() {
        return this.g;
    }

    public IImageLoader getImageLoader() {
        return this.h;
    }

    public final int getOrientation() {
        return this.d;
    }

    public final int getRecMode() {
        return this.b;
    }

    public final int getResultType() {
        return this.f4160a;
    }

    private MLBcrCaptureConfig(boolean z, int i, int i2, int i3, boolean z2, String str, String str2, IBlankBlockDrawer iBlankBlockDrawer, IImageLoader iImageLoader) {
        this.c = z;
        this.d = i;
        this.f4160a = i2;
        this.b = i3;
        this.e = z2;
        this.f = str;
        this.g = iBlankBlockDrawer;
        this.h = iImageLoader;
    }
}
