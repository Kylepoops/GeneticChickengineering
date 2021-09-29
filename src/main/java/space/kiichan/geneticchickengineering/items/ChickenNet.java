package space.kiichan.geneticchickengineering.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.EntityInteractHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import space.kiichan.geneticchickengineering.GeneticChickengineering;

public class ChickenNet extends SimpleSlimefunItem<EntityInteractHandler> implements NotPlaceable {

    private final GeneticChickengineering plugin;

    public ChickenNet(GeneticChickengineering plugin, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        this.plugin = plugin;
    }

    @Override
    public @NotNull EntityInteractHandler getItemHandler() {
        addItemHandler(this.getSecondItemHandler());
        return (event, item, offhand) -> {
            if (event.getRightClicked().getType() == EntityType.CHICKEN) {
                Chicken chick = (Chicken) event.getRightClicked();
                ItemStack pocketChicken = this.plugin.convert(chick);
                World world = chick.getWorld();
                Location location = chick.getLocation().toCenterLocation();
                world.dropItemNaturally(location, pocketChicken);
                world.playSound(location, Sound.ENTITY_CHICKEN_EGG, 1F, 1F);
                chick.remove();
            }
        };
    }
    public ItemUseHandler getSecondItemHandler() {
        return PlayerRightClickEvent::cancel;
    }
}
