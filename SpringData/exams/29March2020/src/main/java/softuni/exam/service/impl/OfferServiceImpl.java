package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImportRootDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final OfferRepository offerRepository;
    private final SellerService sellerService;
    private final CarService carService;

    public OfferServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser, OfferRepository offerRepository, SellerService sellerService, CarService carService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.offerRepository = offerRepository;
        this.sellerService = sellerService;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        OfferImportRootDTO offerImportRootDTO = xmlParser.readFromFile(OFFERS_FILE_PATH, OfferImportRootDTO.class);

        offerImportRootDTO.getOffers()
                .forEach(offerImportDTO -> {
                    if(!validationUtil.isValid(offerImportDTO)) {
                        sb.append("Invalid offer");
                    } else {
                        Seller seller = this.sellerService.findSellerById(offerImportDTO.getSeller().getId());
                        Car car = this.carService.findById(offerImportDTO.getCar().getId());
                        Offer offer = modelMapper.map(offerImportDTO, Offer.class).setCar(car).setSeller(seller);
                        this.offerRepository.save(offer);
                        sb.append(String.format("Successfully import offer %s - %s",offer.getAddedOn(),offerImportDTO.isHasGoldStatus()));
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
