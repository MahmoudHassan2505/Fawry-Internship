package org.example;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Health", "postgres", "1Direction")) {

            if (conn != null) {

                Statement selectStatement = conn.createStatement();


                // name of doctors in hospital
//                ResultSet resultSet = selectStatement.executeQuery("select * from doctor where hospital_id = 1;");
//                System.out.println("Name:");
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString(2));
//                }


                // name of patient with doctors
//                ResultSet resultSet = selectStatement.executeQuery("select * from patient left join doctor on doctor.id=doctor_id; ;");
//                while (resultSet.next()) {
//                    System.out.println("Pateint Name: " +resultSet.getString(2)+"\t||\t"+"Doctor Name: "+ resultSet.getString(6));
//                }

                //name of Doctor with the Drug
//                ResultSet resultSet = selectStatement.executeQuery("select doctor.name,drug.name from patient inner join doctor on patient.doctor_id=doctor.id\n" +
//                        "inner join patient_drug on patient.id=patient_drug.patient_id\n" +
//                        "inner join drug on patient_drug.drug_id=drug.id;");
//                while (resultSet.next()) {
//                    System.out.println("Doctor Name: " + resultSet.getString(1) + "\t||\t" + "Drug Name: " + resultSet.getString(2));
//                }


                resultSet.close();
                selectStatement.close();


            } else {
                System.out.println("Error1");
            }

        } catch (SQLException e) {
            System.out.println("Error2");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
