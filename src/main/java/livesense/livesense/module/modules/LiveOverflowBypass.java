package livesense.livesense.module.modules;

import livesense.livesense.mixin.PlayerMoveC2SPacketAccessor;
import livesense.livesense.mixin.VehicleMoveC2SPacketAccessor;
import livesense.livesense.module.Module;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public class LiveOverflowBypass extends Module {

    public LiveOverflowBypass() {
        super("LiveOverflowBypass", GLFW.GLFW_KEY_L, Category.EXPLOIT);
    }

    @Override
    public void onPacketSend(Packet p) {



        if(p instanceof PlayerMoveC2SPacket){
            double x = ((int)(((PlayerMoveC2SPacket) p).getX(mc.player.getX()) * 100)) / 100.0;
            double z = ((int)(((PlayerMoveC2SPacket) p).getZ(mc.player.getZ()) * 100)) / 100.0;

            ((PlayerMoveC2SPacketAccessor) p).setX(x);
            ((PlayerMoveC2SPacketAccessor) p).setZ(z);
        }

        if(!(mc.player.getVehicle() instanceof BoatEntity boat)){return;}

        if(p instanceof VehicleMoveC2SPacket){
            double boatx = ((int)(((VehicleMoveC2SPacket) p).getX() * 100)) / 100.0;
            double boatz = ((int)(((VehicleMoveC2SPacket) p).getZ() * 100)) / 100.0;

            ((VehicleMoveC2SPacketAccessor) p).setX(boatx);
            ((VehicleMoveC2SPacketAccessor) p).setZ(boatz);
        }

    }
}
