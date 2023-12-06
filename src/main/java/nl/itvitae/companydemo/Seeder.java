package nl.itvitae.companydemo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final CompanyRepository companyRepository;
    @Override
    public void run(String... args) throws Exception {
        if (companyRepository.count() == 0) {
            companyRepository.save(new Company("Apple", 1000000));
        }
    }
}
