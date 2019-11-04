package com.cgland.util;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;
import java.io.IOException;

/**
 * jave 文档：http://www.sauronsoftware.it/projects/jave/manual.php
 *
 */
public class ChangeSampleRate
{
    private static String WAV_CODEC = "pcm_s16le";

    private static String MP3_CODEC = "libmp3lame";

    public static void main( String[] args ) throws IOException, EncoderException {
        transRate(16000,"/home/workman/audio.wav","/home/workman/audio1.wav");

    }

    // 修改音频采样率
    public static void transRate(int rate,String fromFilename, String toFilename) throws IOException, EncoderException, EncoderException {

        AudioAttributes audio = new AudioAttributes();

        audio.setCodec(WAV_CODEC);
        audio.setBitRate(rate);
        audio.setSamplingRate(rate);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("wav");
        attrs.setAudioAttributes(audio);

        Encoder encoder = new Encoder();
        File inputFile = new File(fromFilename);
        encoder.encode(inputFile,new File(toFilename), attrs);




    }

}
