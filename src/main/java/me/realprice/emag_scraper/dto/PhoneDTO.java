package me.realprice.emag_scraper.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneDTO implements Serializable {

    private String name;
    private int id;
    private int offerId;
    private String url;
    private float price;
    private float recommendedRetailPrice;
    private String brand;
    private float averageRating;


    public PhoneDTO(String name, int id, int offerId, String url, float price, float recommendedRetailPrice, String brand, float averageRating) {
        this.name = name;
        this.id = id;
        this.offerId = offerId;
        this.url = url;
        this.price = price;
        this.recommendedRetailPrice = recommendedRetailPrice;
        this.brand = brand;
        this.averageRating = averageRating;
    }

    public PhoneDTO() {
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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
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

    public float getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public void setRecommendedRetailPrice(float recommendedRetailPrice) {
        this.recommendedRetailPrice = recommendedRetailPrice;
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
                ", offerId=" + offerId +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", recommendedRetailPrice=" + recommendedRetailPrice +
                ", brand='" + brand + '\'' +
                ", averageRating=" + averageRating +
                '}';
    }
}
