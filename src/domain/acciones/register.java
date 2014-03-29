package domain.acciones;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import domain.identification.*;
import domain.exceptions.*;

public class register{
	
	private String login;
	private String password;
	private String password2;
	private String nombre;
	private String ap1;
	private String ap2;
	private String direccion;
	private String telefono;
	private String correo;
	private String cp;
	private String pais;
	private String fecha;
	private Cliente cli;
	
	public String execute(){
		try{
			if (password.compareTo(password2) == 0){
					if(login.isEmpty() || password.isEmpty() || nombre.isEmpty() || ap1.isEmpty() || ap2.isEmpty() || direccion.isEmpty() || 
							telefono.isEmpty() || correo.isEmpty() || cp.isEmpty() || pais.isEmpty() || fecha.isEmpty()) {
						return "FaltanDatos";
					}
					else {
						if(!comprobarTelefono(telefono)) 
							return "FaltanDatos";
						if(!isEmail(correo))
							return "FaltanDatos";
						if (!comprobarCP(cp))
							return "FaltanDatos";
						if(!isDate(fecha))
							return "FaltanDatos";
						
						else {
							cli = new Cliente(login, password, nombre, ap1, ap2, direccion, telefono, correo, false, cp, pais, fecha);
							cli.insert();
							return "Success";
						}
					}
			}else
				return "ContraseñasDiferentes";
		}catch (NoAvailableConnections e){
			return "NoHayConexionesLibres";
		}catch(ClassNotFoundException e){
			return "ClaseNoEncontrada";
		}catch(InstantiationException e){
			return "InstantiationException";
		}catch(IllegalAccessException e){
			return "AccesoIlegal";
		}catch(SQLException e){
			return "ExcepcionSQL";
		}catch(ClienteExistente e){
			return "ClienteExistente";
		}catch(InvalidUserException e){
			return "UsuarioNoValido";
		}
		
	}
	
	//métodos que comprueban:
	public boolean comprobarTelefono(String telNum) {
		boolean correcto = true;
		if(telNum.length() != 9) {
			correcto = false;
		}
		else {
			for(int i=0; i<9; i++) {
				if(!Character.isDigit(telNum.charAt(i)))
					correcto = false;
			}
		}
		return correcto;
	}
	
	public boolean comprobarCP(String codigoP) {
		boolean correcto = true;
		if(codigoP.length() != 5) {
			correcto = false;
		}
		else {
			for(int i=0; i<5; i++) {
				if(!Character.isDigit(codigoP.charAt(i)))
					correcto = false;
			}
		}
		return correcto;
	}
	
	public boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }
	
	//fin metodos que comprueban
	
	
	public void setLogin(String newLogin){
		login = newLogin;
	}

	public void setPassword(String newPassword){
		password = newPassword;
	}
	public void setPassword2(String newPassword2){
		password2 = newPassword2;
	}
	public void setNombre(String newNombre){
		nombre = newNombre;
	}
	public void setAp1(String newAp1){
		ap1 = newAp1;
	}
	public void setAp2(String newAp2){
		ap2 = newAp2;
	}
	public void setDireccion(String newDireccion){
		direccion = newDireccion;
	}
	public void setTelefono(String newTelefono){
		telefono = newTelefono;
	}
	public void setCorreo(String newCorreo){
		correo = newCorreo;
	}
	public void setCp(String newCp){
		cp = newCp;
	}
	public void setPais(String newPais){
		pais = newPais;
	}
	public void setFecha(String newFecha){
		fecha = newFecha;
	}
}
