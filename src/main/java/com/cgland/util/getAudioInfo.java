package com.cgland.util;

import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

public class getAudioInfo {

    private static String mp3Path = "/Users/ls/Desktop/未命名文件夹/sentence-512576580971560960.mp3";
    private static MP3File mp3File;
    private static final int START=6;

    private static void getHead() {
        try {
            System.out.println("----------------Loading...Head-----------------");

            mp3File = new MP3File(mp3Path);//封装好的类
            MP3AudioHeader header = mp3File.getMP3AudioHeader();
            System.out.println("时长: " + header.getTrackLength()); //获得时长
            System.out.println("比特率: " + header.getBitRate()); //获得比特率
            System.out.println("音轨长度: " + header.getTrackLength()); //音轨长度
            System.out.println("格式: " + header.getFormat()); //格式，例 MPEG-1
            System.out.println("声道: " + header.getChannels()); //声道
            System.out.println("采样率: " + header.getSampleRate()); //采样率
            System.out.println("MPEG: " + header.getMpegLayer()); //MPEG
            System.out.println("MP3起始字节: " + header.getMp3StartByte()); //MP3起始字节
            System.out.println("精确的音轨长度: " + header.getPreciseTrackLength()); //精确的音轨长度
        } catch (Exception e) {
            System.out.println("没有获取到任何信息");
        }
    }

    private static void getContent() {
        try {
            System.out.println("----------------Loading...Content-----------------");
            AbstractID3v2Tag id3v2tag=  mp3File.getID3v2Tag();
            String songName=new String(id3v2tag.frameMap.get("TIT2").toString().getBytes("ISO-8859-1"),"GB2312");
            String singer=new String(id3v2tag.frameMap.get("TPE1").toString().getBytes("ISO-8859-1"),"GB2312");
            String author=new String(id3v2tag.frameMap.get("TALB").toString().getBytes("ISO-8859-1"),"GB2312");
            System.out.println("歌名："+songName.substring(START, songName.length()-3));
            System.out.println("歌手:"+singer.substring(START,singer.length()-3));
            System.out.println("专辑名："+author.substring(START,author.length()-3));
        } catch (Exception e) {
            System.out.println("没有获取到任何信息");
        }
        System.out.println("All Info："+mp3File.displayStructureAsPlainText());
    }
}
