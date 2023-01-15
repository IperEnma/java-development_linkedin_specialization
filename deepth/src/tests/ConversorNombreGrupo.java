package tests;
import java.util.HashMap; // import the HashMap class
import java.util.Map;

public class ConversorNombreGrupo {
	
	private static final Map<String, String> GROUPS = new HashMap<String, String>() {{
	    put("PRUEBA", "PRUEBA_BANDEJA");
	}};
	
	public static String conversor(String search) {
		return GROUPS.get(search);
	}
	public static void main(String[] args) {
		System.out.println("retorno: " + conversor("DMN_GST_HMN_FUNCIONARIO_CAF"));
	}
}