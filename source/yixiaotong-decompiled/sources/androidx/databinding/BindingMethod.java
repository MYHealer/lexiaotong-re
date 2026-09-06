package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
@Target({ElementType.ANNOTATION_TYPE})
public @interface BindingMethod {
    String attribute();

    String method();

    Class type();
}
