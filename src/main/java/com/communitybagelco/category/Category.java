package com.communitybagelco.category;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
public class Category {
    
    private String name;
}
