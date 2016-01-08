
package com.tcb.issue1.configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * This class is the configuration class for the MySQL datasource.
 *
 * @author floriancourtial@gmail.com
 */
@Configuration
public class MySQLConfiguration {

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.user}")
    private String user;

    @Value("${mysql.host}")
    private String dbHost;

    @Value("${mysql.port}")
    private String dbPort;

    @Value("${mysql.dbName}")
    private String dbName;


    /**
     * Creation of a MysqlDataSource instance according to properties extracted from the configuration file.
     *
     * @return a DataSource instance initialized according to the properties file.
     * @throws java.sql.SQLException
     */
    @Bean
    public DataSource provisioningDbDataSource() throws SQLException {

        MysqlDataSource provisioningDbDataSource = new MysqlDataSource();
        provisioningDbDataSource.setURL("jdbc:mysql://" + dbHost + ":" + dbPort +"/" + dbName);
        provisioningDbDataSource.setUser(user);
        provisioningDbDataSource.setPassword(password);

        return provisioningDbDataSource;

    }

}
