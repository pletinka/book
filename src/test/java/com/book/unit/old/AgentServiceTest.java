//package com.book.unit;
//
//import com.book.converter.PersonDtoConverter;
//import com.book.dto.ApartmentDto;
//import com.book.exception.UserNotFoundException;
//import com.book.model.Agent;
//import com.book.repository.PersonRepository;
//import com.book.service.PhoneNumberService;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Matchers.any;
//import static org.mockito.Matchers.anyString;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class AgentServiceTest extends OlxParserTest {
//
//    private static final String TRIMMED_NAME_BY_MAX_LENGTH = "Nam";
//    private static final String NORWAY_PHONE = "07000";
//    private static final String NORWAY_CODE = "070";
//    private static final int MAX_LENGTH = 3;
//    private static final int MAX_LENGTH_OVER_LIMIT = 8;
//    @InjectMocks
//    private PersonServiceImpl personService;
//    @Mock
//    private PhoneNumberService numberService;
//    @Mock
//    private PersonRepository personRepository;
//    @Mock
//    private PersonDtoConverter personConverter;
//
//    @Test
//    public void shouldTestPersonWithNorwayPhoneNumber() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(createPersonWithPhoneNumber(NAME, NORWAY_PHONE));
//        when(numberService.isNumberBelongToCountry(anyString(), anyString())).thenReturn(true);
//
//        assertTrue(personService.isPersonHasPhoneNumberWithNorwayCode(NAME));
//        verify(numberService, times(1)).isNumberBelongToCountry(eq(NORWAY_PHONE), eq(NORWAY_CODE));
//    }
//
//    @Test
//    public void shouldTestPersonWithoutPhoneNumber() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(createPerson(NAME));
//
//        assertFalse(personService.isPersonHasPhoneNumberWithNorwayCode(NAME));
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void shouldTestPersonWithEmptyParameter() {
//        assertFalse(personService.isPersonHasPhoneNumberWithNorwayCode(null));
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void shouldTestPhoneInCaseOfAbsentPerson() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(null);
//
//        assertFalse(personService.isPersonHasPhoneNumberWithNorwayCode(NAME));
//    }
//
//    @Test
//    public void shouldGetAllPersonsSize() {
//        personService.getAllPersonsSize();
//        verify(personRepository, times(1)).getAllPersonsSize();
//    }
//
//    @Test
//    public void shouldTryGetPhoneNumberInCasePersonHasPhone() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(createPersonWithPhoneNumber(NAME, NORWAY_PHONE));
//
//        Optional<String> optionalPhoneNumber = personService.tryGetPhoneNumber(NAME);
//        assertEquals(NORWAY_PHONE, optionalPhoneNumber.get());
//    }
//
//    @Test
//    public void shouldTryGetPhoneNumberInCasePersonHasNotPhone() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(createPerson(NAME));
//
//        Optional<String> optionalPhoneNumber = personService.tryGetPhoneNumber(NAME);
//        assertFalse(optionalPhoneNumber.isPresent());
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void shouldTryGetPhoneNumberInCaseOfEmptyParameter() {
//        personService.tryGetPhoneNumber(null);
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void shouldTryGetPhoneNumberInCaseUserNotFound() {
//        when(personRepository.findPersonByName(NAME)).thenReturn(null);
//
//        personService.tryGetPhoneNumber(NAME);
//    }
//
//    @Test
//    public void shouldGetAllPersonFromNorway() {
//        personService.getAllPersonFromNorway();
//        verify(personRepository, times(1)).getAllPersonsByCountryCode(eq(NORWAY_CODE));
//    }
//
//    @Test
//    public void shouldGetAllPersonsNamesAndTrimByMaxLength() {
//        when(personRepository.getAllPersonsName()).thenReturn(Collections.singletonList(NAME));
//
//        List<String> trimmedPersons = personService.getAllPersonsNamesAndTrimByMaxLength(MAX_LENGTH);
//        assertEquals(TRIMMED_NAME_BY_MAX_LENGTH, trimmedPersons.get(0));
//    }
//
//    @Test
//    public void shouldGetAllPersonsNamesAndTrimByMaxLengthInCaseLimitIsMoreThanNameChars() {
//        when(personRepository.getAllPersonsName()).thenReturn(Collections.singletonList(NAME));
//
//        List<String> trimmedPersons = personService.getAllPersonsNamesAndTrimByMaxLength(MAX_LENGTH_OVER_LIMIT);
//        assertEquals(NAME, trimmedPersons.get(0));
//    }
//
//    @Test
//    public void shouldSavePerson() {
//        personService.savePerson(new ApartmentDto());
//
//        verify(personRepository, times(1)).save(any(Agent.class));
//        verify(personConverter, times(1)).doForward(any(Agent.class));
//        verify(personConverter, times(1)).doBackward(any(ApartmentDto.class));
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void shouldSavePersonInCaseOfNullParameter() {
//        personService.savePerson(null);
//    }
//
//    @Test
//    public void shouldGetPerson() {
//        when(personRepository.findOne(any())).thenReturn(new Agent());
//        personService.getPersonById(ID);
//
//        verify(personRepository, times(1)).findOne(eq(ID));
//        verify(personConverter, times(1)).doForward(any(Agent.class));
//    }
//
//    @Test(expected = UserNotFoundException.class)
//    public void shouldNotGetPersonInCaseOfItNotPresent() {
//        when(personRepository.findOne(any())).thenReturn(null);
//
//        personService.getPersonById(ID);
//    }
//
//    @Test
//    public void shouldRemovePerson() {
//        personService.removePerson(ID);
//
//        verify(personRepository, times(1)).delete(eq(ID));
//    }
//}
