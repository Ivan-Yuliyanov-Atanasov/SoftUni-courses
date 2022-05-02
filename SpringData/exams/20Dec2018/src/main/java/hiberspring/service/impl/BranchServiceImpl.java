package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dtos.BranchImportDTO;
import hiberspring.domain.dtos.TownImportDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.FileUtil;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

@Service
public class BranchServiceImpl implements BranchService {

    private static final String BRANCHES_FILE_PATH = "src/main/resources/files/branches.json";
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final BranchRepository branchRepository;

    public BranchServiceImpl(TownService townService, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, FileUtil fileUtil, BranchRepository branchRepository) {
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(BRANCHES_FILE_PATH);
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

        BranchImportDTO[]branches = gson.fromJson(readBranchesJsonFile(), BranchImportDTO[].class);

        Arrays.stream(branches)
                .forEach(branchImportDTO -> {
                    if (!validationUtil.isValid(branchImportDTO)) {
                        sb.append("Error: Invalid data.");

                    } else {
                        Town town = this.townService.findTownByName(branchImportDTO.getTown());

                        this.branchRepository.save(modelMapper.map(branchImportDTO, Branch.class).setTown(town));
                        sb.append(String.format("Successfully imported Branch %s %s.",town.getName(),branchImportDTO.getName()));


                    }

                    sb.append(System.lineSeparator());
                });


        return sb.toString().trim();
    }

    @Override
    public Branch findBranchByName(String name) {
        return this.branchRepository.findByName(name).orElse(null);
    }
}
