package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Guinness")
                            .beerStyle("STOUT")
                            .quantityToBrew(12)
                            .upc(337010000001L)
                            .price(new BigDecimal("29.90"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Heineken")
                    .beerStyle("PILSNER")
                    .quantityToBrew(200)
                    .upc(337010000002L)
                    .price(new BigDecimal("6.90"))
                    .build());
        }
    }
}
