package com.byazt.xb;

import com.byazt.eg.gr;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 54})
public class ve extends n {
    public final Method c;
    public final Class<?> n;
    public final Method tt;
    public final Class<?> uj;
    public final Method ve;

    public ve(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.c = method;
        this.tt = method2;
        this.ve = method3;
        this.uj = cls;
        this.n = cls2;
    }

    @Override // com.byazt.xb.n
    public void c(SSLSocket sSLSocket, String str, List<gr> list) {
        try {
            this.c.invoke(null, sSLSocket, Proxy.newProxyInstance(n.class.getClassLoader(), new Class[]{this.uj, this.n}, new c(c(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.kh.ve.c("unable to set alpn", (Exception) e);
        }
    }

    @Override // com.byazt.xb.n
    public void tt(SSLSocket sSLSocket) {
        try {
            this.ve.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.kh.ve.c("unable to remove alpn", (Exception) e);
        }
    }

    @Override // com.byazt.xb.n
    public String c(SSLSocket sSLSocket) {
        try {
            c cVar = (c) Proxy.getInvocationHandler(this.tt.invoke(null, sSLSocket));
            if (!cVar.c && cVar.tt == null) {
                tt().c(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            }
            if (cVar.c) {
                return null;
            }
            return cVar.tt;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.byazt.kh.ve.c("unable to get selected protocol", (Exception) e);
        }
    }

    public static n c() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new ve(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 24})
    private static class c implements InvocationHandler {
        public boolean c;
        public String tt;
        public final List<String> ve;

        public c(List<String> list) {
            this.ve = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = com.byazt.kh.ve.tt;
            }
            if ("supports".equals(name) && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if ("unsupported".equals(name) && Void.TYPE == returnType) {
                this.c = true;
                return null;
            }
            if ("protocols".equals(name) && objArr.length == 0) {
                return this.ve;
            }
            if ("selectProtocol".equals(name) || ("select".equals(name) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List))) {
                List list = (List) objArr[0];
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (this.ve.contains(list.get(i))) {
                        String str = (String) list.get(i);
                        this.tt = str;
                        return str;
                    }
                }
                String str2 = this.ve.get(0);
                this.tt = str2;
                return str2;
            }
            if ("protocolSelected".equals(name) || ("selected".equals(name) && objArr.length == 1)) {
                this.tt = (String) objArr[0];
                return null;
            }
            return method.invoke(this, objArr);
        }
    }
}
