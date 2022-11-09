package com.communitybagelco.menu;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    
    private List<Item> items = new ArrayList<>();

    @Value
    public static class Item {

        String name;
        String description;
    }
}
