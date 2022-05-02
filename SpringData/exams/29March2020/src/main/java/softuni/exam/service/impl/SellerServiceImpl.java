package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerImportRootDTO;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SellerServiceImpl implements SellerService {
    private static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;

    public SellerServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, SellerRepository sellerRepository, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        SellerImportRootDTO sellerImportRootDTO = xmlParser.readFromFile(SELLERS_FILE_PATH, SellerImportRootDTO.class);

        sellerImportRootDTO.getSellers()
                .forEach(sellerImportDTO -> {
                    if(!validationUtil.isValid(sellerImportDTO)) {
                        sb.append("Invalid seller");
                    } else {
                        this.sellerRepository.save(modelMapper.map(sellerImportDTO, Seller.class));
                        sb.append(String.format("Successfully import seller %s - %s",sellerImportDTO.getLastName(), sellerImportDTO.getEmail()));
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString().trim();
    }

    @Override
    public Seller findSellerById(Long id) {
        return this.sellerRepository.findById(id).orElse(null);
    }
}
