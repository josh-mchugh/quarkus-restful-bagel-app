package com.communitybagelco.menu.repository;

import java.util.List;

import com.communitybagelco.menu.model.ImmutableMenuItem;

public interface MenuItemRepository {
 
    List<ImmutableMenuItem> findAll();
}
