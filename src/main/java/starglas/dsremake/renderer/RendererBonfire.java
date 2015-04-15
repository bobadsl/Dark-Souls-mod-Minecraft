package starglas.dsremake.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.models.Bonfire;

public class RendererBonfire extends TileEntitySpecialRenderer{
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/blocks/bonfiretexture.png");
	
	public Bonfire model;

	public RendererBonfire(){
		this.model = new Bonfire();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5F,(float)y + 3F, (float)z + 0.4F);
			GL11.glRotatef(180F, 0F, 0F, 1F);
			GL11.glScalef(2F, 2F, 2F);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				model.renderModel(0.0625F);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}