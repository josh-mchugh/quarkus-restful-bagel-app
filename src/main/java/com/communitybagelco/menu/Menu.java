package com.communitybagelco.menu;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class Menu {
    
    private List<Item> items = new ArrayList<>();

    @Value
    @RegisterForReflection
    public static class Item {

        String name;
        String description;
    }
}
