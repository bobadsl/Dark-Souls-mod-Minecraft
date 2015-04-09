package starglas.dsremake.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.models.Bonfire;
import starglas.dsremake.common.models.LongswordModel;

public class ItemRendererBlockBonfire implements IItemRenderer {

	public Bonfire model;
	
	public ItemRendererBlockBonfire(){
		model = new Bonfire();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch(type){
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
		case INVENTORY:
			GL11.glPushMatrix();
			
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID,"textures/blocks/bonfiretexture.png"));
				
				/*GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
				
				GL11.glTranslatef(0F, -1.5F, 0.65F);*/
				
				model.render((Entity)data[1],0.0F,0.0F,0.0F,0.0F,0.0F,0.0625F);
				
			GL11.glPopMatrix();
		default:
			break;
		}

	}

}
