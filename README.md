# 🌸 MoFlowers - Bring New Life to Your Minecraft World!

**MoFlowers** is a Minecraft mod that breathes new life into your adventures by adding a wide variety of unique flowers,
berry bushes, and decorative blocks. Every plant is carefully designed to blend naturally into the world, offering new
mechanics, vibrant biomes, and creative possibilities for builders and explorers alike.

---

## ✨ Main Features

- **New Flowers & Bushes**: Discover never-before-seen species, from pale wildflowers with open/closed states, to
  lavenders, calendulas, foxgloves, hebeas, and even aquatic lilies.
- **Berry Bushes**: Harvest sweet blue and glowing berries from special bushes—great for food and attracting animals.
- **Flowers Chest**: A unique chest that only accepts mod items, perfect for organizing your floral collection.
- **Decorative Blocks**: Petals, pots, and tall variants to customize your gardens and builds.
- **Biome Integration**: New plants naturally generate in specific biomes, making exploration more rewarding.
- **Public API**: Allows other mods or datapacks to register compatible flowers and blocks.
- **Custom Rendering & Loot**: Each block has its own drop system and visual effects.
- **Multilanguage Support**: Full translations, including English and Spanish.

---

## 🌍 Localization & Data
- Complete translations in English and Spanish.
- Automatic generation of loot tables, tags, and language files for easy compatibility and customization.

---

## 🧩 MoFlowers API Documentation

MoFlowers provides a simple and extensible API for modders and datapack creators to register, query, and interact with custom flowers and related blocks.

### 🔹 Accessing the API

Use the static access point to get the API instance:

```java
import net.bichal.moflowers.api.MoFlowersAPI;
import net.bichal.moflowers.api.IMoFlowersAPI;

IMoFlowersAPI api = MoFlowersAPI.getInstance();
```

### 🔹 Registering Flowers
You can register new flowers, blocks, or detailed flower data:

```java
// Register a flower item
api.registerFlower(myFlowerItem);

// Register a flower block
api.registerFlowerBlock(myFlowerBlock);

// Register a custom flower with extra data
api.registerCustomFlower(new FlowerData.Builder(myItem, myBlock)
.defaultColor(0xFF00FF)
.tallVariant(true)
.biomeRestriction(myBiomeId)
.build());
```

### 🔹 Querying Flowers
Check if an item or block is a MoFlower:
```java
boolean isFlower = api.isMoFlower(item);
boolean isFlowerBlock = api.isMoFlowerBlock(block);
```

### 🔹 Flowers Chest
Access the special Flowers Chest block and item:

```java
Item flowersChestItem = api.getFlowersChestItem();
Block flowersChestBlock = api.getFlowersChestBlock();
```

### 🔹 Flower Registration Events
Subscribe to flower registration events for integration:

```java
api.registerFlowerRegistrationCallback(flowerData ->{
    // Your code here (e.g., log, add custom behavior)
});
```

### 🔹 Extending MoFlowers
- Add new flowers: Register your own flowers or blocks for full compatibility.
- Custom recipes/tags: Use the provided tags for recipes, advancements, and more.
- Localization: Add translations for your custom flowers using standard Minecraft lang files.


For more details, see the JavaDocs in the api package or explore the example usages in the mod source.