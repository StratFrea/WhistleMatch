package IO;

import Assignments.Game;
import Assignments.GameDatabase;
import Person.Assignor;
import Person.Official;
import Person.User;
import Person.UserDatabase;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileIO {

    public static void saveGames(String fileName, GameDatabase gameDatabase) {
        File file = new File(fileName);
        //TODO Get better try and catch
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Writing to the file

        // Header:
        String[] header = {"gameID", "organizationName", "assignor", "official1", "official2", "official3", "date", "startTime", "endTime", "team1", "team2", "location", "division"};
        csvWriter.writeNext(header);

        for (Game game: gameDatabase.getGames()) {
            String[] data = {game.getGameID().toString(), game.getOrganizationName(), String.valueOf(game.getAssignor().getUserID()), String.valueOf(game.getOfficial1().getUserID()), String.valueOf(game.getOfficial2().getUserID()), String.valueOf(game.getOfficial3().getUserID()), game.getDate().toString(), game.getStartTime().toString(), game.getEndTime().toString(), game.getTeam1(), game.getTeam2(), game.getLocation(), game.getDivision()};
            csvWriter.writeNext(data);
        }
        // Close file
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadGames(File file, GameDatabase gameDatabase, UserDatabase userDatabase) {
        // TODO More explicit try and catch
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;

        Integer gameID = null;
        String organizationName = null;
        String assignor = null;
        String official1 = null;
        String official2 = null;
        String official3 = null;
        LocalDate date = null;
        LocalTime startTime = null;
        LocalTime endTime = null;
        String team1 = null;
        String team2 = null;
        String location = null;
        String division = null;
        try {
            nextRecord = csvReader.readNext();
            while (nextRecord != null) {
                gameID = Integer.parseInt(nextRecord[0]);
                organizationName = nextRecord[1];
                assignor = nextRecord[2];
                official1 = nextRecord[3];
                official2 = nextRecord[4];
                official3 = nextRecord[5];
                date = LocalDate.parse(nextRecord[6]);

                // Format start and end time

                startTime = LocalTime.parse(nextRecord[7]);
                endTime = LocalTime.parse(nextRecord[8]);
                team1 = nextRecord[9];
                team2 = nextRecord[10];
                location = nextRecord[11];
                division = nextRecord[12];
                nextRecord = csvReader.readNext();

                Game game = new Game(gameDatabase);
                game.setGameID(gameID);
                game.setOrganizationName(organizationName);
                game.setAssignor((Assignor) userDatabase.getUser(Integer.parseInt(assignor)));
                if (assignor != null) {
                    game.setAssignor((Assignor) userDatabase.getUser(Integer.parseInt(assignor)));
                } else {game.setAssignor(null);}
                if (official1 != null) {
                    game.setOfficial1((Official) userDatabase.getUser(Integer.valueOf(official1)));
                } else {game.setOfficial1(null);}
                if (official2 != null) {game.setOfficial2((Official) userDatabase.getUser(Integer.valueOf(official2)));}
                else {game.setOfficial2(null);}
                if (official3 != null) {
                    game.setOfficial3((Official) userDatabase.getUser(Integer.valueOf(official3)));
                } else {game.setOfficial3(null);}
                game.setDate(date);
                game.setStartTime(startTime);
                game.setEndTime(endTime);
                game.setTeam1(team1);
                game.setTeam2(team2);
                game.setLocation(location);
                game.setDivision(division);
                gameDatabase.addGame(game);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Close file
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveUsers(String fileName, UserDatabase userDatabase) {
        File file = new File(fileName);
        //TODO Get better try and catch
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Header:
        String[] header = {"userID", "type", "name", "email", "hashedPassword"};
        csvWriter.writeNext(header);

        // All entries
        for (User user: userDatabase.getUsers()) {
            String[] data = {user.getUserID().toString(),String.valueOf(user.getType()), user.getName(), user.getEmail(), user.getHashedPassword()};
            csvWriter.writeNext(data);
        }
        // Close file
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadUsers(String fileName, UserDatabase userDatabase) {
        // TODO More explicit try and catch
        File file = new File(fileName);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fileReader);
        String[] nextRecord;

        Integer userID = null;
        String name = null;
        String email = null;
        String hashedPassword = null;
        User.UserType type = null;
        try {
            nextRecord = csvReader.readNext();
            nextRecord = csvReader.readNext();
            while (nextRecord != null) {
                userID = Integer.parseInt(nextRecord[0]);
                type = User.UserType.valueOf(nextRecord[1]);
                name = nextRecord[2];
                email = nextRecord[3];
                hashedPassword = nextRecord[4];

                if (type == User.UserType.OFFICIAL) {
                    userDatabase.addUser(new Official(name, email, hashedPassword, userDatabase));
                } else if (type == User.UserType.ASSIGNOR) {
                    userDatabase.addUser(new Assignor(name, email, hashedPassword, userDatabase));
                }
                nextRecord = csvReader.readNext();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Close file
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
