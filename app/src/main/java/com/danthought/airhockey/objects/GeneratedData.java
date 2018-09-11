package com.danthought.airhockey.objects;

import java.util.List;

/**
 * Created by danjiang on 2018/8/15.
 */

public class GeneratedData {
    final float[] vertexData;
    final List<DrawCommand> drawList;

    public GeneratedData(float[] vertexData, List<DrawCommand> drawList) {
        this.vertexData = vertexData;
        this.drawList = drawList;
    }
}
