package com.huawei.agconnect.core.service.auth;

import com.huawei.hmf.tasks.Task;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface CredentialsProvider {
    Task<Token> getTokens();

    Task<Token> getTokens(boolean z);
}
