package com.solace.samples.solaceretailpublisher;

import com.solace.sample.Order;
import com.solace.sample.item;

import java.time.Instant;
import java.util.*;


// TODO: Move the potential order data to a json file
// TODO: Read the catalog json file and select items from it.
public class GenerateOrder {
    public static Integer MAX_ITEMS = 20;
    public static Integer MAX_QUANTITY = 10;
    private Order order = new Order();
    private static HashMap<String, Double> availableItems;

    public GenerateOrder() {
        // Default constructor for a new order
        System.out.println("Creating a new order!");
        availableItems  = buildItems();

        Random random = new Random();
        // Generate an order number.
        // Order number will be date plus a random 4 digit number
        // This will overflow Long eventually I suppose.
        order.setOrderNumber((Instant.now().toEpochMilli() * 10000) + random.nextInt(9999));

        // Set customer ID
        order.setCustomerID(random.nextInt(999999999));

        // Assign Order Status
        order.setStatus("New");

        // Assign store
        order.setStore(availableStores[random.nextInt(availableStores.length)]);

        // Assign requestTime UTC
        order.setRequestTime(Instant.now().toString());

        // Build order contents
        List<item> items = new ArrayList<item>();
        for (int i = 0; i <random.nextInt(MAX_ITEMS); i++) {
            items.add(generateItem());
        }
        order.setItems(items);

        // Assign status
        order.setStatus("Created");
    }

    /*
    Function to build items for an order 1 at a time
     */
    private static item generateItem() {
        Random random = new Random();
        item myItem = new item();
        List<String> itemList = new ArrayList<String>(availableItems.keySet());
        int randomItem = new Random().nextInt(itemList.size());
        myItem.setItemName(itemList.get(randomItem));
        myItem.setItemQuantity(random.nextInt(MAX_QUANTITY));
        myItem.setItemPrice(availableItems.get(itemList.get(randomItem)));
        return myItem;
    }

    public Order getOrder() {
        return order;
    }






    // 2D array of items that can go into an order


    String[] availableStores = {
        "Pittsburg",
        "Buckeye",
        "Brea",
        "Indio",
        "Scottsdale",
        "Columbus",
        "Lancaster",
        "Lincoln",
        "Trenton",
        "Boston",
        "Glendora",
        "Rochester",
        "Florissant",
        "Annapolis",
        "Chapel Hill",
        "Lawrence",
        "Calexico",
        "Calumet City",
        "Missoula",
        "Clovis",
        "Pearland",
        "Gilbert",
        "Wausau",
        "Raleigh",
        "Orange",
        "Walnut Creek",
        "Bremerton",
        "Porterville",
        "Marana",
        "Tallahassee",
        "Conroe",
        "Blacksburg",
        "San Antonio",
        "Hartford",
        "Waterloo",
        "Binghamton",
        "Meridian",
        "Fond du Lac",
        "Baytown",
        "Cary",
        "Weymouth Town",
        "Tulsa",
        "Mission",
        "Cuyahoga Falls",
        "Malden",
        "Allen",
        "Tucson",
        "Franklin",
        "Shakopee",
        "Jacksonville",
        "Atlantic City",
        "Erie",
        "Merced",
        "Abilene",
        "Yorba Linda",
        "Greenville",
        "Huntersville",
        "St. Clair Shores",
        "Harrisburg",
        "San Buenaventura (Ventura)",
        "Fremont",
        "Pueblo",
        "Chelsea",
        "Belleville",
        "Minneapolis",
        "Bartlett",
        "Wichita Falls",
        "Missouri City",
        "St. Louis"
    };

