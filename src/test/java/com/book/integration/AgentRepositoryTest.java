//package com.book.integration;
//
//
//import com.book.model.Agent;
//import com.book.repository.PersonRepository;
//import com.book.repository.PhoneNumberRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//public class AgentRepositoryTest extends IntegrationTestConfiguration {
//    private static final String PHONE = "070114421";
//    private static final String NORWAY_CODE = "070";
//    private static final String FIRST_PERSON_NAME = "name1";
//    private static final String SECOND_PERSON_NAME = "name2";
//    private static final String THIRD_PERSON_NAME = "name3";
//    private static final String NORWAY_PHONE = "07011441";
//    private static final String CHINA_PHONE = "099111222";
//
//    @Autowired
//    private PersonRepository personRepository;
//    @Autowired
//    private PhoneNumberRepository numberRepository;
//
//    @Transactional
//    @Before
//    public void before() {
//        Agent firstNorwayAgent = createPerson(FIRST_PERSON_NAME, NORWAY_PHONE);
//        Agent secondNorwayAgent = createPerson(SECOND_PERSON_NAME, NORWAY_PHONE);
//        Agent agentFromChina = createPerson(THIRD_PERSON_NAME, CHINA_PHONE);
//        personRepository.save(Arrays.asList(firstNorwayAgent, secondNorwayAgent, agentFromChina));
//    }
//
//    @After
//    public void after() {
//        personRepository.deleteAll();
//        numberRepository.deleteAll();
//    }
//
//    @Test
//    public void getPersonsSize() {
//        long size = personRepository.getAllPersonsSize();
//
//        assertEquals(3, size);
//    }
//
//    @Test
//    public void getAllNames() {
//        List<String> allPersonsName = personRepository.getAllPersonsName();
//
//        assertTrue(allPersonsName.contains(FIRST_PERSON_NAME));
//        assertTrue(allPersonsName.contains(SECOND_PERSON_NAME));
//        assertTrue(allPersonsName.contains(THIRD_PERSON_NAME));
//    }
//
//    @Test
//    public void getAllNorwayPerson() {
//        List<Agent> allPersonsByCountryCode = personRepository.getAllPersonsByCountryCode(NORWAY_CODE);
//
//        assertEquals(2, allPersonsByCountryCode.size());
//        assertTrue(allPersonsByCountryCode.stream().noneMatch(
//                person -> CHINA_PHONE.equals(person.getPhoneNumber().getNumber())
//        ));
//    }
//
//    @Test
//    public void getPersonByName() {
//        Agent agentByName = personRepository.findPersonByName(FIRST_PERSON_NAME);
//
//        assertEquals(FIRST_PERSON_NAME, agentByName.getName());
//    }
//
//    @Test
//    public void saveAndGetPerson() {
//        Agent agent = createPerson(PERSON_NAME, PHONE);
//        personRepository.save(agent);
//
//        Agent savedAgent = personRepository.findOne(agent.getId());
//
//        assertNotNull(savedAgent.getId());
//        assertEquals(PERSON_NAME, savedAgent.getName());
//        assertEquals(PHONE, savedAgent.getPhoneNumber().getNumber());
//    }
//
//    @Test
//    public void removePerson() {
//        Agent agent = createPerson(PERSON_NAME, PHONE);
//        personRepository.save(agent);
//
//        personRepository.delete(agent.getId());
//
//        assertNull(personRepository.findOne(agent.getId()));
//    }
//
//    @Test
//    public void updatePerson() {
//        Agent agent = createPerson(PERSON_NAME, PHONE);
//        personRepository.save(agent);
//
//        agent.setName(FIRST_PERSON_NAME);
//        personRepository.save(agent);
//        Agent updatedAgent = personRepository.findOne(agent.getId());
//
//        assertEquals(FIRST_PERSON_NAME, updatedAgent.getName());
//    }
//
//    private Agent createPerson(String name, String phone) {
//        Agent agent = new Agent();
//        agent.setName(name);
//        agent.setTimestamp(LocalDateTime.now());
//
//        PhoneNumber phoneNumber = createPhoneNumber(phone);
//        agent.setPhoneNumber(phoneNumber);
//
//        return agent;
//    }
//
//    private PhoneNumber createPhoneNumber(String number) {
//        PhoneNumber phoneNumber = new PhoneNumber();
//        phoneNumber.setNumber(number);
//        return phoneNumber;
//    }
//}
