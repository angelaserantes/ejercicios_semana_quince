import java.util.ArrayList;

public interface Equipo {
    String getNombre();
    void setPuntos(int puntos);
    int getPuntos();
    void setPartidosJugados(int partidosJugados);
    int getPartidosJugados();
    void setPartidosGanados(int partidosGanados);
    int getPartidosGanados();
    void setPartidosEmpatados(int partidosEmpatados);
    int getPartidosEmpatados();
    void setPartidosPerdidos(int partidosPerdidos);
    int getPartidosPerdidos();
    void setGolesFavor(int golesFavor);
    int getGolesFavor();
    void setGolesContra(int golesContra);
    int getGolesContra();
    int calcularPuntos();
}
