package starglas.dsremake.common.items.consumables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import starglas.dsremake.common.CreateCreativeTab;
import starglas.dsremake.common.DSMain;
import starglas.dsremake.common.SoundHandler;
import starglas.dsremake.common.block.ModBlocks;
import starglas.dsremake.common.helpers.Reference;
import starglas.dsremake.common.helpers.RegisterHelper;
import starglas.dsremake.handler.DSPlayerHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Estus extends ItemBucketMilk {

	private float playerHP;
	private float playerMaxHP;
	private int ItemDMG;
	private int ChangedItemDMG;
	private String playerClass;
	private int MaxEstusUses;
	
	public Estus() {
		super();
		this.setCreativeTab(CreateCreativeTab.tabDSConsume);
		this.setTextureName(Reference.MODID + ":myFirstItem");
		this.setMaxStackSize(1);
		this.setMaxDamage(4);
	}

	public int getMaxItemUseDuration(ItemStack Items) {
		return 15;
	}
	public ItemStack onEaten(ItemStack Items, World world, EntityPlayer player) {
		DSPlayerHandler handler = new DSPlayerHandler(player);
		this.playerClass = handler.getPlayerClass();
		SoundHandler.onEntityPlay("ChugThatEstus", world, player, 1, 1);
		player.setHealth((float) (playerHP + (playerMaxHP * 0.40)));
		if(this.playerClass!="taint"){
//			if (!world.isRemote)
//	        {
//	            player.curePotionEffects();
//	        }

		}
		Items.damageItem(1, player);
		this.ChangedItemDMG = Items.getItemDamage();
		if (this.ChangedItemDMG == this.ItemDMG) {
			Items.damageItem(1, player);
		}
		return Items;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Items, World world,
			EntityPlayer player) {
		player.setHealth(10F);
		if(this.ItemDMG != this.MaxEstusUses){
			this.ItemDMG = Items.getItemDamage();
			this.playerMaxHP = player.getMaxHealth();
			this.playerHP = player.getHealth();
			if (this.playerHP < this.playerMaxHP) {
				player.setItemInUse(Items, this.getMaxDamage(Items));
			}
		}
		RegisterHelper.displayChat(player, "HI");
		return Items;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) { // Sets name coloring
		return EnumRarity.rare;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.drink;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) { // Sets enchanting glow
		return true;
	}

	public void refillEstus(ItemStack itemStack, int mark)
	{
		if(mark==1){
			this.setMaxDamage(4);
			this.MaxEstusUses = 4;
			itemStack.setItemDamage(0);
		}
		else if(mark==2){
			this.setMaxDamage(9);
			this.MaxEstusUses = 9;
			itemStack.setItemDamage(0);
		}
		else if(mark==3){
			this.setMaxDamage(14);
			this.MaxEstusUses = 14;
			itemStack.setItemDamage(0);
		}
		else if(mark==4){
			this.setMaxDamage(19);
			this.MaxEstusUses = 19;
			itemStack.setItemDamage(0);
		}
	}
}