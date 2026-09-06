package com.bykv.vk.component.ttvideo.player;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class TTPlayerPluginLoader {
    public static final int PLUGIN_INTERTRUST_DRM = 100;
    private static IPluginLoader mPluginLoader;

    public static void setPluginLoader(IPluginLoader iPluginLoader) {
        mPluginLoader = iPluginLoader;
    }

    public static ClassLoader loadPlugin(int i) {
        IPluginLoader iPluginLoader = mPluginLoader;
        if (iPluginLoader != null) {
            return iPluginLoader.loadPlugin(i);
        }
        return null;
    }
}
