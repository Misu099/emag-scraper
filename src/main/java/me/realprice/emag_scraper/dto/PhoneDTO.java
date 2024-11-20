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
    //TODO: make this a float and change the logic for parser
    private String recommendedRetailPrice;
    private float averageRating;
    private String brand;


    public PhoneDTO() {
    }

    public PhoneDTO(String name, int id, int offerId, String url, float price, String recommendedRetailPrice, float averageRating, String brand) {
        this.name = name;
        this.id = id;
        this.offerId = offerId;
        this.url = url;
        this.price = price;
        this.recommendedRetailPrice = recommendedRetailPrice;
        this.brand = brand;
        this.averageRating = averageRating;
    }

    public PhoneDTO(String phoneName, int phoneId, int phoneOfferId, String phoneUrl, float phonePrice, String phoneBrand) {
        this.name = phoneName;
        this.id = phoneId;
        this.offerId = phoneOfferId;
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

    public String getRecommendedRetailPrice() {
        return recommendedRetailPrice;
    }

    public void setRecommendedRetailPrice(String recommendedRetailPrice) {
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
                ", averageRating=" + averageRating +
                ", brand='" + brand + '\'' +
                '}';
    }
}
