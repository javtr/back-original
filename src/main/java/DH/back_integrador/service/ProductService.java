package DH.back_integrador.service;

import DH.back_integrador.dto.ProductDTO;
import DH.back_integrador.exceptions.ResourceNotFoundException;
import DH.back_integrador.model.*;
import DH.back_integrador.repository.CategoryRepository;
import DH.back_integrador.repository.CityRepository;
import DH.back_integrador.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private  ReservationService reservationService;

    public List<ProductDTO> getAllProduct(){
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productsDTOList;
        productsDTOList= productList.stream().map(p -> p.toDto()).collect(Collectors.toList());

        return productsDTOList;
    }

    public ProductDTO saveProduct(ProductDTO productDTO) throws ResourceNotFoundException {
        Optional<Category> category = categoryRepository.findById(productDTO.getCategory().getId());
        Optional<City> city = cityRepository.findById(productDTO.getCity().getId());
        if (category.isPresent() && city.isPresent()) {
            Product product = productRepository.save(productDTO.toEntity());
            return  product.toDto();
        } else {
            if (category.isEmpty()) {
                throw new ResourceNotFoundException("The category with id " + productDTO.getCategory().getId() + " has not been found.");
            } else if (city.isEmpty()) {
                throw new ResourceNotFoundException("The city with id " + productDTO.getCategory().getId() + " has not been found.");
            } else {
                throw new ResourceNotFoundException("The category with id " + productDTO.getCategory().getId() + "and the city with id" + productDTO.getCategory().getId() + " has not been found.");
            }
        }
    }

    public ProductDTO getProduct(Long id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);


        if (product.isPresent()){
            return product.get().toDto();
        }else {
            return null;
        }

    }




    public List<ProductDTO> getProductsByCategory(Long category_id) throws ResourceNotFoundException {

        List<Product> productList = null;
        List<ProductDTO> productsDTOList;

        Optional<Category> searchedCategory = categoryRepository.findById(category_id);
        if (searchedCategory.isPresent()){
            productList =productRepository.getProductsByCategory(category_id);
        }else {
            throw new ResourceNotFoundException("The category with id " + category_id + " has not been found.");
        }

        productsDTOList= productList.stream().map(p -> p.toDto()).collect(Collectors.toList());
        return productsDTOList ;



    }

    public List<ProductDTO> getProductsByCity(Long city_id) throws ResourceNotFoundException{
        List<Product> productList = null;
        List<ProductDTO> productsDTOList;

        Optional<City> searchedCategory = cityRepository.findById(city_id);
        if (searchedCategory.isPresent()){
            productList =productRepository.getProductsByCity(city_id);
        }else {
            throw new ResourceNotFoundException("The category with id " + city_id + " has not been found.");
        }

        productsDTOList= productList.stream().map(p -> p.toDto()).collect(Collectors.toList());

        return productsDTOList ;


    }



    public ProductDTO updateProduct(ProductDTO productDTO) throws ResourceNotFoundException {
       ProductDTO productDTO1 = getProduct(productDTO.getId());
       Product product = new Product();
        if (productDTO1!=null) {
            product = productRepository.save(productDTO.toEntity());
            return product.toDto();
        } else {
            throw new ResourceNotFoundException("The feature with id " + productDTO1.getId() + " has not been found.");
        }
    }

    public String deleteProduct(Long id) throws ResourceNotFoundException{
        Optional<Product> productToDelete = productRepository.findById(id);

        if (productToDelete.isPresent()) {
            productRepository.delete(productToDelete.get());
            return "The product with id "+productToDelete.get().getId()+ " has been deleted ";

        } else {
            throw new ResourceNotFoundException("The product with id " + id + " has not been found to be deleted.");
        }




    }


    public List<Feature> getFeaturesByProduct(Long product_id) throws ResourceNotFoundException{
        Optional <Product> searchedFeatures = productRepository.findById(product_id);
        if (searchedFeatures.isPresent()) {
          return productRepository.getFeaturesByProducts(product_id);
        } else {
            throw new ResourceNotFoundException("The feature with id " + product_id + " has not been found.");
        }
    }

    public  List<ProductDTO> findAllBetweenDates(LocalDate startDate, LocalDate endDate) throws ResourceNotFoundException {

        Optional<List<Product>> listOptional = productRepository.findProductsXDates(startDate,endDate);
        List<Product> products = null;

        if (listOptional.isPresent()){
            products =listOptional.get();
        }



        List<ProductDTO> productsDTOList= products.stream().map(p->p.toDto()).collect(Collectors.toList());
        return productsDTOList;


      /*  List<ReservationDTO> reservationList = reservationService.findAll();

        List<ReservationDTO> reservationList2 = reservationList.stream()
                .filter(reservation -> reservation.getCheckIn().isAfter(startDate)&&
                        reservation.getCheckIn().isBefore(endDate)||reservation.getCheckOut().isBefore(endDate)
                        && reservation.getCheckOut().isAfter(startDate)).collect(Collectors.toList());
        Set<ProductDTO> productDTOList = new HashSet<>();
        System.out.println(reservationList2.toString());

        List<ProductDTO> productDTOListFree2 = new ArrayList<>();


        for(ReservationDTO reservation : reservationList2){

            productDTOList.add(getProduct(reservation.getProduct().getId()));
            productDTOListFree2.stream().map(
                    productDTO -> productDTO.getId().equals(reservation.getProduct().getId())
            );
        }
        System.out.println(productDTOList.toString());
        System.out.println(productDTOListFree2.toString());
       return null;
    */
    }

    public List<ProductDTO> findByProductBetweenDatesAndCity( LocalDate startDate, LocalDate endDate, Long id){
      ;
        Optional<List<Product>> listOptional = productRepository.findProductsXDatesAndCity(startDate,endDate,id);
        List<Product> products = null;
        if (listOptional.isPresent()){
            products =listOptional.get();
        }
        List<ProductDTO> productsDTOList= products.stream().map(p->p.toDto()).collect(Collectors.toList());

        return productsDTOList;
    }






}
