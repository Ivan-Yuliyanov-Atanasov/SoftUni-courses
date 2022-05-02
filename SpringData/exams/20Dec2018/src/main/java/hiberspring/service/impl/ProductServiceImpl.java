package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductImportRootDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.domain.entities.Town;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_PATH = "src/main/resources/files/products.xml";

    private final FileUtil fileUtil;
    private final BranchService branchService;
    private final ProductRepository productRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    public ProductServiceImpl(FileUtil fileUtil, BranchService branchService, ProductRepository productRepository, ValidationUtil validationUtil, ModelMapper modelMapper, XmlParser xmlParser) {
        this.fileUtil = fileUtil;
        this.branchService = branchService;
        this.productRepository = productRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }


    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return fileUtil.readFile(PRODUCTS_FILE_PATH);
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {

            StringBuilder sb = new StringBuilder();

            ProductImportRootDTO products = xmlParser.parseXml(ProductImportRootDTO.class, PRODUCTS_FILE_PATH);

            products.getProducts()
                    .forEach(productImportDTO -> {
                        if (!validationUtil.isValid(productImportDTO)) {
                            sb.append("Error: Invalid data.");

                        } else {

                            Branch branch = this.branchService.findBranchByName(productImportDTO.getBranch());
                            this.productRepository.save(modelMapper.map(productImportDTO, Product.class).setBranch(branch));
                            sb.append(String.format("Successfully imported %s.",productImportDTO.getName()));


                        }

                        sb.append(System.lineSeparator());
                    });


        return sb.toString().trim();
    }
}
