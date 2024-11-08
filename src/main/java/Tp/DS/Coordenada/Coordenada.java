package Tp.DS.Coordenada;

public class Coordenada {
    int id;
    private double lat;
    private double lng;

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

    
}
