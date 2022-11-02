package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class PacketFly extends Module {

    public PacketFly() {
        super("PacketFly", GLFW.GLFW_KEY_C, Category.EXPLOIT);
    }

    @Override
    public void onTick() {

        mc.player.setVelocity(0,0,0);

        mc.player.noClip = true;

        float yMotion = 0;

        if (mc.player.age % 4 == 0) {
           yMotion-= 0.03;
        }

        if(mc.player.input.jumping){
            yMotion+=0.05;
        }
        if(mc.player.input.sneaking){
            yMotion-=0.05;
        }

        double x = 0;
        double z = 0;

        if(mc.player.forwardSpeed != 0) {
            double yaw = Math.toRadians(mc.player.getBodyYaw());
            float speed = 0.05f;
            x = -Math.sin(yaw) * speed;
            z = Math.cos(yaw) * speed;


        sendPos(mc.player.getX() + x, mc.player.getY() + yMotion, mc.player.getZ() + z);
        sendPos(mc.player.getX(), mc.player.getY() - 1337, mc.player.getZ());



        }
    }
    public void sendPos(double x, double y, double z) {
        mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.PositionAndOnGround(x,y,z,mc.player.isOnGround()));
    }
    @Override
    public void onDisable(){
        if(nullCheck()){return;}
        mc.player.noClip = false;
    }
}
