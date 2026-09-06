package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.q6;
import com.miui.zeus.mimo.sdk.w3;
import com.miui.zeus.mimo.sdk.y8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ImageICP extends ImageView implements h8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ClickAreaType f5702a;
    public boolean b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5703a;

        public a(i8 i8Var) {
            this.f5703a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5703a.onClick(view, ImageICP.this.getClickAreaType());
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5704a;

        public b(i8 i8Var) {
            this.f5704a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5704a;
            if (i8Var != null) {
                i8Var.onClick(view, ImageICP.this.getClickAreaType());
            }
        }
    }

    public class c extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5705a;

        public c(i8 i8Var) {
            this.f5705a = i8Var;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            ImageICP.this.a((Bitmap) null, true, this.f5705a);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition transition) {
            ImageICP.this.a((Bitmap) obj, true, this.f5705a);
        }
    }

    public ImageICP(Context context) {
        this(context, null);
    }

    public ImageICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5702a = ClickAreaType.TYPE_PICTURE;
        this.b = false;
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a0.h4);
                this.b = typedArrayObtainStyledAttributes.getBoolean(a0.I, false);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str, RequestListener<Drawable> requestListener) {
        Glide.with(y8.f5752a).load(str).addListener(requestListener).into(this);
    }

    public void a(String str, i8 i8Var, RequestListener<Drawable> requestListener) {
        a(str, requestListener);
        if (i8Var == null) {
            return;
        }
        setOnClickListener(new a(i8Var));
    }

    public ClickAreaType getClickAreaType() {
        return this.f5702a;
    }

    public void setClickAreaType(ClickAreaType clickAreaType) {
        this.f5702a = clickAreaType;
    }

    public void a(Bitmap bitmap, boolean z, i8 i8Var) {
        if (z) {
            Glide.with(y8.f5752a).load(bitmap).error((Drawable) new ColorDrawable(-16777216)).transform(new q6(25, 8, true, this.b)).into(this);
        } else {
            setImageBitmap(bitmap);
        }
        setOnClickListener(new b(i8Var));
    }

    public void a(MimoAdInfo mimoAdInfo, w3 w3Var, i8 i8Var) {
        String strF = TextUtils.isEmpty(mimoAdInfo.c(w3Var)) ? mimoAdInfo.f() : mimoAdInfo.c(w3Var);
        if (!com.miui.zeus.mimo.sdk.b.g(strF) || w3Var.getVideoBitmap() == null) {
            Glide.with(y8.f5752a).asBitmap().load(strF).into(new c(i8Var));
        } else {
            a(w3Var.getVideoBitmap(), true, i8Var);
        }
    }

    public void a(String str, i8 i8Var) {
        a(str, (RequestListener<Drawable>) null);
        if (i8Var == null) {
            return;
        }
        setOnClickListener(new a(i8Var));
    }
}
