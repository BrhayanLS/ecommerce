package com.ecommerce.Repository;

import com.ecommerce.DTO.rolUsuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolRepository extends MongoRepository<rolUsuario, String> {
}
