package com.fancy;

import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Size;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a1 implements _a0 {
    public static final _a1 _a = new _a1();

    public class _a implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ int _a;
        public final /* synthetic */ int _b;

        /* JADX INFO: renamed from: com.fancy._a1$_a$_a, reason: collision with other inner class name */
        public class C0359_a implements ImageDecoder.OnPartialImageListener {
            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public _a(int i, int i2) {
            this._a = i;
            this._b = i2;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            int i;
            int i2;
            imageDecoder.setOnPartialImageListener(new C0359_a());
            Size size = imageInfo.getSize();
            int width = size.getWidth();
            int height = size.getHeight();
            if (width <= 0 || height <= 0 || (i = this._a) <= 0 || (i2 = this._b) <= 0) {
                return;
            }
            if (width > i || height > i2) {
                float f = ((long) width) * ((long) i2) > ((long) i) * ((long) height) ? i / width : i2 / height;
                imageDecoder.setTargetSize(Math.round(size.getWidth() * f), Math.round(f * size.getHeight()));
            }
        }
    }

    @Override // com.fancy._a0
    public final Object _a(_c2 _c2Var) {
        try {
            if (Build.VERSION.SDK_INT >= 28 && _c2Var._a()._c() == 14) {
                int i = _c2Var._a;
                int i2 = _c2Var._b;
                _bz _bzVar_a = _c2Var._a();
                if (_bzVar_a._f == null) {
                    _bzVar_a._f = _bzVar_a._b._b();
                }
                return ImageDecoder.decodeDrawable(ImageDecoder.createSource(ByteBuffer.wrap(_bzVar_a._f)), new _a(i, i2));
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
