package com.example.contraftfirstimpl;

import com.example.contractfirstImpl.ContractFirstImpl;
import com.example.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
        import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContractFirstImplTest {

    private static final String SUM_SALARY_TEST_VALUE = "10";

    @InjectMocks
    private ContractFirstImpl objectUnderTest;

    @Mock
    private PersonRepository PersonRepositoryMock;

    @Test
    public void testSumSalary() {

        //Given
        when(PersonRepositoryMock.sumSal()).thenReturn(SUM_SALARY_TEST_VALUE);

        //When
        final String sumSalaryValue = objectUnderTest.sumSalary();

        //Then
        assertEquals(sumSalaryValue, SUM_SALARY_TEST_VALUE);
    }

}
