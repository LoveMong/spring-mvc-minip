package com.spring.minip.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MysqlConnectionTest {

    @Inject
    private DataSource ds;

    @Test
    public void testConnection() throws Exception {

        try (Connection conn = ds.getConnection()) {
            System.out.println("\n >>>>>>>>>>>>>>>> Connection 출력 : " + conn + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
