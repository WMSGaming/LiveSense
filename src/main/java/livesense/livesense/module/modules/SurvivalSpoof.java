package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.world.GameMode;
import org.lwjgl.glfw.GLFW;

public class SurvivalSpoof extends Module {

    public SurvivalSpoof() {
        super("SurvivalSpoof", GLFW.GLFW_KEY_U, Category.EXPLOIT);
    }

    @Override
    public void onTick() {
        mc.interactionManager.setGameMode(GameMode.SURVIVAL);
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}

    }

}
