package com.yfanads.android.libs.thirdpart.lottie.model.layer;

import com.yfanads.android.libs.thirdpart.lottie.LottieComposition;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableFloatValue;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextFrame;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTextProperties;
import com.yfanads.android.libs.thirdpart.lottie.model.animatable.AnimatableTransform;
import com.yfanads.android.libs.thirdpart.lottie.model.content.ContentModel;
import com.yfanads.android.libs.thirdpart.lottie.model.content.Mask;
import com.yfanads.android.libs.thirdpart.lottie.value.Keyframe;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class Layer {
    private final LottieComposition composition;
    private final List<Keyframe<Float>> inOutKeyframes;
    private final long layerId;
    private final String layerName;
    private final LayerType layerType;
    private final List<Mask> masks;
    private final MatteType matteType;
    private final long parentId;
    private final int preCompHeight;
    private final int preCompWidth;
    private final String refId;
    private final List<ContentModel> shapes;
    private final int solidColor;
    private final int solidHeight;
    private final int solidWidth;
    private final float startFrame;
    private final AnimatableTextFrame text;
    private final AnimatableTextProperties textProperties;
    private final AnimatableFloatValue timeRemapping;
    private final float timeStretch;
    private final AnimatableTransform transform;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j;
        this.layerType = layerType;
        this.parentId = j2;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = i;
        this.solidHeight = i2;
        this.solidColor = i3;
        this.timeStretch = f;
        this.startFrame = f2;
        this.preCompWidth = i4;
        this.preCompHeight = i5;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getId() {
        return this.layerId;
    }

    public List<Keyframe<Float>> getInOutKeyframes() {
        return this.inOutKeyframes;
    }

    public LayerType getLayerType() {
        return this.layerType;
    }

    public List<Mask> getMasks() {
        return this.masks;
    }

    public MatteType getMatteType() {
        return this.matteType;
    }

    public String getName() {
        return this.layerName;
    }

    public long getParentId() {
        return this.parentId;
    }

    public int getPreCompHeight() {
        return this.preCompHeight;
    }

    public int getPreCompWidth() {
        return this.preCompWidth;
    }

    public String getRefId() {
        return this.refId;
    }

    public List<ContentModel> getShapes() {
        return this.shapes;
    }

    public int getSolidColor() {
        return this.solidColor;
    }

    public int getSolidHeight() {
        return this.solidHeight;
    }

    public int getSolidWidth() {
        return this.solidWidth;
    }

    public float getStartProgress() {
        return this.startFrame / this.composition.getDurationFrames();
    }

    public AnimatableTextFrame getText() {
        return this.text;
    }

    public AnimatableTextProperties getTextProperties() {
        return this.textProperties;
    }

    public AnimatableFloatValue getTimeRemapping() {
        return this.timeRemapping;
    }

    public float getTimeStretch() {
        return this.timeStretch;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(getName()).append(IOUtils.LINE_SEPARATOR_UNIX);
        Layer layerLayerModelForId = this.composition.layerModelForId(getParentId());
        if (layerLayerModelForId != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2).append(layerLayerModelForId.getName());
                layerLayerModelForId = this.composition.layerModelForId(layerLayerModelForId.getParentId());
                if (layerLayerModelForId == null) {
                    break;
                }
                str2 = "->";
            }
            sb.append(str).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (!getMasks().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(getMasks().size()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (getSolidWidth() != 0 && getSolidHeight() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(getSolidWidth()), Integer.valueOf(getSolidHeight()), Integer.valueOf(getSolidColor())));
        }
        if (!this.shapes.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<ContentModel> it = this.shapes.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }
}
