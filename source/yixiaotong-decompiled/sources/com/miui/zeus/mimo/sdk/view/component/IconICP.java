package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.p6;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class IconICP extends ImageICP {
    public ClickAreaType c;
    public Transformation<Bitmap> d;

    public IconICP(Context context) {
        this(context, null);
    }

    public IconICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = ClickAreaType.TYPE_ICON;
        this.d = new RoundedCorners(f9.a(getContext(), 13.09f));
        int i2 = 0;
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.C1);
                i2 = typedArrayObtainStyledAttributes.getInt(a0.s2, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        }
        setStyle(i2);
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.ImageICP
    public void a(String str, RequestListener<Drawable> requestListener) {
        RequestManager requestManagerWith = Glide.with(y8.f5752a);
        int i = a0.i4;
        Glide.with(y8.f5752a).load(str).error((RequestBuilder<Drawable>) requestManagerWith.load(Integer.valueOf(i)).transform(this.d)).addListener(requestListener).placeholder(getResources().getDrawable(i)).transform(this.d).into(this);
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.ImageICP
    public ClickAreaType getClickAreaType() {
        return this.c;
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.ImageICP
    public void setClickAreaType(ClickAreaType clickAreaType) {
        this.c = clickAreaType;
    }

    public void setStyle(int i) {
        Transformation<Bitmap> roundedCorners;
        switch (i) {
            case 0:
                roundedCorners = new RoundedCorners(f9.a(getContext(), 13.09f));
                this.d = roundedCorners;
                break;
            case 1:
                roundedCorners = new p6(56, 2, Color.parseColor(s.d(new byte[]{66, 4, 0, 14, 11, 8, 88, 93, 95}, "a26721")));
                this.d = roundedCorners;
                break;
            case 2:
                roundedCorners = new RoundedCorners(f9.a(getContext(), 32.0f));
                this.d = roundedCorners;
                break;
            case 3:
                roundedCorners = new RoundedCorners(1);
                this.d = roundedCorners;
                break;
            case 4:
                this.d = new RoundedCorners(f9.a(getContext(), 6.0f));
            case 5:
                this.d = new RoundedCorners(f9.a(getContext(), 4.7f));
            case 6:
                roundedCorners = new RoundedCorners(f9.a(getContext(), 8.7f));
                this.d = roundedCorners;
                break;
        }
    }
}
