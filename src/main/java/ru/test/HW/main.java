package ru.test.HW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Driver loaded");

            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String user = "root";
            String password = "";

            try (Connection conn = DriverManager.getConnection(url, user, password)){
                Statement stmt = conn.createStatement();

                String groups = "CREATE TABLE Groups (\n" +
                        "Id INT IDENTITY(1,1) PRIMARY KEY," +
                        "Name NVARCHAR(10) NOT NULL UNIQUE," +
                        "[Year] INT NOT NULL CHECK ([Year] BETWEEN 1 AND 5)," +
                        "DepartmentId INT NOT NULL," +
                        "FOREIGN KEY (DepartmentId) REFERENCES Departments(Id)" +
                        ");";

                int createRows = stmt.executeUpdate(groups);
                System.out.println("Была создана" + createRows);


                String subjects = "CREATE TABLE Subjects (" +
                        "Id INT IDENTITY(1,1) PRIMARY KEY," +
                        "Name NVARCHAR(100) NOT NULL UNIQUE" +
                        ");";

                int createRows2 = stmt.executeUpdate(subjects);
                System.out.println("Была создана" + createRows2);



                String teachers = "CREATE TABLE Teachers (" +
                        "Id INT IDENTITY(1,1) PRIMARY KEY," +
                        "Name NVARCHAR(50) NOT NULL," +
                        "Salary MONEY NOT NULL CHECK (Salary > 0)," +
                        "Surname NVARCHAR(50) NOT NULL" +
                        ");";

                int createRows3 = stmt.executeUpdate(teachers);
                System.out.println("Была создана" + createRows3);


                String groupsADD = "INSERT INTO Groups (Name, Year) " +
                        " VALUES (`1A` , `2`), " +
                                "(`2SP` , `3`), " +
                                "(`1SP` , `1`), " +
                                "(`2TOP3` , `3`), " +
                                "(`4TOP4` , `4`) " ;

                int createGroupsADD = stmt.executeUpdate(groupsADD);
                System.out.println("Было добавлено" + createGroupsADD);


                String subjectsADD = "INSERT INTO Subjects (Name) " +
                        " VALUES (`Философия`), " +
                                "(`Черчение`), " +
                                "(`Экономика`), " +
                                "(`Информатика`) ";


                int createSubjectsADD = stmt.executeUpdate(subjectsADD);
                System.out.println("Было добавлено" + createSubjectsADD);



                String teachersADD = "INSERT INTO Teachers (Name, Salary, Surname) " +
                        " VALUES (`Robert` , `30000`, `Pierce`), " +
                        "(`Chris` , `45000`, `West`), " +
                        "(`Mark` , `50000`, `Edwards`), " +
                        "(`Mary` , `35000`, `Vargas`), " +
                        "(`Jessica` , `40000`, `Nelson`) " ;

                int createTeachersADD = stmt.executeUpdate(teachersADD);
                System.out.println("Было добавлено" + createTeachersADD);


                String teachersUpdate = "UPDATE Teachers SET Salary = `65000` WHERE Id = 1";
                int createTeachersUpdate = stmt.executeUpdate(teachersUpdate);
                System.out.println("Обновлено" + createTeachersUpdate);


                String subjectsDelete = "DELETE FROM Subjects WHERE Id = 3";
                int createSubjectsUpdate = stmt.executeUpdate(subjectsDelete);
                System.out.println("Обновлено" + createSubjectsUpdate);

            }
            
        }catch (Exception e) {
            System.out.println("Driver not loaded");
            System.out.println(e.getMessage());
        }
    }
}

