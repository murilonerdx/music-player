package com.company;

import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, JavaLayerException {
        Musica music = new Musica();
        String respostaMusica = music.mostrarMusica();
        music.selecionarMusica(respostaMusica);
        music.play();
        music.playMusic();
    }
}
