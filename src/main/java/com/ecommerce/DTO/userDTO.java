package com.ecommerce.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuario")
public class userDTO {
    @Id
    private String id ;

    private  String nombre;
    private String email;
    private String password;
    private rolUsuario ROL_USUARIO;

}
