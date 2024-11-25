package com.sakalti.nocooldown;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("nocooldown")
public class NoCooldownMod {
    public NoCooldownMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().getDirectEntity() instanceof net.minecraft.world.entity.player.Player player) {
            // 攻撃が斧によるものであるか確認
            if (player.getMainHandItem().getItem() instanceof net.minecraft.world.item.AxeItem) {
                // クールダウンを無効化（または何もしない）
                event.setCanceled(true); // 必要ならダメージもキャンセル可能
            }
        }
    }
}
