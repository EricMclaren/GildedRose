package com.gildedrose;

class GildedRose {
    
    private static final String AGEDBRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED ="Conjured"; 
    private static final int TENDAYS = 10;
    private static final int FIVEDAYS = 5;
    private static final int ZERO = 0;
    private static final int MAXQUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    private static void decreaseSellIn(Item item) {
        item.sellIn--;
    }
    
    private static void modifyQuality(Item item, int n) {
        item.quality += n;
    }
    
    public void updateQuality() {
        for (int i=0; i<items.length; i++) {
            Item item = items[i];
            switch (item.name) {
                case AGEDBRIE :
                    if (item.quality < MAXQUALITY) modifyQuality(item, 1);
                    break;
                case BACKSTAGE :
                    if (item.sellIn < 1) {
                        item.quality = 0;
                    } else {
                        if (item.sellIn < 6 && item.quality <= MAXQUALITY) modifyQuality(item, 3);
                        else if (item.sellIn < 11 && item.quality <= MAXQUALITY) modifyQuality(item, 2);
                        else if (item.quality <= MAXQUALITY) modifyQuality(item, 1); 
                        decreaseSellIn(item);
                    }
                    break;
                case SULFURAS :
                    break;
                case CONJURED :
                    if (item.sellIn > 0 && item.quality > 0) modifyQuality(item, -2);
                    else if (item.sellIn <= 0 && item.quality > 0) modifyQuality(item, -4);
                    decreaseSellIn(item);
                    break;
                default : 
                    if (item.sellIn > 0 && item.quality > 0) modifyQuality(item, -1);
                    else modifyQuality(item, -2);
                    decreaseSellIn(item);
            }
        }
    }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
}