package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostImportRootDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    public static final String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final UserService userService;
    private final PictureService pictureService;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, UserService userService, PictureService pictureService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.pictureService = pictureService;
    }


    @Override
    public boolean areImported() {
        return this.postRepository.count() > 1;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POSTS_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        PostImportRootDTO postRootImportDTO = xmlParser.readFromFile(POSTS_FILE_PATH, PostImportRootDTO.class);
        postRootImportDTO.getPosts().stream()
                .forEach(postImportDTO -> {
                    Picture picture = this.pictureService.findPictureByPath(postImportDTO.getPicture().getPath());
                    User user = this.userService.findUserByUsername(postImportDTO.getUser().getUsername());
                    if(!validatorUtil.isValid(postImportDTO) || picture == null || user == null) {
                        sb.append("Invalid Post");
                    } else {
                        this.postRepository.save(modelMapper.map(postImportDTO, Post.class).setPicture(picture).setUser(user));
                        sb.append(String.format("Successfully imported Post, made by %s",user.getUsername()));
                    }
                    sb.append(System.lineSeparator());
                });
        return sb.toString();
    }
}
