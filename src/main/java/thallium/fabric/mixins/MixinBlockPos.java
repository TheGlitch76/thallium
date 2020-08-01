package thallium.fabric.mixins;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(BlockPos.class)
public abstract class MixinBlockPos extends Vec3i {

    public MixinBlockPos(int int_1, int int_2, int int_3) {
        super(int_1, int_2, int_3);
    }

    @Overwrite
    public BlockPos up() {
        return new BlockPos(this.getX(), this.getY() + 1, this.getZ());
    }

    @Overwrite
    public BlockPos up(int int_1) {
        return new BlockPos(this.getX(), this.getY() + int_1, this.getZ());
    }

    @Overwrite
    public BlockPos north() {
        return new BlockPos(this.getX(), this.getY(), this.getZ() - 1);
    }

    @Overwrite
    public BlockPos north(int int_1) {
        return new BlockPos(this.getX(), this.getY(), this.getZ() - int_1);
    }

    @Overwrite
    public BlockPos south() {
        return new BlockPos(this.getX(), this.getY(), this.getZ() + 1);
    }

    @Overwrite
    public BlockPos south(int int_1) {
        return new BlockPos(this.getX(), this.getY(), this.getZ() + int_1);
    }

    @Overwrite
    public BlockPos west() {
        return new BlockPos(this.getX() - 1, this.getY(), this.getZ());
    }

    @Overwrite
    public BlockPos west(int int_1) {
        return new BlockPos(this.getX() - int_1, this.getY(), this.getZ());
    }

    @Overwrite
    public BlockPos east() {
        return new BlockPos(this.getX() + 1, this.getY(), this.getZ());
    }

    @Overwrite
    public BlockPos east(int int_1) {
        return new BlockPos(this.getX() + int_1, this.getY(), this.getZ());
    }

    @Overwrite
    public BlockPos offset(Direction direction_1) {
        switch (direction_1) {
            case UP:
                return new BlockPos(this.getX(), this.getY() + 1, this.getZ());
            case DOWN:
                return new BlockPos(this.getX(), this.getY() - 1, this.getZ());
            case NORTH:
                return new BlockPos(this.getX(), this.getY(), this.getZ() - 1);
            case SOUTH:
                return new BlockPos(this.getX(), this.getY(), this.getZ() + 1);
            case WEST:
                return new BlockPos(this.getX() - 1, this.getY(), this.getZ());
            case EAST:
                return new BlockPos(this.getX() + 1, this.getY(), this.getZ());
            default:
                return new BlockPos(this.getX() + direction_1.getOffsetX(), this.getY() + direction_1.getOffsetY(), this.getZ() + direction_1.getOffsetZ());
        }
    }

}