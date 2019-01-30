package com.example.root.contohdata;

public class ModelData {

    String idTeam ;
    String strTeam ;
    String strAlternate ;
    String strManager ;
    String strStadium ;
    String strKeywords ;

    public ModelData(){

    }
    public ModelData(String idTeam, String strTeam, String strAlternate, String strManager, String strStadium, String strKeywords) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strAlternate = strAlternate;
        this.strManager = strManager;
        this.strStadium = strStadium;
        this.strKeywords = strKeywords;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }
}
