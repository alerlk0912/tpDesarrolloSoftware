package Tp.DS.Coordenada;

import java.util.Objects;

public class Coordenada {
    int id;
    private double lat;
    private double lng;

    public Coordenada(int id, double lat, double lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }
    
    public Coordenada(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public double calcularDistancia(Coordenada otraCoordenada) {
        final int RADIO_TIERRA = 6371;
        double latDistancia = Math.toRadians(otraCoordenada.getLat() - this.lat);
        double lngDistancia = Math.toRadians(otraCoordenada.getLng() - this.lng);
        double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2)
                + Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(otraCoordenada.getLat()))
                * Math.sin(lngDistancia / 2) * Math.sin(lngDistancia / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIO_TIERRA * c;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordenada that = (Coordenada) o;

        return id == that.id &&
               Double.compare(that.lat, lat) == 0 &&
               Double.compare(that.lng, lng) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lat, lng);
    }
}
