package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class AuthOption {
    private final AuthScheme authScheme;
    private final Credentials creds;

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.creds;
    }

    public AuthOption(AuthScheme authScheme, Credentials credentials) {
        Args.notNull(authScheme, "Auth scheme");
        Args.notNull(credentials, "User credentials");
        this.authScheme = authScheme;
        this.creds = credentials;
    }

    public String toString() {
        return this.authScheme.toString();
    }
}
