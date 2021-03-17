package com.company;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Musica {

    Scanner scanner = new Scanner(System.in);
    String nomeMusica = "";
    File file;
    Clip clip;
    Player player;

    String diretorio = System.getProperty("user.dir") + "\\src\\com\\company\\musica";
    String diretorioMediaPlayer;
    AudioInputStream audioStream;

    File path = new File(diretorio);
    File[] files = path.listFiles(File::isFile);
    String[] pegarExtensao;

    String respostaMusica = "";
    String resposta = "";
    int qtdEscolha = 1;

    public Musica() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    }

    public String mostrarMusica() {
        for (File arquivo : files) {
            System.out.println(qtdEscolha + " - " + arquivo.getName());
            qtdEscolha++;
        }
//        for (String musica : listaMusicas) {
//            System.out.println(qtdEscolha + " - " + musica);
//            qtdEscolha++;
//        }
        qtdEscolha = 1;
        System.out.println("# [ === Escolha a musica === ] #");
        System.out.print("---> ");
        return respostaMusica = scanner.next();
    }

    public void playMusic() throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException {
        while (!resposta.equals("Q")) {
            System.out.println("========================================================================");
            System.out.println("|| P = Play  S = Stop   R = Reset    T = Trocar de musica    Q = Quit ||");
            System.out.println("========================================================================");
            System.out.println("# [ === Escolha sua opção === ] #");
            System.out.print("---> ");
            resposta = scanner.next();
            resposta = resposta.toUpperCase();

            switch (resposta) {
                case ("P"):
                    clip.start();
                    break;
                case ("S"):
                    clip.stop();
                    break;
                case ("R"):
                    clip.setMicrosecondPosition(0);
                    break;
                case ("Q"):
                    clip.close();
                    break;
                case ("T"):
                    clip.stop();
                    respostaMusica = mostrarMusica();
                    selecionarMusica(respostaMusica);
                    play();
                    playMusic();
                    return;
                default:
                    System.out.println("Sua escolha não é valida!");
            }
        }
    }

    public void selecionarMusica(String respostaMusica) throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException {
        switch (respostaMusica) {

            case ("1"):
                setNomeMusica(files[0].getName());
                setFile(new File(diretorio + "/" + getNomeMusica()));
                pegarExtensao = files[0].getName().trim().split("\\.");
                audioStream = AudioSystem.getAudioInputStream(getFile());
                clip = AudioSystem.getClip();
                break;
            case ("2"):
                setNomeMusica(files[1].getName());
                setFile(new File(diretorio + "/" + getNomeMusica()));
                pegarExtensao = files[1].getName().trim().split("\\.");
                audioStream = AudioSystem.getAudioInputStream(getFile());
                clip = AudioSystem.getClip();
                break;
            case ("3"):
                setNomeMusica(files[2].getName());
                setFile(new File(diretorio + "/" + getNomeMusica()));
                pegarExtensao = files[2].getName().trim().split("\\.");
                audioStream = AudioSystem.getAudioInputStream(getFile());
                clip = AudioSystem.getClip();
                break;
            default:
                System.out.println("Sua escolha não é valida!");
        }

    }

    public void play() throws IOException, LineUnavailableException, JavaLayerException, UnsupportedAudioFileException {
        clip.open(getAudioStream());
        clip.start();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }


    public String getRespostaMusica() {
        return respostaMusica;
    }

    public void setRespostaMusica(String respostaMusica) {
        this.respostaMusica = respostaMusica;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getQtdEscolha() {
        return qtdEscolha;
    }

    public void setQtdEscolha(int qtdEscolha) {
        this.qtdEscolha = qtdEscolha;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public AudioInputStream getAudioStream() {
        return audioStream;
    }

    public void setAudioStream(AudioInputStream audioStream) {
        this.audioStream = audioStream;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
