package model;

public enum Tipo {
	
		AVENTURA("Aventura"),
		DEGUSTACION("Degustaci�n"),
		PAISAJE("Paisaje");
		
		private String descripcion; 
		
		private Tipo (String desc) {		
			this.descripcion = desc;
		}
	
		public String getDescripcion() {
			return this.descripcion;
		}
		
		
		
	
	
}
