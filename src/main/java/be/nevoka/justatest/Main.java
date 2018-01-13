package be.nevoka.justatest;

import be.nevoka.justatest.block.ModBlocks;
import be.nevoka.justatest.item.ModItems;
import be.nevoka.justatest.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(
        modid = Main.MODID,
        name = Main.name,
        version = Main.VERSION,
        acceptedMinecraftVersions = Main.minecraftversion
)
public class Main
{
    public static final String
            MODID = "%MODID%",
            VERSION = "%MODVERSION%",
            name = "%MODNAME%",
            minecraftversion = "[%MINECRAFTVERSIONS%]";


    @Mod.Instance
    public static Main instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("'" + name + "' is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
    @SidedProxy(serverSide = "be.nevoka.justatest.proxy.CommonProxy", clientSide = "be.nevoka.justatest.proxy.ClientProxy")
    public static CommonProxy Proxy;

    @Mod.EventBusSubscriber
    public static class RegistrationHandler
    {

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event)
        {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event)
        {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event)
        {
            ModBlocks.register(event.getRegistry());
        }
    }

}
