/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adrianmoya.bddsample.cucumber;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class StepDefinition {

    static final String APP_URL = "http://localhost:8080/bddsample/";
    WebDriver driver;

    @Before
    public void setup() {
        this.driver = new HtmlUnitDriver();
    }

    @Dado("^que estoy en la aplicación$")
    public void que_estoy_en_la_aplicación() throws Throwable {
        this.driver.get(APP_URL);
    }

    @Cuando("^ingreso los números ([-]?\\d+) y ([-]?\\d+)$")
    public void ingreso_los_números_y(int numero1, int numero2) throws Throwable {
        WebElement campo1 = this.driver.findElement(By.id("calc_form:numero1"));
        WebElement campo2 = this.driver.findElement(By.id("calc_form:numero2"));
        campo1.sendKeys(String.valueOf(numero1));
        campo2.sendKeys(String.valueOf(numero2));
    }

    @Cuando("^solicito el resultado del cálculo$")
    public void solicito_el_resultado_del_cálculo() throws Throwable {
        WebElement botonCalcular = this.driver.findElement(By.id("calc_form:btn_calcular"));
        botonCalcular.click();
    }

    @Entonces("^el resultado debe ser ([-]?\\d+)$")
    public void el_resultado_debe_ser(int resultado) throws Throwable {
        WebElement divResultado = this.driver.findElement(By.id("resultado"));
        assertThat(divResultado.getText(), is("El resultado es " + String.valueOf(resultado)));
    }
}
