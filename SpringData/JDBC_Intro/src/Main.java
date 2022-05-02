import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "minions_db";
    private static Connection connection;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws SQLException, IOException {

         /*
        In createConnection() method, you can hardcode your username(at line 261) and password (at line 262),
        so it won't be necessary to write them everytime when the program starts.
         */

        connection = createConnection();
        selectExercise();

    }

    private static void selectExercise() throws SQLException, IOException {
        System.out.println("Please enter exercise number:");
        int exerciseNumber = Integer.parseInt(reader.readLine());
        switch (exerciseNumber) {
            case 2:
                exerciseTwo();
                break;
            case 3:
                exerciseThree();
                break;
            case 4:
                exerciseFour();
                break;
            case 5:
                exerciseFive();
                break;
            case 6:
                exerciseSix();
                break;
            case 7:
                exerciseSeven();
                break;
            case 8:
                exerciseEight();
                break;
            case 9:
                exerciseNine();
                break;
        }
    }

    private static void exerciseSix() throws IOException, SQLException {
        System.out.println("Please enter villain id:");
        int villain_id = Integer.parseInt(reader.readLine());
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM minions_villains " +
                "WHERE villain_id = ?");
        preparedStatement.setInt(1, villain_id);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("No such villain was found");
        } else {
            String villainName = findEntityNameById(villain_id, "villains");
            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released", affectedRows);
        }
    }

    private static String findEntityNameById(int id, String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM " + tableName + " WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            return resultSet.getString(1);

        }
        return null;
    }

    private static void exerciseNine() throws IOException, SQLException {
        System.out.println("Please enter minion id:");
        int minion_id = Integer.parseInt(reader.readLine());
        CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
        callableStatement.setInt(1, minion_id);
        callableStatement.execute();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        preparedStatement.setInt(1, minion_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));


    }

    private static void exerciseEight() throws IOException, SQLException {
        System.out.println("Please enter minion IDs:");
        String[] ids = reader.readLine().split(" ");

        for (int i = 0; i < ids.length; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE minions " +
                    "SET age = age + 1, name = LOWER(name)  " +
                    "WHERE id = ?");
            preparedStatement.setInt(1, Integer.parseInt(ids[i]));
            preparedStatement.execute();

        }
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    private static void exerciseSeven() throws SQLException {
        PreparedStatement selectStatement = connection.prepareStatement("SELECT name FROM minions");
        ResultSet resultSet = selectStatement.executeQuery();
        List<String> minionNames = new ArrayList<>();
        while (resultSet.next()) {
            minionNames.add(resultSet.getString(1));
        }
        for (int i = 0; i < minionNames.size() / 2; i++) {
            System.out.println(minionNames.get(i));
            System.out.println(minionNames.get(minionNames.size() - 1 - i));
        }
    }

    private static void exerciseFive() throws IOException, SQLException {

        System.out.println("Please enter country name:");
        String countryName = reader.readLine();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE towns  " +
                "SET name = UPPER(name) " +
                "WHERE country = ?");
        preparedStatement.setString(1, countryName);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            System.out.println("No town names were affected.");
        } else {
            PreparedStatement selectStatement = connection.prepareStatement("SELECT name FROM towns " +
                    "WHERE country = ?");
            selectStatement.setString(1, countryName);
            ResultSet resultSet = selectStatement.executeQuery();
            System.out.printf("%d town names were affected.%n", affectedRows);
            List<String> towns = new ArrayList<>();
            while (resultSet.next()) {
                towns.add(resultSet.getString(1));
            }
            System.out.println(towns);
        }


    }

    private static void exerciseFour() throws IOException, SQLException {
        System.out.println("Please enter information for the minion:");
        String[] minionInfo = reader.readLine().split(" ");
        System.out.println("Please enter information for the villain:");
        String[] villainInfo = reader.readLine().split(" ");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String villainName = villainInfo[1];
        int townId = findEntityIdByName(minionTown, "towns");
        int villainId = findEntityIdByName(villainName, "villains");

        if (townId == 0) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `towns` (`name`) VALUES (?)");
            preparedStatement.setString(1, minionTown);
            preparedStatement.execute();
            System.out.printf("Town %s was added to the database.%n", minionTown);
            townId = findEntityIdByName(minionTown, "towns");
        }
        if (villainId == 0) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `villains` (`name`, `evilness_factor`) VALUES (?, 'evil')");
            preparedStatement.setString(1, villainName);
            preparedStatement.execute();
            System.out.printf("Villain %s was added to the database.%n", villainName);
            villainId = findEntityIdByName(villainName, "villains");
        }
        PreparedStatement minionInsertStatement = connection.prepareStatement("INSERT INTO `minions` (`name`, `age`, `town_id`) VALUES (?, ?, ?)");
        minionInsertStatement.setString(1, minionName);
        minionInsertStatement.setInt(2, minionAge);
        minionInsertStatement.setInt(3, townId);
        minionInsertStatement.execute();

        int minionId = findEntityIdByName(minionName, "minions");

        PreparedStatement minionToVillain = connection.prepareStatement("INSERT INTO `minions_villains` (`minion_id`, `villain_id`) VALUES (?, ?)");
        minionToVillain.setInt(1, minionId);
        minionToVillain.setInt(2, villainId);
        minionToVillain.execute();
        System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);

    }

    private static int findEntityIdByName(String entityName, String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM " + tableName + " WHERE name = ?");
        preparedStatement.setString(1, entityName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            return resultSet.getInt(1);

        }
        return 0;
    }

    private static void exerciseThree() throws SQLException, IOException {
        System.out.println("Please enter villain id:");
        int villainId = Integer.parseInt(reader.readLine());
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.name, m.name, m.age FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "JOIN minions m on mv.minion_id = m.id\n" +
                "WHERE v.id = ?\n" +
                "GROUP BY m.id");

        preparedStatement.setInt(1, villainId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int counter = 0;
            System.out.printf("Villain: %s%n", resultSet.getString(1));
            System.out.printf("%d. %s %d%n", ++counter, resultSet.getString(2), resultSet.getInt(3));
            while (resultSet.next()) {
                System.out.printf("%d. %s %d%n", ++counter, resultSet.getString(2), resultSet.getInt(3));
            }
        } else {
            System.out.printf("No villain with ID %d exists in the database.", villainId);

        }
    }

    private static void exerciseTwo() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT v.name, COUNT(DISTINCT minion_id) AS minion_count FROM villains AS v\n" +
                "JOIN minions_villains mv on v.id = mv.villain_id\n" +
                "GROUP BY v.id\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC");

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString(1), resultSet.getInt(2));
        }
    }

    public static Connection createConnection() throws SQLException, IOException {



        System.out.println("Please enter username:");
        String username = reader.readLine();
        System.out.println("Please enter password:");
        String password = reader.readLine();
        Properties properties = new Properties();
        properties.setProperty("user", username);
        properties.setProperty("password", password);

        return DriverManager.getConnection(CONNECTION_STRING + DATABASE_NAME, properties);
    }

}
