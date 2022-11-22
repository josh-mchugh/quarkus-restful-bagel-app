package com.communitybagelco.product;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.communitybagelco.category.Category;

import lombok.AllArgsConstructor;

@ApplicationScoped
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    
    private final EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> rootEntry = cq.from(Product.class);
        CriteriaQuery<Product> all = cq.select(rootEntry);
    
        TypedQuery<Product> allQuery = entityManager.createQuery(all);
        
        return allQuery.getResultList();
    }

    @Override
    public List<Product> getByIds(Collection<Integer> ids) {
        
        return getAll().stream()
            .filter(product -> ids.contains(product.getId()))
            .toList();
    }    
}
