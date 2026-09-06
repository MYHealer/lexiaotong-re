package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@Target({ElementType.METHOD})
public @interface BindingAdapter {
    boolean requireAll() default true;

    String[] value();
}
