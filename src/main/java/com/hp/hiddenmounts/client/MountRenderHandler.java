package com.hp.hiddenmounts.client;

import com.hp.hiddenmounts.HiddenMounts;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HiddenMounts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class MountRenderHandler {
    private MountRenderHandler() {
    }

    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && event.getEntity() == minecraft.player.getVehicle()) {
            event.setCanceled(true);
        }
    }
}