package com.meishu.sdk.core.bquery;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.meishu.sdk.core.bquery.e;
import com.meishu.sdk.core.utils.VideoLoadManager;
import com.meishu.sdk.core.utils.c0;
import com.meishu.sdk.core.utils.z;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: AbstractBQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class e<T extends e<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f4771a;
    public Constructor<T> b;
    public View c;
    public View d;

    public e(Activity activity) {
        this.f4771a = activity;
    }

    public T c(int i) {
        View view = this.d;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (i == 0) {
                imageView.setImageBitmap(null);
            } else {
                imageView.setImageResource(i);
            }
        }
        return this;
    }

    public T d(int i) {
        View view = this.d;
        if (view != null && view.getVisibility() != i) {
            this.d.setVisibility(i);
        }
        return this;
    }

    public T a(int i) {
        View viewFindViewById;
        View view = this.c;
        if (view != null) {
            viewFindViewById = view.findViewById(i);
        } else {
            Activity activity = this.f4771a;
            viewFindViewById = activity != null ? activity.findViewById(i) : null;
        }
        if (this.b == null) {
            try {
                this.b = (Constructor<T>) getClass().getConstructor(View.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return this.b.newInstance(viewFindViewById);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public T b(int i) {
        View viewFindViewById;
        View view = this.c;
        if (view != null) {
            viewFindViewById = view.findViewById(i);
        } else {
            Activity activity = this.f4771a;
            viewFindViewById = activity != null ? activity.findViewById(i) : null;
        }
        this.d = viewFindViewById;
        return this;
    }

    public e(View view) {
        this.c = view;
        this.d = view;
    }

    public e(Context context) {
    }

    public T a(CharSequence charSequence) {
        View view = this.d;
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        return this;
    }

    public T a(String str, boolean z) {
        View view = this.d;
        if (view instanceof ImageView) {
            try {
                ImageView imageView = (ImageView) view;
                OkHttpClient okHttpClient = z.f4956a;
                if (imageView != null && str != null) {
                    imageView.setTag(str);
                    com.meishu.sdk.core.cache.a.a(str, new c0(new SoftReference(imageView), str, z), false);
                }
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public void a(String str, int i, boolean z, h<File> hVar) {
        VideoLoadManager videoLoadManager;
        synchronized (VideoLoadManager.class) {
            if (VideoLoadManager.b == null) {
                VideoLoadManager.b = new VideoLoadManager();
            }
            videoLoadManager = VideoLoadManager.b;
        }
        videoLoadManager.a(str, i, z, hVar, false);
    }
}
