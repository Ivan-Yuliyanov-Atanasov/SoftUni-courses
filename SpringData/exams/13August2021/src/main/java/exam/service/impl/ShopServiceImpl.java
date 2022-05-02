package exam.service.impl;

import exam.model.dto.ShopImportDTO;
import exam.model.dto.ShopRootImportDTO;
import exam.model.dto.TownRootImportDTO;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidatorUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    public static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
    }



    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 1;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        ShopRootImportDTO shopRootImportDTO = xmlParser.readFromFile(SHOPS_FILE_PATH, ShopRootImportDTO.class);
        shopRootImportDTO.getShops().forEach(shopImportDTO -> {

            if(!validatorUtil.isValid(shopImportDTO) || (this.shopRepository.findByName(shopImportDTO.getName()) != null)) {
                sb.append("Invalid Shop");

            } else {
                Town town = townService.findByName(shopImportDTO.getTown().getName());

                Shop shop = modelMapper.map(shopImportDTO, Shop.class).setTown(town);

                this.shopRepository.save(shop);
                sb.append(String.format("Successfully imported Shop %s - %s",shop.getName(),shop.getIncome()));
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }


    @Override
    public Shop findByName(String name) {
        return this.shopRepository.findByName(name);
    }




}
