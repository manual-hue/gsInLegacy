package org.team.g2.common.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.team.g2.fundboard.config.FundRootConfig;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@ComponentScan(basePackages = {"org.team.g2.fundboard.service"})
@MapperScan(basePackages = {"org.team.g2.fundboard.mapper"})
@Import(FundRootConfig.class)
public class RootConfig {


	@Bean
	public SqlSessionFactory sqlSessionFactory()throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public DataSource dataSource(){
		HikariConfig config = new HikariConfig();
		//config.setDriverClassName("com.mysql.cj.jdbc.Driver");

		config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");

		//config.setJdbcUrl("jdbc:mysql://localhost:3306/springdb");
		config.setJdbcUrl("jdbc:log4jdbc:mysql://106.241.252.51:1524/gstreet?useUnicode=true&characterEncoding=utf-8");
		config.setUsername("gstreet");
		config.setPassword("gstreetpw");
		config.setMaximumPoolSize(3);
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}

	@Bean
	public TransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	} //db와 연결되어있으니까.

	@Bean(name = "names")
	public ArrayList<String> names(){
		ArrayList<String> list = new ArrayList<>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		return list;
	}
}

