package portalService.test2.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import portalService.test2.connection.ConnectionConst;
import portalService.test2.connection.ConnectionMaker;
import portalService.test2.connection.JejuConnectionMaker;
import portalService.test2.context.JdbcContext;

import javax.sql.DataSource;

import static portalService.test2.connection.ConnectionConst.*;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao(jdbcContext());
        return userDao;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL_JEJU, USERNAME_JEJU, PASSWORD_JEJU);
        return dataSource;
    }

    @Bean
    public JdbcContext jdbcContext() {
        JdbcContext jdbcContext = new JdbcContext(dataSource());
        return jdbcContext;
    }
}
