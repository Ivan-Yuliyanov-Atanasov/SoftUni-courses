package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureImportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 1;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        PictureImportDTO[] pictures = gson.fromJson(new FileReader(PICTURES_FILE_PATH), PictureImportDTO[].class);

        Arrays.stream(pictures).forEach(pictureImportDTO -> {
            if(!validatorUtil.isValid(pictureImportDTO) || (pictureRepository.findByPath(pictureImportDTO.getPath()) != null)) {
                sb.append("Invalid Picture");
            } else {
                this.pictureRepository.save(modelMapper.map(pictureImportDTO, Picture.class));
                sb.append(String.format("Successfully imported Picture, with size %.2f",pictureImportDTO.getSize()));
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();
        this.pictureRepository.findAllBySizeGreaterThanOrderBySize(30000.0)
                .forEach(picture -> {
                    sb.append(String.format("%.2f – %s\n", picture.getSize(), picture.getPath()));
                });

        return sb.toString().trim();
    }

    @Override
    public Picture findPictureByPath(String path) {
        return this.pictureRepository.findByPath(path);
    }


}
