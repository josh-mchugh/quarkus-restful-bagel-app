package com.communitybagelco.menu;

import java.util.List;

public class Menu {
    
    private List<Item> items;

    public Menu() {
        this.items = List.of();
    }

    public Menu(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class Item {

        private String name;
        private String description;

        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
