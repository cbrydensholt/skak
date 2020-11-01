package com.example.skak.Repository;

import com.example.skak.Models.medlem;
import com.example.skak.util.DatabaseConnectionManager;
import com.mysql.cj.protocol.Resultset;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class restanceRepository {


    private Connection conn;

    public restanceRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    public List<medlem> readAllRestancer() {
        List<medlem> alleRestancer = new ArrayList<>();

        try {
            PreparedStatement readAlleRestancer = conn.prepareStatement("SELECT restance.medlemsId, nuværendeRestance, medlemsFornavn, medlemsEfternavn FROM medlemmer INNER JOIN restance ON medlemmer.medlemsId = restance.medlemsId");
            ResultSet rs = readAlleRestancer.executeQuery();
            while (rs.next()) {
                medlem tempMedlem = new medlem();
                tempMedlem.setMedlemsId(rs.getInt(1));
                tempMedlem.setMedlemsRestance(rs.getInt(2));
                tempMedlem.setMedlemsFornavn(rs.getString(3));
                tempMedlem.setMedlemsEfternavn(rs.getString(4));

                alleRestancer.add(tempMedlem);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alleRestancer;
    }

    public void tilføjRykkerGebyr(int medlemsId) {
        int nuværendeRestance = 0;
        try {
            PreparedStatement currentRestance = conn.prepareStatement("SELECT nuværendeRestance FROM restance WHERE medlemsId =?");
            currentRestance.setInt(1, medlemsId);
            ResultSet nuværende = currentRestance.executeQuery();
            while (nuværende.next()) {
                nuværendeRestance = nuværende.getInt(1);
            }

            int restanceMedGebyr = nuværendeRestance + 80;


            PreparedStatement tilføjGebyr = conn.prepareStatement("UPDATE restance SET nuværendeRestance =? where medlemsId =?");
            tilføjGebyr.setInt(1, restanceMedGebyr);
            tilføjGebyr.setInt(2, medlemsId);
            tilføjGebyr.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateRestance(medlem medlem) {

        try {
            PreparedStatement updatemedlem = conn.prepareStatement("UPDATE restance SET nuværendeRestance=? WHERE medlemsId =?");
            updatemedlem.setInt(1, medlem.getMedlemsRestance());
            updatemedlem.setInt(2, medlem.getMedlemsId());
            updatemedlem.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public medlem readRestance(int medlemsId){
        medlem tempMedlem = new medlem();
        try{

            PreparedStatement readmedlem = conn.prepareStatement("SELECT restance.medlemsId, nuværendeRestance, medlemsFornavn, medlemsEfternavn FROM restance INNER JOIN medlemmer ON restance.medlemsId = medlemmer.medlemsId WHERE restance.medlemsId =?");
            readmedlem.setInt(1, medlemsId);
            ResultSet rs = readmedlem.executeQuery();
            while(rs.next()){

                tempMedlem = new medlem();
                tempMedlem.setMedlemsId(rs.getInt(1));
                tempMedlem.setMedlemsRestance(rs.getInt(2));
                tempMedlem.setMedlemsFornavn(rs.getString(3));
                tempMedlem.setMedlemsEfternavn(rs.getString(4));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempMedlem;
    }



}
