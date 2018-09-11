package com.danthought.airhockey.objects;

import com.danthought.airhockey.data.VertexArray;
import com.danthought.airhockey.objects.DrawCommand;
import com.danthought.airhockey.objects.GeneratedData;
import com.danthought.airhockey.objects.ObjectBuilder;
import com.danthought.airhockey.programs.ColorShaderProgram;

import static com.danthought.airhockey.util.Geometry.*;

import java.util.List;

/**
 * Created by danjiang on 2018/8/15.
 */

public class Puck {
    private static final int POSITION_COMPONENT_COUNT = 3;

    public final float radius, height;

    private final VertexArray vertexArray;
    private final List<DrawCommand> drawList;

    public Puck(float radius, float height, int numPointsAroundPuck) {
        GeneratedData generatedData = ObjectBuilder.createPuck(new Cylinder(new Point(0f, 0f, 0f), radius, height), numPointsAroundPuck);

        this.radius = radius;
        this.height = height;

        vertexArray = new VertexArray(generatedData.vertexData);
        drawList = generatedData.drawList;
    }

    public void bindData(ColorShaderProgram colorProgram) {
        vertexArray.setVertexAttribPointer(0,
                colorProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT, 0);
    }

    public void draw() {
        for (DrawCommand drawCommand : drawList) {
            drawCommand.draw();
        }
    }
}
