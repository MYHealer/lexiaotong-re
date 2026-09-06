package com.kwad.sdk.api.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@KsAdSdkDynamicApi
@Retention(RetentionPolicy.RUNTIME)
public @interface KsAdSdkDynamicImpl {
    Class<?> value();
}
