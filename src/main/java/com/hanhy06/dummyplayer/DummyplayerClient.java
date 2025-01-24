package com.hanhy06.dummyplayer;

import com.hanhy06.dummyplayer.entities.ModEntities;
import com.hanhy06.dummyplayer.entities.dummyplayer.client.DummyPlayerEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DummyplayerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DUMMY_PLAYER, DummyPlayerEntityRenderer::new);
    }
}
