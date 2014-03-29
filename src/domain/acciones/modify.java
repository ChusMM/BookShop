package domain.acciones;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;
import domain.identification.*;
import domain.exceptions.*;

public class modify {
	
	private String old_pass;
	private String new_pass;
	private String new_pass2;
	private String nombre;
	private String ap1;
	private String ap2;
	private String direccion;
	private String telefono;
	private String correo;
	private String cp;
	private String pais;
	private String fecha;
	private Cliente cli, c;
	
	public String execute(){
		try{
			c = (Cliente)ActionContext.getContext().getSession().get("cliente");
			if(old_pass.compareTo(c.getPass()) == 0){
				if (new_pass.compareTo(new_pass2) == 0){
					if(new_pass.isEmpty() || nombre.isEmpty() || ap1.isEmpty() || ap2.isEmpty() || direccion.isEmpty() ||
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
							cli = new Cliente(c.getLogin(), new_pass, nombre, ap1, ap2, direccion, telefono, correo, false, cp, pais, fecha);
							Cliente.update(cli);
							return "Success";
						}
					}
				}else
					return "ContraseñasDiferentes";
			}else{
				return "ContrasenaIncorrecta";
			}
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
			
	public void setOld_pass(String newOld_pass){
		old_pass = newOld_pass;
	}
	public void setNew_pass(String newNew_pass){
		new_pass = newNew_pass;
	}
	public void setNew_pass2(String newNew_pass2){
		new_pass2 = newNew_pass2;
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
