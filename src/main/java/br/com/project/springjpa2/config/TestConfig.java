package br.com.project.springjpa2.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.springjpa2.models.Address;
import br.com.project.springjpa2.models.CardPayment;
import br.com.project.springjpa2.models.Category;
import br.com.project.springjpa2.models.City;
import br.com.project.springjpa2.models.Client;
import br.com.project.springjpa2.models.Order;
import br.com.project.springjpa2.models.OrderItem;
import br.com.project.springjpa2.models.Payment;
import br.com.project.springjpa2.models.Product;
import br.com.project.springjpa2.models.State;
import br.com.project.springjpa2.models.TicketPayment;
import br.com.project.springjpa2.models.enums.ClientType;
import br.com.project.springjpa2.models.enums.PaymentStatus;
import br.com.project.springjpa2.repositories.AddressRepository;
import br.com.project.springjpa2.repositories.CategoryRepository;
import br.com.project.springjpa2.repositories.CityRepository;
import br.com.project.springjpa2.repositories.ClientRepository;
import br.com.project.springjpa2.repositories.OrderItemRepository;
import br.com.project.springjpa2.repositories.OrderRepository;
import br.com.project.springjpa2.repositories.PaymentRepository;
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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        Client client1 = new Client(null, "Maria", "maria@email.com", "1112223344", ClientType.PESSOAFISICA);
        client1.getTelephones().addAll(Arrays.asList("32900001111", "32922223333"));

        Address address1 = new Address(null, "Rua Maria", "100", "Apt. 300", "Centro", "00000111", client1, city1);
        Address address2 = new Address(null, "Rua Osvaldo", "105", "Sala 800", "Centro", "22222333", client1, city2);

        client1.getAddresses().addAll(Arrays.asList(address1, address2));

        clientRepository.saveAll(Arrays.asList(client1));
        addressRepository.saveAll(Arrays.asList(address1, address2));

        Order order1 = new Order(null, Instant.now(), client1, address1);
        Order order2 = new Order(null, Instant.now(), client1, address2);

        Payment payment1 = new CardPayment(null, PaymentStatus.PAIDOFF, order1, 6);
        order1.setPayment(payment1);
        Payment payment2 = new TicketPayment(null, PaymentStatus.WAITING, order2, Instant.now(), null);
        order1.setPayment(payment1);
        order2.setPayment(payment2);

        client1.getOrders().addAll(Arrays.asList(order1, order2));

        orderRepository.saveAll(Arrays.asList(order1, order2));
        paymentRepository.saveAll(Arrays.asList(payment1, payment2));

        OrderItem orderItem1 = new OrderItem(order1, product1, 0.00, 1, 2000.00);
        OrderItem orderItem2 = new OrderItem(order1, product3, 0.00, 2, 80.00);
        OrderItem orderItem3 = new OrderItem(order2, product2, 100.00, 1, 800.00);

        order1.getItens().addAll(Arrays.asList(orderItem1, orderItem2));
        order2.getItens().addAll(Arrays.asList(orderItem3));

        product1.getItens().addAll(Arrays.asList(orderItem1));
        product2.getItens().addAll(Arrays.asList(orderItem3));
        product3.getItens().addAll(Arrays.asList(orderItem2));

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));
    }

}