package com.hanhy06.dummyplayer.entities.dummyplayer.client;

import com.hanhy06.dummyplayer.Dummyplayer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.util.Identifier;

public class DummyPlayerEntityModel<T> extends EntityModel<DummyPlayerEntityRenderState> {
    public static final EntityModelLayer DUMMY_PLAYER = new EntityModelLayer(Identifier.of(Dummyplayer.MOD_ID),"dummy_player");

    public static final EntityModelLayer PLAYER_SLIM = new EntityModelLayer(Identifier.ofVanilla("player_slim"),"main");
    public static final EntityModelLayer PLAYER = new EntityModelLayer(Identifier.ofVanilla("player"),"main");
//    public static final EntityModelLayer PLAYER_SLIM = registerMain("player_slim");

    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart jacket;
    private final ModelPart leftSleeve;
    private final ModelPart rightSleeve;
    private final ModelPart leftPants;
    private final ModelPart rightPants;

    private final boolean slimArms;

    public DummyPlayerEntityModel(ModelPart root, boolean slimArms) {
        super(root);
        this.slimArms = slimArms;

        this.head = root.getChild(EntityModelPartNames.HEAD);
        this.hat = this.head.getChild(EntityModelPartNames.HAT);
        this.body = root.getChild(EntityModelPartNames.BODY);
        this.rightArm = root.getChild(EntityModelPartNames.RIGHT_ARM);
        this.leftArm = root.getChild(EntityModelPartNames.LEFT_ARM);
        this.rightLeg = root.getChild(EntityModelPartNames.RIGHT_LEG);
        this.leftLeg = root.getChild(EntityModelPartNames.LEFT_LEG);
        this.jacket = this.body.getChild("jacket");
        this.leftSleeve = this.leftArm.getChild("left_sleeve");
        this.rightSleeve = this.rightArm.getChild("right_sleeve");
        this.leftPants = this.leftLeg.getChild("left_pants");
        this.rightPants = this.rightLeg.getChild("right_pants");
    }

    public static TexturedModelData getTexturedModelData(Dilation dilation, boolean slimArms) {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild(EntityModelPartNames.HEAD,
                ModelPartBuilder.create()
                        .uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.HEAD).addChild(EntityModelPartNames.HAT,
                ModelPartBuilder.create()
                        .uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.5F)),
                ModelTransform.NONE
        );

        root.addChild(EntityModelPartNames.BODY,
                ModelPartBuilder.create()
                        .uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.BODY).addChild("jacket",
                ModelPartBuilder.create()
                        .uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE
        );

        float armWidth = slimArms ? 3.0F : 4.0F;

        root.addChild(EntityModelPartNames.RIGHT_ARM,
                ModelPartBuilder.create()
                        .uv(40, 16).cuboid(-armWidth, -2.0F, -2.0F, armWidth, 12.0F, 4.0F, dilation),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.RIGHT_ARM).addChild("right_sleeve",
                ModelPartBuilder.create()
                        .uv(40, 32).cuboid(-armWidth, -2.0F, -2.0F, armWidth, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE
        );

        root.addChild(EntityModelPartNames.LEFT_ARM,
                ModelPartBuilder.create()
                        .uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, armWidth, 12.0F, 4.0F, dilation),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.LEFT_ARM).addChild("left_sleeve",
                ModelPartBuilder.create()
                        .uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, armWidth, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE
        );

        root.addChild(EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create()
                        .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
                ModelTransform.pivot(-1.9F, 12.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.RIGHT_LEG).addChild("right_pants",
                ModelPartBuilder.create()
                        .uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE
        );

        root.addChild(EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create()
                        .uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
                ModelTransform.pivot(1.9F, 12.0F, 0.0F)
        );

        root.getChild(EntityModelPartNames.LEFT_LEG).addChild("left_pants",
                ModelPartBuilder.create()
                        .uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
                ModelTransform.NONE
        );

        return TexturedModelData.of(modelData, 64, 64);
    }

//    public static ModelData getCustomModelData(Dilation dilation, boolean slim, float pivotOffsetY) {
//        ModelData modelData = new ModelData();
//        ModelPartData modelPartData = modelData.getRoot();
//
//        // Head and Hat
//        ModelPartData headPart = modelPartData.addChild(
//                EntityModelPartNames.HEAD,
//                ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation),
//                ModelTransform.pivot(0.0F, pivotOffsetY, 0.0F)
//        );
//        headPart.addChild(
//                EntityModelPartNames.HAT,
//                ModelPartBuilder.create().uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, dilation.add(0.5F)),
//                ModelTransform.NONE
//        );
//
//        // Body and Jacket
//        ModelPartData bodyPart = modelPartData.addChild(
//                EntityModelPartNames.BODY,
//                ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation),
//                ModelTransform.pivot(0.0F, pivotOffsetY, 0.0F)
//        );
//        bodyPart.addChild(
//                EntityModelPartNames.JACKET,
//                ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                ModelTransform.NONE
//        );
//
//        // Arms (Left and Right)
//        if (slim) {
//            ModelPartData leftArm = modelPartData.addChild(
//                    EntityModelPartNames.LEFT_ARM,
//                    ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, dilation),
//                    ModelTransform.pivot(5.0F, 2.0F + pivotOffsetY, 0.0F)
//            );
//            ModelPartData rightArm = modelPartData.addChild(
//                    EntityModelPartNames.RIGHT_ARM,
//                    ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, dilation),
//                    ModelTransform.pivot(-5.0F, 2.0F + pivotOffsetY, 0.0F)
//            );
//            leftArm.addChild(
//                    "left_sleeve",
//                    ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                    ModelTransform.NONE
//            );
//            rightArm.addChild(
//                    "right_sleeve",
//                    ModelPartBuilder.create().uv(40, 32).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                    ModelTransform.NONE
//            );
//        } else {
//            ModelPartData leftArm = modelPartData.addChild(
//                    EntityModelPartNames.LEFT_ARM,
//                    ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
//                    ModelTransform.pivot(5.0F, 2.0F + pivotOffsetY, 0.0F)
//            );
//            ModelPartData rightArm = modelPartData.addChild(
//                    EntityModelPartNames.RIGHT_ARM,
//                    ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
//                    ModelTransform.pivot(-5.0F, 2.0F + pivotOffsetY, 0.0F)
//            );
//            leftArm.addChild(
//                    "left_sleeve",
//                    ModelPartBuilder.create().uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                    ModelTransform.NONE
//            );
//            rightArm.addChild(
//                    "right_sleeve",
//                    ModelPartBuilder.create().uv(40, 32).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                    ModelTransform.NONE
//            );
//        }
//
//        // Legs (Left and Right)
//        ModelPartData leftLeg = modelPartData.addChild(
//                EntityModelPartNames.LEFT_LEG,
//                ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
//                ModelTransform.pivot(1.9F, 12.0F + pivotOffsetY, 0.0F)
//        );
//        ModelPartData rightLeg = modelPartData.addChild(
//                EntityModelPartNames.RIGHT_LEG,
//                ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation),
//                ModelTransform.pivot(-1.9F, 12.0F + pivotOffsetY, 0.0F)
//        );
//        leftLeg.addChild(
//                "left_pants",
//                ModelPartBuilder.create().uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                ModelTransform.NONE
//        );
//        rightLeg.addChild(
//                "right_pants",
//                ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation.add(0.25F)),
//                ModelTransform.NONE
//        );
//
//        return modelData;
//    }

}
