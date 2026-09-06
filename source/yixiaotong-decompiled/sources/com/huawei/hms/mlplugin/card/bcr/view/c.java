package com.huawei.hms.mlplugin.card.bcr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CameraConfig;
import com.huawei.hms.ml.camera.CameraManager;
import com.huawei.hms.mlplugin.card.bcr.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Torch.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c extends d {
    private CameraManager c;
    private int d;
    private Map<String, Bitmap> e;

    public c(Context context, CameraManager cameraManager, int i, int i2) {
        super(i, i2);
        this.d = 0;
        HashMap map = new HashMap();
        this.e = map;
        this.c = cameraManager;
        map.put("flashOnLan", BitmapFactory.decodeResource(context.getResources(), R.drawable.mlkit_bcr_flashon_lan));
        this.e.put("flashLan", BitmapFactory.decodeResource(context.getResources(), R.drawable.mlkit_bcr_flash_lan));
        this.e.put("flashOnPor", BitmapFactory.decodeResource(context.getResources(), R.drawable.mlkit_bcr_flashon_por));
        this.e.put("flashPor", BitmapFactory.decodeResource(context.getResources(), R.drawable.mlkit_bcr_flash_por));
    }

    public int c() {
        return this.d;
    }

    public void a(Canvas canvas, Context context, boolean z, String str) {
        Map<String, Bitmap> map;
        String str2;
        Bitmap bitmap;
        Map<String, Bitmap> map2;
        String str3;
        CameraManager cameraManager = this.c;
        if (cameraManager == null) {
            return;
        }
        if (cameraManager.getTorchStatus().equals(CameraConfig.CAMERA_TORCH_ON)) {
            if (z) {
                map2 = this.e;
                str3 = "flashOnLan";
            } else {
                map2 = this.e;
                str3 = "flashOnPor";
            }
            bitmap = map2.get(str3);
        } else {
            if (z) {
                map = this.e;
                str2 = "flashLan";
            } else {
                map = this.e;
                str2 = "flashPor";
            }
            bitmap = map.get(str2);
        }
        canvas.save();
        canvas.translate((-b()) >> 1, (-a()) >> 1);
        a(canvas, bitmap, 0, 0, b(), a(), 0, 0);
        if (z) {
            this.d = 0;
        } else {
            if (TextUtils.isEmpty(str)) {
                str = context.getResources().getString(R.string.mlkit_bcr_turn_on_light);
            }
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.mlkit_bcr_torch_font_size);
            Paint paint = new Paint(1);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(context.getResources().getColor(R.color.mlkit_bcr_tips_color));
            paint.setShadowLayer(3.0f, 1.0f, 1.0f, -16777216);
            paint.setTextSize(dimensionPixelOffset);
            Rect rect = new Rect();
            paint.getTextBounds(str, 0, str.length(), rect);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mlkit_bcr_torch_tips_margin_top);
            canvas.translate(b() >> 1, a() + dimensionPixelSize);
            canvas.drawText(str, 0.0f, rect.height(), paint);
            this.d = rect.height() + (dimensionPixelSize << 1);
        }
        canvas.restore();
    }
}
