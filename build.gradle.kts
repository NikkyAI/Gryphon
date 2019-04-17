plugins {
	id("gryphon")
}

gryphon {
	name = "Gryphon"
	//What to name the modpack jar.
	projectName = "gryphon"
	//The version of the modpack. Should be valid SemVer.
	version = "1.0.0"
	//Description of the modpack. Should be one or two sentences.
	description = "A basic pack template."

	//Put the file names of any mod jars in "/libs" here, separated by commas.
	//In /libs, make sure you have both the dev and prod versions,
	//and that the dev version has "-dev" appended to its name.
	fileMods = listOf()

	fabric(
		minecraft = "1.14 Pre-Release 4",
		yarn = YARN_DEFAULT,
		loader = LOADER_DEFAULT
	)
}

repositories {
	// add custom repos here
	maven(url="https://maven.jamieswhiteshirt.com/libs-release/") {
		name = "maven.jamieswhiteshirt.com"
	}
}

dependencies {

	// add all mods here

//	include("net.fabricmc:fabric:0.2.7+build.127")
	include("io.github.prospector.modmenu:ModMenu:1.4.1-74")
	include("io.github.cottonmc:cotton:0.6.1+1.14-SNAPSHOT")
	include("io.github.prospector.silk:SilkAPI:1.2.4-43")
//  include("epicurean:epicurean:gastronomy:2.1.1+1.14", //mixin weirdness, works nested in prod (uncomment on build))
	include("hwyla:Hwyla-fabric-1.14:1.9.16:60")
	include("aquarius:aquarius:1.3.0+1.14")
	include("com.jamieswhiteshirt:rtree-3i-lite-fabric:0.2.0")
	include("com.jamieswhiteshirt:clothesline-fabric:0.0.16")
//  include("tumble-dryer:Tumble Dryer:1.1", //gradle is upset by the space, doesn't nest properly)
	include("stockpile:stockpile:1.0.1+1.14:Pre5")
	include("net.fabricmc:fabric-language-kotlin:1.3.30-SNAPSHOT")
	include("composable-automation:composable:automation:0.2.0+mc1.14")
	include("roughly-enough-items:RoughlyEnoughItems:2.7.11.97")
	include("auto-config:auto:config:1.0.0+mc1.14")
	include("cloth-config:ClothConfig:0.2.1.14")
	include("metatips:metatips:1.1.2+1.14pre2")
	include("cursed-chests:CursedChests:1.1.9")
	include("proletarian:proletarian:0.6.0+mc1.14:pre4")
	include("fabriblocks:fabriblocks:1.1.3")
	include("blockus:blockus:1.1.6")
	include("shulkerboxtooltip:shulkerboxtooltip:1.1.2+1.14.0")
	include("mouse-wheelie:mousewheelie:1.0.8+1.14_Pre:Release_5")
	include("level-up-hp:level-up:hp:4.0.0+mc1.14")
	include("i-am-very-smart:i-am-very-smart:0.5.0+mc1.14:pre5")
//  include("arcanemagic:ArcaneMagic:1.0:beta2", //mapping weirdness, doesn't work nested in prod yet)
//  include("com.github.Boundarybreaker:CutsceneAPI:0f52600e94", //mapping weirdness, doesn't work nested in prod yet)
	include("multiblock-api:MultiBlockAPI:1.0.1:1")
	include("crochet:crochet:1.0.2")
//  include("nbt-crafting:nbtcrafting:1.1.8", //mixin weirdness, works nested in prod (uncomment on build))
	include("light-overlay:LightOverlay:1.1.0.6")
	include("cloth:ClothEvents:0.3.1.23")
	include("lil-tater:lil:tater:1.0.2")
	include("coal-nugget:coalnugget:1.0.0.1")
	include("simpleharvest:Harvest-1.14:fabric:1.0.4")
	include("draylars-battle-towers:battle:towers:1.0.3")
	include("fabric-furnaces:fabric:furnaces:1.0.1")
	include("ladysnake-illuminations:Illuminations:0.1.4:19w14b")
	include("extra-pieces:extrapieces:1.2.0")
	include("sodden:sodden:1.0.0.0")
	include("dulce-de-leche:dulcedeleche:1.2.2:30")
	include("more-berries:moreberries:1.1.3")
	// TODO: use -dev for modCompile of files in libs/
}
