package snowmansixtyfour.evergreen.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.enums.EnumBlockSoundEffectType;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

public class DichondriaGrass extends Block {
	public DichondriaGrass(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		if (entity.isSneaking() && entity.yd < 0.0) {
			entity.yd = 0.0;
		}
		else if (entity.yd < 0.0D) {
			world.playBlockSoundEffect((Entity)null, x, y, z, this, EnumBlockSoundEffectType.ENTITY_LAND);
			entity.yd = -entity.yd;
			entity.fallDistance = 0;
		}
	}

	public AABB getCollisionBoundingBoxFromPool (World world,int x, int y, int z){
		return AABB.getBoundingBoxFromPool(x, y, z, (x + 1), y+.9f, (z + 1));
	}
}
