package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void textNbAnneeAnciennete0() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now());
        //When =>
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnneeAnciennete).isEqualTo(0);
    }

    @Test
    public void testNbAnneeAnciennete20() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(20));
        //When =>
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnneeAnciennete).isEqualTo(20);

    }

    @Test
    public void testAnneeAncienneteNotNull() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now());
        //When =>
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneeAnciennete).isNotNull();

    }

    @Test
    public void testAnneeAnciennete1() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(1));
        //When =>
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneeAnciennete).isEqualTo(1);

    }

    @Test
    public void testAnneeAnciennete5() {
        //Given
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(5));
        //When =>
        Integer nbAnneeAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneeAnciennete).isEqualTo(5);

    }
    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 0, 0.5, 500.0",
            "2, 'T12345', 0, 1.0, 2300.0",
            "1, 'M12345', 0, 1.0, 1700.0",
    })
    public void testGetPrimeAnnuelle(Integer performance, String matricule,
                                     Long nbAnneeAnciennete, Double tempsPartiel, Double primeCalculee){
        //Given
        Employe employe2 = new Employe("Doe", "John", matricule,
                LocalDate.now().minusYears(nbAnneeAnciennete), Entreprise.SALAIRE_BASE,
                performance, tempsPartiel);
        Employe employe = new Employe();
        employe.setMatricule(matricule);
        employe.setPerformance(performance);
        employe.setTempsPartiel(tempsPartiel);
        employe.setDateEmbauche(LocalDate.now().minusYears(nbAnneeAnciennete));
        //When
        Double prime = employe.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isEqualTo(primeCalculee);
    }
}
