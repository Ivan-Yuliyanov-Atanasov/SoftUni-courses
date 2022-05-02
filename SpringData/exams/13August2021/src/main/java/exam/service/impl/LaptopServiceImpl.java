package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ExportDTO;
import exam.model.dto.LaptopImportDTO;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    public static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final ShopService shopService;


    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.shopService = shopService;

    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 1;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {

        StringBuilder sb = new StringBuilder();

        LaptopImportDTO[] laptops = gson.fromJson(new FileReader(LAPTOPS_FILE_PATH), LaptopImportDTO[].class);

        Arrays.stream(laptops).forEach(laptop -> {
            if (!validatorUtil.isValid(laptop) || (this.laptopRepository.findByMacAddress(laptop.getMacAddress()) != null)) {
                sb.append("Invalid Laptop");
            } else {
                Shop shop = shopService.findByName(laptop.getShop().getName());
                Laptop currentLaptop = modelMapper.map(laptop, Laptop.class).setShop(shop);
                this.laptopRepository.save(currentLaptop);
                sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d", currentLaptop.getMacAddress(), currentLaptop.getCpuSpeed(), currentLaptop.getRam(), currentLaptop.getStorage()));
            }
            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();
        laptopRepository.findAllLaptops().forEach(sb::append);

        return sb.toString().trim();
    }
}
