public enum Estados {
    PENSANDO("PENSANDO"),
    COMENDO("COMENDO");

    private String estado;

    Estados(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
