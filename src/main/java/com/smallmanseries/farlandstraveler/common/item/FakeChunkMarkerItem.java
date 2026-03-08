package com.smallmanseries.farlandstraveler.common.item;

import com.smallmanseries.farlandstraveler.common.misc.FLTAttachments;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

public class FakeChunkMarkerItem extends Item {
    public FakeChunkMarkerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (!level.isClientSide) {
            LevelChunk chunk = level.getChunkAt(pos);
            if(chunk.getData(FLTAttachments.FAKE_CHUNK)) {
                chunk.setData(FLTAttachments.FAKE_CHUNK, false);
                if (player != null) {
                    player.displayClientMessage(Component.literal("该区块现在不是假区块"), true);
                }
            } else {
                chunk.setData(FLTAttachments.FAKE_CHUNK, true);
                if (player != null) {
                    player.displayClientMessage(Component.literal("该区块现在是假区块"), true);
                }
            }
            chunk.markUnsaved();
        }

        return InteractionResult.SUCCESS;
    }

}
