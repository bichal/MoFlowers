<h1 align="center">🌸 MoFlowers - Bring New Life to Your Minecraft World! 🌸</h1>

<p><b>MoFlowers</b> is a Minecraft mod that breathes new life into your adventures by adding a wide variety of unique flowers, berry bushes, and decorative blocks. Every plant is carefully designed to blend naturally into the world, offering new mechanics, vibrant biomes, and creative possibilities for builders and explorers alike.</p>

![HeaderTop](https://github.com/user-attachments/assets/bf89d8c0-440a-4ecf-98c9-1afef7054d56)

<h2 align="center">✨ Main Features</h2>

<ul>
    <li><b>New Flowers & Bushes:</b> Discover species like wildflowers with open/closed states, lavenders, calendulas, foxgloves, hebeas, and aquatic lilies...</li>
    <li><b>Berry Bushes:</b> Harvest sweet blue and glowing berries for food and attracting animals.</li>
    <li><b>Flowers Chest:</b> A chest that only accepts mod items for organizing your floral collection.</li>
    <li><b>Decorative Blocks:</b> Petals, pots, and tall variants for customization.</li>
    <li><b>Biome Integration:</b> New plants naturally generate in specific biomes.</li>
    <li><b>Public API:</b> Allows other mods or datapacks to register compatible flowers and blocks.</li>
    <li><b>Custom Rendering & Loot:</b> Unique drop system and visual effects.</li>
    <li><b>Multilanguage Support:</b> Available in English and Spanish.</li>
</ul>

<h2 align="center">📥 Installation</h2>

1. Install [Fabric Loader](https://fabricmc.net/use/installer/).
2. Download the latest release from [GitHub](https://github.com/bichal/TranslucentWindow).
3. Place the `.jar` file into your `mods` folder.

<div aling="center">
    <img src="https://github.com/user-attachments/assets/c10b7d18-1719-4010-a8a8-88cc6d0b11d3">
    <a href="https://www.curseforge.com/minecraft/mc-mods/moflowers"></a></img>
    <img src="https://github.com/user-attachments/assets/3fbbf92f-214d-4a43-9e47-4fc0ee259881">
    <a href="https://modrinth.com/mod/moflowers"></a></img>
    <img src="https://github.com/user-attachments/assets/7db2e2f5-40a2-4ffb-8d1d-2ee1d1f3099c">
    <a href="https://github.com/bichal/moflowers"></a></img>
    <img src="https://github.com/user-attachments/assets/11c5e3ec-da31-41e7-abf9-4afc2e723387">
    <a href="https://www.curseforge.com/minecraft/mc-mods/fabric-api/files"></img>
</div>
<br>
      
![FooterTop](https://github.com/user-attachments/assets/6d94a263-2767-4f91-9992-7c9b31383472)

<h2 align="center">🧩 MoFlowers API Documentation</h2>

<p align="center">MoFlowers provides a simple and extensible API for modders and datapack creators to register, query, and interact with custom flowers and related blocks.</p>

![HeaderBottom](https://github.com/user-attachments/assets/a4b04459-d61c-4fe3-9ee3-88d62f34a85f)

<h3 align="center">Accessing the API</h3>
<p align="center">Use the static access point to get the API instance</p>

```java
import net.bichal.moflowers.api.MoFlowersAPI;
import net.bichal.moflowers.api.IMoFlowersAPI;

IMoFlowersAPI api = MoFlowersAPI.getInstance();
```
<h3 align="center">Registering Flowers</h3>
<p align="center">You can register new flowers, blocks, or detailed flower data:</p>

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
<h3 align="center">Querying Flowers</h3>
<p align="center">Check if an item or block is a MoFlower</p>

```java
boolean isFlower = api.isMoFlower(item);
boolean isFlowerBlock = api.isMoFlowerBlock(block);
```
<h3 align="center">Flowers Chest</h3>
<p align="center">Access the special Flowers Chest block and item</p>

```java
Item flowersChestItem = api.getFlowersChestItem();
Block flowersChestBlock = api.getFlowersChestBlock();
```
<h3 align="center">Flower Registration Events</h3>
<p align="center">Subscribe to flower registration events for integration</p>

```java
api.registerFlowerRegistrationCallback(flowerData ->{
// Your code here (e.g., log, add custom behavior)
});
```
<h3 align="center">Extending MoFlowers</h3>

- **Add new flowers:** Register your own flowers or blocks for full compatibility.
- **Custom recipes/tags:** Use the provided tags for recipes, advancements, and more.
- **Localization:** Add translations for your custom flowers using standard Minecraft lang files.

<h5 align="center">For more details, see the JavaDocs in the api package or explore the example usages in the mod
    source.</h5>
    
![FooterBottom](https://github.com/user-attachments/assets/95f9bf24-7607-4ca0-947e-3da309c583a6)

<h6 align="center">This mod is licensed is <b>All Rights Reserved</b>.</h6>
