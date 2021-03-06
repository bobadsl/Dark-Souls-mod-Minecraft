package starglas.dsremake.client.render.block;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import starglas.dsremake.client.models.blocks.bloodstoneore;
import starglas.dsremake.common.helpers.ModVars;

public class BlockRendererBloodstoneOre extends TileEntitySpecialRenderer{
	
	public bloodstoneore model;

	public BlockRendererBloodstoneOre(){
		this.model = new bloodstoneore();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + 1.5F, (float)z + 0.5F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			GL11.glScalef(1F, 1F, 1F);
			this.bindTexture(new ResourceLocation(ModVars.MODID, "textures/blocks/bloodstoneoretexture.png"));
			GL11.glPushMatrix();
				model.renderAll(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
