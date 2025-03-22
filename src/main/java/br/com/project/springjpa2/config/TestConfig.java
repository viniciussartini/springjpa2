package br.com.project.springjpa2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.springjpa2.models.Category;
import br.com.project.springjpa2.repositories.CategoryRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Informática");
        Category category2 = new Category(null, "Escritório");
        categoryRepository.saveAll(Arrays.asList(category1, category2));
        
    }


}
