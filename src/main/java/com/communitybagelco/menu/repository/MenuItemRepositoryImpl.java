package com.communitybagelco.menu.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jooq.DSLContext;

import com.communitybagelco.menu.model.ImmutableMenuItem;

import lombok.AllArgsConstructor;

import static org.jooq.generated.tables.MenuItems.MENU_ITEMS;

@ApplicationScoped
@Transactional
@AllArgsConstructor
public class MenuItemRepositoryImpl implements MenuItemRepository {

    private final DSLContext dsl;

    @Override
    public List<ImmutableMenuItem> findAll() {

        return dsl.selectFrom(MENU_ITEMS)
            .fetchInto(ImmutableMenuItem.class);
    }
}
