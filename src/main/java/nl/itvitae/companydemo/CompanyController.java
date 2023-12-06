package nl.itvitae.companydemo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin("${cors}")
@RequestMapping("api/v1/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;
    @GetMapping
    public Iterable<Company> get() {
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Company> getById(@PathVariable long id) {
        return companyRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company newCompany, UriComponentsBuilder ucb) {
        companyRepository.save(newCompany);
        URI locationOfNewCompany = ucb
                .path("/api/v1/companies/{id}")
                .buildAndExpand(newCompany.getId())
                .toUri();
        return ResponseEntity.created(locationOfNewCompany).body(newCompany);
    }
}
