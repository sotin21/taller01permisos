import java.util.ArrayList;
import java.util.List;
class Ciudadano {
    private String nombre;
    private String direccion;
    private List<Permiso> permisos;

    public Ciudadano(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.permisos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void agregarPermiso(Permiso permiso) {
        permisos.add(permiso);
    }

    public List<Permiso> buscarPermisosPorTipo(String tipo) {
        List<Permiso> permisosEncontrados = new ArrayList<>();
        for (Permiso permiso : permisos) {
            if (permiso.getTipo().equalsIgnoreCase(tipo)) {
                permisosEncontrados.add(permiso);
            }
        }
        return permisosEncontrados;
    }

    public List<Permiso> buscarPermisosPorFechaEmision(String fechaEmision) {
        List<Permiso> permisosEncontrados = new ArrayList<>();
        for (Permiso permiso : permisos) {
            if (permiso.getFechaEmision().equalsIgnoreCase(fechaEmision)) {
                permisosEncontrados.add(permiso);
            }
        }
        return permisosEncontrados;
    }

    public List<Permiso> buscarPermisosPorFechaVencimiento(String fechaVencimiento) {
        List<Permiso> permisosEncontrados = new ArrayList<>();
        for (Permiso permiso : permisos) {
            if (permiso.getFechaVencimiento().equalsIgnoreCase(fechaVencimiento)) {
                permisosEncontrados.add(permiso);
            }
        }
        return permisosEncontrados;
    }
}