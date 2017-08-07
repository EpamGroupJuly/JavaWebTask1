package com.teamcore.manageapp.service.dao.user;

import com.teamcore.manageapp.service.utils.TestFactory;
import com.teamcore.manageapp.service.config.TestServiceConfig;
import com.teamcore.manageapp.service.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestServiceConfig.class})
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
                scripts = {"classpath:db/init_schema.sql", "classpath:db/init_data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
                scripts = {"classpath:db/cleanup.sql"})
})
public class UserDAOImplTest {
    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Test
    public void saveAndGetUser() throws InterruptedException {
        User user = TestFactory.createDefaultUser();

        User dbUser = userDAO.save(user);
        assertNotNull(dbUser);

        //fetch from database test
        dbUser = userDAO.getById(dbUser.getId());
        assertNotNull(dbUser);
        //test fields
        assertEquals(user.getName(), dbUser.getName());
        assertEquals(user.getEmail(), dbUser.getEmail());
        assertEquals(user.getCreatedAt(), dbUser.getCreatedAt());
    }

}