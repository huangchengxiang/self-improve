package com.aibank.jdk8.collector;

import com.aibank.jdk8.data.Album;
import com.aibank.jdk8.data.Artist;
import com.aibank.jdk8.data.Track;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.*;

public class CollectorDemo {

    public static List<Album> albumList;

    public static void main(String[] args){

        // 找出乐队成员最多的乐队
        Optional<Artist> artistOptional = albumList.stream()
                .map(album -> album.getMusician())
                .filter(artist -> artist.getMembers() != null) // or, will get NullPointException
                .collect(maxBy(comparing(artist -> artist.getMembers().size())));
        System.out.println(artistOptional);

        System.out.println("=================================");

        //找出一组专辑上曲目的平均数
        double averageTracks = albumList.stream().collect(averagingInt(album -> album.getTracks().size()));
        System.out.println("一组专辑上曲目的平均数:" + averageTracks);

        System.out.println("=================================");

        //收集格式化艺术家列表
        String artistList= albumList.stream()
                .map(album -> album.getMusician())
                .map(artist -> artist.getName())
                .distinct()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(artistList);

        System.out.println("=================================");

        //计算每个艺术家专辑数
        albumList.stream()
                .collect(groupingBy(album -> album.getMusician().getName(), counting()))
                .forEach((artistName, cnt) -> {
                    System.out.println(artistName + ":" + cnt);
                });

        System.out.println("=================================");

        //求每个艺术家的专辑名
        albumList.stream()
                .collect(groupingBy(album -> album.getMusician().getName(), mapping(album -> album.getName(), toList())))
                .forEach((artistName, albums) -> {
                    System.out.println(artistName + ":" + albums);
                });

        System.out.println("=================================");

        //求每个艺术家的专辑名
        albumList.stream()
                .collect(groupingBy(album -> album.getMusician().getName(),
                                    mapping(album -> album.getName(), Collectors.joining(" , ", "[", "]"))))
                .forEach((artistName, albums) -> {
                    System.out.println(artistName + ":" + albums);
                });


    }


    static  {

        albumList = new ArrayList<>();

        List<Track>  tracks = new ArrayList<>();
        tracks.add(new Track("Yestoday once more", 521L));
        tracks.add(new Track("My Heart Will Go On", 434L));
        tracks.add(new Track("Heal The World", 234L));
        tracks.add(new Track("Auld Lang Syne", 897L));
        tracks.add(new Track("Casablanca", 223L));
        tracks.add(new Track("More Than I Can Say", 674L));
        tracks.add(new Track("Sound of Silence", 532L));
        Album album = new Album("sunshine", new Date(), tracks, new Artist("Tom", null, "Beijing"));
        albumList.add(album);

        List<Track>  tracks2 = new ArrayList<>();
        tracks2.add(new Track("Yestoday once more", 521L));
        tracks2.add(new Track("My Heart Will Go On", 434L));
        tracks2.add(new Track("The World", 234L));
        tracks2.add(new Track("Syne", 1893L));
        tracks2.add(new Track("Casablanca", 223L));
        tracks2.add(new Track("I Can Say", 562L));
        Album album2 = new Album("river", new Date(), tracks2, new Artist("Tom", null, "Beijing"));
        albumList.add(album2);

        List<Track>  tracks3 = new ArrayList<>();
        tracks3.add(new Track("Yestoday once more", 231L));
        tracks3.add(new Track("My Heart Will Go On", 434L));
        tracks3.add(new Track("Heal The World", 234L));
        tracks3.add(new Track("The one you love", 897L));
        tracks3.add(new Track("Because I love you", 564L));
        tracks3.add(new Track("More Than I Can Say", 674L));
        List<String> members3 = new ArrayList<>();
        members3.add("AWM");
        members3.add("AK47");
        members3.add("VECTOR");
        members3.add("98K");
        members3.add("Scagr");
        Album album3 = new Album("mountain", new Date(), tracks3, new Artist("The Beatles", members3, "Hubei"));
        albumList.add(album3);

        List<Track>  tracks4 = new ArrayList<>();
        tracks4.add(new Track("Yestoday", 521L));
        tracks4.add(new Track("My Heart", 434L));
        tracks4.add(new Track("Casablanca", 223L));
        List<String> members4 = new ArrayList<>();
        members4.add("Huangbo");
        members4.add("Xiening");
        Album album4 = new Album("Ocean", new Date(), tracks4, new Artist("Blue sand", members4, "Hubei"));
        albumList.add(album4);

        List<Track>  tracks5 = new ArrayList<>();
        tracks5.add(new Track("Once more", 521L));
        tracks5.add(new Track("First Time", 897L));
        tracks5.add(new Track("Good bye", 223L));
        tracks5.add(new Track("More Than I Can Say", 674L));
        tracks5.add(new Track("Hi", 430L));
        Album album5 = new Album("rain", new Date(), tracks5, new Artist("Tom", null, "Beijing"));
        albumList.add(album5);

        List<Track>  tracks6 = new ArrayList<>();
        tracks6.add(new Track("Good morning", 521L));
        tracks6.add(new Track("I am ok", 434L));
        tracks6.add(new Track("More Than I Can Say", 674L));
        tracks6.add(new Track("Sound of Silence", 532L));
        Album album6 = new Album("love", new Date(), tracks6, new Artist("Jack", null, "Beijing"));
        albumList.add(album6);

        List<Track>  tracks7 = new ArrayList<>();
        tracks7.add(new Track("Yestoday", 521L));
        tracks7.add(new Track("Today", 434L));
        tracks7.add(new Track("Time", 234L));
        tracks7.add(new Track("Day", 897L));
        tracks7.add(new Track("weekend", 223L));
        Album album7 = new Album("time", new Date(), tracks7, new Artist("Lily", null, "Beijing"));
        albumList.add(album7);

        List<Track>  tracks8 = new ArrayList<>();
        tracks8.add(new Track("Book", 521L));
        tracks8.add(new Track("road", 434L));
        tracks8.add(new Track("World", 234L));
        Album album8 = new Album("world", new Date(), tracks8, new Artist("Vencent", null, "Hainan"));
        albumList.add(album8);

        List<Track>  tracks9 = new ArrayList<>();
        tracks9.add(new Track("Light", 521L));
        tracks9.add(new Track("Dark", 434L));
        tracks9.add(new Track("White", 234L));
        tracks9.add(new Track("Color", 897L));
        Album album9 = new Album("color", new Date(), tracks9, new Artist("Robert", null, "Chongqi"));
        albumList.add(album9);
    }


}
