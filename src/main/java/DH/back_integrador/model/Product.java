package DH.back_integrador.model;

import DH.back_integrador.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Product {

    @Id
    //@SequenceGenerator(name = "product_generator", sequenceName = "product_generator", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column
    private String name;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String address;
    @Column
    private Integer roomNumber;
    @Column
    private Integer numberOfBathrooms;


    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "city_id",nullable = false)
    private City city;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    //@JsonIgnore
    private Set<Image> images;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @JsonIgnore
    private Set<ProductFeature> productFeatures;


    public Product() {
    }

    public Product(Long id, String name, String title, String description, String address, Integer roomNumber, Integer numberOfBathrooms, Category category, City city, Set<Image> images, Set<ProductFeature> productFeatures) {
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

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String title) {
        this.id = id;
        this.title = title;
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

    public ProductDTO toDto() {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setTitle(title);
        productDto.setDescription(description);
        productDto.setAddress(address);
        productDto.setRoomNumber(roomNumber);
        productDto.setNumberOfBathrooms(numberOfBathrooms);
        productDto.setCategory(category);
        productDto.setCity(city);
        productDto.setImages(images);
        productDto.setProductFeatures(productFeatures);
        return productDto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
