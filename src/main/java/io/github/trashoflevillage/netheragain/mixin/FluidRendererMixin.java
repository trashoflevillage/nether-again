package io.github.trashoflevillage.netheragain.mixin;

import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FluidRenderer.class)
public class FluidRendererMixin {
	@ModifyConstant(method = "render", constant = @Constant(intValue = 16777215, ordinal = 0))
	private int modifyLavaColor(int original) {
		return original & 0xFFFFFF;
	}
}