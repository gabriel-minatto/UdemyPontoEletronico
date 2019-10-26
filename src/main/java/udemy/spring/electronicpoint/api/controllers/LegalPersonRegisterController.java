package udemy.spring.electronicpoint.api.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import udemy.spring.electronicpoint.api.converter.DTOConverter;
import udemy.spring.electronicpoint.api.dtos.LegalPersonRegisterDto;
import udemy.spring.electronicpoint.api.entities.Company;
import udemy.spring.electronicpoint.api.responses.ResponseWrapper;
import udemy.spring.electronicpoint.api.services.CompanyService;
import udemy.spring.electronicpoint.api.services.EmployeeService;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping("/api/register-lp")
@CrossOrigin(origins = "*")
public class LegalPersonRegisterController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private DTOConverter<Company, LegalPersonRegisterDto> companyConverter;

    /**
     * Register a legal person in the system
     *
     * @param request New legal person's data object
     * @param result
     * @return ResponseEntity<ResponseWrapper<LegalPersonRegisterDto>>
     * @throws NoSuchAlgorithmException
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWrapper<LegalPersonRegisterDto>> create(@Valid @RequestBody LegalPersonRegisterDto request, BindingResult result) throws NoSuchAlgorithmException {
        log.info("Creating Legal Person: {}", request);
        LegalPersonRegisterDto.LegalPersonRegisterDtoBuilder response = LegalPersonRegisterDto.builder();

        //validate

        Company company = companyConverter.toDomain(request);
        //if (result.hasErrors())

        return null;
    }
}
