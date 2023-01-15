import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Ventana {

	private JFrame frame;
	private JTextField nombreField;
	private JTextField matricula;
	private JTextArea ruta;
	JScrollPane scrollPane;
	private final String url = "jdbc:mysql://localhost:3306/Universidad";
	private final String usr = "root";
	private final String pass = "";
	Clip sonido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(117, 43, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula:");
		lblNewLabel_1.setBounds(117, 85, 61, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		nombreField = new JTextField();
		nombreField.setBounds(190, 40, 86, 20);
		frame.getContentPane().add(nombreField);
		nombreField.setColumns(10);
		
		matricula = new JTextField();
		matricula.setBounds(190, 82, 86, 20);
		frame.getContentPane().add(matricula);
		matricula.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarAudio();
				String nombre = nombreField.getText();
				String sql = "insert into alumnos(Nombre) values('" + nombre + "')";
				
				try (Connection conn =
						DriverManager.getConnection(url, usr, pass);
						PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.executeUpdate();
					loggear("Agregado", nombre);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(28, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarAudio();
				int id = Integer.parseInt(matricula.getText());
				String sql = "Select Nombre from alumnos where Matricula=" + id;
				
				try (Connection conn =
						DriverManager.getConnection(url, usr, pass);
						PreparedStatement ps = conn.prepareStatement(sql)) {
					try (ResultSet rs = ps.executeQuery()) {
						if (rs.next() == true) {
							nombreField.setText(rs.getString("Nombre"));
						}
						else {
							nombreField.setText("No encontrado");
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(190, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarAudio();
				int id = Integer.parseInt(matricula.getText());
				String sql = "Delete from alumnos where Matricula=" + id;
				
				try (Connection conn =
						DriverManager.getConnection(url, usr, pass);
						PreparedStatement ps = conn.prepareStatement(sql)) {
					int update = ps.executeUpdate();
					if (update == 0) {
						nombreField.setText("No encontrado");
						loggear("Borrado", "id-" + Integer.toString(id));
					} else {
						nombreField.setText("Borrado");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(335, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Borrar todo");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarAudio();
				String sql = "TRUNCATE TABLE alumnos";
				
				try (Connection conn =
						DriverManager.getConnection(url, usr, pass);
						PreparedStatement ps = conn.prepareStatement(sql)) {
					ps.executeUpdate();
					nombreField.setText("Registros borrados");
					loggear("Borrado", "todo el registro");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(311, 216, 113, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Leer archivo");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarAudio();
				leer();
			}
		});
		btnNewButton_4.setBounds(28, 216, 122, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("Ruta:");
		lblNewLabel_2.setBounds(28, 134, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 110, 307, 56);
		frame.getContentPane().add(scrollPane);
		
		ruta = new JTextArea();
		scrollPane.setViewportView(ruta);
		
		JButton btnNewButton_5 = new JButton("Limpiar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta.setText("");
				nombreField.setText("");
				matricula.setText("");
			}
		});
		btnNewButton_5.setBounds(187, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
	}
	
	public void ejecutarAudio() {
		try {
			sonido = AudioSystem.getClip();
			File archivo = new File("audio.wav");
			sonido.open(AudioSystem.getAudioInputStream(archivo));
			sonido.start();
			Thread.sleep(1000);
			sonido.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loggear(String accion, String alumno) {
		String cuPath = System.getProperty("user.dir");
		String logPath = cuPath + "\\log.txt";
		
		try (PrintWriter escribir =
				new PrintWriter(new BufferedWriter(new FileWriter(logPath, true)));)
		{
			escribir.println(accion + ": " + alumno + " - Fecha: "  + LocalDateTime.now());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leer() {
		String path = ruta.getText();
		if (path.isEmpty()) {
			ruta.setText("La ruta no puede estar vacia");
		} else {
			File archivo = new File(path);
			if (!archivo.isFile()) {
				ruta.setText("Archivo invalido");
			} else {
				try (BufferedReader reader = new BufferedReader(new FileReader(archivo));) {
					StringBuffer buffer = new StringBuffer();
					String line;
					while((line = reader.readLine()) != null) {
						buffer.append(line + "\n");
					}
					ruta.setText(buffer.toString());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
