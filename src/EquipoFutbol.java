public class EquipoFutbol implements Comparable<EquipoFutbol>, Equipo {
    private String nombre;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;
    private int golesContra;

    public EquipoFutbol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPuntos(int puntos) {

    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    @Override
    public void setPartidosGanados(int partidosGanados) {

    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    @Override
    public void setPartidosEmpatados(int partidosEmpatados) {

    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    @Override
    public void setPartidosPerdidos(int partidosPerdidos) {

    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    @Override
    public void setGolesFavor(int golesFavor) {

    }

    public int getGolesFavor() {
        return golesFavor;
    }

    @Override
    public void setGolesContra(int golesContra) {

    }

    public int getGolesContra() {
        return golesContra;
    }

    @Override
    public int calcularPuntos() {
        return 0;
    }

    public int getPuntos() {
        return (partidosGanados * 3) + partidosEmpatados;
    }

    @Override
    public void setPartidosJugados(int partidosJugados) {

    }

    public void registrarPartido(int golesFavor, int golesContra) {
        partidosJugados++;
        this.golesFavor += golesFavor;
        this.golesContra += golesContra;
        if (golesFavor > golesContra) {
            partidosGanados++;
        } else if (golesFavor == golesContra) {
            partidosEmpatados++;
        } else {
            partidosPerdidos++;
        }
    }

    @Override
    public int compareTo(EquipoFutbol otroEquipo) {
        int puntosEsteEquipo = this.getPuntos();
        int puntosOtroEquipo = otroEquipo.getPuntos();

        if (puntosEsteEquipo > puntosOtroEquipo) {
            return -1;
        } else if (puntosEsteEquipo < puntosOtroEquipo) {
            return 1;
        } else {
            int difGolesEsteEquipo = this.golesFavor - this.golesContra;
            int difGolesOtroEquipo = otroEquipo.golesFavor - otroEquipo.golesContra;

            if (difGolesEsteEquipo > difGolesOtroEquipo) {
                return -1;
            } else if (difGolesEsteEquipo < difGolesOtroEquipo) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-24s| %2d | %2d | %2d | %2d | %2d | %2d | %2d", nombre, partidosJugados, partidosGanados,
                partidosEmpatados, partidosPerdidos, golesFavor, golesContra, getPuntos());
    }
}
