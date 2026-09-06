package org.videolan.libvlc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class RendererItem extends VLCObject<Event> {
    public static final int LIBVLC_RENDERER_CAN_AUDIO = 1;
    public static final int LIBVLC_RENDERER_CAN_VIDEO = 2;
    public final String displayName;
    public final int flags;
    public final String iconUrl;
    public final String name;
    private final long ref;
    public final String type;

    public static class Event extends VLCEvent {
        public Event(int i) {
            super(i);
        }
    }

    public RendererItem(String str, String str2, String str3, int i, long j) {
        int iLastIndexOf = str.lastIndexOf(45);
        this.name = str;
        this.displayName = iLastIndexOf != -1 ? str.substring(0, iLastIndexOf).replace('-', ' ') : str;
        this.type = str2;
        this.iconUrl = str3;
        this.flags = i;
        this.ref = j;
    }

    public RendererItem(RendererDiscoverer rendererDiscoverer, long j) {
        super(rendererDiscoverer);
        RendererItem rendererItemNativeNewItem = nativeNewItem(rendererDiscoverer, j);
        this.name = rendererItemNativeNewItem == null ? null : rendererItemNativeNewItem.name;
        this.displayName = rendererItemNativeNewItem == null ? null : rendererItemNativeNewItem.displayName;
        this.type = rendererItemNativeNewItem == null ? null : rendererItemNativeNewItem.type;
        this.iconUrl = rendererItemNativeNewItem != null ? rendererItemNativeNewItem.iconUrl : null;
        this.flags = rendererItemNativeNewItem == null ? 0 : rendererItemNativeNewItem.flags;
        this.ref = rendererItemNativeNewItem != null ? rendererItemNativeNewItem.ref : j;
    }

    private native RendererItem nativeNewItem(RendererDiscoverer rendererDiscoverer, long j);

    private native void nativeReleaseItem();

    public boolean equals(Object obj) {
        return (obj instanceof RendererItem) && this.ref == ((RendererItem) obj).ref;
    }

    @Override // org.videolan.libvlc.VLCObject
    public /* bridge */ /* synthetic */ boolean isReleased() {
        return super.isReleased();
    }

    @Override // org.videolan.libvlc.VLCObject
    public Event onEventNative(int i, long j, long j2, long j3, long j4, float f, String str) {
        return new Event(i);
    }

    @Override // org.videolan.libvlc.VLCObject
    public void onReleaseNative() {
        nativeReleaseItem();
    }
}
