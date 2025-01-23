package com.hanhy06.dummyplayer.entities.dummyplayer.client;

import com.hanhy06.dummyplayer.entities.dummyplayer.entity.DummyPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

public class DummyPlayerEntityRenderer extends EntityRenderer<DummyPlayerEntity,DummyPlayerEntityRenderState> {
    public DummyPlayerEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(DummyPlayerEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(state, matrices, vertexConsumers, light);
    }

    @Override
    public void updateRenderState(DummyPlayerEntity entity, DummyPlayerEntityRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
    }

    @Override
    public DummyPlayerEntityRenderState createRenderState() {
        return new DummyPlayerEntityRenderState();
    }
}
