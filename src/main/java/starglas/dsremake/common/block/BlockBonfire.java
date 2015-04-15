package starglas.dsremake.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.SoundHandler;

public class BlockBonfire extends BlockContainer{

	protected BlockBonfire() {
		super(Material.ground);
		this.setCreativeTab(CreateCreativeTab.tabDSBlocks);
		this.setHardness(0.5F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1.3F, 1F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int inter) {
		return new TileEntityBonfire();
	}
	
	public  
	int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	public boolean onBlockActivated(World world, int X, int Y, int Z, EntityPlayer player, int par6, float par7, float par8, float par9){
		System.out.println("Thou has activated thy bonfire");
		SoundHandler.onEntityPlay("BonfireLit", world, player, 1, 1);
		return false;
	}
	
	
	/*@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon){	
		this.blockIcon = icon.registerIcon(ModBlocks.blockBonfire);
	}*/
	
	
}