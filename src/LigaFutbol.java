
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LigaFutbol implements Liga {
    private String nombre;
    private ArrayList<EquipoFutbol> equipos;
    private List<List<PartidoFutbol>> jornadas;
    private int jornadaActual = 0;

    public LigaFutbol(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
        this.jornadas = new ArrayList<>();
        this.equipos.add(new EquipoFutbol("Athletic Club"));
        this.equipos.add(new EquipoFutbol("Atlético de Madrid"));
        this.equipos.add(new EquipoFutbol("FC Barcelona"));
        this.equipos.add(new EquipoFutbol("Real Betis Balompié"));
        this.equipos.add(new EquipoFutbol("Cádiz CF"));
        this.equipos.add(new EquipoFutbol("RC Celta de Vigo"));
        this.equipos.add(new EquipoFutbol("Deportivo Alavés"));
        this.equipos.add(new EquipoFutbol("RCD Espanyol"));
        this.equipos.add(new EquipoFutbol("Getafe CF"));
        this.equipos.add(new EquipoFutbol("Granada CF"));
        this.equipos.add(new EquipoFutbol("Levante UD"));
        this.equipos.add(new EquipoFutbol("RCD Mallorca"));
        this.equipos.add(new EquipoFutbol("CA Osasuna"));
        this.equipos.add(new EquipoFutbol("Rayo Vallecano"));
        this.equipos.add(new EquipoFutbol("Real Madrid CF"));
        this.equipos.add(new EquipoFutbol("Real Sociedad de Fútbol"));
        this.equipos.add(new EquipoFutbol("Sevilla FC"));
        this.equipos.add(new EquipoFutbol("Valencia CF"));
        this.equipos.add(new EquipoFutbol("Villarreal CF"));
        this.equipos.add(new EquipoFutbol("CD Lugo "));
        generarCalendario();
    }

    @Override
    public String getNombre() {
        return nombre;
    }


    public ArrayList<EquipoFutbol> getEquipos() {
        return equipos;
    }

    private void generarCalendario() {
        int numEquipos = equipos.size();
        int numJornadas = (numEquipos - 1) * 2;
        int partidosPorJornada = numEquipos / 2;

        // crear las jornadas y los partidos correspondientes
        for (int i = 0; i < numJornadas; i++) {
            List<PartidoFutbol> jornada = new ArrayList<>();
            for (int j = 0; j < partidosPorJornada; j++) {
                int equipoLocal = (i + j) % (numEquipos - 1);
                int equipoVisitante = (numEquipos - 1 - j + i) % (numEquipos - 1);
                if (j == 0) {
                    equipoVisitante = numEquipos - 1;
                }
                jornada.add(new PartidoFutbol(equipos.get(equipoLocal), equipos.get(equipoVisitante)));
            }
            jornadas.add(jornada);

            // rotar los equipos excepto el primero
            EquipoFutbol primerEquipo = equipos.get(0);
            for (int k = 1; k < numEquipos - 1; k++) {
                equipos.set(k - 1, equipos.get(k));
            }
            equipos.set(numEquipos - 2, primerEquipo);
        }
    }



    @Override
    public void simularJornada() {
        if (jornadaActual < jornadas.size()) {
            List<PartidoFutbol> jornada = jornadas.get(jornadaActual);
            for (PartidoFutbol partido : jornada) {
                partido.jugar();
            }
            // actualizar la clasificación
            Collections.sort(equipos);
            jornadaActual++;
        } else {
            System.out.println("La liga ha terminado.");
        }
    }

        @Override
        public void consultarTabla() {
            int posicion = 1;
            System.out.println("                             | PJ | PG | PE | PP | GF | GC | Puntos");
            for (EquipoFutbol equipo : equipos) {
                System.out.println(String.format("%2d - %s", posicion++, equipo));
            }
        }
    }

