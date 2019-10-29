/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.model;

/**
 *
 * @author qoheng
 */
public class user {
    
    
    protected user(){
        
        
    }

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        user.userid = userid;
    }

    public static String getPasswrod() {
        return passwrod;
    }

    public static void setPasswrod(String passwrod) {
        user.passwrod = passwrod;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        user.nama = nama;
    }

    public static String getMabna() {
        return mabna;
    }

    public static void setMabna(String mabna) {
        user.mabna = mabna;
    }

    public static String getLantai() {
        return lantai;
    }

    public static void setLantai(String lantai) {
        user.lantai = lantai;
    }

    public static String getKamar() {
        return kamar;
    }

    public static void setKamar(String kamar) {
        user.kamar = kamar;
    }

    public static String getFakultas() {
        return fakultas;
    }

    public static void setFakultas(String fakultas) {
        user.fakultas = fakultas;
    }

    public static String getJurusan() {
        return jurusan;
    }

    public static void setJurusan(String jurusan) {
        user.jurusan = jurusan;
    }

    
    
    

//    Deklarasi variable
    private static String userid;
    private static String passwrod;
    private static String nama;
    private static String mabna;
    private static String lantai;
    private static String kamar;
    private static String fakultas;
    private static String jurusan;
    
}
