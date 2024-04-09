class PermisoEventoEspecial extends Permiso {
    private int cantidadAsistentes;
    private static final double TARIFA_POR_100_ASISTENTES = 100000;

    public PermisoEventoEspecial(String tipo, String fechaEmision, String fechaVencimiento, double costoBase, int cantidadAsistentes) {
        super(tipo, fechaEmision, fechaVencimiento, costoBase);
        this.cantidadAsistentes = cantidadAsistentes;
    }

    @Override
    public double calcularCosto() {
        return costoBase + (cantidadAsistentes / 100 * TARIFA_POR_100_ASISTENTES);
    }
}
