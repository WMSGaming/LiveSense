package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import org.lwjgl.glfw.GLFW;

public class CrystalTriggerBot extends Module {

    public CrystalTriggerBot() {
        super("CrystalTriggerBot", GLFW.GLFW_KEY_G, Category.COMBAT);
    }

    @Override
    public void onTick() {
        if (mc.crosshairTarget != null && mc.crosshairTarget.getType() == HitResult.Type.ENTITY) {
            Entity target = ((EntityHitResult) mc.crosshairTarget).getEntity();

            if (!target.isAlive()) {
                return;
            }

            if (target instanceof EndCrystalEntity) {
                if (mc.player.canSee(target) && mc.player.distanceTo(target) < 5) {
                    mc.interactionManager.attackEntity(mc.player, target);
                    mc.player.swingHand(Hand.MAIN_HAND);
                }
            }
        }
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}

    }

}
