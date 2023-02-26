import java.util.Random;

public class PartidoFutbol {
    private EquipoFutbol equipoLocal;
    private EquipoFutbol equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    public PartidoFutbol(EquipoFutbol equipoLocal, EquipoFutbol equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public void jugar() {
        Random random = new Random();
        golesLocal = random.nextInt(5);
        golesVisitante = random.nextInt(5);

        // Se actualizan las estadísticas de los equipos
        equipoLocal.registrarPartido(golesLocal, golesVisitante);
        equipoVisitante.registrarPartido(golesVisitante, golesLocal);

        // Muestra el resultado del partido
        System.out.println(equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre());
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre();
    }
}

