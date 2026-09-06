package cz.msebera.android.httpclient.impl.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface NTLMEngine {
    String generateType1Msg(String str, String str2) throws NTLMEngineException;

    String generateType3Msg(String str, String str2, String str3, String str4, String str5) throws NTLMEngineException;
}
