package com.javahack.demo.services.database;

import com.javahack.demo.models.Role;
import com.javahack.demo.models.User;
import com.javahack.demo.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DbInit.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("DbInit RUN [START]");
        if (userRepository.findAll() == null) {
            LOGGER.info("'users' table is empty in database");
            List<User> users = new LinkedList<>();

            User ordinaryUser = new User();
            ordinaryUser.setLogin("EgorYakovlev");
            ordinaryUser.setPassword("Pomidor1998");
            ordinaryUser.setEmail("yakovlev.es@phystech.edu");
            ordinaryUser.setSex("M");
            ordinaryUser.setAge(20);
            ordinaryUser.setRole(Role.USER.getAuthority());
            users.add(ordinaryUser);

            User adminUser = new User();
            adminUser.setLogin("admin");
            adminUser.setPassword("admin");
            adminUser.setEmail("admin@admin.ru");
            adminUser.setAge(21);
            adminUser.setSex("M");
            adminUser.setRole(Role.ADMIN.getAuthority());
            users.add(adminUser);

            userRepository.saveAll(users);
        }
        LOGGER.info("DbInit RUN [FINISH]");
    }
}
