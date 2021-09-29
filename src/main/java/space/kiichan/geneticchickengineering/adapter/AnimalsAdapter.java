package space.kiichan.geneticchickengineering.adapter;

/* Wholesale stolen from TheBusyBiscuit's
 * MobCapturer.
 *
 * I am dum and couldn't figure out how to set that as a
 * dependency
 */

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Animals;

import com.google.gson.JsonObject;

import space.kiichan.geneticchickengineering.adapter.MobAdapter;

public class AnimalsAdapter<T extends Animals> implements MobAdapter<T> {

    private final Class<T> entityClass;

    public AnimalsAdapter(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public List<String> getLore(JsonObject json) {
        List<String> lore = MobAdapter.super.getLore(json);

        boolean isBaby = json.get("baby").getAsBoolean();

        if (isBaby) {
            lore.add(ChatColor.GRAY + "Baby: " + ChatColor.WHITE + isBaby);
        }

        return lore;
    }

    @Override
    public JsonObject saveData(T entity) {
        JsonObject json = MobAdapter.super.saveData(entity);

        json.addProperty("baby", !entity.isAdult());
        json.addProperty("_age", entity.getAge());
        json.addProperty("_ageLock", entity.getAgeLock());
        json.addProperty("_breedable", entity.canBreed());
        json.addProperty("_loveModeTicks", entity.getLoveModeTicks());

        return json;
    }

    @Override
    public void apply(T entity, JsonObject json) {
        MobAdapter.super.apply(entity, json);

        if (json.get("baby").getAsBoolean()) { entity.setBaby(); }
        entity.setAge(json.get("_age").getAsInt());
        entity.setLoveModeTicks(json.get("_loveModeTicks").getAsInt());
        entity.setAgeLock(json.get("_ageLock").getAsBoolean());
        entity.setBreed(json.get("_breedable").getAsBoolean());
    }

    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

}
