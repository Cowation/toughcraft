package me.derpee.toughcraft;

import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Hoglin;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Husk;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Vindicator;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.entity.Zoglin;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Listeners implements Listener {
	Plugin plugin = ToughCraft.getPlugin(ToughCraft.class);

	@EventHandler(priority = EventPriority.HIGH)
	public void spawnEvent(EntitySpawnEvent event) {		
		if (event.getEntityType() == EntityType.ZOMBIE) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Zombie zombie = (Zombie) event.getEntity();
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			zombie.getEquipment().setHelmet(helmet);
			zombie.getEquipment().setChestplate(chestplate);
			zombie.getEquipment().setLeggings(leggings);
			zombie.getEquipment().setBoots(boots);
			
			double percent = Math.random();
			
			if (percent > 0.995) {
				ItemStack sensor = new ItemStack(Material.DAYLIGHT_DETECTOR);
				zombie.getEquipment().setItemInMainHand(sensor);
				zombie.getEquipment().setItemInMainHandDropChance(0.01f);
			} else {
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
				zombie.getEquipment().setItemInMainHand(sword);
				zombie.getEquipment().setItemInMainHandDropChance(0f);
			}
		}
		
		if (event.getEntityType() == EntityType.ZOMBIE_VILLAGER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			ZombieVillager zombieVillager = (ZombieVillager) event.getEntity();
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			zombieVillager.getEquipment().setHelmet(helmet);
			zombieVillager.getEquipment().setChestplate(chestplate);
			zombieVillager.getEquipment().setLeggings(leggings);
			zombieVillager.getEquipment().setBoots(boots);
			
			double percent = Math.random();
			
			if (percent > 0.995) {
				ItemStack sensor = new ItemStack(Material.DAYLIGHT_DETECTOR);
				zombieVillager.getEquipment().setItemInMainHand(sensor);
				zombieVillager.getEquipment().setItemInMainHandDropChance(0.01f);
			} else {
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
				zombieVillager.getEquipment().setItemInMainHand(sword);
				zombieVillager.getEquipment().setItemInMainHandDropChance(0f);
			}
		}
		
		if (event.getEntityType() == EntityType.SKELETON) {
			if (plugin.getConfig().getBoolean("opMobs") == false) {
				if (plugin.getConfig().getBoolean("superSkeletons") == true) {
					// OpMobs OFF, SS ON
					Skeleton skeleton = (Skeleton) event.getEntity();
					
					ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					
					LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
					helmMeta.setColor(Color.fromRGB(58, 179, 218));
					helmet.setItemMeta(helmMeta);
					
					LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
					chestMeta.setColor(Color.fromRGB(58, 179, 218));
					chestplate.setItemMeta(chestMeta);
					
					LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
					legsMeta.setColor(Color.fromRGB(58, 179, 218));
					leggings.setItemMeta(legsMeta);
					
					LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
					bootsMeta.setColor(Color.fromRGB(58, 179, 218));
					boots.setItemMeta(bootsMeta);
					
					helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					helmet.addEnchantment(Enchantment.OXYGEN, 1);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
					boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					
					skeleton.getEquipment().setHelmet(helmet);
					skeleton.getEquipment().setChestplate(chestplate);
					skeleton.getEquipment().setLeggings(leggings);
					skeleton.getEquipment().setBoots(boots);
					
					ItemStack bow = new ItemStack(Material.BOW);
					bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
					bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
					
					skeleton.getEquipment().setItemInMainHand(bow);
					skeleton.getEquipment().setItemInMainHandDropChance(0f);
					
					Spider spider = (Spider) skeleton.getWorld().spawnEntity(skeleton.getLocation(), EntityType.SPIDER);
					spider.addPassenger(skeleton);
					
					return;
				} else {
					// OpMobs OFF, SS OFF
					return;
				}
			} else {
				if (plugin.getConfig().getBoolean("superSkeletons") == true) {
					// OpMobs ON, SS ON
					Skeleton skeleton = (Skeleton) event.getEntity();
					
					ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					
					LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
					helmMeta.setColor(Color.fromRGB(58, 179, 218));
					helmet.setItemMeta(helmMeta);
					
					LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
					chestMeta.setColor(Color.fromRGB(58, 179, 218));
					chestplate.setItemMeta(chestMeta);
					
					LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
					legsMeta.setColor(Color.fromRGB(58, 179, 218));
					leggings.setItemMeta(legsMeta);
					
					LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
					bootsMeta.setColor(Color.fromRGB(58, 179, 218));
					boots.setItemMeta(bootsMeta);
					
					helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					helmet.addEnchantment(Enchantment.OXYGEN, 1);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
					boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
					
					skeleton.getEquipment().setHelmet(helmet);
					skeleton.getEquipment().setChestplate(chestplate);
					skeleton.getEquipment().setLeggings(leggings);
					skeleton.getEquipment().setBoots(boots);
					
					ItemStack bow = new ItemStack(Material.BOW);
					bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
					bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
					
					skeleton.getEquipment().setItemInMainHand(bow);
					skeleton.getEquipment().setItemInMainHandDropChance(0f);
					
					Spider spider = (Spider) skeleton.getWorld().spawnEntity(skeleton.getLocation(), EntityType.SPIDER);
					spider.addPassenger(skeleton);
					
					return;
				} else {
					// OpMobs ON, SS OFF
					Skeleton skeleton = (Skeleton) event.getEntity();
					
					ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
					ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
					ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
					ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
					
					LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
					helmMeta.setColor(Color.WHITE);
					helmet.setItemMeta(helmMeta);
					
					LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
					chestMeta.setColor(Color.SILVER);
					chestplate.setItemMeta(chestMeta);
					
					LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
					legsMeta.setColor(Color.GRAY);
					leggings.setItemMeta(legsMeta);
					
					LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
					bootsMeta.setColor(Color.BLACK);
					boots.setItemMeta(bootsMeta);
					
					helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					helmet.addEnchantment(Enchantment.OXYGEN, 1);
					chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
					boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
					
					skeleton.getEquipment().setHelmet(helmet);
					skeleton.getEquipment().setChestplate(chestplate);
					skeleton.getEquipment().setLeggings(leggings);
					skeleton.getEquipment().setBoots(boots);
					
					ItemStack bow = new ItemStack(Material.BOW);
					bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
					bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
					
					skeleton.getEquipment().setItemInMainHand(bow);
					skeleton.getEquipment().setItemInMainHandDropChance(0f);
					
					return;
				}
			}
		}
		
		if (event.getEntityType() == EntityType.CREEPER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Creeper creeper = (Creeper) event.getEntity();
			
			creeper.setPowered(true);
		}
		
		if (event.getEntityType() == EntityType.ENDERMAN) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			Enderman enderman = (Enderman) event.getEntity();
			
			enderman.setTarget(playerList.get(new Random().nextInt(playerList.size())));
			
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			effect.apply(enderman);
		}
		 
		if (event.getEntityType() == EntityType.SPIDER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) {
				if (plugin.getConfig().getBoolean("superSkeletons") == true) {
					// OpMobs OFF, SS ON
					List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
					Spider spider = (Spider) event.getEntity();
					
					spider.setTarget(playerList.get(new Random().nextInt(playerList.size())));
					
					PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 3);
					effect.apply(spider);
				} else {
					// OpMobs OFF, SS OFF
					return;
				}
			} else {
				if (plugin.getConfig().getBoolean("superSkeletons") == true) {
					// OpMobs ON, SS ON
					List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
					Spider spider = (Spider) event.getEntity();
					
					spider.setTarget(playerList.get(new Random().nextInt(playerList.size())));
					
					PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 3);
					effect.apply(spider);
				} else {
					// OpMobs ON, SS OFF
					List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
					Spider spider = (Spider) event.getEntity();
					
					spider.setTarget(playerList.get(new Random().nextInt(playerList.size())));
					
					PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
					effect.apply(spider);
				}
			}
		}
		
		if (event.getEntityType() == EntityType.CAVE_SPIDER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			CaveSpider caveSpider = (CaveSpider) event.getEntity();
			
			caveSpider.setTarget(playerList.get(new Random().nextInt(playerList.size())));
			
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			effect.apply(caveSpider);
		}
		
		if (event.getEntityType() == EntityType.STRAY) {
			Stray stray = (Stray) event.getEntity();
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			stray.getEquipment().setHelmet(helmet);
			stray.getEquipment().setChestplate(chestplate);
			stray.getEquipment().setLeggings(leggings);
			stray.getEquipment().setBoots(boots);
			
			ItemStack bow = new ItemStack(Material.BOW);
			bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
			bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
			
			stray.getEquipment().setItemInMainHand(bow);
			stray.getEquipment().setItemInMainHandDropChance(0f);
		}
		
		if (event.getEntityType() == EntityType.HUSK) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Husk husk = (Husk) event.getEntity();
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			husk.getEquipment().setHelmet(helmet);
			husk.getEquipment().setChestplate(chestplate);
			husk.getEquipment().setLeggings(leggings);
			husk.getEquipment().setBoots(boots);
			
			double percent = Math.random();
			
			if (percent > 0.995) {
				ItemStack sensor = new ItemStack(Material.DAYLIGHT_DETECTOR);
				husk.getEquipment().setItemInMainHand(sensor);
				husk.getEquipment().setItemInMainHandDropChance(0.01f);
			} else {
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
				husk.getEquipment().setItemInMainHand(sword);
				husk.getEquipment().setItemInMainHandDropChance(0f);
			}
		}
		
		if (event.getEntityType() == EntityType.EVOKER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Evoker evoker = (Evoker) event.getEntity();
			
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2000000, 1);
			speed.apply(evoker);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(evoker);
		}
		
		if (event.getEntityType() == EntityType.PILLAGER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Pillager pillager = (Pillager) event.getEntity();
			
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			speed.apply(pillager);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(pillager);
			
			ItemStack bow = new ItemStack(Material.CROSSBOW);
			bow.addEnchantment(Enchantment.QUICK_CHARGE, 3);
			bow.addEnchantment(Enchantment.MULTISHOT, 1);
			bow.addEnchantment(Enchantment.PIERCING, 4);
			
			pillager.getEquipment().setItemInMainHand(bow);
			pillager.getEquipment().setItemInMainHandDropChance(0f);
		}
		
		if (event.getEntityType() == EntityType.RAVAGER) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Ravager ravager = (Ravager) event.getEntity();
			
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			speed.apply(ravager);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(ravager);
		}
		
		if (event.getEntityType() == EntityType.VINDICATOR) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Vindicator vindicator = (Vindicator) event.getEntity();
			
			ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
			
			axe.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			speed.apply(vindicator);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(vindicator);
			
			vindicator.getEquipment().setItemInMainHand(axe);
			vindicator.getEquipment().setItemInMainHandDropChance(0f);
		}
		
		if (event.getEntityType() == EntityType.WITHER_SKELETON) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			WitherSkeleton witherSkeleton = (WitherSkeleton) event.getEntity();
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			witherSkeleton.getEquipment().setHelmet(helmet);
			witherSkeleton.getEquipment().setChestplate(chestplate);
			witherSkeleton.getEquipment().setLeggings(leggings);
			witherSkeleton.getEquipment().setBoots(boots);
			
			ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
			
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			witherSkeleton.getEquipment().setItemInMainHand(sword);
			witherSkeleton.getEquipment().setItemInMainHandDropChance(0f);
		}
		
		if (event.getEntityType() == EntityType.ZOGLIN) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Zoglin zoglin = (Zoglin) event.getEntity();
			
			PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			effect.apply(zoglin);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(zoglin);
		}
		
		if (event.getEntityType() == EntityType.HOGLIN) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			Hoglin hoglin = (Hoglin) event.getEntity();
			
			PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 2000000, 0);
			speed.apply(hoglin);
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 0);
			resistance.apply(hoglin);
		}
		
		if (event.getEntityType() == EntityType.PIGLIN) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			Piglin piglin = (Piglin) event.getEntity();
			
			piglin.setTarget(playerList.get(new Random().nextInt(playerList.size())));
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			piglin.getEquipment().setHelmet(helmet);
			piglin.getEquipment().setChestplate(chestplate);
			piglin.getEquipment().setLeggings(leggings);
			piglin.getEquipment().setBoots(boots);
			
			if (piglin.getEquipment().getItemInMainHand().getType() == Material.GOLDEN_SWORD) {
				ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
				sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
				piglin.getEquipment().setItemInMainHand(sword);
				piglin.getEquipment().setItemInMainHandDropChance(0f);
			} else {
				ItemStack bow = new ItemStack(Material.CROSSBOW);
				bow.addEnchantment(Enchantment.QUICK_CHARGE, 3);
				bow.addEnchantment(Enchantment.MULTISHOT, 1);
				bow.addEnchantment(Enchantment.PIERCING, 4);
				
				piglin.getEquipment().setItemInMainHand(bow);
				piglin.getEquipment().setItemInMainHandDropChance(0f);
			}
		}
		
		if (event.getEntityType() == EntityType.ZOMBIFIED_PIGLIN) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());

			PigZombie zombifiedPiglin = (PigZombie) event.getEntity();
			
			zombifiedPiglin.setTarget(playerList.get(new Random().nextInt(playerList.size())));
			zombifiedPiglin.setAngry(true);
			zombifiedPiglin.setAnger(100);
			
			ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
			ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			
			LeatherArmorMeta helmMeta = (LeatherArmorMeta) helmet.getItemMeta();
			helmMeta.setColor(Color.WHITE);
			helmet.setItemMeta(helmMeta);
			
			LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
			chestMeta.setColor(Color.SILVER);
			chestplate.setItemMeta(chestMeta);
			
			LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
			legsMeta.setColor(Color.GRAY);
			leggings.setItemMeta(legsMeta);
			
			LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
			bootsMeta.setColor(Color.BLACK);
			boots.setItemMeta(bootsMeta);
			
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			helmet.addEnchantment(Enchantment.OXYGEN, 1);
			chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			boots.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			
			zombifiedPiglin.getEquipment().setHelmet(helmet);
			zombifiedPiglin.getEquipment().setChestplate(chestplate);
			zombifiedPiglin.getEquipment().setLeggings(leggings);
			zombifiedPiglin.getEquipment().setBoots(boots);
			
			ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
			sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			
			zombifiedPiglin.getEquipment().setItemInMainHand(sword);
			zombifiedPiglin.getEquipment().setItemInMainHandDropChance(0f);
		}
		
		if (event.getEntity().getType() == EntityType.ENDER_DRAGON) {
			if (plugin.getConfig().getBoolean("opMobs") == false) return;
			EnderDragon dragon = (EnderDragon) event.getEntity();
			
			PotionEffect resistance = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2000000, 3);
			resistance.apply(dragon);
		}
	}
	
	private final boolean isArmor(final ItemStack itemStack) {
		if (itemStack == null) return false;
		
		final String typeNameString = itemStack.getType().name().toLowerCase();
		
		if (typeNameString.endsWith("_helmet")
					|| typeNameString.endsWith("_chestplate")
					|| typeNameString.endsWith("_leggings")
					|| typeNameString.endsWith("_boots")) {
			return true;
		}
		
		return false;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void craftEvent(CraftItemEvent event) {
		if (plugin.getConfig().getBoolean("craftingMonsters") == false) return;
		
		Recipe recipe = event.getRecipe();
		ItemStack result = recipe.getResult();
		
		int amount = result.getAmount();
		Material type = result.getType();
		HumanEntity whoClicked = event.getWhoClicked();
		
		int itemsChecked = 0;
		int[] possibleCreations = {1};
		
		if (event.getAction().equals(InventoryAction.HOTBAR_SWAP)) {
			event.setResult(Result.DENY);
			event.setCancelled(true);
			return;
		}
		
		if (event.isShiftClick()) {
			for (ItemStack item : event.getInventory().getMatrix()) {
				if (item != null && !item.getType().equals(Material.AIR)) {
					if (itemsChecked == 0) {
						possibleCreations[0] = item.getAmount();
					} else {
						possibleCreations[0] = Math.min(possibleCreations[0], item.getAmount());
					}
					itemsChecked++;
				}
			}
		}
		
		for (int b = 0; b < possibleCreations[0]; b++) {
			for (int i = 0; i < amount; i++) {
				Zombie zombie = (Zombie) whoClicked.getWorld().spawnEntity(whoClicked.getLocation(), EntityType.ZOMBIE);
				
				zombie.setBaby(true);
				
				zombie.getEquipment().setChestplateDropChance(0f);
				zombie.getEquipment().setHelmetDropChance(0f);
				zombie.getEquipment().setLeggingsDropChance(0f);
				zombie.getEquipment().setBootsDropChance(0f);
				zombie.getEquipment().setItemInMainHandDropChance(0f);
				zombie.getEquipment().setItemInOffHandDropChance(0f);
				
				if (isArmor(result)) {
					if (type.name().toLowerCase().endsWith("_helmet")) {
						zombie.getEquipment().setHelmet(new ItemStack(type));
						zombie.getEquipment().setHelmetDropChance(1f);
						
						zombie.getEquipment().setChestplate(new ItemStack(type));
						zombie.getEquipment().setLeggings(new ItemStack(type));
						zombie.getEquipment().setBoots(new ItemStack(type));
					} else if (type.name().toLowerCase().endsWith("_chestplate")) {
						zombie.getEquipment().setChestplate(new ItemStack(type));
						zombie.getEquipment().setChestplateDropChance(1f);
						
						zombie.getEquipment().setHelmet(new ItemStack(type));
						zombie.getEquipment().setLeggings(new ItemStack(type));
						zombie.getEquipment().setBoots(new ItemStack(type));
					} else if (type.name().toLowerCase().endsWith("_leggings")) {
						zombie.getEquipment().setLeggings(new ItemStack(type));
						zombie.getEquipment().setLeggingsDropChance(1f);
						
						zombie.getEquipment().setHelmet(new ItemStack(type));
						zombie.getEquipment().setChestplate(new ItemStack(type));
						zombie.getEquipment().setBoots(new ItemStack(type));
					} else if (type.name().toLowerCase().endsWith("_boots")) {
						zombie.getEquipment().setBoots(new ItemStack(type));
						zombie.getEquipment().setBootsDropChance(1f);
						
						zombie.getEquipment().setHelmet(new ItemStack(type));
						zombie.getEquipment().setChestplate(new ItemStack(type));
						zombie.getEquipment().setLeggings(new ItemStack(type));
					}
				} else {
					zombie.getEquipment().setHelmet(new ItemStack(type));
					zombie.getEquipment().setHelmetDropChance(1f);
					
					zombie.getEquipment().setChestplate(new ItemStack(type));
					zombie.getEquipment().setLeggings(new ItemStack(type));
					zombie.getEquipment().setBoots(new ItemStack(type));
				}
				
				zombie.getEquipment().setItemInMainHand(new ItemStack(type));
				zombie.getEquipment().setItemInOffHand(new ItemStack(type));
				
				ArmorStand armorStand = (ArmorStand) whoClicked.getWorld().spawnEntity(zombie.getLocation(), EntityType.ARMOR_STAND);
				zombie.addPassenger(armorStand);
				
				armorStand.setMarker(true);
				armorStand.setInvulnerable(true);
				armorStand.setSmall(true);
				armorStand.setVisible(false);
				
				zombie.setCustomName(WordUtils.capitalize(type.name().toLowerCase().replaceAll("_", " ")));
				zombie.setCustomNameVisible(false);
				
				armorStand.setCustomName("\u00a7c\u00a7l" + WordUtils.capitalize(type.name().toLowerCase().replaceAll("_", " ")));
				armorStand.setCustomNameVisible(true);
				
				PotionEffect invisibility = new PotionEffect(PotionEffectType.INVISIBILITY, 2000000, 0);
				invisibility.apply(zombie);
				
				zombie.addScoreboardTag("CraftingZombie");
			}
		}
		
		new BukkitRunnable() {
			@Override
			public void run() {
				if (whoClicked instanceof Player) {
					int itemsLeftToCollect = possibleCreations[0] * amount;
					Player player = (Player) whoClicked;
					PlayerInventory inventory = player.getInventory();
					
					if (event.isShiftClick()) {
						for (int i = 0; i < inventory.getSize(); i++) {
							ItemStack scanStack = inventory.getItem(i);
							
							if (new ItemStack(type).isSimilar(scanStack)) {
								if (scanStack.getAmount() < itemsLeftToCollect) {
									itemsLeftToCollect -= scanStack.getAmount();
									scanStack.setAmount(0);
								} else {
									scanStack.setAmount(scanStack.getAmount() - possibleCreations[0] * amount);
									itemsLeftToCollect = 0;
								}
							}
							
							if (itemsLeftToCollect == 0) break;
						}
					} else {
						if (new ItemStack(type).isSimilar(player.getItemOnCursor())) {
							player.setItemOnCursor(new ItemStack(Material.AIR));
						}
					}
					
					player.updateInventory();
				}
			}
		}.runTaskLater(plugin, 1);
		
		Player player = (Player) whoClicked;
		player.updateInventory();
	}
	
	@EventHandler
	public void deathEvent(EntityDeathEvent event) {
		if (event.getEntityType().equals(EntityType.ZOMBIE)) {
			for (String tag : event.getEntity().getScoreboardTags()) {
				if (tag == "CraftingZombie") {
					event.getDrops().clear();
					event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), new ItemStack(event.getEntity().getEquipment().getHelmet().getType()));
					
					for (Entity passenger : event.getEntity().getPassengers()) {
						passenger.remove();
					}
				}
			}
		}
	}
	
	@EventHandler
	public void damageEvent(EntityDamageEvent event) {
		if (plugin.getConfig().getBoolean("damageShare") == false) return;
		
		if (event.getEntityType() == EntityType.PLAYER) {
			if (event.getCause() == DamageCause.CUSTOM) return;
			
			Player player = (Player) event.getEntity();
			double damage = event.getFinalDamage();
			
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			
			for (Player currPlayer : playerList) {
				if (currPlayer != player) {
					currPlayer.damage(damage);
				}
			}
		}
	}
	
	/*@EventHandler
	public void chatEvent(AsyncPlayerChatEvent event) {
		if (event.getMessage().contains("fuck")) {
			Bukkit.getScheduler().runTask(plugin, new Runnable() {
				@Override
				public void run() {
					event.getPlayer().kickPlayer("you suck");
				}
			});
		}
	}*/
}
