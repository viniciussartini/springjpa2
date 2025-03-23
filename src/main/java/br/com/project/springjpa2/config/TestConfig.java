package br.com.project.springjpa2.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.springjpa2.models.Category;
import br.com.project.springjpa2.models.City;
import br.com.project.springjpa2.models.Product;
import br.com.project.springjpa2.models.State;
import br.com.project.springjpa2.repositories.CategoryRepository;
import br.com.project.springjpa2.repositories.CityRepository;
import br.com.project.springjpa2.repositories.ProductRepository;
import br.com.project.springjpa2.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Informática");
        Category category2 = new Category(null, "Escritório");
        
        Product product1 = new Product(null, "Computador", 2000.00);
        Product product2 = new Product(null, "Impressora", 800.00);
        Product product3 = new Product(null, "Mouse", 80.00);

        category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
        category2.getProducts().addAll(Arrays.asList(product2));

        product1.getCategories().addAll(Arrays.asList(category1));
        product2.getCategories().addAll(Arrays.asList(category1, category2));
        product3.getCategories().addAll(Arrays.asList(category1));

        categoryRepository.saveAll(Arrays.asList(category1, category2));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");
    
        City city1 = new City(null, "Uberlândia", state1);
        City city2 = new City(null, "São Paulo", state2);
        City city3 = new City(null, "Campinas", state2);
    
        state1.getCities().addAll(Arrays.asList(city1));
        state2.getCities().addAll(Arrays.asList(city2, city3));

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));
    }


}
