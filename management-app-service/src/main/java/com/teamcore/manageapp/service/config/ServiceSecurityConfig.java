package com.teamcore.manageapp.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

public class ServiceSecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        final String usersByUsernameQuery = "select c_name, c_password, c_enabled from t_users " +
                "where c_name = ?";
        final String authoritiesByUsernameQuery = "select t_users.c_name, t_user_groups.c_name " +
                "from t_users join t_user_groups on t_users.c_user_group_id = t_user_groups.c_group_id " +
                "where t_users.c_name = ?";

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(usersByUsernameQuery)
                .authoritiesByUsernameQuery(authoritiesByUsernameQuery);
    }

}
