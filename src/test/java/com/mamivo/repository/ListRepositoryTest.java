package com.mamivo.repository;

import com.mamivo.entity.List;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class ListRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    ListRepository listRepository;

    private TestEntityManager testEntityManager;

    @BeforeEach
    public void setUp() {
        testEntityManager = new TestEntityManager(entityManager.getEntityManagerFactory());
    }


    @Test
    public void createList() {
        List list = new List();
        String name = "Watchlist";
        String description = "Top 100 classics";
        list.setName(name);
        list.setDescription(description);
        testEntityManager.persist(list);
        testEntityManager.flush();

        List foundList = testEntityManager.find(List.class, list.getId());
        assertNotNull(foundList);
        assertEquals(name, foundList.getName());
        assertEquals(description, foundList.getDescription());
    }
}
