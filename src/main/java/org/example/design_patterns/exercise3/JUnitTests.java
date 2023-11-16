package org.example.design_patterns.exercise3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JUnitTests {
    final private PrintStream stdOut = System.out;
    final private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private WeatherData weatherData = new WeatherData();
    private CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
    private ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    private HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

    @Before
    public void setupOutputStream() {
        weatherData.setMeasurements(70, 60, 50);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCurrentConditionsDisplay() {
        currentConditionsDisplay.display();
        Assert.assertEquals("Current conditions: 70.0F degrees and 60.0% humidity", outputStreamCaptor.toString().trim());
    }
    @Test
    public void testForecastDisplay() {
        forecastDisplay.display();
        Assert.assertEquals("Forecast: Improving weather on the way!", outputStreamCaptor.toString().trim());

    }
    @Test
    public void testHeatIndexDisplay() {
        heatIndexDisplay.display();
        Assert.assertEquals("Heat index is 75.99424", outputStreamCaptor.toString().trim());
    }

    @After
    public void resetOutputStream() {
        System.setOut(stdOut);
    }
}

