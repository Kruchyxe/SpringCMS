package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category category){
        entityManager.persist(category);
    }

    public void deleteCategory(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }

    public void updateCategory(Category category) {
        entityManager.merge(category);
    }
}
