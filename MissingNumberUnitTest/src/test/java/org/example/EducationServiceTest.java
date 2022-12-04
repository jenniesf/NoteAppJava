package org.example;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class EducationServiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;


    @Test
    public void testStudentsByClass() {
        // Given
        Student studentJM = new Student(“Joy Ma”, “Spanish);
        Student student JH = new Student(“Julio Hernandez”, “Algebra”);
        Student student JJ = new Student(“Jenny Jones”, “Calculus”);
        List<Student> allStudents = Arrays.asList(studentJM, studentJH, studentJJ);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        // When
        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject(“math”);

        // Then
        assertThat(mathStudents.size(), is(2));
        assertThat(mathStudents, hasItems(studentJJ, student JH);
    }
}