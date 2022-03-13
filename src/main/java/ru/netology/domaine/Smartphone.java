package ru.netology.domaine;

import java.util.Objects;

public class Smartphone extends Product{
    private String brand;
    private String manufacturer;

    public Smartphone (){
        super();
    }


    public Smartphone(int id, String name, int price, String brand, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(manufacturer, that.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }


}
