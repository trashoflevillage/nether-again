package io.github.trashoflevillage.netheragain.entities.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class NetherMoleEntity extends HostileEntity {
    protected NetherMoleEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
}
