package DH.back_integrador.Service;

import DH.back_integrador.model.Category;
import DH.back_integrador.service.CategoryService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import DH.back_integrador.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@Slf4j
//@Transactional
public class CategoryServiceTest {
    /*
    @Autowired
    private CategoryService categoryService;

    @Test
    public void saveCategoriaTest(){
        log.info("Saving the categories");
        Category category = new Category("Categoria1", "descripcion1","url1");
        categoryService.saveCategory(category);
    }

     */

    /*
    @Test
    public void getCategoryTest(){
        log.info("Searching results of the categorie");
        Category category = new Category("CategoriaUpdate", "descripcionUpdate","urlUpdate");
        Category categorySaved =  categoryService.saveCategory(category);
        System.out.println(categoryService.getCategory(categorySaved.getId()));
    }

     */
    /*
    @Test
    public void getAllTest(){
        log.info("Searching results of the all categories");
        Category category = new Category(3L,"CategoriaUpdate", "descripcionUpdate","urlUpdate");
        System.out.println(categoryService.getAllCategory());
    }

     */

    /*
    @Test
    public void updateCategoryTest(){
        log.info("Updating the categories");
        Category category = new Category(3L,"CategoriaUpdate", "descripcionUpdate","urlUpdate");
        Category categorySaved = categoryService.saveCategory(category);
        categoryService.updateCategory(category);
    }

     */
    /*
    @Test
    public void deleteCategoryTest() throws ResourceNotFoundException {
        Category category = new Category(3L,"CategoriaDelete", "descripcionDelete","urlDelete");
        Category categorySaved = categoryService.saveCategory(category);
        categoryService.deleteCategory(categorySaved.getId());
    }

     */
}




