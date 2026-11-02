package dev.universalleafdecay.mixin;

import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Vanilla: Blaetter mit persistent=true (vom Spieler gesetzt oder aus Axiom-Blueprints)
 * verfallen nie. Hier wird das persistent-Flag ignoriert, sodass jedes Blatt verfaellt,
 * sobald kein Stamm in Reichweite ist (distance == 7).
 */
@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin {

	/** Entscheidet beim Random-Tick, ob das Blatt entfernt wird. */
	@Inject(method = "decaying", at = @At("HEAD"), cancellable = true)
	private void universalleafdecay$ignorePersistentDecaying(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(state.getValue(BlockStateProperties.DISTANCE) == 7);
	}

	/** Sorgt dafuer, dass auch persistente Blaetter ueberhaupt Random-Ticks bekommen. */
	@Inject(method = "isRandomlyTicking", at = @At("HEAD"), cancellable = true)
	private void universalleafdecay$ignorePersistentTicking(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(state.getValue(BlockStateProperties.DISTANCE) == 7);
	}
}
