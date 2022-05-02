package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PictureImportDTO;
import softuni.exam.instagraphlite.models.dto.UserImportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;


@Service
public class UserServiceImpl implements UserService {

    public static final String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, PictureService pictureService) {
        this.userRepository = userRepository;

        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.pictureService = pictureService;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 1;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USERS_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        UserImportDTO[] users = gson.fromJson(new FileReader(USERS_FILE_PATH), UserImportDTO[].class);
        Arrays.stream(users).forEach(userImportDTO -> {
            Picture picture = this.pictureService.findPictureByPath(userImportDTO.getProfilePicture());
            if (!validatorUtil.isValid(userImportDTO) || picture == null || (this.userRepository.findByUsername(userImportDTO.getUsername())) != null) {
                sb.append("Invalid User");
            } else {
                this.userRepository.save(modelMapper.map(userImportDTO, User.class).setProfilePicture(picture));
                sb.append(String.format("Successfully imported User: %s",userImportDTO.getUsername()));

            }
            sb.append(System.lineSeparator());
        });

        return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        this.userRepository.exportUsers()
                .forEach(user -> {
                    sb.append(String.format("User: %s\n" +
                            "Post count: %d\n" +
                            "==Post Details:\n",user.getUsername(), user.getPosts().size()));
                    user.getPosts()
                            .stream()
                            .sorted(Comparator.comparingDouble(p -> p.getPicture().getSize()))
                            .forEach(p -> sb.append(String.format("----Caption: %s\n" +
                                    "----Picture Size: %.2f\n",p.getCaption(),p.getPicture().getSize())));
                });
        return sb.toString().trim();
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
