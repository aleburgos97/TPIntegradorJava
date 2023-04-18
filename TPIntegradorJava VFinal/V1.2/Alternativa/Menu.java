package alt;

public class Menu {
	//Test
	public static void main (String[]args) {
		PronosticosDeportivos pronos = new PronosticosDeportivos ("/home/bigballs/Documentos/GitHub/Eclipse/AP40Main/src/alt/Partidos");
		pronos.agregarParticipante("Daniel", "/home/bigballs/Documentos/GitHub/Eclipse/AP40Main/src/alt/ApuestasDaniel");
		pronos.agregarParticipante("Eduardo", "/home/bigballs/Documentos/GitHub/Eclipse/AP40Main/src/alt/ApuestasEduardo");
		pronos.cerrar();
	}
}
