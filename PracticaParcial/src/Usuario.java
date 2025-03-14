    public abstract class Usuario implements Administrable {
        private String nombre;
        private String apellido;
        private String carrera;
        private String estado;
    
        public Usuario(String nombre, String apellido, String carrera) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.carrera = carrera;
            this.estado = "activo";
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getApellido() {
            return apellido;
        }
    
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    
        public String getCarrera() {
            return carrera;
        }
    
        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
    
        public String getEstado() {
            return estado;
        }
    
        public void setEstado(String estado) {
            this.estado = estado;
        }
    
        public void imprimir() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellido: " + apellido);
            System.out.println("Carrera: " + carrera);
            System.out.println("Estado: " + estado);
        }
    
        @Override
        public void desactivar() {
            if (estado.equals("activo")) {
                estado = "inactivo";
                System.out.println("Usuario desactivado.");
            } else {
                System.out.println("El usuario ya había sido desactivado.");
            }
        }
    }   
