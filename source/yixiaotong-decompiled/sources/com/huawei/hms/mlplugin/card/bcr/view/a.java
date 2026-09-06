package com.huawei.hms.mlplugin.card.bcr.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.huawei.hms.mlplugin.card.bcr.R;

/* JADX INFO: compiled from: Album.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a extends d {
    private Bitmap c;

    public a(Context context, int i, int i2) {
        super(i, i2);
        this.c = BitmapFactory.decodeResource(context.getResources(), R.drawable.mlkit_bcr_album);
    }

    public void a(Canvas canvas, Context context) {
        canvas.save();
        canvas.translate((-b()) >> 1, (-a()) >> 1);
        a(canvas, this.c, 0, 0, b(), a(), 0, 0);
        canvas.restore();
    }
}
