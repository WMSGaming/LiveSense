package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import org.lwjgl.glfw.GLFW;

public class Flight extends Module {

    public Flight() {
        super("Flight", GLFW.GLFW_KEY_V, Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().setFlySpeed(0.5f);
        mc.player.setSprinting(true);
        double yMotion = 0;

        if (mc.player.age % 4 == 0) {
            mc.player.setVelocity(mc.player.getVelocity().x,mc.player.getVelocity().y - 0.04,mc.player.getVelocity().z);
        }

        if(mc.player.input.jumping){
            yMotion+=0.02;
        }
        if(mc.player.input.sneaking){
            yMotion-=0.02;
        }

        mc.player.setVelocity(mc.player.getVelocity().x,mc.player.getVelocity().y + yMotion,mc.player.getVelocity().z);
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}
        mc.player.getAbilities().flying = false;
    }

}
