package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.PictureSeedDto;
import softuni.exam.domain.dtos.PictureSeedRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.ValidatorUtilImpl;
import softuni.exam.util.XmlParser;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/xml/pictures.xml";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importPictures() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        PictureSeedRootDto pictureSeedRootDto = xmlParser.readFromFile(PICTURES_FILE_PATH, PictureSeedRootDto.class);
        pictureSeedRootDto.getPictures()
                .forEach(pictureSeedDto -> {
                    if (!validatorUtil.isValid(pictureSeedDto)) {
                        sb.append("Invalid picture").append(System.lineSeparator());
                    } else {
                        Picture picture = modelMapper.map(pictureSeedDto, Picture.class);
                        sb.append(String.format("Successfully imported picture - %s", picture.getUrl())).append(System.lineSeparator());
                        pictureRepository.save(picture);
                    }

                });

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public Picture getPictureByUrl(String url) {

        return pictureRepository.findByUrl(url).orElse(null);
    }


}
