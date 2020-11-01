package com.example.skak.Repository;


import com.example.skak.Models.medarbejder;
import com.example.skak.Models.medlem;
import com.example.skak.util.DatabaseConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class arbejderRepository {

        private Connection conn;
        public arbejderRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}




        public medarbejder readArbejder(int arbejderId){
            medarbejder tempmedarbejder = new medarbejder();
            try{

                PreparedStatement readArbejder = conn.prepareStatement("SELECT * FROM medarbejdere WHERE arbejderId =?");
                readArbejder.setInt(1, arbejderId);
                ResultSet rs = readArbejder.executeQuery();
                while(rs.next()){

                    tempmedarbejder = new medarbejder();
                    tempmedarbejder.setArbejderId(rs.getInt(1));
                    tempmedarbejder.setArbejderFornavn(rs.getString(2));
                    tempmedarbejder.setArbejderEfternavn(rs.getString(3));
                    tempmedarbejder.setArbejderTelefon(rs.getInt(4));
                    tempmedarbejder.setArbejderTitel(rs.getString(5));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return tempmedarbejder;
        }

        public List<medarbejder> readAlleArbejdere(){
            List<medarbejder> alleMedarbejdere = new ArrayList<>();

            try{
                PreparedStatement readAllmedarbejdere = conn.prepareStatement("SELECT * FROM medarbejdere");
                ResultSet rs = readAllmedarbejdere.executeQuery();
                while(rs.next()){
                    medarbejder tempmedarbejder = new medarbejder();
                    tempmedarbejder.setArbejderId(rs.getInt(1));
                    tempmedarbejder.setArbejderFornavn(rs.getString(2));
                    tempmedarbejder.setArbejderEfternavn(rs.getString(3));
                    tempmedarbejder.setArbejderTelefon(rs.getInt(4));
                    tempmedarbejder.setArbejderTitel(rs.getString(5));

                    alleMedarbejdere.add(tempmedarbejder);


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return alleMedarbejdere;
        }




        public void deleteArbejder(int arbejderId){

            try {
                PreparedStatement deletemedarbejder = conn.prepareStatement("DELETE FROM medarbejdere WHERE arbejderId = ?");
                deletemedarbejder.setInt(1, arbejderId);
                deletemedarbejder.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        public void updateArbejder(medarbejder medarbejder){

            try{
                PreparedStatement updatemedarbejder = conn.prepareStatement("UPDATE medarbejdere SET arbejderFornavn=?, arbejderEfternavn=?, arbejderTelefon=?, arbejderTitel=? WHERE arbejderId =?");
                updatemedarbejder.setString(1, medarbejder.getArbejderFornavn());
                updatemedarbejder.setString(2, medarbejder.getArbejderEfternavn());
                updatemedarbejder.setInt(3, medarbejder.getArbejderTelefon());
                updatemedarbejder.setString(4, medarbejder.getArbejderTitel());
                updatemedarbejder.setInt(5, medarbejder.getArbejderId());
                updatemedarbejder.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }



    public medarbejder createArbejder(medarbejder medarbejder){

        try {
            PreparedStatement createArbejder = conn.prepareStatement("INSERT INTO medarbejdere(arbejderFornavn, arbejderEfternavn, arbejderTelefon, arbejderTitel)" + "VALUES(?,?,?,?) ");
            createArbejder.setString(1, medarbejder.getArbejderFornavn());
            createArbejder.setString(2, medarbejder.getArbejderEfternavn());
            createArbejder.setInt(3, medarbejder.getArbejderTelefon());
            createArbejder.setString(4, medarbejder.getArbejderTitel());

            createArbejder.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medarbejder;

    }



    }
