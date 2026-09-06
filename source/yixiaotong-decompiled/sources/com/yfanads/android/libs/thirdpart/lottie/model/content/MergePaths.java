package com.yfanads.android.libs.thirdpart.lottie.model.content;

import com.yfanads.android.libs.thirdpart.lottie.L;
import com.yfanads.android.libs.thirdpart.lottie.LottieDrawable;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.Content;
import com.yfanads.android.libs.thirdpart.lottie.animation.content.MergePathsContent;
import com.yfanads.android.libs.thirdpart.lottie.model.layer.BaseLayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class MergePaths implements ContentModel {
    private final MergePathsMode mode;
    private final String name;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i != 4) {
                return i != 5 ? Merge : ExcludeIntersections;
            }
            return Intersect;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.name = str;
        this.mode = mergePathsMode;
    }

    public MergePathsMode getMode() {
        return this.mode;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            return new MergePathsContent(this);
        }
        L.warn("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.mode + '}';
    }
}
