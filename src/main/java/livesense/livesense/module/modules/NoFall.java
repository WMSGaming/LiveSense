package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", GLFW.GLFW_KEY_U, Category.MOVEMENT);
    }

    @Override
    public void onTick() {
        if(mc.player.fallDistance > 5){
            mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(mc.player.getX(),mc.player.getY(),mc.player.getZ(),true));
        }
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}

    }

}
