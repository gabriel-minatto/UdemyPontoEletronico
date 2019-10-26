package udemy.spring.electronicpoint.api.dtos;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import udemy.spring.electronicpoint.api.validation.UniqueCompanyCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//using a few javax validators because some hibernate validators are deprecated

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegalPersonRegisterDto {

    private Long id;

    @NotEmpty(message = "Name is required and can't be empty.")
    @Length(min = 3, max = 200, message = "The name's length must be between 3 and 200 characters.")
    private String name;

    @NotEmpty(message = "Email is required and can't be empty.")
    @Length(min = 5, max = 200, message = "The email's length must be between 5 and 200 characters.")
    @Email(message = "Invalid format for web email.")
    private String email;

    @NotEmpty(message = "Password is required and can't be empty.")
    private String password;

    @NotEmpty(message = "CPF is required and can't be empty.")
    @CPF(message = "Invalid format for CPF.")
    private String cpf;

    @NotEmpty(message = "CorporateName is required and can't be empty.")
    @Length(min = 5, max = 200, message = "The corporate name's length must be between 5 and 200 characters.")
    private String corporateName;

    @UniqueCompanyCnpj
    @NotEmpty(message = "CNPJ is required and can't be empty.")
    @CNPJ(message = "Invalid format for CNPJ.")
    private String cnpj;
}
