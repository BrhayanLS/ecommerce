package com.ecommerce.Repository;

import com.ecommerce.DTO.userDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepository extends MongoRepository<userDTO ,String> {
}
