package isi.deso.tpds;

class Coordenada {
    private double lat;
    private double lng;

    public Coordenada(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    // Método para calcular la distancia usando la fórmula de Haversine
    public double calcularDistancia(Coordenada otraCoordenada) {
        final int RADIO_TIERRA = 6371; // Radio de la tierra en kilómetros
        double latDistancia = Math.toRadians(otraCoordenada.getLat() - this.lat);
        double lngDistancia = Math.toRadians(otraCoordenada.getLng() - this.lng);
        double a = Math.sin(latDistancia / 2) * Math.sin(latDistancia / 2)
                + Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(otraCoordenada.getLat()))
                * Math.sin(lngDistancia / 2) * Math.sin(lngDistancia / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIO_TIERRA * c;
    }
}