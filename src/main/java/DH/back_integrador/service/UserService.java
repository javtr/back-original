package DH.back_integrador.service;

import DH.back_integrador.dto.ReservationDTO;
import DH.back_integrador.exceptions.ResourceNotFoundException;
import DH.back_integrador.model.Product;
import DH.back_integrador.model.Reservation;
import DH.back_integrador.model.Roles;
import DH.back_integrador.model.Users;
import DH.back_integrador.repository.ProductRepository;
import DH.back_integrador.repository.ReservationRepository;
import DH.back_integrador.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {


    @Autowired
    private UsersRepository usersRepository;

    @PersistenceContext
    EntityManager em = null;

    @Autowired
    private JwtUtilService jwtUtil;





    public Users getUserByToker(String token) throws ResourceNotFoundException {
        String usuario = jwtUtil.getUserName(token);

        if (usuario != null && usuario != "" ){

            Users user =  usersRepository.findByEmail(usuario);
            user.setPassword("");
            return user;

        }else{
            throw new ResourceNotFoundException("The user has not been found");
        }

    }





}
