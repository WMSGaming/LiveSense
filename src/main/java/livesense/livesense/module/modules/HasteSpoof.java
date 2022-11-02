package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.lwjgl.glfw.GLFW;
import static net.minecraft.entity.effect.StatusEffects.HASTE;

public class HasteSpoof extends Module {

    public double gamma;

    public HasteSpoof() {
        super("HasteSpoof", GLFW.GLFW_KEY_U, Category.EXPLOIT);
    }

    @Override
    public void onTick(){
        mc.player.addStatusEffect(new StatusEffectInstance(HASTE, 100, 2, false, false, false));

    }
    @Override
    public void onDisable(){
        if(mc.player.hasStatusEffect(HASTE)){
            mc.player.removeStatusEffect(HASTE);
        }
    }
}
