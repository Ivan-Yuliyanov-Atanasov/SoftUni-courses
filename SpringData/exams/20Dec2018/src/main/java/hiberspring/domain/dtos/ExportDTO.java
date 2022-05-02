package hiberspring.domain.dtos;

public class ExportDTO {

    private String fullName;

    private String position;

    private String employeeCardNumber;

    public ExportDTO(String fullName, String position, String employeeCardNumber) {
        this.fullName = fullName;
        this.position = position;
        this.employeeCardNumber = employeeCardNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n" +
                "Position: %s\n" +
                "Card Number: %s\n" +
                "-------------------------\n",this.fullName, this.position,this.employeeCardNumber);
    }
}
