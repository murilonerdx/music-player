package com.company;


import javax.sound.sampled.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Musica music = new Musica();
        String respostaMusica = music.mostrarMusica();
        music.selecionarMusica(respostaMusica);
        music.play();
        music.playMusic();
    }
}
