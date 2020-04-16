package app;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;

import java.util.List;

public class AlbumManager {
    public static void main(String[] args){

        ArtistsEntity artistsEntity = new ArtistsEntity();
        artistsEntity.setName("Gigel");
        artistsEntity.setCountry("Romania");

        ArtistRepository artistRepository = new ArtistRepository();
        artistRepository.create(artistsEntity);

        List<ArtistsEntity> artistsEntityList = artistRepository.findByName("Gigel");
        for (ArtistsEntity artistsEntity1:
                artistsEntityList) {
            System.out.println(artistsEntity1.getName());
        }

        ArtistsEntity artistsEntity1 = artistRepository.findById(1);
        System.out.println(artistsEntity1.getName());

        AlbumsEntity albumsEntity = new AlbumsEntity();
        albumsEntity.setArtistId(1);
        albumsEntity.setName("Manele 2020");
        albumsEntity.setReleaseYear(2020);
        AlbumRepository albumRepository = new AlbumRepository();
        albumRepository.create(albumsEntity);

        List<AlbumsEntity> albumsEntityList = albumRepository.findByName("Manele 2020");
        for (AlbumsEntity albumsEntity1:
                albumsEntityList) {
            System.out.println(albumsEntity1.getName());
        }

        AlbumsEntity albumById = albumRepository.findById(1);
        System.out.println(albumById.getReleaseYear());

        List<AlbumsEntity> albumsEntityListByArtist = albumRepository.findByArtist(artistsEntity1);
        for (AlbumsEntity a:
                albumsEntityListByArtist) {
            System.out.println(a.getArtistId());
        }

    }
}