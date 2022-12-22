package com.communitybagelco.menu.repository;

import java.util.List;

import com.communitybagelco.menu.model.MenuItem;

public interface MenuItemRepository {
 
    List<MenuItem> findAll();
}
