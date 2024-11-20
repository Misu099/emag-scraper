package me.realprice.emag_scraper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneDTO implements Serializable {

    private String name;
    private int id;
    private String url;
    private float price;
    private float averageRating;
    private String brand;


    public PhoneDTO() {
    }

    public PhoneDTO(String name, int id, String url, float price, float averageRating, String brand) {
        this.name = name;
        this.id = id;
        this.url = url;
        this.price = price;
        this.brand = brand;
        this.averageRating = averageRating;
    }

    public PhoneDTO(String phoneName, int phoneId, String phoneUrl, float phonePrice, String phoneBrand) {
        this.name = phoneName;
        this.id = phoneId;
        this.url = phoneUrl;
        this.price = phonePrice;
        this.brand = phoneBrand;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", averageRating=" + averageRating +
                ", brand='" + brand + '\'' +
                '}';
    }
}