    private HashMap<String, Double> buildItems() {
        availableItems = new HashMap<>();
        // Each item has a random price between .01 and 50.00
        availableItems.put("DELLE VENEZIE PINOT GRIGIO - PASQUA COLORI D'ITALIA", 12.99);
        availableItems.put("1792 - BCLS PERSONAL BARREL BOURBON", 1.99);
        availableItems.put("MICHELOB - ULTRA SLEEK 24 CAN", 1.99);
        availableItems.put("STEAM WHISTLE - PILSNER CAN", 1.99);
        availableItems.put("BAROLO - SANDRONE LE VIGNE 2016", 1.99);
        availableItems.put("ABSOLUT - JUICE STRAWBERRY EDITION", 1.99);
        availableItems.put("OLD PULTENEY - 2007 SINGLE CASK", 1.99);
        availableItems.put("FRONSAC - CHATEAU MOULIN HAUT LAROQUE 2018", 1.99);
        availableItems.put("ARGYLE - VINTAGE BRUT 2014", 1.99);
        availableItems.put("GLENFARCLAS - 17 YEAR OLD", 1.99);
        availableItems.put("BALVENIE - WEEK OF PEAT 14YO", 1.99);
        availableItems.put("CANADIAN CLUB 43 YEAR OLD - CC CHRONICLES ISSUE NO. 3", 1.99);
        availableItems.put("RUSSELL BREWING - BLOOD ALLEY ESB TALL CAN", 1.99);
        availableItems.put("MERLOT  DONINI", 1.99);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 1999", 1.99);
        availableItems.put("REMY MARTIN - GRANDE CHAMPAGNE LOUIS XIII", 1.99);
        availableItems.put("DEVERON - 12 YEAR OLD", 1.99);
        availableItems.put("DUJARDIN - V.S.O.P.", 1.99);
        availableItems.put("SILENT SAM", 1.99);
        availableItems.put("NIKKA - TAKETSURU 21 YEAR OLD MADEIRA FINISH", 1.99);
        availableItems.put("ST ESTEPHE - CHATEAU LILIAN LADOUYS 2018", 1.99);
        availableItems.put("COMPASS BOX - MENAGERIE", 1.99);
        availableItems.put("PALM BAY - 0G VARIETY CAN", 1.99);
        availableItems.put("SAINT VIVANT - V.S.O.P.", 1.99);
        availableItems.put("BOLGHERI SUPERIORE - ORNELLAIA 2016", 1.99);
        availableItems.put("GRAVES BLANC - CLOS FLORIDENE 2013", 1.99);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 2017", 1.99);
        availableItems.put("CORONA LIGHT - SLEEK CAN", 1.99);
        availableItems.put("GRANT'S - SHERRY CASK 8 YO", 1.99);
        availableItems.put("GEVREY CHAMBERTIN 1ER LAVAUX ST JACQUES - ALBERT BICHOT 2016", 1.99);
        availableItems.put("CEDARCREEK - CHARDONNAY 2019", 1.99);
        availableItems.put("PAUILLAC - CHATEAU LYNCH BAGES 2010", 1.99);
        availableItems.put("CHASSAGNE MONTRACHET 1ER LES VERGERS - DOM FONT GAGNARD 16", 1.99);
        availableItems.put("PIPER HEIDSIECK - CUVEE BRUT", 1.99);
        availableItems.put("SMIRNOFF INFUSIONS - WATERMELON AND MINT", 1.99);
        availableItems.put("TRUMPETER - ROSE DE MALBEC EXTRA BRUT", 1.99);
        availableItems.put("BORDEAUX ROUGE - JEAN PIERRE MOUEIX 2016", 1.99);
        availableItems.put("GROWERS - SUMMER PEACH CAN", 1.99);
        availableItems.put("REVELSTOKE GIN - SERIES NO. 1", 1.99);
        availableItems.put("DAGERAAD - BURNABARIAN TALL CAN", 1.99);
        availableItems.put("CHIANTI CLASSICO GRAN SELEZIONE - RUFFINO ROMITORIO DI SANTE", 1.99);
        availableItems.put("CROWN ROYAL BLENDERS MASH", 1.99);
        availableItems.put("PAUILLAC - CHATEAU LAFITE ROTHSCHILD 2017", 1.99);
        availableItems.put("PINOT NOIR - SOKOL BLOSSER DUNDEE HILLS 2017", 1.99);
        availableItems.put("CHATEAU LAFITE ROTHSCHILD 2013", 1.99);
        availableItems.put("NAPA VALLEY RED - OPUS ONE 2014", 1.99);
        availableItems.put("LAMB'S - NAVY", 1.99);
        availableItems.put("CABERNET SAUVIGNON - MIL PIEDRAS VALLEY DE UCO 2018", 1.99);
        availableItems.put("SHIRAZ - PIRRAMIMMA 1892 MCLAREN VALE 2018", 1.99);
        availableItems.put("VOSNE ROMANEE 1ER LES ROUGES DU DESSUS - PIERRE BRISSET 2015", 1.99);
        availableItems.put("NIKKA - THE NIKKA 12 YEAR OLD", 1.99);
        availableItems.put("SAUVIGNON BLANC - CRANSWICK COCOPARRA RIVERINA", 1.99);
        availableItems.put("STELLERS JAY - BRUT 2016", 1.99);
        availableItems.put("THE KRAKEN - BLACK SPICED", 1.99);
        availableItems.put("CHINON - DOMAINE DE L'R LE CANAL DES GRANDS PIECES 2019", 1.99);
        availableItems.put("PESSAC LEOGNAN - LA CLARTE DE HAUT BRION BLANC 2018", 1.99);
        availableItems.put("CABERNET SAUVIGNON - 8 RIOS CHILE 2018", 1.99);
        availableItems.put("BILLECART SALMON - VINTAGE 2007", 1.99);
        availableItems.put("MALBEC - CATENA ZAPATA ADRIANNA VINEYARD RIVER STONES", 1.99);
        availableItems.put("NAPA VALLEY RED - BOND QUELLA 2014", 1.99);
        availableItems.put("VINTAGE PORT - DOW'S 2017", 1.99);
        availableItems.put("Angelica", 1.99);
        availableItems.put("Savoy cabbage", 1.99);
        availableItems.put("Silver linden", 1.99);
        availableItems.put("Kiwi", 1.99);
        availableItems.put("Allium (Onion)", 1.99);
        availableItems.put("Garden onion", 1.99);
        availableItems.put("Leek", 1.99);
        availableItems.put("Garlic", 1.99);
        availableItems.put("Chives", 1.99);
        availableItems.put("Lemon verbena", 1.99);
        availableItems.put("Cashew nut", 1.99);
        availableItems.put("Pineapple", 1.99);
        availableItems.put("Dill", 1.99);
        availableItems.put("Custard apple", 1.99);
        availableItems.put("Wild celery", 1.99);
        availableItems.put("Peanut", 1.99);
        availableItems.put("Burdock", 1.99);
        availableItems.put("Horseradish", 1.99);
        availableItems.put("Tarragon", 1.99);
        availableItems.put("Mugwort", 1.99);
        availableItems.put("Asparagus", 1.99);
        availableItems.put("Oat", 1.99);
        availableItems.put("Star fruit", 1.99);
        availableItems.put("Brazil nut", 1.99);
        availableItems.put("Common beet", 1.99);
        availableItems.put("Borage", 1.99);
        availableItems.put("Chinese mustard", 1.99);
        availableItems.put("Swede", 1.99);
        availableItems.put("Rape", 1.99);
        availableItems.put("Common cabbage", 1.99);
        availableItems.put("Cauliflower", 1.99);
        availableItems.put("Brussel sprouts", 1.99);
        availableItems.put("Kohlrabi", 1.99);
        availableItems.put("Broccoli", 1.99);
        availableItems.put("Chinese cabbage", 1.99);
        availableItems.put("Turnip", 1.99);
        availableItems.put("Pigeon pea", 1.99);
        availableItems.put("Tea", 1.99);
        availableItems.put("Capers", 1.99);
        availableItems.put("Pepper (C. annuum)", 1.99);
        availableItems.put("Papaya", 1.99);
        availableItems.put("Safflower", 1.99);
        availableItems.put("Caraway", 1.99);
        availableItems.put("Pecan nut", 1.99);
        availableItems.put("Chestnut", 1.99);
        availableItems.put("Roman camomile", 1.99);
        availableItems.put("Chickpea", 1.99);
        availableItems.put("Endive", 1.99);
        availableItems.put("Chicory", 1.99);
        availableItems.put("Chinese cinnamon", 1.99);
        availableItems.put("Ceylon cinnamon", 1.99);
        availableItems.put("Watermelon", 1.99);
        availableItems.put("Lime", 1.99);
        availableItems.put("Lemon", 1.99);
        availableItems.put("Pummelo", 1.99);
        availableItems.put("Mandarin orange (Clementine, Tangerine)", 1.99);
        availableItems.put("Sweet orange", 1.99);
        availableItems.put("Coffee", 1.99);
        availableItems.put("Arabica coffee", 1.99);
        availableItems.put("Robusta coffee", 1.99);
        availableItems.put("Coriander", 1.99);
        availableItems.put("Common hazelnut", 1.99);
        availableItems.put("Saffron", 1.99);
        availableItems.put("Muskmelon", 1.99);
        availableItems.put("Cucumber", 1.99);
        availableItems.put("Cucurbita (Gourd)", 1.99);
        availableItems.put("Cumin", 1.99);
        availableItems.put("Turmeric", 1.99);
        availableItems.put("Quince", 1.99);
        availableItems.put("Lemon grass", 1.99);
        availableItems.put("Globe artichoke", 1.99);
        availableItems.put("Wild carrot", 1.99);
        availableItems.put("Japanese persimmon", 1.99);
        availableItems.put("Cardamom", 1.99);
        availableItems.put("Black crowberry", 1.99);
        availableItems.put("Loquat", 1.99);
        availableItems.put("Rocket salad", 1.99);
        availableItems.put("Wax apple", 1.99);
        availableItems.put("Common buckwheat", 1.99);
        availableItems.put("Tartary buckwheat", 1.99);
        availableItems.put("Fig", 1.99);
        availableItems.put("Fennel", 1.99);
        availableItems.put("Strawberry", 1.99);
        availableItems.put("Black huckleberry", 1.99);
        availableItems.put("Soy bean", 1.99);
        availableItems.put("Sunflower", 1.99);
        availableItems.put("Sea-buckthornberry", 1.99);
        availableItems.put("Barley", 1.99);
        availableItems.put("Hyssop", 1.99);
        availableItems.put("Star anise", 1.99);
        availableItems.put("Swamp cabbage", 1.99);
        availableItems.put("Sweet potato", 1.99);
        availableItems.put("Black walnut", 1.99);
        availableItems.put("Common walnut", 1.99);
        availableItems.put("Lettuce", 1.99);
        availableItems.put("Grass pea", 1.99);
        availableItems.put("Sweet bay", 1.99);
        availableItems.put("Lentils", 1.99);
        availableItems.put("Garden cress", 1.99);
        availableItems.put("Lovage", 1.99);
        availableItems.put("Flaxseed", 1.99);
        availableItems.put("Mexican oregano", 1.99);
        availableItems.put("Lichee", 1.99);
        availableItems.put("Lupine", 1.99);
        availableItems.put("Apple", 1.99);
        availableItems.put("Mango", 1.99);
        availableItems.put("German camomile", 1.99);
        availableItems.put("Lemon balm", 1.99);
        availableItems.put("Mentha (Mint)", 1.99);
        availableItems.put("Orange mint", 1.99);
        availableItems.put("Cornmint", 1.99);
        availableItems.put("Spearmint", 1.99);
        availableItems.put("Peppermint", 1.99);
        availableItems.put("Medlar", 1.99);
        availableItems.put("Bitter gourd", 1.99);
        availableItems.put("Mulberry", 1.99);
        availableItems.put("Black mulberry", 1.99);
        availableItems.put("Nutmeg", 1.99);
        availableItems.put("Sweet basil", 1.99);
        availableItems.put("Evening primrose", 1.99);
        availableItems.put("Olive", 1.99);
        availableItems.put("Sweet marjoram", 1.99);
        availableItems.put("Pot marjoram", 1.99);
        availableItems.put("Common oregano", 1.99);
        availableItems.put("Rice", 1.99);
        availableItems.put("Millet", 1.99);
        availableItems.put("Poppy", 1.99);
        availableItems.put("Passion fruit", 1.99);
        availableItems.put("Parsnip", 1.99);
        availableItems.put("Avocado", 1.99);
        availableItems.put("Parsley", 1.99);
        availableItems.put("Scarlet bean", 1.99);
        availableItems.put("Lima bean", 1.99);
        availableItems.put("Common bean", 1.99);
        availableItems.put("Date", 1.99);
        availableItems.put("Black chokeberry", 1.99);
        availableItems.put("Anise", 1.99);
        availableItems.put("Pine nut", 1.99);
        availableItems.put("Pepper (Spice)", 1.99);
        availableItems.put("Pistachio", 1.99);
        availableItems.put("Common pea", 1.99);
        availableItems.put("Purslane", 1.99);
        availableItems.put("Prunus (Cherry, Plum)", 1.99);
        availableItems.put("Apricot", 1.99);
        availableItems.put("Sweet cherry", 1.99);
        availableItems.put("Sour cherry", 1.99);
        availableItems.put("European plum", 1.99);
        availableItems.put("Almond", 1.99);
        availableItems.put("Peach", 1.99);
        availableItems.put("Guava", 1.99);
        availableItems.put("Pomegranate", 1.99);
        availableItems.put("Pear", 1.99);
        availableItems.put("Radish", 1.99);
        availableItems.put("Garden rhubarb", 1.99);
        availableItems.put("Blackcurrant", 1.99);
        availableItems.put("Redcurrant", 1.99);
        availableItems.put("Gooseberry", 1.99);
        availableItems.put("Watercress", 1.99);
        availableItems.put("Rosemary", 1.99);
        availableItems.put("Rubus (Blackberry, Raspberry)", 1.99);
        availableItems.put("Cloudberry", 1.99);
        availableItems.put("Red raspberry", 1.99);
        availableItems.put("Black raspberry", 1.99);
        availableItems.put("Sorrel", 1.99);
        availableItems.put("Common sage", 1.99);
        availableItems.put("Black elderberry", 1.99);
        availableItems.put("Summer savory", 1.99);
        availableItems.put("Winter savory", 1.99);
        availableItems.put("Rye", 1.99);
        availableItems.put("Sesame", 1.99);
        availableItems.put("Garden tomato", 1.99);
        availableItems.put("Cherry tomato", 1.99);
        availableItems.put("Garden tomato", 1.99);
        availableItems.put("Eggplant", 1.99);
        availableItems.put("Potato", 1.99);
        availableItems.put("Rowanberry", 1.99);
        availableItems.put("Sorghum", 1.99);
        availableItems.put("Spinach", 1.99);
        availableItems.put("Cloves", 1.99);
        availableItems.put("Tamarind", 1.99);
        availableItems.put("Dandelion", 1.99);
        availableItems.put("Cocoa bean", 1.99);
        availableItems.put("Common thyme", 1.99);
        availableItems.put("Linden", 1.99);
        availableItems.put("Small-leaf linden", 1.99);
        availableItems.put("Fenugreek", 1.99);
        availableItems.put("Common wheat", 1.99);
        availableItems.put("Vaccinium (Blueberry, Cranberry, Huckleberry)", 1.99);
        availableItems.put("Lowbush blueberry", 1.99);
        availableItems.put("Sparkleberry", 1.99);
        availableItems.put("Highbush blueberry", 1.99);
        availableItems.put("American cranberry", 1.99);
        availableItems.put("Bilberry", 1.99);
        availableItems.put("Lingonberry", 1.99);
        availableItems.put("Vanilla", 1.99);
        availableItems.put("Common verbena", 1.99);
        availableItems.put("Broad bean", 1.99);
        availableItems.put("Adzuki bean", 1.99);
        availableItems.put("Gram bean", 1.99);
        availableItems.put("Mung bean", 1.99);
        availableItems.put("Climbing bean", 1.99);
        availableItems.put("Cowpea", 1.99);
        availableItems.put("Muscadine grape", 1.99);
        availableItems.put("Common grape", 1.99);
        availableItems.put("Corn", 1.99);
        availableItems.put("Ginger", 1.99);
        availableItems.put("Arctic blackberry", 1.99);
        availableItems.put("Banana", 1.99);
        availableItems.put("Bayberry", 1.99);
        availableItems.put("Elliott's blueberry", 1.99);
        availableItems.put("Canada blueberry", 1.99);
        availableItems.put("Bog bilberry", 1.99);
        availableItems.put("Buffalo currant", 1.99);
        availableItems.put("Celeriac", 1.99);
        availableItems.put("Celery stalks", 1.99);
        availableItems.put("Chinese chives", 1.99);
        availableItems.put("European cranberry", 1.99);
        availableItems.put("Deerberry", 1.99);
        availableItems.put("Ginseng", 1.99);
        availableItems.put("Cascade huckleberry", 1.99);
        availableItems.put("Oval-leaf huckleberry", 1.99);
        availableItems.put("Evergreen huckleberry", 1.99);
        availableItems.put("Red huckleberry", 1.99);
        availableItems.put("Longan", 1.99);
        availableItems.put("Macadamia nut (M. tetraphylla)", 1.99);
        availableItems.put("Garden onion ", 1.99);
        availableItems.put("Summer grape", 1.99);
        availableItems.put("Fox grape", 1.99);
        availableItems.put("Nectarine", 1.99);
        availableItems.put("Peach ", 1.99);
        availableItems.put("Pepper (C. baccatum)", 1.99);
        availableItems.put("Pepper (C. chinense)", 1.99);
        availableItems.put("Pepper (Capsicum)", 1.99);
        availableItems.put("Rambutan", 1.99);
        availableItems.put("Red rice", 1.99);
        availableItems.put("Annual wild rice", 1.99);
        availableItems.put("Swiss chard", 1.99);
        availableItems.put("Lemon thyme", 1.99);
        availableItems.put("Tronchuda cabbage", 1.99);
        availableItems.put("Japanese walnut", 1.99);
        availableItems.put("Welsh onion", 1.99);
        availableItems.put("Hard wheat", 1.99);
        availableItems.put("Shallot", 1.99);
        availableItems.put("Rocket salad", 1.99);
        availableItems.put("Carrot", 1.99);
        availableItems.put("Triticale", 1.99);
        availableItems.put("Black cabbage", 1.99);
        availableItems.put("Half-highbush blueberry", 1.99);
        availableItems.put("Celery leaves", 1.99);
        availableItems.put("Chicory leaves", 1.99);
        availableItems.put("Komatsuna", 1.99);
        availableItems.put("Pak choy", 1.99);
        availableItems.put("Napa cabbage", 1.99);
        availableItems.put("Chicory roots", 1.99);
        availableItems.put("Grapefruit/Pummelo hybrid", 1.99);
        availableItems.put("Grapefruit", 1.99);
        availableItems.put("Jostaberry", 1.99);
        availableItems.put("Kai-lan", 1.99);
        availableItems.put("Italian oregano", 1.99);
        availableItems.put("Oxheart cabbage", 1.99);
        availableItems.put("Daikon radish", 1.99);
        availableItems.put("Black radish", 1.99);
        availableItems.put("Radish", 1.99);
        availableItems.put("Red beetroot", 1.99);
        availableItems.put("Sweet rowanberry", 1.99);
        availableItems.put("Pineappple sage", 1.99);
        availableItems.put("Skunk currant", 1.99);
        availableItems.put("Beer", 1.99);
        availableItems.put("Breakfast cereal", 1.99);
        availableItems.put("Pasta", 1.99);
        availableItems.put("Biscuit", 1.99);
        availableItems.put("Sourdough", 1.99);
        availableItems.put("Spirit", 1.99);
        availableItems.put("Fortified wine", 1.99);
        availableItems.put("Abalone", 1.99);
        availableItems.put("Abiyuch", 1.99);
        availableItems.put("Acerola", 1.99);
        availableItems.put("Acorn", 1.99);
        availableItems.put("Winter squash", 1.99);
        availableItems.put("Agar", 1.99);
        availableItems.put("Red king crab", 1.99);
        availableItems.put("Alfalfa", 1.99);
        availableItems.put("Allspice", 1.99);
        availableItems.put("Amaranth", 1.99);
        availableItems.put("Arrowhead", 1.99);
        availableItems.put("Arrowroot", 1.99);
        availableItems.put("Asian pear", 1.99);
        availableItems.put("Atlantic herring", 1.99);
        availableItems.put("Atlantic mackerel", 1.99);
        availableItems.put("Painted comber", 1.99);
        availableItems.put("Atlantic pollock", 1.99);
        availableItems.put("Atlantic wolffish", 1.99);
        availableItems.put("Bamboo shoots", 1.99);
        availableItems.put("Striped bass", 1.99);
        availableItems.put("Beaver", 1.99);
        availableItems.put("Beech nut", 1.99);
        availableItems.put("Beluga whale", 1.99);
        availableItems.put("Bison", 1.99);
        availableItems.put("Black bear", 1.99);
        availableItems.put("Alaska blackfish", 1.99);
        availableItems.put("Blue crab", 1.99);
        availableItems.put("Blue mussel", 1.99);
        availableItems.put("Northern bluefin tuna", 1.99);
        availableItems.put("Bluefish", 1.99);
        availableItems.put("Wild boar", 1.99);
        availableItems.put("Bowhead whale", 1.99);
        availableItems.put("Breadfruit", 1.99);
        availableItems.put("Breadnut tree seed", 1.99);
        availableItems.put("Rapini", 1.99);
        availableItems.put("Brown bear", 1.99);
        availableItems.put("Buffalo", 1.99);
        availableItems.put("Burbot", 1.99);
        availableItems.put("Giant butterbur", 1.99);
        availableItems.put("American butterfish", 1.99);
        availableItems.put("Butternut", 1.99);
        availableItems.put("Butternut squash", 1.99);
        availableItems.put("Calabash", 1.99);
        availableItems.put("Cardoon", 1.99);
        availableItems.put("Caribou", 1.99);
        availableItems.put("Natal plum", 1.99);
        availableItems.put("Carob", 1.99);
        availableItems.put("Common carp", 1.99);
        availableItems.put("Cassava", 1.99);
        availableItems.put("Channel catfish", 1.99);
        availableItems.put("Chayote", 1.99);
        availableItems.put("Cherimoya", 1.99);
        availableItems.put("Chervil", 1.99);
        availableItems.put("Chia", 1.99);
        availableItems.put("Chicken (Cock, Hen, Rooster)", 1.99);
        availableItems.put("Chinese broccoli", 1.99);
        availableItems.put("Chinese chestnut", 1.99);
        availableItems.put("Chinese water chestnut", 1.99);
        availableItems.put("Garland chrysanthemum", 1.99);
        availableItems.put("Cisco", 1.99);
        availableItems.put("Nuttall cockle", 1.99);
        availableItems.put("Coconut", 1.99);
        availableItems.put("Pacific cod", 1.99);
        availableItems.put("Atlantic cod", 1.99);
        availableItems.put("Common octopus", 1.99);
        availableItems.put("Corn salad", 1.99);
        availableItems.put("Cottonseed", 1.99);
        availableItems.put("Catjang pea", 1.99);
        availableItems.put("Malus (Crab apple)", 1.99);
        availableItems.put("Squashberry", 1.99);
        availableItems.put("Atlantic croaker", 1.99);
        availableItems.put("Cusk", 1.99);
        availableItems.put("Cuttlefish", 1.99);
        availableItems.put("Mule deer", 1.99);
        availableItems.put("Devilfish", 1.99);
        availableItems.put("Dock", 1.99);
        availableItems.put("Dolphin fish", 1.99);
        availableItems.put("Freshwater drum", 1.99);
        availableItems.put("Mallard duck", 1.99);
        availableItems.put("Dungeness crab", 1.99);
        availableItems.put("Durian", 1.99);
        availableItems.put("Eastern oyster", 1.99);
        availableItems.put("Freshwater eel", 1.99);
        availableItems.put("Elderberry", 1.99);
        availableItems.put("Elk", 1.99);
        availableItems.put("Emu", 1.99);
        availableItems.put("Oregon yampah", 1.99);
        availableItems.put("European anchovy", 1.99);
        availableItems.put("European chestnut", 1.99);
        availableItems.put("Turbot", 1.99);
        availableItems.put("Fireweed", 1.99);
        availableItems.put("Florida pompano", 1.99);
        availableItems.put("Ginkgo nuts", 1.99);
        availableItems.put("Greylag goose", 1.99);
        availableItems.put("Grape", 1.99);
        availableItems.put("Greenland halibut/turbot", 1.99);
        availableItems.put("Groundcherry", 1.99);
        availableItems.put("Grouper", 1.99);
        availableItems.put("Guinea hen", 1.99);
        availableItems.put("Haddock", 1.99);
        availableItems.put("Hippoglossus (Common halibut)", 1.99);
        availableItems.put("Hazelnut", 1.99);
        availableItems.put("Hickory nut", 1.99);
        availableItems.put("Horse", 1.99);
        availableItems.put("Horseradish tree", 1.99);
        availableItems.put("Alaska blueberry", 1.99);
        availableItems.put("Hyacinth bean", 1.99);
        availableItems.put("Irish moss", 1.99);
        availableItems.put("Pacific jack mackerel", 1.99);
        availableItems.put("Jackfruit", 1.99);
        availableItems.put("Japanese chestnut", 1.99);
        availableItems.put("Java plum", 1.99);
        availableItems.put("Jerusalem artichoke", 1.99);
        availableItems.put("Jujube", 1.99);
        availableItems.put("Jute", 1.99);
        availableItems.put("Kale", 1.99);
        availableItems.put("Kelp", 1.99);
        availableItems.put("King mackerel", 1.99);
        availableItems.put("Kumquat", 1.99);
        availableItems.put("Lambsquarters", 1.99);
        availableItems.put("Leather chiton", 1.99);
        availableItems.put("Wild leek", 1.99);
        availableItems.put("Common ling", 1.99);
        availableItems.put("Lingcod", 1.99);
        availableItems.put("American lobster", 1.99);
        availableItems.put("Loganberry", 1.99);
        availableItems.put("Lotus", 1.99);
        availableItems.put("Sacred lotus", 1.99);
        availableItems.put("White lupine", 1.99);
        availableItems.put("Malabar spinach", 1.99);
        availableItems.put("Mammee apple", 1.99);
        availableItems.put("Purple mangosteen", 1.99);
        availableItems.put("Alpine sweetvetch", 1.99);
        availableItems.put("Milkfish", 1.99);
        availableItems.put("Monkfish", 1.99);
        availableItems.put("Moose", 1.99);
        availableItems.put("Moth bean", 1.99);
        availableItems.put("Mountain yam", 1.99);
        availableItems.put("Striped mullet", 1.99);
        availableItems.put("Muskrat", 1.99);
        availableItems.put("White mustard", 1.99);
        availableItems.put("Mustard spinach", 1.99);
        availableItems.put("New Zealand spinach", 1.99);
        availableItems.put("Nopal", 1.99);
        availableItems.put("Ocean pout", 1.99);
        availableItems.put("North Pacific giant octopus", 1.99);
        availableItems.put("Ohelo berry", 1.99);
        availableItems.put("Okra", 1.99);
        availableItems.put("Tunicate", 1.99);
        availableItems.put("Opossum", 1.99);
        availableItems.put("Ostrich", 1.99);
        availableItems.put("Spotted seal", 1.99);
        availableItems.put("Pacific herring", 1.99);
        availableItems.put("Pacific oyster", 1.99);
        availableItems.put("Pacific rockfish", 1.99);
        availableItems.put("Velvet duck", 1.99);
        availableItems.put("Pepper (C. frutescens)", 1.99);
        availableItems.put("Common persimmon", 1.99);
        availableItems.put("Pheasant", 1.99);
        availableItems.put("Northern pike", 1.99);
        availableItems.put("Pili nut", 1.99);
        availableItems.put("Colorado pinyon", 1.99);
        availableItems.put("Pitanga", 1.99);
        availableItems.put("Plains prickly pear", 1.99);
        availableItems.put("French plantain", 1.99);
        availableItems.put("American pokeweed", 1.99);
        availableItems.put("Polar bear", 1.99);
        availableItems.put("Opium poppy", 1.99);
        availableItems.put("Prairie turnip", 1.99);
        availableItems.put("Prickly pear", 1.99);
        availableItems.put("Quinoa", 1.99);
        availableItems.put("European rabbit", 1.99);
        availableItems.put("Raccoon", 1.99);
        availableItems.put("Rainbow smelt", 1.99);
        availableItems.put("Rainbow trout", 1.99);
        availableItems.put("Malabar plum", 1.99);
        availableItems.put("Rose hip", 1.99);
        availableItems.put("Roselle", 1.99);
        availableItems.put("Orange roughy", 1.99);
        availableItems.put("Sablefish", 1.99);
        availableItems.put("Pink salmon", 1.99);
        availableItems.put("Chum salmon", 1.99);
        availableItems.put("Coho salmon", 1.99);
        availableItems.put("Sockeye salmon", 1.99);
        availableItems.put("Chinook salmon", 1.99);
        availableItems.put("Atlantic salmon", 1.99);
        availableItems.put("Salmonberry", 1.99);
        availableItems.put("Common salsify", 1.99);
        availableItems.put("Sapodilla", 1.99);
        availableItems.put("Mamey sapote", 1.99);
        availableItems.put("Spanish mackerel", 1.99);
        availableItems.put("Pacific sardine", 1.99);
        availableItems.put("Scallop", 1.99);
        availableItems.put("Scup", 1.99);
        availableItems.put("Sea cucumber", 1.99);
        availableItems.put("Steller sea lion", 1.99);
        availableItems.put("Bearded seal", 1.99);
        availableItems.put("Ringed seal", 1.99);
        availableItems.put("Seatrout", 1.99);
        availableItems.put("Sesbania flower", 1.99);
        availableItems.put("American shad", 1.99);
        availableItems.put("Shark", 1.99);
        availableItems.put("Sheefish", 1.99);
        availableItems.put("Sheep (Mutton, Lamb)", 1.99);
        availableItems.put("Sheepshead", 1.99);
        availableItems.put("Hedge mustard", 1.99);
        availableItems.put("Skipjack tuna", 1.99);
        availableItems.put("Snapper", 1.99);
        availableItems.put("Soursop", 1.99);
        availableItems.put("Spelt", 1.99);
        availableItems.put("Spirulina", 1.99);
        availableItems.put("Squab", 1.99);
        availableItems.put("Squirrel", 1.99);
        availableItems.put("Strawberry guava", 1.99);
        availableItems.put("Greater sturgeon", 1.99);
        availableItems.put("White sucker", 1.99);
        availableItems.put("Sugar apple", 1.99);
        availableItems.put("Pumpkinseed sunfish", 1.99);
        availableItems.put("Swordfish", 1.99);
        availableItems.put("Taro", 1.99);
        availableItems.put("Teff", 1.99);
        availableItems.put("Tilefish", 1.99);
        availableItems.put("Mexican groundcherry", 1.99);
        availableItems.put("Towel gourd", 1.99);
        availableItems.put("Salmonidae (Salmon, Trout)", 1.99);
        availableItems.put("Turkey", 1.99);
        availableItems.put("Cattle (Beef, Veal)", 1.99);
        availableItems.put("Walleye", 1.99);
        availableItems.put("Alaska pollock", 1.99);
        availableItems.put("Wasabi", 1.99);
        availableItems.put("Wax gourd", 1.99);
        availableItems.put("Whelk", 1.99);
        availableItems.put("Coalfish pollock", 1.99);
        availableItems.put("Broad whitefish", 1.99);
        availableItems.put("Whitefish", 1.99);
        availableItems.put("Whiting", 1.99);
        availableItems.put("Wild rice", 1.99);
        availableItems.put("Tea leaf willow", 1.99);
        availableItems.put("Winged bean", 1.99);
        availableItems.put("Yam", 1.99);
        availableItems.put("Jicama", 1.99);
        availableItems.put("Yautia", 1.99);
        availableItems.put("Yellowfin tuna", 1.99);
        availableItems.put("Yellowtail amberjack", 1.99);
        availableItems.put("Pollock", 1.99);
        availableItems.put("Albacore tuna", 1.99);
        availableItems.put("Gadus (Common cod)", 1.99);
        availableItems.put("Atlantic halibut", 1.99);
        availableItems.put("Pacific halibut", 1.99);
        availableItems.put("Pacific salmon", 1.99);
        availableItems.put("Smelt", 1.99);
        availableItems.put("Clupeinae (Herring, Sardine, Sprat)", 1.99);
        availableItems.put("Spiny lobster", 1.99);
        availableItems.put("Snow crab", 1.99);
        availableItems.put("Black-eyed pea", 1.99);
        availableItems.put("Deer", 1.99);
        availableItems.put("Macadamia nut", 1.99);
        availableItems.put("Percoidei", 1.99);
        availableItems.put("Perciformes", 1.99);
        availableItems.put("Arctic ground squirrel", 1.99);
        availableItems.put("Rabbit", 1.99);
        availableItems.put("Domestic goat", 1.99);
        availableItems.put("Beefalo", 1.99);
        availableItems.put("Antelope", 1.99);
        availableItems.put("Bivalvia ", 1.99);
        availableItems.put("Squid", 1.99);
        availableItems.put("Shrimp", 1.99);
        availableItems.put("Crayfish", 1.99);
        availableItems.put("Flatfish", 1.99);
        availableItems.put("Domestic pig (Piglet, Pork)", 1.99);
        availableItems.put("Walrus", 1.99);
        availableItems.put("Alaska wild rhubarb", 1.99);
        availableItems.put("Oriental wheat", 1.99);
        availableItems.put("Yardlong bean", 1.99);
        availableItems.put("Great horned owl", 1.99);
        availableItems.put("Quail", 1.99);
        availableItems.put("Boysenberry", 1.99);
        availableItems.put("Persian lime", 1.99);
        availableItems.put("Feijoa", 1.99);
        availableItems.put("Rowal", 1.99);
        availableItems.put("Jew's ear", 1.99);
        availableItems.put("Common mushroom", 1.99);
        availableItems.put("Shiitake", 1.99);
        availableItems.put("Purple laver", 1.99);
        availableItems.put("Wakame", 1.99);
        availableItems.put("Enokitake", 1.99);
        availableItems.put("Epazote", 1.99);
        availableItems.put("Oyster mushroom", 1.99);
        availableItems.put("Cloud ear fungus", 1.99);
        availableItems.put("Maitake", 1.99);
        availableItems.put("Ostrich fern", 1.99);
        availableItems.put("Spot croaker", 1.99);
        availableItems.put("Sourdock", 1.99);
        availableItems.put("Tinda", 1.99);
        availableItems.put("Atlantic menhaden", 1.99);
        availableItems.put("Wheat", 1.99);
        availableItems.put("Common chokecherry", 1.99);
        availableItems.put("Agave", 1.99);
        availableItems.put("Narrowleaf cattail", 1.99);
        availableItems.put("Jellyfish", 1.99);
        availableItems.put("Anchovy", 1.99);
        availableItems.put("Blue whiting", 1.99);
        availableItems.put("Carp bream", 1.99);
        availableItems.put("Chanterelle", 1.99);
        availableItems.put("Sturgeon", 1.99);
        availableItems.put("Charr", 1.99);
        availableItems.put("Cinnamon", 1.99);
        availableItems.put("Crab", 1.99);
        availableItems.put("Common dab", 1.99);
        availableItems.put("Spiny dogfish", 1.99);
        availableItems.put("Anatidae (Duck, Goose, Swan)", 1.99);
        availableItems.put("Anguilliformes (Eel)", 1.99);
        availableItems.put("True frog", 1.99);
        availableItems.put("Garfish", 1.99);
        availableItems.put("Gadiformes (Cod, Hake)", 1.99);
        availableItems.put("Mountain hare", 1.99);
        availableItems.put("Lake trout", 1.99);
        availableItems.put("Lemon sole", 1.99);
        availableItems.put("Clawed lobster", 1.99);
        availableItems.put("Lumpsucker", 1.99);
        availableItems.put("Scombridae (Bonito, Mackerel, Tuna)", 1.99);
        availableItems.put("Marine mussel", 1.99);
        availableItems.put("Norway haddock", 1.99);
        availableItems.put("Norway lobster", 1.99);
        availableItems.put("Norway pout", 1.99);
        availableItems.put("Oil palm", 1.99);
        availableItems.put("True oyster", 1.99);
        availableItems.put("Sago palm", 1.99);
        availableItems.put("Persimmon", 1.99);
        availableItems.put("Pikeperch", 1.99);
        availableItems.put("Pleuronectidae (Dab, Halibut, Plaice)", 1.99);
        availableItems.put("Rock ptarmigan", 1.99);
        availableItems.put("Pacific ocean perch", 1.99);
        availableItems.put("Black salsify", 1.99);
        availableItems.put("True seal", 1.99);
        availableItems.put("Red algae", 1.99);
        availableItems.put("Kombu", 1.99);
        availableItems.put("Snail", 1.99);
        availableItems.put("True sole", 1.99);
        availableItems.put("Catfish", 1.99);
        availableItems.put("Thistle", 1.99);
        availableItems.put("Thunnus (Common tuna)", 1.99);
        availableItems.put("Walnut", 1.99);
        availableItems.put("Cetacea (Dolphin, Porpoise, Whale)", 1.99);
        availableItems.put("Columbidae (Dove, Pigeon)", 1.99);
        availableItems.put("Conch", 1.99);
        availableItems.put("Apple cider", 1.99);
        availableItems.put("Liquor", 1.99);
        availableItems.put("Cheese", 1.99);
        availableItems.put("Milk (Cow)", 1.99);
        availableItems.put("Eggs", 1.99);
        availableItems.put("Yogurt", 1.99);
        availableItems.put("Bean", 1.99);
        availableItems.put("Vodka", 1.99);
        availableItems.put("Whisky", 1.99);
        availableItems.put("Ice cream", 1.99);
        availableItems.put("Gin", 1.99);
        availableItems.put("Honey", 1.99);
        availableItems.put("Liquorice", 1.99);
        availableItems.put("Vinegar", 1.99);
        availableItems.put("Rum", 1.99);
        availableItems.put("Port wine", 1.99);
        availableItems.put("Vermouth", 1.99);
        availableItems.put("Sherry", 1.99);
        availableItems.put("Madeira wine", 1.99);
        availableItems.put("Nougat", 1.99);
        availableItems.put("Toffee", 1.99);
        availableItems.put("Cake", 1.99);
        availableItems.put("Pizza", 1.99);
        availableItems.put("Ymer", 1.99);
        availableItems.put("Crisp bread", 1.99);
        availableItems.put("Pastry", 1.99);
        availableItems.put("DragÔøΩÔøΩe", 1.99);
        availableItems.put("Chewing gum", 1.99);
        availableItems.put("Marzipan", 1.99);
        availableItems.put("Salad dressing", 1.99);
        availableItems.put("Sauce", 1.99);
        availableItems.put("Salt", 1.99);
        availableItems.put("Butter", 1.99);
        availableItems.put("Butter substitute", 1.99);
        availableItems.put("Cream", 1.99);
        availableItems.put("Sugar", 1.99);
        availableItems.put("Sausage", 1.99);
        availableItems.put("Meatball", 1.99);
        availableItems.put("Mustard", 1.99);
        availableItems.put("Pate", 1.99);
        availableItems.put("Sugar substitute", 1.99);
        availableItems.put("Meat bouillon", 1.99);
        availableItems.put("Whey", 1.99);
        availableItems.put("Casein", 1.99);
        availableItems.put("Fruit preserve", 1.99);
        availableItems.put("Leavening agent", 1.99);
        availableItems.put("Marshmallow", 1.99);
        availableItems.put("Gelatin", 1.99);
        availableItems.put("Water", 1.99);
        availableItems.put("Baby food", 1.99);
        availableItems.put("Dumpling", 1.99);
        availableItems.put("Soup", 1.99);
        availableItems.put("Syrup", 1.99);
        availableItems.put("Tallow", 1.99);
        availableItems.put("Remoulade", 1.99);
        availableItems.put("Chocolate spread", 1.99);
        availableItems.put("Fruit gum", 1.99);
        availableItems.put("Curry powder", 1.99);
        availableItems.put("Meringue", 1.99);
        availableItems.put("Lard", 1.99);
        availableItems.put("Cocoa butter", 1.99);
        availableItems.put("Cocoa powder", 1.99);
        availableItems.put("Cocoa liquor", 1.99);
        availableItems.put("Chocolate", 1.99);
        availableItems.put("Hot chocolate", 1.99);
        availableItems.put("Dried milk", 1.99);
        availableItems.put("Kefir", 1.99);
        availableItems.put("Buttermilk", 1.99);
        availableItems.put("Soy sauce", 1.99);
        availableItems.put("Miso", 1.99);
        availableItems.put("Tofu", 1.99);
        availableItems.put("Zwieback", 1.99);
        availableItems.put("Roe", 1.99);
        availableItems.put("Cichlidae (Tilapia)", 1.99);
        availableItems.put("Icing", 1.99);
        availableItems.put("Snack bar", 1.99);
        availableItems.put("Green turtle", 1.99);
        availableItems.put("Energy drink", 1.99);
        availableItems.put("Burrito", 1.99);
        availableItems.put("Hamburger", 1.99);
        availableItems.put("Baked beans", 1.99);
        availableItems.put("Chili", 1.99);
        availableItems.put("Taco", 1.99);
        availableItems.put("Tortilla", 1.99);
        availableItems.put("Nachos", 1.99);
        availableItems.put("Processed cheese", 1.99);
        availableItems.put("Salad", 1.99);
        availableItems.put("Cream substitute", 1.99);
        availableItems.put("Dulce de leche", 1.99);
        availableItems.put("Topping", 1.99);
        availableItems.put("Sweet custard", 1.99);
        availableItems.put("Egg roll", 1.99);
        availableItems.put("Heart of palm", 1.99);
        availableItems.put("Popcorn", 1.99);
        availableItems.put("Potato chip", 1.99);
        availableItems.put("Tortilla chip", 1.99);
        availableItems.put("Corn chip", 1.99);
        availableItems.put("Hibiscus tea", 1.99);
        availableItems.put("Stew", 1.99);
        availableItems.put("Gelatin dessert", 1.99);
        availableItems.put("Junket", 1.99);
        availableItems.put("Falafel", 1.99);
        availableItems.put("Frybread", 1.99);
        availableItems.put("Lasagna", 1.99);
        availableItems.put("Morchella (Morel)", 1.99);
        availableItems.put("Pancake", 1.99);
        availableItems.put("Pectin", 1.99);
        availableItems.put("Pudding", 1.99);
        availableItems.put("Waffle", 1.99);
        availableItems.put("Soy milk", 1.99);
        availableItems.put("Meatloaf", 1.99);
        availableItems.put("Sake", 1.99);
        availableItems.put("Cocktail", 1.99);
        availableItems.put("Couscous", 1.99);
        availableItems.put("Bulgur", 1.99);
        availableItems.put("Coffee substitute", 1.99);
        availableItems.put("Coffee mocha", 1.99);
        availableItems.put("Chimichanga", 1.99);
        availableItems.put("Semolina", 1.99);
        availableItems.put("Tapioca pearl", 1.99);
        availableItems.put("Tostada", 1.99);
        availableItems.put("Quesadilla", 1.99);
        availableItems.put("Baked potato", 1.99);
        availableItems.put("Hot dog", 1.99);
        availableItems.put("Spread", 1.99);
        availableItems.put("Enchilada", 1.99);
        availableItems.put("Egg substitute", 1.99);
        availableItems.put("Ketchup", 1.99);
        availableItems.put("Breakfast sandwich", 1.99);
        availableItems.put("Adobo", 1.99);
        availableItems.put("Macaroni and cheese", 1.99);
        availableItems.put("Butterfat", 1.99);
        availableItems.put("Horned melon", 1.99);
        availableItems.put("Hushpuppy", 1.99);
        availableItems.put("Fruit juice", 1.99);
        availableItems.put("Relish", 1.99);
        availableItems.put("Fruit salad", 1.99);
        availableItems.put("Soy yogurt", 1.99);
        availableItems.put("Vegetarian food", 1.99);
        availableItems.put("Veggie burger", 1.99);
        availableItems.put("Cold cut", 1.99);
        availableItems.put("Mixed nuts", 1.99);
        availableItems.put("Canola", 1.99);
        availableItems.put("Babassu palm", 1.99);
        availableItems.put("CupuaÔøΩ_u", 1.99);
        availableItems.put("Shea tree", 1.99);
        availableItems.put("Oil-seed Camellia", 1.99);
        availableItems.put("Ucuhuba", 1.99);
        availableItems.put("Phyllo dough", 1.99);
        availableItems.put("Cooking oil", 1.99);
        availableItems.put("Pie crust", 1.99);
        availableItems.put("Pie filling", 1.99);
        availableItems.put("Pie", 1.99);
        availableItems.put("Shortening", 1.99);
        availableItems.put("Soy cream", 1.99);
        availableItems.put("Ice cream cone", 1.99);
        availableItems.put("Molasses", 1.99);
        availableItems.put("Cracker", 1.99);
        availableItems.put("Nance", 1.99);
        availableItems.put("Naranjilla", 1.99);
        availableItems.put("Natto", 1.99);
        availableItems.put("Ravioli", 1.99);
        availableItems.put("Scrapple", 1.99);
        availableItems.put("Succotash", 1.99);
        availableItems.put("Tamale", 1.99);
        availableItems.put("Rice cake", 1.99);
        availableItems.put("Tree fern", 1.99);
        availableItems.put("Evaporated milk", 1.99);
        availableItems.put("Flour", 1.99);
        availableItems.put("Akutaq", 1.99);
        availableItems.put("Dough", 1.99);
        availableItems.put("Pita bread", 1.99);
        availableItems.put("Focaccia", 1.99);
        availableItems.put("Bagel", 1.99);
        availableItems.put("Piki bread", 1.99);
        availableItems.put("French toast", 1.99);
        availableItems.put("Wheat bread", 1.99);
        availableItems.put("Rye bread", 1.99);
        availableItems.put("Oat bread", 1.99);
        availableItems.put("Potato bread", 1.99);
        availableItems.put("Cornbread", 1.99);
        availableItems.put("Corn grits", 1.99);
        availableItems.put("Multigrain bread", 1.99);
        availableItems.put("Rice bread", 1.99);
        availableItems.put("Pan dulce", 1.99);
        availableItems.put("Raisin bread", 1.99);
        availableItems.put("Wonton wrapper", 1.99);
        availableItems.put("Trail mix", 1.99);
        availableItems.put("Greenthread tea", 1.99);
        availableItems.put("Fruit-flavor drink", 1.99);
        availableItems.put("Vegetable juice", 1.99);
        availableItems.put("Horchata", 1.99);
        availableItems.put("Soft drink", 1.99);
        availableItems.put("Frozen yogurt", 1.99);
        availableItems.put("Milkshake", 1.99);
        availableItems.put("Chocolate mousse", 1.99);
        availableItems.put("Dripping", 1.99);
        availableItems.put("Pupusa", 1.99);
        availableItems.put("Empanada", 1.99);
        availableItems.put("Arepa", 1.99);
        availableItems.put("Ascidians", 1.99);
        availableItems.put("Gefilte fish", 1.99);
        availableItems.put("Yellow pond-lily", 1.99);
        availableItems.put("Fish burger", 1.99);
        availableItems.put("Pot pie", 1.99);
        availableItems.put("Stuffing", 1.99);
        availableItems.put("Edible shell", 1.99);
        availableItems.put("Fudge", 1.99);
        availableItems.put("Candy bar", 1.99);
        availableItems.put("Condensed milk", 1.99);
        availableItems.put("Margarine", 1.99);
        availableItems.put("Margarine-like spread", 1.99);
        availableItems.put("Hummus", 1.99);
        availableItems.put("Potato puffs", 1.99);
        availableItems.put("Potato gratin", 1.99);
        availableItems.put("Milk substitute", 1.99);
        availableItems.put("Pepper", 1.99);
        availableItems.put("Soft-necked garlic", 1.99);
        availableItems.put("Cabbage", 1.99);
        availableItems.put("Chinese bayberry", 1.99);
        availableItems.put("Mushrooms", 1.99);
        availableItems.put("Alcoholic beverages", 1.99);
        availableItems.put("Onion-family vegetables", 1.99);
        availableItems.put("Pomes", 1.99);
        availableItems.put("Brassicas", 1.99);
        availableItems.put("Cereals and cereal products", 1.99);
        availableItems.put("Citrus", 1.99);
        availableItems.put("Cocoa and cocoa products", 1.99);
        availableItems.put("Coffee and coffee products", 1.99);
        availableItems.put("Crustaceans", 1.99);
        availableItems.put("Milk and milk products", 1.99);
        availableItems.put("Fats and oils", 1.99);
        availableItems.put("Fishes", 1.99);
        availableItems.put("Herbs and Spices", 1.99);
        availableItems.put("Pulses", 1.99);
        availableItems.put("Animal foods", 1.99);
        availableItems.put("Mollusks", 1.99);
        availableItems.put("Nuts", 1.99);
        availableItems.put("Beverages", 1.99);
        availableItems.put("Fruits", 1.99);
        availableItems.put("Green vegetables", 1.99);
        availableItems.put("Root vegetables", 1.99);
        availableItems.put("Sunburst squash (pattypan squash)", 1.99);
        availableItems.put("Green zucchini", 1.99);
        availableItems.put("Yellow zucchini", 1.99);
        availableItems.put("Green bell pepper", 1.99);
        availableItems.put("Yellow bell pepper", 1.99);
        availableItems.put("Orange bell pepper", 1.99);
        availableItems.put("Red bell pepper", 1.99);
        availableItems.put("Italian sweet red pepper", 1.99);
        availableItems.put("Yellow wax bean", 1.99);
        availableItems.put("Green bean", 1.99);
        availableItems.put("Saskatoon berry", 1.99);
        availableItems.put("Nanking cherry", 1.99);
        availableItems.put("Japanese pumpkin", 1.99);
        availableItems.put("White cabbage", 1.99);
        availableItems.put("Romaine lettuce", 1.99);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 0% fat", 1.99);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 1% fat", 1.99);
        availableItems.put("Cow milk, pasteurized, vitamin A + D added, 2% fat", 1.99);
        availableItems.put("Cow milk, pasteurized, vitamin D added, 3.25% fat", 1.99);

        return availableItems;
    };
}
