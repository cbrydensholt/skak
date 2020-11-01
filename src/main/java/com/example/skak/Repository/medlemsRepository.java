package com.example.skak.Repository;

import com.example.skak.Models.medlem;
import org.springframework.stereotype.Repository;
import com.example.skak.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class medlemsRepository {

    private Connection conn;
    public medlemsRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}




    public medlem readMedlem(int medlemsId){
       medlem tempMedlem = new medlem();
        try{

            PreparedStatement readmedlem = conn.prepareStatement("SELECT * FROM medlemmer WHERE medlemsId =?");
            readmedlem.setInt(1, medlemsId);
            ResultSet rs = readmedlem.executeQuery();
            while(rs.next()){

                tempMedlem = new medlem();
                tempMedlem.setMedlemsId(rs.getInt(1));
                tempMedlem.setMedlemsFornavn(rs.getString(2));
                tempMedlem.setMedlemsEfternavn(rs.getString(3));
                tempMedlem.setMedlemsTelefon(rs.getInt(4));
                tempMedlem.setMedlemsKategori(rs.getString(5));
                tempMedlem.setMedlemsRating(rs.getInt(6));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempMedlem;
    }

    public List<medlem> readAllMedlemmer(){
    List<medlem> alleMedlemmer = new ArrayList<>();

        try{
            PreparedStatement readAllmedlemmer = conn.prepareStatement("SELECT * FROM medlemmer");
            ResultSet rs = readAllmedlemmer.executeQuery();
            while(rs.next()){
                medlem tempMedlem = new medlem();
                tempMedlem.setMedlemsId(rs.getInt(1));
                tempMedlem.setMedlemsFornavn(rs.getString(2));
                tempMedlem.setMedlemsEfternavn(rs.getString(3));
                tempMedlem.setMedlemsTelefon(rs.getInt(4));
                tempMedlem.setMedlemsKategori(rs.getString(5));
                tempMedlem.setMedlemsRating(rs.getInt(6));

                alleMedlemmer.add(tempMedlem);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alleMedlemmer;
    }


    public medlem createMedlem(medlem medlem){
    int maxId = 0;
        try {
            PreparedStatement createMedlem = conn.prepareStatement("INSERT INTO medlemmer(medlemsFornavn, medlemsEfternavn, medlemsTelefon, medlemsKategori, medlemsRating)" + "VALUES(?,?,?,?,?) ");
            createMedlem.setString(1, medlem.getMedlemsFornavn());
            createMedlem.setString(2, medlem.getMedlemsEfternavn());
            createMedlem.setInt(3, medlem.getMedlemsTelefon());
            createMedlem.setString(4, medlem.getMedlemsKategori());
            createMedlem.setInt(5, medlem.getMedlemsRating());

            createMedlem.executeUpdate();

            PreparedStatement getLastCustomerId = conn.prepareStatement("SELECT max(medlemsId) FROM medlemmer");
            ResultSet lastId = getLastCustomerId.executeQuery();
            while(lastId.next()){
            maxId = lastId.getInt(1);
            }


            PreparedStatement opretRestance = conn.prepareStatement("INSERT INTO restance(medlemsId, nuværendeRestance)" + "VALUES(?,?)");
            opretRestance.setInt(1, maxId);
            opretRestance.setInt(2, medlem.getMedlemsRestance());
            opretRestance.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medlem;
    }


    public void deleteMedlem(int medlemsId){
        medlem medlem;
        try {
            PreparedStatement deletemedlem = conn.prepareStatement("DELETE FROM medlemmer WHERE medlemsId = ?");
            deletemedlem.setInt(1, medlemsId);
            deletemedlem.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateMedlem(medlem medlem){

        try{
            PreparedStatement updatemedlem = conn.prepareStatement("UPDATE medlemmer SET medlemsFornavn=?, medlemsEfternavn=?, medlemsTelefon=?, medlemsKategori=?, medlemsRating=? WHERE medlemsId =?");
            updatemedlem.setString(1, medlem.getMedlemsFornavn());
            updatemedlem.setString(2, medlem.getMedlemsEfternavn());
            updatemedlem.setInt(3, medlem.getMedlemsTelefon());
            updatemedlem.setString(4, medlem.getMedlemsKategori());
            updatemedlem.setInt(5, medlem.getMedlemsRating());
            updatemedlem.setInt(6, medlem.getMedlemsId());
            updatemedlem.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }






        }


    public void styrkejustering(medlem medlemfrompost){

        try{

            PreparedStatement updaterating = conn.prepareStatement("UPDATE medlemmer SET medlemsRating=? where medlemsId =?");
            updaterating.setInt(1, medlemfrompost.getMedlemsRating());
            updaterating.setInt(2, medlemfrompost.getMedlemsId());

            updaterating.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public medlem searchForMember(int medlemsTelefon){
        medlem tempmedlem = new medlem();

        try{
            PreparedStatement searchname = conn.prepareStatement("SELECT * FROM medlemmer where medlemsTelefon =?");
            searchname.setInt(1, medlemsTelefon);

           ResultSet rs = searchname.executeQuery();

           while(rs.next()){
               tempmedlem = new medlem();
               tempmedlem.setMedlemsId(rs.getInt(1));
               tempmedlem.setMedlemsFornavn(rs.getString(2));
               tempmedlem.setMedlemsEfternavn(rs.getString(3));
               tempmedlem.setMedlemsTelefon(rs.getInt(4));
               tempmedlem.setMedlemsKategori(rs.getString(5));
               tempmedlem.setMedlemsRating(rs.getInt(6));




           }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return tempmedlem;

    }



}
