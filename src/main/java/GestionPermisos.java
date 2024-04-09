import java.util.ArrayList;
import java.util.List;
public class GestionPermisos {
    private List<Ciudadano> ciudadanos;

    public GestionPermisos() {
        this.ciudadanos = new ArrayList<>();
    }

    public void registrarCiudadano(String nombre, String direccion) {
        Ciudadano ciudadano = new Ciudadano(nombre, direccion);
        ciudadanos.add(ciudadano);
    }

    public void registrarPermiso(String nombreCiudadano, Permiso permiso) {
        Ciudadano ciudadano = buscarCiudadano(nombreCiudadano);
        if (ciudadano != null) {
            ciudadano.agregarPermiso(permiso);
        } else {
            System.out.println("Ciudadano no encontrado");
        }
    }

    public List<Permiso> buscarPermisosPorTipo(String nombreCiudadano, String tipo) {
        Ciudadano ciudadano = buscarCiudadano(nombreCiudadano);
        if (ciudadano != null) {
            return ciudadano.buscarPermisosPorTipo(tipo);
        } else {
            System.out.println("Ciudadano no encontrado");
            return new ArrayList<>();
        }
    }

    public List<Permiso> buscarPermisosPorFechaEmision(String nombreCiudadano, String fechaEmision) {
        Ciudadano ciudadano = buscarCiudadano(nombreCiudadano);
        if (ciudadano != null) {
            return ciudadano.buscarPermisosPorFechaEmision(fechaEmision);
        } else {
            System.out.println("Ciudadano no encontrado");
            return new ArrayList<>();
        }
    }

    public List<Permiso> buscarPermisosPorFechaVencimiento(String nombreCiudadano, String fechaVencimiento) {
        Ciudadano ciudadano = buscarCiudadano(nombreCiudadano);
        if (ciudadano != null) {
            return ciudadano.buscarPermisosPorFechaVencimiento(fechaVencimiento);
        } else {
            System.out.println("Ciudadano no encontrado");
            return new ArrayList<>();
        }
    }

    public void mostrarPermisos(String nombreCiudadano) {
        Ciudadano ciudadano = buscarCiudadano(nombreCiudadano);
        if (ciudadano != null) {
            List<Permiso> permisos = ciudadano.getPermisos();
            for (Permiso permiso : permisos) {
                System.out.println("Tipo: " + permiso.getTipo());
                System.out.println("Fecha de Emisión: " + permiso.getFechaEmision());
                System.out.println("Fecha de Vencimiento: " + permiso.getFechaVencimiento());
                System.out.println("Costo: " + permiso.calcularCosto());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Ciudadano no encontrado");
        }
    }

    public Permiso obtenerInformacionCompletaPermiso(String nombreCiudadano, String tipo, String fechaEmision, String fechaVencimiento) {
        List<Permiso> permisos = buscarPermisosPorTipo(nombreCiudadano, tipo);
        for (Permiso permiso : permisos) {
            if (permiso.getFechaEmision().equals(fechaEmision) && permiso.getFechaVencimiento().equals(fechaVencimiento)) {
                return permiso;
            }
        }
        return null;
    }

    private Ciudadano buscarCiudadano(String nombreCiudadano) {
        for (Ciudadano ciudadano : ciudadanos) {
            if (ciudadano.getNombre().equalsIgnoreCase(nombreCiudadano)) {
                return ciudadano;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GestionPermisos gestionPermisos = new GestionPermisos();

        gestionPermisos.registrarCiudadano("Seba Soto", "Calle Falsa 123");
        gestionPermisos.registrarCiudadano("Maria", "Avenida siempre viva 36");

        Permiso permisoNegocio = new PermisoNegocio("Negocio", "2024-04-01", "2024-04-30", 500, 100, 5);
        Permiso permisoConstruccion = new PermisoConstruccion("Construccion", "2024-04-05", "2024-05-30", 1000, 200);
        Permiso permisoEventoEspecial = new PermisoEventoEspecial("Evento Especial", "2023-01-03", "2027-04-15", 200, 500);

        gestionPermisos.registrarPermiso("Seba Soto", permisoNegocio);
        gestionPermisos.registrarPermiso("Seba Soto", permisoConstruccion);
        gestionPermisos.registrarPermiso("Maria", permisoEventoEspecial);

        List<Permiso> permisosSebaSoto = gestionPermisos.buscarPermisosPorTipo("Seba Soto", "Negocio");
        System.out.println("Permisos de Seba Soto:");
        for (Permiso permiso : permisosSebaSoto) {
            System.out.println("Tipo: " + permiso.getTipo() + ", Costo: " + permiso.calcularCosto());
        }

        List<Permiso> permisosMaria = gestionPermisos.buscarPermisosPorFechaVencimiento("Maria", "2027-04-15");
        System.out.println("\nPermisos de Maria:");
        for (Permiso permiso : permisosMaria) {
            System.out.println("Tipo: " + permiso.getTipo() + ", Costo: " + permiso.calcularCosto());
        }

        System.out.println("\nInformación completa del permiso de Maria:");
        Permiso permisoMaria = gestionPermisos.obtenerInformacionCompletaPermiso("Maria", "Evento Especial", "2023-01-03", "2027-04-15");
        if (permisoMaria != null) {
            System.out.println("Tipo: " + permisoMaria.getTipo());
            System.out.println("Fecha de Emisión: " + permisoMaria.getFechaEmision());
            System.out.println("Fecha de Vencimiento: " + permisoMaria.getFechaVencimiento());
            System.out.println("Costo: " + permisoMaria.calcularCosto());
        } else {
            System.out.println("Permiso no encontrado");
        }
    }
}