package com.hanhy06.dummyplayer.entities;

import com.hanhy06.dummyplayer.Dummyplayer;
import com.hanhy06.dummyplayer.entities.dummyplayer.entity.DummyPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static EntityType<DummyPlayerEntity> DUMMY_PLAYER = registerEntityType(
            Dummyplayer.MOD_ID,
            "dummy_player",
            DummyPlayerEntity::new,
            SpawnGroup.MISC,
            0.6f,
            1.8f
    );

    protected static <T extends Entity> EntityType<T> registerEntityType(
            String modId,
            String name,
            EntityType.EntityFactory<T> factory,
            SpawnGroup spawnGroup,
            float width,
            float height) {
        // Identifier.of를 사용하여 Identifier 생성
        Identifier id = Identifier.of(modId, name);

        // RegistryKey 생성
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);

        // EntityType 생성 (dimensions 포함)
        EntityType<T> entityType = EntityType.Builder.create(factory, spawnGroup)
                .dimensions(width,height) // 크기 설정
                .build(key);

        // Registry에 등록
        return Registry.register(Registries.ENTITY_TYPE, key, entityType);
    }
}
