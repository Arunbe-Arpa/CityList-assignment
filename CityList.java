package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to delete
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if that city  exists
     * @param city
     *      This is the city to add
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    public List<City> getCities(char a) {
        List<City> cityList = cities;
        sortProvince();
        return cityList;
    }
    /**
     * This adds a city to the list if that city does not exist
     * @param
     * @return
     *    returns the size of cities
     */
    public int count(){
        return cities.size();
    }

    /**
     * This sorts according to city name
     * @param
     * @return
     *
     */
    public void  sortName(){
        Comparator<City> nameComparator = new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return city1.getCityName().compareTo(city2.getCityName());
            }
        };
        Collections.sort(cities, nameComparator);
    }

    /**
     * This sorts according to province name
     * @param
     * @return
     *
     */
    public void  sortProvince(){
        Comparator<City> proComparator = new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                return city1.getProvinceName().compareTo(city2.getProvinceName());
            }
        };
        Collections.sort(cities, proComparator);
    }
}
