package vn.techmaster.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import vn.techmaster.jpa.entity.Product;
import vn.techmaster.jpa.entity.User;
import vn.techmaster.jpa.repository.ProductRepository;
import vn.techmaster.jpa.repository.UserRepository;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    JpaRepositoriesAutoConfiguration.class
})
public class SpringBootJpaMultiDataSourcesStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootJpaMultiDataSourcesStartUp.class);
        UserRepository userRepository = applicationContext.getBean(
            UserRepository.class
        );
        User user = new User();
        user.setName("Techmaster");
        user = userRepository.save(user);
        User fetchedUser = userRepository.findById(user.getId()).get();
        System.out.println("fetchedUser: " + fetchedUser);

        ProductRepository productRepository = applicationContext.getBean(
            ProductRepository.class
        );
        Product product = new Product();
        product.setName("Mastering spring boot");
        product = productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).get();
        System.out.println("fetchedProduct: " + fetchedProduct);
    }
}
