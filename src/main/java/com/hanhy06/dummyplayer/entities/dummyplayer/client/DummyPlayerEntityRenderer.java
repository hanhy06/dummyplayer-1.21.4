package com.hanhy06.dummyplayer.entities.dummyplayer.client;

import com.hanhy06.dummyplayer.entities.dummyplayer.entity.DummyPlayerEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;

import static net.minecraft.client.util.DefaultSkinHelper.getTexture;

public class DummyPlayerEntityRenderer extends EntityRenderer<DummyPlayerEntity,DummyPlayerEntityRenderState> {
    private static final DummyPlayerEntityModel model = new DummyPlayerEntityModel(DummyPlayerEntityModel.getTexturedModelData(new Dilation(1),false).createModel(), false);

    public DummyPlayerEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(DummyPlayerEntityRenderState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(getTexture()));
        model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, -1);

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
