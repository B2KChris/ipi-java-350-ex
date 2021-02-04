package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
