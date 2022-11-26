package DH.back_integrador.dto;


import DH.back_integrador.model.*;
import java.util.Set;

public class ProductDTO {

    private Long id;
    private String name;
    private String title;
    private String description;
    private String address;
    private Integer roomNumber;
    private Integer numberOfBathrooms;
    private Category category;
    private City city;
    private Set<Image> images;
    private Set<ProductFeature> productFeatures;

    public ProductDTO(Long id, String name, String title, String description, String address, Integer roomNumber, Integer numberOfBathrooms, Category category, City city, Set<Image> images, Set<ProductFeature> productFeatures) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.address = address;
        this.roomNumber = roomNumber;
        this.numberOfBathrooms = numberOfBathrooms;
        this.category = category;
        this.city = city;
        this.images = images;
        this.productFeatures = productFeatures;
    }

    public ProductDTO(Long id) {
        this.id = id;
    }

    public ProductDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(Integer numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<ProductFeature> getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(Set<ProductFeature> productFeatures) {
        this.productFeatures = productFeatures;
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setTitle(title);
        product.setDescription(description);
        product.setAddress(address);
        product.setRoomNumber(roomNumber);
        product.setNumberOfBathrooms(numberOfBathrooms);
        product.setCategory(category);
        product.setCity(city);
        product.setImages(images);
        product.setProductFeatures(productFeatures);
        return product;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +

                ", title='" + title + '\'' +

                '}';
    }
}
