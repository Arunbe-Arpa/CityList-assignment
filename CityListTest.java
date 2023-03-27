package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    public void testDelete() {
        CityList cityList = new CityList();


        City city1 = new City("Regina", "SK");
        City city2 = new City("dhaka", "cumilla");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertTrue(!cityList.getCities().contains(city1));
        assertEquals(1, cityList.getCities().size());

    }

    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();


        City city1 = new City("Regina", "SK");
        City city2 = new City("Dhaka", "Arambagh");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    public void testCount() {
        CityList cityList = new CityList();
        City city1 = new City("Regina", "SK");
        City city2 = new City("dhaka", "cumilla");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertEquals(cityList.count(), cityList.getCities().size());
    }

    @Test
    public void testSortName() {
        CityList cityList = new CityList();
        City city1 = new City("Regina", "SK");
        City city2 = new City("Dhaka", "Arambagh");

        cityList.add(city1);
        cityList.add(city2);

        cityList.sortName();

        List<City> expected_list = new ArrayList<>();
        expected_list.add(city2);
        expected_list.add(city1);

        assertEquals( expected_list, cityList.getCities());

    }
    @Test
    public void testSortProvince() {
        CityList cityList = new CityList();
        City city1 = new City("Regina", "Sk");
        City city2 = new City("Thaka", "Arambagh");

        cityList.add(city1);
        cityList.add(city2);

        cityList.sortProvince();

        List<City> expected_list = new ArrayList<>();
        expected_list.add(city2);
        expected_list.add(city1);

        assertEquals( expected_list, cityList.getCities('a'));


    }
}
