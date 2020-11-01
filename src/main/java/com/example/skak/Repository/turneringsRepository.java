package com.example.skak.Repository;

import com.example.skak.Models.Turnering;
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
public class turneringsRepository{

    private Connection conn;

    public turneringsRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    public Turnering readTurnering(int turneringsId){
        Turnering tempTurnering = new Turnering();
        try{

            PreparedStatement readmedlem = conn.prepareStatement("SELECT * FROM turneringer WHERE turneringsId =?");
            readmedlem.setInt(1, turneringsId);
            ResultSet rs = readmedlem.executeQuery();
            while(rs.next()){

                tempTurnering = new Turnering();
                tempTurnering.setTurneringsId(rs.getInt(1));
                tempTurnering.setTurneringsNavn(rs.getString(2));
                tempTurnering.setAntalDeltagere(rs.getInt(3));
                tempTurnering.setDato(rs.getString(4));
                tempTurnering.setDeltagerKategori(rs.getString(5));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tempTurnering;
    }

    public List<Turnering> readAllTurneringer(){
        List<Turnering> alleTurneringer = new ArrayList<>();

        try{
            PreparedStatement readAllTurneringer = conn.prepareStatement("SELECT * FROM turneringer");
            ResultSet rs = readAllTurneringer.executeQuery();
            while(rs.next()){
                Turnering tempTurnering = new Turnering();
                tempTurnering.setTurneringsId(rs.getInt(1));
                tempTurnering.setTurneringsNavn(rs.getString(2));
                tempTurnering.setAntalDeltagere(rs.getInt(3));
                tempTurnering.setDato(rs.getString(4));
                tempTurnering.setDeltagerKategori(rs.getString(5));

                alleTurneringer.add(tempTurnering);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alleTurneringer;
    }


    public Turnering createTurnering(Turnering turnering){
        int maxId = 0;
        try {
            PreparedStatement createTurnering = conn.prepareStatement("INSERT INTO turneringer(turneringsNavn, antalDeltagere, dato, deltagerKategori)" + "VALUES(?,?,?,?) ");
            createTurnering.setString(1, turnering.getTurneringsNavn());
            createTurnering.setInt(2, turnering.getAntalDeltagere());
            createTurnering.setString(3, turnering.getDato());
            createTurnering.setString(4, turnering.getDeltagerKategori());

            createTurnering.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turnering;
    }


    public void deleteTurnering(int turneringsId){
        try {
            PreparedStatement deleteTurnering = conn.prepareStatement("DELETE FROM turneringer WHERE turneringsId = ?");
            deleteTurnering.setInt(1, turneringsId);
            deleteTurnering.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateTurnering(Turnering turnering){

        try{
            PreparedStatement updateTurnering = conn.prepareStatement("UPDATE turneringer SET turneringsNavn=?, antalDeltagere=?, dato=?, deltagerKategori=? WHERE turneringsId =?");
            updateTurnering.setString(1, turnering.getTurneringsNavn());
            updateTurnering.setInt(2, turnering.getAntalDeltagere());
            updateTurnering.setString(3, turnering.getDato());
            updateTurnering.setString(4, turnering.getDeltagerKategori());
            updateTurnering.setInt(5, turnering.getTurneringsId());
            updateTurnering.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




}
